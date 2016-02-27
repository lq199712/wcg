package com.jlj.service;

import java.util.List;

import com.jlj.model.Bigwheel;

public interface IBigwheelService {

	List<Bigwheel> queryList(String publicaccount);

	int getTotalCount(String publicaccount);

	void add(Bigwheel bigwheel);

	void delete(Bigwheel bigwheel);

	Bigwheel loadById(int id);

	void update(Bigwheel bigwheel);

}
