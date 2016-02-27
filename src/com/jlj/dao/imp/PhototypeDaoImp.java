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

import com.jlj.dao.IPhototypeDao;
import com.jlj.model.Phototype;
@Component("phototypeDao")
public class PhototypeDaoImp implements IPhototypeDao {
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IPhototypeDao#save(com.jlj.model.Phototype)
	 */
	public void save(Phototype phototype) {
		this.hibernateTemplate.save(phototype);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IPhototypeDao#delete(com.jlj.model.Phototype)
	 */
	public void delete(Phototype phototype) {
		this.hibernateTemplate.delete(phototype);
	}

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IPhototypeDao#deleteById(int)
	 */
	public void deleteById(int id) {
		this.hibernateTemplate.delete(this.loadById(id));
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IPhototypeDao#update(com.jlj.model.Phototype)
	 */
	public void update(Phototype phototype) {
		this.hibernateTemplate.update(phototype);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IPhototypeDao#updateByHql(java.lang.String, java.lang.String[], java.lang.Object[])
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
	 * @see com.jlj.dao.imp.IPhototypeDao#getPhototypes()
	 */
	public List<Phototype> getPhototypes() {
		return this.hibernateTemplate.loadAll(Phototype.class);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IPhototypeDao#queryList(java.lang.String)
	 */
	public List<Phototype> queryList(String queryString) {
		return this.hibernateTemplate.find(queryString);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IPhototypeDao#getObjectsByCondition(java.lang.String, java.lang.Object[])
	 */
	public List<Phototype> getObjectsByCondition(String queryString, Object[] p) {
		return this.hibernateTemplate.find(queryString,p);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IPhototypeDao#queryList(java.lang.String, java.lang.String[], java.lang.Object[])
	 */
	public List<Phototype> queryList(String queryString, String[] paramNames,
			Object[] values)
	{
		List list =  this.hibernateTemplate.findByNamedParam(queryString, paramNames, values);
		return list;
	}
	
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IPhototypeDao#getObjectsByIdList(java.lang.String, java.util.List)
	 */
	public List<Phototype> getObjectsByIdList(final String hql,final List<Integer> idList) {
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
	 * @see com.jlj.dao.imp.IPhototypeDao#pageList(java.lang.String, java.lang.Object[], java.lang.Integer, java.lang.Integer)
	 */
	public List<Phototype> pageList(final String queryString,final Object[] p,final Integer page,
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
	 * @see com.jlj.dao.imp.IPhototypeDao#getUniqueResult(java.lang.String, java.lang.Object[])
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
	 * @see com.jlj.dao.imp.IPhototypeDao#loadById(int)
	 */
	public Phototype loadById(int id) {
		return (Phototype) this.hibernateTemplate.load(Phototype.class, id);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IPhototypeDao#queryByNamedParam(java.lang.String, java.lang.String[], java.lang.Object[])
	 */
	public Phototype queryByNamedParam(String queryString, String[] paramNames,
			Object[] values) {
		List list=this.hibernateTemplate.findByNamedParam(queryString, paramNames, values);
		return list.size()>0?(Phototype)list.get(0):null;
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IPhototypeDao#checkClientExistsWithName(java.lang.String, java.lang.Object[])
	 */
	public boolean checkClientExistsWithName(String queryString, Object[] p) {
		List list =  this.hibernateTemplate.find(queryString,p);
		return list.size()>0 ? true : false;
	}

	

	
	
	
	
	
	
	
	

}
