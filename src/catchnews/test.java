package catchnews;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import cn.edu.hfut.dmic.contentextractor.ContentExtractor;
import cn.edu.hfut.dmic.contentextractor.News;
import catchnews.tools.SaveHtml;

public class test {

	public static void main(String[] args) throws Exception {
		String a = "2014������Ӣ�3����";
		System.out.println(selectBanji(a));
		
	}
	public static String selectBanji(String txt){
		
		
		String number ="";
		String banji="";
		Matcher matcher = Pattern.compile("��").matcher(txt);
		while(matcher.find()){

			
			number = txt.substring(txt.indexOf("��")-2, txt.indexOf("��"));
			banji=selectNumber(number);


		}
		if(!banji.equals("")){
			return banji;
		}
		return "1";
	}
	
	public static String selectNumber(String txt){
		

		String number ="";
		Matcher matcher = Pattern.compile("\\d+").matcher(txt);
		while(matcher.find()){


			number = number +  matcher.group().toString();

		}
		return number;
	}
}
