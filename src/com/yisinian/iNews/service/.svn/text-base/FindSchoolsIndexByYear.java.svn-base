package com.yisinian.iNews.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.yisinian.iNews.tools.FindAllIndex;
import com.yisinian.iNews.tools.FindAllSchools;
import com.yisinian.iNews.tools.FindNewsFileNameByTime;

/*
 * 获取每个学校的索引次数，在限定的时间内
 * 
 * 2015.7.7
 * 朱旭
 * 参数：时间 ，201404,2014,20140605，
 * 返回值：无
 * 操作：更新school表中各个学校时间段内的索引次数
 * 
 * 
 * 
 * */
public class FindSchoolsIndexByYear {
	
	

	public static void getAllSchoolIndexByTime(String time){
		 
		
		Connection conn = null;

			try{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager
				.getConnection("jdbc:mysql://120.24.64.106:3306/inews","administrator", "yisinian123456");
				Statement stat = conn.createStatement();
				

	
				
				//获取所有学校的名称
				List<String> schoolsName = FindAllSchools.getAllSchoolNames();
				
				//存放每个学校索引结果的map
				Map<String,String> results = new TreeMap<String,String>();
				
				//存放通过时间找到的文件名称
				List<String> filesName = FindNewsFileNameByTime.getNewsFilenamesByTime(time);
				
				
				for(int i =0;i<schoolsName.size();i++){
					//这个学校名称
					String name = schoolsName.get(i);
					//这个学校的索引值
					int index = FindAllIndex.getAllIndex(filesName, name);
					//向数据库总插入数据
					stat.executeUpdate("update schools set year"+time+ "= "+index+" where school_name ='"  + name + "'");
					System.out.println("学校：" + name +"\n" + "检索时间："+ time +"\n" + "检索次数：" + index);
					
				}
				
				
				
				
				
				
				
				
				
				

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
