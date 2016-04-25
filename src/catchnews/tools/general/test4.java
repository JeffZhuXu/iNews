package catchnews.tools.general;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class test4 {

	public static void main(String[] args) {
		
		//读取HTML
		String filePath="E:\\tsinghuanews\\1.html";
		String sEncode ="utf-8";
		String text=ChangeFormat.readTextFile(filePath, sEncode);
		
		//修改格式
		String textChangeFormat=ChangeFormat.changeFormat(text);
		
		//保存
		String fileSaveName="test2cf";
		ChangeFormat.saveToHtmlFile(textChangeFormat, fileSaveName);
		
		
		
		
		//测试替换
//		String filePath="C:\\Users\\Administrator\\Desktop\\inewsTest\\test1.html";
//		String sEncode ="utf-8";
//		String text=ChangeFormat.readTextFile(filePath, sEncode);
//		Matcher matcher = Pattern.compile("style=\"[^v&^\"]{2,80}\"").matcher(text);
//			
//		int count =0;
//		while(matcher.find()){
//			count++;
//			System.out.println(matcher.group());
//		}
//		System.out.println(count);
		
		
		//两次替换测试 (有问题!!)
//		String text="<p class=\"newsmain\">菠萝菠萝蜜菠萝菠萝蜜带我去带我去<p class=\"newsmain\">背景链接：<a>http://www.baidu.com</a></p><p class=\"newsmain\">菠萝菠萝蜜菠萝菠萝蜜带我去带我去";
//		Matcher matcher = Pattern.compile("<p class=\"newsmain\">[\u4e00-\u9fa5]{2,7}：?<").matcher(text);
//		int groupCount =0;
//		while(matcher.find()){	
//			Matcher matcher2 = Pattern.compile("<p class=\"newsmain\">").matcher(matcher.group(groupCount));
//			while(matcher2.find()){
//				text=text.replaceAll(matcher2.group(),"<p class=\"newssource\">");
//				
//			}
//			groupCount++;
//		}
//
//		System.out.println(text);
	
		//图片样式测试
//		//String text="<img  style=\"max-width:100%\"  border=\"0\" hspace=\"0\" src=\"http://news.xjtu.edu.cn/_mediafile/news/2015/10/16/2h4jqpl9e4.jpg\" width=\"320\" align=\"middle\" />";
//		String filePath="C:\\Users\\Administrator\\Desktop\\inewsTest\\test1.html";
//		String sEncode ="utf-8";
//		String text=ChangeFormat.readTextFile(filePath, sEncode);
//		Matcher matcher = Pattern.compile("src=\"http.{2,100}\"").matcher(text);
//		while(matcher.find()){	
//			//System.out.println(matcher.group());
//			text=text.replaceAll(matcher.group(),"class=\"newsimg\" "+ matcher.group());
//		}
//		System.out.println(text);
		
		
		//作者测试
//		String text="<p class=\"newsmain\">菠萝菠萝蜜菠萝菠萝蜜带我去带我去<p class=\"newsmain\">（编辑：邓锐）</p>";
//		Matcher matcher = Pattern.compile("<p class=\"newsmain\">\\(?（?([\u4e00-\u9fa5]{2,5}\\s?\\：?){1,5}\\)?）?</p>").matcher(text);
//		String shortChinese = null;
//		while(matcher.find()){	
//			//Matcher matcher2 = Pattern.compile("([\u4e00-\u9fa5]\\s?\\:?){1,14}").matcher(matcher.group());	
//			Matcher matcher2 = Pattern.compile("[^a-zA-Z|<|>|/]{2,20}").matcher(matcher.group());	
//			String replaceBefore = matcher.group();//标签头+作者+标签尾
//			//System.out.println(replaceBefore);
//			while (matcher2.find()) {
//				shortChinese=matcher2.group();
//			}
//			//System.out.println(shortChinese);
//			text=text.replaceAll(replaceBefore,"<p class=\"newseditor\">"+shortChinese+"</p>");
//			System.out.println("替换后："+text);
//			
//			
//		}
		
		//链接测试
//		//String text= "<p class=\"newsmain\">附原文链接：<a href=\"http://paper.ce.cn/jjrb/html/2015-10/16/content_279259.htm\">http://paper.ce.cn/jjrb/html/2015-10/16/content_279259.htm</a></p>";
//		String filePath="C:\\Users\\Administrator\\Desktop\\inewsTest\\test1.html";
//		String sEncode ="utf-8";
//		String text=ChangeFormat.readTextFile(filePath, sEncode);
//		text=ChangeFormat.changeFormat(text);
//		//System.out.println(text);
//		
//		Matcher matcher = Pattern.compile("<p class=\"newsmain\">[\u4e00-\u9fa5]{2,10}：").matcher(text);
//		String linkChinese = null;
//		while(matcher.find()){
//			String linkReplaceBefore = matcher.group();
//			//System.out.println(linkReplaceBefore);
//			Matcher matcher2 = Pattern.compile("[^a-zA-Z|<|>|/]{2,20}").matcher(matcher.group());
//			while (matcher2.find()) {
//				linkChinese=matcher2.group();
//			}
//			//System.out.println("链接中文"+linkChinese);
//			text=text.replaceAll(linkReplaceBefore,"<p class=\"newssource\">"+linkChinese);
//			
//		}
//		System.out.println(text);
		
		
		
		//测试首行空两格
//		String text="<p class=\"newsmain\">测试第一行是否能够删去空格。<p class=\"newsmain\">  测试第一行是否能够删去空格";
////		String filePath="C:\\Users\\Administrator\\Desktop\\inewsTest\\test2.html";
////		String sEncode ="utf-8";
////		String text=ChangeFormat.readTextFile(filePath, sEncode);
//		text=ChangeFormat.changeFormat(text);
//		Matcher matcher = Pattern.compile("<p class=\"newsmain\">[\u4e00-\u9fa5]").matcher(text);
//		String noSpaceChinese=null;
//		while(matcher.find()){
//			String noSpaceChineseBefore = matcher.group();
//			//System.out.println(linkReplaceBefore);
//			Matcher matcher2 = Pattern.compile("[\u4e00-\u9fa5]").matcher(matcher.group());
//			while (matcher2.find()) {
//				noSpaceChinese=matcher2.group();
//			}
//			//System.out.println("链接中文"+linkChinese);
//			text=text.replaceAll(noSpaceChineseBefore,"<p class=\"newsmain\">  "+noSpaceChinese);
//		}
//		System.out.println(text);
		
		
		
		
		
	}
}
