package catchnews.tools.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WebsiteName {

	//保存新闻获取网站的信息
	/*chinese为网站中文名称
	 * english为英文名，也是保存的文件夹名称
	 * idcode表示新闻类型的识别码
	 * seed表示爬虫的种子点
	 * regex表示需要的新闻链接以及新闻列表链接的格式，为正则表达式，必须同时包含新闻的和新闻列表的链接，要不然其他的列表就抓不到了
	 * newsurl表示真正新闻的链接，正则表达式
	 * wordlength 正文最低的长度，低于这个值这条新闻无效
	 * title通用的title抓取器抓不到，用单独的正则
	 * 
	 * 
	 * 
	*/
	
		public static final List<String> schoolNames = new ArrayList<String>(){
			{
				add("清华大学");
				add("北京大学");
				add("深圳大学");
				add("中国科学技术大学");
				add("中国人民大学");
				add("南京大学");
				add("北京航空航天大学");
				add("北京理工大学");
				add("中国农业大学");
				add("北京师范大学");
				add("北京协和医院");
				add("中国人民大学");
				add("中央名族大学");
				add("北京大学医学部");
				add("重庆大学");
				add("厦门大学");
				add("兰州大学");
				add("中山大学");
				add("华南理工大学");
				add("东北大学");
				add("哈尔滨工业大学");
				add("武汉大学");
				add("中华中科技大学");
				add("湖南大学");
				add("中南大学");
				add("国防科技大学");
				add("吉林大学");
				add("东南大学");
				add("大连理工大学");
				add("山东大学");
				add("中国海洋大学");
				add("哈尔滨工业大学(威海)");
				add("西安交通大学");
				add("西北工业大学");
				add("西北农林科技大学");
				add("复旦大学");
				add("同济大学");
				add("上海交通大学");
				add("华东师范大学");
				add("四川大学");
				add("电子科学技术大学");
				add("南开大学");
				add("天津大学");
				add("浙江大学");
				
				
			}
		};
		


		public static final String SCIENCE = "科学网";    
		public static final String SINA = "新浪教育网";   
		//public static final String[] TSINGHUA = new String["清华大学新闻网","TSINGHUA"];   
		

		//清华大学新闻网
		public static final HashMap<String, String> TSINGHUA = new HashMap<String, String>() {
		    {
		        put("chinese", "清华大学新闻网");  //中文名
		        put("english", "TSINGHUA");  //英文名个文件夹名
		        put("idcode", "3");  		//新闻类型识别码
		        put("seed", "http://news.tsinghua.edu.cn/publish/news/4204/index.html"); //爬虫种子点
		        put("regex", "http://news.tsinghua.edu.cn/publish/news.*"); 			//爬取链接形式
		        put("newsurl", "http://news.tsinghua.edu.cn/publish/news.*[0-9]{5,10}_.*"); 		//真正新闻链接形式
		        put("ignoreurl", ""); 													//要忽略的新闻链接形式
		        put("wordlength", "400");  //最低正文长度
		        put("title", "");  //通用的title抓取器抓不到，用单独的正则
		    }
		};
		
		//北京大学新闻网
		public static final HashMap<String, String> PEKING = new HashMap<String, String>() {
		    {
		        put("chinese", "北京大学新闻网"); 
		        put("english", "PEKING");  
		        put("idcode", "3");  
		        put("seed", "http://pkunews.pku.edu.cn/xxfz/node_185.htm"); 
		        put("regex", "http://pkunews.pku.edu.cn/.*"); 			//爬取链接形式
		        put("newsurl", "http://pkunews.pku.edu.cn/.*/201[0-9]{1}.*/.*[0-9]{5,10}.*"); 		//真正新闻链接形式
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", "");  //通用的title抓取器抓不到，用单独的正则
		    }
		};
		
		//深圳大学新闻网
		public static final HashMap<String, String> SZU = new HashMap<String, String>() {
		    {
		        put("chinese", "深圳大学新闻网");  
		        put("english", "SZU");  
		        put("idcode", "3");  
		        put("seed", "http://www.szu.edu.cn/2014/news/"); 
		        put("regex", "http://www.szu.edu.cn/2014/.*"); 
		        put("newsurl", "http://www.szu.edu.cn/2014/.*[0-9]{3,20}.*"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", "");  //通用的title抓取器抓不到，用单独的正则
		        
		        
		    }
		};
		
		//中国科学技术大学
		public static final HashMap<String, String> ZGKXJSDX = new HashMap<String, String>() {
		    {
		        put("chinese", "中国科学技术大学新闻网");  
		        put("english", "ZGKXJSDX");  
		        put("idcode", "3");  
		        put("seed", "http://news.ustc.edu.cn/xwbl/201507/t20150723_224441.html"); 
		        put("regex", "http://news.ustc.edu.cn/.*"); 
		        put("newsurl", "http://news.ustc.edu.cn/.*html"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", "");  //通用的title抓取器抓不到，用单独的正则
		        
		        
		    }
		};
	
		//中国科人民大学
		public static final HashMap<String, String> ZGRMDX = new HashMap<String, String>() {
		    {
		        put("chinese", "中国人民大学新闻网");  
		        put("english", "ZGRMDX");  
		        put("idcode", "3");  
		        put("seed", "http://news.ruc.edu.cn/archives/category/important_news"); 
		        put("regex", "http://news.ruc.edu.cn/archives/.*"); 
		        put("newsurl", "http://news.ruc.edu.cn/archives/[0-9]{3,10}.*"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", "");  //通用的title抓取器抓不到，用单独的正则
		        
		        
		    }
		};
		
		//南京大学
		public static final HashMap<String, String> NJDX = new HashMap<String, String>() {
		    {
		        put("chinese", "南京大学新闻网");  
		        put("english", "NJDX");  
		        put("idcode", "3");  
		        put("seed", "http://news.nju.edu.cn/list_1.html"); 
		        put("regex", "http://news.nju.edu.cn/.*"); 
		        put("newsurl", "http://news.nju.edu.cn/show_article_.*"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", "");  //通用的title抓取器抓不到，用单独的正则
		        
		        
		    }
		};
		
		//北京航空航天大学
		public static final HashMap<String, String> BJHKHTDX = new HashMap<String, String>() {
		    {
		        put("chinese", "北京航空航天大学新闻网");  
		        put("english", "BJHKHTDX");  
		        put("idcode", "3");  
		        put("seed", "http://news.buaa.edu.cn/zhxw/index.htm"); 
		        put("regex", "http://news.buaa.edu.cn/.*"); 
		        put("newsurl", "http://news.buaa.edu.cn/.*[0-9]{3,5}.*"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "600");
		        put("title", "");  //通用的title抓取器抓不到，用单独的正则
		        
		        
		    }
		};
		//北京理工大学
		public static final HashMap<String, String> BJLGDX = new HashMap<String, String>() {
		    {
		        put("chinese", "北京理工大学新闻网");  
		        put("english", "BJLGDX");  
		        put("idcode", "3");  
		        put("seed", "http://www.bit.edu.cn/xww/xwtt/index.htm"); 
		        put("regex", "http://www.bit.edu.cn/xww/.*"); 
		        put("newsurl", "http://www.bit.edu.cn/xww/.*[0-9]{3,5}\\.htm"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", "");  //通用的title抓取器抓不到，用单独的正则
		        
		        
		    }
		};
		

		//中国农业大学
		public static final HashMap<String, String> ZGNYDX = new HashMap<String, String>() {
		    {
		        put("chinese", "中国农业大学新闻网");  
		        put("english", "ZGNYDX");  
		        put("idcode", "3");  
		        put("seed", "http://news.cau.edu.cn/col/col8769/index.html"); 
		        put("regex", "http://news.cau.edu.cn/.*"); 
		        put("newsurl", "http://news.cau.edu.cn/.*[0-9]{3,10}\\.html"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", "");  //通用的title抓取器抓不到，用单独的正则
		        
		        
		    }
		};
		
		//北京师范大学   注：title抓取不成功，正文部分有一个<div固定正文格式，去掉
		public static final HashMap<String, String> BJSFDX = new HashMap<String, String>() {
		    {
		        put("chinese", "北京师范大学新闻网");  
		        put("english", "BJSFDX");  
		        put("idcode", "3");  
		        put("seed", "http://www.bnu.edu.cn/bsdkx/index.html"); 
		        put("regex", "http://news.bnu.edu.cn/.*"); 
		        put("newsurl", "http://news.bnu.edu.cn/.*[0-9]{3,10}\\.htm"); 
		        
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", "(?<=(<h2>|<h3>))[\\s\\S]*(?=(</h2>|</h3>))");  
		        
		        
		    }
		};
		
		//北京协和医院
		public static final HashMap<String, String> BJXHYY = new HashMap<String, String>() {
		    {
		        put("chinese", "北京协和医院");  
		        put("english", "BJXHYY");  
		        put("idcode", "3");  
		        put("seed", "http://www.pumch.cn/Category_42/Index.aspx"); 
		        put("regex", "http://www.pumch.cn/((Category_42/Index.*)|(Item.*))\\.aspx"); 
		        put("newsurl", "http://www.pumch.cn/Item.*[0-9]{5,10}.*"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", ""); 
		        
		        
		    }
		};
		
		//中央名族大学 注：抓不到，各种方法都抓不到
		public static final HashMap<String, String> ZYMZDX = new HashMap<String, String>() {
		    {
		        put("chinese", "中央名族大学");  
		        put("english", "ZYMZDX");  
		        put("idcode", "3");  
		        put("seed", "http://www.muc.edu.cn/xwdt/zhxw/"); 
		        put("regex", "http://www.muc.edu.cn/.*"); 
		        put("newsurl", "http://www.muc.edu.cn/.*/[0-9]{3,4}.*"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", "(?<=H2\">)[\\s\\S]*(?=(</h2>))"); 
		        
		        
		    }
		};
		
		//北京大学医学部
		public static final HashMap<String, String> BJDXYXB = new HashMap<String, String>() {
		    {
		        put("chinese", "北京大学医学部");  
		        put("english", "BJDXYXB");  
		        put("idcode", "3");  
		        put("seed", "http://bynew.bjmu.edu.cn/zhxw/2014n/178628.htm"); 
		        put("regex", "http://bynew.bjmu.edu.cn/.*"); 
		        put("newsurl", "http://bynew.bjmu.edu.cn/.*/[0-9]{4,10}.*"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", ""); 
		        
		        
		    }
		};
		
		//重庆大学
		public static final HashMap<String, String> CQDX = new HashMap<String, String>() {
		    {
		        put("chinese", "重庆大学");  
		        put("english", "CQDX");  
		        put("idcode", "3");  
		        put("seed", "http://news.cqu.edu.cn/news/"); 
		        put("regex", "http://news.cqu.edu.cn/news/article.*"); 
		        put("newsurl", "http://news.cqu.edu.cn/news/article.*/.*[0-9]{4,10}.*"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", ""); 
		        
		        
		    }
		};
		
		//厦门大学
		public static final HashMap<String, String> XMDX = new HashMap<String, String>() {
		    {
		        put("chinese", "厦门大学新闻网");  
		        put("english", "XMDX");  
		        put("idcode", "3");  
		        put("seed", "http://news.xmu.edu.cn/s/13/t/542/p/1/c/194/list.htm"); 
		        put("regex", "http://news.xmu.edu.cn/s/13/t/542.*"); 
		        put("newsurl", "http://news.xmu.edu.cn/s/13/t/542/.*/info[0-9]{4,10}.*"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", ""); 
		        
		        
		    }
		};
		
		//兰州大学
		public static final HashMap<String, String> LZDX = new HashMap<String, String>() {
		    {
		        put("chinese", "兰州大学新闻网");  
		        put("english", "LZDX");  
		        put("idcode", "3");  
		        put("seed", "http://news.lzu.edu.cn/l/yaowen/"); 
		        put("regex", "http://news.lzu.edu.cn/.*"); 
		        put("newsurl", "http://news.lzu.edu.cn/.*/[0-9]{4,10}.*"); 
		        put("ignoreurl", "http://news.lzu.edu.cn/.*(2004|2005).*"); 
		        put("wordlength", "400");
		        put("title", ""); 
		        
		        
		    }
		};
		
		//中山大学    注：标题没抓成功
		public static final HashMap<String, String> ZSDX = new HashMap<String, String>() {
		    {
		        put("chinese", "中山大学新闻网");  
		        put("english", "ZSDX");  
		        put("idcode", "3");  
		        put("seed", "http://news2.sysu.edu.cn/news01/index.htm"); 
		        put("regex", "http://news2.sysu.edu.cn/.*"); 
		        put("newsurl", "http://news2.sysu.edu.cn/.*/[0-9]{4,10}.*"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", "(?<=<h1 align=\"center\">)[\\s\\S]*(?=(</h1>))"); 
		        
		        
		    }
		};
		
		//华南理工大学
		public static final HashMap<String, String> HNLGDX = new HashMap<String, String>() {
		    {
		        put("chinese", "华南理工大学新闻网");  
		        put("english", "HNLGDX");  
		        put("idcode", "3");  
		        put("seed", "http://news.scut.edu.cn/s/22/t/4/p/69/c/7/list.htm"); 
		        put("regex", "http://news.scut.edu.cn/s/22.*"); 
		        put("newsurl", "http://news.scut.edu.cn/s/22.*[0-9]{4,10}.*"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", ""); 
		        
		        
		    }
		};
		
		//东北大学
		public static final HashMap<String, String> DBDX = new HashMap<String, String>() {
		    {
		        put("chinese", "东北大学新闻网");  
		        put("english", "DBDX");  
		        put("idcode", "3");  
		        put("seed", "http://neunews.neu.edu.cn/campus/part/DDYW.html"); 
		        put("regex", "http://neunews.neu.edu.cn/campus.*"); 
		        put("newsurl", "http://neunews.neu.edu.cn/campus.*[0-9]{4,10}.*"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", ""); 
		        
		        
		    }
		};
		
		//哈尔滨工业大学
		public static final HashMap<String, String> HEBGYDX = new HashMap<String, String>() {
		    {
		        put("chinese", "哈尔滨工业大学新闻网");  
		        put("english", "HEBGYDX");  
		        put("idcode", "3");  
		        put("seed", "http://news1.hit.edu.cn/xxyw/list.htm"); 
		        put("regex", "http://news1.hit.edu.cn/.*"); 
		        put("newsurl", "http://news1.hit.edu.cn/.*[0-9]{4,10}/page.*"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", ""); 
		        
		    }
		};
		
		//武汉大学
		public static final HashMap<String, String> WHDX = new HashMap<String, String>() {
		    {
		        put("chinese", "武汉大学新闻网");  
		        put("english", "WHDX");  
		        put("idcode", "3");  
		        put("seed", "http://news.whu.edu.cn/wdyw.htm"); 
		        put("regex", "http://news.whu.edu.cn/.*"); 
		        put("newsurl", "http://news.whu.edu.cn/info.*[0-9]{4,10}.*"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "600");
		        put("title", "(?<=(<div class=\"news_title\">))[\\s\\S]{1,50}(?=</div>[\\s\\S]*<div class=\"news_ftitle\">)"); 
		        
		    }
		};
		
		//华中科技大学
		public static final HashMap<String, String> HZKJDX = new HashMap<String, String>() {
		    {
		        put("chinese", "华中科技大学新闻网");  
		        put("english", "HZKJDX");  
		        put("idcode", "3");  
		        put("seed", "http://news.hustonline.net/"); 
		        put("regex", "http://news.hustonline.net/.*"); 
		        put("newsurl", "http://news.hustonline.net/article/.*[0-9]{4,10}.*"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", ""); 
		        
		    }
		};
		
		//湖南大学
		public static final HashMap<String, String> HNDX = new HashMap<String, String>() {
		    {
		        put("chinese", "湖南大学新闻网");  
		        put("english", "HNDX");  
		        put("idcode", "3");  
		        put("seed", "http://news.hnu.edu.cn/zhyw/"); 
		        put("regex", "http://news.hnu.edu.cn/(zhyw|mthd|xyjw|xydt|hdrw|xysd|ylwy).*"); 
		        put("newsurl", "http://news.hnu.edu.cn/(zhyw|mthd|xyjw|xydt|hdrw|xysd|ylwy).*[0-9]{4,10}.*"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", ""); 
		        
		    }
		};
		
		//中南大学
		public static final HashMap<String, String> ZNDX = new HashMap<String, String>() {
		    {
		        put("chinese", "中南大学新闻网");  
		        put("english", "ZNDX");  
		        put("idcode", "3");  
		        put("seed", "http://news.csu.edu.cn/mtzn.htm"); 
		        put("regex", "http://news.csu.edu.cn.*"); 
		        put("newsurl", "http://news.csu.edu.cn/info/.*[0-9]{5,10}.*"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", ""); 
		        
		    }
		};
		
		//国防科学技术大学
		public static final HashMap<String, String> GFKXJSDX = new HashMap<String, String>() {
		    {
		        put("chinese", "国防科技大学");  
		        put("english", "GFKXJSDX");  
		        put("idcode", "3");  
		        put("seed", "http://www.nudt.edu.cn/articlelist.asp?classid=58"); 
		        put("regex", "http://www.nudt.edu.cn/.*"); 
		        put("newsurl", "http://www.nudt.edu.cn/Articleshow.asp\\?id=.*[0-9]{1,10}.*"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", ""); 
		        
		    }
		};
		//吉林大学
		public static final HashMap<String, String> JLDX = new HashMap<String, String>() {
		    {
		        put("chinese", "吉林大学");  
		        put("english", "JLDX");  
		        put("idcode", "3");  
		        put("seed", "http://news.jlu.edu.cn/new/nindex.php"); 
		        put("regex", "http://news.jlu.edu.cn/new/\\?mod=article.*"); 
		        put("newsurl", "http://news.jlu.edu.cn/new/\\?mod=article&act=show&id=.*[0-9]{1,10}.*"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", "(?<=show_title\">)[\\s\\S]{1,100}(?=<div)"); 
		        
		    }
		};
		//东南大学
		public static final HashMap<String, String> DNDX = new HashMap<String, String>() {
		    {
		        put("chinese", "东南大学新闻网");  
		        put("english", "DNDX");  
		        put("idcode", "3");  
		        put("seed", "http://news.seu.edu.cn/5487/list.htm"); 
		        put("regex", "http://news.seu.edu.cn/.*"); 
		        put("newsurl", "http://news.seu.edu.cn/.*page.*"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", ""); 
		        
		    }
		};
		
		//大连理工大学
		public static final HashMap<String, String> DLLGDX = new HashMap<String, String>() {
		    {
		        put("chinese", "大连理工大学新闻网");  
		        put("english", "DLLGDX");  
		        put("idcode", "3");  
		        put("seed", "http://news.dlut.edu.cn/article/zonghe/1.shtml"); 
		        put("regex", "http://news.dlut.edu.cn/article/.*"); 
		        put("newsurl", "http://news.dlut.edu.cn/article/.*[0-9]{3,10}.*"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", ""); 
		        
		    }
		};
		
		//山东大学
		public static final HashMap<String, String> SDDX = new HashMap<String, String>() {
		    {
		        put("chinese", "山东大学新闻网");  
		        put("english", "SDDX");  
		        put("idcode", "3");  
		        put("seed", "http://www.view.sdu.edu.cn/new/sdnews/"); 
		        put("regex", "http://www.view.sdu.edu.cn/new/.*"); 
		        put("newsurl", "http://www.view.sdu.edu.cn/new/201[5-9]{1}/.*[0-9]{5,10}.*"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", ""); 
		        
		    }
		};
		
		//中国海洋大学
		public static final HashMap<String, String> ZGHYDX = new HashMap<String, String>() {
		    {
		        put("chinese", "中国海洋大学新闻网");  
		        put("english", "ZGHYDX");  
		        put("idcode", "3");  
		        put("seed", "http://xinwen.ouc.edu.cn/Article/Class3/xwlb/index.html"); 
		        put("regex", "http://xinwen.ouc.edu.cn/.*"); 
		        put("newsurl", "http://xinwen.ouc.edu.cn/[^P].*/201[5-9]{1}.*[0-9]{4,9}.*"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", ""); 
		        
		    }
		};
		
		//哈尔滨工业大学(威海)
		public static final HashMap<String, String> HEBGYDXWH = new HashMap<String, String>() {
		    {
		        put("chinese", "哈尔滨工业大学(威海)");  
		        put("english", "HEBGYDXWH");  
		        put("idcode", "3");  
		        put("seed", "http://news.hitwh.edu.cn/news_list.asp?id=1"); 
		        put("regex", "http://news.hitwh.edu.cn/news_.*"); 
		        put("newsurl", "http://news.hitwh.edu.cn/news_.*[0-9]{3,6}.*"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", "(?<=([^\"]itle.{1,3}>))[\\s\\S]{1,50}(?=</)"); 
		        
		    }
		};
		
		//西安交通大学
		public static final HashMap<String, String> XAJTDX = new HashMap<String, String>() {
		    {
		        put("chinese", "西安交通大学新闻网");  
		        put("english", "XAJTDX");  
		        put("idcode", "3");  
		        put("seed", "http://news.xjtu.edu.cn/zyxw.htm"); 
		        put("regex", "http://news.xjtu.edu.cn/.*"); 
		        put("newsurl", "http://news.xjtu.edu.cn/info/[0-9]{4}/[0-9]{4,5}.*"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", ""); 
		        
		    }
		};
		
		//西北工业大学
		public static final HashMap<String, String> XBGYDX = new HashMap<String, String>() {
		    {
		        put("chinese", "西北工业大学新闻网");  
		        put("english", "XBGYDX");  
		        put("idcode", "3");  
		        put("seed", "http://news.nwpu.edu.cn/news/gdyw.htm"); 
		        put("regex", "http://news.nwpu.edu.cn/.*"); 
		        put("newsurl", "http://news.nwpu.edu.cn/info/(1002|1003|1124|1009|1014)/[0-9]{4,5}.*"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", "(?<=([^\"]itle.{1,3}>))[\\s\\S]{1,50}(?=</)"); 
		        
		    }
		};
		
		//西北农林科技大学
		public static final HashMap<String, String> XBNLKJDX = new HashMap<String, String>() {
		    {
		        put("chinese", "西北农林科技大学新闻网");  
		        put("english", "XBNLKJDX");  
		        put("idcode", "3");  
		        put("seed", "http://news.nwsuaf.edu.cn/xnxw/index.htm"); 
		        put("regex", "http://news.nwsuaf.edu.cn/.*"); 
		        put("newsurl", "http://news.nwsuaf.edu.cn/.*/[0-9]{4,5}.*"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", ""); 
		        
		    }
		};
		
		//复旦大学
		public static final HashMap<String, String> FDDX = new HashMap<String, String>() {
		    {
		        put("chinese", "复旦大学新闻网");  
		        put("english", "FDDX");  
		        put("idcode", "3");  
		        put("seed", "http://news.fudan.edu.cn/news/xxyw/"); 
		        put("regex", "http://news.fudan.edu.cn/.*"); 
		        put("newsurl", "http://news.fudan.edu.cn/201[5-9]{1}/[0-9]{4,5}.*"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", ""); 
		        
		    }
		};
		//同济大学
		public static final HashMap<String, String> TJDX = new HashMap<String, String>() {
		    {
		        put("chinese", "同济大学新闻网");  
		        put("english", "TJDX");  
		        put("idcode", "3");  
		        put("seed", "http://news.tongji.edu.cn/classid-1.html"); 
		        put("regex", "http://news.tongji.edu.cn/classid-.*"); 
		        put("newsurl", "http://news.tongji.edu.cn/classid-.*news.*"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", ""); 
		        
		    }
		};
		
		//上海交通大学
		public static final HashMap<String, String> SHJTDX = new HashMap<String, String>() {
		    {
		        put("chinese", "上海交通大学新闻网");  
		        put("english", "SHJTDX");  
		        put("idcode", "3");  
		        put("seed", "http://news.sjtu.edu.cn/jdyw.htm"); 
		        put("regex", "http://news.sjtu.edu.cn/.*"); 
		        put("newsurl", "http://news.sjtu.edu.cn/info/[0-9]{4}/[0-9]{4,9}.*"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", ""); 
		        
		    }
		};
		
		//华东师范大学
		public static final HashMap<String, String> HDSFDX = new HashMap<String, String>() {
		    {
		        put("chinese", "华东师范大学新闻网");  
		        put("english", "HDSFDX");  
		        put("idcode", "3");  
		        put("seed", "http://news.ecnu.edu.cn/1833/list.htm"); 
		        put("regex", "http://news.ecnu.edu.cn/.*"); 
		        put("newsurl", "http://news.ecnu.edu.cn/.*[0-9]{4,9}/.*"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", ""); 
		        
		    }
		};
		
		//四川大学
		public static final HashMap<String, String> SCDX = new HashMap<String, String>() {
		    {
		        put("chinese", "四川大学新闻网");  
		        put("english", "SCDX");  
		        put("idcode", "3");  
		        put("seed", "http://news.scu.edu.cn/news2012/cdzx/I0201index_1.htm"); 
		        put("regex", "http://news.scu.edu.cn/news2012.*"); 
		        put("newsurl", "http://news.scu.edu.cn/news2012.*[0-9]{9,20}.*"); 
		        put("ignoreurl", "http://news.scu.edu.cn/news2012/(cjjj|jycd|ttwe).*"); 
		        put("wordlength", "400");
		        put("title", ""); 
		        
		    }
		};
		
		//电子科学技术大学
		public static final HashMap<String, String> DZKJDX = new HashMap<String, String>() {
		    {
		        put("chinese", "电子科技大学新闻网");  
		        put("english", "DZKJDX");  
		        put("idcode", "3");  
		        put("seed", "http://www.new1.uestc.edu.cn/?n=UestcNews.Front.Category.Page&CatId=42"); 
		        put("regex", "http://www.new1.uestc.edu.cn/\\?n=UestcNews.*"); 
		        put("newsurl", "http://www.new1.uestc.edu.cn/\\?n=UestcNews.Front.Document.*Page.*[0-9]{4,8}"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", "(?<=([^\"](itle|ITLE)[\\s\\S]{1,3}>[\\S\\s]{1,20}>))[\\s\\S]{1,50}(?=</)"); 
		        
		    }
		};
		//南开大学
		public static final HashMap<String, String> NKDX = new HashMap<String, String>() {
		    {
		        put("chinese", "南开大学新闻网");  
		        put("english", "NKDX");  
		        put("idcode", "3");  
		        put("seed", "http://news.nankai.edu.cn/"); 
		        put("regex", "http://news.nankai.edu.cn/.*"); 
		        put("newsurl", "http://news.nankai.edu.cn/.*/201[5-9]{1}/.*/[0-9]{5,10}.*"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "500");
		        put("title", ""); 
		        
		    }
		};
		
		//天津大学
		public static final HashMap<String, String> TIANJINDX = new HashMap<String, String>() {
		    {
		        put("chinese", "天津大学新闻网");  
		        put("english", "TIANJINDX");  
		        put("idcode", "3");  
		        put("seed", "http://news.tju.edu.cn/zx/qb/"); 
		        put("regex", "http://news.tju.edu.cn/.*"); 
		        put("newsurl", "http://news.tju.edu.cn/.*/201[5-9]{1}.*/.*[0-9]{5,10}.*"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", "(?<=([^\"]itle.{1,3}>))[\\s\\S]{1,50}(?=</)"); 
		        
		    }
		};
		
		//浙江大学
		public static final HashMap<String, String> ZJDX = new HashMap<String, String>() {
		    {
		        put("chinese", "浙江大学新闻网");  
		        put("english", "ZJDX");  
		        put("idcode", "3");  
		        put("seed", "http://www.news.zju.edu.cn/navnews-list.php?type=6"); 
		        put("regex", "http://www.news.zju.edu.cn/.*"); 
		        put("newsurl", "http://www.news.zju.edu.cn/news.php\\?id=[0-9]{4,7}.*"); 
		        put("ignoreurl", ""); 
		        put("wordlength", "400");
		        put("title", ""); 
		        
		    }
		};
}
