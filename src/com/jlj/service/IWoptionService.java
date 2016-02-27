package com.jlj.service;

import java.util.List;

import com.jlj.model.Woption;

public interface IWoptionService {

	public abstract void add(Woption woption) throws Exception;

	public abstract void delete(Woption woption);

	public abstract void deleteById(int id);

	public abstract void update(Woption woption);

	public abstract List<Woption> getWoptions();

	public abstract Woption loadById(int id);

	public abstract int getPageCount(int con, String convalue, int size);

	public abstract int getTotalCount(int con, String convalue);

	public abstract List<Woption> queryList(int con, String convalue, int page,
			int size);

	public abstract List<Woption> queryListBywid(Integer wid);

}