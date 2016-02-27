package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IKeyresDao;
import com.jlj.model.Keyres;
import com.jlj.service.IGuanzhuresService;
import com.jlj.service.IKeyresService;
@Component("keyresService")
public class KeyresServiceImp implements IKeyresService{
	private IKeyresDao keyresDao;
	public IKeyresDao getKeyresDao() {
		return keyresDao;
	}
	@Resource
	public void setKeyresDao(IKeyresDao keyresDao) {
		this.keyresDao = keyresDao;
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IKeyresService#add(com.jlj.model.Keyres)
	 */
	public void add(Keyres keyres) throws Exception {
		keyresDao.save(keyres);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IKeyresService#delete(com.jlj.model.Keyres)
	 */
	public void delete(Keyres keyres) {
		keyresDao.delete(keyres);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IKeyresService#deleteById(int)
	 */
	public void deleteById(int id) {
		keyresDao.deleteById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IKeyresService#update(com.jlj.model.Keyres)
	 */
	public void update(Keyres keyres) {
		keyresDao.update(keyres);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IKeyresService#getKeyress()
	 */
	public List<Keyres> getKeyress() {
		return keyresDao.getKeyress();
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IKeyresService#loadById(int)
	 */
	public Keyres loadById(int id) {
		return keyresDao.loadById(id);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IKeyresService#getPageCountByPkid(int, java.lang.String, int, int, int)
	 */
	public int getPageCountByPkid(int con, String convalue, int status, int pkid,
			int size) {
		int totalCount=this.getTotalCountByPkid(con, convalue, status, pkid);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IKeyresService#getTotalCountByPkid(int, java.lang.String, int, int)
	 */
	public int getTotalCountByPkid(int con, String convalue, int status, int pkid) {
		String queryString = "select count(*) from Keyres mo where mo.publickey.id=? ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//关键字
			if(con==1){
				queryString += "and mo.keytitle like ? "; 
			}
			p = new Object[]{pkid,'%'+convalue+'%'};
		}else{
			p = new Object[]{pkid};
		}
		return keyresDao.getUniqueResult(queryString,p);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IKeyresService#queryListByPkid(int, java.lang.String, int, int, int, int)
	 */
	public List<Keyres> queryListByPkid(int con, String convalue, int status,
			int pkid, int page, int size) {
		String queryString = "from Keyres mo where mo.publickey.id=? ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//关键字
			if(con==1){
				queryString += "and mo.keytitle like ? "; 
			}
			p = new Object[]{pkid,'%'+convalue+'%'};
		}else{
			p = new Object[]{pkid};
		}
		queryString += " order by mo.id desc ";
		return keyresDao.pageList(queryString,p,page,size);
	}

}
