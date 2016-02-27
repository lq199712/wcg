package com.jlj.service;

import java.util.List;

import com.jlj.model.Keyres;

public interface IKeyresService {

	public abstract void add(Keyres keyres) throws Exception;

	public abstract void delete(Keyres keyres);

	public abstract void deleteById(int id);

	public abstract void update(Keyres keyres);

	public abstract List<Keyres> getKeyress();

	public abstract Keyres loadById(int id);

	public abstract int getPageCountByPkid(int con, String convalue,
			int status, int pkid, int size);

	public abstract int getTotalCountByPkid(int con, String convalue,
			int status, int pkid);

	public abstract List<Keyres> queryListByPkid(int con, String convalue,
			int status, int pkid, int page, int size);

}