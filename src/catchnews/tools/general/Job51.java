package catchnews.tools.general;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
 
public class Job51 {
        private HttpClient client;  
        private PostMethod post;  
        private static String name = "iezhuxu@163.com";//�㶮��
        private static String password = "wamqy1";//^_^
        private static String pageUrl = "http://my.51job.com/my/My_Pmc.php";//��ַ
           
        private NameValuePair ie = new NameValuePair("User-Agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; SV1; .NET CLR 2.0.50727)");  
        private NameValuePair url = new NameValuePair("url","%2Fmy%2FMy_Pmc.php");  
        private NameValuePair x = new NameValuePair("x", "67");  
        private NameValuePair y = new NameValuePair("y", "18"); 
        private NameValuePair nameVP =  new NameValuePair("username", name);
        private NameValuePair pwdVP = new NameValuePair("userpwd", password);
        public Job51() {  
            client = new HttpClient();  
            client.getParams().setParameter("http.protocol.cookie-policy", CookiePolicy.BROWSER_COMPATIBILITY);
            client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"gb2312");
            post = new PostMethod(pageUrl);  
        }  
           
        public void execute() throws HttpException, IOException {  
            NameValuePair[] p = new NameValuePair[]{ie,url,x,y,nameVP,pwdVP};  
            post.setRequestBody(p);  
            client.executeMethod(post);  
            //�����½�ɹ����cookie
            Cookie[] cookies = client.getState().getCookies();  
            client.getState().addCookies(cookies);  
            post.releaseConnection(); 
             
            GetMethod get = new GetMethod(pageUrl);  
            client.executeMethod(get);  
            String homePage = new String(get.getResponseBodyAsString());
            
            System.out.println(homePage);
            String regex = null;
            Pattern pattern = null;
            Matcher matcher = null;
            regex = "http://my.51job.com/cv/CResume.*\\?[0-9]{5,10}";
            pattern = Pattern.compile(regex);
            matcher = pattern.matcher(homePage);
            String resumeNo="";
            if(matcher.find()){					
                resumeNo = matcher.group();	
                System.out.println("��ȡ������Ҫ�ı��url��"+resumeNo);
            }
            get.releaseConnection();
            String resumeListUrl = resumeNo;
            if(resumeListUrl != ""){
                System.out.print("������ַ�ǣ�"+resumeListUrl+" ��½�ɹ�");
                GetMethod get1 = new GetMethod(resumeListUrl);
                client.executeMethod(get1);
                String homePage1 = new String(get1.getResponseBodyAsString());
                System.out.println("���������ǣ�" +homePage1 );
            }else{
                System.out.print("��½ʧ��");
            }
        }  
        

           
        public static void main(String[] args) throws HttpException, IOException {  
            Job51 job = new Job51();  
            job.execute();  
        }  
        

        

}