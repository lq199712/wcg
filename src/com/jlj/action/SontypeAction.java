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

import com.jlj.dao.IFooterDao;
import com.jlj.model.Bigtype;
import com.jlj.model.Footer;
import com.jlj.model.Pubclient;
import com.jlj.model.Screenimg;
import com.jlj.model.Sontype;
import com.jlj.service.IBigtypeService;
import com.jlj.service.IFooterService;
import com.jlj.service.IPubclientService;
import com.jlj.service.IScreenimgService;
import com.jlj.service.ISontypeService;
import com.jlj.util.DateTimeKit;
import com.opensymphony.xwork2.ActionSupport;

@Component("sontypeAction")
@Scope("prototype")
public class SontypeAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private ISontypeService sontypeService;
	private IBigtypeService bigtypeService;
	private IScreenimgService screenimgService;
	private IFooterService footerService;
	private IPubclientService pubclientService;
	
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//单个对象
	private int id;
	private Sontype sontype;
	//添加页面显示大类别
	private List<Bigtype> bigtypes;
	//分页显示
	private String[] arg=new String[2];
	private List<Sontype> sontypes;
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
	
	private int btid;//大类别id
	private String frontpa;
	private List<Screenimg> screenimgs;
	private Footer footer;
	
	private String template;
	/**
	 * 前台-子页类别列表
	 * @return
	 */
	public String frontsontype(){
		sontypes=sontypeService.querySontypeByCondition(btid);
		screenimgs = screenimgService.getScreenimgsByCondition(2, frontpa);
		footer = footerService.queryByPublicaccount(frontpa);
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
		return "frontsontype";
	}
	//=================================================================================
	/**
	 * 后台-类别管理
	 */
	public String list() throws Exception{
		if(convalue!=null&&!convalue.equals("")){
			convalue=URLDecoder.decode(convalue, "utf-8");
		}
		if(page<1){
			page=1;
		}
		//总页数
		pageCount=sontypeService.getPageCount(con,convalue,status,publicaccount,size);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		sontypes=sontypeService.queryList(con,convalue,status,publicaccount,page,size);
		//总记录数
		totalCount=sontypeService.getTotalCount(con,convalue,status,publicaccount);
		return "list";
	}
	/**
	 * 跳转到添加页面
	 * @return
	 */
	public String goToAdd(){
		Pubclient pubclient = (Pubclient)session.get("pubclient");
		if(pubclient==null){
			String errorInfo="会话失效，请重新登录";
			request.put("errorInfo", errorInfo);
			return "operror";
		}
		String paccount=pubclient.getPublicaccount();
		bigtypes = bigtypeService.getBigtypesByPublicAccount(paccount);
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
			sontype.setImage(paccount+"/"+imageName);
			
		}
		sontypeService.add(sontype);
		
		arg[0]="sontypeAction!list?publicaccount="+paccount+"&status="+sontype.getProducttype();
		arg[1]="类别管理";
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
		Sontype sontype=sontypeService.loadById(id);
		
		arg[0]="sontypeAction!list?publicaccount="+paccount+"&status="+sontype.getProducttype();
		arg[1]="类别管理";
		//删除图片
		File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+sontype.getImage());
		photofile.delete();
		sontypeService.delete(sontype);
		
		
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
			File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+sontype.getImage());
			photofile.delete();
			sontype.setImage(paccount+"/"+imageName);
			
		}
		sontypeService.update(sontype);
		arg[0]="sontypeAction!list?publicaccount="+paccount+"&status="+sontype.getProducttype();
		arg[1]="类别管理";
		return SUCCESS;
	}
	/**
	 * 查看信息
	 * @return
	 */
	public String view(){
		sontype=sontypeService.loadById(id);
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
		bigtypes = bigtypeService.getBigtypesByPublicAccount(paccount);
		sontype=sontypeService.loadById(id);
		return "load";
	}
	
	//--------新闻类别-----------------------------------------------------------
	/**
	 * 后台-类别管理
	 */
	public String newslist() throws Exception{
		if(convalue!=null&&!convalue.equals("")){
			convalue=URLDecoder.decode(convalue, "utf-8");
		}
		if(page<1){
			page=1;
		}
		//总页数
		pageCount=sontypeService.getPageCount(con,convalue,status,publicaccount,size);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		sontypes=sontypeService.queryList(con,convalue,status,publicaccount,page,size);
		//总记录数
		totalCount=sontypeService.getTotalCount(con,convalue,status,publicaccount);
		return "newslist";
	}
	/**
	 * 跳转到添加页面
	 * @return
	 */
	public String goToAdd2(){
		Pubclient pubclient = (Pubclient)session.get("pubclient");
		if(pubclient==null){
			String errorInfo="会话失效，请重新登录";
			request.put("errorInfo", errorInfo);
			return "operror";
		}
		String paccount=pubclient.getPublicaccount();
		bigtypes = bigtypeService.getBigtypesByPublicAccount(paccount);
		return "add2";
	}
	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	public String add2() throws Exception{
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
			sontype.setImage(paccount+"/"+imageName);
			
		}
		sontypeService.add(sontype);
		
		arg[0]="sontypeAction!newslist?publicaccount="+paccount+"&status="+sontype.getProducttype();
		arg[1]="新闻类别管理";
		return SUCCESS;
	}
	/**
	 * 删除
	 * @return
	 */
	public String delete2(){
		Pubclient pubclient = (Pubclient)session.get("pubclient");
		if(pubclient==null){
			String errorInfo="会话失效，请重新登录";
			request.put("errorInfo", errorInfo);
			return "operror";
		}
		String paccount=pubclient.getPublicaccount();
		Sontype sontype=sontypeService.loadById(id);
		
		arg[0]="sontypeAction!newslist?publicaccount="+paccount+"&status="+sontype.getProducttype();
		arg[1]="新闻类别管理";
		//删除图片
		File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+sontype.getImage());
		photofile.delete();
		sontypeService.delete(sontype);
		
		
		return SUCCESS;
	}
	/**
	 * 修改
	 * @return
	 */
	public String update2() throws Exception{
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
			File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+sontype.getImage());
			photofile.delete();
			sontype.setImage(paccount+"/"+imageName);
			
		}
		sontypeService.update(sontype);
		arg[0]="sontypeAction!newslist?publicaccount="+paccount+"&status="+sontype.getProducttype();
		arg[1]="新闻类别管理";
		return SUCCESS;
	}
	/**
	 * 查看信息
	 * @return
	 */
	public String view2(){
		sontype=sontypeService.loadById(id);
		return "view2";
	}
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String load2() throws Exception{
		Pubclient pubclient = (Pubclient)session.get("pubclient");
		if(pubclient==null){
			String errorInfo="会话失效，请重新登录";
			request.put("errorInfo", errorInfo);
			return "operror";
		}
		String paccount=pubclient.getPublicaccount();
		bigtypes = bigtypeService.getBigtypesByPublicAccount(paccount);
		sontype=sontypeService.loadById(id);
		return "load2";
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
	public ISontypeService getSontypeService() {
		return sontypeService;
	}
	@Resource
	public void setSontypeService(ISontypeService sontypeService) {
		this.sontypeService = sontypeService;
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
	
	public void setSontype(Sontype sontype) {
		this.sontype = sontype;
	}
	
	public Sontype getSontype() {
		return sontype;
	}
	public List<Sontype> getSontypes() {
		return sontypes;
	}
	public void setSontypes(List<Sontype> sontypes) {
		this.sontypes = sontypes;
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
	public IBigtypeService getBigtypeService() {
		return bigtypeService;
	}
	@Resource
	public void setBigtypeService(IBigtypeService bigtypeService) {
		this.bigtypeService = bigtypeService;
	}
	public List<Bigtype> getBigtypes() {
		return bigtypes;
	}
	public void setBigtypes(List<Bigtype> bigtypes) {
		this.bigtypes = bigtypes;
	}

	public int getBtid() {
		return btid;
	}

	public void setBtid(int btid) {
		this.btid = btid;
	}

	public IScreenimgService getScreenimgService() {
		return screenimgService;
	}
	@Resource
	public void setScreenimgService(IScreenimgService screenimgService) {
		this.screenimgService = screenimgService;
	}

	public String getFrontpa() {
		return frontpa;
	}

	public void setFrontpa(String frontpa) {
		this.frontpa = frontpa;
	}

	public List<Screenimg> getScreenimgs() {
		return screenimgs;
	}

	public void setScreenimgs(List<Screenimg> screenimgs) {
		this.screenimgs = screenimgs;
	}

	public IFooterService getFooterService() {
		return footerService;
	}
	@Resource
	public void setFooterService(IFooterService footerService) {
		this.footerService = footerService;
	}

	public Footer getFooter() {
		return footer;
	}

	public void setFooter(Footer footer) {
		this.footer = footer;
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
