package catchnews.webcollector;

import catchnews.tools.SaveHtml;
import catchnews.tools.Select;
import cn.edu.hfut.dmic.contentextractor.ContentExtractor;
import cn.edu.hfut.dmic.contentextractor.News;
import cn.edu.hfut.dmic.webcollector.crawler.DeepCrawler;
import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.util.FileUtils;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;


/**
 * Demo演示爬取搜狗搜索的搜索结果 分页爬取搜狗，并下载搜索结果中的每个网页到本地
 *
 * @author hu
 */
public class DemoSogouCrawler extends DeepCrawler {

    public DemoSogouCrawler(String crawlPath) {
        super(crawlPath);
    }
    
    /*用一个自增id来生成唯一文件名*/
    AtomicInteger id=new AtomicInteger(0);

    @Override
    public Links visitAndGetNextLinks(Page page) {
        String url = page.getUrl();
        
        /*如果是搜狗的页面*/
        if (Pattern.matches("http://news.tsinghua.edu.cn/publish/news/[\\s\\S].*/index.html", url)) {
            Links nextLinks=new Links();
            /*将所有搜索结果条目的超链接返回，爬虫会在下一层爬取中爬取这些链接*/
            //nextLinks.add(url);
            nextLinks.addAllFromDocument(page.getDoc());
            System.out.println("添加新链接：" + url);
            

            return nextLinks;
        }else 
        {
            /*本程序中之可能遇到2种页面，搜狗搜索页面和搜索结果对应的页面,
              所以这个else{}中对应的是搜索结果对应的页面，我们要保存这些页面到本地
            */
            try {
            	News news = ContentExtractor.getNewsByUrl(url);
				SaveHtml.saveToHtmlFile(Jsoup.connect(url).get().html(), "321/"+Select.selectChinese(news.getTitle())+"");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return null;
    }

    
    public static void main(String[] args) throws Exception {
        DemoSogouCrawler crawler = new DemoSogouCrawler("d:/inews/webcollect/web");
        
        
            crawler.addSeed("http://news.tsinghua.edu.cn/publish/news/4204/index.html");
        
            
        
        /*遍历中第一层爬取搜狗的搜索结果页面，
          第二层爬取搜索结果对应的页面,
          所以这里要将层数设置为2
        */
        crawler.setThreads(50);  
        crawler.setTopN(1000);   
        crawler.start(3);
    }

}
