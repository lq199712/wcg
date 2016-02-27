package com.jlj.service;

import java.util.List;

import com.jlj.model.Resmessage;

public interface IResmessageService {

	public abstract void add(Resmessage resmessage) throws Exception;

	public abstract void delete(Resmessage resmessage);

	public abstract void deleteById(int id);

	public abstract void update(Resmessage resmessage);

	public abstract List<Resmessage> getResmessages();

	public abstract Resmessage loadById(int id);

	public abstract int getPageCount(int con, String convalue, int status,
			String publicaccount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Resmessage> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Resmessage> getResmessagesByPublicAccount(
			String paccount);

}