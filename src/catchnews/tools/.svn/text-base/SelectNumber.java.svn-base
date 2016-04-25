package catchnews.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


//获取一段字符串当中的数字和英文字母
public class SelectNumber {


	//
	public static String selectNumber(String txt){
		

		String number ="";
		Matcher matcher = Pattern.compile("\\d+").matcher(txt);
		while(matcher.find()){


			number = number +  matcher.group().toString();

		}
		return number;
	}
}
