package com.jlj.dao;

import java.util.List;

import com.jlj.model.Footer;

public interface IFooterDao {

	public abstract void save(Footer footer);

	public abstract void delete(Footer footer);

	public abstract void deleteById(int id);

	public abstract void update(Footer footer);

	public abstract void updateByHql(final String hql,
			final String[] paramNames, final Object[] values);

	public abstract List<Footer> getFooters();

	public abstract List<Footer> queryList(String queryString);

	public abstract List<Footer> getObjectsByCondition(String queryString,
			Object[] p);

	public abstract List<Footer> queryList(String queryString,
			String[] paramNames, Object[] values);

	public abstract List<Footer> getObjectsByIdList(final String hql,
			final List<Integer> idList);

	public abstract List<Footer> pageList(final String queryString,
			final Object[] p, final Integer page, final Integer size);

	public abstract int getUniqueResult(final String queryString,
			final Object[] p);

	public abstract Footer loadById(int id);

	public abstract Footer queryByNamedParam(String queryString,
			String[] paramNames, Object[] values);

	public abstract boolean checkClientExistsWithName(String queryString,
			Object[] p);

}