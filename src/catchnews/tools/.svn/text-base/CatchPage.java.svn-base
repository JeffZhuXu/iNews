package catchnews.tools;




import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.net.MalformedURLException; 
import java.net.URL; 

public class CatchPage {
											//htmlurl为网址，charset为抓取网页的汉字编码格式，GB2312，GBK或者是UTF-8
	 public static String GetPage(String htmlurl,String charset) { 
	        URL url; 
	        String temp; 
	        StringBuffer sb = new StringBuffer(); 
	        try { 
	            url = new URL(htmlurl); 
	            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), charset)); 
	            while ((temp = in.readLine()) != null) { 
	                sb.append(temp); 
	            } 
	            in.close(); 
	        } catch (final MalformedURLException me) { 
	            System.out.println("输入的URL格式错误!"); 
	            me.getMessage(); 
	        } catch (final IOException e) { 
	            //e.printStackTrace();   //如果不注释掉，那么一旦抓取的网页为空，那么就会一直抛异常，注释掉的话就不抛异常了
	        	//System.out.println("该网址为空网址");
	        } 
	        return sb.toString(); //返回的汉字编码格式实际上是GBK/GB2312，在存入html文件的时候需要进行转码，转成UTF-8再存进去的啦
	    }
}
