package catchnews.websites.TsingHua;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatchAllTsinghuaNews {

	/**抓取清华大学所有类型的新闻
	 * 朱旭
	 * 2015.07.30
	 * @param 无
	 */
	//存放新闻网页的列表网页
	public static  List<String> webpages =  Arrays.asList(
			"http://news.tsinghua.edu.cn/publish/news/4204/index.html", //头条新闻
			"http://news.tsinghua.edu.cn/publish/news/4205/index.html", //综合新闻
			"http://news.tsinghua.edu.cn/publish/news/4207/index.html",//媒体清华
			"http://news.tsinghua.edu.cn/publish/news/4208/index.html",//清华人物
			"http://news.tsinghua.edu.cn/publish/news/4209/index.html", //教学科研
			"http://news.tsinghua.edu.cn/publish/news/4210/index.html", //招生就业
			"http://news.tsinghua.edu.cn/publish/news/4211/index.html",//国际合作
			"http://news.tsinghua.edu.cn/publish/news/4212/index.html", //校园写意
			"http://news.tsinghua.edu.cn/publish/news/4213/index.html", //校友动态
			"http://news.tsinghua.edu.cn/publish/news/4214/index.html", //领导讲话
			"http://news.tsinghua.edu.cn/publish/news/4215/index.html",//紫荆论坛
			"http://news.tsinghua.edu.cn/publish/news/4216/index.html",//清华史苑
			"http://news.tsinghua.edu.cn/publish/news/4195/index.html", //高教视点
			"http://news.tsinghua.edu.cn/publish/news/4217/index.html", //社会服务
			"http://news.tsinghua.edu.cn/publish/news/4225/index.html"//信息预告
	);
	//存放新闻类型
	public static  List<String> types =  Arrays.asList(

			"头条新闻",
			"综合新闻",
			"媒体清华",
			"清华人物",
			"教学科研",
			"招生就业",
			"国际合作",
			"校园写意",
			"校友动态",
			"领导讲话",
			"紫荆论坛",
			"清华史苑",
			"高教视点",
			"社会服务",
			"信息预告"
			
	);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i=0;i<webpages.size();i++){
			//逐一取出新闻列表网页
			List<String> urls = CatchURL.getURLsFromWebpage(webpages.get(i));
			for(int j=0;j<urls.size();j++){
				CatchAndStorageNewsFromURL.catchNews(urls.get(j).replace("/publish", "http://news.tsinghua.edu.cn/publish"), types.get(i));
			}

		}

	}

}
