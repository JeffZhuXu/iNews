package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.yisinian.iNews.tools.FindAllIndex;
import com.yisinian.iNews.tools.FindAllSchools;


public class test11 {

	
	public static void main(String[] args) throws IOException {
		
//		HadoopFile a = new HadoopFile();
//		String path ="hdfs://192.168.0.96:9000/user/root/dailynews/20150724.txt";
//		String content = "xiaohaidao";
//		a.sendFile(path, "D:/inews/20150724.txt");
//		UploadFileToHDFS.uploadFile("D:/inews/20150724.txt","hdfs://192.168.0.96:9000/user/root/dailynews/20150724.txt");
		Long startTime = System.currentTimeMillis();
		
		List<String> schoolName = FindAllSchools.getAllSchoolNames();
		for(int i=0;i<schoolName.size();i++){
			List<String> filename = new ArrayList<String>();
			filename.add("201507310");
			System.out.println(schoolName.get(i));
			System.out.println("��������:" + FindAllIndex.getAllIndex(filename, schoolName.get(i)));
			
		}

		Long endTime = System.currentTimeMillis();
		System.out.println("����ʱ�䣺" + (endTime-startTime));
//		
//		
//		String content = ReadHtmlFiles.readTextFile("D:\\inews\\htmlfile\\201507310.html", "UTF8");
//		System.out.println(content);
//		
//	      String str=content; 
//	      String[] strarray=str.split("inews"); 
//	      for (int i = 0; i < strarray.length; i++) 
//	      {
//	          System.out.println(strarray[i]); 
//	      }
		
	}
	
	
}