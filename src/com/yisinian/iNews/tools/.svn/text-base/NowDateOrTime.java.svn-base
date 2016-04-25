package com.yisinian.iNews.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

//用于获取当天的日期或者是时间
//2015.7.27
//朱旭

public class NowDateOrTime {
	
	//获取当前时间
	public static String getNowTimeAsString(){
		Date d = new Date();
		
		SimpleDateFormat format = 
			new SimpleDateFormat("yyyyMMddHHmmss");
		String a = format.format(d).toString();
		
		return a;
	}
	//获取当前日期，格式为20150724
	public static String getNowDateAsString(){
			Date d = new Date();
			
			SimpleDateFormat format = 
				new SimpleDateFormat("yyyyMMdd");
			String a = format.format(d).toString();
			

			return a;
	}
	public static void main(String[] args) {
		getNowTimeAsString();
		getNowDateAsString();
	}

}
