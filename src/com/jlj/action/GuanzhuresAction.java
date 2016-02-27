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

import com.jlj.model.Fodder;
import com.jlj.model.Guanzhures;
import com.jlj.model.Pubclient;
import com.jlj.service.IFodderService;
import com.jlj.service.IGuanzhuresService;
import com.jlj.util.DateTimeKit;
import com.opensymphony.xwork2.ActionSupport;

@Component("guanzhuresAction")
@Scope("prototype")
public class GuanzhuresAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private IGuanzhuresService guanzhuresService;
	private IFodderService fodderService;
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//单个对象
	private int id;
	private Guanzhures guanzhures;
	//分页显示
	private String[] arg=new String[2];
	private List<Guanzhures> guanzhuress;
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
	
	
	/**
	 * 素材管理
	 */
	public String list() throws Exception{
		if(convalue!=null&&!convalue.equals("")){
			convalue=URLDecoder.decode(convalue, "utf-8");
		}
		if(page<1){
			page=1;
		}
		//总页数
		pageCount=guanzhuresService.getPageCount(con,convalue,status,publicaccount,size);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		guanzhuress=guanzhuresService.queryList(con,convalue,status,publicaccount,page,size);
		//总记录数
		totalCount=guanzhuresService.getTotalCount(con,convalue,status,publicaccount);
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
		String paccount=guanzhures.getPublicaccount();
		guanzhuresService.add(guanzhures);
		
		arg[0]="guanzhuresAction!view?publicaccount="+paccount;
		arg[1]="我的素材";
		return SUCCESS;
	}
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		Pubclient pubclient = (Pubclient)session.get("pubclient");
		if(pubclient==null){
			String errorInfo="会话失效，请重新登录";
			request.put("errorInfo", errorInfo);
			return "operror";
		}
		String paccount=pubclient.getPublicaccount();
		Guanzhures guanzhures=guanzhuresService.loadById(id);
		guanzhuresService.delete(guanzhures);
		
		arg[0]="guanzhuresAction!list?publicaccount="+paccount;
		arg[1]="素材管理";
		return SUCCESS;
	}
	/**
	 * 修改
	 * @return
	 */
	public String update() throws Exception{
		String paccount=guanzhures.getPublicaccount();
		guanzhuresService.update(guanzhures);
		arg[0]="guanzhuresAction!view?publicaccount="+paccount;
		arg[1]="我的素材";
		return SUCCESS;
	}
	/**
	 * 查看信息
	 * @return
	 */
	private Fodder fodder;
	public String view(){
		//若客户第一次浏览该页，首先进入添加关注回复页面;否则，直接进入查看页面
		List<Guanzhures> guanzhureslist= guanzhuresService.queryListByPublicAccount(publicaccount);
		if(guanzhureslist.size()>0){
			guanzhures=guanzhureslist.get(0);
			
			if(guanzhures!=null){
				fodder=fodderService.loadById(guanzhures.getFodderid());
				return "view";
			}else{
				String errorInfo="会话失效了，请重新登录";
				request.put("errorInfo", errorInfo);
				return "operror";
			}
			
			
		}else{
			session.put("sucainame", "");
			session.put("fodderid", "");
			return this.goToAdd();
		}
		
	}
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String load() throws Exception{
		guanzhures=guanzhuresService.loadById(id);
		int fodderid=guanzhures.getFodderid();
		fodder = fodderService.loadById(fodderid);
		session.put("sucainame", fodder.getTitle());
		session.put("fodderid", fodderid);
		session.put("guanzhures", guanzhures);
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
	
	//get、set-------------------------------------------
	public IGuanzhuresService getGuanzhuresService() {
		return guanzhuresService;
	}
	@Resource
	public void setGuanzhuresService(IGuanzhuresService guanzhuresService) {
		this.guanzhuresService = guanzhuresService;
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
	
	public void setGuanzhures(Guanzhures guanzhures) {
		this.guanzhures = guanzhures;
	}
	
	public Guanzhures getGuanzhures() {
		return guanzhures;
	}
	public List<Guanzhures> getGuanzhuress() {
		return guanzhuress;
	}
	public void setGuanzhuress(List<Guanzhures> guanzhuress) {
		this.guanzhuress = guanzhuress;
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
	public IFodderService getFodderService() {
		return fodderService;
	}
	@Resource
	public void setFodderService(IFodderService fodderService) {
		this.fodderService = fodderService;
	}
	public Fodder getFodder() {
		return fodder;
	}
	public void setFodder(Fodder fodder) {
		this.fodder = fodder;
	}
	
	
}
