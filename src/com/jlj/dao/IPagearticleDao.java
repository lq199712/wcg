package com.jlj.dao;

import java.util.List;

import com.jlj.model.Pagearticle;

public interface IPagearticleDao {

	public abstract void save(Pagearticle pagearticle);

	public abstract void delete(Pagearticle pagearticle);

	public abstract void deleteById(int id);

	public abstract void update(Pagearticle pagearticle);

	public abstract void updateByHql(final String hql,
			final String[] paramNames, final Object[] values);

	public abstract List<Pagearticle> getPagearticles();

	public abstract List<Pagearticle> queryList(String queryString);

	public abstract List<Pagearticle> getObjectsByCondition(String queryString,
			Object[] p);

	public abstract List<Pagearticle> queryList(String queryString,
			String[] paramNames, Object[] values);

	public abstract List<Pagearticle> getObjectsByIdList(final String hql,
			final List<Integer> idList);

	public abstract List<Pagearticle> pageList(final String queryString,
			final Object[] p, final Integer page, final Integer size);

	public abstract int getUniqueResult(final String queryString,
			final Object[] p);

	public abstract Pagearticle loadById(int id);

	public abstract Pagearticle queryByNamedParam(String queryString,
			String[] paramNames, Object[] values);

	public abstract boolean checkClientExistsWithName(String queryString,
			Object[] p);

}