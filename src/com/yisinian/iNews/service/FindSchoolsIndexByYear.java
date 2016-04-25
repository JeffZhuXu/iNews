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
 * ��ȡÿ��ѧУ���������������޶���ʱ����
 * 
 * 2015.7.7
 * ����
 * ������ʱ�� ��201404,2014,20140605��
 * ����ֵ����
 * ����������school���и���ѧУʱ����ڵ���������
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
				

	
				
				//��ȡ����ѧУ������
				List<String> schoolsName = FindAllSchools.getAllSchoolNames();
				
				//���ÿ��ѧУ���������map
				Map<String,String> results = new TreeMap<String,String>();
				
				//���ͨ��ʱ���ҵ����ļ�����
				List<String> filesName = FindNewsFileNameByTime.getNewsFilenamesByTime(time);
				
				
				for(int i =0;i<schoolsName.size();i++){
					//���ѧУ����
					String name = schoolsName.get(i);
					//���ѧУ������ֵ
					int index = FindAllIndex.getAllIndex(filesName, name);
					//�����ݿ��ܲ�������
					stat.executeUpdate("update schools set year"+time+ "= "+index+" where school_name ='"  + name + "'");
					System.out.println("ѧУ��" + name +"\n" + "����ʱ�䣺"+ time +"\n" + "����������" + index);
					
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
