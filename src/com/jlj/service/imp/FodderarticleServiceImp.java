package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IFodderarticleDao;
import com.jlj.model.Fodderarticle;
import com.jlj.service.IFodderarticleService;
@Component("fodderarticleService")
public class FodderarticleServiceImp implements IFodderarticleService {
	private IFodderarticleDao fodderarticleDao;
	public IFodderarticleDao getFodderarticleDao() {
		return fodderarticleDao;
	}
	@Resource
	public void setFodderarticleDao(IFodderarticleDao fodderarticleDao) {
		this.fodderarticleDao = fodderarticleDao;
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IFodderarticleService#add(com.jlj.model.Fodderarticle)
	 */
	public void add(Fodderarticle fodderarticle) throws Exception {
		fodderarticleDao.save(fodderarticle);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IFodderarticleService#delete(com.jlj.model.Fodderarticle)
	 */
	public void delete(Fodderarticle fodderarticle) {
		fodderarticleDao.delete(fodderarticle);
	}
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IFodderarticleService#deleteById(int)
	 */
	public void deleteById(int id) {
		fodderarticleDao.deleteById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IFodderarticleService#update(com.jlj.model.Fodderarticle)
	 */
	public void update(Fodderarticle fodderarticle) {
		fodderarticleDao.update(fodderarticle);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IFodderarticleService#getFodderarticles()
	 */
	public List<Fodderarticle> getFodderarticles() {
		return fodderarticleDao.getFodderarticles();
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IFodderarticleService#loadById(int)
	 */
	public Fodderarticle loadById(int id) {
		return fodderarticleDao.loadById(id);
	}
	public List<Fodderarticle> queryFodderarticlesByFodderid(int fodderid) {
		String queryString = "from Fodderarticle mo where mo.fodder.id = ?";
		Object[] p = new Object[]{fodderid};
		return fodderarticleDao.getObjectsByCondition(queryString, p);
	}

	
	

}
