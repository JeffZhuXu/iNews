package catchnews.webcollector;

import catchnews.tools.Add;
import catchnews.tools.AddCharset;
import catchnews.tools.AddTitleAndCharset;
import catchnews.tools.SaveHtml;
import catchnews.tools.Select;
import catchnews.tools.SelectNumber;
import catchnews.tools.code.WebsiteName;
import cn.edu.hfut.dmic.contentextractor.ContentExtractor;
import cn.edu.hfut.dmic.contentextractor.News;
import cn.edu.hfut.dmic.webcollector.crawler.BreadthCrawler;  
import cn.edu.hfut.dmic.webcollector.model.Links;  
import cn.edu.hfut.dmic.webcollector.model.Page;  
import java.util.regex.Pattern;  
import org.jsoup.nodes.Document;  
  
/** 
 * Crawl news from yahoo news 
 * 
 * @author hu 
 */  
public class TsingHuaCrawler extends BreadthCrawler {  
  
    /** 
     * @param crawlPath crawlPath is the path of the directory which maintains 
     * information of this crawler 
     * @param autoParse if autoParse is true,BreadthCrawler will auto extract 
     * links which match regex rules from pag 
     */  
    public TsingHuaCrawler(String crawlPath, boolean autoParse) {  
        super(crawlPath, autoParse);  
        /*start page*/  
        this.addSeed("http://news.tsinghua.edu.cn/publish/news/4204/index.html");  
  
        /*fetch url like http://news.yahoo.com/xxxxx*/  
        this.addRegex("http://news.tsinghua.edu.cn/publish/news/.*");  
        /*do not fetch url like http://news.yahoo.com/xxxx/xxx)*/  
        //this.addRegex("http://www16.zzu.edu.cn/msgs/vmsgisapi.dll/onemsg");  
        /*do not fetch jpg|png|gif*/  
        //前面的”-“号表示不抓取的网址
        this.addRegex("-.*\\.(jpg|png|gif).*");  
        /*do not fetch url contains #*/  
        this.addRegex("-.*#.*");  
    }  
  
    @Override  
    public void visit(Page page, Links nextLinks) {  
        String url = page.getUrl();  
        /*if page is news page*/  
        if (Pattern.matches("http://news.tsinghua.edu.cn/publish/news.*", url)) {  
            /*we use jsoup to parse page*/  
        	try {
        		//System.out.println(page.getHtml());
				News news = ContentExtractor.getNewsByUrl(url);
				String contentElement = news.getContentElement().toString();
				//有些正文长度比较短，证明正文没有抓取成功，这条新闻放弃掉
				if(contentElement.length()>300){
				
				String url1 =news.getUrl();
				String title = news.getTitle();
				String time = news.getTime();
				//正文里面如果包含标题了，把原有的标题覆盖掉
				String content = Add.addTitleAndCharset(title, contentElement.replaceAll(title, ""), WebsiteName.TSINGHUA.get("chinese"), time);
				
					
				
				System.out.println("网址url：" + url1);
				System.out.println("标题：" + title);
				System.out.println("时间：" + time);
				SaveHtml.saveToHtmlFile(content,"123/"+Select.selectChinese(title));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
  
            /*If you want to add urls to crawl,add them to nextLink*/  
            /*WebCollector automatically filters links that have been fetched before*/  
            /*If autoParse is true and the link you add to nextLinks does not match the regex rules,the link will also been filtered.*/  
            
			//如果查到列表网页，将列表网页插入到下一个爬取列表中
			
			if(Pattern.matches(".*index.html", url)) {
            	nextLinks.add(url);  
            	System.out.println("添加链接：" + url);
            }
        }  
    }  
  
    public static void main(String[] args) throws Exception {  
        TsingHuaCrawler crawler = new TsingHuaCrawler("crawl", true);  
        crawler.setThreads(50);  
        crawler.setTopN(2000);  
        //crawler.setResumable(true);  
            /*start crawl with depth of 4*/  
        crawler.start(3);  
    }  
  
}  