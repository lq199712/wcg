package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IBigwheelDao;
import com.jlj.model.Bigwheel;
import com.jlj.service.IBigwheelService;

@Component("bigwheelService")
public class BigwheelServiceImp implements IBigwheelService {
	private IBigwheelDao bigwheelDao;
	

	public IBigwheelDao getBigwheelDao() {
		return bigwheelDao;
	}
	
	@Resource
	public void setBigwheelDao(IBigwheelDao bigwheelDao) {
		this.bigwheelDao = bigwheelDao;
	}

	public List<Bigwheel> queryList(String publicaccount) {
		
		String queryString = "from Bigwheel bw where bw.publicaccount = ? order by bw.id asc ";
		Object[] p= new Object[]{publicaccount};
		return bigwheelDao.getObjectsByCondition(queryString, p);
	}

	public int getTotalCount(String publicaccount) {
		// TODO Auto-generated method stub]
		try {
			int size = queryList(publicaccount).size();
			return size;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	public void add(Bigwheel bigwheel) {
		bigwheelDao.save(bigwheel);
		
	}

	public void delete(Bigwheel bigwheel) {
		// TODO Auto-generated method stub
		bigwheelDao.delete(bigwheel);
	}

	public Bigwheel loadById(int id) {
		// TODO Auto-generated method stub
		return bigwheelDao.loadById(id);
	}

	public void update(Bigwheel bigwheel) {
		// TODO Auto-generated method stub
		bigwheelDao.update(bigwheel);
		
	}

}
