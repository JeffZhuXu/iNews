package com.yisinian.iNews.service;

import java.io.IOException;

import com.yisinian.iNews.tools.CollectNews;
import com.yisinian.iNews.tools.NowDateOrTime;

//收集当天抓取到的新闻数据，打成一个大文件，保存到HDFS当中


public class CollectDailyNews {
	
	
	public static void main(String[] args) throws IOException {
		
		//当天新闻保存的目录，就是当天的日期,根目录是d:/inews/htmlfile/

		String dailyNewsPath = "d:/inews/htmlfile/"+NowDateOrTime.getNowDateAsString();
		//hdfs中保存的文件名，路径已经在CollectNews类中制定好了，文件名称也是当天的日期
		String hdfsPath = NowDateOrTime.getNowDateAsString();
		CollectNews.collectDaliyNewsAsTxt(dailyNewsPath, hdfsPath);

		
	}
	
	

}
