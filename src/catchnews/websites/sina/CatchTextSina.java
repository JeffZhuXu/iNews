package catchnews.websites.sina;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class CatchTextSina {
	public static String getTextAsString(String body) throws PatternSyntaxException {
		String text = "正文抓取失败";
		StringBuffer temp1 = new StringBuffer();

		Pattern pattern = Pattern
				.compile(
						"(?<=<!-- 正文内容 begin -->)[\\s\\S]*(?=<!-- 正文内容 end -->)",
						Pattern.DOTALL);
		Matcher matcher = pattern.matcher(body);
		// 考虑到有些特殊标题无法用此方法捕获，例如867,848，此种情况捕获为空，则返回初始化的字符串，后台需手动更改
		while (matcher.find()) {
			temp1.append(matcher.group());

		}
		if (temp1.toString().length() > 1) {
			text = temp1.toString();
		}
		//将设定图片宽度和高度的字段替换掉
		text = text.replace("height", "");
		text = text.replace("width", "");
		//将图片改成自适应浏览器大小的
		text = text.replaceAll("<img", "<img" + " style=\"max-width:100%;\"");
		
		return text;
	}

}
