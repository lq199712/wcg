package com.jlj.action;

import java.net.URLDecoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jlj.menu.MenuManager;
import com.jlj.menu.MenuTest;
import com.jlj.model.Custommenu;
import com.jlj.model.Fodder;
import com.jlj.model.Pubclient;
import com.jlj.service.ICustommenuService;
import com.jlj.service.IFodderService;
import com.jlj.util.CommonUtil;
import com.jlj.util.MenuUtil;
import com.jlj.util.Token;
import com.lq.vxin.util.AppUtil;
import com.opensymphony.xwork2.ActionSupport;

@Component("custommenuAction")
@Scope("prototype")
public class CustommenuAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private ICustommenuService custommenuService;
	private IFodderService fodderService;
	
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//单个对象
	private int id;
	private Custommenu custommenu;
	//分页显示
	private String[] arg=new String[2];
	private List<Custommenu> custommenus;
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
	 * 自定义菜单管理
	 */
	public String list() throws Exception{
		if(convalue!=null&&!convalue.equals("")){
			convalue=URLDecoder.decode(convalue, "utf-8");
		}
		if(page<1){
			page=1;
		}
		//总页数
		pageCount=custommenuService.getPageCount(con,convalue,status,publicaccount,size);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		custommenus=custommenuService.queryList(con,convalue,status,publicaccount,page,size);
		//总记录数
		totalCount=custommenuService.getTotalCount(con,convalue,status,publicaccount);
		return "list";
	}
	/**
	 * 跳转到添加页面
	 * @return
	 */
	private List<Fodder> fodders;
	public String goToAdd(){
		//获取素材列表
		Pubclient pubclient = (Pubclient)session.get("pubclient");
		if(pubclient==null){
			String errorInfo="会话失效，请重新登录";
			request.put("errorInfo", errorInfo);
			return "operror";
		}
		String paccount=pubclient.getPublicaccount();
		fodders = fodderService.getFoddersByPublicAccount(paccount);
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
		custommenu.setCreatedate(new Date());
		custommenuService.add(custommenu);
		
		arg[0]="custommenuAction!view?publicaccount="+paccount;
		arg[1]="自定义菜单";
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
		custommenuService.deleteById(id);
		
		arg[0]="custommenuAction!list?publicaccount="+paccount;
		arg[1]="自定义菜单管理";
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
		custommenuService.update(custommenu);
		arg[0]="custommenuAction!view?publicaccount="+paccount;
		arg[1]="自定义菜单";
		return SUCCESS;
	}
	/**
	 * 查看信息
	 * @return
	 */
	public String view(){
		Pubclient pubclient = (Pubclient)session.get("pubclient");
		if(pubclient==null){
			String errorInfo="会话失效，请重新登录";
			request.put("errorInfo", errorInfo);
			return "operror";
		}
		String paccount=pubclient.getPublicaccount();
		//判断该公众号的自定菜单是否存在，不存在跳转到add；存在跳转到view
		custommenu=custommenuService.queryCustommenuByPublicAccount(paccount);
		if(custommenu!=null){
			//获取素材列表
			fodders = fodderService.getFoddersByPublicAccount(paccount);
			return "load";
		}else{
			return this.goToAdd();
		}
		
	}
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String load(){
//		custommenu=custommenuService.loadById(id);
		return "load";
	}
	
	public String deploy(){
		Pubclient pubclient = (Pubclient)session.get("pubclient");
		if(pubclient==null){
			String errorInfo="会话失效，请重新登录";
			request.put("errorInfo", errorInfo);
			return "operror";
		}
		String paccount=pubclient.getPublicaccount();
		custommenu=custommenuService.queryCustommenuByPublicAccount(paccount);
		//生成菜单并发布
		Logger log = LoggerFactory.getLogger(MenuTest.class);
//		String appId = "wx0ea5802468b284a6";//第三方用户唯一凭证
//		String appSecret = "edb152956778e3ab6b12d0a47b51ecfe";//第三方用户唯一凭证秘钥
		String appId = AppUtil.appID;
		String appSecret = AppUtil.appSecret;
		Token token = CommonUtil.getToken(appId, appSecret);//调用接口获取凭证
		
		if(null!= token){
			//创建菜单
			boolean result = MenuUtil.createMenu(MenuManager.createMenu(custommenu), token.getAccessToken());
			//判断菜单创建结果
			if(result){
				log.info("菜单创建成功！");
				//获取素材列表
				fodders = fodderService.getFoddersByPublicAccount(paccount);
				arg[0]="custommenuAction!view?publicaccount="+paccount;
				arg[1]="自定义菜单";
				return SUCCESS;
			}else{
				log.info("菜单创建失败！配置不正确");
				String errorInfo="菜单创建失败！配置不正确";
				request.put("errorInfo", errorInfo);
				return "operror";
			}
		}else{
			log.info("菜单创建失败！请检查appid和appscret是否填写正确！");
			String errorInfo="菜单创建失败！请检查appid和appscret是否填写正确！";
			request.put("errorInfo", errorInfo);
			return "operror";
		}
		
		
		 
	}
	
	//get、set-------------------------------------------
	public ICustommenuService getCustommenuService() {
		return custommenuService;
	}
	@Resource
	public void setCustommenuService(ICustommenuService custommenuService) {
		this.custommenuService = custommenuService;
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
	
	public void setCustommenu(Custommenu custommenu) {
		this.custommenu = custommenu;
	}
	
	public Custommenu getCustommenu() {
		return custommenu;
	}
	public List<Custommenu> getCustommenus() {
		return custommenus;
	}
	public void setCustommenus(List<Custommenu> custommenus) {
		this.custommenus = custommenus;
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
	public IFodderService getFodderService() {
		return fodderService;
	}
	@Resource
	public void setFodderService(IFodderService fodderService) {
		this.fodderService = fodderService;
	}
	public List<Fodder> getFodders() {
		return fodders;
	}
	public void setFodders(List<Fodder> fodders) {
		this.fodders = fodders;
	}
	
	
}
