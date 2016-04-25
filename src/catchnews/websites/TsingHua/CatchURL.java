package catchnews.websites.TsingHua;

import java.util.ArrayList;
import java.util.List;

import catchnews.tools.CatchHtml;
import catchnews.tools.CatchPage;

public class CatchURL {
	
	
	public static List<String> getURLsFromWebpage(String webpage){
		String text = CatchPage.GetPage(webpage, "utf8");
		List<String> urls = new ArrayList<String> ();
		urls = CatchHtml.getInformationFromContent(text, "(?<=href=')[\\s\\S]{0,100}(?=('><font color))");
		
		return urls;
		
		
	}
	

}
