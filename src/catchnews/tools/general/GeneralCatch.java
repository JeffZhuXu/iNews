package catchnews.tools.general;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GeneralCatch {
	//从一个网页中抓取网页链接的通用方法
	public static List<String> getURLsFromPage(String content){

		
		//用于存放找到的结果
		int num =0;
		List<String> result = new ArrayList<String>();
		Matcher matcher = Pattern.compile("(?<=(href=\")).*?(?=\")").matcher(content);

		while(matcher.find()){	
			result.add(matcher.group());
			num=num+1;
		}  
		//没找到信息的话,填一个0
		if(num==0){
			result.add("0");
		}
		
		return result;
		
	
	}
	//从一个网页中抓取出所有新闻链接
	public static List<String> getImgsFromPage(String content){

		
		//用于存放找到的结果
		int num =0;
		List<String> result = new ArrayList<String>();
		Matcher matcher = Pattern.compile("(?<=src=\").*?(?=\")").matcher(content);

		while(matcher.find()){	
			result.add(matcher.group());
			num=num+1;
		}  
		//没找到信息的话,填一个0
		if(num==0){
			result.add("0");
		}
		
		return result;
		
	
	}
	
	

}
