package com.yisinian.iNews.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/*找出所有的学校的名称
 * 
 * 朱旭
 * 2015.7.7
 * 
 * 参数：无
 * 返回值，学校名称列表
 * 
 * 
 * 
 * */
public class FindAllSchools {
	
	
	//返回的list中存放的是在这个时间内的所有新闻的文件名称
	public static List<String> getAllSchoolNames(){
		 Connection conn = null;
		 //存亡文件名的map
		 List<String> schoolName = new ArrayList<String>();
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager
				.getConnection("jdbc:mysql://120.24.64.106:3306/inews","administrator", "yisinian123456");
				
				Statement stat = conn.createStatement();
				ResultSet rst = stat.executeQuery("select school_name from schools");
				
				while(rst.next()){
					String aFile = rst.getString("school_name");
					schoolName.add(aFile);
					
					}
				
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
				return schoolName;

	}
}
