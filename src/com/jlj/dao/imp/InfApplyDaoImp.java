package com.jlj.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jlj.bean.InfApply;
import com.jlj.bean.InfApplyProcess;
import com.jlj.dao.IInfApplyDao;
import com.jlj.dao.IInfApplyProcessDao;
import com.jlj.db.DBHelp;

public class InfApplyDaoImp implements IInfApplyDao {
	//根据内容中的编号查询该记录的编号、内容以及事务名
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IInfApplyDao#getInfApplysByContentId(java.lang.String)
	 */
	public List<InfApply> getInfApplysByContentId(String contentId){
		
		
		List<InfApply> lists=new ArrayList<InfApply>();
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			con=DBHelp.getConnection();
			String sql = "select INTERNAL_NO,TRANSACT_AFFAIR_NAME,CONTENT from INF_APPLY where CONTENT like ? ";
			pst=con.prepareStatement(sql);
			pst.setString(1, "%"+contentId+"%");
			rs=pst.executeQuery();
			while(rs.next()){
				InfApply infApply=new InfApply();
				infApply.setInternalNo(rs.getString("INTERNAL_NO"));
				infApply.setTransactAffairName(rs.getString("TRANSACT_AFFAIR_NAME"));
				infApply.setContent(rs.getString("CONTENT"));
				lists.add(infApply);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			DBHelp.closeResultSet(rs);
			DBHelp.closePreparedStatement(pst);
			DBHelp.closeConnection(con);
		}
		return lists;
	}
	
	public static void main(String[] args) {
		IInfApplyDao infApplyDao = new InfApplyDaoImp();
		List<InfApply> infApplys=infApplyDao.getInfApplysByContentId("05029");
		System.out.println(infApplys.size());
		for (InfApply infApply : infApplys) {
			System.out.println(infApply);
		}
		
		IInfApplyProcessDao infApplyProcessDao= new InfApplyProcessDaoImp();
		List<InfApplyProcess> infApplyProcesses=infApplyProcessDao.getInfApplyProcessByInternalNo("GG6215");
		System.out.println(infApplyProcesses.size());
		for (InfApplyProcess infApplyProcess : infApplyProcesses) {
			System.out.println(infApplyProcess);
		}
	}
}
