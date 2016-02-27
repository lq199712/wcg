package com.jlj.dao;

import java.util.List;

import com.jlj.model.Renovation;

public interface IRenovationDao {

	public abstract void save(Renovation renovation);

	public abstract void delete(Renovation renovation);

	public abstract void deleteById(int id);

	public abstract void update(Renovation renovation);

	public abstract void updateByHql(final String hql,
			final String[] paramNames, final Object[] values);

	public abstract List<Renovation> getRenovations();

	public abstract List<Renovation> queryList(String queryString);

	public abstract List<Renovation> getObjectsByCondition(String queryString,
			Object[] p);

	public abstract List<Renovation> queryList(String queryString,
			String[] paramNames, Object[] values);

	public abstract List<Renovation> getObjectsByIdList(final String hql,
			final List<Integer> idList);

	public abstract List<Renovation> pageList(final String queryString,
			final Object[] p, final Integer page, final Integer size);

	public abstract int getUniqueResult(final String queryString,
			final Object[] p);

	public abstract Renovation loadById(int id);

	public abstract Renovation queryByNamedParam(String queryString,
			String[] paramNames, Object[] values);

	public abstract boolean checkClientExistsWithName(String queryString,
			Object[] p);

}