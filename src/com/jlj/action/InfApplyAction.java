package com.jlj.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jlj.bean.InfApply;
import com.jlj.bean.InfApplyProcess;
import com.jlj.service.IInfApplyProcessService;
import com.jlj.service.IInfApplyService;
import com.jlj.service.imp.InfApplyProcessServiceImp;
import com.jlj.service.imp.InfApplyServiceImp;
import com.jlj.vo.InfApplyVO;
import com.opensymphony.xwork2.ActionSupport;

@Component("infApplyAction")
@Scope("prototype")
public class InfApplyAction extends ActionSupport implements RequestAware,
SessionAware,ServletResponseAware,ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private IInfApplyService infApplyService = new InfApplyServiceImp();
	private IInfApplyProcessService infApplyProcessService = new InfApplyProcessServiceImp();
	Map<String,Object> request;
	Map<String,Object> session;
	private javax.servlet.http.HttpServletResponse response;
	private javax.servlet.http.HttpServletRequest req;
	private InfApplyVO infApplyVO;
	private String spnumber;
	/**
	 * 户外广告申请查询
	 * @return
	 */
	public String queryInfApply(){
//		List<InfApply> infApplys = infApplyService.getInfApplysByContentId(spnumber);
//		if(infApplys!=null&&infApplys.size()>0){
//			//获取申请查询结果值
//			InfApply infApply = infApplys.get(0);
//			String internalNo = infApply.getInternalNo();
//			String transactAffairName=infApply.getTransactAffairName();
//			String content=infApply.getContent();
//			String note = "";
//			List<InfApplyProcess> infApplyProcesses = infApplyProcessService.getInfApplyProcessByInternalNo(internalNo);
//			if(infApplyProcesses!=null&&infApplyProcesses.size()>0){
//				InfApplyProcess infApplyProcess = infApplyProcesses.get(0);
//				note = infApplyProcess.getNote();
//			}
//			infApplyVO = new InfApplyVO();
//			infApplyVO.setInternalNo(internalNo);
//			infApplyVO.setTransactAffairName(transactAffairName);
//			infApplyVO.setContent(content);
//			infApplyVO.setNote(note);
//			
//			return "xkzResult";
//		}else{
//			String result = "未查询到该审批编号";
//			return "xkzResult";
//		}

		if(spnumber==null||spnumber.equals("")){
			String result = "请输入相关内容";
			return "xkzResult";
		}
		List<InfApply> infApplys = infApplyService.getInfApplysByContentId(spnumber);
		if(infApplys!=null&&infApplys.size()>0){
			//获取申请查询结果值
			InfApply infApply = infApplys.get(0);
			String internalNo = infApply.getInternalNo();
			String transactAffairName=infApply.getTransactAffairName();
			String content=infApply.getContent();
			String note = "";
//			System.out.println(internalNo);
			List<InfApplyProcess> infApplyProcesses = infApplyProcessService.getInfApplyProcessByInternalNo(internalNo);
//			System.out.println(infApplyProcesses.size());
			if(infApplyProcesses!=null&&infApplyProcesses.size()>0){
				InfApplyProcess infApplyProcess = infApplyProcesses.get(0);
				note = infApplyProcess.getNote();
//				System.out.println(note);
			}
			infApplyVO = new InfApplyVO();
			infApplyVO.setInternalNo(internalNo);
			infApplyVO.setTransactAffairName(transactAffairName);
			infApplyVO.setContent(content);
			infApplyVO.setNote(note);
			
			return "xkzResult";
		}else{
			String result = "未查询到该内容";
			return "xkzResult";
		}
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

	public InfApplyVO getInfApplyVO() {
		return infApplyVO;
	}

	public void setInfApplyVO(InfApplyVO infApplyVO) {
		this.infApplyVO = infApplyVO;
	}

	public String getSpnumber() {
		return spnumber;
	}

	public void setSpnumber(String spnumber) {
		this.spnumber = spnumber;
	}
    
	
	
}
