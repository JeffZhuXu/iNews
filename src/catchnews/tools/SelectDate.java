package catchnews.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//ȡ��һ���ַ������е�������Ϣ2014/12/1 8:26:37��Ŀ��Ϊ20141201082637

public class SelectDate {

	

	//
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
}
