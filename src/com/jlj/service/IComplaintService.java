package com.jlj.service;

import java.util.List;

import com.jlj.model.Complaint;

public interface IComplaintService {

	public abstract void add(Complaint complaint) throws Exception;

	public abstract void delete(Complaint complaint);

	public abstract void deleteById(int id);

	public abstract void update(Complaint complaint);

	public abstract List<Complaint> getComplaints();

	public abstract Complaint loadById(int id);

	public abstract int getPageCount(int con, String convalue, int status,
			String publicaccount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Complaint> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Complaint> queryListByPublicAccount(String publicaccount);

	public abstract List<Complaint> queryList(String ip);

	public abstract int getPageCount(int con, String convalue, int size);

	public abstract List<Complaint> queryList(int con, String convalue,
			int page, int size);

	public abstract int getTotalCount(int con, String convalue);

	public abstract List<Complaint> queryList(int comptype, String comptime,
			String name);

}