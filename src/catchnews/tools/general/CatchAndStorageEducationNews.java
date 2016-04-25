package catchnews.tools.general;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import catchnews.tools.Select;
import catchnews.tools.StorageToSql;
import catchnews.tools.code.WebsiteName;
import cn.edu.hfut.dmic.contentextractor.ContentExtractor;
import cn.edu.hfut.dmic.contentextractor.News;

public class CatchAndStorageEducationNews {

	/**根据网页，的网址以及网站的名称以及新闻类型识别码将网页的内容保存为所需要的HTLM文件，给手机端来使用啦，给门户网站的教育网使用
	 * 网页地址
	 * 网站名称
	 * 新闻类型码
	 * @param url,websitename
	 * @author 朱旭
	 * @throws Exception 
	 */
	
	public  static void finalWork(String url,Map<String,String> website) throws Exception{
		

		//文件名称保存为 http**********这种格式，只保留数字和字母
		String fileName = website.get("english")+"/"+selectNumberAndWord(url);
		File newsFile = new File("d:/inews/htmlfile/"+fileName+".html");	
		//当文件不存在的时候，再执行下面的操作，如果已经抓过，那就不再抓取了
		if(!newsFile.exists())	{
		
		//网站的延时设置为40秒
		Document doc = Jsoup.connect(url).timeout(20000).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").get();
		
		//System.out.println("网页正文："+doc);
		
		//相对路径存为u绝对路径
		Elements href1=doc.select("[src]");
		for(Element e:href1){
			String absURL=e.absUrl("src");
			//System.out.println(absURL);
			e.attr("src", absURL);
		}
		
		
		News news = ContentExtractor.getNewsByDoc(doc);
		
		String title="";
		
		//当没有为这个网站单独设定title正则表达式的时候，说明用通用的标题抓取办法可以精确的抓到标题
		if(website.get("title").length()==0){
			
		 title = getBestTitleAsString(doc).trim();
		}else{
			//如果为这个网站单独设定了title的正则表达式，说明这个学校标题不适用通用的方法，要自己写，返回抓到的第一个标题
			title=getInformationFromContent(doc.toString(), website.get("title")).get(0).trim();
		}
		String time = news.getTime();
		//没抓到时间，用系统当前的时间来,长度小于8或者不是以20开头的
		if((time.length()<8)||!(time.substring(0, 2).equals("20"))){
			time=getNowTimeAsString();
		}
		
		//将时间转换成2015081045226的格式，用于存数据库用的,选前8位
		String storagetime = Select.selectDate(time).substring(0, 8);
		
		//如果抓到title，通过长度来判定，认为长度大于2的title表示正确的title,以及正文内容长度设定好的最低长度
		if((title.length()>2)&&(news.toString().length())>Integer.parseInt(website.get("wordlength"))&&(!title.equals("没匹配内容"))){
		

			
		
		
		//第一个replace语句调整图片显示格式，使得图片适应手机屏幕，第二个replace是清除正文部分的title，然后自己添加title
		String content =news.getContentElement().toString().replaceAll("<img", "<img  style=\"max-width:100%\" " ).replaceAll(title, "");
		
		//去掉正文中的不需要的<div   ****>
		Matcher matcher1 = Pattern.compile("<div.*>").matcher(content);
		while(matcher1.find()){	
			content=content.replaceAll(matcher1.group(),"");
		}
		
		
		//获取新闻图片链接，没有的话就是0
		List<String> img = getImgsFromPage(content);
		//System.out.println("图片链接：" + img);
		//设置图片居中，同时前后打上换行符，防止图片前后出现数字
		content = adjastImgsForm(content);
		
		
		//补全网页掐面缺失的信息，包括title，来源和时间
		content =
			//隐藏信息,包括标题、来源和更新时间
		"<div><a href=\"#\"><span style=\"visibility:hidden\">"+title+","+website.get("chinese")+","+storagetime+","+"</span></a></div>"+	
		"<html>\n" +
		"<head>\n" +
		"<META http-equiv=Content-Type content=\"text/html; charset=utf-8\">"+
		"<title>" + title + "</title>\n" + "</head>\n"
		+"<font size=4><center><B>"+title+"</B></center></font><br>"
		+ "<font size=1>"+website.get("chinese") + "  " +time+"</font><br>\n" +
		"<hr style=\"height:3px;border:none;border-top:3px double red;\" /><br>" //添加标题和正文的分割线
		+ content;
		
		//这条门户账网站的教育类新闻相关的学校名称
		String relativeSchools=getRelativeSchools(content).toString();

		
			//保存文件文件名命名为网址中的英文字母和数字的组合
		saveToHtmlFile(content, fileName);
		System.out.println("url: " + url +" save html successful");
		//保存数据库
		StorageToSql.addToSqlWithRelativeSchools(website.get("chinese"), website.get("idcode"), "0", "0", website.get("chinese"), title, storagetime, img.get(0), fileName,relativeSchools);
		
		}
		}
		
	}
	//抓取字符串当中的字母和数字
	public static String selectNumberAndWord(String txt){
		

		String number ="";
		Matcher matcher = Pattern.compile("[a-zA-Z\\d]+").matcher(txt);
		while(matcher.find()){


			number = number +  matcher.group().toString();

		}
		return number;
	}
	//获取当前时间2015-08-07 14:25:32
	public static String getNowTimeAsString(){
		Date d = new Date();
		
		SimpleDateFormat format = 
			new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String a = format.format(d).toString();
		
		return a;
	}
	//获取当前日期，格式为20150724
	public static String getNowDateAsString(){
			Date d = new Date();
			
			SimpleDateFormat format = 
				new SimpleDateFormat("yyyy-MM-dd");
			String a = format.format(d).toString();
			

			return a;
	}
	//抓取新闻的图片链接,例如http://www.szu.edu.cn/2013/img/20150720113555117.jpg
	public static List<String> getImgsFromPage(String content){

		
		//用于存放找到的结果
		int num =0;
		List<String> result = new ArrayList<String>();
		Matcher matcher = Pattern.compile("(?<=src=\").*?(?=\")").matcher(content);

		while(matcher.find()){	
			result.add(matcher.group());
			num=num+1;
		}  
		//没找到信息的话,填一个0
		if(num==0){
			result.add("0");
		}
		
		return result;
	}
	
