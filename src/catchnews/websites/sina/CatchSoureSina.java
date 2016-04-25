package catchnews.websites.sina;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import catchnews.tools.SelectChinese;


public class CatchSoureSina {
	
		public  static String getSourceAsString(String body) throws PatternSyntaxException {
			String source = "���˽���";
			StringBuffer temp1 = new StringBuffer();

			Pattern pattern = Pattern
					.compile(
							"(?<=(fred\">)|(blank\">))[\\s\\S]{0,10}(?=(</a>)|(</span>))",
							Pattern.DOTALL);
			Matcher matcher = pattern.matcher(body);
			// ���ǵ���Щ��������޷��ô˷�����������867,848�������������Ϊ�գ��򷵻س�ʼ�����ַ�������̨���ֶ�����
			while (matcher.find()) {
				source = matcher.group().toString();
			
				break;
			
			}
			return source;
		}

}
