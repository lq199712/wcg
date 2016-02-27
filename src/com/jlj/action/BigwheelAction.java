package com.jlj.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jlj.model.Bigwheel;
import com.jlj.model.Member;
import com.jlj.model.Prizer;
import com.jlj.model.Pubclient;
import com.jlj.service.IBigwheelService;
import com.jlj.service.IMemberService;
import com.jlj.service.IPrizerService;
import com.jlj.service.IPubclientService;
import com.jlj.util.DateTimeKit;
import com.opensymphony.xwork2.ActionSupport;

@Component("bigwheelAction")
@Scope("prototype")
public class BigwheelAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(BigwheelAction.class);
	private IPrizerService prizerService;
	private IBigwheelService bigwheelService;
	private IPubclientService pubclientService;
	private IMemberService memberService;
	
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//单个对象
	private int id;
	private Bigwheel bigwheel;
	private Prizer prizer;

	private List<Bigwheel> bigwheels;
	private List<Prizer> prizers;
	private int totalCount;
	private String publicaccount;//公众号原始ID
	private String[] arg=new String[2];
	private String frontpa;
	private Member member;
	private String openid;
	private int pid;
	private String template;
	
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	/**
	 * 大转盘管理
	 */
	public String list() throws Exception{
		bigwheels = bigwheelService.queryList(publicaccount);
		totalCount = bigwheelService.getTotalCount(publicaccount);
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
		String paccount = bigwheel.getPublicaccount();
		if(picture!=null){
			String imageName = DateTimeKit.getDateRandom()+pictureFileName.substring(pictureFileName.indexOf("."));
			this.upload(imageName);
			bigwheel.setImage(paccount+"/"+imageName);
		}
		if(bigwheel.getPrizenumber1()==null)
		{
			bigwheel.setPrizenumber1(0);
		}
		if(bigwheel.getPrizenumber2()==null)
		{
			bigwheel.setPrizenumber2(0);
		}	
		if(bigwheel.getPrizenumber3()==null)
		{
			bigwheel.setPrizenumber3(0);
		}
		if(bigwheel.getPrizeprob1()==null)
		{
			bigwheel.setPrizeprob1(0.0f);
		}
		if(bigwheel.getPrizeprob2()==null)
		{
			bigwheel.setPrizeprob2(0.0f);
		}	
		if(bigwheel.getPrizeprob3()==null)
		{
			bigwheel.setPrizeprob3(0.0f);
		}
		bigwheelService.add(bigwheel);
		arg[0]="bigwheelAction!list?publicaccount="+paccount;
		arg[1]="大转盘管理";
		return "success";
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
		String paccount = pubclient.getPublicaccount();
		Bigwheel bigwheel = bigwheelService.loadById(id);
		if(bigwheel!=null)
		{
			//删除图片
			try {
				File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+bigwheel.getImage());
				photofile.delete();
			} catch (Exception e) {
				logger.info("图片没有删除成功，文件夹中没有对应图片");
			}	
			bigwheelService.delete(bigwheel);
			arg[0]="bigwheelAction!list?publicaccount="+paccount;
			arg[1]="大转盘管理";
			return SUCCESS;
		}
		else
		{
			logger.info("数据库中bigwheel表格中没有id为"+id+"的记录。");
			return "fail";
		}
		
	}
	/**
	 * 修改
	 * @return
	 */
	public String update() throws Exception{
		String paccount = bigwheel.getPublicaccount();
		if(picture!=null){
			String imageName=DateTimeKit.getDateRandom()+pictureFileName.substring(pictureFileName.indexOf("."));
			this.upload(imageName);
			File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+bigwheel.getImage());
			photofile.delete();
			bigwheel.setImage(paccount+"/"+imageName);
		}
		bigwheelService.update(bigwheel);
		arg[0]="bigwheelAction!list?publicaccount="+paccount;
		arg[1]="大转盘管理";
		return SUCCESS;
	}
	/**
	 * 查看信息
	 * @return
	 */
	public String view(){
		bigwheel = bigwheelService.loadById(id);
		return "view";
	}
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String load() throws Exception{
		bigwheel = bigwheelService.loadById(id);
		return "load";
	}
	
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
	/**
	 * 跳转到front
	 * 前端显示奖品
	 */
	//检查是否存在相同的mid
	public boolean checkOpenid(int mid,int id)
	{
		prizers = prizerService.queryList(mid,id);
//		System.out.println(prizers.size());
		if(prizers!=null&&prizers.size()>0)
		{
			prizer = prizers.get(0);
			return true;
		}
		return false;
	}
	
	//直接跳转到结束页面
	public String toEnd()
	{
		return "bigwheelend";
	}
	
	//检查是否还存在奖品
	public boolean checkHasPrize(Bigwheel bigwheel)
	{
		if(bigwheel.getPrizenumber1()>0||bigwheel.getPrizenumber2()>0||bigwheel.getPrizenumber3()>0)
		{
			if(bigwheel.getPrizenumber1()==0)
			{
				bigwheel.setPrizeprob1(0.0f);
				bigwheelService.update(bigwheel);
			}
			if(bigwheel.getPrizenumber2()==0)
			{
				bigwheel.setPrizeprob2(0.0f);
				bigwheelService.update(bigwheel);
			}
			if(bigwheel.getPrizenumber2()==0)
			{
				bigwheel.setPrizeprob3(0.0f);
				bigwheelService.update(bigwheel);
			}
			return true;
		}
		else
		{
			return false;
		}
	}

	//继续转
	public String isCanWheel() throws Exception
	{
		prizer = prizerService.loadById(pid);
		if(prizer.getTotimes()>0)
		{
			prizer.setTotimes(prizer.getTotimes()-1);
			prizerService.update(prizer);
			bigwheel = prizer.getBigwheel();
			if(checkHasPrize(bigwheel))
			{
				return "bigwheel";
			}
			else
			{
				return "noprizes";
			}
		}
		else
		{
			return "bigwheelend";
		}
	}
	
	 //已存在抽奖者就更新抽奖者，不存在就新增抽奖者
	public void AddOrUpdatePrizer(int mid,int id) throws Exception
	{
		if(!checkOpenid(mid,id))
		{
			//增加
			Prizer per = new Prizer();
			per.setIsprizer(0);
			per.setMid(mid);
			bigwheel = bigwheelService.loadById(id);
			per.setBigwheel(bigwheel);
			per.setTotimes(bigwheel.getTotimes());
			prizer = per;
			prizerService.add(per);
		}
	}
	
	//跳转到前台大转盘
	public String bigwheel() throws Exception
	{
		member=memberService.queryMemberByCondition(openid, frontpa);
		//1、判断会员是否登陆：未登陆跳转到登陆界面；已登录跳转到会员卡展示页面
			if(member!=null){
				bigwheels = bigwheelService.queryList(frontpa);
				Date date = new Date();
				for(Bigwheel bw:bigwheels)
				{
					if(bw.getCurrentstate()==1&&date.compareTo(bw.getTimeend())<0)
					{
						bigwheel = bw;
					}
				}
				
				if(bigwheel!=null)
				{
					AddOrUpdatePrizer(member.getId(),bigwheel.getId());
					pid = prizer.getId();
					if(prizer.getTotimes()>0)
					{
						if(checkHasPrize(bigwheel))
						{
							return "bigwheel";
						}
						else
						{
							return "noprizes";
						}
						
					}
					else
					{
						return "bigwheelend";
					}
				}
				else
				{
					return "bigwheelend";
				}
			}else{
				return "nologin";
			}
	}
	
	private String name;
	private String tel;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	//抽中奖品者更新数据库
	public String updateRealPrizer() throws UnsupportedEncodingException
	{
		prizer  = prizerService.loadById(pid);
		
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
		String prizename = req.getParameter("prizename");
		String prizeid = req.getParameter("prizeid");
		if(name!=null&&!name.equals("")){
			name=URLDecoder.decode(name, "utf-8");
		}
		if(tel!=null&&!tel.equals("")){
			tel=URLDecoder.decode(tel, "utf-8");
		}
		if(prizename!=null&&!prizename.equals("")){
			prizename=URLDecoder.decode(prizename, "utf-8");
			if(prizeid!=null&&!prizeid.equals("")){
				prizeid=URLDecoder.decode(prizeid, "utf-8");
				refreshNewBigwheel(prizeid,prizename,prizer.getBigwheel().getId());
			}
		}
		prizer.setIsprizer(1);
		prizer.setName(name);
		prizer.setTel(tel);
		prizer.setTotimes(prizer.getTotimes()-1);
		prizer.setPrize(prizer.getPrize()+","+prizename);
		prizer.setTime(new Date());
		prizerService.update(prizer);
		return "updateRealPrizersuccess"; 
	}
	
	//抽奖成功后，更新大转盘奖品信息
	public void refreshNewBigwheel(String prizeid,String name,int id)
	{
		int prid = Integer.parseInt(prizeid); 
		bigwheel = bigwheelService.loadById(id);
		
		switch(prid)
		{
			case 1:
				bigwheel.setPrizenumber1(bigwheel.getPrizenumber1()-1);
				bigwheelService.update(bigwheel);
				break;
			case 2:
				bigwheel.setPrizenumber2(bigwheel.getPrizenumber2()-1);
				bigwheelService.update(bigwheel);
				break;
			case 3:
				bigwheel.setPrizenumber3(bigwheel.getPrizenumber3()-1);
				bigwheelService.update(bigwheel);
				break;
		}
	}
	//根据不同的奖品页面中获得不同的图片
	private String prizeImg;
	public String getPrizeImg() throws UnsupportedEncodingException
	{
		prizeImg = req.getParameter("prizeimg");
		if(prizeImg!=null&&!prizeImg.equals("")){
			prizeImg=URLDecoder.decode(prizeImg, "utf-8");
		}
		req.setAttribute("prizeImg",prizeImg);
		//模板
		int temp=0;
		if(session.get("template")!=null){
			temp = (Integer)session.get("template");
		}else{
			Pubclient pubclient = pubclientService.queryPubclientByFrontpa(frontpa);
			temp = pubclient.getTemplate();
			session.put("template",temp);
		}
		template="template"+temp;
		return "prizeimg";
	}
	//get、set-------------------------------------------
	public IBigwheelService getBigwheelService() {
		return bigwheelService;
	}
	@Resource
	public void setBigwheelService(IBigwheelService bigwheelService) {
		this.bigwheelService = bigwheelService;
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
	
	public void setBigwheel(Bigwheel bigwheel) {
		this.bigwheel = bigwheel;
	}
	
	public Bigwheel getBigwheel() {
		return bigwheel;
	}
	public List<Bigwheel> getBigwheels() {
		return bigwheels;
	}
	public void setBigwheels(List<Bigwheel> bigwheels) {
		this.bigwheels = bigwheels;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
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
	public IPrizerService getPrizerService() {
		return prizerService;
	}
	@Resource
	public void setPrizerService(IPrizerService prizerService) {
		this.prizerService = prizerService;
	}
	public Prizer getPrizer() {
		return prizer;
	}
	public void setPrizer(Prizer prizer) {
		this.prizer = prizer;
	}
	public void setResponse(javax.servlet.http.HttpServletResponse response) {
		this.response = response;
	}
	public void setReq(javax.servlet.http.HttpServletRequest req) {
		this.req = req;
	}
	public String getFrontpa() {
		return frontpa;
	}
	public void setFrontpa(String frontpa) {
		this.frontpa = frontpa;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public List<Prizer> getPrizers() {
		return prizers;
	}
	public void setPrizers(List<Prizer> prizers) {
		this.prizers = prizers;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public void setPrizeImg(String prizeImg) {
		this.prizeImg = prizeImg;
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
	public IMemberService getMemberService() {
		return memberService;
	}
	@Resource
	public void setMemberService(IMemberService memberService) {
		this.memberService = memberService;
	}
	
	
}
