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

public class InfApplyProcessDaoImp implements IInfApplyProcessDao  {
	//根据Internal编号查询该记录的是否同意NOTE
	/* (non-Javadoc)
	 * @see com.jlj.dao.imp.IInfApplyProcessDao#getInfApplyProcessByInternalNo(java.lang.String)
	 */
	public List<InfApplyProcess> getInfApplyProcessByInternalNo(String internalno){
		List<InfApplyProcess> lists=new ArrayList<InfApplyProcess>();
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			con=DBHelp.getConnection();
			String sql = "select INTERNAL_NO,NOTE from INF_APPLY_PROCESS where INTERNAL_NO =?";
			pst=con.prepareStatement(sql);
			pst.setString(1, internalno);
			rs=pst.executeQuery();
			while(rs.next()){
//				System.out.println("rs.getString:"+rs.getString("NOTE"));
				InfApplyProcess infApplyProcess=new InfApplyProcess();
				infApplyProcess.setInternalNo(rs.getString("INTERNAL_NO"));
				infApplyProcess.setNote(rs.getString("NOTE"));
				lists.add(infApplyProcess);
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
	
}
