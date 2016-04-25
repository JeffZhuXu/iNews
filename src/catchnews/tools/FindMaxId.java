package catchnews.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FindMaxId {

		/**找到要跟新记录的最大id
		 * @param 
		 * 2015.7.3
		 */
		public static int findMaxId(String website)  {

			 Connection conn = null;
			 int maxId = 0;
				try{
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager
					.getConnection("jdbc:mysql://120.24.64.106:3306/inews","administrator", "yisinian123456");
					
						Statement stat = conn.createStatement();
						ResultSet rst = stat.executeQuery("select max(id) from news where website = '"+website+"'");
					while(rst.next())	{
						 maxId = rst.getInt("max(id)");
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
					return maxId;
		 }

	

}
