package catchnews.websites.science;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import catchnews.tools.SelectDate;

public class CatchTimeSc {


		public  static String getTimeAsString(String body) throws PatternSyntaxException {
			String time = "0";
			StringBuffer temp1 = new StringBuffer();

			Pattern pattern = Pattern
					.compile(
							"(?<=����ʱ��)[\\s\\S]{0,30}(?=(</div>)|(</td>))",
							Pattern.DOTALL);
			Matcher matcher = pattern.matcher(body);
			// ���ǵ���Щ��������޷��ô˷�����������867,848�������������Ϊ�գ��򷵻س�ʼ�����ַ�������̨���ֶ�����
			while (matcher.find()) {
				temp1.append(matcher.group());
			
			}
			if (temp1.toString().length() > 1) {
				time = temp1.toString();
			}

			return SelectDate.selectDate(time);
		}
	
}
