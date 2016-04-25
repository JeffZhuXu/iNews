package catchnews.websites.sina;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import catchnews.tools.Catch;
import catchnews.tools.CatchImage;
import catchnews.tools.CatchPage;
import catchnews.tools.FindMaxId;
import catchnews.tools.SaveHtml;
import catchnews.tools.CatchTitle;
import catchnews.tools.AddTitleAndCharset;
import catchnews.tools.SelectChinese;
import catchnews.tools.StorageToSql;
import catchnews.tools.code.IdentifyCode;
import catchnews.tools.code.WebsiteName;

public class OneDayCatchSinaEducationJudgmentWebsite {

	/**
	 * ֻץȡ����Ľ���ʱ����
	 * 
	 * 
	 * 
	 * ��վ����������
	 * ���ࣺ����ʱ����ʶ����3
	 * 
	 * ����:�б���ַ http://roll.edu.sina.com.cn/all/jysp/index_1.shtml
	 * 
	 * 
	 * @param ����
	 * 2015.7.7
	 */
	public static void catchSinaNews (String url) {

		//��ȡ�������ڣ����ڸ�ʽΪ20150708
		Date d = new Date();

		SimpleDateFormat format = 
			new SimpleDateFormat("yyyyMMdd");
		
		String todayDate = format.format(d);
			

		
		List<String> urls = CatchUrlSina.getWebsiteUrlAsString(url);
		
		for(int i =0;i<urls.size();i++){
			
			
		
		String page = CatchPage.GetPage(urls.get(i), "GB2312");	//ץȡ��ҳ
		
		String text = CatchTextSina.getTextAsString(page);//ץȡ���Ĳ��֣�ͬʱ��ͼƬ�������������ó�����Ӧ�ֻ���Ļ��С
		String title = CatchTitle.getTitleAsString(page).replaceAll("_���˽���_������", "");//����
		List<String> imagpath = CatchImageSina.getImageAsString(text); //�����Ĳ��ֽ�����Ҫ��ͼƬ��ץ����
		text = AddTitleAndCharset.addTitleAndCharset(title,text); //�����ֱ����ʽ�Լ�������ӵ����Ĳ��ֵ���
		String filename = "XLW" + "\\"+String.valueOf(System.currentTimeMillis()); //����ǰʱ��ĺ���ֵ���ɸ������ļ����������
		String source = SelectChinese.selectChinese(CatchSoureSina.getSourceAsString(page));//��Դ�е�ʱ��ץ�����ֺ���ĸ��ȡ�����֣�ȥ���������ַ�
		String time = 	CatchTimeSina.getTimeAsString(page); //ץȡ���Ÿ��µ�ʱ�䣬��ʽΪ20141201082637
		String schools = Catch.getRelativeSchools(text).toString();
		System.out.println("��վ�� " + WebsiteName.SINA);
		System.out.println("���ű��⣺ " + title);
		System.out.println("������� " + "����ʱ��");
		System.out.println(text);
		System.out.println("������Դ�� " + source);
		System.out.println("���Ÿ���ʱ�䣺 " + time);
		
		//��������Ϣ�ǵ�������ŵ�ʱ�򣬴������ݿ⣬ͬʱ�����ļ�
		if(time.indexOf(todayDate)>-1){
		//�������ݿ�
		StorageToSql.addToSqlWithRelativeSchools(
				source, 	//������Դ
				IdentifyCode.SCHOOLLIVES,	//ʶ���룬���� 
				"����ʱ��", //����վ���������
				urls.get(i).substring(urls.get(i).length()-16, urls.get(i).length()-6).replaceAll("_", "0"), //��������id
				WebsiteName.SINA, //ץȡ���ŵ���վ����
				title, //���ű���
				time.substring(0, 8),	//���Ÿ��µ�ʱ��
				imagpath.get(0), //��һ��ͼƬ������
				filename,
				schools);	//�����html�ļ�����
		//����Ϊhtml�ļ�
		SaveHtml.saveToHtmlFile(text, filename);
		System.out.println("���Ÿ��³ɹ�");
		}
		}
	}
		
		
	

}
