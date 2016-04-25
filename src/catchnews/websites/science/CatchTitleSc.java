package catchnews.websites.science;



import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class CatchTitleSc {
	public  static String getTitleAsString(String body) throws PatternSyntaxException {
		String time = "����ץȡʧ��";
		StringBuffer temp1 = new StringBuffer();

		Pattern pattern = Pattern
				.compile(
						"(?<=<title>)[\\s\\S]*?(?=</title>)",
						Pattern.DOTALL);
		Matcher matcher = pattern.matcher(body);
		// ���ǵ���Щ��������޷��ô˷�����������867,848�������������Ϊ�գ��򷵻س�ʼ�����ַ�������̨���ֶ�����
		while (matcher.find()) {
			temp1.append(matcher.group());
		
		}
		if (temp1.toString().length() > 1) {
			time = temp1.toString();
		}

		return time;
	}

}
