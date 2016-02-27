package com.jlj.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
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
import com.jlj.model.Complaint;
import com.jlj.model.Pubclient;
import com.jlj.service.IBigtypeService;
import com.jlj.service.IComplaintService;
import com.jlj.service.IPubclientService;
import com.jlj.util.DateTimeKit;
import com.jlj.util.IPUtil;
import com.opensymphony.xwork2.ActionSupport;

@Component("complaintAction")
@Scope("prototype")
public class ComplaintAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private IComplaintService complaintService;
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//单个对象
	private int id;
	private Complaint complaint;
	//分页显示
	private String[] arg=new String[2];
	private List<Complaint> complaints;
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
		pageCount=complaintService.getPageCount(con,convalue,size);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		complaints=complaintService.queryList(con,convalue,page,size);
		//总记录数
		totalCount=complaintService.getTotalCount(con,convalue);
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
		if(picture!=null){
			String imageName=DateTimeKit.getDateRandom()+pictureFileName.substring(pictureFileName.indexOf("."));
			this.upload(imageName);
			complaint.setImage("/"+imageName);
			
		}
		complaint.setCompstate(0);//新增默认投诉状态为 0：未办理 1：办理中 2：已办理
		complaint.setComptime(DateTimeKit.getLocalTime());
		complaintService.add(complaint);
		arg[0]="complaintAction!list";
		arg[1]="投诉管理";
		return SUCCESS;
	}
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		Complaint complaint=complaintService.loadById(id);
		//删除图片
		if(complaint.getImage()!=null)
		{
			File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+"complaintimage/"+complaint.getImage());
			photofile.delete();
		}
		complaintService.delete(complaint);
		
		arg[0]="complaintAction!list";
		arg[1]="投诉管理";
		return SUCCESS;
	}
	/**
	 * 修改
	 * @return
	 */
	public String update() throws Exception{
		return SUCCESS;
	}
	/**
	 * 查看信息
	 * @return
	 */
	public String view(){
		complaint=complaintService.loadById(id);
		return "view";
	}
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String load() throws Exception{
		return "load";
	}
	/**
	 * 跳转到投诉查询
	 */
	public String toQuery()
	{
		return "query";
	}
	
	/**
	 * 投诉查询
	 */
	private String comptime;
	public String query()
	{
		complaints = complaintService.queryList(comptype,comptime,name);
		return "query_result";
	}
	
	/**
	 * 修改状态
	 */
	private int compstate;
	public String changeState()
	{
		complaint=complaintService.loadById(id);
		complaint.setCompstate(compstate);
		complaintService.update(complaint);
		return null;
	}
	
	
	/**
	 * front 前台添加
	 */
	
	public String goToComplaint()
	{
		return "complaint";
	}
	
	//上传照片
	private File picture;
	private String pictureContentType;
	private String pictureFileName;
	//文件上传
	public void upload(String imageName) throws Exception{
		File saved=new File(ServletActionContext.getServletContext().getRealPath("complaintimage"),imageName);
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
	
	
	public String addFront() throws Exception
	{
		
		String ip = IPUtil.getIpAddr(req);//获得IP地址
		if(checkComplaint(ip))//判断是否已经投诉并且还未处理
		{
			return "liuyanagain";
		}else
		{
			/*
			 * 获得当前微信用户的openid 暂无
			 */
			if(picture!=null){
				String imageName=DateTimeKit.getDateRandom()+pictureFileName.substring(pictureFileName.indexOf("."));
				this.upload(imageName);
				complaint.setImage("/"+imageName);
				
			}
			complaint.setIp(ip);
			complaint.setCompstate(0);//新增默认投诉状态为 0：未办理 1：办理中 2：已办理
			complaint.setComptime(DateTimeKit.getLocalTime());
			complaintService.add(complaint);
			return "front_addsuccess";
		}
		
	}
	
	/*
	 * 检查投诉是否已经受理 
	 */
	private boolean checkComplaint(String ip) {
		// TODO Auto-generated method stub
		
		complaints = complaintService.queryList(ip);
		
		if(complaints==null)
		{
			return false;
		}else
		{
			if(complaints.size()>0)
			{
				for (Complaint complaint : complaints) {
					if(complaint.getCompstate()!=2)
					{
						return true;
					}
				}
			}else
			{
				return false;
			}
		}
		return false;
	}

	private String name;
	private String telphone;
	private int comptype;
	private String content;
	public String addComplaint() throws Exception
	{
		System.out.println("addComplaint");
		if(name!=null&&!name.equals("")){
			name=URLDecoder.decode(name, "utf-8");
		}
		if(telphone!=null&&!telphone.equals("")){
			telphone=URLDecoder.decode(telphone, "utf-8");
		}
		if(content!=null&&!content.equals("")){
			content=URLDecoder.decode(content, "utf-8");
		}
		Complaint complaint = new Complaint();
		
		if(picture!=null){
			String imageName=DateTimeKit.getDateRandom()+pictureFileName.substring(pictureFileName.indexOf("."));
			System.out.println(imageName);
			this.upload(imageName);
			File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+"complaintimage/"+complaint.getImage());
			photofile.delete();
			complaint.setImage("/"+imageName);
		}
		
		
		complaint.setCompstate(0);
		complaint.setComptime(DateTimeKit.getLocalTime());
		complaint.setComptype(comptype);
		complaint.setContent(content);
		complaint.setName(name);
		complaint.setTelphone(telphone);
		complaintService.add(complaint);
		return "front_addsuccess";
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

	public IComplaintService getComplaintService() {
		return complaintService;
	}
	@Resource
	public void setComplaintService(IComplaintService complaintService) {
		this.complaintService = complaintService;
	}
	public Complaint getComplaint() {
		return complaint;
	}
	public void setComplaint(Complaint complaint) {
		this.complaint = complaint;
	}
	public List<Complaint> getComplaints() {
		return complaints;
	}
	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public int getComptype() {
		return comptype;
	}
	public void setComptype(int comptype) {
		this.comptype = comptype;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getComptime() {
		return comptime;
	}
	public void setComptime(String comptime) {
		this.comptime = comptime;
	}
	public int getCompstate() {
		return compstate;
	}
	public void setCompstate(int compstate) {
		this.compstate = compstate;
	}
	
	
	
	
}
