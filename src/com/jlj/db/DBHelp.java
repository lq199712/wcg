package com.jlj.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelp {
	public static Connection getConnection(){
		Connection con=null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");//mysql的连接方式
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			con=DriverManager.getConnection("jdbc:mysql://58.214.254.196:3306/YXCGDATA", "sa", "gongxiang110!");//mysql的连接方式
			//外网查询方式
//			con=DriverManager.getConnection("jdbc:sqlserver://58.214.254.196:1433;DatabaseName=YXCGDATA", "sa", "gongxiang110!");
			//内网查询方式
			con=DriverManager.getConnection("jdbc:sqlserver://10.88.1.117:1433;DatabaseName=YXCGDATA", "sa", "gongxiang110!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}
	public static void closeConnection(Connection con){
		
			try {
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	public static void closeStatement(Statement st){
		try {
			if(st!=null){
				st.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void closePreparedStatement(PreparedStatement pst){
		try {
			if(pst!=null){
				pst.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void closeResultSet(ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
