package com.jlj.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.Calendar;
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

import com.jlj.model.Bigtype;
import com.jlj.model.Pagearticle;
import com.jlj.model.Pubclient;
import com.jlj.model.Sontype;
import com.jlj.service.IBigtypeService;
import com.jlj.service.IPagearticleService;
import com.jlj.service.IPubclientService;
import com.jlj.service.ISontypeService;
import com.jlj.util.DateTimeKit;
import com.opensymphony.xwork2.ActionSupport;

@Component("pagearticleAction")
@Scope("prototype")
public class PagearticleAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private IPagearticleService pagearticleService;
	private ISontypeService sontypeService;
	private IPubclientService pubclientService;
	
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//单个对象
	private int id;
	private Pagearticle pagearticle;
	//添加页面显示大类别
	private List<Sontype> sontypes;
	//分页显示
	private String[] arg=new String[2];
	private List<Pagearticle> pagearticles;
	private int page;
	private final int size=20;
	private int pageCount;
	private int totalCount;
	private int status;//按状态
	private int pid;//按用户id
	private String publicaccount;//公众号原始ID
	//条件
	private int con;
	private String convalue;
	
	private int stid;//子类别id
	private List<Bigtype> bigtypes;
	private IBigtypeService bigtypeService;
	private String frontpa;//传入参数，查询所有大类别信息
	private String template;
	
	private int producttype;//1门店活动界面2服务菜单界面3设计师团队界面
	/**
	 * 前台-分页显示文章列表
	 * @return
	 */
	public String frontpagearticle(){
		//获取该账号的大类别
		bigtypes = bigtypeService.getBigtypesByPublicAccount(frontpa);
		int psize=10;//每页显示10条
		if(page<1){
			page=1;
		}
		//总页数
		pageCount=pagearticleService.getFrontPageCount(stid,psize);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		pagearticles=pagearticleService.queryFrontList(stid,page,psize);
		//总记录数
		totalCount=pagearticleService.getFrontTotalCount(stid);
		
		if(producttype==1){
			return "frontpageactivity";
		}else if(producttype==2){
			return "frontpageservice";
		}else if(producttype==3){
			return "frontpageteam";
		}else{
			return NONE;
		}
		
	}
	/**
	 * 前台-跳转到活动-详细展示界面
	 * @return
	 */
	public String frontview1(){
		//获取该账号的大类别
		bigtypes = bigtypeService.getBigtypesByPublicAccount(frontpa);
		pagearticle=pagearticleService.loadById(id);
		
		return "frontview1";
	}
	/**
	 * 前台-跳转到服务详细展示界面
	 * @return
	 */
	public String frontview2(){
		//获取该账号的大类别
		bigtypes = bigtypeService.getBigtypesByPublicAccount(frontpa);
		pagearticle=pagearticleService.loadById(id);
		
		return "frontview2";
	}
	
	/**
	 * 前台-跳转到设计师团队详细展示界面
	 * @return
	 */
	public String frontview3(){
		//获取该账号的大类别
		bigtypes = bigtypeService.getBigtypesByPublicAccount(frontpa);
		pagearticle=pagearticleService.loadById(id);
		
		return "frontview3";
	}
	/**
	 * 前台-跳转到头版文章详细展示界面
	 * @return
	 */
	public String frontview4(){
		//获取该账号的大类别
		pagearticle=pagearticleService.loadById(id);
		
		return "frontview4";
	}
	/**
	 * 前台-首页-头版文章列表
	 * @return
	 */
	public String frontindexview(){
		int isshow = 2;//查询头版
		int page = 1;//只提取第一页
		int psize = 6;//只显示6条头版
		pagearticles=pagearticleService.queryFrontIndexList(frontpa,isshow,page,psize);
		request.put("pagearticles", pagearticles);
		return null;
	}
	/**
	 * 前台-个人中心-查询该文章
	 * @return
	 */
	public String frontcenterview(){
		pagearticle=pagearticleService.queryPagearticleById(id);
		request.put("pagearticle", pagearticle);
		return null;
	}
	//============活动===========================
	/**
	 * 后台-活动管理
	 */
	public String list1() throws Exception{
		if(convalue!=null&&!convalue.equals("")){
			convalue=URLDecoder.decode(convalue, "utf-8");
		}
		if(page<1){
			page=1;
		}
		//总页数
		pageCount=pagearticleService.getPageCount(con,convalue,status,publicaccount,size);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		pagearticles=pagearticleService.queryList(con,convalue,status,publicaccount,page,size);
		//总记录数
		totalCount=pagearticleService.getTotalCount(con,convalue,status,publicaccount);
		return "list1";
	}
	
	
	/**
	 * 后台-跳转到添加页面
	 * @return
	 */
	public String goToAdd1(){
		Pubclient pubclient = (Pubclient)session.get("pubclient");
		if(pubclient==null){
			String errorInfo="会话失效，请重新登录";
			request.put("errorInfo", errorInfo);
			return "operror";
		}
		String paccount=pubclient.getPublicaccount();
		
		int producttype=1;
		sontypes = sontypeService.getSontypesByPublicAccount(paccount,producttype);
		return "add1";
	}
	
	/**
	 * 后台-添加
	 * @return
	 * @throws Exception
	 */
	public String add1() throws Exception{
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
			pagearticle.setImage(paccount+"/"+imageName);
			
		}
		//设置创建日期
		pagearticle.setCreatetime(Calendar.getInstance());
		pagearticleService.add(pagearticle);
		
		arg[0]="pagearticleAction!list1?publicaccount="+paccount+"&status="+pagearticle.getArticletype();
		arg[1]="活动管理";
		return SUCCESS;
	}
	
	/**
	 * 后台-删除
	 * @return
	 */
	public String delete1(){
		Pubclient pubclient = (Pubclient)session.get("pubclient");
		if(pubclient==null){
			String errorInfo="会话失效，请重新登录";
			request.put("errorInfo", errorInfo);
			return "operror";
		}
		String paccount=pubclient.getPublicaccount();
		Pagearticle pagearticle=pagearticleService.loadById(id);
		
		
		arg[0]="pagearticleAction!list1?publicaccount="+paccount+"&status="+pagearticle.getArticletype();
		arg[1]="活动管理";
		
		//删除图片
		File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+pagearticle.getImage());
		photofile.delete();
		pagearticleService.delete(pagearticle);
		
		
		return SUCCESS;
	}
	/**
	 * 后台-修改
	 * @return
	 */
	public String update1() throws Exception{
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
			File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+pagearticle.getImage());
			photofile.delete();
			pagearticle.setImage(paccount+"/"+imageName);
			
		}
		//设置创建日期
		pagearticle.setCreatetime(Calendar.getInstance());
