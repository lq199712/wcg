package com.jlj.service;

import java.util.List;

import com.jlj.model.Addressbook;

public interface IAddressbookService {

	public abstract void add(Addressbook addressbook) throws Exception;

	public abstract void delete(Addressbook addressbook);

	public abstract void deleteById(int id);

	public abstract void update(Addressbook addressbookbook);

	public abstract List<Addressbook> getAddressbooks();

	public abstract Addressbook loadById(int id);

	public abstract int getPageCount(int con, String convalue, int status,
			String publicaccount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Addressbook> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract Addressbook queryByPublicaccount(String publicaccount);

	public abstract int getPageCount(int con, String convalue, int size);

	public abstract List<Addressbook> queryList(int con, String convalue,
			int page, int size);

	public abstract int getTotalCount(int con, String convalue);

}