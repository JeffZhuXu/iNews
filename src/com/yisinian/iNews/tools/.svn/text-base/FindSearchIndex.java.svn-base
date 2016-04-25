package com.yisinian.iNews.tools;

import java.util.ArrayList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


//获取html新闻文件检索的索引值，索引值表示这条新闻和索引关键字的相关度，索引值越高表示与索引词的相关度越高

public class FindSearchIndex {
	
	
	public static int getIndexNumAsString(String filename,ArrayList<String> keyWords){

		//用于返回索引结果，格式为1000012；首位1表示关键词搜索到的1个，尾数12表示关键词索引了12次，索引按照索引值大小进行排序，值越大，相关度越高
		int index =0;
		//索引结果的首位
		int firstnum = 0;
		
		//用于存放所有关键词索引的结果，1表示索引到了，0表示没有索引到，格式为[1,0,1,0,1,0],长度为关键词的个数哦
		int[] results = new int[keyWords.size()];
		ArrayList<String> mainWords = keyWords;
		String content = ReadHtmlFiles.readTextFile(filename, "UTF8");
		//默认索引值为0，用于保存关键词总的索引次数
		 
		//将所有的关键词索引次数全部加起来，为总的索引次数，返回
		for(int i=0;i<mainWords.size();i++){
			
			//通过正则表达式匹配该关键字出现的次数，作为索引值
			Matcher matcher = Pattern.compile(mainWords.get(i)).matcher(content);

			while(matcher.find()){
				
				index = index+1;
				//当这个关键词被找到的时候，将该关键词的索引结果由0变为1，表示改词找到了
				results[i]=1;
			}
			
		}
		for(int j=0;j<results.length;j++){
			//添加索引的首位
			firstnum = firstnum + results[j];
		}
		return index + firstnum*1000000;
		

	}
		


}
