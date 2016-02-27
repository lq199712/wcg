package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IMessageDao;
import com.jlj.model.Message;
import com.jlj.service.IMessageService;
@Component("messageService")
public class MessageServiceImp implements IMessageService{
	private IMessageDao messageDao;
	public IMessageDao getMessageDao() {
		return messageDao;
	}
	@Resource
	public void setMessageDao(IMessageDao messageDao) {
		this.messageDao = messageDao;
	}

	public void add(Message message) throws Exception {
		messageDao.save(message);
	}

	public void delete(Message message) {
		messageDao.delete(message);
	}

	public void deleteById(int id) {
		messageDao.deleteById(id);
	}
	
	public void update(Message message) {
		messageDao.update(message);
	}
	
	public List<Message> getMessages() {
		return messageDao.getMessages();
	}
	
	public Message loadById(int id) {
		return messageDao.loadById(id);
	}

	public int getPageCount(int con, String convalue, int status, String publicaccount,
			int size) {
		int totalCount=this.getTotalCount(con, convalue, status, publicaccount);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Message mo where mo.publicaccount=? ";
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
		return messageDao.getUniqueResult(queryString,p);
	}

	public List<Message> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Message mo where mo.publicaccount=? ";
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
		return messageDao.pageList(queryString,p,page,size);
	}
	
	public List<Message> getMessagesByPublicAccount(String paccount) {
		String queryString = "from Message mo where mo.publicaccount = ? and mo.islinkonly = 0 order by mo.id desc ";
		Object[] p= new Object[]{paccount};
		return messageDao.getObjectsByCondition(queryString, p);
	}
	
	public List<Message> getFrontMessagesByPublicAccount(String paccount) {
		String queryString = "from Message mo where mo.publicaccount = ? and mo.isshow = 1 order by mo.id desc ";
		Object[] p= new Object[]{paccount};
		return messageDao.getObjectsByCondition(queryString, p);
	}
	public int getPageCount(int con, String convalue, int size) {
		int totalCount=this.getTotalCount(con, convalue);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}
	public int getTotalCount(int con, String convalue) {
		String queryString = "select count(*) from Message mo where 1=1 ";
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
		return messageDao.getUniqueResult(queryString,p);
	}
	public List<Message> queryList(int con, String convalue, int page, int size) {
		String queryString = "from Message mo where 1=1 ";
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
		return messageDao.pageList(queryString,p,page,size);
	}
	public List<Message> getMessagesByIPAndDay(String ip, String localday) {
		String queryString = "from Message mo where mo.messageip = ? and mo.messagetime like ? order by mo.id desc ";
		Object[] p= new Object[]{ip,'%'+localday+'%'};
		return messageDao.getObjectsByCondition(queryString, p);
	}
	public List<Message> getFrontMessages() {
		String queryString = "from Message mo where mo.isshow = 1  order by mo.id desc";
		return messageDao.getObjectsByLimit(queryString);
	}

}
