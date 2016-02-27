package com.jlj.action;

import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
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

import com.jlj.model.Member;
import com.jlj.model.Pubclient;
import com.jlj.service.IMemberService;
import com.jlj.service.IPubclientService;
import com.lq.vxin.bean.AccessToken;
import com.lq.vxin.bean.Actioninfo;
import com.lq.vxin.bean.Scene;
import com.lq.vxin.bean.WeixinQRcode;
import com.lq.vxin.bean.WeixinUser;
import com.lq.vxin.util.AppUtil;
import com.opensymphony.xwork2.ActionSupport;

@Component("memberAction")
@Scope("prototype")
public class MemberAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private IMemberService memberService;
	private IPubclientService pubclientService;
	
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//单个对象
	private int id;
	private Member member;
	//分页显示
	private String[] arg=new String[2];
	private List<Member> members;
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
	
	//前台会员卡登记
	private String truename;
	private String tel;
	private String template;
	private int sel;
	/**
	 * 前台-会员登陆
	 * @return
	 * @throws Exception 
	 */
	public String frontlogin() throws Exception{
		String frontpa = (String)session.get("frontpa");
		
		if(frontpa==null||frontpa.trim().equals("")){
			return "sessiongo";
		}
		//判断手机号和密码是否存在:若存在，则登陆成功；若不存在，则登陆失败
		String tel = req.getParameter("tel");
		String pwd1 = req.getParameter("pwd1");
		member = memberService.queryMemberLogin(tel,pwd1, frontpa);
		PrintWriter out = response.getWriter();
		if(member!=null){
			out.print("ok");
			session.put("member", member);
		}else{
			out.print("relogin");
		}
		return null;
	}
	
	/**
	 * 前台-会员卡添加/会员注册
	 * @return
	 * @throws Exception 
	 */

	public String frontmemberadd() throws Exception{
		
		//String frontpa = (String)session.get("frontpa");
		String frontpa = "gh_616281cc9180";// 为了开发使用 from lq 2015/3/26
		
		// 调用接口获取access_token
		AccessToken at = AppUtil.getAccessToken(AppUtil.appID, AppUtil.appSecret);

		if (null != at) {
			 wxuser = AppUtil.getWxuser("gh_616281cc9180", at.getToken());
		}
		
		if(frontpa==null||frontpa.trim().equals("")){
			return "sessiongo";
		}
		
		//会员注册-跳转到会员登陆
		String truename = req.getParameter("truename");
		System.out.print(truename);
		String tel = req.getParameter("tel");
		String pwd1 = req.getParameter("pwd1");
		PrintWriter out = response.getWriter();
		//判断手机号是否存在:若存在，则请重新注册；若不存在，创建并保持成功
		member = memberService.queryMemberByTel(tel, frontpa);
		if(member!=null){
			out.print("rereg");
		}else{
			//插入数据库
			member = new Member();
			member.setPublicaccount(frontpa);
			member.setRealname(truename);
			member.setPhone(tel);
			member.setPassword(pwd1);
			member.setCredit(1000);
			member.setCurrentcredit(1000);
			member.setConsumecredit(0);
			member.setLevel(0);
			member.setCreatedate(new Date());
			memberService.add(member);
			out.print("ok");
		}
		
		return "frontmembertoview";
		
//		String openid = (String)session.get("openid");
//		String frontpa = (String)session.get("frontpa");
//		if(frontpa!=null&&!frontpa.equals("")&&openid!=null&&!openid.equals("")){
//			member = memberService.queryMemberByCondition(openid,frontpa);
//			member.setRealname(truename);
//			member.setPhone(tel);
//			member.setCredit(0);
//			member.setCurrentcredit(0);
//			member.setConsumecredit(0);
//			member.setLevel(0);
//			member.setCreatedate(new Date());
//			memberService.update(member);
//			return "frontmembertoview";
//		}else{
//			return "sessiongo";
//		}
		
		
		
	}
	/**
	 * 前台展示会员中心-from lq 2015.3.27
	 * @return
	 */
	private WeixinUser wxuser;
	private WeixinUser pwxuser;
	private String qrcodeUrl;
	private List<WeixinUser> nwxusers;
	private String openid;
	private String frontpa;
	public String frontToCenter(){
		if(openid==null||openid.equals("")||frontpa==null||frontpa.equals("")){
			return "sessiongo";
		}
		if(session.get("frontpa")==null){
			session.put("frontpa", frontpa);
		}
		//String frontpa = "gh_616281cc9180"; // 为了开发使用 from lq 2015/3/26
		//默认已经获得openid
		//String openid = "oEzB-uG-AAWbldP4YKIJBSiepA8g";
		member = memberService.queryMemberByCondition(openid, frontpa);
		
		if(member!=null)
		{
//			sel = Integer.parseInt(req.getParameter("sel"));
			session.put("member", member);
			getNextUsers(member);
			// 调用接口获取access_token
			AccessToken at = AppUtil.getAccessToken(AppUtil.appID, AppUtil.appSecret);
			if (null != at) {
				 wxuser = AppUtil.getWxuser(openid, at.getToken());//用户本身
				 if(member.getPreopenid()!=null){
					 pwxuser = AppUtil.getWxuser(member.getPreopenid(), at.getToken());//用户前面那个小伙伴
				 }
			 	 qrcodeUrl = AppUtil.createQrcode(getQrcode(openid), at.getToken()); //二维码
			 	 
			}
		}
		
		//判断是否session中含frontpa，若无则session失效，请重新进入微官网
		if(frontpa!=null&&!frontpa.equals("")){
			return "tocenter";
		}else{
			return "sessiongo";
		}
	}
	
	 private void getNextUsers(Member member2) {
		// TODO Auto-generated method stub
		 if(member2.getNextopenids()!=null&&member2.getNextopenids().length()>0)
		 {
			 String openids[] = member2.getNextopenids().split(",");
			 nwxusers = new ArrayList<WeixinUser>();
			 for(int i=0;i<openids.length;i++)
			 {
				 AccessToken at = AppUtil.getAccessToken(AppUtil.appID, AppUtil.appSecret);
				 if (null != at) {
					 nwxusers.add(AppUtil.getWxuser(openids[i], at.getToken()));
				 }
			 }
		 }
		
	}

	/** 
     * 组装二维码数据 
     *  
     * @return 
     */  
    private static WeixinQRcode getQrcode(String scene_str)
    {
    	WeixinQRcode qrcode = new WeixinQRcode();
    	Scene scene = new Scene();
    	scene.setScene_str(scene_str);
    	Actioninfo actioninfo = new Actioninfo();
    	actioninfo.setScene(scene);
    	qrcode.setAction_name("QR_LIMIT_STR_SCENE");//临时二维码
    	qrcode.setAction_info(actioninfo);
    	return qrcode;
    }
	
	/**
	 * 会员管理
	 */
	public String list() throws Exception{
		if(convalue!=null&&!convalue.equals("")){
			convalue=URLDecoder.decode(convalue, "utf-8");
		}
		if(page<1){
			page=1;
		}
		//总页数
		pageCount=memberService.getPageCount(con,convalue,status,publicaccount,size);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		members=memberService.queryList(con,convalue,status,publicaccount,page,size);
		//总记录数
		totalCount=memberService.getTotalCount(con,convalue,status,publicaccount);
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
		Pubclient pubclient = (Pubclient)session.get("pubclient");
		if(pubclient==null){
			String errorInfo="会话失效，请重新登录";
			request.put("errorInfo", errorInfo);
			return "operror";
		}
		String paccount=pubclient.getPublicaccount();
		memberService.add(member);
		
		arg[0]="memberAction!list?publicaccount="+paccount;
		arg[1]="会员管理";
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
		memberService.deleteById(id);
		
		arg[0]="memberAction!list?publicaccount="+paccount;
		arg[1]="会员管理";
		return SUCCESS;
	}
	/**
	 * 修改
	 * @return
	 */
	public String update(){
		Pubclient pubclient = (Pubclient)session.get("pubclient");
		if(pubclient==null){
			String errorInfo="会话失效，请重新登录";
			request.put("errorInfo", errorInfo);
			return "operror";
		}
		String paccount=pubclient.getPublicaccount();
		memberService.update(member);
		arg[0]="memberAction!list?publicaccount="+paccount;
		arg[1]="会员管理";
		return SUCCESS;
	}
	/**
	 * 修改积分
	 * @return
	 */
	public String updatecredit(){
		Pubclient pubclient = (Pubclient)session.get("pubclient");
		if(pubclient==null){
			String errorInfo="会话失效，请重新登录";
			request.put("errorInfo", errorInfo);
			return "operror";
		}
		String paccount=pubclient.getPublicaccount();
		memberService.update(member);
		arg[0]="memberAction!list?publicaccount="+paccount;
		arg[1]="会员管理";
		return SUCCESS;
	}
	
	/**
	 * 查看信息
	 * @return
	 */
	public String view(){
		member=memberService.loadById(id);
		return "view";
	}
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String load() throws Exception{
		member=memberService.loadById(id);
		return "load";
	}
	
	
	//get、set-------------------------------------------
	public IMemberService getMemberService() {
		return memberService;
	}
	@Resource
	public void setMemberService(IMemberService memberService) {
		this.memberService = memberService;
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
	
	public void setMember(Member member) {
		this.member = member;
	}
	
	public Member getMember() {
		return member;
	}
	public List<Member> getMembers() {
		return members;
	}
	public void setMembers(List<Member> members) {
		this.members = members;
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

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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
	public WeixinUser getWxuser() {
		return wxuser;
	}
	public void setWxuser(WeixinUser wxuser) {
		this.wxuser = wxuser;
	}

	public String getQrcodeUrl() {
		return qrcodeUrl;
	}

	public void setQrcodeUrl(String qrcodeUrl) {
		this.qrcodeUrl = qrcodeUrl;
	}

	public WeixinUser getPwxuser() {
		return pwxuser;
	}

	public void setPwxuser(WeixinUser pwxuser) {
		this.pwxuser = pwxuser;
	}

	public List<WeixinUser> getNwxusers() {
		return nwxusers;
	}

	public void setNwxusers(List<WeixinUser> nwxusers) {
		this.nwxusers = nwxusers;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getFrontpa() {
		return frontpa;
	}

	public void setFrontpa(String frontpa) {
		this.frontpa = frontpa;
	}

	public int getSel() {
		return sel;
	}

	public void setSel(int sel) {
		this.sel = sel;
	}
	
	
}
