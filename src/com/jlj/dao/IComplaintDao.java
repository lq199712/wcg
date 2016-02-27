package com.jlj.dao;

import java.util.List;

import com.jlj.model.Complaint;

public interface IComplaintDao {

	public abstract void save(Complaint complaint);

	public abstract void delete(Complaint complaint);

	public abstract void deleteById(int id);

	public abstract void update(Complaint complaint);

	public abstract void updateByHql(final String hql,
			final String[] paramNames, final Object[] values);

	public abstract List<Complaint> getComplaints();

	public abstract List<Complaint> queryList(String queryString);

	public abstract List<Complaint> getObjectsByCondition(String queryString,
			Object[] p);

	public abstract List<Complaint> queryList(String queryString,
			String[] paramNames, Object[] values);

	public abstract List<Complaint> getObjectsByIdList(final String hql,
			final List<Integer> idList);

	public abstract List<Complaint> pageList(final String queryString,
			final Object[] p, final Integer page, final Integer size);

	public abstract int getUniqueResult(final String queryString,
			final Object[] p);

	public abstract Complaint loadById(int id);

	public abstract Complaint queryByNamedParam(String queryString,
			String[] paramNames, Object[] values);

	public abstract boolean checkClientExistsWithName(String queryString,
			Object[] p);

}