package com.jlj.service.imp;

import java.util.List;

import com.jlj.bean.InfApply;
import com.jlj.dao.IInfApplyDao;
import com.jlj.dao.imp.InfApplyDaoImp;
import com.jlj.service.IInfApplyService;

public class InfApplyServiceImp implements IInfApplyService {
	IInfApplyDao infApplyDao = new InfApplyDaoImp();
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IInfApplyService#getInfApplysByContentId(java.lang.String)
	 */
	public List<InfApply> getInfApplysByContentId(String contentId){
		return infApplyDao.getInfApplysByContentId(contentId);
	}
}
