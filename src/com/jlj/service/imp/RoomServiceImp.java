package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IRoomDao;
import com.jlj.model.Room;
import com.jlj.service.IRoomService;
@Component("roomService")
public class RoomServiceImp implements IRoomService {
	private IRoomDao roomDao;
	public IRoomDao getRoomDao() {
		return roomDao;
	}
	@Resource
	public void setRoomDao(IRoomDao roomDao) {
		this.roomDao = roomDao;
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IRoomService#add(com.jlj.model.Room)
	 */
	public void add(Room room) throws Exception {
		roomDao.save(room);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IRoomService#delete(com.jlj.model.Room)
	 */
	public void delete(Room room) {
		roomDao.delete(room);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IRoomService#deleteById(int)
	 */
	public void deleteById(int id) {
		roomDao.deleteById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IRoomService#update(com.jlj.model.Room)
	 */
	public void update(Room room) {
		roomDao.update(room);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IRoomService#getRooms()
	 */
	public List<Room> getRooms() {
		return roomDao.getRooms();
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IRoomService#loadById(int)
	 */
	public Room loadById(int id) {
		return roomDao.loadById(id);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IRoomService#getPageCount(int, java.lang.String, int, java.lang.String, int)
	 */
	public int getPageCount(int con, String convalue, int status, String publicaccount,
			int size) {
		int totalCount=this.getTotalCount(con, convalue, status, publicaccount);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IRoomService#getTotalCount(int, java.lang.String, int, java.lang.String)
	 */
	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Room mo where mo.hotel.publicaccount=? ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//房间名称、酒店名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}else if(con==2){
				queryString += "and mo.hotel.name like ? "; 
			}
			p = new Object[]{publicaccount,'%'+convalue+'%'};
		}else{
			p = new Object[]{publicaccount};
		}
		return roomDao.getUniqueResult(queryString,p);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IRoomService#queryList(int, java.lang.String, int, java.lang.String, int, int)
	 */
	public List<Room> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Room mo where mo.hotel.publicaccount=? ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//房间名称、酒店名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}else if(con==2){
				queryString += "and mo.hotel.name like ? "; 
			}
			p = new Object[]{publicaccount,'%'+convalue+'%'};
		}else{
			p = new Object[]{publicaccount};
		}
		queryString += " order by mo.id asc ";
		return roomDao.pageList(queryString,p,page,size);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IRoomService#queryRoomByCondition(int)
	 */
	public List<Room> queryRoomByCondition(int hid) {
		String queryString = "from Room mo where mo.hotel.id=? ";
		Object[] p= new Object[]{hid};
		return roomDao.getObjectsByCondition(queryString, p);
	}
	
	

}
