package com.yisinian.iNews.service;

import java.io.IOException;

import com.yisinian.iNews.tools.CollectNews;
import com.yisinian.iNews.tools.NowDateOrTime;

//�ռ�����ץȡ�����������ݣ����һ�����ļ������浽HDFS����


public class CollectDailyNews {
	
	
	public static void main(String[] args) throws IOException {
		
		//�������ű����Ŀ¼�����ǵ��������,��Ŀ¼��d:/inews/htmlfile/

		String dailyNewsPath = "d:/inews/htmlfile/"+NowDateOrTime.getNowDateAsString();
		//hdfs�б�����ļ�����·���Ѿ���CollectNews�����ƶ����ˣ��ļ�����Ҳ�ǵ��������
		String hdfsPath = NowDateOrTime.getNowDateAsString();
		CollectNews.collectDaliyNewsAsTxt(dailyNewsPath, hdfsPath);

		
	}
	
	

}
