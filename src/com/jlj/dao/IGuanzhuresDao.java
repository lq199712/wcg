package com.jlj.dao;

import java.util.List;

import com.jlj.model.Guanzhures;

public interface IGuanzhuresDao {

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IGuanzhuresDao#save(com.jlj.model.Guanzhures)
	 * 保存一条记录
	 */
	public abstract void save(Guanzhures guanzhures);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IGuanzhuresDao#delete(com.jlj.model.Guanzhures)
	 * 删除一条记录
	 */
	public abstract void delete(Guanzhures guanzhures);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IGuanzhuresDao#deleteById(int)
	 * 根据ID删除一条记录
	 */
	public abstract void deleteById(int id);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IGuanzhuresDao#update(com.jlj.model.Guanzhures)
	 * 修改一条记录
	 */
	public abstract void update(Guanzhures guanzhures);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IGuanzhuresDao#updateByHql(java.lang.String, java.lang.String[], java.lang.Object[])
	 * 根据hql语句、条件、条件值修改某些记录
	 */
	public abstract void updateByHql(final String hql,
			final String[] paramNames, final Object[] values);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IGuanzhuresDao#getGuanzhuress()
	 * 获得所有记录
	 */
	public abstract List<Guanzhures> getGuanzhuress();

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IGuanzhuresDao#queryList(java.lang.String)
	 * 根据hql语句来查询所有记录
	 */
	public abstract List<Guanzhures> queryList(String queryString);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IGuanzhuresDao#getObjectsByCondition(java.lang.String, java.lang.Object[])
	 * 根据hql、条件值查询某些记录
	 */
	public abstract List<Guanzhures> getObjectsByCondition(String queryString,
			Object[] p);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IGuanzhuresDao#queryList(java.lang.String, java.lang.String[], java.lang.Object[])
	 * 根据hql语句、条件、条件值查询某些记录
	 */
	public abstract List<Guanzhures> queryList(String queryString,
			String[] paramNames, Object[] values);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IGuanzhuresDao#getObjectsByIdList(java.lang.String, java.util.List)
	 * 根据hql、id列表查询某些记录
	 */
	public abstract List<Guanzhures> getObjectsByIdList(final String hql,
			final List<Integer> idList);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IGuanzhuresDao#pageList(java.lang.String, java.lang.Object[], java.lang.Integer, java.lang.Integer)
	 * 根据hql语句、条件值、分页查询某些记录
	 */
	public abstract List<Guanzhures> pageList(final String queryString,
			final Object[] p, final Integer page, final Integer size);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IGuanzhuresDao#getUniqueResult(java.lang.String, java.lang.Object[])
	 * 根据hql、条件值获得一个唯一值
	 */
	public abstract int getUniqueResult(final String queryString,
			final Object[] p);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IGuanzhuresDao#loadById(int)
	 * 根据id查询一条记录
	 */
	public abstract Guanzhures loadById(int id);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IGuanzhuresDao#queryByNamedParam(java.lang.String, java.lang.String[], java.lang.Object[])
	 * 根据hql语句、条件、值来查询一条记录
	 */
	public abstract Guanzhures queryByNamedParam(String queryString,
			String[] paramNames, Object[] values);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IGuanzhuresDao#checkClientExistsWithName(java.lang.String)
	 * 根据hql语句、条件值来查询是否存在该记录
	 */
	public abstract boolean checkClientExistsWithName(String queryString,
			Object[] p);

}