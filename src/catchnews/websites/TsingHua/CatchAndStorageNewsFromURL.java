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
	
	//根据网页，抓取新闻信息，保存并存入数据库，
	//参数，网页地址，新闻类型
	
	public static void catchNews(String URL,String type) {

		String url=URL;
		String page = CatchPage.GetPage(url, "utf8").replaceAll("<div id=\"hidden_detail\" style=\"display:none;\">", "");
		String title = CatchTitle.getTitleAsString(page);
		String releaseTime = SelectNumber.selectNumber(CatchHtml.getInformationFromContent(page,"(?<=更新)[\\s\\S]*?(?=]</div>)").get(0));
		
		//是当天的新闻在往下走
		if((releaseTime.indexOf(NowDateOrTime.getNowDateAsString())>-1)){
			
		
		title = title.substring(0, title.indexOf("清华大学新闻网")).replaceAll("-", "");
		
		String text = CatchHtml.getInformationFromContent(page, "(?<=&nbsp;内容</div>)[\\s\\S]*(?=<div id=\"datalist_detail\">)").get(0).replaceAll("src=\"", "src=\"http://news.tsinghua.edu.cn").replaceAll("img", "img style=\"max-width:100%\" ");
		text = AddCharset.addTitleAndCharset(title, text);
		List<String> imagePath = CatchImage.getImageAsString(text);
		//文件名，前面是文件夹名称，后面是具体文件名，用系统当前的毫秒值来定 20150722\125212521
		String fileName = NowDateOrTime.getNowDateAsString()+"\\"+String.valueOf(System.currentTimeMillis());
		
		//当该条新闻是当天的新闻的时候，再执行下面的相关操作，负责不上传
		if((title!="没匹配内容")&&(text!="没匹配内容")&&(releaseTime!="没匹配内容")){
			
		
		SaveHtml.saveToHtmlFile(text, fileName);
		StorageToSql.addToSql(WebsiteName.TSINGHUA.get("chinese"), "3", type, String.valueOf(System.currentTimeMillis()), WebsiteName.TSINGHUA.get("chinese"), title, releaseTime, imagePath.get(0), fileName);
		
		System.out.println("网址：" + url );
		System.out.println("标题：" + title);
		//System.out.println("正文：" + text);
		System.out.println("时间：" + releaseTime);
		System.out.println("图片：" + imagePath);
		System.out.println("文件名：" + fileName);
		
		}
		}

	}

	
}
