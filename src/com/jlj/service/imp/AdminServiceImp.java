package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IAdminDao;
import com.jlj.model.Admin;
import com.jlj.service.IAdminService;
@Component("adminService")
public class AdminServiceImp implements IAdminService {
	private IAdminDao adminDao;
	public IAdminDao getAdminDao() {
		return adminDao;
	}
	@Resource
	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IAdminService#add(com.jlj.model.Admin)
	 */
	public void add(Admin admin) throws Exception {
		adminDao.save(admin);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IAdminService#delete(com.jlj.model.Admin)
	 */
	public void delete(Admin admin) {
		adminDao.delete(admin);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IAdminService#deleteById(int)
	 */
	public void deleteById(int id) {
		adminDao.deleteById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IAdminService#update(com.jlj.model.Admin)
	 */
	public void update(Admin admin) {
		adminDao.update(admin);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IAdminService#getAdmins()
	 */
	public List<Admin> getAdmins() {
		return adminDao.getAdmins();
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IAdminService#loadById(int)
	 */
	public Admin loadById(int id) {
		return adminDao.loadById(id);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IAdminService#getPageCount(int, java.lang.String, int)
	 */
	public int getPageCount(int con, String convalue,int size) {
		int totalCount=this.getTotalCount(con, convalue);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IAdminService#getTotalCount(int, java.lang.String)
	 */
	public int getTotalCount(int con, String convalue) {
		String queryString = "select count(*) from Admin mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//用户名
			if(con==1){
				queryString += " and mo.username like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}
		return adminDao.getUniqueResult(queryString,p);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IAdminService#queryList(int, java.lang.String, int, int)
	 */
	public List<Admin> queryList(int con, String convalue,  int page, int size) {
		String queryString = "from Admin mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//用户名
			if(con==1){
				queryString += " and mo.username like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}
		queryString += " order by mo.id asc ";
		return adminDao.pageList(queryString,p,page,size);
	}
	public Admin userlogin(String username, String password) {
		String queryString="from Admin mo where mo.username=:username and mo.password=:password";
		String[] paramNames=new String[]{"username","password"};
		Object[] values=new Object[]{username,password};
		return adminDao.queryByNamedParam(queryString,paramNames,values);
	}
	public void updatePwd(String newpwd, Integer id) {
		String hql="update Admin mo set mo.password = :newpwd where mo.id=:id";
		String[] paramNames=new String[]{"newpwd","id"};
		Object[] values=new Object[]{newpwd,id};
		adminDao.updateByHql(hql,paramNames,values);
		
	}
	

}
