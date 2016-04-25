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
	
	//��ȡHTML�ļ�
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

	
	//���ļ�����ΪHTML�ļ���Ŀ¼Ϊd��/inews/htlmfile/****,�����ʽͳһΪUTF8
	public static void saveToHtmlFile(String text,String filename){
		
		String processedStr = text;

		try{

		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\inews\\htmlfile\\" + filename + ".html"), "UTF-8"));
		//GBKΪ���ַ�������Ϊ�ƶ��ĺ��ֱ����ʽ��ͳһ��ΪUTF-8																									
		 out.write(processedStr);
		 out.close();
		
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	//������ʽ
	public  static String changeFormat(String text){
				
		//1.����styleɾȥ classҲɾȥ (classδ����)
		Matcher matcher = Pattern.compile("class=\"[^\"]{2,20}\"").matcher(text);
		while(matcher.find()){	
			text=text.replaceAll(matcher.group(),"");
		}
		matcher = Pattern.compile("style=\"[^v&^\"]{2,80}\"").matcher(text);
		while(matcher.find()){	
			text=text.replaceAll(matcher.group(),"");
		}
		//2.<p>   <p class="newsmain"> ���ɹ���
		matcher = Pattern.compile("<p ?>").matcher(text);
		while(matcher.find()){	
			text=text.replaceAll(matcher.group(),"<p class=\"newsmain\">");
		}
		//3.<hr />   <hr class="newsline"> ���ɹ���
		matcher = Pattern.compile("<hr style=\"height:3px;border:none;border-top:3px double red;\" />").matcher(text);
		while(matcher.find()){	
			text=text.replaceAll(matcher.group(),"<hr class=\"newsline\">");
		}
		//4.<font size=4>   <h1 class="newstitle"> ���ɹ���
		matcher = Pattern.compile("<font size=4>").matcher(text);
		while(matcher.find()){	
			text=text.replaceAll(matcher.group(),"<h1 class=\"newstitle\">");
		}
		//5.</center></font>   </center></h1>  ���ɹ� ��
		matcher = Pattern.compile("</center></font>").matcher(text);
		while(matcher.find()){	
			text=text.replaceAll(matcher.group(),"</center></h1>");
		}
		//6.<font size=1>   <p class="newstime">  ���ɹ���
		matcher = Pattern.compile("<font size=1>").matcher(text);
		while(matcher.find()){	
			text=text.replaceAll(matcher.group(),"<p class=\"newstime\">");
		}
		//7.</font><br>   </p><br>  ���ɹ���
		matcher = Pattern.compile("</font><br>").matcher(text);
		while(matcher.find()){	
			text=text.replaceAll(matcher.group(),"</p>");
		}
		//8.<link rel="stylesheet" href="newsstyle.css" type="text/css">  ���ɹ���
		matcher = Pattern.compile("</head>").matcher(text);
		while(matcher.find()){	
			text=text.replaceAll(matcher.group(),"<link rel=\"stylesheet\" href=\"newsstyle.css\" type=\"text/css\"</head>");
		}
		//9.ͼƬclass="newsimg"  (�ɹ�)
		matcher = Pattern.compile("src=\"http.{2,100}\"").matcher(text);
		while(matcher.find()){	
			text=text.replaceAll(matcher.group(),"class=\"newsimg\" "+ matcher.group());
		}
		//10.���� 
		matcher = Pattern.compile("<p class=\"newsmain\">\\(?��?([\u4e00-\u9fa5]{2,5}\\s?\\��?){1,5}\\)?��?</p>").matcher(text);
		String editorChinese = null;
		while(matcher.find()){		
			Matcher matcher2 = Pattern.compile("[^a-zA-Z|<|>|/]{2,20}").matcher(matcher.group());	
			String editorReplaceBefore = matcher.group();//��ǩͷ+����+��ǩβ
			//System.out.println(editorReplaceBefore);
			while (matcher2.find()) {
				editorChinese=matcher2.group();
			}
			//System.out.println(editorChinese);
			text=text.replaceAll(editorReplaceBefore,"<p class=\"newseditor\">"+editorChinese+"</p>");
			//System.out.println("�滻��"+text);
		
		}
		
		
		//����ϸ��
		//ԭ������ 
		matcher = Pattern.compile("<p class=\"newsmain\">[\u4e00-\u9fa5]{2,10}��").matcher(text);
		String linkChinese = null;
		while(matcher.find()){
			String linkReplaceBefore = matcher.group();
			//System.out.println(linkReplaceBefore);
			Matcher matcher2 = Pattern.compile("[^a-zA-Z|<|>|/]{2,20}").matcher(matcher.group());
			while (matcher2.find()) {
				linkChinese=matcher2.group();
			}
			//System.out.println("��������"+linkChinese);
			text=text.replaceAll(linkReplaceBefore,"<p class=\"newsbackground\">"+linkChinese);
			
		}
		
		//���п�����
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
