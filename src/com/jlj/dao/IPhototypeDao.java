package com.jlj.dao;

import java.util.List;

import com.jlj.model.Phototype;

public interface IPhototypeDao {

	public abstract void save(Phototype phototype);

	public abstract void delete(Phototype phototype);

	public abstract void deleteById(int id);

	public abstract void update(Phototype phototype);

	public abstract void updateByHql(final String hql,
			final String[] paramNames, final Object[] values);

	public abstract List<Phototype> getPhototypes();

	public abstract List<Phototype> queryList(String queryString);

	public abstract List<Phototype> getObjectsByCondition(String queryString,
			Object[] p);

	public abstract List<Phototype> queryList(String queryString,
			String[] paramNames, Object[] values);

	public abstract List<Phototype> getObjectsByIdList(final String hql,
			final List<Integer> idList);

	public abstract List<Phototype> pageList(final String queryString,
			final Object[] p, final Integer page, final Integer size);

	public abstract int getUniqueResult(final String queryString,
			final Object[] p);

	public abstract Phototype loadById(int id);

	public abstract Phototype queryByNamedParam(String queryString,
			String[] paramNames, Object[] values);

	public abstract boolean checkClientExistsWithName(String queryString,
			Object[] p);

}