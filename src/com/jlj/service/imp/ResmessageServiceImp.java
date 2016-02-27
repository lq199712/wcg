package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IResmessageDao;
import com.jlj.model.Resmessage;
import com.jlj.service.IResmessageService;
@Component("resmessageService")
public class ResmessageServiceImp implements IResmessageService {
	private IResmessageDao resmessageDao;
	public IResmessageDao getResmessageDao() {
		return resmessageDao;
	}
	@Resource
	public void setResmessageDao(IResmessageDao resmessageDao) {
		this.resmessageDao = resmessageDao;
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IResmessageService#add(com.jlj.model.Resmessage)
	 */
	public void add(Resmessage resmessage) throws Exception {
		resmessageDao.save(resmessage);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IResmessageService#delete(com.jlj.model.Resmessage)
	 */
	public void delete(Resmessage resmessage) {
		resmessageDao.delete(resmessage);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IResmessageService#deleteById(int)
	 */
	public void deleteById(int id) {
		resmessageDao.deleteById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IResmessageService#update(com.jlj.model.Resmessage)
	 */
	public void update(Resmessage resmessage) {
		resmessageDao.update(resmessage);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IResmessageService#getResmessages()
	 */
	public List<Resmessage> getResmessages() {
		return resmessageDao.getResmessages();
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IResmessageService#loadById(int)
	 */
	public Resmessage loadById(int id) {
		return resmessageDao.loadById(id);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IResmessageService#getPageCount(int, java.lang.String, int, java.lang.String, int)
	 */
	public int getPageCount(int con, String convalue, int status, String publicaccount,
			int size) {
		int totalCount=this.getTotalCount(con, convalue, status, publicaccount);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IResmessageService#getTotalCount(int, java.lang.String, int, java.lang.String)
	 */
	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Resmessage mo where mo.publicaccount=? ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//大类别名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}
			p = new Object[]{publicaccount,'%'+convalue+'%'};
		}else{
			p = new Object[]{publicaccount};
		}
		return resmessageDao.getUniqueResult(queryString,p);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IResmessageService#queryList(int, java.lang.String, int, java.lang.String, int, int)
	 */
	public List<Resmessage> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Resmessage mo where mo.publicaccount=? ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//大类别名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}
			p = new Object[]{publicaccount,'%'+convalue+'%'};
		}else{
			p = new Object[]{publicaccount};
		}
		queryString += " order by mo.id asc ";
		return resmessageDao.pageList(queryString,p,page,size);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IResmessageService#getResmessagesByPublicAccount(java.lang.String)
	 */
	public List<Resmessage> getResmessagesByPublicAccount(String paccount) {
		String queryString = "from Resmessage mo where mo.publicaccount = ?";
		Object[] p= new Object[]{paccount};
		return resmessageDao.getObjectsByCondition(queryString, p);
	}
	
	

}
