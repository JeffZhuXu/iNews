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
 * Demo��ʾ��ȡ�ѹ�������������� ��ҳ��ȡ�ѹ�����������������е�ÿ����ҳ������
 *
 * @author hu
 */
public class DemoSogouCrawler extends DeepCrawler {

    public DemoSogouCrawler(String crawlPath) {
        super(crawlPath);
    }
    
    /*��һ������id������Ψһ�ļ���*/
    AtomicInteger id=new AtomicInteger(0);

    @Override
    public Links visitAndGetNextLinks(Page page) {
        String url = page.getUrl();
        
        /*������ѹ���ҳ��*/
        if (Pattern.matches("http://news.tsinghua.edu.cn/publish/news/[\\s\\S].*/index.html", url)) {
            Links nextLinks=new Links();
            /*���������������Ŀ�ĳ����ӷ��أ����������һ����ȡ����ȡ��Щ����*/
            //nextLinks.add(url);
            nextLinks.addAllFromDocument(page.getDoc());
            System.out.println("��������ӣ�" + url);
            

            return nextLinks;
        }else 
        {
            /*��������֮��������2��ҳ�棬�ѹ�����ҳ������������Ӧ��ҳ��,
              �������else{}�ж�Ӧ�������������Ӧ��ҳ�棬����Ҫ������Щҳ�浽����
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
        
            
        
        /*�����е�һ����ȡ�ѹ����������ҳ�棬
          �ڶ�����ȡ���������Ӧ��ҳ��,
          ��������Ҫ����������Ϊ2
        */
        crawler.setThreads(50);  
        crawler.setTopN(1000);   
        crawler.start(3);
    }

}
