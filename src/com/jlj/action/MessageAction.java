package com.jlj.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jlj.model.Bigtype;
import com.jlj.model.Message;
import com.jlj.model.Pubclient;
import com.jlj.service.IBigtypeService;
import com.jlj.service.IMessageService;
import com.jlj.service.IPubclientService;
import com.jlj.util.DateTimeConvertor;
import com.jlj.util.DateTimeKit;
import com.jlj.util.IPUtil;
import com.opensymphony.xwork2.ActionSupport;

@Component("messageAction")
@Scope("prototype")
public class MessageAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private IMessageService messageService;
	private IPubclientService pubclientService;
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//单个对象
	private int id;
	private Message message;
	//分页显示
	private String[] arg=new String[2];
	private List<Message> messages;
	private int page;
	private final int size=10;
	private int pageCount;
	private int totalCount;
	private int status;//按状态
	private int pid;//按用户id
	private String publicaccount;//公众号原始ID
	//条件
	private int con;
	private String convalue;
	
	private String frontpa;
	public String frontMessages(){
		messages = messageService.getFrontMessagesByPublicAccount(frontpa);
		request.put("messages", messages);
//		//查询该frontpa所用的模板信息
//		Pubclient pubclient = pubclientService.queryPubclientByFrontpa(frontpa);
//		int template = pubclient.getTemplate();
//		session.put("template", template);
		return NONE;
	}
	//=========后台首页类别=================================================
	/**
	 * 首页类别管理
	 */
	public String list() throws Exception{
		
		if(convalue!=null&&!convalue.equals("")){
			convalue=URLDecoder.decode(convalue, "utf-8");
		}
		if(page<1){
			page=1;
		}
		//总页数
		pageCount=messageService.getPageCount(con,convalue,size);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		messages=messageService.queryList(con,convalue,page,size);
		//总记录数
		totalCount=messageService.getTotalCount(con,convalue);
		return "list";
	}
	/**
	 * 跳转到添加页面
	 * @return
	 */
	public String goToAdd(){
		return "add";
	}
	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	
	public String add() throws Exception{
		
		messageService.add(message);
		
		arg[0]="messageAction!list";
		arg[1]="留言管理";
		return SUCCESS;
	}
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		/*Pubclient pubclient = (Pubclient)session.get("pubclient");
		if(pubclient==null){
			String errorInfo="会话失效，请重新登录";
			request.put("errorInfo", errorInfo);
			return "operror";
		}
		String paccount=pubclient.getPublicaccount();*/
		message=messageService.loadById(id);
		messageService.delete(message);
		
		arg[0]="messageAction!list";
		arg[1]="留言管理";
		return SUCCESS;
	}
	/**
	 * 修改
	 * @return
	 */
	public String update() throws Exception{
		messageService.update(message);
		arg[0]="messageAction!list";
		arg[1]="留言管理";
		return SUCCESS;
	}
	/**
	 * 查看信息
	 * @return
	 */
	public String view(){
		message=messageService.loadById(id);
		return "view";
	}
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String load() throws Exception{
		message=messageService.loadById(id);
		return "load";
	}
	
	//上传照片
	private File picture;
	private String pictureContentType;
	private String pictureFileName;
	//文件上传
	public void upload(String imageName) throws Exception{
		String floderName=((Pubclient)session.get("pubclient")).getPublicaccount();
		File saved=new File(ServletActionContext.getServletContext().getRealPath(floderName),imageName);
		InputStream ins=null;
		OutputStream ous=null;
		try {
			saved.getParentFile().mkdirs();
			ins=new FileInputStream(picture);
			ous=new FileOutputStream(saved);
			byte[] b=new byte[1024];
			int len = 0;
			while((len=ins.read(b))!=-1){
				ous.write(b,0,len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(ous!=null)
				ous.close();
			if(ins!=null) 
				ins.close();
		}
	}
	
	/**
	 * 前台
	 * @return
	 */
	public String listMessageFront()
	{
		
		messages = messageService.getFrontMessages();
		
		return "frontlist";
	}
	
	
	private String messagecontent;
	private String name;
	public String addMessageFront() throws Exception
	{
		
		String ip = IPUtil.getIpAddr(req);//获得留言端IP地址
		if(checkMessageip(ip))
		{
			Message message = new Message();
			message.setMessagecontent(messagecontent);
			message.setMessageip(ip);
			message.setName(name);
			message.setMessagestate(0);//设置留言是否审核 0:未审核 1:已审核
			message.setIsshow(0);//设置留言页面是否显示为 0:不显示 1:显示
			message.setMessagetime(DateTimeKit.getLocalTime());
			
			messageService.add(message);
			
			return "liuyanaddsuccess";
		}else
		{
			return "liuyanadderror";
		}
		
	}
	
	/*
	 * 检查是否改IP的用户今天已经发过言
	 */
	
	private boolean checkMessageip(String ip)
	{
		String localday = DateTimeKit.getLocalDay();
		
		messages = messageService.getMessagesByIPAndDay(ip,localday);
		
		if(messages!=null&&messages.size()>0)
		{
			return false;
		}else
		{
			return true;
		}
		
	}
	
	//get、set-------------------------------------------
	public IMessageService getMessageService() {
		return messageService;
	}
	@Resource
	public void setMessageService(IMessageService messageService) {
		this.messageService = messageService;
	}
	// 获得HttpServletResponse对象
    public void setServletResponse(HttpServletResponse response)
    {
        this.response = response;
    }    
    public void setServletRequest(HttpServletRequest req) {
		this.req = req;
	}
    public Map<String, Object> getRequest() {
		return request;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void setMessage(Message message) {
		this.message = message;
	}
	
	public Message getMessage() {
		return message;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCon() {
		return con;
	}
	public void setCon(int con) {
		this.con = con;
	}
	public String getConvalue() {
		return convalue;
	}
	public void setConvalue(String convalue) {
		this.convalue = convalue;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String[] getArg() {
		return arg;
	}
	public void setArg(String[] arg) {
		this.arg = arg;
	}
	public String getPublicaccount() {
		return publicaccount;
	}
	public void setPublicaccount(String publicaccount) {
		this.publicaccount = publicaccount;
	}
	public File getPicture() {
		return picture;
	}
	public void setPicture(File picture) {
		this.picture = picture;
	}
	public String getPictureContentType() {
		return pictureContentType;
	}
	public void setPictureContentType(String pictureContentType) {
		this.pictureContentType = pictureContentType;
	}
	public String getPictureFileName() {
		return pictureFileName;
	}
	public void setPictureFileName(String pictureFileName) {
		this.pictureFileName = pictureFileName;
	}

	public String getFrontpa() {
		return frontpa;
	}

	public void setFrontpa(String frontpa) {
		this.frontpa = frontpa;
	}

	public IPubclientService getPubclientService() {
		return pubclientService;
	}

	@Resource
	public void setPubclientService(IPubclientService pubclientService) {
		this.pubclientService = pubclientService;
	}
	public String getMessagecontent() {
		return messagecontent;
	}
	public void setMessagecontent(String messagecontent) {
		this.messagecontent = messagecontent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
