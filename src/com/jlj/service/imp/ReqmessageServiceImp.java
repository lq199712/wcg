package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IReqmessageDao;
import com.jlj.model.Reqmessage;
import com.jlj.service.IReqmessageService;
@Component("reqmessageService")
public class ReqmessageServiceImp implements IReqmessageService {
	private IReqmessageDao reqmessageDao;
	public IReqmessageDao getReqmessageDao() {
		return reqmessageDao;
	}
	@Resource
	public void setReqmessageDao(IReqmessageDao reqmessageDao) {
		this.reqmessageDao = reqmessageDao;
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IReqmessageService#add(com.jlj.model.Reqmessage)
	 */
	public void add(Reqmessage reqmessage) throws Exception {
		reqmessageDao.save(reqmessage);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IReqmessageService#delete(com.jlj.model.Reqmessage)
	 */
	public void delete(Reqmessage reqmessage) {
		reqmessageDao.delete(reqmessage);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IReqmessageService#deleteById(int)
	 */
	public void deleteById(int id) {
		reqmessageDao.deleteById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IReqmessageService#update(com.jlj.model.Reqmessage)
	 */
	public void update(Reqmessage reqmessage) {
		reqmessageDao.update(reqmessage);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IReqmessageService#getReqmessages()
	 */
	public List<Reqmessage> getReqmessages() {
		return reqmessageDao.getReqmessages();
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IReqmessageService#loadById(int)
	 */
	public Reqmessage loadById(int id) {
		return reqmessageDao.loadById(id);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IReqmessageService#getPageCount(int, java.lang.String, int, java.lang.String, int)
	 */
	public int getPageCount(int con, String convalue, int status, String publicaccount,
			int size) {
		int totalCount=this.getTotalCount(con, convalue, status, publicaccount);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IReqmessageService#getTotalCount(int, java.lang.String, int, java.lang.String)
	 */
	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Reqmessage mo where mo.tousername=? ";
		Object[] p = new Object[]{publicaccount};
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//日期
			if(con==1){
				queryString += " and mo.reqtime = '"+ convalue +"'"; 
			}
		}
		return reqmessageDao.getUniqueResult(queryString,p);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IReqmessageService#queryList(int, java.lang.String, int, java.lang.String, int, int)
	 */
	public List<Reqmessage> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Reqmessage mo where mo.tousername=? ";
		Object[] p = new Object[]{publicaccount};
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//日期
			if(con==1){
				queryString += " and mo.reqtime = '"+ convalue +"'"; 
			}
		}
		queryString += " order by mo.id asc ";
		return reqmessageDao.pageList(queryString,p,page,size);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IReqmessageService#getReqmessagesByPublicAccount(java.lang.String)
	 */
	public List<Reqmessage> getReqmessagesByPublicAccount(String paccount) {
		String queryString = "from Reqmessage mo where mo.tousername = ?";
		Object[] p= new Object[]{paccount};
		return reqmessageDao.getObjectsByCondition(queryString, p);
	}
	
	

}
