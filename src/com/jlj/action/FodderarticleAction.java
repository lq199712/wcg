package com.jlj.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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
import com.jlj.model.Fodderarticle;
import com.jlj.model.Pubclient;
import com.jlj.service.IFodderService;
import com.jlj.service.IFodderarticleService;
import com.jlj.util.DateTimeKit;
import com.opensymphony.xwork2.ActionSupport;

@Component("fodderarticleAction")
@Scope("prototype")
public class FodderarticleAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private IFodderarticleService fodderarticleService;
	private IFodderService fodderService;
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//单个对象
	private int id;
	private Fodderarticle fodderarticle;
	//分页显示
	private String[] arg=new String[2];
	private List<Fodderarticle> fodderarticles;
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
	 * 子图文管理
	 */
	private int fodderid;//获取该ID下的list
	private Fodder fodder;//在子图文页面中显示他的标题等信息
	public String list() throws Exception{
		//所有记录对象
		fodderarticles=fodderarticleService.queryFodderarticlesByFodderid(fodderid);
		fodder=fodderService.loadById(fodderid);
		return "list";
	}
	/**
	 * 跳转到添加页面
	 * @return
	 */
	public String goToAdd(){
		fodder = fodderService.loadById(fodderid);
		return "add";
	}
	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	
	public String add() throws Exception{
		Pubclient pubclient = (Pubclient)session.get("pubclient");
		if(pubclient==null){
			String errorInfo="会话失效，请重新登录";
			request.put("errorInfo", errorInfo);
			return "operror";
		}
		String paccount=pubclient.getPublicaccount();
		
		if(picture!=null){
			String imageName=DateTimeKit.getDateRandom()+pictureFileName.substring(pictureFileName.indexOf("."));
			this.upload(imageName);
			fodderarticle.setPicurl(paccount+"/"+imageName);
			
		}
		
		fodderarticleService.add(fodderarticle);
		//修改图文数量+1
		Fodder fodderup=fodderService.loadById(fodderid);
		int newarticlecount = fodderup.getArticlecount()+1;
		//判断新的图文数量是否大于8
		if(newarticlecount>8){
			String errorInfo="子图文数量不能超过8个";
			request.put("errorInfo", errorInfo);
			return "operror";
		}
		
		fodderService.updateArticleCount(newarticlecount,fodderid);
		arg[0]="fodderarticleAction!list?fodderid="+fodderid;
		arg[1]="子图文管理";
		return SUCCESS;
	}
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		Fodderarticle fodderarticle=fodderarticleService.loadById(id);
		//删除图片
		File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+fodderarticle.getPicurl());
		photofile.delete();
		fodderarticleService.delete(fodderarticle);
		//修改图文数量-1
		Fodder fodderup=fodderService.loadById(fodderid);
		fodderService.updateArticleCount(fodderup.getArticlecount()-1,fodderid);
		
		arg[0]="fodderarticleAction!list?fodderid="+fodderid;
		arg[1]="子图文管理";
		return SUCCESS;
	}
	/**
	 * 修改
	 * @return
	 */
	public String update() throws Exception{
		Pubclient pubclient = (Pubclient)session.get("pubclient");
		if(pubclient==null){
			String errorInfo="会话失效，请重新登录";
			request.put("errorInfo", errorInfo);
			return "operror";
		}
		String paccount=pubclient.getPublicaccount();
		
		if(picture!=null){
			String imageName=DateTimeKit.getDateRandom()+pictureFileName.substring(pictureFileName.indexOf("."));
			this.upload(imageName);
			File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+fodderarticle.getPicurl());
			photofile.delete();
			fodderarticle.setPicurl(paccount+"/"+imageName);
			
		}
		fodderarticleService.update(fodderarticle);
		arg[0]="fodderarticleAction!list?fodderid="+fodderid;
		arg[1]="子图文管理";
		return SUCCESS;
	}
	/**
	 * 查看信息
	 * @return
	 */
	public String view(){
		fodderarticle=fodderarticleService.loadById(id);
		fodder = fodderService.loadById(fodderid);
		return "view";
	}
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String load() throws Exception{
		fodderarticle=fodderarticleService.loadById(id);
		fodder = fodderService.loadById(fodderid);
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
	public IFodderarticleService getFodderarticleService() {
		return fodderarticleService;
	}
	@Resource
	public void setFodderarticleService(IFodderarticleService fodderarticleService) {
		this.fodderarticleService = fodderarticleService;
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
	
	public void setFodderarticle(Fodderarticle fodderarticle) {
		this.fodderarticle = fodderarticle;
	}
	
	public Fodderarticle getFodderarticle() {
		return fodderarticle;
	}
	public List<Fodderarticle> getFodderarticles() {
		return fodderarticles;
	}
	public void setFodderarticles(List<Fodderarticle> fodderarticles) {
		this.fodderarticles = fodderarticles;
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
	public int getFodderid() {
		return fodderid;
	}
	public void setFodderid(int fodderid) {
		this.fodderid = fodderid;
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
