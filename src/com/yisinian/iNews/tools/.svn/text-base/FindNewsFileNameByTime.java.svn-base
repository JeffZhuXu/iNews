package com.yisinian.iNews.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;



/*
 * 2015.7.7
 * 朱旭
 * 从数据库中，将指定时间的新闻文件的名称找出来
 * 参数：时间 例如 2015,201506,20150607，...
 * 返回值：文件名称的列表
 * 
 * 
 * */
public class FindNewsFileNameByTime {
	
	//返回的list中存放的是在这个时间内的所有新闻的文件名称
	public static List<String> getNewsFilenamesByTime(String time){
		 Connection conn = null;
		 //存亡文件名的map
		 List<String> fileNames = new ArrayList<String>();
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager
				.getConnection("jdbc:mysql://120.24.64.106:3306/inews","root", "379016635");
				
				Statement stat = conn.createStatement();
				ResultSet rst = stat.executeQuery("select file_name from news where update_time like '"+time+"%'");
				
				while(rst.next()){
					String aFile = rst.getString("file_name");
					fileNames.add(aFile);
					
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
				return fileNames;
	}
	

	
	

}
