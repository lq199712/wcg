package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IMemberDao;
import com.jlj.model.Member;
import com.jlj.service.IMemberService;
@Component("memberService")
public class MemberServiceImp implements IMemberService {
	private IMemberDao memberDao;
	public IMemberDao getMemberDao() {
		return memberDao;
	}
	@Resource
	public void setMemberDao(IMemberDao memberDao) {
		this.memberDao = memberDao;
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IMemberService#add(com.jlj.model.Member)
	 */
	public void add(Member member) {
		memberDao.save(member);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IMemberService#delete(com.jlj.model.Member)
	 */
	public void delete(Member member) {
		memberDao.delete(member);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IMemberService#deleteById(int)
	 */
	public void deleteById(int id) {
		memberDao.deleteById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IMemberService#update(com.jlj.model.Member)
	 */
	public void update(Member member) {
		memberDao.update(member);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IMemberService#getMembers()
	 */
	public List<Member> getMembers() {
		return memberDao.getMembers();
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IMemberService#loadById(int)
	 */
	public Member loadById(int id) {
		return memberDao.loadById(id);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IMemberService#getPageCount(int, java.lang.String, int, java.lang.String, int)
	 */
	public int getPageCount(int con, String convalue, int status, String publicaccount,
			int size) {
		int totalCount=this.getTotalCount(con, convalue, status, publicaccount);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IMemberService#getTotalCount(int, java.lang.String, int, java.lang.String)
	 */
	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Member mo where mo.realname!='' and mo.publicaccount=? ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//姓名、手机号
			if(con==1){
				queryString += "and mo.realname like ? "; 
			}else if (con==2) {
				queryString += "and mo.phone like ? "; 
			}
			p = new Object[]{publicaccount,'%'+convalue+'%'};
		}else{
			p = new Object[]{publicaccount};
		}
		return memberDao.getUniqueResult(queryString,p);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IMemberService#queryList(int, java.lang.String, int, java.lang.String, int, int)
	 */
	public List<Member> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Member mo where mo.realname!='' and mo.publicaccount=? ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//姓名、手机号
			if(con==1){
				queryString += "and mo.realname like ? "; 
			}else if (con==2) {
				queryString += "and mo.phone like ? "; 
			}
			p = new Object[]{publicaccount,'%'+convalue+'%'};
		}else{
			p = new Object[]{publicaccount};
		}
		queryString += " order by mo.id desc ";
		return memberDao.pageList(queryString,p,page,size);
	}
	public void updatecredit(int credit, int mid) {
		String hql = "update Member mo set mo.credit=:credit where mo.id=:mid";
		String[] paramNames = new String[]{"credit","mid"};
		Object[] values = new Object[]{credit,mid};
		memberDao.updateByHql(hql, paramNames, values);
	}
	public Member queryMemberByCondition(String openid, String frontpa) {
		String queryString = "from Member mo where mo.openid=:openid and mo.publicaccount=:frontpa ";
		String[] paramNames = new String[]{"openid","frontpa"};
		Object[] values = new Object[]{openid,frontpa};
		return memberDao.queryByNamedParam(queryString, paramNames, values);
	}
	public Member queryMemberByTel(String tel, String frontpa) {
		String queryString = "from Member mo where mo.phone=:phone and mo.publicaccount=:frontpa ";
		String[] paramNames = new String[]{"phone","frontpa"};
		Object[] values = new Object[]{tel,frontpa};
		return memberDao.queryByNamedParam(queryString, paramNames, values);
	}

	public Member queryMemberLogin(String tel,String pwd1, String frontpa) {
		String queryString = "from Member mo where mo.phone=:phone and mo.password=:password and mo.publicaccount=:frontpa ";
		String[] paramNames = new String[]{"phone","password","frontpa"};
		Object[] values = new Object[]{tel,pwd1,frontpa};
		return memberDao.queryByNamedParam(queryString, paramNames, values);
	}
}