//		//设置详细描述
//		pagearticle.setDescription(htmlspecialchars(pagearticle.getDescription()));
		pagearticleService.update(pagearticle);
		arg[0]="pagearticleAction!list1?publicaccount="+paccount+"&status="+pagearticle.getArticletype();
		arg[1]="活动管理";
		return SUCCESS;
	}
	/**
	 * 后台-查看信息
	 * @return
	 */
	public String view1(){
		pagearticle=pagearticleService.loadById(id);
		return "view1";
	}
	/**
	 * 后台-跳转到修改页面
	 * @return
	 */
	public String load1() throws Exception{
		Pubclient pubclient = (Pubclient)session.get("pubclient");
		if(pubclient==null){
			String errorInfo="会话失效，请重新登录";
			request.put("errorInfo", errorInfo);
			return "operror";
		}
		String paccount=pubclient.getPublicaccount();
		int producttype=1;
		sontypes = sontypeService.getSontypesByPublicAccount(paccount,producttype);
		pagearticle=pagearticleService.loadById(id);
		return "load1";
	}
	//------------服务管理----------------------------------
	
	/**
	 * 后台服务-服务管理
	 */
	public String list2() throws Exception{
		if(convalue!=null&&!convalue.equals("")){
			convalue=URLDecoder.decode(convalue, "utf-8");
		}
		if(page<1){
			page=1;
		}
		//总页数
		pageCount=pagearticleService.getPageCount(con,convalue,status,publicaccount,size);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		pagearticles=pagearticleService.queryList(con,convalue,status,publicaccount,page,size);
		//总记录数
		totalCount=pagearticleService.getTotalCount(con,convalue,status,publicaccount);
		return "list2";
	}
	
	/**
	 * 后台服务-跳转到添加页面
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
		int producttype=1;
		sontypes = sontypeService.getSontypesByPublicAccount(paccount,producttype);
		return "add2";
	}
	
	/**
	 * 后台服务-添加
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
			pagearticle.setImage(paccount+"/"+imageName);
			
		}
		//设置创建日期
		pagearticle.setCreatetime(Calendar.getInstance());
		pagearticleService.add(pagearticle);
		
		arg[0]="pagearticleAction!list2?publicaccount="+paccount+"&status="+pagearticle.getArticletype();
		arg[1]="服务管理";
		return SUCCESS;
	}
	
	/**
	 * 后台服务-删除
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
		Pagearticle pagearticle=pagearticleService.loadById(id);
		
		
		arg[0]="pagearticleAction!list2?publicaccount="+paccount+"&status="+pagearticle.getArticletype();
		arg[1]="服务管理";
		
		//删除图片
		File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+pagearticle.getImage());
		photofile.delete();
		pagearticleService.delete(pagearticle);
		
		
		return SUCCESS;
	}
	/**
	 * 后台服务-修改
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
			File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+pagearticle.getImage());
			photofile.delete();
			pagearticle.setImage(paccount+"/"+imageName);
			
		}
		//设置创建日期
		pagearticle.setCreatetime(Calendar.getInstance());
//		//设置详细描述
//		pagearticle.setDescription(htmlspecialchars(pagearticle.getDescription()));
		pagearticleService.update(pagearticle);
		arg[0]="pagearticleAction!list2?publicaccount="+paccount+"&status="+pagearticle.getArticletype();
		arg[1]="服务管理";
		return SUCCESS;
	}
	/**
	 * 后台服务-查看信息
	 * @return
	 */
	public String view2(){
		pagearticle=pagearticleService.loadById(id);
		return "view2";
	}
	/**
	 * 后台服务-跳转到修改页面
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
		int producttype=1;
		sontypes = sontypeService.getSontypesByPublicAccount(paccount,producttype);
		pagearticle=pagearticleService.loadById(id);
		return "load2";
	}
	
	
	//============设计师===========================
	/**
	 * 后台-设计师管理
	 */
	public String list3() throws Exception{
		if(convalue!=null&&!convalue.equals("")){
			convalue=URLDecoder.decode(convalue, "utf-8");
		}
		if(page<1){
			page=1;
		}
		//总页数
		pageCount=pagearticleService.getPageCount(con,convalue,status,publicaccount,size);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		pagearticles=pagearticleService.queryList(con,convalue,status,publicaccount,page,size);
		//总记录数
		totalCount=pagearticleService.getTotalCount(con,convalue,status,publicaccount);
		return "list3";
	}
	
	
	/**
	 * 后台-跳转到添加页面
	 * @return
	 */
	public String goToAdd3(){
		Pubclient pubclient = (Pubclient)session.get("pubclient");
		if(pubclient==null){
			String errorInfo="会话失效，请重新登录";
			request.put("errorInfo", errorInfo);
			return "operror";
		}
		String paccount=pubclient.getPublicaccount();
		
		int producttype=1;
		sontypes = sontypeService.getSontypesByPublicAccount(paccount,producttype);
		return "add3";
	}
	
	/**
	 * 后台-添加
	 * @return
	 * @throws Exception
	 */
	public String add3() throws Exception{
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
			pagearticle.setImage(paccount+"/"+imageName);
			
		}
		//设置创建日期
		pagearticle.setCreatetime(Calendar.getInstance());
		pagearticleService.add(pagearticle);
		
		arg[0]="pagearticleAction!list3?publicaccount="+paccount+"&status="+pagearticle.getArticletype();
		arg[1]="设计师管理";
		return SUCCESS;
	}
	
	/**
	 * 后台-删除
	 * @return
	 */
	public String delete3(){
		Pubclient pubclient = (Pubclient)session.get("pubclient");
		if(pubclient==null){
			String errorInfo="会话失效，请重新登录";
			request.put("errorInfo", errorInfo);
			return "operror";
		}
		String paccount=pubclient.getPublicaccount();
		Pagearticle pagearticle=pagearticleService.loadById(id);
		
		
		arg[0]="pagearticleAction!list3?publicaccount="+paccount+"&status="+pagearticle.getArticletype();
		arg[1]="设计师管理";
		
		//删除图片
		File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+pagearticle.getImage());
		photofile.delete();
		pagearticleService.delete(pagearticle);
		
		
		return SUCCESS;
	}
	/**
	 * 后台-修改
	 * @return
	 */
	public String update3() throws Exception{
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
			File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+pagearticle.getImage());
			photofile.delete();
			pagearticle.setImage(paccount+"/"+imageName);
			
		}
		//设置创建日期
		pagearticle.setCreatetime(Calendar.getInstance());
