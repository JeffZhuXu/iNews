package com.yisinian.iNews.tools;

import java.io.File;
import java.io.IOException;



public class CollectNews {

	/**20115.7.27
	 * ������������ļ�html�ҳ��������кϲ����ϲ���txt��ʽ�ļ�������������������hadoop��HDFSϵͳ�����ڶ����ݽ���ͳ�ƺʹ���
	 * ����
	 * ��������Ҫ�ϲ����ļ���·��,������ļ�·��
	 * @param 
	 */
	public static int num =0;  //���ڱ��浱�����������
	//�ϲ�ÿ���������Ϣ
	public static void collectDaliyNewsAsTxt(String newsPath,String savepath) throws IOException{
		
		//���ļ��ı��ر���·��,ֱ�ӷ���D�̣��ϴ���ɹ���ֱ��ɾ��
		String savePath = "d:/inews/txtfile/"+savepath+".txt";
		//������ļ���hadoop·��
		String hdfsPath = "hdfs://192.168.0.96:9000/user/root/dailynews/" +savepath ;
		
		
		//�������ļ����ڣ���ɾ��
//		File f1 = new File(savePath + ".txt");
//		if(f1.exists()){
//			System.out.println(f1.getAbsolutePath());
//			f1.delete();
//		}

		String daliyNewsContent = "";//����ϲ��������Ϣ���ַ���
		
		//ÿ��������Ǳ��������������������ļ��������
		String dailyNewsPath = newsPath;
		
		
			//�ҵ�����ĸ��µ�����
			File file = new File(dailyNewsPath);
			if(file.exists()){
				for(File f:file.listFiles()){
					if(f.isFile()){
						daliyNewsContent = daliyNewsContent+ ReadHtmlFiles.readTextFile(f.getAbsolutePath(), "utf8") + "\r\n" + "inews" +"\r\n"; //ÿ������֮��ͨ��<inews>�����ʶ��������
						System.out.println(f.getAbsolutePath());
					}
				
				}
				//���������ݱ��浽���أ������ʽUTF-8
				SaveTxt.saveToHtmlFile(daliyNewsContent, savePath, "utf8");
				//�����������ϴ���HDFS
				//UploadFileToHDFS.uploadFile(savePath, hdfsPath);
				//�ϴ�������Ź��󣬽����ɵı����ļ�ɾ��
				File f2 = new File(savePath);
				//f2.delete();
				
			}
			else{
				System.out.println("ָ��Ŀ¼�ļ�������");
			}
			
				

	}
	

}