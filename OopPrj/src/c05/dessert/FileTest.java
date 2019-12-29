package c05.dessert;

import java.io.File;

public class FileTest {

	/**
	 * �ݹ���г�һ��Ŀ¼�µ������ļ�
	 */
	public static void getFiles(File dir) {
		if (dir == null || !dir.exists()) {
	        return;
	    }
	    if (dir.isFile()) {
	        System.out.println(dir.getName());
	        return;
	    }
	    for (File file : dir.listFiles()) {
	    	getFiles(file);
	    }
	}
	public static void main(String[] args) {
		File f = new File("D:\\workSpace1");
		getFiles(f);
	}
}