//		//设置详细描述
//		pagearticle.setDescription(htmlspecialchars(pagearticle.getDescription()));
		pagearticleService.update(pagearticle);
		arg[0]="pagearticleAction!list3?publicaccount="+paccount+"&status="+pagearticle.getArticletype();
		arg[1]="设计师管理";
		return SUCCESS;
	}
	/**
	 * 后台-查看信息
	 * @return
	 */
	public String view3(){
		pagearticle=pagearticleService.loadById(id);
		return "view3";
	}
	/**
	 * 后台-跳转到修改页面
	 * @return
	 */
	public String load3() throws Exception{
		Pubclient pubclient = (Pubclient)session.get("pubclient");
		if(pubclient==null){
			String errorInfo="会话失效，请重新登录";
			request.put("errorInfo", errorInfo);
			return "operror";
		}
		String paccount=pubclient.getPublicaccount();
		int producttype=1;
		sontypes = sontypeService.getSontypesByPublicAccount(paccount,producttype);
		pagearticle=pagearticleService.loadById(id);
		return "load3";
	}
	//=========================================================
	
	//============头版文章管理===========================
	/**
	 * 后台-头版文章管理
	 */
	public String list4() throws Exception{
		if(convalue!=null&&!convalue.equals("")){
			convalue=URLDecoder.decode(convalue, "utf-8");
		}
		if(page<1){
			page=1;
		}
		//总页数
		pageCount=pagearticleService.getPageCount(con,convalue,status,publicaccount,size);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		pagearticles=pagearticleService.queryList(con,convalue,status,publicaccount,page,size);
		//总记录数
		totalCount=pagearticleService.getTotalCount(con,convalue,status,publicaccount);
		return "list4";
	}
	
	
	/**
	 * 后台-跳转到添加页面
	 * @return
	 */
	public String goToAdd4(){
		Pubclient pubclient = (Pubclient)session.get("pubclient");
		if(pubclient==null){
			String errorInfo="会话失效，请重新登录";
			request.put("errorInfo", errorInfo);
			return "operror";
		}
		String paccount=pubclient.getPublicaccount();
		
		int producttype=1;
		sontypes = sontypeService.getSontypesByPublicAccount(paccount,producttype);
		return "add4";
	}
	
	/**
	 * 后台-添加
	 * @return
	 * @throws Exception
	 */
	public String add4() throws Exception{
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
			pagearticle.setImage(paccount+"/"+imageName);
			
		}
		//设置创建日期
		pagearticle.setCreatetime(Calendar.getInstance());
		pagearticleService.add(pagearticle);
		
		arg[0]="pagearticleAction!list4?publicaccount="+paccount+"&status="+pagearticle.getArticletype();
		arg[1]="头版文章管理";
		return SUCCESS;
	}
	
	/**
	 * 后台-删除
	 * @return
	 */
	public String delete4(){
		Pubclient pubclient = (Pubclient)session.get("pubclient");
		if(pubclient==null){
			String errorInfo="会话失效，请重新登录";
			request.put("errorInfo", errorInfo);
			return "operror";
		}
		String paccount=pubclient.getPublicaccount();
		Pagearticle pagearticle=pagearticleService.loadById(id);
		
		
		arg[0]="pagearticleAction!list4?publicaccount="+paccount+"&status="+pagearticle.getArticletype();
		arg[1]="头版文章管理";
		
		//删除图片
		File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+pagearticle.getImage());
		photofile.delete();
		pagearticleService.delete(pagearticle);
		
		
		return SUCCESS;
	}
	/**
	 * 后台-修改
	 * @return
	 */
	public String update4() throws Exception{
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
			File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+pagearticle.getImage());
			photofile.delete();
			pagearticle.setImage(paccount+"/"+imageName);
			
		}
		//设置创建日期
		pagearticle.setCreatetime(Calendar.getInstance());
