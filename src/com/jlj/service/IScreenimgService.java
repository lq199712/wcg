package com.jlj.service;

import java.util.List;

import com.jlj.model.Screenimg;

public interface IScreenimgService {

	public abstract void add(Screenimg screenimg) throws Exception;

	public abstract void delete(Screenimg screenimg);

	public abstract void deleteById(int id);

	public abstract void update(Screenimg screenimg);

	public abstract List<Screenimg> getScreenimgs();

	public abstract Screenimg loadById(int id);

	public abstract List<Screenimg> getScreenimgsByPublicaccount(
			String publicaccount);

	public abstract List<Screenimg> getScreenimgsByCondition(int imgtype,
			String publicaccount);

}