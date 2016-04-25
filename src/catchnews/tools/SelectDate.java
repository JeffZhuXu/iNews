package catchnews.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//取出一串字符串当中的日期信息2014/12/1 8:26:37，目标为20141201082637

public class SelectDate {

	

	//
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
}
