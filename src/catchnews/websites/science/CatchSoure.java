package catchnews.websites.science;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import catchnews.tools.SelectChinese;


public class CatchSoure {
	
		public  static String getSourceAsString(String body) throws PatternSyntaxException {
			String source = "��Դץȡʧ��";
			StringBuffer temp1 = new StringBuffer();

			Pattern pattern = Pattern
					.compile(
							"(?<=��Դ��)[\\s\\S]*?(?=����ʱ��)",
							Pattern.DOTALL);
			Matcher matcher = pattern.matcher(body);
			// ���ǵ���Щ��������޷��ô˷�����������867,848�������������Ϊ�գ��򷵻س�ʼ�����ַ�������̨���ֶ�����
			while (matcher.find()) {
				temp1.append(matcher.group());
			
			}
			if (temp1.toString().length() > 1) {
				source = temp1.toString();
			}

			return SelectChinese.selectChinese(source);
		}

	

}