//		//设置详细描述
//		pagearticle.setDescription(htmlspecialchars(pagearticle.getDescription()));
		pagearticleService.update(pagearticle);
		arg[0]="pagearticleAction!list4?publicaccount="+paccount+"&status="+pagearticle.getArticletype();
		arg[1]="头版文章管理";
		return SUCCESS;
	}
	/**
	 * 后台-查看信息
	 * @return
	 */
	public String view4(){
		pagearticle=pagearticleService.loadById(id);
		return "view4";
	}
	/**
	 * 后台-跳转到修改页面
	 * @return
	 */
	public String load4() throws Exception{
		Pubclient pubclient = (Pubclient)session.get("pubclient");
		if(pubclient==null){
			String errorInfo="会话失效，请重新登录";
			request.put("errorInfo", errorInfo);
			return "operror";
		}
		String paccount=pubclient.getPublicaccount();
		int producttype=1;
		sontypes = sontypeService.getSontypesByPublicAccount(paccount,producttype);
		pagearticle=pagearticleService.loadById(id);
		return "load4";
	}
	//=======================================================================
	
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
	private String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}
	//get、set-------------------------------------------
	public IPagearticleService getPagearticleService() {
		return pagearticleService;
	}
	@Resource
	public void setPagearticleService(IPagearticleService pagearticleService) {
		this.pagearticleService = pagearticleService;
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
	
	public void setPagearticle(Pagearticle pagearticle) {
		this.pagearticle = pagearticle;
	}
	
	public Pagearticle getPagearticle() {
		return pagearticle;
	}
	public List<Pagearticle> getPagearticles() {
		return pagearticles;
	}
	public void setPagearticles(List<Pagearticle> pagearticles) {
		this.pagearticles = pagearticles;
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
	public ISontypeService getSontypeService() {
		return sontypeService;
	}
	@Resource
	public void setSontypeService(ISontypeService sontypeService) {
		this.sontypeService = sontypeService;
	}
	public List<Sontype> getSontypes() {
		return sontypes;
	}
	public void setSontypes(List<Sontype> sontypes) {
		this.sontypes = sontypes;
	}

	public int getStid() {
		return stid;
	}

	public void setStid(int stid) {
		this.stid = stid;
	}

	public List<Bigtype> getBigtypes() {
		return bigtypes;
	}

	public void setBigtypes(List<Bigtype> bigtypes) {
		this.bigtypes = bigtypes;
	}

	public IBigtypeService getBigtypeService() {
		return bigtypeService;
	}
	@Resource
	public void setBigtypeService(IBigtypeService bigtypeService) {
		this.bigtypeService = bigtypeService;
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
	public int getProducttype() {
		return producttype;
	}
	public void setProducttype(int producttype) {
		this.producttype = producttype;
	}
	
	
}
