package com.jlj.dao;

import java.util.List;

import com.jlj.model.Prizer;


public interface IPrizerDao {

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IBigtypeDao#save(com.jlj.model.Bigtype)
	 * 保存一条记录
	 */
	public abstract void save(Prizer prizer);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IBigtypeDao#delete(com.jlj.model.Bigtype)
	 * 删除一条记录
	 */
	public abstract void delete(Prizer prizer);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IBigtypeDao#deleteById(int)
	 * 根据ID删除一条记录
	 */
	public abstract void deleteById(int id);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IBigtypeDao#update(com.jlj.model.Bigtype)
	 * 修改一条记录
	 */
	public abstract void update(Prizer prizer);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IBigtypeDao#updateByHql(java.lang.String, java.lang.String[], java.lang.Object[])
	 * 根据hql语句、条件、条件值修改某些记录
	 */
	public abstract void updateByHql(final String hql,
			final String[] paramNames, final Object[] values);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IBigtypeDao#getBigtypes()
	 * 获得所有记录
	 */
	public abstract List<Prizer> getPrizers();

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IBigtypeDao#queryList(java.lang.String)
	 * 根据hql语句来查询所有记录
	 */
	public abstract List<Prizer> queryList(String queryString);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IBigtypeDao#getObjectsByCondition(java.lang.String, java.lang.Object[])
	 * 根据hql、条件值查询某些记录
	 */
	public abstract List<Prizer> getObjectsByCondition(String queryString,
			Object[] p);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IBigtypeDao#queryList(java.lang.String, java.lang.String[], java.lang.Object[])
	 * 根据hql语句、条件、条件值查询某些记录
	 */
	public abstract List<Prizer> queryList(String queryString,
			String[] paramNames, Object[] values);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IBigtypeDao#getObjectsByIdList(java.lang.String, java.util.List)
	 * 根据hql、id列表查询某些记录
	 */
	public abstract List<Prizer> getObjectsByIdList(final String hql,
			final List<Integer> idList);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IBigtypeDao#pageList(java.lang.String, java.lang.Object[], java.lang.Integer, java.lang.Integer)
	 * 根据hql语句、条件值、分页查询某些记录
	 */
	public abstract List<Prizer> pageList(final String queryString,
			final Object[] p, final Integer page, final Integer size);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IBigtypeDao#getUniqueResult(java.lang.String, java.lang.Object[])
	 * 根据hql、条件值获得一个唯一值
	 */
	public abstract int getUniqueResult(final String queryString,
			final Object[] p);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IBigtypeDao#loadById(int)
	 * 根据id查询一条记录
	 */
	public abstract Prizer loadById(int id);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IBigtypeDao#queryByNamedParam(java.lang.String, java.lang.String[], java.lang.Object[])
	 * 根据hql语句、条件、值来查询一条记录
	 */
	public abstract Prizer queryByNamedParam(String queryString,
			String[] paramNames, Object[] values);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IBigtypeDao#checkClientExistsWithName(java.lang.String)
	 * 根据hql语句、条件值来查询是否存在该记录
	 */
	public abstract boolean checkClientExistsWithName(String queryString,
			Object[] p);

}