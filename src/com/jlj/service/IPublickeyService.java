package com.jlj.service;

import java.util.List;

import com.jlj.model.Publickey;

public interface IPublickeyService {

	public abstract void add(Publickey publickey) throws Exception;

	public abstract void delete(Publickey publickey);

	public abstract void deleteById(int id);

	public abstract void update(Publickey publickey);

	public abstract List<Publickey> getPublickeys();

	public abstract Publickey loadById(int id);

	public abstract int getPageCount(int con, String convalue, int status,
			String publicaccount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Publickey> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Publickey> queryListByPublicAccount(
			String publicaccount);

}