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
 * ͨ����վ����Ϣ��ȡѧУУ԰��������
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
	
	
	//��ȡ��վ����Ϣ
	public void setWebsite(HashMap<String, String> aWebsite){
		this.website=aWebsite;
	}
	
	
	//��ʼ�����棬�趨·�����Զ�ץȡ���Լ���վ����Ϣ
    public NewsCrawler(String crawlPath, boolean autoParse,HashMap<String, String> aWebsite) {  
        super(crawlPath, autoParse);  
        this.website=aWebsite;
        /*start page
         * ��������
         * */  
        this.addSeed(website.get("seed"));  
  
        /*fetch url like http://news.yahoo.com/xxxxx
         * ���õ�����
         * */  
        this.addRegex(website.get("regex"));  
 
        /*do not fetch url like http://news.yahoo.com/xxxx/xxx)*/  
        //this.addRegex("http://www16.zzu.edu.cn/msgs/vmsgisapi.dll/onemsg");  
        /*do not fetch jpg|png|gif*/  
        //ǰ��ġ�-���ű�ʾ��ץȡ����ַ
        this.addRegex("-.*\\.(jpg|png|gif).*");  
        /*do not fetch url contains #
         * ����Ҫ������
         * */  
        this.addRegex("-.*#.*"); 
        this.addRegex("-"+website.get("ignoreurl")); 
    }  
  
    @Override  
    public void visit(Page page, Links nextLinks) {  
        String url = page.getUrl();  
        /*if page is news page
         * ������ҳ�����ӣ������ĸ����������߰�������Ӳ�ҪŶ
         * ��ȡ��ʵ���ŵ�����
         * */  
        if (Pattern.matches(website.get("newsurl"), url)) {  
            /*we use jsoup to parse page*/  
        	try {
        		//System.out.println(page.getHtml());
				News news = ContentExtractor.getNewsByUrl(url);
//				String contentElement = news.getContentElement().toString();
//				//��Щ���ĳ��ȱȽ϶̣�֤������û��ץȡ�ɹ����������ŷ�����
//				if(contentElement.length()>300){
//				
//				String url1 =news.getUrl();
//				String title = news.getTitle();
//				String time = news.getTime();
//				String content = AddTitleAndCharset.addTitleAndCharset(title, contentElement);
//				
//					
//				
//				System.out.println("��ַurl��" + url1);
//				System.out.println("���⣺" + title);
//				System.out.println("ʱ�䣺" + time);
				CatchAndStorageNews.finalWork(url, website);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
  
            /*If you want to add urls to crawl,add them to nextLink*/  
            /*WebCollector automatically filters links that have been fetched before*/  
            /*If autoParse is true and the link you add to nextLinks does not match the regex rules,the link will also been filtered.*/  
            
			//����鵽�б���ҳ�����б���ҳ���뵽��һ����ȡ�б���
			
//			if(Pattern.matches(".*node_274.htm", url)) {
//            	nextLinks.add(url);  
//            }
        }  
    }  
  
//    public static void main(String[] args) throws Exception {  
//    	//�ж������վ���ļ����Ƿ���ڣ������ڵĻ�����
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
    
    //��ʼִ������
    public static void startCrawler(HashMap<String, String> website,int maxUrlNum,int floodNum,int threadNum ) throws Exception {  
    	
    	
    	//�ж������վ���ļ����Ƿ���ڣ������ڵĻ�����
    	File aFile = new File("c:/inews/htmlfile/"+website.get("english"));
    	if(!aFile.exists()){
    		aFile.mkdir();
    	}
    	
        NewsCrawler crawler = new NewsCrawler("crawl", true,website);  
        
        crawler.setThreads(threadNum);  //�����С 50
        crawler.setTopN(maxUrlNum);  	//�����С1000����
        //crawler.setResumable(true);  
            /*start crawl with depth of 4*/  
        crawler.start(floodNum);		//����ֵΪ3
    }  
    
  
}  