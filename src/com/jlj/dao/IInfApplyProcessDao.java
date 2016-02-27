package com.jlj.dao;

import java.util.List;

import com.jlj.bean.InfApplyProcess;

public interface IInfApplyProcessDao {

	//根据Internal编号查询该记录的是否同意NOTE
	public abstract List<InfApplyProcess> getInfApplyProcessByInternalNo(
			String internalno);

}