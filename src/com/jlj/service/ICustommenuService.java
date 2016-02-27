package com.jlj.service;

import java.util.List;

import com.jlj.model.Custommenu;

public interface ICustommenuService {

	public abstract void add(Custommenu custommenu) throws Exception;

	public abstract void delete(Custommenu custommenu);

	public abstract void deleteById(int id);

	public abstract void update(Custommenu custommenu);

	public abstract List<Custommenu> getCustommenus();

	public abstract Custommenu loadById(int id);

	public abstract int getPageCount(int con, String convalue, int status,
			String publicaccount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Custommenu> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Custommenu> getCustommenusByPublicAccount(
			String paccount);

	public abstract Custommenu queryCustommenuByPublicAccount(String paccount);

}