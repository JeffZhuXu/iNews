package catchnews.work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import catchnews.tools.code.WebsiteName;
import catchnews.tools.general.NewsCrawler;

public class Catch985News {

	/**抓取各个学校网站新闻的主程序
	 * 
	 * @param 学校的map信息
	 * 
	 * @author 朱旭
	 * @throws Exception 
	 */

	public static void main(String[] args) throws Exception {
		
		//开始时间
	Long starttime = System.currentTimeMillis();

	NewsCrawler.startCrawler(WebsiteName.ZGKXJSDX, 500, 4, 50); //中国科学技术大学
	NewsCrawler.startCrawler(WebsiteName.PEKING, 400, 4, 50); //北京大学
	NewsCrawler.startCrawler(WebsiteName.TSINGHUA, 500, 3, 50); //清华大学
	NewsCrawler.startCrawler(WebsiteName.SZU, 500, 3, 50); //深圳大学
//	NewsCrawler.startCrawler(WebsiteName.NJDX, 500, 3, 50); //南京大学  防爬虫
	NewsCrawler.startCrawler(WebsiteName.ZGRMDX, 500, 3, 50); //中国人民大学
	NewsCrawler.startCrawler(WebsiteName.BJHKHTDX, 500, 4, 50); //北京航空航天大学
	NewsCrawler.startCrawler(WebsiteName.BJLGDX, 500, 4, 50); //北京理工大学
	NewsCrawler.startCrawler(WebsiteName.ZGNYDX, 500, 4, 50); //中国农业大学
	NewsCrawler.startCrawler(WebsiteName.BJXHYY, 500, 4, 50); //北京协和医院
	NewsCrawler.startCrawler(WebsiteName.BJSFDX, 500, 4, 50); //北京师范大学
	NewsCrawler.startCrawler(WebsiteName.ZYMZDX, 500, 3, 50); //中央名族大学
	NewsCrawler.startCrawler(WebsiteName.BJDXYXB, 500, 3, 50); //北京大学医学部
	NewsCrawler.startCrawler(WebsiteName.CQDX, 500, 3, 50); //重庆大学
	NewsCrawler.startCrawler(WebsiteName.XMDX, 500, 4, 50); //厦门大学
	NewsCrawler.startCrawler(WebsiteName.LZDX, 500, 3, 50); //兰州大学
	NewsCrawler.startCrawler(WebsiteName.ZSDX, 500, 4, 50); //中山大学      标题抓取失败
	NewsCrawler.startCrawler(WebsiteName.HNLGDX, 500, 4, 50);  //华南理工大学
	NewsCrawler.startCrawler(WebsiteName.DBDX, 500, 3, 50);   //东北大学
	NewsCrawler.startCrawler(WebsiteName.HEBGYDX, 500, 4, 50);   //哈尔滨工业大学
	NewsCrawler.startCrawler(WebsiteName.BJSFDX, 500, 3, 50);   //北京师范大学   这个学校正文有一个<div,标题抓取失败
//	NewsCrawler.startCrawler(WebsiteName.WHDX, 300, 3, 50);   //武汉大学  很慢，不抓了
	NewsCrawler.startCrawler(WebsiteName.HZKJDX, 500, 3, 50);  //华中科技大学
	NewsCrawler.startCrawler(WebsiteName.HNDX, 500, 3, 50);   //湖南大学
	NewsCrawler.startCrawler(WebsiteName.ZNDX, 500, 3, 50); //中南大学
	NewsCrawler.startCrawler(WebsiteName.GFKXJSDX, 500, 4, 50); //国防科技大学
	NewsCrawler.startCrawler(WebsiteName.JLDX, 500, 3, 50);  //吉林大学
	NewsCrawler.startCrawler(WebsiteName.DNDX, 500,5, 50);  //东南大学
	NewsCrawler.startCrawler(WebsiteName.DLLGDX, 500,3, 50);  //大连理工大学
	NewsCrawler.startCrawler(WebsiteName.SDDX, 500,4, 50);  //山东大学
	NewsCrawler.startCrawler(WebsiteName.ZGHYDX, 800,3, 50); //中国海洋大学
	NewsCrawler.startCrawler(WebsiteName.HEBGYDXWH, 500,3, 50); //哈尔滨工业大学(威海)
	NewsCrawler.startCrawler(WebsiteName.XAJTDX, 500,3, 50); //西安交通大学
	NewsCrawler.startCrawler(WebsiteName.XBGYDX, 500,4, 50);	//西北工业大学
	NewsCrawler.startCrawler(WebsiteName.XBNLKJDX, 500,4, 50);	//西北农林科技大学
	NewsCrawler.startCrawler(WebsiteName.FDDX, 500,3, 50); 	//复旦大学
//	NewsCrawler.startCrawler(WebsiteName.TJDX, 500,3, 50);	//同济大学   防爬虫，最高等级
	NewsCrawler.startCrawler(WebsiteName.SHJTDX, 500,3, 50); //上海交通大学
	NewsCrawler.startCrawler(WebsiteName.HDSFDX, 500,3, 50); //华东师范大学
	NewsCrawler.startCrawler(WebsiteName.SCDX, 500,3, 50);	//四川大学
	NewsCrawler.startCrawler(WebsiteName.DZKJDX, 500,3, 50);	//电子科技大学
	NewsCrawler.startCrawler(WebsiteName.NKDX, 500,3, 50);	//南开大学
	NewsCrawler.startCrawler(WebsiteName.TIANJINDX, 500,3, 50);	//天津大学
	NewsCrawler.startCrawler(WebsiteName.ZJDX, 500,3, 50);	//浙江大学
	
	//结束时间
	Long endtime = System.currentTimeMillis();
	System.out.println("抓取所有网页的时间：" + (endtime-starttime) + " 毫秒" );
	}
}
