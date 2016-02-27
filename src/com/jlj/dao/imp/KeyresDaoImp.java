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

import com.jlj.dao.IKeyresDao;
import com.jlj.model.Keyres;
@Component("keyresDao")
public class KeyresDaoImp implements IKeyresDao {
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IKeyresDao#save(com.jlj.model.Keyres)
	 */
	public void save(Keyres keyres) {
		this.hibernateTemplate.save(keyres);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IKeyresDao#delete(com.jlj.model.Keyres)
	 */
	public void delete(Keyres keyres) {
		this.hibernateTemplate.delete(keyres);
	}

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IKeyresDao#deleteById(int)
	 */
	public void deleteById(int id) {
		this.hibernateTemplate.delete(this.loadById(id));
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IKeyresDao#update(com.jlj.model.Keyres)
	 */
	public void update(Keyres keyres) {
		this.hibernateTemplate.update(keyres);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IKeyresDao#updateByHql(java.lang.String, java.lang.String[], java.lang.Object[])
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
	 * @see com.jlj.dao.imp.IKeyresDao#getKeyress()
	 */
	public List<Keyres> getKeyress() {
		return this.hibernateTemplate.loadAll(Keyres.class);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IKeyresDao#queryList(java.lang.String)
	 */
	public List<Keyres> queryList(String queryString) {
		return this.hibernateTemplate.find(queryString);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IKeyresDao#getObjectsByCondition(java.lang.String, java.lang.Object[])
	 */
	public List<Keyres> getObjectsByCondition(String queryString, Object[] p) {
		return this.hibernateTemplate.find(queryString,p);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IKeyresDao#queryList(java.lang.String, java.lang.String[], java.lang.Object[])
	 */
	public List<Keyres> queryList(String queryString, String[] paramNames,
			Object[] values)
	{
		List list =  this.hibernateTemplate.findByNamedParam(queryString, paramNames, values);
		return list;
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IKeyresDao#getObjectsByIdList(java.lang.String, java.util.List)
	 */
	public List<Keyres> getObjectsByIdList(final String hql,final List<Integer> idList) {
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
	 * @see com.jlj.dao.imp.IKeyresDao#pageList(java.lang.String, java.lang.Object[], java.lang.Integer, java.lang.Integer)
	 */
	public List<Keyres> pageList(final String queryString,final Object[] p,final Integer page,
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
	 * @see com.jlj.dao.imp.IKeyresDao#getUniqueResult(java.lang.String, java.lang.Object[])
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
	 * @see com.jlj.dao.imp.IKeyresDao#loadById(int)
	 */
	public Keyres loadById(int id) {
		return (Keyres) this.hibernateTemplate.load(Keyres.class, id);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IKeyresDao#queryByNamedParam(java.lang.String, java.lang.String[], java.lang.Object[])
	 */
	public Keyres queryByNamedParam(String queryString, String[] paramNames,
			Object[] values) {
		List list=this.hibernateTemplate.findByNamedParam(queryString, paramNames, values);
		return list.size()>0?(Keyres)list.get(0):null;
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IKeyresDao#checkClientExistsWithName(java.lang.String, java.lang.Object[])
	 */
	public boolean checkClientExistsWithName(String queryString, Object[] p) {
		List list =  this.hibernateTemplate.find(queryString,p);
		return list.size()>0 ? true : false;
	}


}
