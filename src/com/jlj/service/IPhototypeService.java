package com.jlj.service;

import java.util.List;

import com.jlj.model.Phototype;

public interface IPhototypeService {

	public abstract void add(Phototype phototype) throws Exception;

	public abstract void delete(Phototype phototype);

	public abstract void deleteById(int id);

	public abstract void update(Phototype phototype);

	public abstract List<Phototype> getPhototypes();

	public abstract Phototype loadById(int id);

	public abstract int getPageCount(int con, String convalue, int status,
			String publicaccount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Phototype> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Phototype> getPhototypesByPublicAccount(String publicaccount);

}