package com.jlj.service;

import java.util.List;

import com.jlj.bean.InfApply;

public interface IInfApplyService {

	public abstract List<InfApply> getInfApplysByContentId(String contentId);

}