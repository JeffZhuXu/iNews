package catchnews.tools.general;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import catchnews.tools.Select;
import catchnews.tools.StorageToSql;
import catchnews.tools.code.WebsiteName;
import cn.edu.hfut.dmic.contentextractor.ContentExtractor;
import cn.edu.hfut.dmic.contentextractor.News;

public class CatchAndStorageEducationNews {

	/**������ҳ������ַ�Լ���վ�������Լ���������ʶ���뽫��ҳ�����ݱ���Ϊ����Ҫ��HTLM�ļ������ֻ�����ʹ���������Ż���վ�Ľ�����ʹ��
	 * ��ҳ��ַ
	 * ��վ����
	 * ����������
	 * @param url,websitename
	 * @author ����
	 * @throws Exception 
	 */
	
	public  static void finalWork(String url,Map<String,String> website) throws Exception{
		

		//�ļ����Ʊ���Ϊ http**********���ָ�ʽ��ֻ�������ֺ���ĸ
		String fileName = website.get("english")+"/"+selectNumberAndWord(url);
		File newsFile = new File("d:/inews/htmlfile/"+fileName+".html");	
		//���ļ������ڵ�ʱ����ִ������Ĳ���������Ѿ�ץ�����ǾͲ���ץȡ��
		if(!newsFile.exists())	{
		
		//��վ����ʱ����Ϊ40��
		Document doc = Jsoup.connect(url).timeout(20000).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").get();
		
		//System.out.println("��ҳ���ģ�"+doc);
		
		//���·����Ϊu����·��
		Elements href1=doc.select("[src]");
		for(Element e:href1){
			String absURL=e.absUrl("src");
			//System.out.println(absURL);
			e.attr("src", absURL);
		}
		
		
		News news = ContentExtractor.getNewsByDoc(doc);
		
		String title="";
		
		//��û��Ϊ�����վ�����趨title�������ʽ��ʱ��˵����ͨ�õı���ץȡ�취���Ծ�ȷ��ץ������
		if(website.get("title").length()==0){
			
		 title = getBestTitleAsString(doc).trim();
		}else{
			//���Ϊ�����վ�����趨��title���������ʽ��˵�����ѧУ���ⲻ����ͨ�õķ�����Ҫ�Լ�д������ץ���ĵ�һ������
			title=getInformationFromContent(doc.toString(), website.get("title")).get(0).trim();
		}
		String time = news.getTime();
		//ûץ��ʱ�䣬��ϵͳ��ǰ��ʱ����,����С��8���߲�����20��ͷ��
		if((time.length()<8)||!(time.substring(0, 2).equals("20"))){
			time=getNowTimeAsString();
		}
		
		//��ʱ��ת����2015081045226�ĸ�ʽ�����ڴ����ݿ��õ�,ѡǰ8λ
		String storagetime = Select.selectDate(time).substring(0, 8);
		
		//���ץ��title��ͨ���������ж�����Ϊ���ȴ���2��title��ʾ��ȷ��title,�Լ��������ݳ����趨�õ���ͳ���
		if((title.length()>2)&&(news.toString().length())>Integer.parseInt(website.get("wordlength"))&&(!title.equals("ûƥ������"))){
		

			
		
		
		//��һ��replace������ͼƬ��ʾ��ʽ��ʹ��ͼƬ��Ӧ�ֻ���Ļ���ڶ���replace��������Ĳ��ֵ�title��Ȼ���Լ�����title
		String content =news.getContentElement().toString().replaceAll("<img", "<img  style=\"max-width:100%\" " ).replaceAll(title, "");
		
		//ȥ�������еĲ���Ҫ��<div   ****>
		Matcher matcher1 = Pattern.compile("<div.*>").matcher(content);
		while(matcher1.find()){	
			content=content.replaceAll(matcher1.group(),"");
		}
		
		
		//��ȡ����ͼƬ���ӣ�û�еĻ�����0
		List<String> img = getImgsFromPage(content);
		//System.out.println("ͼƬ���ӣ�" + img);
		//����ͼƬ���У�ͬʱǰ����ϻ��з�����ֹͼƬǰ���������
		content = adjastImgsForm(content);
		
		
		//��ȫ��ҳ����ȱʧ����Ϣ������title����Դ��ʱ��
		content =
			//������Ϣ,�������⡢��Դ�͸���ʱ��
		"<div><a href=\"#\"><span style=\"visibility:hidden\">"+title+","+website.get("chinese")+","+storagetime+","+"</span></a></div>"+	
		"<html>\n" +
		"<head>\n" +
		"<META http-equiv=Content-Type content=\"text/html; charset=utf-8\">"+
		"<title>" + title + "</title>\n" + "</head>\n"
		+"<font size=4><center><B>"+title+"</B></center></font><br>"
		+ "<font size=1>"+website.get("chinese") + "  " +time+"</font><br>\n" +
		"<hr style=\"height:3px;border:none;border-top:3px double red;\" /><br>" //���ӱ�������ĵķָ���
		+ content;
		
		//�����Ż�����վ�Ľ�����������ص�ѧУ����
		String relativeSchools=getRelativeSchools(content).toString();

		
			//�����ļ��ļ�������Ϊ��ַ�е�Ӣ����ĸ�����ֵ����
		saveToHtmlFile(content, fileName);
		System.out.println("url: " + url +" save html successful");
		//�������ݿ�
		StorageToSql.addToSqlWithRelativeSchools(website.get("chinese"), website.get("idcode"), "0", "0", website.get("chinese"), title, storagetime, img.get(0), fileName,relativeSchools);
		
		}
		}
		
	}
	//ץȡ�ַ������е���ĸ������
	public static String selectNumberAndWord(String txt){
		

		String number ="";
		Matcher matcher = Pattern.compile("[a-zA-Z\\d]+").matcher(txt);
		while(matcher.find()){


			number = number +  matcher.group().toString();

		}
		return number;
	}
	//��ȡ��ǰʱ��2015-08-07 14:25:32
	public static String getNowTimeAsString(){
		Date d = new Date();
		
		SimpleDateFormat format = 
			new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String a = format.format(d).toString();
		
		return a;
	}
	//��ȡ��ǰ���ڣ���ʽΪ20150724
	public static String getNowDateAsString(){
			Date d = new Date();
			
			SimpleDateFormat format = 
				new SimpleDateFormat("yyyy-MM-dd");
			String a = format.format(d).toString();
			

			return a;
	}
	//ץȡ���ŵ�ͼƬ����,����http://www.szu.edu.cn/2013/img/20150720113555117.jpg
	public static List<String> getImgsFromPage(String content){

		
		//���ڴ���ҵ��Ľ��
		int num =0;
		List<String> result = new ArrayList<String>();
		Matcher matcher = Pattern.compile("(?<=src=\").*?(?=\")").matcher(content);

		while(matcher.find()){	
			result.add(matcher.group());
			num=num+1;
		}  
		//û�ҵ���Ϣ�Ļ�,��һ��0
		if(num==0){
			result.add("0");
		}
		
		return result;
	}
	
