package catchnews.tools.general;


import catchnews.tools.AddCharset;
import catchnews.tools.AddTitleAndCharset;
import catchnews.tools.SaveHtml;
import catchnews.tools.Select;
import catchnews.tools.SelectNumber;
import catchnews.tools.code.WebsiteName;
import catchnews.tools.general.CatchAndStorageNews;
import cn.edu.hfut.dmic.contentextractor.ContentExtractor;
import cn.edu.hfut.dmic.contentextractor.News;
import cn.edu.hfut.dmic.webcollector.crawler.BreadthCrawler;  
import cn.edu.hfut.dmic.webcollector.model.Links;  
import cn.edu.hfut.dmic.webcollector.model.Page;  

import java.io.File;
import java.util.HashMap;
import java.util.regex.Pattern;  
import org.jsoup.nodes.Document;  
  
/** 
 * Crawl news by website information 
 * 通过网站的信息爬取学校校园网的新闻
 * 
 * 2015.8.11
 * 
 * @author zhu
 */  
public class NewsCrawler extends BreadthCrawler {  
  
    /** 
     * @param crawlPath crawlPath is the path of the directory which maintains 
     * information of this crawler 
     * @param autoParse if autoParse is true,BreadthCrawler will auto extract 
     * links which match regex rules from pag 
     */  
	public static HashMap<String, String> website = new HashMap<String, String>();
	
	
	//获取网站的信息
	public void setWebsite(HashMap<String, String> aWebsite){
		this.website=aWebsite;
	}
	
	
	//初始化爬虫，设定路径，自动抓取，以及网站的信息
    public NewsCrawler(String crawlPath, boolean autoParse,HashMap<String, String> aWebsite) {  
        super(crawlPath, autoParse);  
        this.website=aWebsite;
        /*start page
         * 种子链接
         * */  
        this.addSeed(website.get("seed"));  
  
        /*fetch url like http://news.yahoo.com/xxxxx
         * 有用的链接
         * */  
        this.addRegex(website.get("regex"));  
 
        /*do not fetch url like http://news.yahoo.com/xxxx/xxx)*/  
        //this.addRegex("http://www16.zzu.edu.cn/msgs/vmsgisapi.dll/onemsg");  
        /*do not fetch jpg|png|gif*/  
        //前面的”-“号表示不抓取的网址
        this.addRegex("-.*\\.(jpg|png|gif).*");  
        /*do not fetch url contains #
         * 不想要的新闻
         * */  
        this.addRegex("-.*#.*"); 
        this.addRegex("-"+website.get("ignoreurl")); 
    }  
  
    @Override  
    public void visit(Page page, Links nextLinks) {  
        String url = page.getUrl();  
        /*if page is news page
         * 新闻网页的连接，其他的各种乱起乱七八糟的连接不要哦
         * 获取真实新闻的链接
         * */  
        if (Pattern.matches(website.get("newsurl"), url)) {  
            /*we use jsoup to parse page*/  
        	try {
        		//System.out.println(page.getHtml());
				News news = ContentExtractor.getNewsByUrl(url);
//				String contentElement = news.getContentElement().toString();
//				//有些正文长度比较短，证明正文没有抓取成功，这条新闻放弃掉
//				if(contentElement.length()>300){
//				
//				String url1 =news.getUrl();
//				String title = news.getTitle();
//				String time = news.getTime();
//				String content = AddTitleAndCharset.addTitleAndCharset(title, contentElement);
//				
//					
//				
//				System.out.println("网址url：" + url1);
//				System.out.println("标题：" + title);
//				System.out.println("时间：" + time);
				CatchAndStorageNews.finalWork(url, website);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
  
            /*If you want to add urls to crawl,add them to nextLink*/  
            /*WebCollector automatically filters links that have been fetched before*/  
            /*If autoParse is true and the link you add to nextLinks does not match the regex rules,the link will also been filtered.*/  
            
			//如果查到列表网页，将列表网页插入到下一个爬取列表中
			
//			if(Pattern.matches(".*node_274.htm", url)) {
//            	nextLinks.add(url);  
//            }
        }  
    }  
  
//    public static void main(String[] args) throws Exception {  
//    	//判断这个网站的文件夹是否存在，不存在的话创建
//    	File aFile = new File("d:/inews/htmlfile/"+WebsiteName.SZU.get("english"));
//    	if(!aFile.exists()){
//    		aFile.mkdir();
//    	}
//    	
//        NewsCrawler crawler = new NewsCrawler("crawl", true);  
//        crawler.setThreads(50);  
//        crawler.setTopN(1000);  
//        //crawler.setResumable(true);  
//            /*start crawl with depth of 4*/  
//        crawler.start(3);  
//    }  
    
    //开始执行爬虫
    public static void startCrawler(HashMap<String, String> website,int maxUrlNum,int floodNum,int threadNum ) throws Exception {  
    	
    	
    	//判断这个网站的文件夹是否存在，不存在的话创建
    	File aFile = new File("c:/inews/htmlfile/"+website.get("english"));
    	if(!aFile.exists()){
    		aFile.mkdir();
    	}
    	
        NewsCrawler crawler = new NewsCrawler("crawl", true,website);  
        
        crawler.setThreads(threadNum);  //建议大小 50
        crawler.setTopN(maxUrlNum);  	//建议大小1000以内
        //crawler.setResumable(true);  
            /*start crawl with depth of 4*/  
        crawler.start(floodNum);		//建议值为3
    }  
    
  
}  