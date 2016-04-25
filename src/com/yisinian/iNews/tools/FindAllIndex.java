package com.yisinian.iNews.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 获取关键词所有的索引次数，关键词只有一个
 * 
 * 
 * 
 * 
 * */
//
public class FindAllIndex {

	public static int getAllIndex(List<String> filename,String keyWords){

		//用于返回索引结果
		int index =0;
		
		for(int j=0;j<filename.size();j++){
		
		//填充文件完整路径
		String filePath="D:\\inews\\htmlfile\\"+filename.get(j) + ".html";
		
		String mainWords = keyWords;
		String content = ReadHtmlFiles.readTextFile(filePath, "UTF8");
		//默认索引值为0，用于保存关键词总的索引次数
				//通过正则表达式匹配该关键字出现的次数，作为索引值
			Matcher matcher = Pattern.compile(mainWords).matcher(content);

			while(matcher.find()){	
				index = index+1;
			}
			
		}
		
		
		
		return index;
		

	}
		

}
