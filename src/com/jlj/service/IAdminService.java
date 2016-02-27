package com.jlj.service;

import java.util.List;

import com.jlj.model.Admin;

public interface IAdminService {

	public abstract void add(Admin admin) throws Exception;

	public abstract void delete(Admin admin);

	public abstract void deleteById(int id);

	public abstract void update(Admin admin);

	public abstract List<Admin> getAdmins();

	public abstract Admin loadById(int id);

	public abstract int getPageCount(int con, String convalue, int size);

	public abstract int getTotalCount(int con, String convalue);

	public abstract List<Admin> queryList(int con, String convalue, int page,
			int size);

	public abstract Admin userlogin(String username, String password);

	public abstract void updatePwd(String newpwd, Integer id);

}