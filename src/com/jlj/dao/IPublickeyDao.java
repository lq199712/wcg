package com.jlj.dao;

import java.util.List;

import com.jlj.model.Publickey;

public interface IPublickeyDao {

	public abstract void save(Publickey publickey);

	public abstract void delete(Publickey publickey);

	public abstract void deleteById(int id);

	public abstract void update(Publickey publickey);

	public abstract void updateByHql(final String hql,
			final String[] paramNames, final Object[] values);

	public abstract List<Publickey> getPublickeys();

	public abstract List<Publickey> queryList(String queryString);

	public abstract List<Publickey> getObjectsByCondition(String queryString,
			Object[] p);

	public abstract List<Publickey> queryList(String queryString,
			String[] paramNames, Object[] values);

	public abstract List<Publickey> getObjectsByIdList(final String hql,
			final List<Integer> idList);

	public abstract List<Publickey> pageList(final String queryString,
			final Object[] p, final Integer page, final Integer size);

	public abstract int getUniqueResult(final String queryString,
			final Object[] p);

	public abstract Publickey loadById(int id);

	public abstract Publickey queryByNamedParam(String queryString,
			String[] paramNames, Object[] values);

	public abstract boolean checkClientExistsWithName(String queryString,
			Object[] p);

}