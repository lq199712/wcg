package com.jlj.dao;

import java.util.List;

import com.jlj.bean.InfApply;

public interface IInfApplyDao {

	//根据内容中的编号查询该记录的编号、内容以及事务名
	public abstract List<InfApply> getInfApplysByContentId(String contentId);

}