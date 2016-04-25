package catchnews.tools;

import java.net.URL;
import java.net.MalformedURLException;
import java.net.HttpURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 2009-5-11
 * Time: 13:34:10
 * ģ��Http���ʵĹ�����
 */
public class HttpConnectionUtil {
    public static String getHttpContent(String url) {
        return getHttpContent(url, "UTF8");
    }

    public static String getHttpContent(String url, String charSet) {
        HttpURLConnection connection = null;
        String content = "";
        try {
            URL address_url = new URL(url);
            connection = (HttpURLConnection) address_url.openConnection();
//            connection.setRequestMethod("GET");
            //���÷��ʳ�ʱʱ�估��ȡ��ҳ���ĳ���ʱ��,����ֵ
            System.setProperty("sun.net.client.defaultConnectTimeout","30000");
            System.setProperty("sun.net.client.defaultReadTimeout", "30000");

            //after JDK 1.5
//            connection.setConnectTimeout(10000);
//            connection.setReadTimeout(10000);
            //�õ�����ҳ��ķ���ֵ
            int response_code = connection.getResponseCode();
            if (response_code == HttpURLConnection.HTTP_OK) {
                InputStream in = connection.getInputStream();
//                InputStreamReader reader = new InputStreamReader(in,charSet);
                BufferedReader reader = new BufferedReader(new InputStreamReader(in, charSet));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    content+=line;
                }
                return content;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(connection !=null){
                connection.disconnect();
            }
        }
        return "";
    }

//    public static void main(String[] args) {
////        String content = HttpConnectionUtil.getHttpContent("http://192.168.1.61:8001/");
//        String content = HttpConnectionUtil.getHttpContent("http://pkunews.pku.edu.cn/xywh/2015-08/03/content_289945.htm");
//        System.out.println("content = " + content);
//    }
}