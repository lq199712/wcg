package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IPrizerDao;
import com.jlj.model.Prizer;
import com.jlj.service.IPrizerService;
@Component("prizerService")
public class PrizerServiceImp implements IPrizerService{
	private IPrizerDao prizerDao;
	
	public IPrizerDao getPrizerDao() {
		return prizerDao;
	}
	
	@Resource
	public void setPrizerDao(IPrizerDao prizerDao) {
		this.prizerDao = prizerDao;
	}

	public void add(Prizer prizer) throws Exception {
		prizerDao.save(prizer);
	}

	public void delete(Prizer prizer) {
		prizerDao.delete(prizer);
	}

	public void deleteById(int id) {
		prizerDao.deleteById(id);
	}
	
	public void update(Prizer prizer) {
		prizerDao.update(prizer);
	}
	
	public List<Prizer> getPrizers() {
		return prizerDao.getPrizers();
	}
	
	public Prizer loadById(int id) {
		return prizerDao.loadById(id);
	}

	
	public List<Prizer> getBigtypesByPublicAccount(String paccount) {
		String queryString = "from Prizer mo where mo.bigwheel.publicaccount=? order by mo.id asc ";
		Object[] p= new Object[]{paccount};
		return prizerDao.getObjectsByCondition(queryString, p);
	}

	public int getPageCount(int con, String convalue, int status,
			String publicaccount, int size, int bid) {
		int totalCount=this.getTotalCount(con, convalue, status, publicaccount,bid);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status,
			String publicaccount, int bid) {
		String queryString = "select count(*) from Prizer mo where mo.bigwheel.publicaccount=? and mo.bigwheel.id=?";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			if(con==1){
				queryString += "and mo.awardstate = ? "; 
				p = new Object[]{publicaccount,bid,status};
			}
			if(con==2){
				queryString += "and mo.prize like ? "; 
				p = new Object[]{publicaccount,bid,'%'+convalue+'%'};
			}
		}else{
			p = new Object[]{publicaccount,bid};
		}
		System.out.println(queryString+" "+p);
		return prizerDao.getUniqueResult(queryString,p);
	}

	public List<Prizer> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size, int bid) {
		String queryString = "from Prizer mo where mo.bigwheel.publicaccount=? and mo.bigwheel.id=?";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			if(con==1){
				queryString += "and mo.awardstate = ? "; 
				p = new Object[]{publicaccount,bid,status};
			}
			if(con==2){
				queryString += "and mo.prize like ? "; 
				p = new Object[]{publicaccount,bid,'%'+convalue+'%'};
			}
		}else{
			p = new Object[]{publicaccount,bid};
		}
		queryString += " order by mo.id asc ";
		return prizerDao.pageList(queryString,p,page,size);
	}

	public List<Prizer> queryList(int mid, int id) {
		// TODO Auto-generated method stub
		String queryString = "from Prizer mo where mo.mid=? and mo.bigwheel.id=?";
		Object[] p = new Object[]{mid,id};
		queryString += " order by mo.id asc ";
		return prizerDao.getObjectsByCondition(queryString,p);
	}
	
	

}
