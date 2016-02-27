package com.jlj.service;

import java.util.List;

import com.jlj.model.Footer;

public interface IFooterService {

	public abstract void add(Footer footer) throws Exception;

	public abstract void delete(Footer footer);

	public abstract void deleteById(int id);

	public abstract void update(Footer footer);

	public abstract List<Footer> getFooters();

	public abstract Footer loadById(int id);

	public abstract int getPageCount(int con, String convalue, int status,
			String publicaccount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Footer> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract Footer queryByPublicaccount(String publicaccount);

}