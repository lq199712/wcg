package com.jlj.dao;

import java.util.List;

import com.jlj.model.Member;

public interface IMemberDao {

	public abstract void save(Member member);

	public abstract void delete(Member member);

	public abstract void deleteById(int id);

	public abstract void update(Member member);

	public abstract void updateByHql(final String hql,
			final String[] paramNames, final Object[] values);

	public abstract List<Member> getMembers();

	public abstract List<Member> queryList(String queryString);

	public abstract List<Member> getObjectsByCondition(String queryString,
			Object[] p);

	public abstract List<Member> queryList(String queryString,
			String[] paramNames, Object[] values);

	public abstract List<Member> getObjectsByIdList(final String hql,
			final List<Integer> idList);

	public abstract List<Member> pageList(final String queryString,
			final Object[] p, final Integer page, final Integer size);

	public abstract int getUniqueResult(final String queryString,
			final Object[] p);

	public abstract Member loadById(int id);

	public abstract Member queryByNamedParam(String queryString,
			String[] paramNames, Object[] values);

	public abstract boolean checkClientExistsWithName(String queryString,
			Object[] p);

}