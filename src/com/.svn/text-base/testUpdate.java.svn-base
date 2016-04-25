package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class testUpdate {

	
	 public static void main(String[] args)  {

		 Connection conn = null;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager
				.getConnection("jdbc:mysql://120.24.64.106:3306/inews","root", "379016635");
				
				Statement stat = conn.createStatement();
				String name ="北京大学";
				String year = "2015";
				int index = 57771;
				
				stat.executeUpdate("update schools set year"+year+ "= "+index+" where school_name ='"  + name + "'");

				
				//关闭数据库连接
				conn.close();
			}catch (Exception e) { 
				e.printStackTrace(); 
				
				}finally{ 
					if(conn!=null){ 
						try { conn.close(); 
						} catch (SQLException e) {
							e.printStackTrace();
							} 
						} 
					}

	 }
}
