package com.jlj.dao;

import java.util.List;

import com.jlj.model.Sontype;

public interface ISontypeDao {

	public abstract void save(Sontype sontype);

	public abstract void delete(Sontype sontype);

	public abstract void deleteById(int id);

	public abstract void update(Sontype sontype);

	public abstract void updateByHql(final String hql,
			final String[] paramNames, final Object[] values);

	public abstract List<Sontype> getSontypes();

	public abstract List<Sontype> queryList(String queryString);

	public abstract List<Sontype> getObjectsByCondition(String queryString,
			Object[] p);

	public abstract List<Sontype> queryList(String queryString,
			String[] paramNames, Object[] values);

	public abstract List<Sontype> getObjectsByIdList(final String hql,
			final List<Integer> idList);

	public abstract List<Sontype> pageList(final String queryString,
			final Object[] p, final Integer page, final Integer size);

	public abstract int getUniqueResult(final String queryString,
			final Object[] p);

	public abstract Sontype loadById(int id);

	public abstract Sontype queryByNamedParam(String queryString,
			String[] paramNames, Object[] values);

	public abstract boolean checkClientExistsWithName(String queryString,
			Object[] p);

}