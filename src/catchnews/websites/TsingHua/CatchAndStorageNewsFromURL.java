package catchnews.websites.TsingHua;

import java.util.List;

import com.yisinian.iNews.tools.NowDateOrTime;

import catchnews.tools.AddCharset;
import catchnews.tools.CatchHtml;
import catchnews.tools.CatchImage;
import catchnews.tools.CatchPage;
import catchnews.tools.CatchTitle;
import catchnews.tools.SaveHtml;
import catchnews.tools.SelectNumber;
import catchnews.tools.StorageToSql;
import catchnews.tools.code.WebsiteName;

public class CatchAndStorageNewsFromURL {
	
	//������ҳ��ץȡ������Ϣ�����沢�������ݿ⣬
	//��������ҳ��ַ����������
	
	public static void catchNews(String URL,String type) {

		String url=URL;
		String page = CatchPage.GetPage(url, "utf8").replaceAll("<div id=\"hidden_detail\" style=\"display:none;\">", "");
		String title = CatchTitle.getTitleAsString(page);
		String releaseTime = SelectNumber.selectNumber(CatchHtml.getInformationFromContent(page,"(?<=����)[\\s\\S]*?(?=]</div>)").get(0));
		
		//�ǵ����������������
		if((releaseTime.indexOf(NowDateOrTime.getNowDateAsString())>-1)){
			
		
		title = title.substring(0, title.indexOf("�廪��ѧ������")).replaceAll("-", "");
		
		String text = CatchHtml.getInformationFromContent(page, "(?<=&nbsp;����</div>)[\\s\\S]*(?=<div id=\"datalist_detail\">)").get(0).replaceAll("src=\"", "src=\"http://news.tsinghua.edu.cn").replaceAll("img", "img style=\"max-width:100%\" ");
		text = AddCharset.addTitleAndCharset(title, text);
		List<String> imagePath = CatchImage.getImageAsString(text);
		//�ļ�����ǰ�����ļ������ƣ������Ǿ����ļ�������ϵͳ��ǰ�ĺ���ֵ���� 20150722\125212521
		String fileName = NowDateOrTime.getNowDateAsString()+"\\"+String.valueOf(System.currentTimeMillis());
		
		//�����������ǵ�������ŵ�ʱ����ִ���������ز����������ϴ�
		if((title!="ûƥ������")&&(text!="ûƥ������")&&(releaseTime!="ûƥ������")){
			
		
		SaveHtml.saveToHtmlFile(text, fileName);
		StorageToSql.addToSql(WebsiteName.TSINGHUA.get("chinese"), "3", type, String.valueOf(System.currentTimeMillis()), WebsiteName.TSINGHUA.get("chinese"), title, releaseTime, imagePath.get(0), fileName);
		
		System.out.println("��ַ��" + url );
		System.out.println("���⣺" + title);
		//System.out.println("���ģ�" + text);
		System.out.println("ʱ�䣺" + releaseTime);
		System.out.println("ͼƬ��" + imagePath);
		System.out.println("�ļ�����" + fileName);
		
		}
		}

	}

	
}
