package com.jlj.dao;

import java.util.List;

import com.jlj.model.Addressbook;

public interface IAddressbookDao {

	public abstract void save(Addressbook addressbook);

	public abstract void delete(Addressbook addressbook);

	public abstract void deleteById(int id);

	public abstract void update(Addressbook addressbook);

	public abstract void updateByHql(final String hql,
			final String[] paramNames, final Object[] values);

	public abstract List<Addressbook> getAddressbooks();

	public abstract List<Addressbook> queryList(String queryString);

	public abstract List<Addressbook> getObjectsByCondition(String queryString,
			Object[] p);

	public abstract List<Addressbook> queryList(String queryString,
			String[] paramNames, Object[] values);

	public abstract List<Addressbook> getObjectsByIdList(final String hql,
			final List<Integer> idList);

	public abstract List<Addressbook> pageList(final String queryString,
			final Object[] p, final Integer page, final Integer size);

	public abstract int getUniqueResult(final String queryString,
			final Object[] p);

	public abstract Addressbook loadById(int id);

	public abstract Addressbook queryByNamedParam(String queryString,
			String[] paramNames, Object[] values);

	public abstract boolean checkClientExistsWithName(String queryString,
			Object[] p);

}