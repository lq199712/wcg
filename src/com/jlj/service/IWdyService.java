package com.jlj.service;

import java.util.List;

import com.jlj.model.Wdy;

public interface IWdyService {

	public abstract void add(Wdy wdy) throws Exception;

	public abstract void delete(Wdy wdy);

	public abstract void deleteById(int id);

	public abstract void update(Wdy wdy);

	public abstract List<Wdy> getWdys();

	public abstract Wdy loadById(int id);

	public abstract int getPageCount(int con, String convalue, int size);

	public abstract int getTotalCount(int con, String convalue);

	public abstract List<Wdy> queryList(int con, String convalue, int page,
			int size);

	public abstract List<Wdy> queryListBywid(Integer wid);

}