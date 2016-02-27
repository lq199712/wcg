package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IAutoresDao;
import com.jlj.model.Autores;
import com.jlj.service.IAutoresService;
@Component("autoresService")
public class AutoresServiceImp implements IAutoresService {
	private IAutoresDao autoresDao;
	public IAutoresDao getAutoresDao() {
		return autoresDao;
	}
	@Resource
	public void setAutoresDao(IAutoresDao autoresDao) {
		this.autoresDao = autoresDao;
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IAutoresService#add(com.jlj.model.Autores)
	 */
	public void add(Autores autores) throws Exception {
		autoresDao.save(autores);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IAutoresService#delete(com.jlj.model.Autores)
	 */
	public void delete(Autores autores) {
		autoresDao.delete(autores);
	}
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IAutoresService#deleteById(int)
	 */
	public void deleteById(int id) {
		autoresDao.deleteById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IAutoresService#update(com.jlj.model.Autores)
	 */
	public void update(Autores autores) {
		autoresDao.update(autores);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IAutoresService#getAutoress()
	 */
	public List<Autores> getAutoress() {
		return autoresDao.getAutoress();
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IAutoresService#loadById(int)
	 */
	public Autores loadById(int id) {
		return autoresDao.loadById(id);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IAutoresService#getPageCount(int, java.lang.String, int, java.lang.String, int)
	 */
	public int getPageCount(int con, String convalue, int status, String publicaccount,
			int size) {
		int totalCount=this.getTotalCount(con, convalue, status, publicaccount);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IAutoresService#getTotalCount(int, java.lang.String, int, java.lang.String)
	 */
	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Autores mo where mo.publicaccount=? ";
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
		return autoresDao.getUniqueResult(queryString,p);
	}
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IAutoresService#queryList(int, java.lang.String, int, java.lang.String, int, int)
	 */
	public List<Autores> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Autores mo where mo.publicaccount=? ";
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
		queryString += " order by mo.id desc ";
		return autoresDao.pageList(queryString,p,page,size);
	}
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IAutoresService#queryListByPublicAccount(java.lang.String)
	 */
	public List<Autores> queryListByPublicAccount(String publicaccount) {
		String queryString = "from Autores mo where mo.publicaccount = ?";
		Object[] p = new Object[]{publicaccount};
		return autoresDao.getObjectsByCondition(queryString, p);
	}
	
	

}
