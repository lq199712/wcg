package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWvoteDao;
import com.jlj.model.Wvote;
import com.jlj.service.IWvoteService;
@Component("wvoteService")
public class WvoteServiceImp implements IWvoteService {
	private IWvoteDao wvoteDao;
	public IWvoteDao getWvoteDao() {
		return wvoteDao;
	}
	@Resource
	public void setWvoteDao(IWvoteDao wvoteDao) {
		this.wvoteDao = wvoteDao;
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IWvoteService#add(com.jlj.model.Wvote)
	 */
	public void add(Wvote wvote) throws Exception {
		wvoteDao.save(wvote);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IWvoteService#delete(com.jlj.model.Wvote)
	 */
	public void delete(Wvote wvote) {
		wvoteDao.delete(wvote);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IWvoteService#deleteById(int)
	 */
	public void deleteById(int id) {
		wvoteDao.deleteById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IWvoteService#update(com.jlj.model.Wvote)
	 */
	public void update(Wvote wvote) {
		wvoteDao.update(wvote);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IWvoteService#getWvotes()
	 */
	public List<Wvote> getWvotes() {
		return wvoteDao.getWvotes();
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IWvoteService#loadById(int)
	 */
	public Wvote loadById(int id) {
		return wvoteDao.loadById(id);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IWvoteService#getPageCount(int, java.lang.String, int)
	 */
	public int getPageCount(int con, String convalue,int size) {
		int totalCount=this.getTotalCount(con, convalue);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IWvoteService#getTotalCount(int, java.lang.String)
	 */
	public int getTotalCount(int con, String convalue) {
		String queryString = "select count(*) from Wvote mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//用户名
			if(con==1){
				queryString += " and mo.username like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}
		return wvoteDao.getUniqueResult(queryString,p);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IWvoteService#queryList(int, java.lang.String, int, int)
	 */
	public List<Wvote> queryList(int con, String convalue,  int page, int size) {
		String queryString = "from Wvote mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//用户名
			if(con==1){
				queryString += " and mo.username like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}
		queryString += " order by mo.id asc ";
		return wvoteDao.pageList(queryString,p,page,size);
	}
	public Wvote getWvoteById(Integer id) {
		String queryString = "from Wvote mo where mo.id=:id";
		String[] paramNames = new String[] { "id" };
		Object[] values = new Object[] { id};
		return wvoteDao.queryByNamedParam(queryString, paramNames, values);
	}

}
