package catchnews.tools.general;

import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.io.OutputStream;  
import java.net.HttpURLConnection;  
import java.net.URL;  



import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;


  
/* 
 * 模拟登录系统的简单示例 
 * */  
  
public class VirtualLog {  
   
	private static PostMethod doPostMethode51(String username,String password,String url){
		HttpClient client = new HttpClient();
		String loginUrl=url;
		client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "gbk");
		PostMethod pMethod=new PostMethod(loginUrl);
		NameValuePair[] postData={
				new NameValuePair("username",username),
				new NameValuePair("userpwd",password)
		};
		pMethod.setRequestBody(postData);
		try{
			client.executeMethod(pMethod);
			Cookie[] cookies = client.getState().getCookies();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		pMethod.releaseConnection();
		

		return pMethod;
	}
	
	public static void main(String[] args) throws IOException {

		String loginUrl="http://my.51job.com/my/My_SignIn.php";
		PostMethod pm =doPostMethode51("iezhuxu@163.com","wamqy1",loginUrl);
		System.out.println(pm.getResponseBodyAsString());
		Header header =pm.getRequestHeader("location");
		String uri=header.getValue();
		if(loginUrl.equals(uri)){
			//state=ture;
		}
	}
} 