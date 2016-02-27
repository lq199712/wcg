package com.jlj.dao;

import java.util.List;

import com.jlj.model.Screenimg;

public interface IScreenimgDao {

	public abstract void save(Screenimg screenimg);

	public abstract void delete(Screenimg screenimg);

	public abstract void deleteById(int id);

	public abstract void update(Screenimg screenimg);

	public abstract void updateByHql(final String hql,
			final String[] paramNames, final Object[] values);

	public abstract List<Screenimg> getScreenimgs();

	public abstract List<Screenimg> queryList(String queryString);

	public abstract List<Screenimg> getObjectsByCondition(String queryString,
			Object[] p);

	public abstract List<Screenimg> queryList(String queryString,
			String[] paramNames, Object[] values);

	public abstract List<Screenimg> getObjectsByIdList(final String hql,
			final List<Integer> idList);

	public abstract List<Screenimg> pageList(final String queryString,
			final Object[] p, final Integer page, final Integer size);

	public abstract int getUniqueResult(final String queryString,
			final Object[] p);

	public abstract Screenimg loadById(int id);

	public abstract Screenimg queryByNamedParam(String queryString,
			String[] paramNames, Object[] values);

	public abstract boolean checkClientExistsWithName(String queryString,
			Object[] p);

}