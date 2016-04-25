package catchnews.tools.general;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
import cn.edu.hfut.dmic.contentextractor.ContentExtractor;
import cn.edu.hfut.dmic.contentextractor.News;

public class ChangeFormat {
	
	//读取HTML文件
	public static String readTextFile(String sFileName, String sEncode)
	{
	    StringBuffer sbStr = new StringBuffer();

	    try
	    {
	        File ff = new File(sFileName);
	        InputStreamReader read = new InputStreamReader(new FileInputStream(ff),
	                sEncode);
	        
	        BufferedReader ins = new BufferedReader(read);

	        String dataLine = "";
	        while (null != (dataLine = ins.readLine()))
	        {
	            sbStr.append(dataLine);
	            
	        }

	        ins.close();
	    }
	    catch (Exception e)
	    {
	       e.printStackTrace();
	    }

	    return sbStr.toString();
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
	
	//更改样式
	public  static String changeFormat(String text){
				
		//1.所有style删去 class也删去 (class未测试)
		Matcher matcher = Pattern.compile("class=\"[^\"]{2,20}\"").matcher(text);
		while(matcher.find()){	
			text=text.replaceAll(matcher.group(),"");
		}
		matcher = Pattern.compile("style=\"[^v&^\"]{2,80}\"").matcher(text);
		while(matcher.find()){	
			text=text.replaceAll(matcher.group(),"");
		}
		//2.<p>   <p class="newsmain"> （成功）
		matcher = Pattern.compile("<p ?>").matcher(text);
		while(matcher.find()){	
			text=text.replaceAll(matcher.group(),"<p class=\"newsmain\">");
		}
		//3.<hr />   <hr class="newsline"> （成功）
		matcher = Pattern.compile("<hr style=\"height:3px;border:none;border-top:3px double red;\" />").matcher(text);
		while(matcher.find()){	
			text=text.replaceAll(matcher.group(),"<hr class=\"newsline\">");
		}
		//4.<font size=4>   <h1 class="newstitle"> （成功）
		matcher = Pattern.compile("<font size=4>").matcher(text);
		while(matcher.find()){	
			text=text.replaceAll(matcher.group(),"<h1 class=\"newstitle\">");
		}
		//5.</center></font>   </center></h1>  （成功 ）
		matcher = Pattern.compile("</center></font>").matcher(text);
		while(matcher.find()){	
			text=text.replaceAll(matcher.group(),"</center></h1>");
		}
		//6.<font size=1>   <p class="newstime">  （成功）
		matcher = Pattern.compile("<font size=1>").matcher(text);
		while(matcher.find()){	
			text=text.replaceAll(matcher.group(),"<p class=\"newstime\">");
		}
		//7.</font><br>   </p><br>  （成功）
		matcher = Pattern.compile("</font><br>").matcher(text);
		while(matcher.find()){	
			text=text.replaceAll(matcher.group(),"</p>");
		}
		//8.<link rel="stylesheet" href="newsstyle.css" type="text/css">  （成功）
		matcher = Pattern.compile("</head>").matcher(text);
		while(matcher.find()){	
			text=text.replaceAll(matcher.group(),"<link rel=\"stylesheet\" href=\"newsstyle.css\" type=\"text/css\"</head>");
		}
		//9.图片class="newsimg"  (成功)
		matcher = Pattern.compile("src=\"http.{2,100}\"").matcher(text);
		while(matcher.find()){	
			text=text.replaceAll(matcher.group(),"class=\"newsimg\" "+ matcher.group());
		}
		//10.作者 
		matcher = Pattern.compile("<p class=\"newsmain\">\\(?（?([\u4e00-\u9fa5]{2,5}\\s?\\：?){1,5}\\)?）?</p>").matcher(text);
		String editorChinese = null;
		while(matcher.find()){		
			Matcher matcher2 = Pattern.compile("[^a-zA-Z|<|>|/]{2,20}").matcher(matcher.group());	
			String editorReplaceBefore = matcher.group();//标签头+作者+标签尾
			//System.out.println(editorReplaceBefore);
			while (matcher2.find()) {
				editorChinese=matcher2.group();
			}
			//System.out.println(editorChinese);
			text=text.replaceAll(editorReplaceBefore,"<p class=\"newseditor\">"+editorChinese+"</p>");
			//System.out.println("替换后："+text);
		
		}
		
		
		//部分细节
		//原文链接 
		matcher = Pattern.compile("<p class=\"newsmain\">[\u4e00-\u9fa5]{2,10}：").matcher(text);
		String linkChinese = null;
		while(matcher.find()){
			String linkReplaceBefore = matcher.group();
			//System.out.println(linkReplaceBefore);
			Matcher matcher2 = Pattern.compile("[^a-zA-Z|<|>|/]{2,20}").matcher(matcher.group());
			while (matcher2.find()) {
				linkChinese=matcher2.group();
			}
			//System.out.println("链接中文"+linkChinese);
			text=text.replaceAll(linkReplaceBefore,"<p class=\"newsbackground\">"+linkChinese);
			
		}
		
		//首行空两格
		matcher = Pattern.compile("<p class=\"newsmain\">[\u4e00-\u9fa5]").matcher(text);
		String noSpaceChinese=null;
		while(matcher.find()){
			String noSpaceChineseBefore = matcher.group();
			//System.out.println(linkReplaceBefore);
			Matcher matcher2 = Pattern.compile("[\u4e00-\u9fa5]").matcher(matcher.group());
			while (matcher2.find()) {
				noSpaceChinese=matcher2.group();
			}
			text=text.replaceAll(noSpaceChineseBefore,"<p class=\"newsmain\">  "+noSpaceChinese);
		}
		
		
		
		
		
		
		
		
		
		
		
		String returnString = text;
		return returnString;
		
		
	}
	
	
}
