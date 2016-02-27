package com.jlj.dao;

import java.util.List;

import com.jlj.model.Photo;

public interface IPhotoDao {

	public abstract void save(Photo photo);

	public abstract void delete(Photo photo);

	public abstract void deleteById(int id);

	public abstract void update(Photo photo);

	public abstract void updateByHql(final String hql,
			final String[] paramNames, final Object[] values);

	public abstract List<Photo> getPhotos();

	public abstract List<Photo> queryList(String queryString);

	public abstract List<Photo> getObjectsByCondition(String queryString,
			Object[] p);

	public abstract List<Photo> queryList(String queryString,
			String[] paramNames, Object[] values);

	public abstract List<Photo> getObjectsByIdList(final String hql,
			final List<Integer> idList);

	public abstract List<Photo> pageList(final String queryString,
			final Object[] p, final Integer page, final Integer size);

	public abstract int getUniqueResult(final String queryString,
			final Object[] p);

	public abstract Photo loadById(int id);

	public abstract Photo queryByNamedParam(String queryString,
			String[] paramNames, Object[] values);

	public abstract boolean checkClientExistsWithName(String queryString,
			Object[] p);

}