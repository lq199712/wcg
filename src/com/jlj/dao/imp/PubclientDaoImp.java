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

import com.jlj.dao.IPubclientDao;
import com.jlj.model.Pubclient;
@Component("pubclientDao")
public class PubclientDaoImp implements IPubclientDao {
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IPubclientDao#save(com.jlj.model.Pubclient)
	 * 保存一条记录
	 */
	public void save(Pubclient pubclient) {
		this.hibernateTemplate.save(pubclient);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IPubclientDao#delete(com.jlj.model.Pubclient)
	 * 删除一条记录
	 */
	public void delete(Pubclient pubclient) {
		this.hibernateTemplate.delete(pubclient);
	}
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IPubclientDao#deleteById(int)
	 * 根据ID删除一条记录
	 */
	public void deleteById(int id) {
		this.hibernateTemplate.delete(this.loadById(id));
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IPubclientDao#update(com.jlj.model.Pubclient)
	 * 修改一条记录
	 */
	public void update(Pubclient pubclient) {
		this.hibernateTemplate.update(pubclient);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IPubclientDao#updateByHql(java.lang.String, java.lang.String[], java.lang.Object[])
	 * 根据hql语句、条件、条件值修改某些记录
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
	 * @see com.jlj.dao.imp.IPubclientDao#getPubclients()
	 * 获得所有记录
	 */
	public List<Pubclient> getPubclients() {
		return this.hibernateTemplate.loadAll(Pubclient.class);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IPubclientDao#queryList(java.lang.String)
	 * 根据hql语句来查询所有记录
	 */
	public List<Pubclient> queryList(String queryString) {
		return this.hibernateTemplate.find(queryString);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IPubclientDao#getObjectsByCondition(java.lang.String, java.lang.Object[])
	 * 根据hql、条件值查询某些记录
	 */
	public List<Pubclient> getObjectsByCondition(String queryString, Object[] p) {
		return this.hibernateTemplate.find(queryString,p);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IPubclientDao#queryList(java.lang.String, java.lang.String[], java.lang.Object[])
	 * 根据hql语句、条件、条件值查询某些记录
	 */
	public List<Pubclient> queryList(String queryString, String[] paramNames,
			Object[] values)
	{
		List list =  this.hibernateTemplate.findByNamedParam(queryString, paramNames, values);
		return list;
	}
	
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IPubclientDao#getObjectsByIdList(java.lang.String, java.util.List)
	 * 根据hql、id列表查询某些记录
	 */
	public List<Pubclient> getObjectsByIdList(final String hql,final List<Integer> idList) {
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
	 * @see com.jlj.dao.imp.IPubclientDao#pageList(java.lang.String, java.lang.Object[], java.lang.Integer, java.lang.Integer)
	 * 根据hql语句、条件值、分页查询某些记录
	 */
	public List<Pubclient> pageList(final String queryString,final Object[] p,final Integer page,
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
	 * @see com.jlj.dao.imp.IPubclientDao#getUniqueResult(java.lang.String, java.lang.Object[])
	 * 根据hql、条件值获得一个唯一值
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
	 * @see com.jlj.dao.imp.IPubclientDao#loadById(int)
	 * 根据id查询一条记录
	 */
	public Pubclient loadById(int id) {
		return (Pubclient) this.hibernateTemplate.load(Pubclient.class, id);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IPubclientDao#queryByNamedParam(java.lang.String, java.lang.String[], java.lang.Object[])
	 * 根据hql语句、条件、值来查询一条记录
	 */
	public Pubclient queryByNamedParam(String queryString, String[] paramNames,
			Object[] values) {
		List list=this.hibernateTemplate.findByNamedParam(queryString, paramNames, values);
		return list.size()>0?(Pubclient)list.get(0):null;
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IPubclientDao#checkClientExistsWithName(java.lang.String)
	 * 根据hql语句、条件值来查询是否存在该记录
	 */
	public boolean checkClientExistsWithName(String queryString, Object[] p) {
		List list =  this.hibernateTemplate.find(queryString,p);
		return list.size()>0 ? true : false;
	}

	

	
	
	
	
	
	
	
	

}
