package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IBigtypeDao;
import com.jlj.model.Bigtype;
import com.jlj.service.IBigtypeService;
@Component("bigtypeService")
public class BigtypeServiceImp implements IBigtypeService{
	private IBigtypeDao bigtypeDao;
	public IBigtypeDao getBigtypeDao() {
		return bigtypeDao;
	}
	@Resource
	public void setBigtypeDao(IBigtypeDao bigtypeDao) {
		this.bigtypeDao = bigtypeDao;
	}

	public void add(Bigtype bigtype) throws Exception {
		bigtypeDao.save(bigtype);
	}

	public void delete(Bigtype bigtype) {
		bigtypeDao.delete(bigtype);
	}

	public void deleteById(int id) {
		bigtypeDao.deleteById(id);
	}
	
	public void update(Bigtype bigtype) {
		bigtypeDao.update(bigtype);
	}
	
	public List<Bigtype> getBigtypes() {
		return bigtypeDao.getBigtypes();
	}
	
	public Bigtype loadById(int id) {
		return bigtypeDao.loadById(id);
	}

	public int getPageCount(int con, String convalue, int status, String publicaccount,
			int size) {
		int totalCount=this.getTotalCount(con, convalue, status, publicaccount);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Bigtype mo where mo.publicaccount=? ";
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
		return bigtypeDao.getUniqueResult(queryString,p);
	}

	public List<Bigtype> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Bigtype mo where mo.publicaccount=? ";
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
		queryString += " order by mo.orderid asc ";
		return bigtypeDao.pageList(queryString,p,page,size);
	}
	
	public List<Bigtype> getBigtypesByPublicAccount(String paccount) {
		String queryString = "from Bigtype mo where mo.publicaccount = ? and mo.islinkonly = 0 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return bigtypeDao.getObjectsByCondition(queryString, p);
	}
	
	public List<Bigtype> getFrontBigtypesByPublicAccount(String paccount) {
		String queryString = "from Bigtype mo where mo.publicaccount = ? and mo.isshow = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return bigtypeDao.getObjectsByCondition(queryString, p);
	}

}
