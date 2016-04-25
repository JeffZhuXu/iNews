package catchnews.tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveHtml {

	public static void saveToHtmlFile(String text,String filename){
	
	String processedStr = text;

	try{

	Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("c:\\inews\\htmlfile\\" + filename + ".html"), "UTF-8"));
	//GBK为将字符串保存为制定的汉字编码格式，统一改为UTF-8																									
	 out.write(processedStr);
	 out.close();
	}catch(IOException e)
	{
		e.printStackTrace();
	}
}
}
