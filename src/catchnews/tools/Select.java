package catchnews.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//从给定的字符串中选出自己想要的部分中,输入的是字符串，网页的源代码用catch类
public class Select {
	
		//抽取中文部分
public static String selectChinese(String txt){
		
		String text  ="";
		String regex = "([\u4e00-\u9fa5]+)";
		Matcher matcher = Pattern.compile(regex).matcher(txt);
		while(matcher.find()){
			
			text = text + matcher.group().toString();
		}
		return text;
	}



////取出一串字符串当中的日期信息2014/12/1 8:26:37，目标为20141201082637
public static String selectDate(String txt){
	

	String time ="";
	Matcher matcher = Pattern.compile("\\d+").matcher(txt);
	while(matcher.find()){

		//如果抓到的月份或者是天数是单数，那么在前面添加个零，再附加上去
		if(matcher.group().toString().length()==1){
			time = time + "0" + matcher.group().toString();
		}
		else{
			time = time + matcher.group().toString();
		}
	}
	return time;
}
//获取字符串中的数字
public static String selectNumber(String txt){
	

	String number ="";
	Matcher matcher = Pattern.compile("\\d+").matcher(txt);
	while(matcher.find()){


		number = number +  matcher.group().toString();

	}
	return number;
}
//获取数字和所有的字母
public static String selectNumberAndWord(String txt){
	

	String number ="";
	Matcher matcher = Pattern.compile("[a-zA-Z\\d]").matcher(txt);
	while(matcher.find()){


		number = number +  matcher.group().toString();

	}
	return number;
}

}
