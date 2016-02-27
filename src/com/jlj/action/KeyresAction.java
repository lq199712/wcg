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

import com.jlj.model.Fodder;
import com.jlj.model.Keyres;
import com.jlj.model.Pubclient;
import com.jlj.service.IFodderService;
import com.jlj.service.IKeyresService;
import com.opensymphony.xwork2.ActionSupport;

@Component("keyresAction")
@Scope("prototype")
public class KeyresAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private IKeyresService keyresService;
	private IFodderService fodderService;
	
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//单个对象
	private int id;
	private Keyres keyres;
	//分页显示
	private String[] arg=new String[2];
	private List<Keyres> keyress;
	private int page;
	private final int size=10;
	private int pageCount;
	private int totalCount;
	private int status;//按状态
	private int pkid;//按用户id
	private String publicaccount;//公众号原始ID
	//条件
	private int con;
	private String convalue;
	
	
	/**
	 * 关键词管理
	 */
	public String list() throws Exception{
		if(convalue!=null&&!convalue.equals("")){
			convalue=URLDecoder.decode(convalue, "utf-8");
		}
		if(page<1){
			page=1;
		}
		//总页数
		pageCount=keyresService.getPageCountByPkid(con,convalue,status,pkid,size);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		keyress=keyresService.queryListByPkid(con,convalue,status,pkid,page,size);
		//总记录数
		totalCount=keyresService.getTotalCountByPkid(con,convalue,status,pkid);
		return "list";
	}
	/**
	 * 跳转到添加页面
	 * @return
	 */
	List<Fodder> fodders;
	public String goToAdd(){
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
		keyresService.add(keyres);
		
		arg[0]="keyresAction!list?pkid="+pkid;
		arg[1]="关键词管理";
		return SUCCESS;
	}
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		keyresService.deleteById(id);
		
		arg[0]="keyresAction!list?pkid="+pkid;
		arg[1]="关键词管理";
		return SUCCESS;
	}
	/**
	 * 修改
	 * @return
	 */
	public String update() throws Exception{
		keyresService.update(keyres);
		arg[0]="keyresAction!list?pkid="+pkid;
		arg[1]="关键词管理";
		return SUCCESS;
	}
	/**
	 * 查看信息
	 * @return
	 */
	public String view(){
		keyres=keyresService.loadById(id);
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
		fodders = fodderService.getFoddersByPublicAccount(paccount);
		keyres=keyresService.loadById(id);
		return "load";
	}
	
	
	//get、set-------------------------------------------
	public IKeyresService getKeyresService() {
		return keyresService;
	}
	@Resource
	public void setKeyresService(IKeyresService keyresService) {
		this.keyresService = keyresService;
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
	
	public void setKeyres(Keyres keyres) {
		this.keyres = keyres;
	}
	
	public Keyres getKeyres() {
		return keyres;
	}
	public List<Keyres> getKeyress() {
		return keyress;
	}
	public void setKeyress(List<Keyres> keyress) {
		this.keyress = keyress;
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

	
	public int getPkid() {
		return pkid;
	}
	public void setPkid(int pkid) {
		this.pkid = pkid;
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
