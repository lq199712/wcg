package com.jlj.dao;

import java.util.List;

import com.jlj.model.Fodderarticle;

public interface IFodderarticleDao {

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IBigtypeDao#save(com.jlj.model.Bigtype)
	 * 保存一条记录
	 */
	public abstract void save(Fodderarticle fodderarticle);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#delete(com.jlj.model.Fodderarticle)
	 * 删除一条记录
	 */
	public abstract void delete(Fodderarticle fodderarticle);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#deleteById(int)
	 * 根据ID删除一条记录
	 */
	public abstract void deleteById(int id);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#update(com.jlj.model.Fodderarticle)
	 * 修改一条记录
	 */
	public abstract void update(Fodderarticle fodderarticle);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#updateByHql(java.lang.String, java.lang.String[], java.lang.Object[])
	 * 根据hql语句、条件、条件值修改某些记录
	 */
	public abstract void updateByHql(final String hql,
			final String[] paramNames, final Object[] values);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#getFodderarticles()
	 * 获得所有记录
	 */
	public abstract List<Fodderarticle> getFodderarticles();

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#queryList(java.lang.String)
	 * 根据hql语句来查询所有记录
	 */
	public abstract List<Fodderarticle> queryList(String queryString);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#getObjectsByCondition(java.lang.String, java.lang.Object[])
	 * 根据hql、条件值查询某些记录
	 */
	public abstract List<Fodderarticle> getObjectsByCondition(
			String queryString, Object[] p);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#queryList(java.lang.String, java.lang.String[], java.lang.Object[])
	 * 根据hql语句、条件、条件值查询某些记录
	 */
	public abstract List<Fodderarticle> queryList(String queryString,
			String[] paramNames, Object[] values);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#getObjectsByIdList(java.lang.String, java.util.List)
	 * 根据hql、id列表查询某些记录
	 */
	public abstract List<Fodderarticle> getObjectsByIdList(final String hql,
			final List<Integer> idList);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#pageList(java.lang.String, java.lang.Object[], java.lang.Integer, java.lang.Integer)
	 * 根据hql语句、条件值、分页查询某些记录
	 */
	public abstract List<Fodderarticle> pageList(final String queryString,
			final Object[] p, final Integer page, final Integer size);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#getUniqueResult(java.lang.String, java.lang.Object[])
	 * 根据hql、条件值获得一个唯一值
	 */
	public abstract int getUniqueResult(final String queryString,
			final Object[] p);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#loadById(int)
	 * 根据id查询一条记录
	 */
	public abstract Fodderarticle loadById(int id);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#queryByNamedParam(java.lang.String, java.lang.String[], java.lang.Object[])
	 * 根据hql语句、条件、值来查询一条记录
	 */
	public abstract Fodderarticle queryByNamedParam(String queryString,
			String[] paramNames, Object[] values);

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#checkClientExistsWithName(java.lang.String)
	 * 根据hql语句、条件值来查询是否存在该记录
	 */
	public abstract boolean checkClientExistsWithName(String queryString,
			Object[] p);

}