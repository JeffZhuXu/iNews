package catchnews.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


//��ȡһ���ַ������е�����
public class SelectNumberAndWord {


	//
	public static String selectNumber(String txt){
		

		String number ="";
		Matcher matcher = Pattern.compile("[a-zA-Z\\d]+").matcher(txt);
		while(matcher.find()){


			number = number +  matcher.group().toString();

		}
		return number;
	}
}
