package com.yisinian.iNews.tools;

import java.util.ArrayList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


//��ȡhtml�����ļ�����������ֵ������ֵ��ʾ�������ź������ؼ��ֵ���ضȣ�����ֵԽ�߱�ʾ�������ʵ���ض�Խ��

public class FindSearchIndex {
	
	
	public static int getIndexNumAsString(String filename,ArrayList<String> keyWords){

		//���ڷ��������������ʽΪ1000012����λ1��ʾ�ؼ�����������1����β��12��ʾ�ؼ���������12�Σ�������������ֵ��С��������ֵԽ����ض�Խ��
		int index =0;
		//�����������λ
		int firstnum = 0;
		
		//���ڴ�����йؼ��������Ľ����1��ʾ�������ˣ�0��ʾû������������ʽΪ[1,0,1,0,1,0],����Ϊ�ؼ��ʵĸ���Ŷ
		int[] results = new int[keyWords.size()];
		ArrayList<String> mainWords = keyWords;
		String content = ReadHtmlFiles.readTextFile(filename, "UTF8");
		//Ĭ������ֵΪ0�����ڱ���ؼ����ܵ���������
		 
		//�����еĹؼ�����������ȫ����������Ϊ�ܵ���������������
		for(int i=0;i<mainWords.size();i++){
			
			//ͨ��������ʽƥ��ùؼ��ֳ��ֵĴ�������Ϊ����ֵ
			Matcher matcher = Pattern.compile(mainWords.get(i)).matcher(content);

			while(matcher.find()){
				
				index = index+1;
				//������ؼ��ʱ��ҵ���ʱ�򣬽��ùؼ��ʵ����������0��Ϊ1����ʾ�Ĵ��ҵ���
				results[i]=1;
			}
			
		}
		for(int j=0;j<results.length;j++){
			//�����������λ
			firstnum = firstnum + results[j];
		}
		return index + firstnum*1000000;
		

	}
		


}
