package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IAddressbookDao;
import com.jlj.model.Addressbook;
import com.jlj.service.IAddressbookService;
@Component("addressbookService")
public class AddressbookServiceImp implements IAddressbookService {
	private IAddressbookDao addressbookDao;
	public IAddressbookDao getAddressbookDao() {
		return addressbookDao;
	}
	@Resource
	public void setAddressbookDao(IAddressbookDao addressbookDao) {
		this.addressbookDao = addressbookDao;
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IAddressbookService#add(com.jlj.model.Addressbook)
	 */
	public void add(Addressbook addressbook) throws Exception {
		addressbookDao.save(addressbook);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IAddressbookService#delete(com.jlj.model.Addressbook)
	 */
	public void delete(Addressbook addressbook) {
		addressbookDao.delete(addressbook);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IAddressbookService#deleteById(int)
	 */
	public void deleteById(int id) {
		addressbookDao.deleteById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IAddressbookService#update(com.jlj.model.Addressbook)
	 */
	public void update(Addressbook addressbook) {
		addressbookDao.update(addressbook);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IAddressbookService#getAddressbooks()
	 */
	public List<Addressbook> getAddressbooks() {
		return addressbookDao.getAddressbooks();
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IAddressbookService#loadById(int)
	 */
	public Addressbook loadById(int id) {
		return addressbookDao.loadById(id);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IAddressbookService#getPageCount(int, java.lang.String, int, java.lang.String, int)
	 */
	public int getPageCount(int con, String convalue, int status, String publicaccount,
			int size) {
		int totalCount=this.getTotalCount(con, convalue, status, publicaccount);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IAddressbookService#getTotalCount(int, java.lang.String, int, java.lang.String)
	 */
	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Addressbook mo where mo.publicaccount=? ";
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
		return addressbookDao.getUniqueResult(queryString,p);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IAddressbookService#queryList(int, java.lang.String, int, java.lang.String, int, int)
	 */
	public List<Addressbook> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Addressbook mo where mo.publicaccount=? ";
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
		return addressbookDao.pageList(queryString,p,page,size);
	}
	public Addressbook queryByPublicaccount(String publicaccount) {
		// TODO Auto-generated method stub
		String queryString = "from Addressbook mo where mo.publicaccount=:publicaccount";
		String[] paramNames=new String[]{"publicaccount"};
		Object[] values = new Object[]{publicaccount};
		return addressbookDao.queryByNamedParam(queryString, paramNames, values);
	}
	public int getPageCount(int con, String convalue, int size) {
		int totalCount=this.getTotalCount(con, convalue);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}
	public int getTotalCount(int con, String convalue) {
		String queryString = "select count(*) from Addressbook mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//大类别名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}else{
			p = new Object[]{};
		}
		return addressbookDao.getUniqueResult(queryString,p);
	}
	public List<Addressbook> queryList(int con, String convalue, int page,
			int size) {
		String queryString = "from Addressbook mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//大类别名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}else{
			p = new Object[]{};
		}
		queryString += " order by mo.id desc ";
		return addressbookDao.pageList(queryString,p,page,size);
	}
	
	

}
