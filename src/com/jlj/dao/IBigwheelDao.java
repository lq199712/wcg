package com.jlj.dao;

import java.util.List;

import com.jlj.model.Bigwheel;

public interface IBigwheelDao {


	List<Bigwheel> getObjectsByCondition(String queryString, Object[] p);

	List<Bigwheel> findByHql(String queryString);

	void save(Bigwheel bigwheel);

	void delete(Bigwheel bigwheel);

	Bigwheel loadById(int id);

	void update(Bigwheel bigwheel);

}
