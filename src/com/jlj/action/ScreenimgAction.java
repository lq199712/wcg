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

import com.jlj.model.Pubclient;
import com.jlj.model.Screenimg;
import com.jlj.service.IScreenimgService;
import com.jlj.util.DateTimeKit;
import com.opensymphony.xwork2.ActionSupport;

@Component("screenimgAction")
@Scope("prototype")
public class ScreenimgAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private IScreenimgService screenimgService;
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//单个对象
	private int id;
	private Screenimg screenimg;
	//分页显示
	private String[] arg=new String[2];
	private List<Screenimg> screenimgs;
	private String publicaccount;//公众号原始ID
	private int imgtype;
	/**
	 * 前台-获取某种类型、某个公众账号的图片列表
	 * @return
	 */
	public String frontimglist(){
		screenimgs = screenimgService.getScreenimgsByCondition(imgtype,publicaccount);
		request.put("screenimgs", screenimgs);
		return null;
	}
	
	/**
	 * 全屏轮播管理
	 * @return
	 */
	public String imglist(){
		screenimgs = screenimgService.getScreenimgsByPublicaccount(publicaccount);
		return "imglist";
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
			screenimg.setImageurl(paccount+"/"+imageName);
			
		}
		screenimgService.add(screenimg);
		
		arg[0]="screenimgAction!imglist?publicaccount="+paccount;
		arg[1]="全屏轮播图片";
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
		Screenimg screenimg=screenimgService.loadById(id);
		//删除图片
		File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+screenimg.getImageurl());
		photofile.delete();
		screenimgService.delete(screenimg);
		
		arg[0]="screenimgAction!imglist?publicaccount="+paccount;
		arg[1]="全屏轮播图片";
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
		String imageName=DateTimeKit.getDateRandom()+pictureFileName.substring(pictureFileName.indexOf("."));
		if(picture!=null){
			this.upload(imageName);
			File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+screenimg.getImageurl());
			photofile.delete();
			screenimg.setImageurl(paccount+"/"+imageName);
			
		}
		screenimgService.update(screenimg);
		arg[0]="screenimgAction!imglist?publicaccount="+paccount;
		arg[1]="全屏轮播图片";
		return SUCCESS;
	}
	/**
	 * 查看信息
	 * @return
	 */
	public String view(){
		screenimg=screenimgService.loadById(id);
		return "view";
	}
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String load() throws Exception{
		screenimg=screenimgService.loadById(id);
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
	public IScreenimgService getScreenimgService() {
		return screenimgService;
	}
	@Resource
	public void setScreenimgService(IScreenimgService screenimgService) {
		this.screenimgService = screenimgService;
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
	
	public void setScreenimg(Screenimg screenimg) {
		this.screenimg = screenimg;
	}
	
	public Screenimg getScreenimg() {
		return screenimg;
	}
	public List<Screenimg> getScreenimgs() {
		return screenimgs;
	}
	public void setScreenimgs(List<Screenimg> screenimgs) {
		this.screenimgs = screenimgs;
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

	public int getImgtype() {
		return imgtype;
	}

	public void setImgtype(int imgtype) {
		this.imgtype = imgtype;
	}
	
	
}
