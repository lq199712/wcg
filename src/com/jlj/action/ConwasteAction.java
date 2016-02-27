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

import com.jlj.model.Conwaste;
import com.jlj.service.IConwasteService;
import com.opensymphony.xwork2.ActionSupport;

@Component("conwasteAction")
@Scope("prototype")
public class ConwasteAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private IConwasteService conwasteService;
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//单个对象
	private int id;
	private Conwaste conwaste;
	//分页显示
	private String[] arg=new String[2];
	private List<Conwaste> conwastes;
	private int page;
	private final int size=20;
	private int pageCount;
	private int totalCount;
	private int status;//按状态
	private int pid;//按用户id
	//条件
	private int con;
	private String convalue;
	
	//=========后台首页类别=================================================
	/**
	 * 建筑垃圾准运管理
	 */
	public String list() throws Exception{
		status=1;
		if(convalue!=null&&!convalue.equals("")){
			convalue=URLDecoder.decode(convalue, "utf-8");
		}
		if(page<1){
			page=1;
		}
		//总记录数
		totalCount=conwasteService.getTotalCount(con,convalue,status);
		//总页数
		pageCount=conwasteService.getPageCount(totalCount,size);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		conwastes=conwasteService.queryList(con,convalue,status,page,size);
		
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
		String forquery = conwaste.getPerson()+","+conwaste.getPhone()+","+conwaste.getCarnumber();
		conwaste.setForquery(forquery);
		conwasteService.add(conwaste);
		
		arg[0]="conwasteAction!list";
		arg[1]="建筑垃圾准运管理";
		return SUCCESS;
	}
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		Conwaste conwaste=conwasteService.loadById(id);
		conwasteService.delete(conwaste);
		
		arg[0]="conwasteAction!list";
		arg[1]="建筑垃圾准运管理";
		return SUCCESS;
	}
	/**
	 * 修改
	 * @return
	 */
	public String update() throws Exception{
		String forquery = conwaste.getPerson()+","+conwaste.getPhone()+","+conwaste.getCarnumber();
		conwaste.setForquery(forquery);
		conwasteService.update(conwaste);
		arg[0]="conwasteAction!list";
		arg[1]="建筑垃圾准运管理";
		return SUCCESS;
	}
	
	
	/**
	 * 审核信息
	 * @return
	 * @throws Exception 
	 */
	public String shenhe() throws Exception{
		int status=1;//审核通过
		conwasteService.updateStatusById(status,id);
		return this.list();
	}
	
	/**
	 * 查看信息
	 * @return
	 */
	public String view(){
		conwaste=conwasteService.loadById(id);
		return "view";
	}
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String load() throws Exception{
		conwaste=conwasteService.loadById(id);
		return "load";
	}
	
	
	//get、set-------------------------------------------
	public IConwasteService getConwasteService() {
		return conwasteService;
	}
	@Resource
	public void setConwasteService(IConwasteService conwasteService) {
		this.conwasteService = conwasteService;
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
	
	public void setConwaste(Conwaste conwaste) {
		this.conwaste = conwaste;
	}
	
	public Conwaste getConwaste() {
		return conwaste;
	}
	public List<Conwaste> getConwastes() {
		return conwastes;
	}
	public void setConwastes(List<Conwaste> conwastes) {
		this.conwastes = conwastes;
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
	
}
