package com.jlj.service.imp;

import java.util.List;

import com.jlj.bean.InfApply;
import com.jlj.bean.InfApplyProcess;
import com.jlj.dao.IInfApplyProcessDao;
import com.jlj.dao.imp.InfApplyProcessDaoImp;
import com.jlj.service.IInfApplyProcessService;

public class InfApplyProcessServiceImp implements IInfApplyProcessService {
	IInfApplyProcessDao infApplyProcessDao = new InfApplyProcessDaoImp();
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IInfApplyService#getInfApplysByContentId(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IInfApplyProcessService#getInfApplyProcessByInternalNo(java.lang.String)
	 */
	public List<InfApplyProcess> getInfApplyProcessByInternalNo(String internalno){
		return infApplyProcessDao.getInfApplyProcessByInternalNo(internalno);
	}
}
