package com.yisinian.iNews.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * ��ȡ�ؼ������е������������ؼ���ֻ��һ��
 * 
 * 
 * 
 * 
 * */
//
public class FindAllIndex {

	public static int getAllIndex(List<String> filename,String keyWords){

		//���ڷ����������
		int index =0;
		
		for(int j=0;j<filename.size();j++){
		
		//����ļ�����·��
		String filePath="D:\\inews\\htmlfile\\"+filename.get(j) + ".html";
		
		String mainWords = keyWords;
		String content = ReadHtmlFiles.readTextFile(filePath, "UTF8");
		//Ĭ������ֵΪ0�����ڱ���ؼ����ܵ���������
				//ͨ��������ʽƥ��ùؼ��ֳ��ֵĴ�������Ϊ����ֵ
			Matcher matcher = Pattern.compile(mainWords).matcher(content);

			while(matcher.find()){	
				index = index+1;
			}
			
		}
		
		
		
		return index;
		

	}
		

}
