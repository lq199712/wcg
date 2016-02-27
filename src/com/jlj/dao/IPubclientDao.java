package com.jlj.dao;

import java.util.List;

import com.jlj.model.Pubclient;

public interface IPubclientDao {

	public abstract boolean checkClientExistsWithName(String queryString, Object[] p);

	public abstract List<Pubclient> getPubclients();

	public abstract Pubclient loadById(int id);

	public abstract void save(Pubclient pubclient);

	public abstract Pubclient queryByNamedParam(String queryString,
			String[] paramNames, Object[] values);

	public abstract List<Pubclient> queryList(String queryString);

	public abstract void update(Pubclient pubclient);

	public abstract void delete(Pubclient pubclient);

	public abstract void deleteById(int id);

	public abstract List<Pubclient> pageList(final String queryString,
			final Object[] p, final Integer page, final Integer size);

	public abstract int getUniqueResult(final String queryString,
			final Object[] p);

	public abstract List<Pubclient> queryList(String queryString,
			String[] paramNames, Object[] values);

	public abstract void updateByHql(final String hql,
			final String[] paramNames, final Object[] values);

	public abstract List<Pubclient> getObjectsByCondition(String queryString,
			Object[] p);

	public abstract List<Pubclient> getObjectsByIdList(final String hql,
			final List<Integer> idList);

}