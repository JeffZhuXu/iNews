package com.yisinian.iNews.tools;

import java.io.File;
import java.io.IOException;



public class CollectNews {

	/**20115.7.27
	 * 将保存的新闻文件html找出来，进行合并，合并成txt格式文件，并保存下来，存入hadoop的HDFS系统，便于对数据进行统计和处理
	 * 朱旭
	 * 参数：需要合并的文件的路径,保存的文件路径
	 * @param 
	 */
	public static int num =0;  //用于保存当天的新闻条数
	//合并每天的新闻信息
	public static void collectDaliyNewsAsTxt(String newsPath,String savepath) throws IOException{
		
		//该文件的本地保存路径,直接放在D盘，上传完成过后直接删除
		String savePath = "d:/inews/txtfile/"+savepath+".txt";
		//保存该文件的hadoop路径
		String hdfsPath = "hdfs://192.168.0.96:9000/user/root/dailynews/" +savepath ;
		
		
		//如果这个文件存在，则删除
//		File f1 = new File(savePath + ".txt");
//		if(f1.exists()){
//			System.out.println(f1.getAbsolutePath());
//			f1.delete();
//		}

		String daliyNewsContent = "";//保存合并过后的信息的字符串
		
		//每天的新闻是保存在以日期名命名的文件夹下面的
		String dailyNewsPath = newsPath;
		
		
			//找到当天的更新的新闻
			File file = new File(dailyNewsPath);
			if(file.exists()){
				for(File f:file.listFiles()){
					if(f.isFile()){
						daliyNewsContent = daliyNewsContent+ ReadHtmlFiles.readTextFile(f.getAbsolutePath(), "utf8") + "\r\n" + "inews" +"\r\n"; //每条新闻之间通过<inews>这个标识符来区分
						System.out.println(f.getAbsolutePath());
					}
				
				}
				//将新闻内容保存到本地，编码格式UTF-8
				SaveTxt.saveToHtmlFile(daliyNewsContent, savePath, "utf8");
				//将新闻内容上传到HDFS
				//UploadFileToHDFS.uploadFile(savePath, hdfsPath);
				//上传完成新闻过后，将生成的本地文件删除
				File f2 = new File(savePath);
				//f2.delete();
				
			}
			else{
				System.out.println("指定目录文件不存在");
			}
			
				

	}
	

}
