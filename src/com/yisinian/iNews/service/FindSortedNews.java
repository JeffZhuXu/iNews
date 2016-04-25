package com.yisinian.iNews.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import com.yisinian.iNews.tools.FindSearchIndex;
import com.yisinian.iNews.tools.ResultsSort;

/*用于检索所有新闻文件，返回限制条数的新闻名称，同时将新闻根据索引值从大到小进行排列，大的表示相关度高
 * 朱旭
 * 2015.7.6
 * 参数1：关键词keyWords
 * 参数2：限制返回的新闻条数 
 * 
 * */

//厉遍所有html新闻文件，根据查询的关键字查找其索引值，按照索引值从大到小排列，索引值必须要大于1
public class FindSortedNews {
	
	
	
	//参数有两个，一个是ArrayList<String>的搜索关键词,newsNum用于限定返回新闻条数的最大值哦
	public static Map<Integer,String> getSortedFromAllFilesByIndex(ArrayList<String> keyWords,int limitNewsNum ) {
		
		 //用于存放索引到的文件名称
		Map<String,Integer> findFiles = new  TreeMap<String,Integer>();
		//用于保存限制条数过后过后的新闻名称
		Map<Integer,String> limitedFiles = new  TreeMap<Integer,String>();
		Map<Integer,String> limitedFiles1 = new  TreeMap<Integer,String>();
		
		ArrayList<String> mainwords = keyWords;
		//用于保存返回的索引结果
		ArrayList<String> results = new ArrayList<String>(); 
		File file = new File("D:\\inews\\htmlfile");
		if(file.isDirectory()){
			File[] htmlfiles = file.listFiles();
		
		for (int i = 0; i < htmlfiles.length; i++) {  

			int index = FindSearchIndex.getIndexNumAsString(htmlfiles[i].getAbsolutePath(), mainwords);
			if(index > 0 )
			{
			System.out.println("文件名： " +  htmlfiles[i].getName() + 
					 + FindSearchIndex.getIndexNumAsString(htmlfiles[i].getAbsolutePath(), mainwords));
			findFiles.put(htmlfiles[i].getName(), index);
			}       
        }  
		
		}
		limitedFiles =ResultsSort.getSortResults(findFiles);
		//将结果进行排序并且限制个数过后返回回去
		
		//当查询到的文件数小于限制的条数的时候，直接返回
		if(limitedFiles.size()<=limitNewsNum){
			return limitedFiles;
		}
		//如果查找到的条数大于设定的限制条数，只返回限制个数的新闻问价名称
		else{
			for(int i =1;i< limitNewsNum+1;i++){
				limitedFiles1.put(i, limitedFiles.get(i));
			}
			return limitedFiles1;
		}
		
	} 
		
		
}
	
	


