package catchnews.tools.general;


import org.apache.commons.httpclient.Cookie;  
import org.apache.commons.httpclient.HttpClient;  
import org.apache.commons.httpclient.cookie.CookiePolicy;  
import org.apache.commons.httpclient.NameValuePair;  
import org.apache.commons.httpclient.methods.GetMethod;  
import org.apache.commons.httpclient.methods.PostMethod;  
  
/**  
 * @author 作者 ：chenzenan E-mail:chen.ze.nan@163.com  
 * @version 创建时间：2012-8-10 下午04:35:48 Copyright ? 2012-8-10 Shanghai XXX Co.  
 *          Ltd. All right reserved.  
 */  
public class HttpClientLogin {  
  
    public static void main(String[] args) {  
        // 登陆 Url  
        String loginUrl = "http://isisn.nsfc.gov.cn/egrantweb/j_spring_security_check";  
        // 需登陆后访问的 Url  
        String dataUrl = "http://isisn.nsfc.gov.cn/egrantweb/main?locale=zh_CN";
        HttpClient httpClient = new HttpClient();  
  
        // 模拟登陆，按实际服务器端要求选用 Post 或 Get 请求方式  
        PostMethod postMethod = new PostMethod(loginUrl);  
  
        // 设置登陆时要求的信息，用户名和密码  
        NameValuePair[] data = { 
        		new NameValuePair("keynew", "0"),
        		new NameValuePair("sn_seral", ""),
        		new NameValuePair("digest", ""),
        		new NameValuePair("pwd", ""),
        		new NameValuePair("RandomData", "0"),
        		new NameValuePair("username", "wangye@hitsz.edu.cn"),  
                new NameValuePair("password", "09b958003"), 
                new NameValuePair("service", "/egrantweb/main"),
                new NameValuePair("locale", "zh_CN"),
                new NameValuePair("loginUrl", "http://isisn.nsfc.gov.cn/egrantweb/index"),};  
        postMethod.setRequestBody(data);  
        try {  
            // 设置 HttpClient 接收 Cookie,用与浏览器一样的策略  
            httpClient.getParams().setCookiePolicy(  
                    CookiePolicy.BROWSER_COMPATIBILITY);  
            httpClient.executeMethod(postMethod);  
            // 获得登陆后的 Cookie   https://mylogin.51job.com/08550225084121689791/my/My_Pmc.php https://mylogin.51job.com/72391487952313845862/my/My_Pmc.php
            Cookie[] cookies = httpClient.getState().getCookies();  
            StringBuffer tmpcookies = new StringBuffer();  
            for (Cookie c : cookies) {  
                tmpcookies.append(c.toString() + ";");  
            }  //e41228174f102e9bfed3c3c6b69eb1e0  68808f27838d30c5b51069a0dfc25f1f
            // 进行登陆后的操作1581,1602,1603,1610,1609,1608,1607,1606,1605,1620,1619,1617,1616,1622,1626,1642,1648,1647,1657  
            //http://219.223.252.205:9999/j_acegi_login.do?j_captcha_response=&j_username=14S158026&j_password=d1f3c05c062ce97fd2fd16798e7df67e&x=15&y=8
            //http://219.223.252.205:9999/j_acegi_login.do?j_captcha_response=&j_username=14S158026&j_password=d1f3c05c062ce97fd2fd16798e7df67e&x=56&y=2
            GetMethod getMethod = new GetMethod(dataUrl);  
            // 每次访问需授权的网址时需带上前面的 cookie 作为通行证  
            getMethod.setRequestHeader("cookie", tmpcookies.toString());  //.substring(0, tmpcookies.toString().length()-1)
            // 你还可以通过 PostMethod/GetMethod 设置更多的请求后数据  
            // 例如，referer 从哪里来的，UA 像搜索引擎都会表名自己是谁，无良搜索引擎除外  
            postMethod.setRequestHeader("Referer", "http://isisn.nsfc.gov.cn/egrantweb/");  
            postMethod.setRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.125 Safari/537.36");  
            httpClient.executeMethod(getMethod);  
            // 打印出返回数据，检验一下是否成功  
            String text = getMethod.getResponseBodyAsString();  
            System.out.println(text);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}  