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

import com.jlj.dao.IPagearticleDao;
import com.jlj.dao.ISontypeDao;
import com.jlj.model.Pagearticle;
@Component("pagearticleDao")
public class PagearticleDaoImp implements IPagearticleDao {
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IPagearticle#save(com.jlj.model.Pagearticle)
	 */
	public void save(Pagearticle pagearticle) {
		this.hibernateTemplate.save(pagearticle);
	}
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IPagearticle#delete(com.jlj.model.Pagearticle)
	 */
	public void delete(Pagearticle pagearticle) {
		this.hibernateTemplate.delete(pagearticle);
	}
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IPagearticle#deleteById(int)
	 */
	public void deleteById(int id) {
		this.hibernateTemplate.delete(this.loadById(id));
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IPagearticle#update(com.jlj.model.Pagearticle)
	 */
	public void update(Pagearticle pagearticle) {
		this.hibernateTemplate.update(pagearticle);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IPagearticle#updateByHql(java.lang.String, java.lang.String[], java.lang.Object[])
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
	 * @see com.jlj.dao.imp.IPagearticle#getPagearticles()
	 */
	public List<Pagearticle> getPagearticles() {
		return this.hibernateTemplate.loadAll(Pagearticle.class);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IPagearticle#queryList(java.lang.String)
	 */
	public List<Pagearticle> queryList(String queryString) {
		return this.hibernateTemplate.find(queryString);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IPagearticle#getObjectsByCondition(java.lang.String, java.lang.Object[])
	 */
	public List<Pagearticle> getObjectsByCondition(String queryString, Object[] p) {
		return this.hibernateTemplate.find(queryString,p);
	}
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IPagearticle#queryList(java.lang.String, java.lang.String[], java.lang.Object[])
	 */
	public List<Pagearticle> queryList(String queryString, String[] paramNames,
			Object[] values)
	{
		List list =  this.hibernateTemplate.findByNamedParam(queryString, paramNames, values);
		return list;
	}
	
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IPagearticle#getObjectsByIdList(java.lang.String, java.util.List)
	 */
	public List<Pagearticle> getObjectsByIdList(final String hql,final List<Integer> idList) {
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
	 * @see com.jlj.dao.imp.IPagearticle#pageList(java.lang.String, java.lang.Object[], java.lang.Integer, java.lang.Integer)
	 */
	public List<Pagearticle> pageList(final String queryString,final Object[] p,final Integer page,
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
	 * @see com.jlj.dao.imp.IPagearticle#getUniqueResult(java.lang.String, java.lang.Object[])
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
	 * @see com.jlj.dao.imp.IPagearticle#loadById(int)
	 */
	public Pagearticle loadById(int id) {
		return (Pagearticle) this.hibernateTemplate.load(Pagearticle.class, id);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IPagearticle#queryByNamedParam(java.lang.String, java.lang.String[], java.lang.Object[])
	 */
	public Pagearticle queryByNamedParam(String queryString, String[] paramNames,
			Object[] values) {
		List list=this.hibernateTemplate.findByNamedParam(queryString, paramNames, values);
		return list.size()>0?(Pagearticle)list.get(0):null;
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IPagearticle#checkClientExistsWithName(java.lang.String, java.lang.Object[])
	 */
	public boolean checkClientExistsWithName(String queryString, Object[] p) {
		List list =  this.hibernateTemplate.find(queryString,p);
		return list.size()>0 ? true : false;
	}

	

	
	
	
	
	
	
	
	

}
