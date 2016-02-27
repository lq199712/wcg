package com.jlj.action;

import java.io.PrintWriter;
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

import com.jlj.model.Bigtype;
import com.jlj.model.Pubclient;
import com.jlj.model.Screenimg;
import com.jlj.service.IBigtypeService;
import com.jlj.service.IScreenimgService;
import com.jlj.service.IVcoreService;
import com.jlj.service.imp.VcoreService;
import com.jlj.util.SignUtil;
import com.opensymphony.xwork2.ActionSupport;

@Component("vcoreAction")
@Scope("prototype")
public class VcoreAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 3222279472851543374L;
	private IVcoreService vcoreService;
	private IScreenimgService screenimgService;
	private IBigtypeService bigtypeService;
	
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//成为开发者
	public String vcheck() throws Exception{
		// 1、获取微信公众账号英文名
		String vxinpublic = req.getParameter("vxinpublic");
		// 2、判断是否数据库存在该注册公众号，若有则提取该公众账号的信息token用
		String token = "jsjlj1988";
		// 3、检查是否来自微信，是否校验成功
		
		// 微信加密签名
		String signature = req.getParameter("signature");
		// 时间戳
		String timestamp = req.getParameter("timestamp");
		// 随机数
		String nonce = req.getParameter("nonce");
		// 随机字符串
		String echostr = req.getParameter("echostr");

		PrintWriter out = response.getWriter();
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (SignUtil.checkSignature(signature, timestamp, nonce, token)) {
			out.print(echostr);
		}
		out.close();
		out = null;
		return null;
	}
	//得到从微信服务器过来的post返回响应
	public String vresponse() throws Exception{
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		req.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 1、获取微信公众账号英文名
		String vxinpublic = req.getParameter("vxinpublic");
		// 2、判断是否数据库存在该注册公众号，若有则提取该公众账号的信息token用
		String token = "jsjlj1988";
		System.out.println("vxinpublic="+vxinpublic+",token="+token);
		// 微信加密签名
		String signature = req.getParameter("signature");
		// 时间戳
		String timestamp = req.getParameter("timestamp");
		// 随机数
		String nonce = req.getParameter("nonce");
		// 响应消息
		PrintWriter out = response.getWriter();
		// Z、检查判断是否信息来自微信
		if (SignUtil.checkSignature(signature, timestamp, nonce, token)) {
			// 调用核心业务类接收消息、处理消息[传入session放openid值]
			// 3、根据事件或回复内容产生相应的响应结果
			String respMessage = vcoreService.processRequest(req,vxinpublic);
			out.print(respMessage);
		}
		
		
		
		out.close();
		return null;
	}
	public String vprocess() throws Exception{
		if("GET".equals(req.getMethod())){
			return this.vcheck();
		}else{
			return this.vresponse();
		}
	}
	
	private String frontpa;
	private String openid;
	private List<Screenimg> screenimgs;
	private List<Bigtype> bigtypes;
	public String venter(){
		session.put("frontpa", frontpa);
		session.put("openid", openid);
		screenimgs = screenimgService.getScreenimgsByCondition(2, frontpa);
		bigtypes = bigtypeService.getBigtypesByPublicAccount(frontpa);
		return "travel";
	}
	//跳转到大酒店首页
	public String vhotel(){
		session.put("frontpa", frontpa);
		session.put("openid", openid);
		screenimgs = screenimgService.getScreenimgsByCondition(2, frontpa);
		return "hotel";
	}
	//get、set-------------------------------------------
	public IVcoreService getVcoreService() {
		return vcoreService;
	}
	@Resource
	public void setVcoreService(IVcoreService vcoreService) {
		this.vcoreService = vcoreService;
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
	public IScreenimgService getScreenimgService() {
		return screenimgService;
	}
	@Resource
	public void setScreenimgService(IScreenimgService screenimgService) {
		this.screenimgService = screenimgService;
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
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	
}
