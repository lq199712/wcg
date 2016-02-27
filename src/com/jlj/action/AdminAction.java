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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jlj.model.Admin;
import com.jlj.model.Pubclient;
import com.jlj.service.IAdminService;
import com.opensymphony.xwork2.ActionSupport;

@Component("adminAction")
@Scope("prototype")
public class AdminAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private IAdminService adminService;
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//单个对象
	private int id;
	private Admin admin;
	//分页显示
	private String[] arg=new String[2];
	private List<Admin> admins;
	private int page;
	private final int size=20;
	private int pageCount;
	private int totalCount;
	private int status;//按状态
	private int pid;//按用户id
	//条件
	private int con;
	private String convalue;
	
	//登陆-用户名、密码、验证码参数
	private String username;
	private String password;
	//=========后台账号=================================================
	/**
	 * 用户登陆
	 */
	public String login(){
		if(username==null||username.equals("")||password==null||password.equals("")){
			String loginfail="用户名或密码不能为空";
			request.put("loginFail", loginfail);
			return "adminLogin";
		}
		Admin admin=adminService.userlogin(username,password);
		if(admin==null){
			String loginfail="用户名或密码输入有误";
			request.put("loginFail", loginfail);
			return "adminLogin";
		}else{
			session.put("admin", admin);
			return "loginSucc";
		}
	}
	
	/**
	 * 跳转到修改我的账号页面
	 * @return
	 */
	public String loadself() throws Exception{
		admin=adminService.loadById(id);
		return "loadself";
	}
	
	/**
	 * 修改我的信息
	 * @return
	 */
	public String updateself() throws Exception{
		adminService.update(admin);
		arg[0]="welcom.jsp";
		arg[1]="主页";
		return SUCCESS;
	}
	
	private String newpwd;//新密码
	private String againpwd;//再次输入新密码
	private String oldpwd;//旧密码
	/**
	 * 修改个人密码
	 * @return
	 */
	public String upMyPwd(){
		Admin admin=adminService.userlogin(username,oldpwd);
		String errorInfo=null;
		if(admin==null){
			errorInfo="原密码输入有误";
			request.put("errorInfo", errorInfo);
			return "operror";
		}else{
			if(newpwd!=null&&!newpwd.equals("")&&againpwd!=null&&!againpwd.equals("")&&againpwd.equals(newpwd)){
				adminService.updatePwd(newpwd,admin.getId());
				
				arg[0]="welcom.jsp";
				arg[1]="主页";
				return SUCCESS;
			}else{
				errorInfo="两次密码输入不一致";
				request.put("errorInfo", errorInfo);
				return "operror";
			}
		}
	}
	/**
	 * 账号管理
	 */
	public String list() throws Exception{
		if(convalue!=null&&!convalue.equals("")){
			convalue=URLDecoder.decode(convalue, "utf-8");
		}
		if(page<1){
			page=1;
		}
		//总页数
		pageCount=adminService.getPageCount(con,convalue,size);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		admins=adminService.queryList(con,convalue,page,size);
		//总记录数
		totalCount=adminService.getTotalCount(con,convalue);
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
		Date newdate = new Date();
		admin.setCreatedate(newdate);
		adminService.add(admin);
		
		arg[0]="adminAction!list";
		arg[1]="账号管理";
		return SUCCESS;
	}
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		
		adminService.deleteById(id);
		
		arg[0]="adminAction!list";
		arg[1]="账号管理";
		return SUCCESS;
	}
	/**
	 * 修改
	 * @return
	 */
	public String update() throws Exception{
		adminService.update(admin);
		arg[0]="adminAction!list";
		arg[1]="账号管理";
		return SUCCESS;
	}
	/**
	 * 查看信息
	 * @return
	 */
	public String view(){
		admin=adminService.loadById(id);
		return "view";
	}
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String load() throws Exception{
		admin=adminService.loadById(id);
		return "load";
	}
	
	
	//get、set-------------------------------------------
	public IAdminService getAdminService() {
		return adminService;
	}
	@Resource
	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
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
	
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public Admin getAdmin() {
		return admin;
	}
	public List<Admin> getAdmins() {
		return admins;
	}
	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewpwd() {
		return newpwd;
	}

	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}

	public String getAgainpwd() {
		return againpwd;
	}

	public void setAgainpwd(String againpwd) {
		this.againpwd = againpwd;
	}

	public String getOldpwd() {
		return oldpwd;
	}

	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}

	
	
	
}