	//将新闻正文的图片设置为居中，同时在图片前面和后面打上换行符，防止前后出现汉字；<br><div align="center"><img **/></div><br>
	public static String adjastImgsForm(String content){

		
		String text = content;
		

		
		
		Matcher matcher = Pattern.compile("(<img|<IMG).*?>").matcher(text);

		while(matcher.find()){	
			//设置图片居中，同时在图片前后打上换行符,将设定固定高度的图片属性替换掉
			String img =matcher.group();
			img=img.replaceAll("height", "");
			text=text.replaceAll(matcher.group(),"<br><div align=\"center\"><br>" +img+"</div><br>"  );
		}  
		return text;
	}
	
	//将文件保存为HTML文件，目录为d：/inews/htlmfile/****,编码格式统一为UTF8
	public static void saveToHtmlFile(String text,String filename){
		
		String processedStr = text;

		try{

		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\inews\\htmlfile\\" + filename + ".html"), "UTF-8"));
		//GBK为将字符串保存为制定的汉字编码格式，统一改为UTF-8																									
		 out.write(processedStr);
		 out.close();
		
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	//抓取新闻标题,通过比对三种方法抓到的title，从中选最优的
	public static String getBestTitleAsString(Document doc) throws Exception{
		
		
		
		List<String> title= new ArrayList<String>();
		title.add(doc.title()); //doc文件中内置的title
		title.add(ContentExtractor.getNewsByDoc(doc).getTitle()); //通过webcolector的新闻标题抓取程序抓到的标题
		Matcher matcher = Pattern.compile("(?<=([^\"]itle.{1,3}>))[\\s\\S]{1,50}(?=</)").matcher(doc.html().toString());
		
		int sum=0;
		//通过自己写的函数来抓取标题
		while(matcher.find()){	
			//将匹配到的正文出去前面和后面的空格和换行符
			title.add(matcher.group().trim());
			sum=sum+1;
		}  
		//自己的方法没有找到title
		if(sum==0){
			
			//当这两个方法都没抓到的时候
			if((title.get(0).length()==0)&&(title.get(1).length()==0)){
			return "标题获取失败";	
			//当抓到的两种方法中，最小的标题长度如果超过5，那么认为少的抓到的标题是正确的，选用小的长度作为正确的表诶
			}else if(((title.get(1).length()<title.get(0).length()))&&(title.get(1).length()>5)){
				return title.get(1);
			}else{
				//如果抓到的长度小的标题长度小于5 ，认为抓到的端的新闻标题是错误的，选长的标题作为正确的标题
				return title.get(0);
			}
		}else   //自己的方法也抓到的时候，那么抓到的有可能正确，如果另外两种方法找到的不对，那么用自己的title
		{      
			//之前的两个方法抓到，取最佳的那一个，长度大于5的最小的那一个
			if(((title.get(1).length()<title.get(0).length()))&&(title.get(1).length()>5)){
			return title.get(1);
			
			//优先级最高的是News方法,如果没抓到在上传自己的方法
			
			}else if( (title.get(1).length()<5)&&(title.get(2).length()<=title.get(0).length())){
				return title.get(2);
			}else{
				return title.get(0);
			}
		}
		}
	
	//抓取指定文本中的，匹配正则表达式的内容部分
	public static List<String> getInformationFromContent(String content,String limit){

		
		//用于存放找到的结果
		int num =0;
		List<String> result = new ArrayList<String>();
		Matcher matcher = Pattern.compile(limit).matcher(content);

		while(matcher.find()){	
			result.add(matcher.group());
			num=num+1;
		}  
		//没找到信息的话
		if(num==0){
			result.add("没匹配内容");
		}
		
		return result;
		
	
	}
	
	//找出这条新闻中，相关的学校名称，返回的结果就是相关学校名称的一个list
	public static List<String> getRelativeSchools(String content){

		
		//用于存放找到的结果
		int num =0;
		List<String> result = new ArrayList<String>();
		
		//学校的名称集合
		List<String> schools=WebsiteName.schoolNames;
		
		for(int i=0;i<schools.size();i++){
			
			Matcher matcher = Pattern.compile(schools.get(i)).matcher(content);

			while(matcher.find()){	
				result.add(schools.get(i));
				num=num+1;
				break;
			}  
			
		}

		//没找到信息的话
		if(num==0){
			result.add("0");
		}
		
		return result;
		
	
	}

}
