package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IHotelDao;
import com.jlj.model.Hotel;
import com.jlj.service.IHotelService;
@Component("hotelService")
public class HotelServiceImp implements IHotelService {
	private IHotelDao hotelDao;
	public IHotelDao getHotelDao() {
		return hotelDao;
	}
	@Resource
	public void setHotelDao(IHotelDao hotelDao) {
		this.hotelDao = hotelDao;
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IHotelService#add(com.jlj.model.Hotel)
	 */
	public void add(Hotel hotel) throws Exception {
		hotelDao.save(hotel);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IHotelService#delete(com.jlj.model.Hotel)
	 */
	public void delete(Hotel hotel) {
		hotelDao.delete(hotel);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IHotelService#deleteById(int)
	 */
	public void deleteById(int id) {
		hotelDao.deleteById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IHotelService#update(com.jlj.model.Hotel)
	 */
	public void update(Hotel hotel) {
		hotelDao.update(hotel);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IHotelService#getHotels()
	 */
	public List<Hotel> getHotels() {
		return hotelDao.getHotels();
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IHotelService#loadById(int)
	 */
	public Hotel loadById(int id) {
		return hotelDao.loadById(id);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IHotelService#getPageCount(int, java.lang.String, int, java.lang.String, int)
	 */
	public int getPageCount(int con, String convalue, int status, String publicaccount,
			int size) {
		int totalCount=this.getTotalCount(con, convalue, status, publicaccount);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IHotelService#getTotalCount(int, java.lang.String, int, java.lang.String)
	 */
	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Hotel mo where mo.publicaccount=? ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//酒店名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}
			p = new Object[]{publicaccount,'%'+convalue+'%'};
		}else{
			p = new Object[]{publicaccount};
		}
		return hotelDao.getUniqueResult(queryString,p);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IHotelService#queryList(int, java.lang.String, int, java.lang.String, int, int)
	 */
	public List<Hotel> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Hotel mo where mo.publicaccount=? ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//酒店名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}
			p = new Object[]{publicaccount,'%'+convalue+'%'};
		}else{
			p = new Object[]{publicaccount};
		}
		queryString += " order by mo.id asc ";
		return hotelDao.pageList(queryString,p,page,size);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IHotelService#getHotelsByPublicAccount(java.lang.String)
	 */
	public List<Hotel> getHotelsByPublicAccount(String paccount) {
		String queryString = "from Hotel mo where mo.publicaccount = ? ";
		Object[] p= new Object[]{paccount};
		return hotelDao.getObjectsByCondition(queryString, p);
	}
	
	

}
