package com.yisinian.iNews.tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ResultsSort {

	
	public static Map<Integer, String> getSortResults(Map<String, Integer> results){
		
		//用于保存返回的文件名称
		Map<Integer, String> sortResults = new TreeMap <Integer, String>();
		
		//初始化返回新闻搜索结果列表的序号，从以开始，依次递增，一直加到限制返回的最大新闻条数
		
		int id = 1;
	
	 List<Map.Entry<String,Integer>> mappingList = null; 
	  
	 Map<String,Integer> map = results;
	  
	  //通过ArrayList构造函数把map.entrySet()转换成list 
	 mappingList = new ArrayList<Map.Entry<String,Integer>>(map.entrySet()); 
	  //通过比较器实现比较排序 
	 Collections.sort(mappingList, new Comparator<Map.Entry<String,Integer>>(){ 
	 public int compare(Map.Entry<String,Integer> mapping1,Map.Entry<String,Integer> mapping2){ 
	 return mapping2.getValue().compareTo(mapping1.getValue()); 
	   } 
	  }); 
	  
	  for(Map.Entry<String,Integer> mapping:mappingList){ 
	   System.out.println(mapping.getKey()+":"+mapping.getValue()); 
	   sortResults.put(id, mapping.getKey());
	   id=id+1;
	   
	  } 
	  
	  return sortResults;
	}
}
