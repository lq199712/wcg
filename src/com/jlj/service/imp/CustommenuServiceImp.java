package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.ICustommenuDao;
import com.jlj.model.Custommenu;
import com.jlj.service.ICustommenuService;
@Component("custommenuService")
public class CustommenuServiceImp implements ICustommenuService {
	private ICustommenuDao custommenuDao;
	public ICustommenuDao getCustommenuDao() {
		return custommenuDao;
	}
	@Resource
	public void setCustommenuDao(ICustommenuDao custommenuDao) {
		this.custommenuDao = custommenuDao;
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ICustommenuService#add(com.jlj.model.Custommenu)
	 */
	public void add(Custommenu custommenu) throws Exception {
		custommenuDao.save(custommenu);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ICustommenuService#delete(com.jlj.model.Custommenu)
	 */
	public void delete(Custommenu custommenu) {
		custommenuDao.delete(custommenu);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ICustommenuService#deleteById(int)
	 */
	public void deleteById(int id) {
		custommenuDao.deleteById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ICustommenuService#update(com.jlj.model.Custommenu)
	 */
	public void update(Custommenu custommenu) {
		custommenuDao.update(custommenu);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ICustommenuService#getCustommenus()
	 */
	public List<Custommenu> getCustommenus() {
		return custommenuDao.getCustommenus();
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ICustommenuService#loadById(int)
	 */
	public Custommenu loadById(int id) {
		return custommenuDao.loadById(id);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ICustommenuService#getPageCount(int, java.lang.String, int, java.lang.String, int)
	 */
	public int getPageCount(int con, String convalue, int status, String publicaccount,
			int size) {
		int totalCount=this.getTotalCount(con, convalue, status, publicaccount);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ICustommenuService#getTotalCount(int, java.lang.String, int, java.lang.String)
	 */
	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Custommenu mo where mo.publicaccount=? ";
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
		return custommenuDao.getUniqueResult(queryString,p);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ICustommenuService#queryList(int, java.lang.String, int, java.lang.String, int, int)
	 */
	public List<Custommenu> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Custommenu mo where mo.publicaccount=? ";
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
		return custommenuDao.pageList(queryString,p,page,size);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ICustommenuService#getCustommenusByPublicAccount(java.lang.String)
	 */
	public List<Custommenu> getCustommenusByPublicAccount(String paccount) {
		String queryString = "from Custommenu mo where mo.publicaccount = ?";
		Object[] p= new Object[]{paccount};
		return custommenuDao.getObjectsByCondition(queryString, p);
	}
	public Custommenu queryCustommenuByPublicAccount(String paccount) {
		String queryString = "from Custommenu mo where mo.publicaccount=:paccount ";
		String[] paramNames = new String[]{"paccount"};
		Object[] values = new Object[]{paccount};
		return custommenuDao.queryByNamedParam(queryString, paramNames, values);
	}
	
	

}
