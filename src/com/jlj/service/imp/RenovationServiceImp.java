package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IRenovationDao;
import com.jlj.model.Renovation;
import com.jlj.service.IRenovationService;

@Component("renovationService")
public class RenovationServiceImp implements IRenovationService {
	private IRenovationDao renovationDao;

	public IRenovationDao getRenovationDao() {
		return renovationDao;
	}

	@Resource
	public void setRenovationDao(IRenovationDao renovationDao) {
		this.renovationDao = renovationDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jlj.service.imp.IAutoresService#add(com.jlj.model.Autores)
	 */
	public void add(Renovation renovation) throws Exception {
		renovationDao.save(renovation);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jlj.service.imp.IRenovationService#delete(com.jlj.model.Renovation)
	 */
	public void delete(Renovation renovation) {
		renovationDao.delete(renovation);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jlj.service.imp.IRenovationService#deleteById(int)
	 */
	public void deleteById(int id) {
		renovationDao.deleteById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jlj.service.imp.IRenovationService#update(com.jlj.model.Renovation)
	 */
	public void update(Renovation renovation) {
		renovationDao.update(renovation);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jlj.service.imp.IRenovationService#getRenovations()
	 */
	public List<Renovation> getRenovations() {
		return renovationDao.getRenovations();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jlj.service.imp.IRenovationService#loadById(int)
	 */
	public Renovation loadById(int id) {
		return renovationDao.loadById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jlj.service.imp.IRenovationService#getPageCount(int,
	 *      java.lang.String, int, java.lang.String, int)
	 */
	public int getPageCount(int con, String convalue, int status,
			String publicaccount, int size) {
		int totalCount = this.getTotalCount(con, convalue, status,
				publicaccount);
		return totalCount % size == 0 ? totalCount / size
				: (totalCount / size + 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jlj.service.imp.IRenovationService#getTotalCount(int,
	 *      java.lang.String, int, java.lang.String)
	 */
	public int getTotalCount(int con, String convalue, int status,
			String publicaccount) {
		String queryString = "select count(*) from Renovation mo where mo.publicaccount=? ";
		Object[] p = null;
		if (con != 0 && convalue != null && !convalue.equals("")) {
			// 大类别名称
			if (con == 1) {
				queryString += "and mo.name like ? ";
			}
			p = new Object[] { publicaccount, '%' + convalue + '%' };
		} else {
			p = new Object[] { publicaccount };
		}
		return renovationDao.getUniqueResult(queryString, p);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jlj.service.imp.IRenovationService#queryList(int,
	 *      java.lang.String, int, java.lang.String, int, int)
	 */
	public List<Renovation> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Renovation mo where mo.publicaccount=? ";
		Object[] p = null;
		if (con != 0 && convalue != null && !convalue.equals("")) {
			// 大类别名称
			if (con == 1) {
				queryString += "and mo.name like ? ";
			}
			p = new Object[] { publicaccount, '%' + convalue + '%' };
		} else {
			p = new Object[] { publicaccount };
		}
		queryString += " order by mo.id desc ";
		return renovationDao.pageList(queryString, p, page, size);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jlj.service.imp.IRenovationService#queryListByPublicAccount(java.lang.String)
	 */
	public List<Renovation> queryListByPublicAccount(String publicaccount) {
		String queryString = "from Renovation mo where mo.publicaccount = ?";
		Object[] p = new Object[] { publicaccount };
		return renovationDao.getObjectsByCondition(queryString, p);
	}

	public List<Renovation> queryList(String ip) {

		String queryString = "from Renovation bw where bw.ip = ? order by bw.id desc ";
		Object[] p = new Object[] { ip };
		return renovationDao.getObjectsByCondition(queryString, p);
	}

	public int getPageCount(int con, String convalue, int size) {
		int totalCount = this.getTotalCount(con, convalue);
		return totalCount % size == 0 ? totalCount / size
				: (totalCount / size + 1);
	}

	public int getTotalCount(int con, String convalue) {
		String queryString = "select count(*) from Renovation mo where 1=1";
		Object[] p = null;
		if (con != 0 && convalue != null && !convalue.equals("")) {
			// 大类别名称
			if (con == 1) {
				queryString += " and mo.name like ? ";
				
				p = new Object[] { '%' + convalue + '%' };
			}
			else if(con == 2)
			{
				queryString += " and mo.renostate = ? ";
				
				p = new Object[] { Integer.parseInt(convalue)};
			}
		} else {
			p = new Object[] {};
		}
		return renovationDao.getUniqueResult(queryString, p);
	}

	public List<Renovation> queryList(int con, String convalue, int page,
			int size) {
		String queryString = "from Renovation mo where 1=1";
		Object[] p = null;
		if (con != 0 && convalue != null && !convalue.equals("")) {
			// 大类别名称
			if (con == 1) {
				queryString += "and mo.name like ? ";
				
				p = new Object[] { '%' + convalue + '%' };
			}
			else if(con == 2)
			{
				queryString += "and mo.renostate = ? ";
				
				p = new Object[] { Integer.parseInt(convalue)};
			}
		} else {
			p = new Object[] {};
		}
		queryString += " order by mo.id desc ";
		return renovationDao.pageList(queryString, p, page, size);
	}

	public List<Renovation> queryList(int comptype, String comptime, String name) {
		String queryString = "from Renovation bw where bw.comptype = ? and  bw.comptime like ? and bw.name like ? order by bw.id desc ";
		Object[] p = new Object[] { comptype,'%' + comptime + '%','%' + name + '%' };
		return renovationDao.getObjectsByCondition(queryString, p);
	}

	public List<Renovation> queryListByRenostate(int renostate) {
		String queryString = "from Renovation mo where mo.renostate = ?";
		Object[] p = new Object[] { renostate };
		return renovationDao.getObjectsByCondition(queryString, p);
	}

	public List<Renovation> queryListByToday(String today,String tomorrow) {
		// TODO Auto-generated method stub
		String queryString = "from Renovation mo where  mo.reporttime <='"+tomorrow+"'"+" and mo.reporttime >='"+today+"'";
		return renovationDao.queryList(queryString);
	}

}
