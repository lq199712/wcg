package com.jlj.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.text.ParseException;
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

import com.jlj.model.Renovation;
import com.jlj.service.IRenovationService;
import com.jlj.util.DateTimeKit;
import com.opensymphony.xwork2.ActionSupport;

@Component("renovationAction")
@Scope("prototype")
public class RenovationAction extends ActionSupport implements RequestAware,
		SessionAware, ServletResponseAware, ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private IRenovationService renovationService;
	Map<String, Object> request;
	Map<String, Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	// 单个对象
	private int id;
	private Renovation renovation;
	// 分页显示
	private String[] arg = new String[2];
	private List<Renovation> renovations;
	private int page;
	private final int size = 10;
	private int pageCount;
	private int totalCount;
	private int status;// 按状态
	private int pid;// 按用户id
	private String publicaccount;// 公众号原始ID
	// 条件
	private int con;
	private String convalue;
	private String frontpa;

	// =========后台首页类别=================================================
	/**
	 * 首页类别管理
	 */
	public String list() throws Exception {
		if (convalue != null && !convalue.equals("")) {
			convalue = URLDecoder.decode(convalue, "utf-8");
		}
		if (page < 1) {
			page = 1;
		}
		// 总页数
		pageCount = renovationService.getPageCount(con, convalue, size);
		if (page > pageCount && pageCount != 0) {
			page = pageCount;
		}
		// 所有当前页记录对象
		renovations = renovationService.queryList(con, convalue, page, size);
		// 总记录数
		totalCount = renovationService.getTotalCount(con, convalue);
		return "list";

	}

	/**
	 * 跳转到添加页面
	 * 
	 * @return
	 */
	public String goToAdd() {
		return "add";
	}

	/**
	 * 添加
	 * 
	 * @return
	 * @throws Exception
	 */

	public String add() throws Exception {

		if (picture1 != null && picture1FileName != null
				&& !picture1FileName.replace(" ", "").equals("")) {
			String imageName = DateTimeKit.getDateRandom()
					+ picture1FileName.substring(picture1FileName.indexOf("."));
			this.upload("/disappearman", imageName, picture1);
			renovation.setImage1("disappearman" + "/" + imageName);
		}
		if (picture2 != null && picture2FileName != null
				&& !picture2FileName.replace(" ", "").equals("")) {
			String imageName = DateTimeKit.getDateRandom()
					+ picture2FileName.substring(picture2FileName.indexOf("."));
			this.upload("/disappearman", imageName, picture2);
			renovation.setImage2("renovation" + "/" + imageName);
		}
		renovation.setRenostate(0);// 新增默认整改状态为 0：未办理 1：办理中 2：已办理
		renovationService.add(renovation);
		arg[0] = "renovationAction!list";
		arg[1] = "整改管理";
		return SUCCESS;
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public String delete() {
		Renovation renovation = renovationService.loadById(id);
		// 删除图片
		if (renovation.getImage1() != null
				&& !renovation.getImage1().replace(" ", "").equals("")) {
			File photofile = new File(ServletActionContext.getServletContext()
					.getRealPath("/")
					+ renovation.getImage1());
			photofile.delete();
		}
		if (renovation.getImage2() != null
				&& !renovation.getImage2().replace(" ", "").equals("")) {
			File photofile = new File(ServletActionContext.getServletContext()
					.getRealPath("/")
					+ renovation.getImage2());
			photofile.delete();
		}
		renovationService.delete(renovation);
		arg[0] = "renovationAction!list";
		arg[1] = "整改管理";
		return SUCCESS;
	}

	/**
	 * 修改
	 * 
	 * @return
	 */
	public String update() throws Exception {
		if (picture1 != null && picture1FileName != null
				&& !picture1FileName.replace(" ", "").equals("")) {
			String imageName = DateTimeKit.getDateRandom()
					+ picture1FileName.substring(picture1FileName.indexOf("."));
			this.upload("/renovation", imageName, picture1);
			File photofile = new File(ServletActionContext.getServletContext()
					.getRealPath("/")
					+ renovation.getImage1());
			photofile.delete();
			renovation.setImage1("renovation" + "/" + imageName);
		}
		if (picture2 != null && picture2FileName != null
				&& !picture2FileName.replace(" ", "").equals("")) {
			String imageName = DateTimeKit.getDateRandom()
					+ picture2FileName.substring(picture2FileName.indexOf("."));
			this.upload("/renovation", imageName, picture2);
			File photofile = new File(ServletActionContext.getServletContext()
					.getRealPath("/")
					+ renovation.getImage2());
			photofile.delete();
			renovation.setImage2("renovation" + "/" + imageName);
		}
		renovationService.update(renovation);
		arg[0] = "renovationAction!list";
		arg[1] = "整改管理";
		return SUCCESS;
	}

	/**
	 * 查看信息
	 * 
	 * @return
	 */
	public String view() {
		renovation = renovationService.loadById(id);
		return "view";
	}

	/**
	 * 跳转到修改页面
	 * 
	 * @return
	 */
	public String load() throws Exception {
		renovation = renovationService.loadById(id);
		return "load";
	}

	/**
	 * 跳转到投诉查询
	 */
	public String toQuery() {
		return "query";
	}

	/**
	 * 修改状态
	 */
	private int renostate;

	public String changeRenostate() {
		renovation = renovationService.loadById(id);
		renovation.setRenostate(renostate);
		renovationService.update(renovation);
		return null;
	}

	/**
	 * front 前台添加
	 */

	public String goToRenovation() {
		return "renovation";
	}

	// 上传照片
	private File picture2;
	private File picture1;
	private String picture2ContentType;
	private String picture1ContentType;
	private String picture2FileName;
	private String picture1FileName;

	// 文件上传
	public void upload(String fileName, String imageName, File picture)
			throws Exception {
		File saved = new File(ServletActionContext.getServletContext()
				.getRealPath(fileName), imageName);
		InputStream ins = null;
		OutputStream ous = null;
		try {
			saved.getParentFile().mkdirs();
			ins = new FileInputStream(picture);
			ous = new FileOutputStream(saved);
			byte[] b = new byte[1024];
			int len = 0;
			while ((len = ins.read(b)) != -1) {
				ous.write(b, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ous != null)
				ous.close();
			if (ins != null)
				ins.close();
		}
	}

	/**
	 * 前端
	 */
	private int ftype;

	public String frontList() throws ParseException {
		switch (ftype) {
		case 0:
			//所有
			renovations = renovationService.getRenovations();
			break;
		case 1:
			//今日
			String today = DateTimeKit.getLocalDay();
			String tomorrow = DateTimeKit.dayBeforethis(today, -1);//1天之后的时间
			renovations = renovationService.queryListByToday(today,tomorrow);
			break;
		case 2:
			//已解决
			int renostate = 2;
			renovations = renovationService.queryListByRenostate(renostate);
		default:
			break;
		}
		return "frontList";
	}

	// 获得HttpServletResponse对象
	public void setServletResponse(HttpServletResponse response) {
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

	public File getPicture2() {
		return picture2;
	}

	public void setPicture2(File picture2) {
		this.picture2 = picture2;
	}

	public String getPicture2ContentType() {
		return picture2ContentType;
	}

	public void setPicture2ContentType(String picture2ContentType) {
		this.picture2ContentType = picture2ContentType;
	}

	public String getPicture2FileName() {
		return picture2FileName;
	}

	public void setPicture2FileName(String picture2FileName) {
		this.picture2FileName = picture2FileName;
	}

	public String getFrontpa() {
		return frontpa;
	}

	public void setFrontpa(String frontpa) {
		this.frontpa = frontpa;
	}

	public IRenovationService getRenovationService() {
		return renovationService;
	}

	@Resource
	public void setRenovationService(IRenovationService renovationService) {
		this.renovationService = renovationService;
	}

	public Renovation getRenovation() {
		return renovation;
	}

	public void setRenovation(Renovation renovation) {
		this.renovation = renovation;
	}

	public List<Renovation> getRenovations() {
		return renovations;
	}

	public void setRenovations(List<Renovation> renovations) {
		this.renovations = renovations;
	}

	public File getPicture1() {
		return picture1;
	}

	public void setPicture1(File picture1) {
		this.picture1 = picture1;
	}

	public String getPicture1ContentType() {
		return picture1ContentType;
	}

	public void setPicture1ContentType(String picture1ContentType) {
		this.picture1ContentType = picture1ContentType;
	}

	public String getPicture1FileName() {
		return picture1FileName;
	}

	public void setPicture1FileName(String picture1FileName) {
		this.picture1FileName = picture1FileName;
	}

	public int getRenostate() {
		return renostate;
	}

	public void setRenostate(int renostate) {
		this.renostate = renostate;
	}

	public int getFtype() {
		return ftype;
	}

	public void setFtype(int ftype) {
		this.ftype = ftype;
	}

}
