package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jlj.dao.ISysconfDao;
import com.jlj.model.Sysconf;
import com.jlj.service.ISysconfService;
@Path("/sysconfservice")
public class SysconfServiceImp implements ISysconfService {
	private ISysconfDao sysconfDao;
	public ISysconfDao getSysconfDao() {
		return sysconfDao;
	}
	@Resource
	public void setSysconfDao(ISysconfDao sysconfDao) {
		this.sysconfDao = sysconfDao;
	}
	//添加对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISysconfService#add(com.jlj.model.Sysconf)
	 */
	public void add(Sysconf sysconf) throws Exception {
		sysconfDao.save(sysconf);
	}
	//删除对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISysconfService#delete(com.jlj.model.Sysconf)
	 */
	public void delete(Sysconf sysconf) {
		sysconfDao.delete(sysconf);
	}
	//删除某个id的对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISysconfService#deleteById(int)
	 */
	public void deleteById(int id) {
		sysconfDao.deleteById(id);
	}
	//修改对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISysconfService#update(com.jlj.model.Sysconf)
	 */
	public void update(Sysconf sysconf) {
		sysconfDao.update(sysconf);
	}
	//获取所有对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISysconfService#getSysconfs()
	 */
	public List<Sysconf> getSysconfs() {
		return sysconfDao.getSysconfs();
	}
	//加载一个id的对象
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISysconfService#loadById(int)
	 */
	public Sysconf loadById(int id) {
		return sysconfDao.loadById(id);
	}
	//后台管理-页数获取
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISysconfService#getPageCount(int, java.lang.String, int)
	 */
	public int getPageCount(int con, String convalue,int size) {
		int totalCount=this.getTotalCount(con, convalue);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}
	//后台管理-获取总记录数
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISysconfService#getTotalCount(int, java.lang.String)
	 */
	public int getTotalCount(int con, String convalue) {
		String queryString = "select count(*) from Sysconf mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//线路名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}
		queryString += " order by mo.id desc ";
		return sysconfDao.getUniqueResult(queryString,p);
	}
	//后台管理-获取符合条件的记录
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.ISysconfService#queryList(int, java.lang.String, int, int)
	 */
	public List<Sysconf> queryList(int con, String convalue, int page, int size) {
		String queryString = "from Sysconf mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//线路名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}
		queryString += " order by mo.id desc ";
		return sysconfDao.pageList(queryString,p,page,size);
	}
	
	//webservice部分
	/**
	 * 获取apk版本号
	 * @return
	 */
	@GET
	@Path("/apkversion")
	@Produces(MediaType.APPLICATION_JSON)
	public String getApkVersion(){
		Sysconf sysconf = sysconfDao.loadById(1);
		if(sysconf!=null){
			return sysconf.getVersion();
		}else{
			return "no";
		}
		
	}
	
}
