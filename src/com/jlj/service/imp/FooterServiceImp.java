package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IFooterDao;
import com.jlj.model.Footer;
import com.jlj.service.IFooterService;
@Component("footerService")
public class FooterServiceImp implements IFooterService {
	private IFooterDao footerDao;
	public IFooterDao getFooterDao() {
		return footerDao;
	}
	@Resource
	public void setFooterDao(IFooterDao footerDao) {
		this.footerDao = footerDao;
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IFooterService#add(com.jlj.model.Footer)
	 */
	public void add(Footer footer) throws Exception {
		footerDao.save(footer);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IFooterService#delete(com.jlj.model.Footer)
	 */
	public void delete(Footer footer) {
		footerDao.delete(footer);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IFooterService#deleteById(int)
	 */
	public void deleteById(int id) {
		footerDao.deleteById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IFooterService#update(com.jlj.model.Footer)
	 */
	public void update(Footer footer) {
		footerDao.update(footer);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IFooterService#getFooters()
	 */
	public List<Footer> getFooters() {
		return footerDao.getFooters();
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IFooterService#loadById(int)
	 */
	public Footer loadById(int id) {
		return footerDao.loadById(id);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IFooterService#getPageCount(int, java.lang.String, int, java.lang.String, int)
	 */
	public int getPageCount(int con, String convalue, int status, String publicaccount,
			int size) {
		int totalCount=this.getTotalCount(con, convalue, status, publicaccount);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IFooterService#getTotalCount(int, java.lang.String, int, java.lang.String)
	 */
	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Footer mo where mo.publicaccount=? ";
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
		return footerDao.getUniqueResult(queryString,p);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IFooterService#queryList(int, java.lang.String, int, java.lang.String, int, int)
	 */
	public List<Footer> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Footer mo where mo.publicaccount=? ";
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
		return footerDao.pageList(queryString,p,page,size);
	}
	public Footer queryByPublicaccount(String publicaccount) {
		// TODO Auto-generated method stub
		String queryString = "from Footer mo where mo.publicaccount=:publicaccount";
		String[] paramNames=new String[]{"publicaccount"};
		Object[] values = new Object[]{publicaccount};
		return footerDao.queryByNamedParam(queryString, paramNames, values);
	}
	
	

}
