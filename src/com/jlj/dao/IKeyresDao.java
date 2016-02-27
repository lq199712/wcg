package com.jlj.dao;

import java.util.List;

import com.jlj.model.Keyres;

public interface IKeyresDao {

	public abstract void save(Keyres keyres);

	public abstract void delete(Keyres keyres);

	public abstract void deleteById(int id);

	public abstract void update(Keyres keyres);

	public abstract void updateByHql(final String hql,
			final String[] paramNames, final Object[] values);

	public abstract List<Keyres> getKeyress();

	public abstract List<Keyres> queryList(String queryString);

	public abstract List<Keyres> getObjectsByCondition(String queryString,
			Object[] p);

	public abstract List<Keyres> queryList(String queryString,
			String[] paramNames, Object[] values);

	public abstract List<Keyres> getObjectsByIdList(final String hql,
			final List<Integer> idList);

	public abstract List<Keyres> pageList(final String queryString,
			final Object[] p, final Integer page, final Integer size);

	public abstract int getUniqueResult(final String queryString,
			final Object[] p);

	public abstract Keyres loadById(int id);

	public abstract Keyres queryByNamedParam(String queryString,
			String[] paramNames, Object[] values);

	public abstract boolean checkClientExistsWithName(String queryString,
			Object[] p);

}