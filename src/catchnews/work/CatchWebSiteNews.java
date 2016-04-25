package catchnews.work;

import catchnews.tools.code.NewsWebsite;
import catchnews.tools.code.WebsiteName;
import catchnews.tools.general.NewsCrawler;

public class CatchWebSiteNews {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		NewsCrawler.startCrawler(NewsWebsite.SZSTI, 500, 3, 1); //深圳市科技创新委员会
	}

}
