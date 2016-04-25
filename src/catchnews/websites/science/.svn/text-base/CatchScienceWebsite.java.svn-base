package catchnews.websites.science;

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

public class CatchScienceWebsite {

	/**网站《科学网》
	 * 分类：科技类，识别码1
	 * 
	 * 检查最大新闻ID过后的200个ID内的所有
	 * 
	 * @param 朱旭
	 * 2015.7.3
	 */
	public static void main(String[] args) {
		
		String websiteName = "科学网";
		
		//获取当前日期
		Date d = new Date();
		SimpleDateFormat format = 
			new SimpleDateFormat("yyyyMMdd");
		String date = format.format(d);
		//获取最大新闻
		int maxId = FindMaxId.findMaxId("科学网");
		System.out.println("最大新闻ID="+maxId);
		
		//通过循环语句，查找从最大id代码到最大id代码之后200条记录
		for(int i = maxId+1;i< maxId+200;i++)
		{
		String url = "http://news.sciencenet.cn/htmlnews/"
			+Integer.parseInt(date.substring(0, 4))+"/"     //年份
			+Integer.parseInt(date.substring(4, 6))+"/"		//月份
			+i
			+".shtm";
		String page = CatchPage.GetPage(url,"UTF-8");
		String title =CatchTitle.getTitleAsString(page).replaceAll("—新闻—科学网", "");  //抓取标题
		
		//当抓到标题时，认为该条新闻已经更新了，开始执行下面的一系列操作，如果没有抓到标题的话，那么认为新闻没有更新
		if(title!="标题抓取失败"){
			
		
		String text = CatchText.getTextAsString(page);	//抓取正文部分，同时将图片链接修正，设置成自适应手机屏幕大小
		List<String> imagpath = CatchImage.getImageAsString(text); //从正文部分将所需要的图片给抓进来
		text = AddTitleAndCharset.addTitleAndCharset(title,text); //将文字编码格式以及标题添加到正文部分当中
		String filename ="KXW"+"\\"+ String.valueOf(System.currentTimeMillis()); //将当前时间的毫秒值当成该新闻文件保存的名称
		String source = SelectChinese.selectChinese(CatchSoure.getSourceAsString(page));//来源有的时候抓到汉字和字母，取出汉字，去掉其他的字符
		String time = 	CatchTimeSc.getTimeAsString(page); //抓取新闻更新的时间，格式为20141201082637
		
		String schools = Catch.getRelativeSchools(text).toString();
		
		System.out.println("网站： " + websiteName);
		System.out.println("新闻标题： " + title);
		System.out.println("新闻ID： " + i) ;
		System.out.println("新闻来源： " + source);
		System.out.println("新闻更新时间： " + time);
		//存入数据库
		StorageToSql.addToSqlWithRelativeSchools(
				source,
				IdentifyCode.TECHNOLOGY, 
				"要闻", 
				String.valueOf(i), 
				websiteName, 
				title, 
				time.substring(0, 8),
				imagpath.get(0), 
				filename,
				schools);
		//保存为html文件
		SaveHtml.saveToHtmlFile(text, filename);
		}
		
		
		}
	}

}
