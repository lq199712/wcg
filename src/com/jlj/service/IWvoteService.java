package com.jlj.service;

import java.util.List;

import com.jlj.model.Wvote;

public interface IWvoteService {

	public abstract void add(Wvote wvote) throws Exception;

	public abstract void delete(Wvote wvote);

	public abstract void deleteById(int id);

	public abstract void update(Wvote wvote);

	public abstract List<Wvote> getWvotes();

	public abstract Wvote loadById(int id);

	public abstract int getPageCount(int con, String convalue, int size);

	public abstract int getTotalCount(int con, String convalue);

	public abstract List<Wvote> queryList(int con, String convalue, int page,
			int size);

	public abstract Wvote getWvoteById(Integer id);

}