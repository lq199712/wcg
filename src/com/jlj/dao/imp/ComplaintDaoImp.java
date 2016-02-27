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

import com.jlj.dao.IComplaintDao;
import com.jlj.model.Complaint;
@Component("complaintDao")
public class ComplaintDaoImp implements IComplaintDao {
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IAutoresDao#save(com.jlj.model.Autores)
	 */
	public void save(Complaint complaint) {
		this.hibernateTemplate.save(complaint);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IAutoresDao#delete(com.jlj.model.Complaint)
	 */
	public void delete(Complaint complaints) {
		this.hibernateTemplate.delete(complaints);
	}
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IAutoresDao#deleteById(int)
	 */
	public void deleteById(int id) {
		this.hibernateTemplate.delete(this.loadById(id));
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IAutoresDao#update(com.jlj.model.Complaint)
	 */
	public void update(Complaint complaints) {
		this.hibernateTemplate.update(complaints);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IAutoresDao#updateByHql(java.lang.String, java.lang.String[], java.lang.Object[])
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
	 * @see com.jlj.dao.imp.IAutoresDao#getAutoress()
	 */
	public List<Complaint> getComplaints() {
		return this.hibernateTemplate.loadAll(Complaint.class);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IComplaintDao#queryList(java.lang.String)
	 */
	public List<Complaint> queryList(String queryString) {
		return this.hibernateTemplate.find(queryString);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IComplaintDao#getObjectsByCondition(java.lang.String, java.lang.Object[])
	 */
	public List<Complaint> getObjectsByCondition(String queryString, Object[] p) {
		return this.hibernateTemplate.find(queryString,p);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IComplaintDao#queryList(java.lang.String, java.lang.String[], java.lang.Object[])
	 */
	public List<Complaint> queryList(String queryString, String[] paramNames,
			Object[] values)
	{
		List list =  this.hibernateTemplate.findByNamedParam(queryString, paramNames, values);
		return list;
	}
	
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IComplaintDao#getObjectsByIdList(java.lang.String, java.util.List)
	 */
	public List<Complaint> getObjectsByIdList(final String hql,final List<Integer> idList) {
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
	 * @see com.jlj.dao.imp.IComplaintDao#pageList(java.lang.String, java.lang.Object[], java.lang.Integer, java.lang.Integer)
	 */
	public List<Complaint> pageList(final String queryString,final Object[] p,final Integer page,
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
	 * @see com.jlj.dao.imp.IComplaintDao#getUniqueResult(java.lang.String, java.lang.Object[])
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
	 * @see com.jlj.dao.imp.IComplaintDao#loadById(int)
	 */
	public Complaint loadById(int id) {
		return (Complaint) this.hibernateTemplate.load(Complaint.class, id);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IComplaintDao#queryByNamedParam(java.lang.String, java.lang.String[], java.lang.Object[])
	 */
	public Complaint queryByNamedParam(String queryString, String[] paramNames,
			Object[] values) {
		List list=this.hibernateTemplate.findByNamedParam(queryString, paramNames, values);
		return list.size()>0?(Complaint)list.get(0):null;
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IComplaintDao#checkClientExistsWithName(java.lang.String, java.lang.Object[])
	 */
	public boolean checkClientExistsWithName(String queryString, Object[] p) {
		List list =  this.hibernateTemplate.find(queryString,p);
		return list.size()>0 ? true : false;
	}

	

	
	
	
	
	
	
	
	

}
