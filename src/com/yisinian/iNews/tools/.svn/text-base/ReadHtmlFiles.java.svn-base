package com.yisinian.iNews.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadHtmlFiles {

	
	public static String readTextFile(String sFileName, String sEncode)
	{
	    StringBuffer sbStr = new StringBuffer();

	    try
	    {
	        File ff = new File(sFileName);
	        InputStreamReader read = new InputStreamReader(new FileInputStream(ff),
	                sEncode);
	        
	        BufferedReader ins = new BufferedReader(read);

	        String dataLine = "";
	        while (null != (dataLine = ins.readLine()))
	        {
	            sbStr.append(dataLine);
	            
	        }

	        ins.close();
	    }
	    catch (Exception e)
	    {
	       e.printStackTrace();
	    }

	    return sbStr.toString();
	}
//	public static void main(String[] args) {
//		String fileName ="d:/14075.html";  //文件的路径，绝对路径
//		String content = readTextFile(fileName,"UTF8"); // utf8为汉字编码格式，常用的编码格式有GBK,GB2312，UTF8，我们
//														//新闻用的是UTF8	
//		System.out.println(content);
//	}
}
