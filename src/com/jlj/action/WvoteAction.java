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

import com.jlj.model.Woption;
import com.jlj.model.Wvote;
import com.jlj.service.IWoptionService;
import com.jlj.service.IWvoteService;
import com.jlj.util.DateTimeKit;
import com.jlj.util.IPUtil;
import com.jlj.vo.WoptionfrontVO;
import com.jlj.vo.WvoteVO;
import com.opensymphony.xwork2.ActionSupport;

@Component("wvoteAction")
@Scope("prototype")
public class WvoteAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private IWvoteService wvoteService;
	private IWoptionService woptionService;
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	//单个对象
	private int id;
	private Wvote wvote;
	private WvoteVO wvoteVO;
	private Woption woption;
	//分页显示
	private String[] arg=new String[2];
	private List<Wvote> wvotes;
	private List<WvoteVO> wvoteVOs;
	private List<Woption> woptions;
	private List<WoptionfrontVO> woptionfrontVOs;
	private int page;
	private final int size=20;
	private int pageCount;
	private int totalCount;
	private int status;//按状态
	private int pid;//按用户id
	//条件
	private int con;
	private String convalue;
	
	//选项
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String option5;
	private String option6;
	private String option7;
	private String option8;
	private String option9;
	private String option10;
	
	private String image1;
	private String image2;
	private String image3;
	private String image4;
	private String image5;
	private String image6;
	private String image7;
	private String image8;
	private String image9;
	private String image10;
	
	private Integer number1;
	private Integer number2;
	private Integer number3;
	private Integer number4;
	private Integer number5;
	private Integer number6;
	private Integer number7;
	private Integer number8;
	private Integer number9;
	private Integer number10;
	
	private Integer percent1;
	private Integer percent2;
	private Integer percent3;
	private Integer percent4;
	private Integer percent5;
	private Integer percent6;
	private Integer percent7;
	private Integer percent8;
	private Integer percent9;
	private Integer percent10;
	
	
	//=========后台账号=================================================
	
	/**
	 * 管理
	 */
	public String list() throws Exception{
		/*if(convalue!=null&&!convalue.equals("")){
			convalue=URLDecoder.decode(convalue, "utf-8");
		}
		if(page<1){
			page=1;
		}
		//总页数
		pageCount=wvoteService.getPageCount(con,convalue,size);
		if(page>pageCount&&pageCount!=0){
			page=pageCount;
		}
		//所有当前页记录对象
		wvotes=wvoteService.queryList(con,convalue,page,size);
		//总记录数
		totalCount=wvoteService.getTotalCount(con,convalue);*/
		
		wvotes=wvoteService.getWvotes();
		
		if(wvotes!=null&&wvotes.size()>0)
		{
			wvoteVOs = new ArrayList<WvoteVO>();
			for (Wvote wvote : wvotes) {
				WvoteVO wvoteVO = new WvoteVO();
				wvoteVO.setId(wvote.getId());
				wvoteVO.setName(wvote.getName());
				wvoteVO.setKeywordname(wvote.getKeywordname());
				wvoteVO.setTime(wvote.getStarttime()+"-"+wvote.getEndtime());
				wvoteVO.setIsuseful(checkUsefulDay(wvote.getStarttime(),wvote.getEndtime()));
				wvoteVOs.add(wvoteVO);
			}
		}
		
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
			this.upload("wvoteimage",imageName,picture);
			wvote.setImage("/"+imageName);
		}
		wvote.setNumber(0);
		wvoteService.add(wvote);
		
		addWoptions(wvote);
		
		arg[0]="wvoteAction!list";
		arg[1]="微投票管理";
		return SUCCESS;
	}
	/*
	 * 添加选项
	 */
	private void addWoptions(Wvote wvote) throws Exception {
		// TODO Auto-generated method stub
		if(option1!=null&&!option1.replace(" ", "").equals(""))
		{
			Woption woption = new Woption();
			woption.setName(option1);
			woption.setNumber(0);
			if(picture1!=null){
				String imageName=DateTimeKit.getDateRandom()+picture1FileName.substring(picture1FileName.indexOf("."));
				this.upload("/wvoteimage/wvote_"+wvote.getId(),imageName,picture1);
				woption.setImage("/wvote_"+wvote.getId()+"/"+imageName);
			}
			woption.setWvote(wvote);
			woptionService.add(woption);
		}
		if(option2!=null&&!option2.replace(" ", "").equals(""))
		{
			Woption woption = new Woption();
			woption.setName(option2);
			woption.setNumber(0);
			if(picture2!=null){
				String imageName=DateTimeKit.getDateRandom()+picture2FileName.substring(picture2FileName.indexOf("."));
				this.upload("/wvoteimage/wvote_"+wvote.getId(),imageName,picture2);
				woption.setImage("/wvote_"+wvote.getId()+"/"+imageName);
			}
			woption.setWvote(wvote);
			woptionService.add(woption);
		}
		if(option3!=null&&!option3.replace(" ", "").equals(""))
		{
			Woption woption = new Woption();
			woption.setName(option3);
			woption.setNumber(0);
			if(picture3!=null){
				String imageName=DateTimeKit.getDateRandom()+picture3FileName.substring(picture3FileName.indexOf("."));
				this.upload("/wvoteimage/wvote_"+wvote.getId(),imageName,picture3);
				woption.setImage("/wvote_"+wvote.getId()+"/"+imageName);
			}
			woption.setWvote(wvote);
			woptionService.add(woption);
		}
		if(option4!=null&&!option4.replace(" ", "").equals(""))
		{
			Woption woption = new Woption();
			woption.setName(option4);
			woption.setNumber(0);
			if(picture4!=null){
				String imageName=DateTimeKit.getDateRandom()+picture4FileName.substring(picture4FileName.indexOf("."));
				this.upload("/wvoteimage/wvote_"+wvote.getId(),imageName,picture4);
				woption.setImage("/wvote_"+wvote.getId()+"/"+imageName);
			}
			woption.setWvote(wvote);
			woptionService.add(woption);
		}
		if(option5!=null&&!option5.replace(" ", "").equals(""))
		{
			Woption woption = new Woption();
			woption.setName(option5);
			woption.setNumber(0);
			if(picture5!=null){
				String imageName=DateTimeKit.getDateRandom()+picture5FileName.substring(picture5FileName.indexOf("."));
				this.upload("/wvoteimage/wvote_"+wvote.getId(),imageName,picture5);
				woption.setImage("/wvote_"+wvote.getId()+"/"+imageName);
			}
			woption.setWvote(wvote);
			woptionService.add(woption);
		}
		if(option6!=null&&!option6.replace(" ", "").equals(""))
		{
			Woption woption = new Woption();
			woption.setName(option6);
			woption.setNumber(0);
			if(picture6!=null){
				String imageName=DateTimeKit.getDateRandom()+picture6FileName.substring(picture6FileName.indexOf("."));
				this.upload("/wvoteimage/wvote_"+wvote.getId(),imageName,picture6);
				woption.setImage("/wvote_"+wvote.getId()+"/"+imageName);
			}
			woption.setWvote(wvote);
			woptionService.add(woption);
		}
		if(option7!=null&&!option7.replace(" ", "").equals(""))
		{
			Woption woption = new Woption();
			woption.setName(option7);
			woption.setNumber(0);
			if(picture7!=null){
				String imageName=DateTimeKit.getDateRandom()+picture7FileName.substring(picture7FileName.indexOf("."));
				this.upload("/wvoteimage/wvote_"+wvote.getId(),imageName,picture7);
				woption.setImage("/wvote_"+wvote.getId()+"/"+imageName);
			}
			woption.setWvote(wvote);
			woptionService.add(woption);
		}
		if(option8!=null&&!option8.replace(" ", "").equals(""))
		{
			Woption woption = new Woption();
			woption.setName(option8);
			woption.setNumber(0);
			if(picture8!=null){
				String imageName=DateTimeKit.getDateRandom()+picture8FileName.substring(picture8FileName.indexOf("."));
				this.upload("/wvoteimage/wvote_"+wvote.getId(),imageName,picture8);
				woption.setImage("/wvote_"+wvote.getId()+"/"+imageName);
			}
			woption.setWvote(wvote);
			woptionService.add(woption);
		}
		if(option9!=null&&!option9.replace(" ", "").equals(""))
		{
			Woption woption = new Woption();
			woption.setName(option9);
			woption.setNumber(0);
			if(picture9!=null){
				String imageName=DateTimeKit.getDateRandom()+picture9FileName.substring(picture9FileName.indexOf("."));
				this.upload("/wvoteimage/wvote_"+wvote.getId(),imageName,picture9);
				woption.setImage("/wvote_"+wvote.getId()+"/"+imageName);
			}
			woption.setWvote(wvote);
			woptionService.add(woption);
		}
		if(option10!=null&&!option10.replace(" ", "").equals(""))
		{
			Woption woption = new Woption();
			woption.setName(option10);
			woption.setNumber(0);
			if(picture10!=null){
				String imageName=DateTimeKit.getDateRandom()+picture10FileName.substring(picture10FileName.indexOf("."));
				this.upload("/wvoteimage/wvote_"+wvote.getId(),imageName,picture10);
				woption.setImage("/wvote_"+wvote.getId()+"/"+imageName);
			}
			woption.setWvote(wvote);
			woptionService.add(woption);
		}
		
	}
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		
		
		 wvote= wvoteService.loadById(id);
		//删除图片
		if(wvote.getImage()!=null&&!wvote.getImage().replace(" ", "").equals(""))
		{
			File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+"wvoteimage/"+wvote.getImage());
			photofile.delete();
		}
		
		deleteOption(wvote);
		
		wvoteService.deleteById(id);
		
		arg[0]="wvoteAction!list";
		arg[1]="微投票管理";
		return SUCCESS;
	}
	
	/*
	 * 删除选项及选项的图片
	 */
	private void deleteOption(Wvote wvote) {
		// TODO Auto-generated method stub
		
		woptions = woptionService.queryListBywid(wvote.getId());
		if(woptions!=null&&woptions.size()>0)
		{
			for (Woption woption : woptions) {
				if(woption.getImage()!=null&&!woption.getImage().replace(" ", "").equals(""))
				{
					File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+ "wvoteimage/"+woption.getImage());
					photofile.delete();
				}
				woptionService.delete(woption);
			}
		}
	}

	/**
	 * 修改
	 * @return
	 */
	public String update() throws Exception{
		
		if(picture!=null&&pictureFileName!=null&&!pictureFileName.replace(" ", "").equals("")){
			String imageName=DateTimeKit.getDateRandom()+pictureFileName.substring(pictureFileName.indexOf("."));
			this.upload("wvoteimage",imageName,picture);
			File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+ "wvoteimage/"+wvote.getImage());
			photofile.delete();
			wvote.setImage("/"+imageName);
		}
		
		
		wvoteService.update(wvote);
		
		updateWoptions(wvote);
		
		arg[0]="wvoteAction!list";
		arg[1]="微投票管理";
		return SUCCESS;
	}
	
	/*
	 * 修改选项
	 */
	private void updateWoptions(Wvote wvote) throws Exception {
		// TODO Auto-generated method stub
		
		woptions = woptionService.queryListBywid(wvote.getId());
		
		if(option1!=null&&!option1.replace(" ", "").equals(""))
		{
			
			if(woptions.size()>0)
			{
				Woption woption = woptionService.loadById(woptions.get(0).getId());
				woption.setName(option1);
				if(picture1!=null){
					String imageName=DateTimeKit.getDateRandom()+picture1FileName.substring(picture1FileName.indexOf("."));
					this.upload("/wvoteimage/wvote_"+wvote.getId(),imageName,picture1);
					File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+ "wvoteimage/"+woption.getImage());
					photofile.delete();
					woption.setImage("/wvote_"+wvote.getId()+"/"+imageName);
					
				}
				woptionService.update(woption);
				
				
			}else
			{
				Woption woption = new Woption();
				woption.setName(option1);
				if(picture1!=null){
					
					String imageName=DateTimeKit.getDateRandom()+picture1FileName.substring(picture1FileName.indexOf("."));
					this.upload("/wvoteimage/wvote_"+wvote.getId(),imageName,picture1);
					File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+ "wvoteimage/"+woption.getImage());
					photofile.delete();
					woption.setImage("/wvote_"+wvote.getId()+"/"+imageName);
					
				}
				woption.setNumber(0);
				woption.setWvote(wvote);
				woptionService.add(woption);
			}
			
			
		}
		if(option2!=null&&!option2.replace(" ", "").equals(""))
		{
			if(woptions.size()>1)
			{
				Woption woption = woptionService.loadById(woptions.get(1).getId());
				woption.setName(option2);
				if(picture2!=null){
					String imageName=DateTimeKit.getDateRandom()+picture2FileName.substring(picture2FileName.indexOf("."));
					this.upload("/wvoteimage/wvote_"+wvote.getId(),imageName,picture2);
					File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+ "wvoteimage/"+woption.getImage());
					photofile.delete();
					woption.setImage("/wvote_"+wvote.getId()+"/"+imageName);
				}
				woptionService.update(woption);
			}else
			{
				Woption woption = new Woption();
				woption.setName(option2);
				woption.setNumber(0);
				woption.setWvote(wvote);
				if(picture2!=null){
					String imageName=DateTimeKit.getDateRandom()+picture2FileName.substring(picture2FileName.indexOf("."));
					this.upload("/wvoteimage/wvote_"+wvote.getId(),imageName,picture2);
					File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+ "wvoteimage/"+woption.getImage());
					photofile.delete();
					woption.setImage("/wvote_"+wvote.getId()+"/"+imageName);
				}
				woptionService.add(woption);
			}
		}
		if(option3!=null&&!option3.replace(" ", "").equals(""))
		{
			if(woptions.size()>2)
			{
				Woption woption = woptionService.loadById(woptions.get(2).getId());
				woption.setName(option3);
				if(picture3!=null){
					String imageName=DateTimeKit.getDateRandom()+picture3FileName.substring(picture3FileName.indexOf("."));
					this.upload("/wvoteimage/wvote_"+wvote.getId(),imageName,picture3);
					File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+ "wvoteimage/"+woption.getImage());
					photofile.delete();
					woption.setImage("/wvote_"+wvote.getId()+"/"+imageName);
				}
				woptionService.update(woption);
			}else
			{
				Woption woption = new Woption();
				woption.setName(option3);
				woption.setNumber(0);
				if(picture3!=null){
					String imageName=DateTimeKit.getDateRandom()+picture3FileName.substring(picture3FileName.indexOf("."));
					this.upload("/wvoteimage/wvote_"+wvote.getId(),imageName,picture3);
					File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+ "wvoteimage/"+woption.getImage());
					photofile.delete();
					woption.setImage("/wvote_"+wvote.getId()+"/"+imageName);
				}
				woption.setWvote(wvote);
				woptionService.add(woption);
			}
			
		}
		if(option4!=null&&!option4.replace(" ", "").equals(""))
		{
			if(woptions.size()>3)
			{
				Woption woption = woptionService.loadById(woptions.get(3).getId());
				woption.setName(option4);
				if(picture4!=null){
					String imageName=DateTimeKit.getDateRandom()+picture4FileName.substring(picture4FileName.indexOf("."));
					this.upload("/wvoteimage/wvote_"+wvote.getId(),imageName,picture4);
					File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+ "wvoteimage/"+woption.getImage());
					photofile.delete();
					woption.setImage("/wvote_"+wvote.getId()+"/"+imageName);
				}
				woptionService.update(woption);
			}else
			{
				Woption woption = new Woption();
				woption.setName(option4);
				if(picture4!=null){
					String imageName=DateTimeKit.getDateRandom()+picture4FileName.substring(picture4FileName.indexOf("."));
					this.upload("/wvoteimage/wvote_"+wvote.getId(),imageName,picture4);
					File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+ "wvoteimage/"+woption.getImage());
					photofile.delete();
					woption.setImage("/wvote_"+wvote.getId()+"/"+imageName);
				}
				woption.setNumber(0);
				woption.setWvote(wvote);
				woptionService.add(woption);
			}
		}
		if(option5!=null&&!option5.replace(" ", "").equals(""))
		{
			if(woptions.size()>4)
			{
				Woption woption = woptionService.loadById(woptions.get(4).getId());
				woption.setName(option5);
				if(picture5!=null){
					String imageName=DateTimeKit.getDateRandom()+picture5FileName.substring(picture5FileName.indexOf("."));
					this.upload("/wvoteimage/wvote_"+wvote.getId(),imageName,picture5);
					File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+ "wvoteimage/"+woption.getImage());
					photofile.delete();
					woption.setImage("/wvote_"+wvote.getId()+"/"+imageName);
				}
				woptionService.update(woption);
			}else
			{
				Woption woption = new Woption();
				woption.setName(option5);
				if(picture5!=null){
					String imageName=DateTimeKit.getDateRandom()+picture5FileName.substring(picture5FileName.indexOf("."));
					this.upload("/wvoteimage/wvote_"+wvote.getId(),imageName,picture5);
					File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+ "wvoteimage/"+woption.getImage());
					photofile.delete();
					woption.setImage("/wvote_"+wvote.getId()+"/"+imageName);
				}
				woption.setNumber(0);
				woption.setWvote(wvote);
				woptionService.add(woption);
			}
			
		}
		if(option6!=null&&!option6.replace(" ", "").equals(""))
		{
			if(woptions.size()>5)
			{
				Woption woption = woptionService.loadById(woptions.get(5).getId());
				woption.setName(option6);
				if(picture6!=null){
					String imageName=DateTimeKit.getDateRandom()+picture6FileName.substring(picture6FileName.indexOf("."));
					this.upload("/wvoteimage/wvote_"+wvote.getId(),imageName,picture6);
					File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+ "wvoteimage/"+woption.getImage());
					photofile.delete();
					woption.setImage("/wvote_"+wvote.getId()+"/"+imageName);
				}
				woptionService.update(woption);
			}else
			{
				Woption woption = new Woption();
				woption.setName(option6);
				woption.setNumber(0);
				if(picture6!=null){
					String imageName=DateTimeKit.getDateRandom()+picture6FileName.substring(picture6FileName.indexOf("."));
					this.upload("/wvoteimage/wvote_"+wvote.getId(),imageName,picture6);
					File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+ "wvoteimage/"+woption.getImage());
					photofile.delete();
					woption.setImage("/wvote_"+wvote.getId()+"/"+imageName);
				}
				woption.setWvote(wvote);
				woptionService.add(woption);
			}
			
		}
		if(option7!=null&&!option7.replace(" ", "").equals(""))
		{
			if(woptions.size()>6)
			{
				Woption woption = woptionService.loadById(woptions.get(6).getId());
				woption.setName(option7);
				if(picture7!=null){
					String imageName=DateTimeKit.getDateRandom()+picture7FileName.substring(picture7FileName.indexOf("."));
					this.upload("/wvoteimage/wvote_"+wvote.getId(),imageName,picture7);
					File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+ "wvoteimage/"+woption.getImage());
					photofile.delete();
					woption.setImage("/wvote_"+wvote.getId()+"/"+imageName);
				}
				woptionService.update(woption);
			}else
			{
				Woption woption = new Woption();
				woption.setName(option7);
				woption.setNumber(0);
				if(picture7!=null){
					String imageName=DateTimeKit.getDateRandom()+picture7FileName.substring(picture7FileName.indexOf("."));
					this.upload("/wvoteimage/wvote_"+wvote.getId(),imageName,picture7);
					File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+ "wvoteimage/"+woption.getImage());
					photofile.delete();
					woption.setImage("/wvote_"+wvote.getId()+"/"+imageName);
				}
				woption.setWvote(wvote);
				woptionService.add(woption);
			}
			
		}
		if(option8!=null&&!option8.replace(" ", "").equals(""))
		{
			if(woptions.size()>7)
			{
				Woption woption = woptionService.loadById(woptions.get(7).getId());
				woption.setName(option8);
				if(picture8!=null){
					String imageName=DateTimeKit.getDateRandom()+picture8FileName.substring(picture8FileName.indexOf("."));
					this.upload("/wvoteimage/wvote_"+wvote.getId(),imageName,picture8);
					File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+ "wvoteimage/"+woption.getImage());
					photofile.delete();
					woption.setImage("/wvote_"+wvote.getId()+"/"+imageName);
				}
				woptionService.update(woption);
			}else
			{
				Woption woption = new Woption();
				woption.setName(option8);
				if(picture8!=null){
					String imageName=DateTimeKit.getDateRandom()+picture8FileName.substring(picture8FileName.indexOf("."));
					this.upload("/wvoteimage/wvote_"+wvote.getId(),imageName,picture8);
					File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+ "wvoteimage/"+woption.getImage());
					photofile.delete();
					woption.setImage("/wvote_"+wvote.getId()+"/"+imageName);
				}
				woption.setNumber(0);
				woption.setWvote(wvote);
				woptionService.add(woption);
			}
			
		}
		if(option9!=null&&!option9.replace(" ", "").equals(""))
		{
			if(woptions.size()>8)
			{
				Woption woption = woptionService.loadById(woptions.get(8).getId());
				woption.setName(option9);
				if(picture9!=null){
					String imageName=DateTimeKit.getDateRandom()+picture9FileName.substring(picture9FileName.indexOf("."));
					this.upload("/wvoteimage/wvote_"+wvote.getId(),imageName,picture9);
					File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+ "wvoteimage/"+woption.getImage());
					photofile.delete();
					woption.setImage("/wvote_"+wvote.getId()+"/"+imageName);
				}
				woptionService.update(woption);
			}else
			{
				Woption woption = new Woption();
				woption.setName(option9);
				woption.setNumber(0);
				if(picture9!=null){
					String imageName=DateTimeKit.getDateRandom()+picture9FileName.substring(picture9FileName.indexOf("."));
					this.upload("/wvoteimage/wvote_"+wvote.getId(),imageName,picture9);
					File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+ "wvoteimage/"+woption.getImage());
					photofile.delete();
					woption.setImage("/wvote_"+wvote.getId()+"/"+imageName);
				}
				woption.setWvote(wvote);
				woptionService.add(woption);
			}
			
		}
		if(option10!=null&&!option10.replace(" ", "").equals(""))
		{
			if(woptions.size()>9)
			{
				Woption woption = woptionService.loadById(woptions.get(9).getId());
				woption.setName(option10);
				if(picture10!=null){
					String imageName=DateTimeKit.getDateRandom()+picture10FileName.substring(picture10FileName.indexOf("."));
					this.upload("/wvoteimage/wvote_"+wvote.getId(),imageName,picture10);
					File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+ "wvoteimage/"+woption.getImage());
					photofile.delete();
					woption.setImage("/wvote_"+wvote.getId()+"/"+imageName);
				}
				woptionService.update(woption);
			}else
			{
				Woption woption = new Woption();
				woption.setName(option10);
				woption.setNumber(0);
				if(picture10!=null){
					String imageName=DateTimeKit.getDateRandom()+picture10FileName.substring(picture10FileName.indexOf("."));
					this.upload("/wvoteimage/wvote_"+wvote.getId(),imageName,picture10);
					File photofile=new File(ServletActionContext.getServletContext().getRealPath("/")+ "wvoteimage/"+woption.getImage());
					photofile.delete();
					woption.setImage("/wvote_"+wvote.getId()+"/"+imageName);
				}
				woption.setWvote(wvote);
				woptionService.add(woption);
			}
			
		}
		
		
	}

	/**
	 * 查看信息
	 * @return
	 */
	public String view(){
		wvote=wvoteService.loadById(id);
		return "view";
	}
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String load() throws Exception{
		
		wvote=wvoteService.loadById(id);
		
		woptions = woptionService.queryListBywid(wvote.getId());
		
		if(woptions!=null&&woptions.size()>0)
		{
			int size = woptions.size();
			if(size>0)
			{
				option1 = woptions.get(0).getName();
				image1 = woptions.get(0).getImage();
				number1 = woptions.get(0).getNumber();
				percent1 = getPercent(number1,wvote.getNumber());
			}
			if(size>1)
			{
				option2 = woptions.get(1).getName();
				image2 = woptions.get(1).getImage();
				number2 = woptions.get(1).getNumber();
				percent2 = getPercent(number2,wvote.getNumber());
			}
			if(size>2)
			{
				option3 = woptions.get(2).getName();
				image3 = woptions.get(2).getImage();
				number3 = woptions.get(2).getNumber();
				percent3 = getPercent(number3,wvote.getNumber());
			}
			if(size>3)
			{
				option4 = woptions.get(3).getName();
				image4 = woptions.get(3).getImage();
				number4 = woptions.get(3).getNumber();
				percent4 = getPercent(number4,wvote.getNumber());
			}
			if(size>4)
			{
				option5 = woptions.get(4).getName();
				image5 = woptions.get(4).getImage();
				number5 = woptions.get(4).getNumber();
				percent5 = getPercent(number5,wvote.getNumber());
			}
			if(size>5)
			{
				option6 = woptions.get(5).getName();
				image6 = woptions.get(5).getImage();
				number6 = woptions.get(5).getNumber();
				percent6 = getPercent(number6,wvote.getNumber());
			}
			if(size>6)
			{
				option7 = woptions.get(6).getName();
				image7 = woptions.get(6).getImage();
				number7 = woptions.get(6).getNumber();
				percent7 = getPercent(number7,wvote.getNumber());
			}
			if(size>7)
			{
				option8 = woptions.get(7).getName();
				image8 = woptions.get(7).getImage();
				number8 = woptions.get(7).getNumber();
				percent8 = getPercent(number8,wvote.getNumber());
			}
			if(size>8)
			{
				option9 = woptions.get(8).getName();
				image9 = woptions.get(8).getImage();
				number9 = woptions.get(8).getNumber();
				percent9 = getPercent(number9,wvote.getNumber());
			}
			if(size>9)
			{
				option10 = woptions.get(9).getName();
				image10 = woptions.get(9).getImage();
				number10 = woptions.get(9).getNumber();
				percent10 = getPercent(number10,wvote.getNumber());
			}
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
	//上传照片
	private File picture;
	private File picture1;
	private File picture2;
	private File picture3;
	private File picture4;
	private File picture5;
	private File picture6;
	private File picture7;
	private File picture8;
	private File picture9;
	private File picture10;
	private String pictureContentType;
	private String picture1ContentType;
	private String picture2ContentType;
	private String picture3ContentType;
	private String picture4ContentType;
	private String picture5ContentType;
	private String picture6ContentType;
	private String picture7ContentType;
	private String picture8ContentType;
	private String picture9ContentType;
	private String picture10ContentType;
	private String pictureFileName;
	private String picture1FileName;
	private String picture2FileName;
	private String picture3FileName;
	private String picture4FileName;
	private String picture5FileName;
	private String picture6FileName;
	private String picture7FileName;
	private String picture8FileName;
	private String picture9FileName;
	private String picture10FileName;
	//文件上传
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
	 * front 微投票 前台
	 * @return
	 */
	private String username;
	private String telphone;
	
	/**
	 * 跳转至选项页面
	 */
	public String goToOptions() throws ParseException
	{
		
		wvotes=wvoteService.getWvotes();
		
		List<Wvote> wvotepres = new ArrayList<Wvote>();
		
		if(wvotes!=null&&wvotes.size()>0)
		{
			for (Wvote wvote : wvotes) {
				
				if(checkUsefulDay(wvote.getStarttime(),wvote.getEndtime())==1)
				{
					
					wvotepres.add(wvote);
				}
			}
		}
		if(wvotepres.size()>0)
		{
			wvote = wvotepres.get(0);
			
			wvoteVO = new WvoteVO();
			wvoteVO.setDiffdays(DateTimeKit.daysBetween(DateTimeKit.getLocalDay(), wvote.getEndtime()));
			
			woptions = woptionService.queryListBywid(wvote.getId());
			
			return "options";
				
			
		}else
		{
			return "wtpover";
		}
		
	}
	
	/*
	 * 设置微投票 增加总投票数 增加投票人 IP及电话 
	 */
	private Wvote setCurrentWvote(Wvote wvote,String ip,String telphone) {
		// TODO Auto-generated method stub
		wvote = wvoteService.loadById(wvote.getId());
		wvote.setNumber(wvote.getNumber()+1);
		if(wvote.getWvoteip()!=null&&!wvote.getWvoteip().equals(""))
		{
			wvote.setWvoteip(wvote.getWvoteip()+","+ip);
		}else
		{
			wvote.setWvoteip(ip);
		}
		if(wvote.getWvotetel()!=null&&!wvote.getWvotetel().equals(""))
		{
			wvote.setWvotetel(wvote.getWvotetel()+","+telphone);
		}else
		{
			wvote.setWvotetel(telphone);
		}
		wvoteService.update(wvote);
		
		return wvote;
	}

	/*
	 * 通过IP及电话检查改用户是否已经投过票
	 */
	private boolean checkWvoteUser(String ip,String telphone,Wvote wvote) {
		
		// TODO Auto-generated method stub
		//System.out.println("wvote ip:"+wvote.getWvoteip());
		//System.out.println("wvote tel:"+wvote.getWvotetel());
		//System.out.println("ip:"+ip);
		//System.out.println("telphone:"+telphone);
		if(wvote.getWvoteip()!=null&&wvote.getWvotetel()!=null&&wvote.getWvoteip().contains(ip)&&wvote.getWvotetel().contains(telphone))
		{
			return false;
		}
		return true;
		
	}

	/**
	 * 选项
	 */
	private Integer woptionid;
	
	public String selectOption() throws UnsupportedEncodingException, ParseException
	{
		if(username!=null&&!username.equals("")){
			username=URLDecoder.decode(username, "utf-8");
		}
		if(telphone!=null&&!telphone.equals("")){
			telphone=URLDecoder.decode(telphone, "utf-8");
		}
		
		woption = woptionService.loadById(woptionid); 
		wvote = wvoteService.getWvoteById(woption.getWvote().getId());
		String ip = IPUtil.getIpAddr(req);//获得IP地址
		if(!checkWvoteUser(ip,telphone,wvote))//判断是否已经投票
		{
			return "wtpagain";
		}
		//刷新后重新获得
		wvote = setCurrentWvote(wvote,ip,telphone);
		
		
		if(woption.getMsg()==null)
		{
			woption.setMsg(username+"_"+telphone+"_"+ip);
		}else
		{
			
			woption.setMsg(woption.getMsg()+","+username+"_"+telphone+"_"+ip);
		}
		woption.setNumber(woption.getNumber()+1);
		woptionService.update(woption);
		
		
		woptions = woptionService.queryListBywid(wvote.getId());
		
		woptionfrontVOs = new ArrayList<WoptionfrontVO>();
		
		for (Woption woption : woptions) {
			WoptionfrontVO woptionfrontVO = new WoptionfrontVO();
			woptionfrontVO.setName(woption.getName());
			double a = (double)(woption.getNumber());
			double b  = (double)(wvote.getNumber());
			double pecent = a/b;
			woptionfrontVO.setPecent((int)(pecent*100));
			woptionfrontVO.setNumber(woption.getNumber());
			woptionfrontVOs.add(woptionfrontVO);
		}
		
		wvoteVO = new WvoteVO();
		wvoteVO.setDiffdays(DateTimeKit.daysBetween(DateTimeKit.getLocalDay(), wvote.getEndtime()));
		
		return "wtpok";
	}
	
	
	//get、set-------------------------------------------
	public IWvoteService getWvoteService() {
		return wvoteService;
	}
	@Resource
	public void setWvoteService(IWvoteService wvoteService) {
		this.wvoteService = wvoteService;
	}
	
	
	public IWoptionService getWoptionService() {
		return woptionService;
	}
	@Resource
	public void setWoptionService(IWoptionService woptionService) {
		this.woptionService = woptionService;
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
	
	public void setWvote(Wvote wvote) {
		this.wvote = wvote;
	}
	
	public Wvote getWvote() {
		return wvote;
	}
	public List<Wvote> getWvotes() {
		return wvotes;
	}
	public void setWvotes(List<Wvote> wvotes) {
		this.wvotes = wvotes;
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
	public File getPicture1() {
		return picture1;
	}
	public void setPicture1(File picture1) {
		this.picture1 = picture1;
	}
	public File getPicture2() {
		return picture2;
	}
	public void setPicture2(File picture2) {
		this.picture2 = picture2;
	}
	public File getPicture3() {
		return picture3;
	}
	public void setPicture3(File picture3) {
		this.picture3 = picture3;
	}
	public File getPicture4() {
		return picture4;
	}
	public void setPicture4(File picture4) {
		this.picture4 = picture4;
	}
	public File getPicture5() {
		return picture5;
	}
	public void setPicture5(File picture5) {
		this.picture5 = picture5;
	}
	public File getPicture6() {
		return picture6;
	}
	public void setPicture6(File picture6) {
		this.picture6 = picture6;
	}
	public File getPicture7() {
		return picture7;
	}
	public void setPicture7(File picture7) {
		this.picture7 = picture7;
	}
	public File getPicture8() {
		return picture8;
	}
	public void setPicture8(File picture8) {
		this.picture8 = picture8;
	}
	public File getPicture9() {
		return picture9;
	}
	public void setPicture9(File picture9) {
		this.picture9 = picture9;
	}
	public File getPicture10() {
		return picture10;
	}
	public void setPicture10(File picture10) {
		this.picture10 = picture10;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public String getOption5() {
		return option5;
	}
	public void setOption5(String option5) {
		this.option5 = option5;
	}
	public String getOption6() {
		return option6;
	}
	public void setOption6(String option6) {
		this.option6 = option6;
	}
	public String getOption7() {
		return option7;
	}
	public void setOption7(String option7) {
		this.option7 = option7;
	}
	public String getOption8() {
		return option8;
	}
	public void setOption8(String option8) {
		this.option8 = option8;
	}
	public String getOption9() {
		return option9;
	}
	public void setOption9(String option9) {
		this.option9 = option9;
	}
	public String getOption10() {
		return option10;
	}
	public void setOption10(String option10) {
		this.option10 = option10;
	}
	public List<WvoteVO> getWvoteVOs() {
		return wvoteVOs;
	}
	public void setWvoteVOs(List<WvoteVO> wvoteVOs) {
		this.wvoteVOs = wvoteVOs;
	}

	public List<Woption> getWoptions() {
		return woptions;
	}

	public void setWoptions(List<Woption> woptions) {
		this.woptions = woptions;
	}

	public String getPicture1FileName() {
		return picture1FileName;
	}

	public void setPicture1FileName(String picture1FileName) {
		this.picture1FileName = picture1FileName;
	}

	public String getPicture1ContentType() {
		return picture1ContentType;
	}

	public void setPicture1ContentType(String picture1ContentType) {
		this.picture1ContentType = picture1ContentType;
	}

	public String getPicture2ContentType() {
		return picture2ContentType;
	}

	public void setPicture2ContentType(String picture2ContentType) {
		this.picture2ContentType = picture2ContentType;
	}

	public String getPicture3ContentType() {
		return picture3ContentType;
	}

	public void setPicture3ContentType(String picture3ContentType) {
		this.picture3ContentType = picture3ContentType;
	}

	public String getPicture4ContentType() {
		return picture4ContentType;
	}

	public void setPicture4ContentType(String picture4ContentType) {
		this.picture4ContentType = picture4ContentType;
	}

	public String getPicture5ContentType() {
		return picture5ContentType;
	}

	public void setPicture5ContentType(String picture5ContentType) {
		this.picture5ContentType = picture5ContentType;
	}

	public String getPicture6ContentType() {
		return picture6ContentType;
	}

	public void setPicture6ContentType(String picture6ContentType) {
		this.picture6ContentType = picture6ContentType;
	}

	public String getPicture7ContentType() {
		return picture7ContentType;
	}

	public void setPicture7ContentType(String picture7ContentType) {
		this.picture7ContentType = picture7ContentType;
	}

	public String getPicture8ContentType() {
		return picture8ContentType;
	}

	public void setPicture8ContentType(String picture8ContentType) {
		this.picture8ContentType = picture8ContentType;
	}

	public String getPicture9ContentType() {
		return picture9ContentType;
	}

	public void setPicture9ContentType(String picture9ContentType) {
		this.picture9ContentType = picture9ContentType;
	}

	public String getPicture10ContentType() {
		return picture10ContentType;
	}

	public void setPicture10ContentType(String picture10ContentType) {
		this.picture10ContentType = picture10ContentType;
	}

	public String getPicture2FileName() {
		return picture2FileName;
	}

	public void setPicture2FileName(String picture2FileName) {
		this.picture2FileName = picture2FileName;
	}

	public String getPicture3FileName() {
		return picture3FileName;
	}

	public void setPicture3FileName(String picture3FileName) {
		this.picture3FileName = picture3FileName;
	}

	public String getPicture4FileName() {
		return picture4FileName;
	}

	public void setPicture4FileName(String picture4FileName) {
		this.picture4FileName = picture4FileName;
	}

	public String getPicture5FileName() {
		return picture5FileName;
	}

	public void setPicture5FileName(String picture5FileName) {
		this.picture5FileName = picture5FileName;
	}

	public String getPicture6FileName() {
		return picture6FileName;
	}

	public void setPicture6FileName(String picture6FileName) {
		this.picture6FileName = picture6FileName;
	}

	public String getPicture7FileName() {
		return picture7FileName;
	}

	public void setPicture7FileName(String picture7FileName) {
		this.picture7FileName = picture7FileName;
	}

	public String getPicture8FileName() {
		return picture8FileName;
	}

	public void setPicture8FileName(String picture8FileName) {
		this.picture8FileName = picture8FileName;
	}

	public String getPicture9FileName() {
		return picture9FileName;
	}

	public void setPicture9FileName(String picture9FileName) {
		this.picture9FileName = picture9FileName;
	}

	public String getPicture10FileName() {
		return picture10FileName;
	}

	public void setPicture10FileName(String picture10FileName) {
		this.picture10FileName = picture10FileName;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public String getImage4() {
		return image4;
	}

	public void setImage4(String image4) {
		this.image4 = image4;
	}

	public String getImage5() {
		return image5;
	}

	public void setImage5(String image5) {
		this.image5 = image5;
	}

	public String getImage6() {
		return image6;
	}

	public void setImage6(String image6) {
		this.image6 = image6;
	}

	public String getImage7() {
		return image7;
	}

	public void setImage7(String image7) {
		this.image7 = image7;
	}

	public String getImage8() {
		return image8;
	}

	public void setImage8(String image8) {
		this.image8 = image8;
	}

	public String getImage9() {
		return image9;
	}

	public void setImage9(String image9) {
		this.image9 = image9;
	}

	public String getImage10() {
		return image10;
	}

	public void setImage10(String image10) {
		this.image10 = image10;
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

	public WvoteVO getWvoteVO() {
		return wvoteVO;
	}

	public void setWvoteVO(WvoteVO wvoteVO) {
		this.wvoteVO = wvoteVO;
	}

	public Integer getWoptionid() {
		return woptionid;
	}

	public void setWoptionid(Integer woptionid) {
		this.woptionid = woptionid;
	}

	public Woption getWoption() {
		return woption;
	}

	public void setWoption(Woption woption) {
		this.woption = woption;
	}

	public List<WoptionfrontVO> getWoptionfrontVOs() {
		return woptionfrontVOs;
	}

	public void setWoptionfrontVOs(List<WoptionfrontVO> woptionfrontVOs) {
		this.woptionfrontVOs = woptionfrontVOs;
	}

	public Integer getNumber1() {
		return number1;
	}

	public void setNumber1(Integer number1) {
		this.number1 = number1;
	}

	public Integer getNumber2() {
		return number2;
	}

	public void setNumber2(Integer number2) {
		this.number2 = number2;
	}

	public Integer getNumber3() {
		return number3;
	}

	public void setNumber3(Integer number3) {
		this.number3 = number3;
	}

	public Integer getNumber4() {
		return number4;
	}

	public void setNumber4(Integer number4) {
		this.number4 = number4;
	}

	public Integer getNumber5() {
		return number5;
	}

	public void setNumber5(Integer number5) {
		this.number5 = number5;
	}

	public Integer getNumber6() {
		return number6;
	}

	public void setNumber6(Integer number6) {
		this.number6 = number6;
	}

	public Integer getNumber7() {
		return number7;
	}

	public void setNumber7(Integer number7) {
		this.number7 = number7;
	}

	public Integer getNumber8() {
		return number8;
	}

	public void setNumber8(Integer number8) {
		this.number8 = number8;
	}

	public Integer getNumber9() {
		return number9;
	}

	public void setNumber9(Integer number9) {
		this.number9 = number9;
	}

	public Integer getNumber10() {
		return number10;
	}

	public void setNumber10(Integer number10) {
		this.number10 = number10;
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

	public Integer getPercent7() {
		return percent7;
	}

	public void setPercent7(Integer percent7) {
		this.percent7 = percent7;
	}

	public Integer getPercent8() {
		return percent8;
	}

	public void setPercent8(Integer percent8) {
		this.percent8 = percent8;
	}

	public Integer getPercent9() {
		return percent9;
	}

	public void setPercent9(Integer percent9) {
		this.percent9 = percent9;
	}

	public Integer getPercent10() {
		return percent10;
	}

	public void setPercent10(Integer percent10) {
		this.percent10 = percent10;
	}

	
	
	
}
