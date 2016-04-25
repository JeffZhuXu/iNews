package catchnews.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//�Ӹ������ַ�����ѡ���Լ���Ҫ�Ĳ�����,��������ַ�������ҳ��Դ������catch��
public class Select {
	
		//��ȡ���Ĳ���
public static String selectChinese(String txt){
		
		String text  ="";
		String regex = "([\u4e00-\u9fa5]+)";
		Matcher matcher = Pattern.compile(regex).matcher(txt);
		while(matcher.find()){
			
			text = text + matcher.group().toString();
		}
		return text;
	}



////ȡ��һ���ַ������е�������Ϣ2014/12/1 8:26:37��Ŀ��Ϊ20141201082637
public static String selectDate(String txt){
	

	String time ="";
	Matcher matcher = Pattern.compile("\\d+").matcher(txt);
	while(matcher.find()){

		//���ץ�����·ݻ����������ǵ�������ô��ǰ����Ӹ��㣬�ٸ�����ȥ
		if(matcher.group().toString().length()==1){
			time = time + "0" + matcher.group().toString();
		}
		else{
			time = time + matcher.group().toString();
		}
	}
	return time;
}
//��ȡ�ַ����е�����
public static String selectNumber(String txt){
	

	String number ="";
	Matcher matcher = Pattern.compile("\\d+").matcher(txt);
	while(matcher.find()){


		number = number +  matcher.group().toString();

	}
	return number;
}
//��ȡ���ֺ����е���ĸ
public static String selectNumberAndWord(String txt){
	

	String number ="";
	Matcher matcher = Pattern.compile("[a-zA-Z\\d]").matcher(txt);
	while(matcher.find()){


		number = number +  matcher.group().toString();

	}
	return number;
}

}
