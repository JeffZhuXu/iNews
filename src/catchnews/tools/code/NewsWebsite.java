package catchnews.tools.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/*
 * ��Ÿ������ŵ��Ż���վ����ַ�Լ��������Ϣ
 * 2015.8.18
 * ����
 *
 * 
 * */
public class NewsWebsite {

	public static final List<String> newsWebsiteNames = new ArrayList<String>(){
		{
			add("���׽�����");
			add("�¾�����");
			add("�����пƼ�����ίԱ��");
			
		}
	};
	
	
	
	
	//���׽�����
	public static final HashMap<String, String> WYJYW = new HashMap<String, String>() {
	    {
	        put("chinese", "���׽�����");  //������
	        put("english", "WYJYW");  //Ӣ�������ļ�����
	        put("idcode", IdentifyCode.EDUCATIONNEWS);  		//��������
	        put("seed", "http://edu.163.com/"); //�������ӵ�
	        put("regex", ".*163.com/.*"); 			//��ȡ������ʽ
	        put("newsurl", ".*163.com/1[5-9]{1}/[0-9]{4}/.*"); 		//��������������ʽ
	        put("ignoreurl", ".*(auto|kids|a).163.com.*"); 													//Ҫ���Ե�����������ʽ
	        put("wordlength", "400");  //������ĳ���
	        put("title", "");  //ͨ�õ�titleץȡ��ץ�������õ���������
	    }
	};
	//�¾�����
	public static final HashMap<String, String> XJBW = new HashMap<String, String>() {
	    {
	        put("chinese", "�¾�����");  //������
	        put("english", "XJBW");  //Ӣ�������ļ�����
	        put("idcode", IdentifyCode.EDUCATIONNEWS);  		//��������
	        put("seed", "http://edu.bjnews.com.cn/"); //�������ӵ�
	        put("regex", "http://www.bjnews.com.cn/.*"); 			//��ȡ������ʽ
	        put("newsurl", "http://www.bjnews.com.cn/edu/201[5-9]{1}.*"); 		//��������������ʽ
	        put("ignoreurl", ""); 													//Ҫ���Ե�����������ʽ
	        put("wordlength", "400");  //������ĳ���
	        put("title", "");  //ͨ�õ�titleץȡ��ץ�������õ���������
	    }
	};
	
	//�����пƼ�����ίԱ��
	public static final HashMap<String, String> SZSTI = new HashMap<String, String>() {
	    {
	        put("chinese", "�����пƼ�����ίԱ��");  //������
	        put("english", "SZSTI");  //Ӣ�������ļ�����
	        put("idcode", IdentifyCode.TECHNOLOGY);  		//��������
	        put("seed", "http://www.szsti.gov.cn/news"); //�������ӵ�
	        put("regex", "http://www.szsti.gov.cn/news.*"); 			//��ȡ������ʽ
	        put("newsurl", "http://www.szsti.gov.cn/news/20.*/.*"); 		//��������������ʽ
	        put("ignoreurl", ""); 													//Ҫ���Ե�����������ʽ
	        put("wordlength", "300");  //������ĳ���
	        put("title", "");  //ͨ�õ�titleץȡ��ץ�������õ���������
	    }
	};
	
}