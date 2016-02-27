package com.jlj.dao;

import java.util.List;

import com.jlj.model.Fodder;

public interface IFodderDao {

	public abstract void save(Fodder fodder);
	
	public abstract Integer savereturn(Fodder fodder);

	public abstract void delete(Fodder fodder);

	public abstract void deleteById(int id);

	public abstract void update(Fodder fodder);

	public abstract void updateByHql(final String hql,
			final String[] paramNames, final Object[] values);

	public abstract List<Fodder> getFodders();

	public abstract List<Fodder> queryList(String queryString);

	public abstract List<Fodder> getObjectsByCondition(String queryString,
			Object[] p);

	public abstract List<Fodder> queryList(String queryString,
			String[] paramNames, Object[] values);

	public abstract List<Fodder> getObjectsByIdList(final String hql,
			final List<Integer> idList);

	public abstract List<Fodder> pageList(final String queryString,
			final Object[] p, final Integer page, final Integer size);

	public abstract int getUniqueResult(final String queryString,
			final Object[] p);

	public abstract Fodder loadById(int id);

	public abstract Fodder queryByNamedParam(String queryString,
			String[] paramNames, Object[] values);

	public abstract boolean checkClientExistsWithName(String queryString,
			Object[] p);

}