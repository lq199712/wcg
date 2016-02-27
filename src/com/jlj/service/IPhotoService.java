package com.jlj.service;

import java.util.List;

import com.jlj.model.Photo;

public interface IPhotoService {

	public abstract void add(Photo photo) throws Exception;

	public abstract void delete(Photo photo);

	public abstract void deleteById(int id);

	public abstract void update(Photo photo);

	public abstract List<Photo> getPhotos();

	public abstract Photo loadById(int id);

	public abstract List<Photo> getPhotosByPublicaccount(String publicaccount);

}