package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IPagearticleDao;
import com.jlj.model.Pagearticle;
import com.jlj.service.IPagearticleService;
@Component("pagearticleService")
public class PagearticleServiceImp implements IPagearticleService{
	private IPagearticleDao pagearticleDao;
	public IPagearticleDao getPagearticleDao() {
		return pagearticleDao;
	}
	@Resource
	public void setPagearticleDao(IPagearticleDao pagearticleDao) {
		this.pagearticleDao = pagearticleDao;
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPagearticleService#add(com.jlj.model.Pagearticle)
	 */
	public void add(Pagearticle pagearticle) throws Exception {
		pagearticleDao.save(pagearticle);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPagearticleService#delete(com.jlj.model.Pagearticle)
	 */
	public void delete(Pagearticle pagearticle) {
		pagearticleDao.delete(pagearticle);
	}
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPagearticleService#deleteById(int)
	 */
	public void deleteById(int id) {
		pagearticleDao.deleteById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPagearticleService#update(com.jlj.model.Pagearticle)
	 */
	public void update(Pagearticle pagearticle) {
		pagearticleDao.update(pagearticle);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPagearticleService#getPagearticles()
	 */
	public List<Pagearticle> getPagearticles() {
		return pagearticleDao.getPagearticles();
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPagearticleService#loadById(int)
	 */
	public Pagearticle loadById(int id) {
		return pagearticleDao.loadById(id);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPagearticleService#getPageCount(int, java.lang.String, int, java.lang.String, int)
	 */
	public int getPageCount(int con, String convalue, int status, String publicaccount,
			int size) {
		int totalCount=this.getTotalCount(con, convalue, status, publicaccount);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPagearticleService#getTotalCount(int, java.lang.String, int, java.lang.String)
	 */
	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Pagearticle mo where mo.articletype=? and mo.publicaccount=? ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//文章标题、子类别名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}else if(con==2){
				queryString += "and mo.sontype.name like ? "; 
			}
			p = new Object[]{status,publicaccount,'%'+convalue+'%'};
		}else{
			p = new Object[]{status,publicaccount};
		}
		return pagearticleDao.getUniqueResult(queryString,p);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPagearticleService#queryList(int, java.lang.String, int, java.lang.String, int, int)
	 */
	public List<Pagearticle> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Pagearticle mo where mo.articletype=? and mo.publicaccount=? ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//文章标题、子类别名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}else if(con==2){
				queryString += "and mo.sontype.name like ? "; 
			}
			p = new Object[]{status,publicaccount,'%'+convalue+'%'};
		}else{
			p = new Object[]{status,publicaccount};
		}
		queryString += " order by mo.id desc ";
		return pagearticleDao.pageList(queryString,p,page,size);
	}
	public int getFrontPageCount(int stid, int size) {
		int totalCount=this.getFrontTotalCount(stid);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}
	public int getFrontTotalCount(int stid) {
		String queryString = "select count(*) from Pagearticle mo where mo.sontype.id=? ";
		Object[] p = new Object[]{stid};
		return pagearticleDao.getUniqueResult(queryString,p);
	}
	public List<Pagearticle> queryFrontList(int stid, int page, int size) {
		String queryString = "from Pagearticle mo where mo.sontype.id=? order by mo.id desc ";
		Object[] p = new Object[]{stid};
		return pagearticleDao.pageList(queryString,p,page,size);
	}
	public List<Pagearticle> queryFrontIndexList(String frontpa, int isshow, int page, int psize) {
		String queryString = "from Pagearticle mo where mo.isshow=? and mo.publicaccount=?  ";
		Object[] p = new Object[]{isshow,frontpa};
		return pagearticleDao.pageList(queryString,p,page,psize);
	}
	public Pagearticle queryPagearticleById(int id) {
		String queryString="from Pagearticle mo where mo.isshow=2 and mo.id=:id";
		String[] paramNames=new String[]{"id"};
		Object[] values=new Object[]{id};
		return pagearticleDao.queryByNamedParam(queryString,paramNames,values);
	}
	
	

}
