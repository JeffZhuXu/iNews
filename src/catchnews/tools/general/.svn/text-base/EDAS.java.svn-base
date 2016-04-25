package catchnews.tools.general;

import java.awt.print.Paper;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import catchnews.tools.Catch;
import catchnews.tools.SaveHtml;
import catchnews.tools.StorageToSql;
 /*
  * 
  * @author zhuxu
  * 自动登录EDAS系统，抓取论文审批情况
  * @date 2015.8.25
  * 
  * */
public class EDAS {
        
		private HttpClient client;  
        private PostMethod post;  
        private GetMethod get;  
        private static String name = "wangye@hitsz.edu.cn";//你懂得
        private static String password = "09b958003";//^_^
        private static String opageUrl = "https://www.edas.info/index.php";//地址
        private static String pageUrl = "https://www.edas.info/index.php";//地址
           
        private NameValuePair a = new NameValuePair("_qf__login","");
        private NameValuePair nameVP =  new NameValuePair("username", name);
        private NameValuePair pwdVP = new NameValuePair("password", password);
        private NameValuePair b = new NameValuePair("logon", "Log on");
        public EDAS() {  
        	
            client = new HttpClient();  
            client.getParams().setParameter("http.protocol.cookie-policy", CookiePolicy.BROWSER_COMPATIBILITY);
            client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf8");
            get = new GetMethod(opageUrl);  
        }  
           
        public void execute() throws HttpException, IOException {  
        	
            NameValuePair[] p = new NameValuePair[]{a,nameVP,pwdVP,b};  
            post= new PostMethod(pageUrl);
            post.setRequestBody(p);  
            client.executeMethod(get);  
            //保存登陆成功后的cookie
            Cookie[] cookies = client.getState().getCookies();  
            client.getState().addCookies(cookies);  
            //post.releaseConnection(); 
             
            //GetMethod get = new GetMethod("https://www.edas.info/index.php");  
            client.executeMethod(post);  
            String homePage = new String(post.getResponseBodyAsString());
            
            System.out.println(homePage);
            System.out.println(Catch.getInformationFromContent(homePage, "(?<=Only papers for upcoming conferences are shown.</p>)[\\s\\S]*(?=<h2.*>My profile)"));
//            String regex = null;
//            Pattern pattern = null;
//            Matcher matcher = null;
//            regex = "http://my.51job.com/cv/CResume.*\\?[0-9]{5,10}";
//            pattern = Pattern.compile(regex);
//            matcher = pattern.matcher(homePage);
//            String resumeNo="";
//            if(matcher.find()){					
//                resumeNo = matcher.group();	
//                System.out.println("获取简历需要的编号url："+resumeNo);
//            }
//            get.releaseConnection();
//            String resumeListUrl = resumeNo;
//            if(resumeListUrl != ""){
//                System.out.print("简历地址是："+resumeListUrl+" 登陆成功");
//                GetMethod get1 = new GetMethod(resumeListUrl);
//                client.executeMethod(get1);
//                String homePage1 = new String(get1.getResponseBodyAsString());
//                System.out.println("简历内容是：" +homePage1 );
//            }else{
//                System.out.print("登陆失败");
//            }
        }  
        
        public static void getPaperMessage(String username,String password) throws HttpException, IOException{

        	HttpClient client;  
            PostMethod post;  
            GetMethod get;  
            String name = username;//你懂得"wangye@hitsz.edu.cn"
            String pass = password;//^_^"09b958003"
            opageUrl = "https://www.edas.info/index.php";//地址
            String pageUrl = "https://www.edas.info/index.php";//地址
               
            NameValuePair a = new NameValuePair("_qf__login","");
            NameValuePair nameVP =  new NameValuePair("username", name);
            NameValuePair pwdVP = new NameValuePair("password", password);
            NameValuePair b = new NameValuePair("logon", "Log on");
            client = new HttpClient();  
            client.getParams().setParameter("http.protocol.cookie-policy", CookiePolicy.BROWSER_COMPATIBILITY);
            client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf8");
            get = new GetMethod(opageUrl);  
            NameValuePair[] p = new NameValuePair[]{a,nameVP,pwdVP,b};  
            post= new PostMethod(pageUrl);
            post.setRequestBody(p);  
            client.executeMethod(get);  
            //保存登陆成功后的cookie
            Cookie[] cookies = client.getState().getCookies();  
            client.getState().addCookies(cookies);  
            //post.releaseConnection(); 
             
            //GetMethod get = new GetMethod("https://www.edas.info/index.php");  
            client.executeMethod(post);  
            String homePage = new String(post.getResponseBodyAsString());
            
            //System.out.println(homePage);
            
            //论文信息
            String papaerMessage=Catch.getInformationFromContent(homePage, "(?<=Only papers for upcoming conferences are shown.</p>)[\\s\\S]*(?=<h2.*>My profile)").get(0);
            papaerMessage=getUsefulInformationFromContent(papaerMessage);
            System.out.println(papaerMessage);
            
            //保存
            String filename= ""+System.currentTimeMillis();
            saveToHtmlFile(papaerMessage, filename);
            StorageToSql.addPaperMessage("1", "EDAS", "EDAS论文审核信息",  filename);
        }

        public static void main(String[] args) throws HttpException, IOException {  
        	getPaperMessage("wangye@hitsz.edu.cn", "09b958003");
        }  
        
        
        //保存为html文件
    	public static void saveToHtmlFile(String text,String filename){
    		
    		String processedStr = text;

    		try{

    		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\inews\\results\\" + filename + ".html"), "UTF-8"));
    		//GBK为将字符串保存为制定的汉字编码格式，统一改为UTF-8																									
    		 out.write(processedStr);
    		 out.close();
    		}catch(IOException e)
    		{
    			e.printStackTrace();
    		}
    	}
    	//处理抓到的论文信息，处理过后返回
    	public static String getUsefulInformationFromContent(String content){

    		
    		//去掉图片，只保留结果
    		int num =0;
    		List<String> result = new ArrayList<String>();
    		Matcher matcher = Pattern.compile("<img.*/>").matcher(content);

    		while(matcher.find()){	
    			result.add(matcher.group());
    			content=content.replaceAll(matcher.group(), "");    	
    			num=num+1;
    		}  
    		//添加消息投，返回

    		return "<html><head><META http-equiv=Content-Type content=\"text/html; charset=utf-8\"></head><br>"+content;
    		
    	
    	}

}