	//���������ĵ�ͼƬ����Ϊ���У�ͬʱ��ͼƬǰ��ͺ�����ϻ��з�����ֹǰ����ֺ��֣�<br><div align="center"><img **/></div><br>
	public static String adjastImgsForm(String content){

		
		String text = content;
		

		
		
		Matcher matcher = Pattern.compile("(<img|<IMG).*?>").matcher(text);

		while(matcher.find()){	
			//����ͼƬ���У�ͬʱ��ͼƬǰ����ϻ��з�,���趨�̶��߶ȵ�ͼƬ�����滻��
			String img =matcher.group();
			img=img.replaceAll("height", "");
			text=text.replaceAll(matcher.group(),"<br><div align=\"center\"><br>" +img+"</div><br>"  );
		}  
		return text;
	}
	
	//���ļ�����ΪHTML�ļ���Ŀ¼Ϊd��/inews/htlmfile/****,�����ʽͳһΪUTF8
	public static void saveToHtmlFile(String text,String filename){
		
		String processedStr = text;

		try{

		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\inews\\htmlfile\\" + filename + ".html"), "UTF-8"));
		//GBKΪ���ַ�������Ϊ�ƶ��ĺ��ֱ����ʽ��ͳһ��ΪUTF-8																									
		 out.write(processedStr);
		 out.close();
		
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	//ץȡ���ű���,ͨ���ȶ����ַ���ץ����title������ѡ���ŵ�
	public static String getBestTitleAsString(Document doc) throws Exception{
		
		
		
		List<String> title= new ArrayList<String>();
		title.add(doc.title()); //doc�ļ������õ�title
		title.add(ContentExtractor.getNewsByDoc(doc).getTitle()); //ͨ��webcolector�����ű���ץȡ����ץ���ı���
		Matcher matcher = Pattern.compile("(?<=([^\"]itle.{1,3}>))[\\s\\S]{1,50}(?=</)").matcher(doc.html().toString());
		
		int sum=0;
		//ͨ���Լ�д�ĺ�����ץȡ����
		while(matcher.find()){	
			//��ƥ�䵽�����ĳ�ȥǰ��ͺ���Ŀո�ͻ��з�
			title.add(matcher.group().trim());
			sum=sum+1;
		}  
		//�Լ��ķ���û���ҵ�title
		if(sum==0){
			
			//��������������ûץ����ʱ��
			if((title.get(0).length()==0)&&(title.get(1).length()==0)){
			return "�����ȡʧ��";	
			//��ץ�������ַ����У���С�ı��ⳤ���������5����ô��Ϊ�ٵ�ץ���ı�������ȷ�ģ�ѡ��С�ĳ�����Ϊ��ȷ�ı���
			}else if(((title.get(1).length()<title.get(0).length()))&&(title.get(1).length()>5)){
				return title.get(1);
			}else{
				//���ץ���ĳ���С�ı��ⳤ��С��5 ����Ϊץ���Ķ˵����ű����Ǵ���ģ�ѡ���ı�����Ϊ��ȷ�ı���
				return title.get(0);
			}
		}else   //�Լ��ķ���Ҳץ����ʱ����ôץ�����п�����ȷ������������ַ����ҵ��Ĳ��ԣ���ô���Լ���title
		{      
			//֮ǰ����������ץ����ȡ��ѵ���һ�������ȴ���5����С����һ��
			if(((title.get(1).length()<title.get(0).length()))&&(title.get(1).length()>5)){
			return title.get(1);
			
			//���ȼ���ߵ���News����,���ûץ�����ϴ��Լ��ķ���
			
			}else if( (title.get(1).length()<5)&&(title.get(2).length()<=title.get(0).length())){
				return title.get(2);
			}else{
				return title.get(0);
			}
		}
		}
	
	//ץȡָ���ı��еģ�ƥ���������ʽ�����ݲ���
	public static List<String> getInformationFromContent(String content,String limit){

		
		//���ڴ���ҵ��Ľ��
		int num =0;
		List<String> result = new ArrayList<String>();
		Matcher matcher = Pattern.compile(limit).matcher(content);

		while(matcher.find()){	
			result.add(matcher.group());
			num=num+1;
		}  
		//û�ҵ���Ϣ�Ļ�
		if(num==0){
			result.add("ûƥ������");
		}
		
		return result;
		
	
	}
	
	//�ҳ����������У���ص�ѧУ���ƣ����صĽ���������ѧУ���Ƶ�һ��list
	public static List<String> getRelativeSchools(String content){

		
		//���ڴ���ҵ��Ľ��
		int num =0;
		List<String> result = new ArrayList<String>();
		
		//ѧУ�����Ƽ���
		List<String> schools=WebsiteName.schoolNames;
		
		for(int i=0;i<schools.size();i++){
			
			Matcher matcher = Pattern.compile(schools.get(i)).matcher(content);

			while(matcher.find()){	
				result.add(schools.get(i));
				num=num+1;
				break;
			}  
			
		}

		//û�ҵ���Ϣ�Ļ�
		if(num==0){
			result.add("0");
		}
		
		return result;
		
	
	}

}