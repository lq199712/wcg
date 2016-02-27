package com.jlj.service;

import java.util.List;

import com.jlj.model.Autores;

public interface IAutoresService {

	public abstract void add(Autores autores) throws Exception;

	public abstract void delete(Autores autores);

	public abstract void deleteById(int id);

	public abstract void update(Autores autores);

	public abstract List<Autores> getAutoress();

	public abstract Autores loadById(int id);

	public abstract int getPageCount(int con, String convalue, int status,
			String publicaccount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Autores> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Autores> queryListByPublicAccount(String publicaccount);

}