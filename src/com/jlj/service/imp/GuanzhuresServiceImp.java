package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IGuanzhuresDao;
import com.jlj.model.Guanzhures;
import com.jlj.service.IGuanzhuresService;
@Component("guanzhuresService")
public class GuanzhuresServiceImp implements IGuanzhuresService{
	private IGuanzhuresDao guanzhuresDao;
	public IGuanzhuresDao getGuanzhuresDao() {
		return guanzhuresDao;
	}
	@Resource
	public void setGuanzhuresDao(IGuanzhuresDao guanzhuresDao) {
		this.guanzhuresDao = guanzhuresDao;
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IGuanzhuresService#add(com.jlj.model.Guanzhures)
	 */
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IGuanzhuresService#add(com.jlj.model.Guanzhures)
	 */
	public void add(Guanzhures guanzhures) throws Exception {
		guanzhuresDao.save(guanzhures);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IGuanzhuresService#delete(com.jlj.model.Guanzhures)
	 */
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IGuanzhuresService#delete(com.jlj.model.Guanzhures)
	 */
	public void delete(Guanzhures guanzhures) {
		guanzhuresDao.delete(guanzhures);
	}
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IGuanzhuresService#deleteById(int)
	 */
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IGuanzhuresService#deleteById(int)
	 */
	public void deleteById(int id) {
		guanzhuresDao.deleteById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IGuanzhuresService#update(com.jlj.model.Guanzhures)
	 */
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IGuanzhuresService#update(com.jlj.model.Guanzhures)
	 */
	public void update(Guanzhures guanzhures) {
		guanzhuresDao.update(guanzhures);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IGuanzhuresService#getGuanzhuress()
	 */
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IGuanzhuresService#getGuanzhuress()
	 */
	public List<Guanzhures> getGuanzhuress() {
		return guanzhuresDao.getGuanzhuress();
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IGuanzhuresService#loadById(int)
	 */
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IGuanzhuresService#loadById(int)
	 */
	public Guanzhures loadById(int id) {
		return guanzhuresDao.loadById(id);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IGuanzhuresService#getPageCount(int, java.lang.String, int, int, int)
	 */
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IGuanzhuresService#getPageCount(int, java.lang.String, int, java.lang.String, int)
	 */
	public int getPageCount(int con, String convalue, int status, String publicaccount,
			int size) {
		int totalCount=this.getTotalCount(con, convalue, status, publicaccount);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IGuanzhuresService#getTotalCount(int, java.lang.String, int, int)
	 */
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IGuanzhuresService#getTotalCount(int, java.lang.String, int, java.lang.String)
	 */
	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Guanzhures mo where mo.publicaccount=? ";
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
		return guanzhuresDao.getUniqueResult(queryString,p);
	}
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IGuanzhuresService#queryList(int, java.lang.String, int, int, int, int)
	 */
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IGuanzhuresService#queryList(int, java.lang.String, int, java.lang.String, int, int)
	 */
	public List<Guanzhures> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Guanzhures mo where mo.publicaccount=? ";
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
		return guanzhuresDao.pageList(queryString,p,page,size);
	}
	public List<Guanzhures> queryListByPublicAccount(String publicaccount) {
		String queryString = "from Guanzhures mo where mo.publicaccount = ?";
		Object[] p = new Object[]{publicaccount};
		return guanzhuresDao.getObjectsByCondition(queryString, p);
	}
	
	

}
