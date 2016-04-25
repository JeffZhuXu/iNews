package catchnews.websites.sina;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import catchnews.tools.SelectDate;

public class CatchTimeSina {


		public  static String getTimeAsString(String body) throws PatternSyntaxException {
			String time = "0";
			StringBuffer temp1 = new StringBuffer();

			Pattern pattern = Pattern
					.compile(
							"(?<=pub_date\">)[\\s\\S]{0,25}(?=(</span>)|(&nbsp))",
							Pattern.DOTALL);
			Matcher matcher = pattern.matcher(body);
			// 考虑到有些特殊标题无法用此方法捕获，例如867,848，此种情况捕获为空，则返回初始化的字符串，后台需手动更改
			while (matcher.find()) {
				temp1.append(matcher.group());
			
			}
			if (temp1.toString().length() > 1) {
				time = temp1.toString();
			}

			return SelectDate.selectDate(time);
		}
	
}
