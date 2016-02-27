package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.ISontypeDao;
import com.jlj.model.Sontype;
import com.jlj.service.ISontypeService;
@Component("sontypeService")
public class SontypeServiceImp implements ISontypeService{
	private ISontypeDao sontypeDao;
	public ISontypeDao getSontypeDao() {
		return sontypeDao;
	}
	@Resource
	public void setSontypeDao(ISontypeDao sontypeDao) {
		this.sontypeDao = sontypeDao;
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISontypeService#add(com.jlj.model.Sontype)
	 */
	public void add(Sontype sontype) throws Exception {
		sontypeDao.save(sontype);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISontypeService#delete(com.jlj.model.Sontype)
	 */
	public void delete(Sontype sontype) {
		sontypeDao.delete(sontype);
	}
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISontypeService#deleteById(int)
	 */
	public void deleteById(int id) {
		sontypeDao.deleteById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISontypeService#update(com.jlj.model.Sontype)
	 */
	public void update(Sontype sontype) {
		sontypeDao.update(sontype);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISontypeService#getSontypes()
	 */
	public List<Sontype> getSontypes() {
		return sontypeDao.getSontypes();
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISontypeService#loadById(int)
	 */
	public Sontype loadById(int id) {
		return sontypeDao.loadById(id);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISontypeService#getPageCount(int, java.lang.String, int, java.lang.String, int)
	 */
	public int getPageCount(int con, String convalue, int status, String publicaccount,
			int size) {
		int totalCount=this.getTotalCount(con, convalue, status, publicaccount);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISontypeService#getTotalCount(int, java.lang.String, int, java.lang.String)
	 */
	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Sontype mo where mo.producttype=? and mo.bigtype.publicaccount=? ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//子类别名称、大类别名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}else if(con==2){
				queryString += "and mo.bigtype.name like ? "; 
			}
			p = new Object[]{status,publicaccount,'%'+convalue+'%'};
		}else{
			p = new Object[]{status,publicaccount};
		}
		return sontypeDao.getUniqueResult(queryString,p);
	}
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISontypeService#queryList(int, java.lang.String, int, java.lang.String, int, int)
	 */
	public List<Sontype> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Sontype mo where mo.producttype=? and mo.bigtype.publicaccount=? ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//子类别名称、大类别名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}else if(con==2){
				queryString += "and mo.bigtype.name like ? "; 
			}
			p = new Object[]{status,publicaccount,'%'+convalue+'%'};
		}else{
			p = new Object[]{status,publicaccount};
		}
		queryString += " order by mo.orderid asc ";
		return sontypeDao.pageList(queryString,p,page,size);
	}
	public List<Sontype> getSontypesByPublicAccount(String paccount,int producttype) {
		String queryString = "from Sontype mo where mo.bigtype.publicaccount=? and mo.producttype=?";
		Object[] p= new Object[]{paccount,producttype};
		return sontypeDao.getObjectsByCondition(queryString, p);
	}
	public List<Sontype> querySontypeByCondition(int btid) {
		String queryString = "from Sontype mo where mo.bigtype.id=? order by mo.orderid asc";
		Object[] p= new Object[]{btid};
		return sontypeDao.getObjectsByCondition(queryString, p);
	}
	
	

}
