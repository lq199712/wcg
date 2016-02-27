package com.jlj.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.Date;
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

@Component("fodderAction")
@Scope("prototype")
public class FodderAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private IFodderService fodderService;
	private IFodderarticleService fodderarticleService;
	
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//单个对象
	private int id;
	private Fodder fodder;
	//分页显示
	private String[] arg=new String[2];
	private List<Fodder> fodders;
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
		pageCount=fodderService.getPageCount(con,convalue,status,publicaccount,size);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		fodders=fodderService.queryList(con,convalue,status,publicaccount,page,size);
		//总记录数
		totalCount=fodderService.getTotalCount(con,convalue,status,publicaccount);
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
	private String musicdes;
	private String newsdes;
	public String add() throws Exception{
		String paccount=fodder.getPublicaccount();
		//保存图片以及图片链接
		
		if(picture!=null){
			String imageName=DateTimeKit.getDateRandom()+pictureFileName.substring(pictureFileName.indexOf("."));
			this.upload(imageName);
			fodder.setPicurl(paccount+"/"+imageName);
			
		}
		//保存正文描述
		if(newsdes!=null&&!newsdes.equals("")){
			fodder.setDescription(newsdes);
		}else if(musicdes!=null&&!musicdes.equals("")){
			fodder.setDescription(musicdes);
		}
		//保存素材类型
		int savetype= fodder.getSavetype();
		if(savetype==1){
			fodder.setMsgtype("text");
		}else if(savetype==5){
			fodder.setMsgtype("music");
		}else if(savetype==6){
			fodder.setMsgtype("news");
			//保存图文消息个数
			if(fodder.getFuncflag()==0){
				fodder.setArticlecount(1);
			}else{
				fodder.setArticlecount(0);
			}
			
		}
		//保存创建日期
		fodder.setCreatedate(new Date());
		
		fodderService.add(fodder);
		
		arg[0]="fodderAction!list?publicaccount="+paccount+"&status="+savetype;
		arg[1]="素材管理";
		return SUCCESS;
	}
	
	/**
	 * 多图文添加
	 * @return
	 * @throws Exception
	 */
	private List<Fodderarticle> fodderarticles;
	private int fodderid;//供子图文页面显示
	public String muladd() throws Exception{
		//保存消息类型
		fodder.setMsgtype("news");
		//保存文章数量
		fodder.setArticlecount(0);
		//保存创建日期
		fodder.setCreatedate(new Date());
		//获取保存后返回的总图文ID
		fodderid = fodderService.addreturn(fodder);
		//查询该总图文ID的所有子图文信息并展示在子图文管理
		fodderarticles = fodderarticleService.queryFodderarticlesByFodderid(fodderid);
		return "fodderarticlelist";
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
		Fodder fodder=fodderService.loadById(id);
		//删除图片
		//如果是单图文，删除该记录中的图片即可，若是多图文，循环删除子图文的图；
		int savetype = fodder.getSavetype();
		int funcflag = fodder.getFuncflag();
		if(savetype==6&&funcflag==0){
			File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+fodder.getPicurl());
			photofile.delete();
		}else if(savetype==6&&funcflag==1){
			List<Fodderarticle> fodderarticles = fodderarticleService.queryFodderarticlesByFodderid(id);
			for (Fodderarticle fodderarticle : fodderarticles) {
				File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+fodderarticle.getPicurl());
				photofile.delete();
			}
		}
		
		fodderService.delete(fodder);
		
		arg[0]="fodderAction!list?publicaccount="+paccount+"&status="+fodder.getSavetype();
		arg[1]="素材管理";
		return SUCCESS;
	}
	/**
	 * 修改
	 * @return
	 */
	public String update() throws Exception{
		String paccount=fodder.getPublicaccount();
		//修改图片
		
		if(picture!=null){
			String imageName=DateTimeKit.getDateRandom()+pictureFileName.substring(pictureFileName.indexOf("."));
			this.upload(imageName);
			File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+fodder.getPicurl());
			photofile.delete();
			fodder.setPicurl(paccount+"/"+imageName);
			
		}
		//保存正文描述
		if(newsdes!=null&&!newsdes.equals("")){
			fodder.setDescription(newsdes);
		}else if(musicdes!=null&&!musicdes.equals("")){
			fodder.setDescription(musicdes);
		}
		//保存素材类型
		int savetype= fodder.getSavetype();
		if(savetype==1){
			fodder.setMsgtype("text");
		}else if(savetype==5){
			fodder.setMsgtype("music");
		}else if(savetype==6){
			fodder.setMsgtype("news");
		}
		//保存创建日期
		fodder.setCreatedate(new Date());
		fodderService.update(fodder);
		arg[0]="fodderAction!list?publicaccount="+paccount+"&status="+savetype;
		arg[1]="素材管理";
		return SUCCESS;
	}
	/**
	 * 查看信息
	 * @return
	 */
	public String view(){
		fodder=fodderService.loadById(id);
		return "view";
	}
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String load() throws Exception{
		fodder=fodderService.loadById(id);
		int savetype=fodder.getSavetype();
		if(savetype==5){
			musicdes = fodder.getDescription();
		}else if(savetype==6){
			newsdes = fodder.getDescription();
		}
		return "load";
	}
	private String currentpage;
	public String choosefodder(){
		//所有当前页记录对象[根据条件、条件值、类型id、公众号原始ID]
		fodders=fodderService.querySavetypeList(con,convalue,status,publicaccount);
		//总记录数
		totalCount=fodderService.getSavetypeTotalCount(con,convalue,status,publicaccount);
		return "fodderchooselist";
	}
	
	public String refreshSessionAs(){
		Fodder thisfodder = fodderService.loadById(fodderid);
		if(thisfodder!=null){
			String sucainame = thisfodder.getTitle();
			session.put("sucainame", sucainame);
			session.put("fodderid", fodderid);
		}
		arg[0]=currentpage+".jsp";
		arg[1]="素材选定";
		return SUCCESS;
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
	public IFodderService getFodderService() {
		return fodderService;
	}
	@Resource
	public void setFodderService(IFodderService fodderService) {
		this.fodderService = fodderService;
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
	
	public void setFodder(Fodder fodder) {
		this.fodder = fodder;
	}
	
	public Fodder getFodder() {
		return fodder;
	}
	public List<Fodder> getFodders() {
		return fodders;
	}
	public void setFodders(List<Fodder> fodders) {
		this.fodders = fodders;
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
	public IFodderarticleService getFodderarticleService() {
		return fodderarticleService;
	}
	@Resource
	public void setFodderarticleService(IFodderarticleService fodderarticleService) {
		this.fodderarticleService = fodderarticleService;
	}
	public List<Fodderarticle> getFodderarticles() {
		return fodderarticles;
	}
	public void setFodderarticles(List<Fodderarticle> fodderarticles) {
		this.fodderarticles = fodderarticles;
	}
	public int getFodderid() {
		return fodderid;
	}
	public void setFodderid(int fodderid) {
		this.fodderid = fodderid;
	}
	public String getMusicdes() {
		return musicdes;
	}
	public void setMusicdes(String musicdes) {
		this.musicdes = musicdes;
	}
	public String getNewsdes() {
		return newsdes;
	}
	public void setNewsdes(String newsdes) {
		this.newsdes = newsdes;
	}
	public String getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(String currentpage) {
		this.currentpage = currentpage;
	}
	
	
}
