package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWdyDao;
import com.jlj.model.Wdy;
import com.jlj.service.IWdyService;
@Component("wdyService")
public class WdyServiceImp implements IWdyService {
	private IWdyDao wdyDao;
	public IWdyDao getWdyDao() {
		return wdyDao;
	}
	@Resource
	public void setWdyDao(IWdyDao wdyDao) {
		this.wdyDao = wdyDao;
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IWdyService#add(com.jlj.model.Wdy)
	 */
	public void add(Wdy wdy) throws Exception {
		wdyDao.save(wdy);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IWdyService#delete(com.jlj.model.Wdy)
	 */
	public void delete(Wdy wdy) {
		wdyDao.delete(wdy);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IWdyService#deleteById(int)
	 */
	public void deleteById(int id) {
		wdyDao.deleteById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IWdyService#update(com.jlj.model.Wdy)
	 */
	public void update(Wdy wdy) {
		wdyDao.update(wdy);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IWdyService#getWdys()
	 */
	public List<Wdy> getWdys() {
		return wdyDao.getWdys();
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IWdyService#loadById(int)
	 */
	public Wdy loadById(int id) {
		return wdyDao.loadById(id);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IWdyService#getPageCount(int, java.lang.String, int)
	 */
	public int getPageCount(int con, String convalue,int size) {
		int totalCount=this.getTotalCount(con, convalue);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IWdyService#getTotalCount(int, java.lang.String)
	 */
	public int getTotalCount(int con, String convalue) {
		String queryString = "select count(*) from Wdy mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//用户名
			if(con==1){
				queryString += " and mo.username like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}
		return wdyDao.getUniqueResult(queryString,p);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IWdyService#queryList(int, java.lang.String, int, int)
	 */
	public List<Wdy> queryList(int con, String convalue,  int page, int size) {
		String queryString = "from Wdy mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//用户名
			if(con==1){
				queryString += " and mo.username like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}
		queryString += " order by mo.id asc ";
		return wdyDao.pageList(queryString,p,page,size);
	}
	public List<Wdy> queryListBywid(Integer wid) {
		String queryString = "from Wdy mo where mo.wvote.id = ?";
		Object[] p = new Object[]{wid};
		return wdyDao.getObjectsByCondition(queryString, p);
	}

}
