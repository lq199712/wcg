package com.jlj.dao;

import java.util.List;

import com.jlj.model.Autores;

public interface IAutoresDao {

	public abstract void save(Autores autores);

	public abstract void delete(Autores autores);

	public abstract void deleteById(int id);

	public abstract void update(Autores autores);

	public abstract void updateByHql(final String hql,
			final String[] paramNames, final Object[] values);

	public abstract List<Autores> getAutoress();

	public abstract List<Autores> queryList(String queryString);

	public abstract List<Autores> getObjectsByCondition(String queryString,
			Object[] p);

	public abstract List<Autores> queryList(String queryString,
			String[] paramNames, Object[] values);

	public abstract List<Autores> getObjectsByIdList(final String hql,
			final List<Integer> idList);

	public abstract List<Autores> pageList(final String queryString,
			final Object[] p, final Integer page, final Integer size);

	public abstract int getUniqueResult(final String queryString,
			final Object[] p);

	public abstract Autores loadById(int id);

	public abstract Autores queryByNamedParam(String queryString,
			String[] paramNames, Object[] values);

	public abstract boolean checkClientExistsWithName(String queryString,
			Object[] p);

}