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

import com.jlj.model.Addressbook;
import com.jlj.model.Pubclient;
import com.jlj.service.IAddressbookService;
import com.opensymphony.xwork2.ActionSupport;

@Component("addressbookAction")
@Scope("prototype")
public class AddressbookAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private IAddressbookService addressbookService;
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//单个对象
	private int id;
	private Addressbook addressbook;
	//分页显示
	private String[] arg=new String[2];
	private List<Addressbook> addressbooks;
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
	 * 页脚管理
	 */
	public String list() throws Exception{
		if(convalue!=null&&!convalue.equals("")){
			convalue=URLDecoder.decode(convalue, "utf-8");
		}
		if(page<1){
			page=1;
		}
		//总页数
		pageCount=addressbookService.getPageCount(con,convalue,size);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		addressbooks=addressbookService.queryList(con,convalue,page,size);
		//总记录数
		totalCount=addressbookService.getTotalCount(con,convalue);
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
		addressbookService.add(addressbook);
		
		arg[0]="main.jsp";
		arg[1]="主页";
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
		Addressbook addressbook=addressbookService.loadById(id);
		addressbookService.delete(addressbook);
		
		arg[0]="main.jsp";
		arg[1]="主页";
		return SUCCESS;
	}
	/**
	 * 修改
	 * @return
	 */
	public String update() throws Exception{
		addressbookService.update(addressbook);
		arg[0]="main.jsp";
		arg[1]="主页";
		return SUCCESS;
	}
	/**
	 * 查看信息
	 * @return
	 */
	public String view(){
		addressbook=addressbookService.queryByPublicaccount(publicaccount);
		if(addressbook!=null){
			return "view";
		}else{
			return "add";
		}
		
	}
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String load() throws Exception{
		addressbook=addressbookService.loadById(id);
		return "load";
	}
	
	/**
	 * front 前端
	 * @return
	 */
	
	public String listFront()
	{
		addressbooks=addressbookService.getAddressbooks();
		return "listfront";
	}
	public String listFrontMobile()
	{
		addressbooks=addressbookService.getAddressbooks();
		return "listfront_mobile";
	}
	
	//get、set-------------------------------------------
	public IAddressbookService getAddressbookService() {
		return addressbookService;
	}
	@Resource
	public void setAddressbookService(IAddressbookService addressbookService) {
		this.addressbookService = addressbookService;
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
	
	public void setAddressbook(Addressbook addressbook) {
		this.addressbook = addressbook;
	}
	
	public Addressbook getAddressbook() {
		return addressbook;
	}
	public List<Addressbook> getAddressbooks() {
		return addressbooks;
	}
	public void setAddressbooks(List<Addressbook> addressbooks) {
		this.addressbooks = addressbooks;
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
	
	
}
