package com.jlj.service;

import java.util.List;

import com.jlj.model.Member;

public interface IMemberService {

	public abstract void add(Member member);

	public abstract void delete(Member member);

	public abstract void deleteById(int id);

	public abstract void update(Member member);

	public abstract List<Member> getMembers();

	public abstract Member loadById(int id);

	public abstract int getPageCount(int con, String convalue, int status,
			String publicaccount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Member> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract void updatecredit(int credit, int mid);

	public abstract Member queryMemberByCondition(String openid, String frontpa);

	public abstract Member queryMemberByTel(String tel, String frontpa);

	public abstract Member queryMemberLogin(String tel, String pwd1,
			String frontpa);

}