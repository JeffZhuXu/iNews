package catchnews.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import catchnews.tools.code.WebsiteName;
import cn.edu.hfut.dmic.contentextractor.ContentExtractor;

/*
 * ����
 * 2015.8.7
 * �Ӹ�����html��ҳ��Դ�������ҳ�����Ҫ�Ķ���
 * */
public class Catch {
	
	
	//ץȡ��ҳ��Դ����,����Ϊ��ַ
	 public static String GetPage(String url) throws IOException { 
		 Document doc = Jsoup.connect(url).get(); 
		 return doc.html();
	    }
	
		//ץȡ�Զ���title
	 public static String GetMyTitle(String content) throws IOException { 
			//���ڴ���ҵ��Ľ��
			int num =0;
			List<String> result = new ArrayList<String>();
			Matcher matcher = Pattern.compile("(?<=([^\"](itle|ITLE).{1,3}>))[\\s\\S]{1,50}(?=</)").matcher(content);

			while(matcher.find()){	
				result.add(matcher.group());
				num=num+1;
			}  
			//û�ҵ���Ϣ�Ļ�
			if(num==0){
				result.add("ûƥ������");
			}
			return result.get(0);
	    }
	
	//�Լ�д��������ʽ
	public static List<String> getInformationFromContent(String content,String limit){

		
		//���ڴ���ҵ��Ľ��
		int num =0;
		List<String> result = new ArrayList<String>();
		Matcher matcher = Pattern.compile(limit).matcher(content);

		while(matcher.find()){	
			result.add(matcher.group());
			num=num+1;
		}  
		//û�ҵ���Ϣ�Ļ�
		if(num==0){
			result.add("ûƥ������");
		}
		
		return result;
		
	
	}
	//ץȡͼƬ����
	public static List<String> getImageAsString(String body)
	throws PatternSyntaxException {
		List<String> temp2 = new ArrayList<String>();

		Pattern pattern = Pattern.compile(
		"(?<= src=\")[\\s\\S]{0,80}(?=(\"\\s[abpw])|(\"\\s/>)|(\"/>))", Pattern.DOTALL);
		Matcher matcher = pattern.matcher(body);
		while (matcher.find()) {
			temp2.add(matcher.group());
		}
		if (temp2.size() < 1)
			temp2.add("0");
		return temp2;
	}
	//ץȡ���ⲿ��
	public  static String getTitleAsString(String body) throws PatternSyntaxException {
		String time = "����ץȡʧ��";
		StringBuffer temp1 = new StringBuffer();

		Pattern pattern = Pattern
				.compile(
						"(?<=<title>)[\\s\\S]*?(?=</title>)",
						Pattern.DOTALL);
		Matcher matcher = pattern.matcher(body);
		// ���ǵ���Щ��������޷��ô˷�����������867,848�������������Ϊ�գ��򷵻س�ʼ�����ַ�������̨���ֶ�����
		while (matcher.find()) {
			temp1.append(matcher.group());
		
		}
		if (temp1.toString().length() > 1) {
			time = temp1.toString();
		}

		return time;
	}
	
	//ץȡ���ű���,ͨ���ȶ����ַ���ץ����title������ѡ���ŵ�
	public static String getBestTitleAsString(Document doc) throws Exception{
		
		List<String> title= new ArrayList<String>();
		title.add(doc.title()); //doc�ļ������õ�title
		title.add(ContentExtractor.getNewsByDoc(doc).getTitle()); //ͨ��webcolector�����ű���ץȡ����ץ���ı���
		Matcher matcher = Pattern.compile("(?<=([^\"]itle.{1,3}>))[\\s\\S]{1,50}(?=</)").matcher(doc.html().toString());
		
		int sum=0;
		//ͨ���Լ�д�ĺ�����ץȡ����
		while(matcher.find()){	
			//��ƥ�䵽�����ĳ�ȥǰ��ͺ���Ŀո�ͻ��з�
			title.add(matcher.group().trim());
			sum=sum+1;
		}  
		//�Լ��ķ���û���ҵ�title
		if(sum==0){
			
			//��������������ûץ����ʱ��
			if((title.get(0).length()==0)&&(title.get(1).length()==0)){
			return "�����ȡʧ��";	
			}else if((title.get(0).length()<title.get(1).length())){
				return title.get(1);
			}else{
				return title.get(0);
			}
		}else{      //�Լ��ķ���Ҳץ����ʱ����ôץ���ľ�����ȷ�ģ������Լ�ץ����title
			return title.get(2);
		}
		}
		
		
	//�ҳ����������У���ص�ѧУ���ƣ����صĽ���������ѧУ���Ƶ�һ��list
	public static List<String> getRelativeSchools(String content){

		
		//���ڴ���ҵ��Ľ��
		int num =0;
		List<String> result = new ArrayList<String>();
		
		//ѧУ�����Ƽ���
		List<String> schools=WebsiteName.schoolNames;
		
		for(int i=0;i<schools.size();i++){
			
			Matcher matcher = Pattern.compile(schools.get(i)).matcher(content);

			while(matcher.find()){	
				result.add(schools.get(i));
				num=num+1;
				break;
			}  
			
		}

		//û�ҵ���Ϣ�Ļ�
		if(num==0){
			result.add("0");
		}
		
		return result;
		
	
	}
	

}
