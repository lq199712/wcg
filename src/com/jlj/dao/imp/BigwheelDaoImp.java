package com.jlj.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.jlj.dao.IBigwheelDao;
import com.jlj.model.Bigwheel;

@Component("bigwheelDao")
public class BigwheelDaoImp implements IBigwheelDao {

	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public List<Bigwheel> getObjectsByCondition(String queryString, Object[] p) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find(queryString,p);
	}
	public List<Bigwheel> findByHql(String queryString) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find(queryString);
	}
	public void save(Bigwheel bigwheel) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.save(bigwheel);
	}
	public void delete(Bigwheel bigwheel) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.delete(bigwheel);	
	}
	public Bigwheel loadById(int id) {
		// TODO Auto-generated method stub
		try {
			return (Bigwheel)this.hibernateTemplate.load(Bigwheel.class, id);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	public void update(Bigwheel bigwheel) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.update(bigwheel);
	}
}
