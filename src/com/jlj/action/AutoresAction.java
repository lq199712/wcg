package com.jlj.action;

import java.net.URLDecoder;
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

import com.jlj.model.Autores;
import com.jlj.model.Pubclient;
import com.jlj.service.IAutoresService;
import com.jlj.service.IFodderService;
import com.opensymphony.xwork2.ActionSupport;

@Component("autoresAction")
@Scope("prototype")
public class AutoresAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private IAutoresService autoresService;
	private IFodderService fodderService;
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//单个对象
	private int id;
	private Autores autores;
	//分页显示
	private String[] arg=new String[2];
	private List<Autores> autoress;
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
	 * 自动回复管理
	 */
	public String list() throws Exception{
		if(convalue!=null&&!convalue.equals("")){
			convalue=URLDecoder.decode(convalue, "utf-8");
		}
		if(page<1){
			page=1;
		}
		//总页数
		pageCount=autoresService.getPageCount(con,convalue,status,publicaccount,size);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		autoress=autoresService.queryList(con,convalue,status,publicaccount,page,size);
		//总记录数
		totalCount=autoresService.getTotalCount(con,convalue,status,publicaccount);
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
		String paccount=autores.getPublicaccount();
		autoresService.add(autores);
		
		arg[0]="autoresAction!view?publicaccount="+paccount;
		arg[1]="自动回复";
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
		Autores autores=autoresService.loadById(id);
		autoresService.delete(autores);
		
		arg[0]="autoresAction!list?publicaccount="+paccount;
		arg[1]="自动回复管理";
		return SUCCESS;
	}
	/**
	 * 修改
	 * @return
	 */
	public String update() throws Exception{
		String paccount=autores.getPublicaccount();
		autoresService.update(autores);
		arg[0]="autoresAction!view?publicaccount="+paccount;
		arg[1]="自动回复";
		return SUCCESS;
	}
	/**
	 * 查看信息
	 * @return
	 */
	public String view(){
		//若客户第一次浏览该页，首先进入添加自动关注回复页面;否则，直接进入查看页面
		List<Autores> autoreslist= autoresService.queryListByPublicAccount(publicaccount);
		if(autoreslist.size()>0){
			autores=autoreslist.get(0);
			
			if(autores!=null){
				return "view";
			}else{
				String errorInfo="会话失效了，请重新登录";
				request.put("errorInfo", errorInfo);
				return "operror";
			}
			
			
		}else{
			return this.goToAdd();
		}
		
	}
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String load() throws Exception{
		autores=autoresService.loadById(id);
		return "load";
	}
	
	
	//get、set-------------------------------------------
	public IAutoresService getAutoresService() {
		return autoresService;
	}
	@Resource
	public void setAutoresService(IAutoresService autoresService) {
		this.autoresService = autoresService;
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
	
	public void setAutores(Autores autores) {
		this.autores = autores;
	}
	
	public Autores getAutores() {
		return autores;
	}
	public List<Autores> getAutoress() {
		return autoress;
	}
	public void setAutoress(List<Autores> autoress) {
		this.autoress = autoress;
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
	
}
