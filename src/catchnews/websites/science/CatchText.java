package catchnews.websites.science;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class CatchText {
	public static String getTextAsString(String body) throws PatternSyntaxException {
		String text = "����ץȡʧ��";
		StringBuffer temp1 = new StringBuffer();

		Pattern pattern = Pattern
				.compile(
						"(?<=([\\s]<b></b></td>)|(�����))[\\s\\S]*(?=(2em)|(</blockquote>))",
						Pattern.DOTALL);
		Matcher matcher = pattern.matcher(body);
		// ���ǵ���Щ��������޷��ô˷�����������867,848�������������Ϊ�գ��򷵻س�ʼ�����ַ�������̨���ֶ�����
		while (matcher.find()) {
			temp1.append(matcher.group());

		}
		if (temp1.toString().length() > 1) {
			text = temp1.toString();
		}
		//����ҳ���ٵ�ͼƬǰ׺������ȥ
		text = text.replace("src=\"", "src=\"http://news.sciencenet.cn");
		
		//���趨ͼƬ��Ⱥ͸߶ȵ��ֶ��滻��
		text = text.replace("height", "");
		text = text.replace("width", "");
		//��ͼƬ�ĳ�����Ӧ�������С��
		text = text.replaceAll("<img", "<img" + " style=\"max-width:100%;\"");
		
		return text;
	}

}
