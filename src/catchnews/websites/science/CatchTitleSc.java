package catchnews.websites.science;



import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class CatchTitleSc {
	public  static String getTitleAsString(String body) throws PatternSyntaxException {
		String time = "标题抓取失败";
		StringBuffer temp1 = new StringBuffer();

		Pattern pattern = Pattern
				.compile(
						"(?<=<title>)[\\s\\S]*?(?=</title>)",
						Pattern.DOTALL);
		Matcher matcher = pattern.matcher(body);
		// 考虑到有些特殊标题无法用此方法捕获，例如867,848，此种情况捕获为空，则返回初始化的字符串，后台需手动更改
		while (matcher.find()) {
			temp1.append(matcher.group());
		
		}
		if (temp1.toString().length() > 1) {
			time = temp1.toString();
		}

		return time;
	}

}
