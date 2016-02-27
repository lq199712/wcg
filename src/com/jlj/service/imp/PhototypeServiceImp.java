package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IPhototypeDao;
import com.jlj.model.Phototype;
import com.jlj.service.IPhototypeService;
@Component("phototypeService")
public class PhototypeServiceImp implements IPhototypeService{
	private IPhototypeDao phototypeDao;
	public IPhototypeDao getPhototypeDao() {
		return phototypeDao;
	}
	@Resource
	public void setPhototypeDao(IPhototypeDao phototypeDao) {
		this.phototypeDao = phototypeDao;
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPhototypeService#add(com.jlj.model.Phototype)
	 */
	public void add(Phototype phototype) throws Exception {
		phototypeDao.save(phototype);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPhototypeService#delete(com.jlj.model.Phototype)
	 */
	public void delete(Phototype phototype) {
		phototypeDao.delete(phototype);
	}
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPhototypeService#deleteById(int)
	 */
	public void deleteById(int id) {
		phototypeDao.deleteById(id);
	}
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPhototypeService#update(com.jlj.model.Phototype)
	 */
	public void update(Phototype phototype) {
		phototypeDao.update(phototype);
	}
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPhototypeService#getPhototypes()
	 */
	public List<Phototype> getPhototypes() {
		return phototypeDao.getPhototypes();
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPhototypeService#loadById(int)
	 */
	public Phototype loadById(int id) {
		return phototypeDao.loadById(id);
	}
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPhototypeService#getPageCount(int, java.lang.String, int, java.lang.String, int)
	 */
	public int getPageCount(int con, String convalue, int status, String publicaccount,
			int size) {
		int totalCount=this.getTotalCount(con, convalue, status, publicaccount);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPhototypeService#getTotalCount(int, java.lang.String, int, java.lang.String)
	 */
	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Phototype mo where mo.publicaccount=? ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//相册类型名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}
			p = new Object[]{publicaccount,'%'+convalue+'%'};
		}else{
			p = new Object[]{publicaccount};
		}
		return phototypeDao.getUniqueResult(queryString,p);
	}
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPhototypeService#queryList(int, java.lang.String, int, java.lang.String, int, int)
	 */
	public List<Phototype> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Phototype mo where mo.publicaccount=? ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//相册类型名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}
			p = new Object[]{publicaccount,'%'+convalue+'%'};
		}else{
			p = new Object[]{publicaccount};
		}
		queryString += " order by mo.id desc ";
		return phototypeDao.pageList(queryString,p,page,size);
	}
	public List<Phototype> getPhototypesByPublicAccount(String publicaccount) {
		String queryString = "from Phototype mo where mo.publicaccount = ?";
		Object[] p= new Object[]{publicaccount};
		return phototypeDao.getObjectsByCondition(queryString, p);
	}
	
	

}
