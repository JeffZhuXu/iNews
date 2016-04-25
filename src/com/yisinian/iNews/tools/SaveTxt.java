package com.yisinian.iNews.tools;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;


public class SaveTxt {

	/**���ַ�������ΪTxT��ʽ�ļ�
	 * ����
	 * 2015.7.27
	 * ������
	 * text:��������
	 * filename��Ҫ������ļ������Լ�·��
	 * fileFormate��Ҫ������ļ���ʽ��txt������html
	 * formate�����ֱ����ʽ��GBK������UT8��UbuntuϵͳĬ�ϵ���UTF8
	 */
	public static void saveToHtmlFile(String text,String filename,String formate){
		
		String processedStr = text;

		try{

		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), formate));
		//GBKΪ���ַ�������Ϊ�ƶ��ĺ��ֱ����ʽ��ͳһ��ΪUTF-8																									
		 out.write(processedStr);
		 out.close();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}