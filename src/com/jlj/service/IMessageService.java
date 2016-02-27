package com.jlj.service;

import java.util.List;

import com.jlj.model.Message;

public interface IMessageService {

	public abstract void add(Message message) throws Exception;

	public abstract void delete(Message message);

	public abstract void deleteById(int id);

	public abstract void update(Message message);

	public abstract List<Message> getMessages();

	public abstract Message loadById(int id);

	public abstract int getPageCount(int con, String convalue, int status,
			String publicaccount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Message> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Message> getMessagesByPublicAccount(String paccount);
	
	public abstract List<Message> getFrontMessagesByPublicAccount(String paccount);

	public abstract int getPageCount(int con, String convalue, int size);

	public abstract List<Message> queryList(int con, String convalue, int page,
			int size);

	public abstract int getTotalCount(int con, String convalue);

	public abstract List<Message> getMessagesByIPAndDay(String ip,
			String localday);

	public abstract List<Message> getFrontMessages();

}