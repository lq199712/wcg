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

import com.jlj.dao.IFodderDao;
import com.jlj.model.Fodder;
@Component("fodderDao")
public class FodderDaoImp implements IFodderDao {
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderDao#save(com.jlj.model.Fodder)
	 */
	public void save(Fodder fodder) {
		this.hibernateTemplate.save(fodder);
	}
	
	public Integer savereturn(Fodder fodder) {
		return (Integer) this.hibernateTemplate.save(fodder);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderDao#delete(com.jlj.model.Fodder)
	 */
	public void delete(Fodder fodder) {
		this.hibernateTemplate.delete(fodder);
	}

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderDao#deleteById(int)
	 */
	public void deleteById(int id) {
		this.hibernateTemplate.delete(this.loadById(id));
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderDao#update(com.jlj.model.Fodder)
	 */
	public void update(Fodder fodder) {
		this.hibernateTemplate.update(fodder);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderDao#updateByHql(java.lang.String, java.lang.String[], java.lang.Object[])
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
	 * @see com.jlj.dao.imp.IFodderDao#getFodders()
	 */
	public List<Fodder> getFodders() {
		return this.hibernateTemplate.loadAll(Fodder.class);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderDao#queryList(java.lang.String)
	 */
	public List<Fodder> queryList(String queryString) {
		return this.hibernateTemplate.find(queryString);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderDao#getObjectsByCondition(java.lang.String, java.lang.Object[])
	 */
	public List<Fodder> getObjectsByCondition(String queryString, Object[] p) {
		return this.hibernateTemplate.find(queryString,p);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderDao#queryList(java.lang.String, java.lang.String[], java.lang.Object[])
	 */
	public List<Fodder> queryList(String queryString, String[] paramNames,
			Object[] values)
	{
		List list =  this.hibernateTemplate.findByNamedParam(queryString, paramNames, values);
		return list;
	}
	
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderDao#getObjectsByIdList(java.lang.String, java.util.List)
	 */
	public List<Fodder> getObjectsByIdList(final String hql,final List<Integer> idList) {
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
	 * @see com.jlj.dao.imp.IFodderDao#pageList(java.lang.String, java.lang.Object[], java.lang.Integer, java.lang.Integer)
	 */
	public List<Fodder> pageList(final String queryString,final Object[] p,final Integer page,
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
	 * @see com.jlj.dao.imp.IFodderDao#getUniqueResult(java.lang.String, java.lang.Object[])
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
	 * @see com.jlj.dao.imp.IFodderDao#loadById(int)
	 */
	public Fodder loadById(int id) {
		return (Fodder) this.hibernateTemplate.load(Fodder.class, id);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderDao#queryByNamedParam(java.lang.String, java.lang.String[], java.lang.Object[])
	 */
	public Fodder queryByNamedParam(String queryString, String[] paramNames,
			Object[] values) {
		List list=this.hibernateTemplate.findByNamedParam(queryString, paramNames, values);
		return list.size()>0?(Fodder)list.get(0):null;
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IFodderDao#checkClientExistsWithName(java.lang.String, java.lang.Object[])
	 */
	public boolean checkClientExistsWithName(String queryString, Object[] p) {
		List list =  this.hibernateTemplate.find(queryString,p);
		return list.size()>0 ? true : false;
	}

	

	
	
	
	
	
	
	
	

}
