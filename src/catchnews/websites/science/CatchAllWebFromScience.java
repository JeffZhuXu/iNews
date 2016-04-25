package catchnews.websites.science;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import catchnews.tools.AddTitleAndCharset;
import catchnews.tools.CatchImage;
import catchnews.tools.CatchPage;
import catchnews.tools.CatchTitle;
import catchnews.tools.SaveHtml;
import catchnews.tools.SelectChinese;
import catchnews.tools.SelectDate;
import catchnews.tools.StorageToSql;
import catchnews.tools.code.IdentifyCode;
import catchnews.tools.code.WebsiteName;

//һ���԰ѿ�ѧ���ϵ���������ץ����

public class CatchAllWebFromScience {

	public static void main(String[] args) {
		
		for(int j = 275;j< 1324;j++){
		
		String url = "http://news.sciencenet.cn/indexyaowen-"+j+".aspx";
		String page = CatchPage.GetPage(url, "UTF-8");
		List<String> urls = CatchUrlSc.getWebsiteUrlAsString(page);
		for(int i =0;i< urls.size();i++){
			String pages = CatchPage.GetPage(urls.get(i), "UTF-8");
			
			String title =  CatchTitle.getTitleAsString(pages);
			String text = CatchText.getTextAsString(pages);
			text = AddTitleAndCharset.addTitleAndCharset(title,text); //�����ֱ����ʽ�Լ�������ӵ����Ĳ��ֵ���
			String time = CatchTimeSc.getTimeAsString(pages);
			List<String> imgPath = CatchImage.getImageAsString(text);
			String source = CatchSoure.getSourceAsString(pages);
			
			System.out.println("���ű��⣺ " + title);
			System.out.println("������Դ�� " + source);
			System.out.println("�������ģ� " + text);
			System.out.println("���Ÿ���ʱ�䣺" +  time);
			System.out.println("ͼƬ���ӣ�  " + imgPath);
			
			String filename = String.valueOf(System.currentTimeMillis()); //������ļ���
			
			//�������ݿ�
			StorageToSql.addToSql(
					source,
					IdentifyCode.TECHNOLOGY, 
					"Ҫ��", 
					String.valueOf(0), 
					WebsiteName.SCIENCE, 
					title, 
					time,
					imgPath.get(0), 
					filename);
			//����Ϊhtml�ļ�
			SaveHtml.saveToHtmlFile(text, filename);
			}
		}
	}
	
}
