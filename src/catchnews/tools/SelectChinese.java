package catchnews.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//ȡ��һ���ַ������е�����
public class SelectChinese {

	
	
	
	public static String selectChinese(String txt){
		
		String text  ="";
		String regex = "([\u4e00-\u9fa5]+)";
		Matcher matcher = Pattern.compile(regex).matcher(txt);
		while(matcher.find()){
			
			text = text + matcher.group().toString();
		}
		return text;
	}
}
