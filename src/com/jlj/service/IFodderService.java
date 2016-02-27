package com.jlj.service;

import java.util.List;

import com.jlj.model.Fodder;

public interface IFodderService {

	public abstract void add(Fodder fodder) throws Exception;
	
	public abstract int addreturn(Fodder fodder) throws Exception;

	public abstract void delete(Fodder fodder);

	public abstract void deleteById(int id);

	public abstract void update(Fodder fodder);

	public abstract List<Fodder> getFodders();

	public abstract Fodder loadById(int id);

	public abstract int getPageCount(int con, String convalue, int status,
			String publicaccount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Fodder> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract void updateArticleCount(int articlecount, int fodderid);

	public abstract List<Fodder> querySavetypeList(int con, String convalue,
			int status, String publicaccount);

	public abstract int getSavetypeTotalCount(int con, String convalue,
			int status, String publicaccount);

	public abstract List<Fodder> getFoddersByPublicAccount(String paccount);

}