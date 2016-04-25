package catchnews.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StorageToSql {

		/**�����Ŵ������ݿ�
		 * @param 
		 * 2015.7.3
		 */
		public static void addToSql(
				String source,
				String identifyId,
				String type,
				String newsId,
				String websiteName,
				String title,
				String updatetime,
				String imagepath,
				String filename
				
				)  {

			 Connection conn = null;
				try{
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager
					.getConnection("jdbc:mysql://120.24.64.106:3306/inews","work", "147258369");
					
					PreparedStatement prep = conn.prepareStatement(
							"insert into news(source,identify_code,news_type,id,website,title,img_path,file_name,update_time)values(?,?,?,?,?,?,?,?,?)");
					prep.setString(1, source);
					prep.setString(2, identifyId);
					prep.setString(3, type);
					prep.setString(4, newsId);
					prep.setString(5, websiteName);
					prep.setString(6, title);
					prep.setString(7, imagepath);
					prep.setString(8, filename);
					prep.setString(9, updatetime);
					prep.executeUpdate();

					
					
					//�ر����ݿ�����
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
		
		//�������ݿ⣬�����ѧУ
		public static void addToSqlWithRelativeSchools(
				String source,
				String identifyId,
				String type,
				String newsId,
				String websiteName,
				String title,
				String updatetime,
				String imagepath,
				String filename,
				String relativeSchools
				)  {

			 Connection conn = null;
				try{
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager
					.getConnection("jdbc:mysql://120.24.64.106:3306/inews","administrator", "yisinian123456");
					
					PreparedStatement prep = conn.prepareStatement(
							"insert into news(source,identify_code,news_type,id,website,title,img_path,file_name,update_time,relative_schools)values(?,?,?,?,?,?,?,?,?,?)");
					prep.setString(1, source);
					prep.setString(2, identifyId);
					prep.setString(3, type);
					prep.setString(4, newsId);
					prep.setString(5, websiteName);
					prep.setString(6, title);
					prep.setString(7, imagepath);
					prep.setString(8, filename);
					prep.setString(9, updatetime);
					prep.setString(10, relativeSchools);
					prep.executeUpdate();

					
					
					//�ر����ݿ�����
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

		public static void addPaperMessage(
				String userid,
				String website,
				String title,
				String resultpath
				)  {

			 Connection conn = null;
				try{
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager
					.getConnection("jdbc:mysql://120.24.64.106:3306/inews","administrator", "yisinian123456");
					
					PreparedStatement prep = conn.prepareStatement(
							"insert into self_log_results(user_id,website,title,result_path)values(?,?,?,?)");
					prep.setString(1, userid);
					prep.setString(2, website);
					prep.setString(3, title);
					prep.setString(4, resultpath);
					
					prep.executeUpdate();

					
					
					//�ر����ݿ�����
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
