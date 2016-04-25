package catchnews.tools.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/*
 * 存放各种新闻的门户网站的网址以及爬虫的信息
 * 2015.8.18
 * 朱旭
 *
 * 
 * */
public class NewsWebsite {

	public static final List<String> newsWebsiteNames = new ArrayList<String>(){
		{
			add("网易教育网");
			add("新京报网");
			add("深圳市科技创新委员会");
			
		}
	};
	
	
	
	
	//网易教育网
	public static final HashMap<String, String> WYJYW = new HashMap<String, String>() {
	    {
	        put("chinese", "网易教育网");  //中文名
	        put("english", "WYJYW");  //英文名个文件夹名
	        put("idcode", IdentifyCode.EDUCATIONNEWS);  		//教育新闻
	        put("seed", "http://edu.163.com/"); //爬虫种子点
	        put("regex", ".*163.com/.*"); 			//爬取链接形式
	        put("newsurl", ".*163.com/1[5-9]{1}/[0-9]{4}/.*"); 		//真正新闻链接形式
	        put("ignoreurl", ".*(auto|kids|a).163.com.*"); 													//要忽略的新闻链接形式
	        put("wordlength", "400");  //最低正文长度
	        put("title", "");  //通用的title抓取器抓不到，用单独的正则
	    }
	};
	//新京报网
	public static final HashMap<String, String> XJBW = new HashMap<String, String>() {
	    {
	        put("chinese", "新京报网");  //中文名
	        put("english", "XJBW");  //英文名个文件夹名
	        put("idcode", IdentifyCode.EDUCATIONNEWS);  		//教育新闻
	        put("seed", "http://edu.bjnews.com.cn/"); //爬虫种子点
	        put("regex", "http://www.bjnews.com.cn/.*"); 			//爬取链接形式
	        put("newsurl", "http://www.bjnews.com.cn/edu/201[5-9]{1}.*"); 		//真正新闻链接形式
	        put("ignoreurl", ""); 													//要忽略的新闻链接形式
	        put("wordlength", "400");  //最低正文长度
	        put("title", "");  //通用的title抓取器抓不到，用单独的正则
	    }
	};
	
	//深圳市科技创新委员会
	public static final HashMap<String, String> SZSTI = new HashMap<String, String>() {
	    {
	        put("chinese", "深圳市科技创新委员会");  //中文名
	        put("english", "SZSTI");  //英文名个文件夹名
	        put("idcode", IdentifyCode.TECHNOLOGY);  		//教育新闻
	        put("seed", "http://www.szsti.gov.cn/news"); //爬虫种子点
	        put("regex", "http://www.szsti.gov.cn/news.*"); 			//爬取链接形式
	        put("newsurl", "http://www.szsti.gov.cn/news/20.*/.*"); 		//真正新闻链接形式
	        put("ignoreurl", ""); 													//要忽略的新闻链接形式
	        put("wordlength", "300");  //最低正文长度
	        put("title", "");  //通用的title抓取器抓不到，用单独的正则
	    }
	};
	
}
