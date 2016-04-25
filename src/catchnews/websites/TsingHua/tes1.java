package catchnews.websites.TsingHua;

import com.yisinian.iNews.tools.NowDateOrTime;

import catchnews.tools.CatchHtml;
import catchnews.tools.CatchPage;

public class tes1 {

	public static void main(String[] args) {
//		String a ="http://news.tsinghua.edu.cn/publish/news/4204/2015/20150712163509958376533/20150712163509958376533_.html";
//		String page = CatchPage.GetPage(a, "utf8");
//		System.out.println(page);
//		String text  = CatchHtml.getInformationFromContent(page, "(?<=&nbsp;ÄÚÈÝ</div>)[\\s\\S]*(?=datalist_detail)").get(0).replaceAll("src=\"", "src=\"http://news.tsinghua.edu.cn").replaceAll("img", "img style=\"max-width:100%\" ");
//		System.out.println(text);
//		
		//CatchAndStorageNewsFromURL.catchNews(a);
		String a ="20150615";
		String b ="2015";
		String c = "2014";
		System.out.println(a.indexOf(b));
		System.out.println(b.indexOf(c));
		System.out.println(NowDateOrTime.getNowDateAsString());
	}
}
