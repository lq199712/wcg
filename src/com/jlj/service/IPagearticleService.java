package com.jlj.service;

import java.util.List;

import com.jlj.model.Pagearticle;

public interface IPagearticleService {

	public abstract void add(Pagearticle pagearticle) throws Exception;

	public abstract void delete(Pagearticle pagearticle);

	public abstract void deleteById(int id);

	public abstract void update(Pagearticle pagearticle);

	public abstract List<Pagearticle> getPagearticles();

	public abstract Pagearticle loadById(int id);

	public abstract int getPageCount(int con, String convalue, int status,
			String publicaccount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Pagearticle> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract int getFrontPageCount(int stid, int size);

	public abstract List<Pagearticle> queryFrontList(int stid, int page,
			int size);

	public abstract int getFrontTotalCount(int stid);

	public abstract List<Pagearticle> queryFrontIndexList(String frontpa,int isshow, int page,
			int psize);

	public abstract Pagearticle queryPagearticleById(int id);

}