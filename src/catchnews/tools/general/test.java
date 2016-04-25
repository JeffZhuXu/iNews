package catchnews.tools.general;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import cn.edu.hfut.dmic.contentextractor.ContentExtractor;
import cn.edu.hfut.dmic.contentextractor.News;
import cn.edu.hfut.dmic.webcollector.model.Page;

import catchnews.cxextractor.TextExtract;
import catchnews.cxextractor.UseDemo;
import catchnews.tools.Catch;
import catchnews.tools.CatchHtml;
import catchnews.tools.CatchPage;
import catchnews.tools.Select;
import catchnews.tools.StorageToSql;
import catchnews.tools.code.WebsiteName;

public class test {
	public static void main(String[] args) throws Exception {
		String url1 = "http://edu.sina.com.cn/gaokao/2015-08-17/1045481227.shtml";
//		Document doc = Jsoup.connect(url1).get();
		Document doc = Jsoup.connect(url1).get();
		//System.out.println(doc);
		System.out.println("Jsoup�Դ�title�� "+ doc.title());
		//System.out.println(Catch.getBestTitleAsString(doc));
		News news = ContentExtractor.getNewsByDoc(doc);
		System.out.println(news);
		System.out.println("webcrawer�Դ�title�� "+ news.getTitle());
		System.out.println("�Լ�������title�� " + Catch.GetMyTitle(doc.html()));
		System.out.println("ͨ�÷���title�� " + CatchAndStorageNews.getBestTitleAsString(doc));
		System.out.println("���ѧУ��" +
				CatchAndStorageEducationNews.getRelativeSchools(doc.toString()));
		//System.out.println(TextExtract.parse(doc.toString()));
		//CatchAndStorageNews.finalWork(url1, WebsiteName.WHDX);
		
		
	}
	
}
