package catchnews.websites.sina;

import catchnews.tools.FindMaxId;

public class CatchAllSinaWebsites {
	public static void main(String[] args) {
		
		//�������е�ҳ��
		for(int i =6;i<463;i++){
		
		String url = "http://roll.edu.sina.com.cn/lm/ky3/kyzx/kaoshi/index_"+i+".shtml"; //��������ҳ��ҳ����1��462
		
		CatchSinaGraduatedWebsite.catchSinaNews(url);
		
		
		}
	}

}
