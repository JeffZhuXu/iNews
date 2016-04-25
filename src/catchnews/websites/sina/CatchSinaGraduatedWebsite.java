package catchnews.websites.sina;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

public class CatchSinaGraduatedWebsite {

	/**网站《新浪网》
	 * 分类：考研类，识别码6
	 * 
	 * 参数:列表网址 http://roll.edu.sina.com.cn/lm/ky3/kyzx/kaoshi/index_1.shtml
	 * 
	 * 
	 * @param 朱旭
	 * 2015.7.7
	 */
	public static void catchSinaNews (String url) {

		//获取当天日期，日期格式为20150708
		Date d = new Date();

		SimpleDateFormat format = 
			new SimpleDateFormat("yyyyMMdd");
		
		String todayDate = format.format(d);
			
			
		List<String> urls = CatchUrlSina.getWebsiteUrlAsString(url);
		
		for(int i =0;i<urls.size();i++){
			
			
		
		String page = CatchPage.GetPage(urls.get(i), "GB2312");	//抓取网页
		
		String text = CatchTextSina.getTextAsString(page);//抓取正文部分，同时将图片链接修正，设置成自适应手机屏幕大小
		String title = CatchTitle.getTitleAsString(page).replaceAll("_新浪教育_新浪网", "");//标题
		List<String> imagpath = CatchImageSina.getImageAsString(text); //从正文部分将所需要的图片给抓进来
		text = AddTitleAndCharset.addTitleAndCharset(title,text); //将文字编码格式以及标题添加到正文部分当中
		String filename = todayDate+"\\"+String.valueOf(System.currentTimeMillis()); //将当前时间的毫秒值当成该新闻文件保存的名称
		String source = SelectChinese.selectChinese(CatchSoureSina.getSourceAsString(page));//来源有的时候抓到汉字和字母，取出汉字，去掉其他的字符
		String time = 	CatchTimeSina.getTimeAsString(page); //抓取新闻更新的时间，格式为20141201082637
		
		System.out.println("网站： " + WebsiteName.SINA);
		System.out.println("新闻标题： " + title);
		System.out.println("新闻类别： " + "考研");
		System.out.println("新闻正文： " +text);
		System.out.println("新闻来源： " + source);
		System.out.println("新闻更新时间： " + time);
		//存入数据库
		StorageToSql.addToSql(
				source,
				IdentifyCode.GRADUATED, 
				"考研", 
				urls.get(i).substring(urls.get(i).length()-16, urls.get(i).length()-6), 
				WebsiteName.SINA, 
				title, 
				time,
				imagpath.get(0), 
				filename);
		//保存为html文件
		SaveHtml.saveToHtmlFile(text, filename);
		}
	}
		
		
	

}
