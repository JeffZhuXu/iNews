package catchnews.tools.general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

public class Hitsz {

    private HttpClient client;  
    private GetMethod get;  
    private static String name = "14S158026";//你懂得
    private static String password = "d1f3c05c062ce97fd2fd16798e7df67e";//^_^
    private static String pageUrl = "http://219.223.252.205:9999/j_acegi_login.do?j_captcha_response=&j_username=14S158026&j_password=d1f3c05c062ce97fd2fd16798e7df67e&x=30&y=7";//地址
    private static String main = "http://219.223.252.205:9999/admin/top.jsp";//地址
       
    private NameValuePair ie = new NameValuePair("User-Agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; SV1; .NET CLR 2.0.50727)");  
    private NameValuePair url = new NameValuePair("url","%2Fmy%2FMy_Pmc.php");  
    private NameValuePair x = new NameValuePair("x", "30");  
    private NameValuePair y = new NameValuePair("y", "7"); 
    private NameValuePair nameVP =  new NameValuePair("j_username", name);
    private NameValuePair pwdVP = new NameValuePair("j_password", password);
    public Hitsz() {  
        client = new HttpClient();  
        client.getParams().setParameter("http.protocol.cookie-policy", CookiePolicy.BROWSER_COMPATIBILITY);
        client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"gb2312");
        get = new GetMethod(pageUrl);  
    }  
       
    public void execute() throws HttpException, IOException {  
//        NameValuePair[] p = new NameValuePair[]{ie,url,x,y,nameVP,pwdVP};  
//        post.setRequestBody(p);  
        client.executeMethod(get);  
        //保存登陆成功后的cookie
        Cookie[] cookies = client.getState().getCookies();  
        client.getState().addCookies(cookies);  
        get.releaseConnection(); 
         
        GetMethod get = new GetMethod(main);  
        client.executeMethod(get);  
        //String homePage = new String(get.getResponseBodyAsString());
        BufferedReader reader = new BufferedReader(new InputStreamReader(get.getResponseBodyAsStream()));
        StringBuffer stringBuffer = new StringBuffer();
        String str = "";
        while((str = reader.readLine())!=null){
        	stringBuffer.append(str);
        }
        String ts = stringBuffer.toString();
        System.out.println(ts);
//        String regex = null;
//        Pattern pattern = null;
//        Matcher matcher = null;
//        regex = "http://my.51job.com/cv/CResume.*\\?[0-9]{5,10}";
//        pattern = Pattern.compile(regex);
//        matcher = pattern.matcher(homePage);
//        String resumeNo="";
//        if(matcher.find()){					
//            resumeNo = matcher.group();	
//            System.out.println("获取简历需要的编号url："+resumeNo);
//        }
//        get.releaseConnection();
//        String resumeListUrl = resumeNo;
//        if(resumeListUrl != ""){
//            System.out.print("简历地址是："+resumeListUrl+" 登陆成功");
//            GetMethod get1 = new GetMethod(resumeListUrl);
//            client.executeMethod(get1);
//            String homePage1 = new String(get1.getResponseBodyAsString());
//            System.out.println("简历内容是：" +homePage1 );
//        }else{
//            System.out.print("登陆失败");
//        }
    }  
       
    public static void main(String[] args) throws HttpException, IOException {  
    	Hitsz hitsz = new Hitsz();  
    	hitsz.execute();  
    }  
    

}
