package com.jlj.service;

import java.util.List;

import com.jlj.model.Sontype;

public interface ISontypeService {

	public abstract void add(Sontype sontype) throws Exception;

	public abstract void delete(Sontype sontype);

	public abstract void deleteById(int id);

	public abstract void update(Sontype sontype);

	public abstract List<Sontype> getSontypes();

	public abstract Sontype loadById(int id);

	public abstract int getPageCount(int con, String convalue, int status,
			String publicaccount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Sontype> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Sontype> getSontypesByPublicAccount(String paccount,int producttype);

	public abstract List<Sontype> querySontypeByCondition(int btid);

}