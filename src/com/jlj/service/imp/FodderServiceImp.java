package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IFodderDao;
import com.jlj.model.Fodder;
import com.jlj.service.IFodderService;
@Component("fodderService")
public class FodderServiceImp implements IFodderService{
	private IFodderDao fodderDao;
	public IFodderDao getFodderDao() {
		return fodderDao;
	}
	@Resource
	public void setFodderDao(IFodderDao fodderDao) {
		this.fodderDao = fodderDao;
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IFodderService#add(com.jlj.model.Fodder)
	 */
	public void add(Fodder fodder) throws Exception {
		fodderDao.save(fodder);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IFodderService#add(com.jlj.model.Fodder)
	 */
	public int addreturn(Fodder fodder) throws Exception {
		return fodderDao.savereturn(fodder);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IFodderService#delete(com.jlj.model.Fodder)
	 */
	public void delete(Fodder fodder) {
		fodderDao.delete(fodder);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IFodderService#deleteById(int)
	 */
	public void deleteById(int id) {
		fodderDao.deleteById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IFodderService#update(com.jlj.model.Fodder)
	 */
	public void update(Fodder fodder) {
		fodderDao.update(fodder);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IFodderService#getFodders()
	 */
	public List<Fodder> getFodders() {
		return fodderDao.getFodders();
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IFodderService#loadById(int)
	 */
	public Fodder loadById(int id) {
		return fodderDao.loadById(id);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IFodderService#getPageCount(int, java.lang.String, int, java.lang.String, int)
	 */
	public int getPageCount(int con, String convalue, int status, String publicaccount,
			int size) {
		int totalCount=this.getTotalCount(con, convalue, status, publicaccount);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IFodderService#getTotalCount(int, java.lang.String, int, java.lang.String)
	 */
	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Fodder mo where mo.publicaccount=? and mo.savetype=? ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//标题名称
			if(con==1){
				queryString += "and mo.title like ? "; 
			}
			p = new Object[]{publicaccount,status,'%'+convalue+'%'};
		}else{
			p = new Object[]{publicaccount,status};
		}
		return fodderDao.getUniqueResult(queryString,p);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IFodderService#queryList(int, java.lang.String, int, java.lang.String, int, int)
	 */
	public List<Fodder> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Fodder mo where mo.publicaccount=? and mo.savetype=? ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//标题名称
			if(con==1){
				queryString += "and mo.title like ? "; 
			}
			p = new Object[]{publicaccount,status,'%'+convalue+'%'};
		}else{
			p = new Object[]{publicaccount,status};
		}
		queryString += " order by mo.id desc ";
		return fodderDao.pageList(queryString,p,page,size);
	}
	
	public void updateArticleCount(int articlecount, int fodderid) {
		String hql = "update Fodder mo set mo.articlecount=:articlecount where mo.id=:fodderid";
		String[] paramNames = new String[]{"articlecount","fodderid"};
		Object[] values = new Object[]{articlecount,fodderid};
		fodderDao.updateByHql(hql, paramNames, values);
	}
	public int getSavetypeTotalCount(int con, String convalue, int status,
			String publicaccount) {
		String queryString = "select count(*) from Fodder mo where mo.publicaccount=? ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//标题名称
			if(con==1){
				queryString += " and mo.title like ? "; 
				if(status==0){
					p = new Object[]{publicaccount,'%'+convalue+'%'};
				}else{
					queryString += " and mo.savetype=? "; 
					p = new Object[]{publicaccount,'%'+convalue+'%',status};
				}
			}
			
			
		}else{
			if(status==0){
				p = new Object[]{publicaccount};
			}else{
				queryString += " and mo.savetype=? "; 
				p = new Object[]{publicaccount,status};
			}
			
		}
		return fodderDao.getUniqueResult(queryString, p);
	}
	public List<Fodder> querySavetypeList(int con, String convalue, int status,
			String publicaccount) {
		String queryString = "from Fodder mo where mo.publicaccount=? ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//标题名称
			if(con==1){
				queryString += " and mo.title like ? "; 
				if(status==0){
					p = new Object[]{publicaccount,'%'+convalue+'%'};
				}else{
					queryString += " and mo.savetype=? "; 
					p = new Object[]{publicaccount,'%'+convalue+'%',status};
				}
			}
			
			
		}else{
			if(status==0){
				p = new Object[]{publicaccount};
			}else{
				queryString += " and mo.savetype=? "; 
				p = new Object[]{publicaccount,status};
			}
			
		}
		queryString += " order by mo.id desc ";
		return fodderDao.getObjectsByCondition(queryString, p);
	}
	public List<Fodder> getFoddersByPublicAccount(String paccount) {
		String queryString = "from Fodder mo where mo.publicaccount = ?";
		Object[] p = new Object[]{paccount};
		return fodderDao.getObjectsByCondition(queryString, p);
	}
	
	

}
