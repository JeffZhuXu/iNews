package catchnews.websites.sina;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import catchnews.tools.SelectChinese;


public class CatchSoureSina {
	
		public  static String getSourceAsString(String body) throws PatternSyntaxException {
			String source = "新浪教育";
			StringBuffer temp1 = new StringBuffer();

			Pattern pattern = Pattern
					.compile(
							"(?<=(fred\">)|(blank\">))[\\s\\S]{0,10}(?=(</a>)|(</span>))",
							Pattern.DOTALL);
			Matcher matcher = pattern.matcher(body);
			// 考虑到有些特殊标题无法用此方法捕获，例如867,848，此种情况捕获为空，则返回初始化的字符串，后台需手动更改
			while (matcher.find()) {
				source = matcher.group().toString();
			
				break;
			
			}
			return source;
		}

}
