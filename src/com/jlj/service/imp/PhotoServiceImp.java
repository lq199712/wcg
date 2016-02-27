package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IPhotoDao;
import com.jlj.model.Photo;
import com.jlj.service.IPhotoService;
@Component("photoService")
public class PhotoServiceImp implements IPhotoService {
	private IPhotoDao photoDao;
	public IPhotoDao getPhotoDao() {
		return photoDao;
	}
	@Resource
	public void setPhotoDao(IPhotoDao photoDao) {
		this.photoDao = photoDao;
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPhotoService#add(com.jlj.model.Photo)
	 */
	public void add(Photo photo) throws Exception {
		photoDao.save(photo);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPhotoService#delete(com.jlj.model.Photo)
	 */
	public void delete(Photo photo) {
		photoDao.delete(photo);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPhotoService#deleteById(int)
	 */
	public void deleteById(int id) {
		photoDao.deleteById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPhotoService#update(com.jlj.model.Photo)
	 */
	public void update(Photo photo) {
		photoDao.update(photo);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPhotoService#getPhotos()
	 */
	public List<Photo> getPhotos() {
		return photoDao.getPhotos();
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPhotoService#loadById(int)
	 */
	public Photo loadById(int id) {
		return photoDao.loadById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPhotoService#getPhotosByPublicaccount(java.lang.String)
	 */
	public List<Photo> getPhotosByPublicaccount(String publicaccount) {
		String queryString = "from Photo mo where mo.phototype.publicaccount = ?";
		Object[] p = new Object[]{publicaccount};
		return photoDao.getObjectsByCondition(queryString, p);
	}


}
