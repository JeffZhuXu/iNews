package catchnews.websites.science;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;





//抓取科学网网页上的新闻连接，list返回
public class CatchUrlSc {

	
	public static List<String> getWebsiteUrlAsString(String url) throws PatternSyntaxException {
		List<String> temp2 = new ArrayList<String>();

		Pattern pattern = Pattern.compile(
				"(?<= href=')[\\s\\S]{0,50}(?=(' target))", Pattern.DOTALL);
		Matcher matcher = pattern.matcher(url);
		while (matcher.find()) {
			
			temp2.add(matcher.group().replaceAll("/htmlnews", "http://news.sciencenet.cn/htmlnews"));
		}
		if (temp2.size() < 1)
			temp2.add("0");
		return temp2;
	}

}
