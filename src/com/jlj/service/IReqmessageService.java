package com.jlj.service;

import java.util.List;

import com.jlj.model.Reqmessage;

public interface IReqmessageService {

	public abstract void add(Reqmessage reqmessage) throws Exception;

	public abstract void delete(Reqmessage reqmessage);

	public abstract void deleteById(int id);

	public abstract void update(Reqmessage reqmessage);

	public abstract List<Reqmessage> getReqmessages();

	public abstract Reqmessage loadById(int id);

	public abstract int getPageCount(int con, String convalue, int status,
			String publicaccount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Reqmessage> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Reqmessage> getReqmessagesByPublicAccount(
			String paccount);

}