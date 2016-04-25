package catchnews.websites.sina;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import catchnews.tools.CatchPage;





//抓取科学网网页上的新闻连接，list返回
public class CatchUrlSina {

	
	public static List<String> getWebsiteUrlAsString(String url) throws PatternSyntaxException {
		
		String linkPage = CatchPage.GetPage(url, "GB2312");	
		List<String> temp2 = new ArrayList<String>();

		Pattern pattern = Pattern.compile(
				"(?<=(href=\"http://e))[\\s\\S]{40,80}(?=ml\" target)", Pattern.DOTALL);
		Matcher matcher = pattern.matcher(linkPage);
		while (matcher.find()) {
			String link = matcher.group().replaceAll("du", "http://edu").replaceAll("sht", "shtml");

			temp2.add(link);
		}
		if (temp2.size() < 1)
			temp2.add("0");
		return temp2;
	}

}
