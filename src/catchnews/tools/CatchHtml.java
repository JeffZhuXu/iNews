package catchnews.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//通过设定开始和结束符号的正则表达式，将所需要的抓取内容从网页当中抓取出来
public class CatchHtml {
	

	public static List<String> getInformationFromContent(String content,String limit){

	
		//用于存放找到的结果
		int num =0;
		List<String> result = new ArrayList<String>();
		Matcher matcher = Pattern.compile(limit).matcher(content);

		while(matcher.find()){	
			result.add(matcher.group());
			num=num+1;
		}  
		//没找到信息的话
		if(num==0){
			result.add("没匹配内容");
		}
		
		return result;
		
	
	}

}
