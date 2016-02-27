package com.jlj.service;

import java.util.List;

import com.jlj.bean.InfApplyProcess;

public interface IInfApplyProcessService {

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IInfApplyService#getInfApplysByContentId(java.lang.String)
	 */
	public abstract List<InfApplyProcess> getInfApplyProcessByInternalNo(
			String internalno);

}