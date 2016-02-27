package com.jlj.dao.imp;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.jlj.dao.IFodderarticleDao;
import com.jlj.model.Fodderarticle;
@Component("fodderarticleDao")
public class FodderarticleDaoImp implements IFodderarticleDao {
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IBigtypeDao#save(com.jlj.model.Bigtype)
	 * 保存一条记录
	 */
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#save(com.jlj.model.Fodderarticle)
	 */
	public void save(Fodderarticle fodderarticle) {
		this.hibernateTemplate.save(fodderarticle);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#delete(com.jlj.model.Fodderarticle)
	 * 删除一条记录
	 */
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#delete(com.jlj.model.Fodderarticle)
	 */
	public void delete(Fodderarticle fodderarticle) {
		this.hibernateTemplate.delete(fodderarticle);
	}
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#deleteById(int)
	 * 根据ID删除一条记录
	 */
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#deleteById(int)
	 */
	public void deleteById(int id) {
		this.hibernateTemplate.delete(this.loadById(id));
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#update(com.jlj.model.Fodderarticle)
	 * 修改一条记录
	 */
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#update(com.jlj.model.Fodderarticle)
	 */
	public void update(Fodderarticle fodderarticle) {
		this.hibernateTemplate.update(fodderarticle);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#updateByHql(java.lang.String, java.lang.String[], java.lang.Object[])
	 * 根据hql语句、条件、条件值修改某些记录
	 */
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#updateByHql(java.lang.String, java.lang.String[], java.lang.Object[])
	 */
	public void updateByHql(final String hql,final String[] paramNames,final Object[] values) {
		this.hibernateTemplate.execute(new HibernateCallback(){

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query=session.createQuery(hql);
				for (int i = 0; i < paramNames.length; i++) {
					query.setParameter(paramNames[i], values[i]);
				}
				query.executeUpdate();
				return null;
			}
			
		});
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#getFodderarticles()
	 * 获得所有记录
	 */
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#getFodderarticles()
	 */
	public List<Fodderarticle> getFodderarticles() {
		return this.hibernateTemplate.loadAll(Fodderarticle.class);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#queryList(java.lang.String)
	 * 根据hql语句来查询所有记录
	 */
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#queryList(java.lang.String)
	 */
	public List<Fodderarticle> queryList(String queryString) {
		return this.hibernateTemplate.find(queryString);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#getObjectsByCondition(java.lang.String, java.lang.Object[])
	 * 根据hql、条件值查询某些记录
	 */
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#getObjectsByCondition(java.lang.String, java.lang.Object[])
	 */
	public List<Fodderarticle> getObjectsByCondition(String queryString, Object[] p) {
		return this.hibernateTemplate.find(queryString,p);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#queryList(java.lang.String, java.lang.String[], java.lang.Object[])
	 * 根据hql语句、条件、条件值查询某些记录
	 */
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#queryList(java.lang.String, java.lang.String[], java.lang.Object[])
	 */
	public List<Fodderarticle> queryList(String queryString, String[] paramNames,
			Object[] values)
	{
		List list =  this.hibernateTemplate.findByNamedParam(queryString, paramNames, values);
		return list;
	}
	
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#getObjectsByIdList(java.lang.String, java.util.List)
	 * 根据hql、id列表查询某些记录
	 */
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#getObjectsByIdList(java.lang.String, java.util.List)
	 */
	public List<Fodderarticle> getObjectsByIdList(final String hql,final List<Integer> idList) {
		return this.hibernateTemplate.executeFind(new HibernateCallback(){

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query=session.createQuery(hql);
				query.setParameterList("idList", idList);
				return query.list();
			}
			
		});
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#pageList(java.lang.String, java.lang.Object[], java.lang.Integer, java.lang.Integer)
	 * 根据hql语句、条件值、分页查询某些记录
	 */
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#pageList(java.lang.String, java.lang.Object[], java.lang.Integer, java.lang.Integer)
	 */
	public List<Fodderarticle> pageList(final String queryString,final Object[] p,final Integer page,
			final Integer size) {
		return this.hibernateTemplate.executeFind(new HibernateCallback(){

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query=session.createQuery(queryString);
				if(p!=null&&p.length>0){
					for (int i = 0; i < p.length; i++) {
						query.setParameter(i, p[i]);
					}
				}
				if(page!=null&&page>0&&size!=null&&size>0){
					query.setFirstResult((page-1)*size).setMaxResults(size);
				}
				return query.list();
			}
			
		});
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#getUniqueResult(java.lang.String, java.lang.Object[])
	 * 根据hql、条件值获得一个唯一值
	 */
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#getUniqueResult(java.lang.String, java.lang.Object[])
	 */
	public int getUniqueResult(final String queryString,final Object[] p) {
		Session session=this.hibernateTemplate.getSessionFactory().getCurrentSession();
		Query query= session.createQuery(queryString);
		if(p!=null&&p.length>0){
			for (int i = 0; i < p.length; i++) {
				query.setParameter(i, p[i]);
			}
		}
		Object obj=query.uniqueResult();
		return ((Long)obj).intValue();
			
	}
	
	
	
	
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#loadById(int)
	 * 根据id查询一条记录
	 */
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#loadById(int)
	 */
	public Fodderarticle loadById(int id) {
		return (Fodderarticle) this.hibernateTemplate.load(Fodderarticle.class, id);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#queryByNamedParam(java.lang.String, java.lang.String[], java.lang.Object[])
	 * 根据hql语句、条件、值来查询一条记录
	 */
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#queryByNamedParam(java.lang.String, java.lang.String[], java.lang.Object[])
	 */
	public Fodderarticle queryByNamedParam(String queryString, String[] paramNames,
			Object[] values) {
		List list=this.hibernateTemplate.findByNamedParam(queryString, paramNames, values);
		return list.size()>0?(Fodderarticle)list.get(0):null;
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#checkClientExistsWithName(java.lang.String)
	 * 根据hql语句、条件值来查询是否存在该记录
	 */
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderarticleDao#checkClientExistsWithName(java.lang.String, java.lang.Object[])
	 */
	public boolean checkClientExistsWithName(String queryString, Object[] p) {
		List list =  this.hibernateTemplate.find(queryString,p);
		return list.size()>0 ? true : false;
	}

	

	
	
	
	
	
	
	
	

}
