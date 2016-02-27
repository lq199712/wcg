package com.jlj.service;

import java.util.List;

import com.jlj.model.Prizer;


public interface IPrizerService {

	public abstract void add(Prizer prizer) throws Exception;

	public abstract void delete(Prizer prizer);

	public abstract void deleteById(int id);

	public abstract void update(Prizer prizer);

	public abstract List<Prizer> getPrizers();

	public abstract Prizer loadById(int id);


	public abstract List<Prizer> getBigtypesByPublicAccount(String paccount);

	public abstract int getPageCount(int con, String convalue, int status,
			String publicaccount, int size, int bid);

	public abstract List<Prizer> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size, int bid);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount, int bid);

	public abstract List<Prizer> queryList(int mid, int id);

}