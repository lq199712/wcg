package com.jlj.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.util.ArrayList;
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

import com.jlj.model.Pubclient;
import com.jlj.model.Wdy;
import com.jlj.model.Woption;
import com.jlj.model.Wvote;
import com.jlj.service.IPubclientService;
import com.jlj.service.IWdyService;
import com.jlj.util.DateTimeKit;
import com.jlj.util.IPUtil;
import com.jlj.vo.WdyVO;
import com.jlj.vo.WoptionfrontVO;
import com.jlj.vo.WvoteVO;
import com.opensymphony.xwork2.ActionSupport;

@Component("wdyAction")
@Scope("prototype")
public class WdyAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private IWdyService wdyService;
	private IPubclientService pubclientService;
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//单个对象
	private int id;
	private Wdy wdy;
	//分页显示
	private String[] arg=new String[2];
	private List<Wdy> wdys;
	private List<WdyVO> wdyVOs;
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
	
	private String frontpa;
	public String frontWdys(){
//		wdys = wdyService.getFrontWdysByPublicAccount(frontpa);
//		request.put("wdys", wdys);
//		//查询该frontpa所用的模板信息
//		Pubclient pubclient = pubclientService.queryPubclientByFrontpa(frontpa);
//		int template = pubclient.getTemplate();
//		session.put("template", template);
		return NONE;
	}
	//=========后台首页类别=================================================
	/**
	 * 管理
	 */
	public String list() throws Exception{
		
/*		if(convalue!=null&&!convalue.equals("")){
			convalue=URLDecoder.decode(convalue, "utf-8");
		}
		if(page<1){
			page=1;
		}
		//总页数
		pageCount=wdyService.getPageCount(con,convalue,size);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		wdys=wdyService.queryList(con,convalue,page,size);*/
		
		
		wdys=wdyService.getWdys();
		if(wdys!=null&&wdys.size()>0)
		{
			wdyVOs = new ArrayList<WdyVO>();
			for (Wdy wdy : wdys) {
				WdyVO wdyVO = new WdyVO();
				wdyVO.setId(wdy.getId());
				wdyVO.setName(wdy.getName());
				wdyVO.setKeywordname(wdy.getKeywordname());
				wdyVO.setTime(wdy.getStarttime()+"-"+wdy.getEndtime());
				wdyVO.setIsuseful(checkUsefulDay(wdy.getStarttime(),wdy.getEndtime()));
				wdyVOs.add(wdyVO);
			}
		}
		
		
		
		//总记录数
		totalCount=wdyService.getTotalCount(con,convalue);
		return "list";
	}
	
	
	/*
	 * 检查投票是否在有效期内
	 */
	private Integer checkUsefulDay(String starttime, String endtime) throws ParseException {
		// TODO Auto-generated method stub
		String nowday = DateTimeKit.getLocalDay();
		if(starttime==null||starttime.replace(" ", "").equals("")||endtime.replace(" ", "").equals("")||endtime==null)
		{
			return 0;
		}
		if(DateTimeKit.daysBetween(starttime, nowday)>0&&DateTimeKit.daysBetween(nowday, endtime)>0)
		{
			return 1;
		}
		return 0;
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
		
		if(picture!=null){
			String imageName=DateTimeKit.getDateRandom()+pictureFileName.substring(pictureFileName.indexOf("."));
			this.upload("wdyimage",imageName,picture);
			wdy.setImage("/"+imageName);
		}
		wdy.setNumber(0);
		wdy.setNumber1(0);
		wdy.setNumber2(0);
		wdy.setNumber3(0);
		wdy.setNumber4(0);
		wdy.setNumber5(0);
		wdy.setNumber6(0);
		wdyService.add(wdy);
		
		arg[0]="wdyAction!list";
		arg[1]="微调研管理";
		return SUCCESS;
	}
	
	/*
	 * 图片上传
	 */
	private File picture;
	private String pictureContentType;
	private String pictureFileName;
	public void upload(String fileName,String imageName,File picture) throws Exception{
		File saved=new File(ServletActionContext.getServletContext().getRealPath(fileName),imageName);
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
	
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		/*Pubclient pubclient = (Pubclient)session.get("pubclient");
		if(pubclient==null){
			String errorInfo="会话失效，请重新登录";
			request.put("errorInfo", errorInfo);
			return "operror";
		}
		String paccount=pubclient.getPublicaccount();*/
		wdy=wdyService.loadById(id);
		//删除图片
		if(wdy.getImage()!=null&&!wdy.getImage().replace(" ", "").equals(""))
		{
			File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+"wdyimage/"+wdy.getImage());
			photofile.delete();
		}
		
		
		wdyService.delete(wdy);
		
		arg[0]="wdyAction!list";
		arg[1]="微调研管理";
		return SUCCESS;
	}
	/**
	 * 修改
	 * @return
	 */
	public String update() throws Exception{
		
		if(picture!=null&&pictureFileName!=null&&!pictureFileName.replace(" ", "").equals("")){
			String imageName=DateTimeKit.getDateRandom()+pictureFileName.substring(pictureFileName.indexOf("."));
			this.upload("wdyimage",imageName,picture);
			File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+ "wdyimage/"+wdy.getImage());
			photofile.delete();
			wdy.setImage("/"+imageName);
		}
		wdyService.update(wdy);
		arg[0]="wdyAction!list";
		arg[1]="微调研管理";
		return SUCCESS;
	}
	/**
	 * 查看信息
	 * @return
	 */
	public String view(){
		wdy=wdyService.loadById(id);
		return "view";
	}
	/**
	 * 跳转到修改页面
	 * @return
	 */
	
	private Integer percent1;
	private Integer percent2;
	private Integer percent3;
	private Integer percent4;
	private Integer percent5;
	private Integer percent6;
	public String load() throws Exception{
		
		wdy=wdyService.loadById(id);
		if(wdy.getNumber()!=0)//确保总选择数不为0
		{
			percent1 = getPercent(wdy.getNumber1(),wdy.getNumber());
			percent2 = getPercent(wdy.getNumber2(),wdy.getNumber());
			percent3 = getPercent(wdy.getNumber3(),wdy.getNumber());
			percent4 = getPercent(wdy.getNumber4(),wdy.getNumber());
			percent5 = getPercent(wdy.getNumber5(),wdy.getNumber());
			percent6 = getPercent(wdy.getNumber6(),wdy.getNumber());
		}
		return "load";
	}
	/*
	 * 获得票数百分百
	 */
	private Integer getPercent(Integer number, Integer totalnumber) {
		// TODO Auto-generated method stub
		
		double a = (double)number;
		double b = (double)totalnumber;
		
		double c = a/b;
		
		int d = (int)(c*100);
		return d;
	}
	
	/**
	 * 前台
	 * @return
	 * @throws ParseException 
	 */
	private String username;
	private String telphone;
	private Integer wdyid;
	private Integer answerNumber;
	/**
	 * 跳转至答案
	 * @return
	 * @throws ParseException
	 */
	public String goToAnswers() throws ParseException
	{
		wdys=wdyService.getWdys();
		
		List<Wdy> wdypres = new ArrayList<Wdy>();
		
		if(wdys!=null&&wdys.size()>0)
		{
			for (Wdy wdy : wdys) {
				
				if(checkUsefulDay(wdy.getStarttime(),wdy.getEndtime())==1)
				{
					wdypres.add(wdy);
				}
			}
		}
		if(wdypres.size()>0)
		{
			wdy = wdypres.get(0);
			
			return "answers";
			
		}else
		{
			return "wdyover";
		}
	}
	
	/**
	 * 选择答案提交
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String selectAnswer() throws UnsupportedEncodingException
	{
		if(username!=null&&!username.equals("")){
			username=URLDecoder.decode(username, "utf-8");
		}
		if(telphone!=null&&!telphone.equals("")){
			telphone=URLDecoder.decode(telphone, "utf-8");
		}
		
		wdy = wdyService.loadById(wdyid); 
		String ip = IPUtil.getIpAddr(req);//获得IP地址
		if(!checkWdyUser(ip,telphone,wdy))//判断是否已经投票
		{
			return "wdyagain";
		}
		//刷新后重新获得
		wdy = setCurrentWdy(wdy,ip,username,telphone,answerNumber);
		return "wdyok";
	}
	
	
	/*
	 * 重新设置微调研信息
	 */
	private Wdy setCurrentWdy(Wdy wdy, String ip, String username, String telphone,Integer answerNumber) {
		// TODO Auto-generated method stub
		
		wdy = wdyService.loadById(wdy.getId());
		wdy.setNumber(wdy.getNumber()+1);
		if(wdy.getWdyip()!=null&&!wdy.getWdyip().equals(""))
		{
			wdy.setWdyip(wdy.getWdyip()+","+ip);
		}else
		{
			wdy.setWdyip(ip);
		}
		if(wdy.getWdytel()!=null&&!wdy.getWdytel().equals(""))
		{
			wdy.setWdytel(wdy.getWdytel()+","+username+"_"+telphone);
		}else
		{
			wdy.setWdytel(username+"_"+telphone);
		}
		switch (answerNumber) {
		case 1:
			wdy.setNumber1(wdy.getNumber1()+1);
			break;
		case 2:
			wdy.setNumber2(wdy.getNumber2()+1);	
					break;
		case 3:
			wdy.setNumber3(wdy.getNumber3()+1);
			break;
		case 4:
			wdy.setNumber4(wdy.getNumber4()+1);
			break;
		case 5:
			wdy.setNumber5(wdy.getNumber5()+1);
			break;
		case 6:
			wdy.setNumber6(wdy.getNumber6()+1);
			break;
		default:
			break;
		}
		wdyService.update(wdy);
		
		return wdy;
	}
	public String listWdyFront()
	{
		
		
		return "frontlist";
	}
	
	
	/*
	 * 通过IP及电话检查改用户是否已经投过票
	 */
	private boolean checkWdyUser(String ip,String telphone,Wdy wdy) {
		
		// TODO Auto-generated method stub
		if(wdy.getWdyip()!=null&&wdy.getWdytel()!=null&&wdy.getWdyip().contains(ip)&&wdy.getWdytel().contains(telphone))
		{
			return false;
		}
		return true;
		
	}

	
	//get、set-------------------------------------------
	public IWdyService getWdyService() {
		return wdyService;
	}
	@Resource
	public void setWdyService(IWdyService wdyService) {
		this.wdyService = wdyService;
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
	
	public void setWdy(Wdy wdy) {
		this.wdy = wdy;
	}
	
	public Wdy getWdy() {
		return wdy;
	}
	public List<Wdy> getWdys() {
		return wdys;
	}
	public void setWdys(List<Wdy> wdys) {
		this.wdys = wdys;
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

	public String getFrontpa() {
		return frontpa;
	}

	public void setFrontpa(String frontpa) {
		this.frontpa = frontpa;
	}

	public IPubclientService getPubclientService() {
		return pubclientService;
	}

	@Resource
	public void setPubclientService(IPubclientService pubclientService) {
		this.pubclientService = pubclientService;
	}
	public List<WdyVO> getWdyVOs() {
		return wdyVOs;
	}
	public void setWdyVOs(List<WdyVO> wdyVOs) {
		this.wdyVOs = wdyVOs;
	}
	public Integer getPercent1() {
		return percent1;
	}
	public void setPercent1(Integer percent1) {
		this.percent1 = percent1;
	}
	public Integer getPercent2() {
		return percent2;
	}
	public void setPercent2(Integer percent2) {
		this.percent2 = percent2;
	}
	public Integer getPercent3() {
		return percent3;
	}
	public void setPercent3(Integer percent3) {
		this.percent3 = percent3;
	}
	public Integer getPercent4() {
		return percent4;
	}
	public void setPercent4(Integer percent4) {
		this.percent4 = percent4;
	}
	public Integer getPercent5() {
		return percent5;
	}
	public void setPercent5(Integer percent5) {
		this.percent5 = percent5;
	}
	public Integer getPercent6() {
		return percent6;
	}
	public void setPercent6(Integer percent6) {
		this.percent6 = percent6;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public Integer getWdyid() {
		return wdyid;
	}
	public void setWdyid(Integer wdyid) {
		this.wdyid = wdyid;
	}
	public Integer getAnswerNumber() {
		return answerNumber;
	}
	public void setAnswerNumber(Integer answerNumber) {
		this.answerNumber = answerNumber;
	}
	
	
}
