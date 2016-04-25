package catchnews.tools;




import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.net.MalformedURLException; 
import java.net.URL; 

public class CatchPage {
											//htmlurlΪ��ַ��charsetΪץȡ��ҳ�ĺ��ֱ����ʽ��GB2312��GBK������UTF-8
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
	            System.out.println("�����URL��ʽ����!"); 
	            me.getMessage(); 
	        } catch (final IOException e) { 
	            //e.printStackTrace();   //�����ע�͵�����ôһ��ץȡ����ҳΪ�գ���ô�ͻ�һֱ���쳣��ע�͵��Ļ��Ͳ����쳣��
	        	//System.out.println("����ַΪ����ַ");
	        } 
	        return sb.toString(); //���صĺ��ֱ����ʽʵ������GBK/GB2312���ڴ���html�ļ���ʱ����Ҫ����ת�룬ת��UTF-8�ٴ��ȥ����
	    }
}
