package com.jlj.dao;

import java.util.List;

import com.jlj.model.Room;

public interface IRoomDao {

	public abstract void save(Room room);

	public abstract void delete(Room room);

	public abstract void deleteById(int id);

	public abstract void update(Room room);

	public abstract void updateByHql(final String hql,
			final String[] paramNames, final Object[] values);

	public abstract List<Room> getRooms();

	public abstract List<Room> queryList(String queryString);

	public abstract List<Room> getObjectsByCondition(String queryString,
			Object[] p);

	public abstract List<Room> queryList(String queryString,
			String[] paramNames, Object[] values);

	public abstract List<Room> getObjectsByIdList(final String hql,
			final List<Integer> idList);

	public abstract List<Room> pageList(final String queryString,
			final Object[] p, final Integer page, final Integer size);

	public abstract int getUniqueResult(final String queryString,
			final Object[] p);

	public abstract Room loadById(int id);

	public abstract Room queryByNamedParam(String queryString,
			String[] paramNames, Object[] values);

	public abstract boolean checkClientExistsWithName(String queryString,
			Object[] p);

}