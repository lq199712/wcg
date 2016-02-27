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

import com.jlj.dao.ISontypeDao;
import com.jlj.model.Sontype;
@Component("sontypeDao")
public class SontypeDaoImp implements ISontypeDao {
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.ISontypeDao#save(com.jlj.model.Sontype)
	 */
	public void save(Sontype sontype) {
		this.hibernateTemplate.save(sontype);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.ISontypeDao#delete(com.jlj.model.Sontype)
	 */
	public void delete(Sontype sontype) {
		this.hibernateTemplate.delete(sontype);
	}
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.ISontypeDao#deleteById(int)
	 */
	public void deleteById(int id) {
		this.hibernateTemplate.delete(this.loadById(id));
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.ISontypeDao#update(com.jlj.model.Sontype)
	 */
	public void update(Sontype sontype) {
		this.hibernateTemplate.update(sontype);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.ISontypeDao#updateByHql(java.lang.String, java.lang.String[], java.lang.Object[])
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
	 * @see com.jlj.dao.imp.ISontypeDao#getSontypes()
	 */
	public List<Sontype> getSontypes() {
		return this.hibernateTemplate.loadAll(Sontype.class);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.ISontypeDao#queryList(java.lang.String)
	 */
	public List<Sontype> queryList(String queryString) {
		return this.hibernateTemplate.find(queryString);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.ISontypeDao#getObjectsByCondition(java.lang.String, java.lang.Object[])
	 */
	public List<Sontype> getObjectsByCondition(String queryString, Object[] p) {
		return this.hibernateTemplate.find(queryString,p);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.ISontypeDao#queryList(java.lang.String, java.lang.String[], java.lang.Object[])
	 */
	public List<Sontype> queryList(String queryString, String[] paramNames,
			Object[] values)
	{
		List list =  this.hibernateTemplate.findByNamedParam(queryString, paramNames, values);
		return list;
	}
	
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.ISontypeDao#getObjectsByIdList(java.lang.String, java.util.List)
	 */
	public List<Sontype> getObjectsByIdList(final String hql,final List<Integer> idList) {
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
	 * @see com.jlj.dao.imp.ISontypeDao#pageList(java.lang.String, java.lang.Object[], java.lang.Integer, java.lang.Integer)
	 */
	public List<Sontype> pageList(final String queryString,final Object[] p,final Integer page,
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
	 * @see com.jlj.dao.imp.ISontypeDao#getUniqueResult(java.lang.String, java.lang.Object[])
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
	 * @see com.jlj.dao.imp.ISontypeDao#loadById(int)
	 */
	public Sontype loadById(int id) {
		return (Sontype) this.hibernateTemplate.load(Sontype.class, id);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.ISontypeDao#queryByNamedParam(java.lang.String, java.lang.String[], java.lang.Object[])
	 */
	public Sontype queryByNamedParam(String queryString, String[] paramNames,
			Object[] values) {
		List list=this.hibernateTemplate.findByNamedParam(queryString, paramNames, values);
		return list.size()>0?(Sontype)list.get(0):null;
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.ISontypeDao#checkClientExistsWithName(java.lang.String, java.lang.Object[])
	 */
	public boolean checkClientExistsWithName(String queryString, Object[] p) {
		List list =  this.hibernateTemplate.find(queryString,p);
		return list.size()>0 ? true : false;
	}

	

	
	
	
	
	
	
	
	

}
