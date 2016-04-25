package catchnews.tools;
/*
 * 2015.8.7
 * 朱旭
 * 向网页html正文中添加指定的字符串
 * */
public class Add {
	
	//向抓到的正文中添加title和字符编码格式,来源和时间
	public static String addTitleAndCharset(String title,String text,String source,String time){
		
		String charset = "<html>\n" +
		"<head>\n" +
		"<META http-equiv=Content-Type content=\"text/html; charset=utf-8\">"+
		"<title>" + title + "</title>\n" + "</head>\n"
		+"<font size=5><center><B>"+title+"</B></center></font><br>\n"
		+"<font size=2><center>"+source+"  "+time+"</center></font><br>\n";
		return charset +  text;
		
	}
	

}
