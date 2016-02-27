package com.jlj.service;

import java.util.List;

import com.jlj.model.Room;

public interface IRoomService {

	public abstract void add(Room room) throws Exception;

	public abstract void delete(Room room);

	public abstract void deleteById(int id);

	public abstract void update(Room room);

	public abstract List<Room> getRooms();

	public abstract Room loadById(int id);

	public abstract int getPageCount(int con, String convalue, int status,
			String publicaccount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Room> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size);

	public abstract List<Room> queryRoomByCondition(int hid);

}