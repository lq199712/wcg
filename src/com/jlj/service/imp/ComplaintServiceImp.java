package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IComplaintDao;
import com.jlj.model.Complaint;
import com.jlj.service.IComplaintService;

@Component("complaintService")
public class ComplaintServiceImp implements IComplaintService {
	private IComplaintDao complaintDao;

	public IComplaintDao getComplaintDao() {
		return complaintDao;
	}

	@Resource
	public void setComplaintDao(IComplaintDao complaintDao) {
		this.complaintDao = complaintDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jlj.service.imp.IAutoresService#add(com.jlj.model.Autores)
	 */
	public void add(Complaint complaint) throws Exception {
		complaintDao.save(complaint);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jlj.service.imp.IComplaintService#delete(com.jlj.model.Complaint)
	 */
	public void delete(Complaint complaint) {
		complaintDao.delete(complaint);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jlj.service.imp.IComplaintService#deleteById(int)
	 */
	public void deleteById(int id) {
		complaintDao.deleteById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jlj.service.imp.IComplaintService#update(com.jlj.model.Complaint)
	 */
	public void update(Complaint complaint) {
		complaintDao.update(complaint);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jlj.service.imp.IComplaintService#getComplaints()
	 */
	public List<Complaint> getComplaints() {
		return complaintDao.getComplaints();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jlj.service.imp.IComplaintService#loadById(int)
	 */
	public Complaint loadById(int id) {
		return complaintDao.loadById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jlj.service.imp.IComplaintService#getPageCount(int,
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
	 * @see com.jlj.service.imp.IComplaintService#getTotalCount(int,
	 *      java.lang.String, int, java.lang.String)
	 */
	public int getTotalCount(int con, String convalue, int status,
			String publicaccount) {
		String queryString = "select count(*) from Complaint mo where mo.publicaccount=? ";
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
		return complaintDao.getUniqueResult(queryString, p);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jlj.service.imp.IComplaintService#queryList(int,
	 *      java.lang.String, int, java.lang.String, int, int)
	 */
	public List<Complaint> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Complaint mo where mo.publicaccount=? ";
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
		return complaintDao.pageList(queryString, p, page, size);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jlj.service.imp.IComplaintService#queryListByPublicAccount(java.lang.String)
	 */
	public List<Complaint> queryListByPublicAccount(String publicaccount) {
		String queryString = "from Complaint mo where mo.publicaccount = ?";
		Object[] p = new Object[] { publicaccount };
		return complaintDao.getObjectsByCondition(queryString, p);
	}

	public List<Complaint> queryList(String ip) {

		String queryString = "from Complaint bw where bw.ip = ? order by bw.id desc ";
		Object[] p = new Object[] { ip };
		return complaintDao.getObjectsByCondition(queryString, p);
	}

	public int getPageCount(int con, String convalue, int size) {
		int totalCount = this.getTotalCount(con, convalue);
		return totalCount % size == 0 ? totalCount / size
				: (totalCount / size + 1);
	}

	public int getTotalCount(int con, String convalue) {
		String queryString = "select count(*) from Complaint mo where 1=1";
		Object[] p = null;
		if (con != 0 && convalue != null && !convalue.equals("")) {
			// 大类别名称
			if (con == 1) {
				queryString += " and mo.name like ? ";
				
				p = new Object[] { '%' + convalue + '%' };
			}
			else if(con == 2)
			{
				queryString += " and mo.compstate = ? ";
				
				p = new Object[] { Integer.parseInt(convalue)};
			}
		} else {
			p = new Object[] {};
		}
		return complaintDao.getUniqueResult(queryString, p);
	}

	public List<Complaint> queryList(int con, String convalue, int page,
			int size) {
		String queryString = "from Complaint mo where 1=1";
		Object[] p = null;
		if (con != 0 && convalue != null && !convalue.equals("")) {
			// 大类别名称
			if (con == 1) {
				queryString += "and mo.name like ? ";
				
				p = new Object[] { '%' + convalue + '%' };
			}
			else if(con == 2)
			{
				queryString += "and mo.compstate = ? ";
				
				p = new Object[] { Integer.parseInt(convalue)};
			}
		} else {
			p = new Object[] {};
		}
		queryString += " order by mo.id desc ";
		return complaintDao.pageList(queryString, p, page, size);
	}

	public List<Complaint> queryList(int comptype, String comptime, String name) {
		String queryString = "from Complaint bw where bw.comptype = ? and  bw.comptime like ? and bw.name like ? order by bw.id desc ";
		Object[] p = new Object[] { comptype,'%' + comptime + '%','%' + name + '%' };
		return complaintDao.getObjectsByCondition(queryString, p);
	}

}
