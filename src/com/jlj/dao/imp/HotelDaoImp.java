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

import com.jlj.dao.IHotelDao;
import com.jlj.model.Hotel;
@Component("hotelDao")
public class HotelDaoImp implements IHotelDao {
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	//保存一条记录
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IHotelDao#save(com.jlj.model.Hotel)
	 */
	public void save(Hotel hotel) {
		this.hibernateTemplate.save(hotel);
	}
	
	//删除一条记录
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IHotelDao#delete(com.jlj.model.Hotel)
	 */
	public void delete(Hotel hotel) {
		this.hibernateTemplate.delete(hotel);
	}
	//根据ID删除一条记录
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IHotelDao#deleteById(int)
	 */
	public void deleteById(int id) {
		this.hibernateTemplate.delete(this.loadById(id));
	}
	
	//修改一条记录
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IHotelDao#update(com.jlj.model.Hotel)
	 */
	public void update(Hotel hotel) {
		this.hibernateTemplate.update(hotel);
	}
	
	//根据hql语句、条件、条件值修改某些记录
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IHotelDao#updateByHql(java.lang.String, java.lang.String[], java.lang.Object[])
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
	
	//获得所有记录
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IHotelDao#getHotels()
	 */
	public List<Hotel> getHotels() {
		return this.hibernateTemplate.loadAll(Hotel.class);
	}
	
	//根据hql语句来查询所有记录
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IHotelDao#queryList(java.lang.String)
	 */
	public List<Hotel> queryList(String queryString) {
		return this.hibernateTemplate.find(queryString);
	}
	
	//根据hql、条件值查询某些记录
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IHotelDao#getObjectsByCondition(java.lang.String, java.lang.Object[])
	 */
	public List<Hotel> getObjectsByCondition(String queryString, Object[] p) {
		return this.hibernateTemplate.find(queryString,p);
	}
	
	//根据hql语句、条件、条件值查询某些记录
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IHotelDao#queryList(java.lang.String, java.lang.String[], java.lang.Object[])
	 */
	public List<Hotel> queryList(String queryString, String[] paramNames,
			Object[] values)
	{
		List list =  this.hibernateTemplate.findByNamedParam(queryString, paramNames, values);
		return list;
	}
	
	
	//根据hql、id列表查询某些记录
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IHotelDao#getObjectsByIdList(java.lang.String, java.util.List)
	 */
	public List<Hotel> getObjectsByIdList(final String hql,final List<Integer> idList) {
		return this.hibernateTemplate.executeFind(new HibernateCallback(){

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query=session.createQuery(hql);
				query.setParameterList("idList", idList);
				return query.list();
			}
			
		});
	}
	
	//根据hql语句、条件值、分页查询某些记录
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IHotelDao#pageList(java.lang.String, java.lang.Object[], java.lang.Integer, java.lang.Integer)
	 */
	public List<Hotel> pageList(final String queryString,final Object[] p,final Integer page,
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
	
	
	
	//根据hql、条件值获得一个唯一值
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IHotelDao#getUniqueResult(java.lang.String, java.lang.Object[])
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
	
	
	
	
	
	//根据id查询一条记录
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IHotelDao#loadById(int)
	 */
	public Hotel loadById(int id) {
		return (Hotel) this.hibernateTemplate.load(Hotel.class, id);
	}
	
	//根据hql语句、条件、值来查询一条记录
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IHotelDao#queryByNamedParam(java.lang.String, java.lang.String[], java.lang.Object[])
	 */
	public Hotel queryByNamedParam(String queryString, String[] paramNames,
			Object[] values) {
		List list=this.hibernateTemplate.findByNamedParam(queryString, paramNames, values);
		return list.size()>0?(Hotel)list.get(0):null;
	}
	
	//根据hql语句、条件值来查询是否存在该记录
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IHotelDao#checkClientExistsWithName(java.lang.String, java.lang.Object[])
	 */
	public boolean checkClientExistsWithName(String queryString, Object[] p) {
		List list =  this.hibernateTemplate.find(queryString,p);
		return list.size()>0 ? true : false;
	}


}
