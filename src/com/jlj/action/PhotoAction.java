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

import com.jlj.model.Photo;
import com.jlj.model.Phototype;
import com.jlj.model.Pubclient;
import com.jlj.service.IPhotoService;
import com.jlj.service.IPhototypeService;
import com.jlj.service.IPubclientService;
import com.jlj.util.DateTimeKit;
import com.opensymphony.xwork2.ActionSupport;

@Component("photoAction")
@Scope("prototype")
public class PhotoAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private IPhotoService photoService;
	private IPubclientService pubclientService;
	
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//单个对象
	private int id;
	private Photo photo;
	//分页显示
	private String[] arg=new String[2];
	private List<Photo> photos;
	private String publicaccount;//公众号原始ID
	private String template;
	
	public String imglist(){
		photos = photoService.getPhotosByPublicaccount(publicaccount);
		return "imglist";
	}
	
	//前台显示翻页相册
	private String frontpa;
	public String frontphoto(){
		photos = photoService.getPhotosByPublicaccount(frontpa);
		//模板
		int temp=0;
		if(session.get("template")!=null){
			temp = (Integer)session.get("template");
		}else{
			Pubclient pubclient = pubclientService.queryPubclientByFrontpa(frontpa);
			temp = pubclient.getTemplate();
			session.put("template",temp);
		}
		template="template"+temp;
		return "frontphoto";
	}
	
	/**
	 * 跳转到添加页面
	 * @return
	 */
	private IPhototypeService phototypeService;
	private List<Phototype> phototypes;
	public String goToAdd(){
		Pubclient pubclient = (Pubclient)session.get("pubclient");
		if(pubclient==null){
			String errorInfo="会话失效，请重新登录";
			request.put("errorInfo", errorInfo);
			return "operror";
		}
		String paccount=pubclient.getPublicaccount();
		phototypes = phototypeService.getPhototypesByPublicAccount(paccount);
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
			photo.setPhotourl(paccount+"/"+imageName);
			
		}
		photoService.add(photo);
		
		arg[0]="photoAction!imglist?publicaccount="+paccount;
		arg[1]="照片管理";
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
		Photo photo=photoService.loadById(id);
		//删除图片
		File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+photo.getPhotourl());
		photofile.delete();
		
		photoService.delete(photo);
		
		arg[0]="photoAction!imglist?publicaccount="+paccount;
		arg[1]="照片管理";
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
			File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+photo.getPhotourl());
			photofile.delete();
			
			photo.setPhotourl(paccount+"/"+imageName);
			
		}
		photoService.update(photo);
		arg[0]="photoAction!imglist?publicaccount="+paccount;
		arg[1]="照片管理";
		return SUCCESS;
	}
	/**
	 * 查看信息
	 * @return
	 */
	public String view(){
		photo=photoService.loadById(id);
		return "view";
	}
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String load() throws Exception{
		Pubclient pubclient = (Pubclient)session.get("pubclient");
		if(pubclient==null){
			String errorInfo="会话失效，请重新登录";
			request.put("errorInfo", errorInfo);
			return "operror";
		}
		String paccount=pubclient.getPublicaccount();
		phototypes = phototypeService.getPhototypesByPublicAccount(paccount);
		photo=photoService.loadById(id);
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
	public IPhotoService getPhotoService() {
		return photoService;
	}
	@Resource
	public void setPhotoService(IPhotoService photoService) {
		this.photoService = photoService;
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
	
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
	
	public Photo getPhoto() {
		return photo;
	}
	public List<Photo> getPhotos() {
		return photos;
	}
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
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
	public IPhototypeService getPhototypeService() {
		return phototypeService;
	}
	@Resource
	public void setPhototypeService(IPhototypeService phototypeService) {
		this.phototypeService = phototypeService;
	}
	public List<Phototype> getPhototypes() {
		return phototypes;
	}
	public void setPhototypes(List<Phototype> phototypes) {
		this.phototypes = phototypes;
	}
	public String getFrontpa() {
		return frontpa;
	}
	public void setFrontpa(String frontpa) {
		this.frontpa = frontpa;
	}
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	public IPubclientService getPubclientService() {
		return pubclientService;
	}
	@Resource
	public void setPubclientService(IPubclientService pubclientService) {
		this.pubclientService = pubclientService;
	}
	
	
	
}
