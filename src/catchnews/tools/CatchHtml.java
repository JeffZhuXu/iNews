package catchnews.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//ͨ���趨��ʼ�ͽ������ŵ�������ʽ��������Ҫ��ץȡ���ݴ���ҳ����ץȡ����
public class CatchHtml {
	

	public static List<String> getInformationFromContent(String content,String limit){

	
		//���ڴ���ҵ��Ľ��
		int num =0;
		List<String> result = new ArrayList<String>();
		Matcher matcher = Pattern.compile(limit).matcher(content);

		while(matcher.find()){	
			result.add(matcher.group());
			num=num+1;
		}  
		//û�ҵ���Ϣ�Ļ�
		if(num==0){
			result.add("ûƥ������");
		}
		
		return result;
		
	
	}

}
