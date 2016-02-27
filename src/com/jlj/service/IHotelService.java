package com.jlj.service;

import java.util.List;

import com.jlj.model.Hotel;

public interface IHotelService {

	public abstract void add(Hotel hotel) throws Exception;

	public abstract void delete(Hotel hotel);

	public abstract void deleteById(int id);

	public abstract void update(Hotel hotel);

	public abstract List<Hotel> getHotels();

	public abstract Hotel loadById(int id);

	public abstract int getPageCount(int con, String convalue, int status,
			String publicaccount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Hotel> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size);

	public abstract List<Hotel> getHotelsByPublicAccount(String paccount);

}