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

//一次性把科学网上的所有新闻抓下来

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
			text = AddTitleAndCharset.addTitleAndCharset(title,text); //将文字编码格式以及标题添加到正文部分当中
			String time = CatchTimeSc.getTimeAsString(pages);
			List<String> imgPath = CatchImage.getImageAsString(text);
			String source = CatchSoure.getSourceAsString(pages);
			
			System.out.println("新闻标题： " + title);
			System.out.println("新闻来源： " + source);
			System.out.println("新闻正文： " + text);
			System.out.println("新闻更新时间：" +  time);
			System.out.println("图片链接：  " + imgPath);
			
			String filename = String.valueOf(System.currentTimeMillis()); //保存的文件名
			
			//存入数据库
			StorageToSql.addToSql(
					source,
					IdentifyCode.TECHNOLOGY, 
					"要闻", 
					String.valueOf(0), 
					WebsiteName.SCIENCE, 
					title, 
					time,
					imgPath.get(0), 
					filename);
			//保存为html文件
			SaveHtml.saveToHtmlFile(text, filename);
			}
		}
	}
	
}
