package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IScreenimgDao;
import com.jlj.model.Screenimg;
import com.jlj.service.IScreenimgService;
@Component("screenimgService")
public class ScreenimgServiceImp implements IScreenimgService {
	private IScreenimgDao screenimgDao;
	public IScreenimgDao getScreenimgDao() {
		return screenimgDao;
	}
	@Resource
	public void setScreenimgDao(IScreenimgDao screenimgDao) {
		this.screenimgDao = screenimgDao;
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IScreenimgService#add(com.jlj.model.Screenimg)
	 */
	public void add(Screenimg screenimg) throws Exception {
		screenimgDao.save(screenimg);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IScreenimgService#delete(com.jlj.model.Screenimg)
	 */
	public void delete(Screenimg screenimg) {
		screenimgDao.delete(screenimg);
	}
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IScreenimgService#deleteById(int)
	 */
	public void deleteById(int id) {
		screenimgDao.deleteById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IScreenimgService#update(com.jlj.model.Screenimg)
	 */
	public void update(Screenimg screenimg) {
		screenimgDao.update(screenimg);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IScreenimgService#getScreenimgs()
	 */
	public List<Screenimg> getScreenimgs() {
		return screenimgDao.getScreenimgs();
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IScreenimgService#loadById(int)
	 */
	public Screenimg loadById(int id) {
		return screenimgDao.loadById(id);
	}
	public List<Screenimg> getScreenimgsByPublicaccount(String publicaccount) {
		// TODO Auto-generated method stub
		String queryString = "from Screenimg mo where mo.publicaccount = ?  order by mo.imgorder asc";
		Object[] p = new Object[]{publicaccount};
		return screenimgDao.getObjectsByCondition(queryString, p);
	}
	public List<Screenimg> getScreenimgsByCondition(int imgtype,
			String publicaccount) {
		String queryString = "from Screenimg mo where mo.imgtype=? and mo.publicaccount = ? and mo.isshow=1 order by mo.imgorder asc";
		Object[] p = new Object[]{imgtype,publicaccount};
		return screenimgDao.getObjectsByCondition(queryString, p);
	}


}
