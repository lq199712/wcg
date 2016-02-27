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

import com.jlj.dao.IAddressbookDao;
import com.jlj.model.Addressbook;
@Component("addressbookDao")
public class AddressbookDaoImp implements IAddressbookDao {
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IAddressbookDao#save(com.jlj.model.Addressbook)
	 */
	public void save(Addressbook addressbook) {
		this.hibernateTemplate.save(addressbook);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IAddressbookDao#delete(com.jlj.model.Addressbook)
	 */
	public void delete(Addressbook addressbook) {
		this.hibernateTemplate.delete(addressbook);
	}
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IAddressbookDao#deleteById(int)
	 */
	public void deleteById(int id) {
		this.hibernateTemplate.delete(this.loadById(id));
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IAddressbookDao#update(com.jlj.model.Addressbook)
	 */
	public void update(Addressbook addressbook) {
		this.hibernateTemplate.update(addressbook);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IAddressbookDao#updateByHql(java.lang.String, java.lang.String[], java.lang.Object[])
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
	 * @see com.jlj.dao.imp.IAddressbookDao#getAddressbooks()
	 */
	public List<Addressbook> getAddressbooks() {
		return this.hibernateTemplate.loadAll(Addressbook.class);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IAddressbookDao#queryList(java.lang.String)
	 */
	public List<Addressbook> queryList(String queryString) {
		return this.hibernateTemplate.find(queryString);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IAddressbookDao#getObjectsByCondition(java.lang.String, java.lang.Object[])
	 */
	public List<Addressbook> getObjectsByCondition(String queryString, Object[] p) {
		return this.hibernateTemplate.find(queryString,p);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IAddressbookDao#queryList(java.lang.String, java.lang.String[], java.lang.Object[])
	 */
	public List<Addressbook> queryList(String queryString, String[] paramNames,
			Object[] values)
	{
		List list =  this.hibernateTemplate.findByNamedParam(queryString, paramNames, values);
		return list;
	}
	
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IAddressbookDao#getObjectsByIdList(java.lang.String, java.util.List)
	 */
	public List<Addressbook> getObjectsByIdList(final String hql,final List<Integer> idList) {
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
	 * @see com.jlj.dao.imp.IAddressbookDao#pageList(java.lang.String, java.lang.Object[], java.lang.Integer, java.lang.Integer)
	 */
	public List<Addressbook> pageList(final String queryString,final Object[] p,final Integer page,
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
	 * @see com.jlj.dao.imp.IAddressbookDao#getUniqueResult(java.lang.String, java.lang.Object[])
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
	 * @see com.jlj.dao.imp.IAddressbookDao#loadById(int)
	 */
	public Addressbook loadById(int id) {
		return (Addressbook) this.hibernateTemplate.load(Addressbook.class, id);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IAddressbookDao#queryByNamedParam(java.lang.String, java.lang.String[], java.lang.Object[])
	 */
	public Addressbook queryByNamedParam(String queryString, String[] paramNames,
			Object[] values) {
		List list=this.hibernateTemplate.findByNamedParam(queryString, paramNames, values);
		return list.size()>0?(Addressbook)list.get(0):null;
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IAddressbookDao#checkClientExistsWithName(java.lang.String, java.lang.Object[])
	 */
	public boolean checkClientExistsWithName(String queryString, Object[] p) {
		List list =  this.hibernateTemplate.find(queryString,p);
		return list.size()>0 ? true : false;
	}

	

	
	
	
	
	
	
	
	

}
