package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWoptionDao;
import com.jlj.model.Woption;
import com.jlj.service.IWoptionService;
@Component("woptionService")
public class WoptionServiceImp implements IWoptionService {
	private IWoptionDao woptionDao;
	public IWoptionDao getWoptionDao() {
		return woptionDao;
	}
	@Resource
	public void setWoptionDao(IWoptionDao woptionDao) {
		this.woptionDao = woptionDao;
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IWoptionService#add(com.jlj.model.Woption)
	 */
	public void add(Woption woption) throws Exception {
		woptionDao.save(woption);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IWoptionService#delete(com.jlj.model.Woption)
	 */
	public void delete(Woption woption) {
		woptionDao.delete(woption);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IWoptionService#deleteById(int)
	 */
	public void deleteById(int id) {
		woptionDao.deleteById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IWoptionService#update(com.jlj.model.Woption)
	 */
	public void update(Woption woption) {
		woptionDao.update(woption);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IWoptionService#getWoptions()
	 */
	public List<Woption> getWoptions() {
		return woptionDao.getWoptions();
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IWoptionService#loadById(int)
	 */
	public Woption loadById(int id) {
		return woptionDao.loadById(id);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IWoptionService#getPageCount(int, java.lang.String, int)
	 */
	public int getPageCount(int con, String convalue,int size) {
		int totalCount=this.getTotalCount(con, convalue);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IWoptionService#getTotalCount(int, java.lang.String)
	 */
	public int getTotalCount(int con, String convalue) {
		String queryString = "select count(*) from Woption mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//用户名
			if(con==1){
				queryString += " and mo.username like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}
		return woptionDao.getUniqueResult(queryString,p);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IWoptionService#queryList(int, java.lang.String, int, int)
	 */
	public List<Woption> queryList(int con, String convalue,  int page, int size) {
		String queryString = "from Woption mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//用户名
			if(con==1){
				queryString += " and mo.username like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}
		queryString += " order by mo.id asc ";
		return woptionDao.pageList(queryString,p,page,size);
	}
	public List<Woption> queryListBywid(Integer wid) {
		String queryString = "from Woption mo where mo.wvote.id = ?";
		Object[] p = new Object[]{wid};
		return woptionDao.getObjectsByCondition(queryString, p);
	}

}
