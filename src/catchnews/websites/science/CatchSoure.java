package catchnews.websites.science;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import catchnews.tools.SelectChinese;


public class CatchSoure {
	
		public  static String getSourceAsString(String body) throws PatternSyntaxException {
			String source = "来源抓取失败";
			StringBuffer temp1 = new StringBuffer();

			Pattern pattern = Pattern
					.compile(
							"(?<=来源：)[\\s\\S]*?(?=发布时间)",
							Pattern.DOTALL);
			Matcher matcher = pattern.matcher(body);
			// 考虑到有些特殊标题无法用此方法捕获，例如867,848，此种情况捕获为空，则返回初始化的字符串，后台需手动更改
			while (matcher.find()) {
				temp1.append(matcher.group());
			
			}
			if (temp1.toString().length() > 1) {
				source = temp1.toString();
			}

			return SelectChinese.selectChinese(source);
		}

	

}
