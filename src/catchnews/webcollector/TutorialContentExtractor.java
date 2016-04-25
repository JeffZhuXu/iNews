package catchnews.webcollector;

import cn.edu.hfut.dmic.contentextractor.ContentExtractor;
import cn.edu.hfut.dmic.contentextractor.News;
import cn.edu.hfut.dmic.webcollector.net.HttpRequest;

/**
 * ���̳���ʾ�˴�WebCollector 2.10����ӵ�������ҳ�����Զ���ȡ����
 * 
 * @author hu
 */
public class TutorialContentExtractor {

    /*����HTML������ƶ���ҳ�ṹ����Ϣ*/
    public static void demo1() throws Exception {
        String url = "http://pkunews.pku.edu.cn/xxfz/2015-08/03/content_289946.htm";
        HttpRequest request = new HttpRequest(url);
        String html = request.getResponse().getHtmlByCharsetDetect();
        News news = ContentExtractor.getNewsByHtml(html, url);
        //System.out.println(news);
        
        System.out.println(news.getTitle());
        System.out.println(news.getTime());
        System.out.println(news.getUrl());
        System.out.println(news.getContentElement());
        
    }

    /*����URL������ƶ���ҳ�ṹ����Ϣ*/
    public static void demo2() throws Exception {
        String url = "http://pkunews.pku.edu.cn/xxfz/2015-08/03/content_289946.htm";
        News news = ContentExtractor.getNewsByUrl(url);
        System.out.println(news);
    }

    /*����HTML������ƶ���ҳ������*/
    public static void demo3() throws Exception {
        String url = "http://pkunews.pku.edu.cn/xxfz/2015-08/03/content_289946.htm";
        HttpRequest request = new HttpRequest(url);
        String html = request.getResponse().getHtmlByCharsetDetect();
        String content = ContentExtractor.getContentByHtml(html, url);
        System.out.println(content);

        //Ҳ�ɳ�ȡ��ҳ�������ڵ�Element
        //Element contentElement = ContentExtractor.getContentElementByHtml(html, url);
        //System.out.println(contentElement);
    }

    /*����URL������ƶ���ҳ������*/
    public static void demo4() throws Exception {
        String url = "http://pkunews.pku.edu.cn/xxfz/2015-08/03/content_289946.htm";
        String content = ContentExtractor.getContentByUrl(url);
        System.out.println(content);

        //Ҳ�ɳ�ȡ��ҳ�������ڵ�Element
        //Element contentElement = ContentExtractor.getContentElementByUrl(url);
        //System.out.println(contentElement);
    }

    public static void main(String[] args) throws Exception {
        demo1();
        //demo2();
        //demo3();
        //demo4();
    }
}