package com.jlj.service;

import java.util.List;

import com.jlj.model.Renovation;

public interface IRenovationService {

	public abstract void add(Renovation renovation) throws Exception;

	public abstract void delete(Renovation renovation);

	public abstract void deleteById(int id);

	public abstract void update(Renovation renovation);

	public abstract List<Renovation> getRenovations();

	public abstract Renovation loadById(int id);

	public abstract int getPageCount(int con, String convalue, int status,
			String publicaccount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Renovation> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Renovation> queryListByPublicAccount(String publicaccount);

	public abstract List<Renovation> queryList(String ip);

	public abstract int getPageCount(int con, String convalue, int size);

	public abstract List<Renovation> queryList(int con, String convalue,
			int page, int size);

	public abstract int getTotalCount(int con, String convalue);

	public abstract List<Renovation> queryList(int comptype, String comptime,
			String name);

	public abstract List<Renovation> queryListByRenostate(int renostate);

	public abstract List<Renovation> queryListByToday(String today, String tomorrow);

}