package catchnews.websites.sina;

import catchnews.tools.CatchImage;
import catchnews.tools.CatchPage;
import catchnews.tools.CatchTitle;

public class testSina {

	
	public static void main(String[] args) {
		String url = "http://roll.edu.sina.com.cn/lm/ky3/kyzx/kaoshi/index_5.shtml";
		String page = CatchPage.GetPage(url, "GB2312");
//		String text = CatchTextSina.getTextAsString(page);
//		String source = CatchSoureSina.getSourceAsString(page);
//		String updateTime = CatchTimeSina.getTimeAsString(page) ;
//			
//		System.out.println(page);
//		System.out.println(CatchTitle.getTitleAsString(page).replaceAll("_新浪教育_新浪网", ""));
//		System.out.println("正文部分： " + text);
//		System.out.println("图片： " + CatchImageSina.getImageAsString(text));
//		System.out.println("来源："  + source);
//		System.out.println("更新时间： " +  updateTime);
		

		for(int i=6;i<431;i++){
			String a  = "http://roll.edu.sina.com.cn/all/jyxx/index_"+i+".shtml";
			CatchSinaEducationWebsite.catchSinaNews(a);
		}
		for(int j=1;j<120;j++){
			String b  = "http://roll.edu.sina.com.cn/all/jysp/index_"+j+".shtml";
			CatchSinaEducationJudgmentWebsite.catchSinaNews(b);
		}
		for(int k =6;k<463;k++){
			
			String c = "http://roll.edu.sina.com.cn/lm/ky3/kyzx/kaoshi/index_"+k+".shtml"; //考研类主页，页数从1到462
			
			CatchSinaGraduatedWebsite.catchSinaNews(c);
			

			}
		
	}
}
