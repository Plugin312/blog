package boke.bean;

import java.io.File;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tools {

	//�������
		static String regEx = "[\u4e00-\u9fa5]";
		static Pattern pat = Pattern.compile(regEx);
	
	public static boolean isContainsChinese(String str)
	{
	Matcher matcher = pat.matcher(str);
	boolean flg = false;
	if (matcher.find())    {
	flg = true;
	}
	return flg;
	}
	
	public static String getRandomString(int length) { //length��ʾ�����ַ����ĳ���  
	    String base = "abcdefghijklmnopqrstuvwxyz0123456789";     
	    Random random = new Random();     
	    StringBuffer sb = new StringBuffer();     
	    for (int i = 0; i < length; i++) {     
	        int number = random.nextInt(base.length());     
	        sb.append(base.charAt(number));     
	    }     
	    return sb.toString();     
	 }     
	
	
	public static void renameFile(String file, String toFile) {

        File toBeRenamed = new File(file);
        //���Ҫ���������ļ��Ƿ���ڣ��Ƿ����ļ�
        if (!toBeRenamed.exists() || toBeRenamed.isDirectory()) {

            System.out.println("File does not exist: " + file);
            return;
        }

        File newFile = new File(toFile);

        //�޸��ļ���
        if (toBeRenamed.renameTo(newFile)) {
            System.out.println("File has been renamed.");
        } else {
            System.out.println("Error renmaing file");
        }

    }
	
}
