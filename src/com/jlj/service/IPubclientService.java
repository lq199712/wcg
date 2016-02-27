package com.jlj.service;

import java.util.List;

import com.jlj.model.Pubclient;

public interface IPubclientService {

	public abstract void add(Pubclient pubclient) throws Exception;

	public abstract void delete(Pubclient pubclient);

	public abstract void deleteById(int id);

	public abstract void update(Pubclient pubclient);

	public abstract void updatePwd(String newpwd, Integer id);

	public abstract List<Pubclient> getPubclients();

	public abstract boolean exists(String username) throws Exception;

	public abstract Pubclient loadById(int id);

	public abstract Pubclient userlogin(String username, String password);

	public abstract int getPageCount(int con, String convalue, int status,
			int pid, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			int pid);

	public abstract List<Pubclient> queryList(int con, String convalue,
			int status, int pid, int page, int size);

	public abstract List<Pubclient> queryList(int depid);

	public abstract List<Pubclient> queryList(int con, String convalue,
			int depid);

	public abstract Pubclient queryPubclientByFrontpa(String frontpa);

}