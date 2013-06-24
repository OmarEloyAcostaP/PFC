package tafat.engine.tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileHandler {

	public static void writeFile(String filename, String content) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(filename));
			out.write(content);
			out.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String readFile(String filename){
		BufferedReader in;
		StringBuffer sb = null;
		try {
			in = new BufferedReader(new FileReader(filename));
			String nextLine = "";
		    sb = new StringBuffer();
			while ((nextLine = in.readLine()) != null) {
			     sb.append(nextLine);
			     sb.append("\n");
			}
			in.close();
			return sb.toString();
		} catch (IOException e) {
			//e.printStackTrace();
		}
		return "";
	}
	
	public static void copyFile(File source, File target) throws IOException {
		if (source.isDirectory()) {
			target.mkdir();

			String[] children = source.list();
			for (int i=0; i<children.length; i++)
				copyFile(new File(source, children[i]), new File(target, children[i]));
		}
		else {
			InputStream in = new FileInputStream(source);
			OutputStream out = new FileOutputStream(target);

			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0)
				out.write(buf, 0, len);
			in.close();
			out.close();
		}
	}
	
	
	public static String searchFile(String elementToSearch, File file) {
		String returnedFilePath = "";
		if (file.isFile()) {
			if (file.getName().toLowerCase().equals(elementToSearch.toLowerCase()))
				return file.getAbsolutePath();
		}
		else if (file.isDirectory()) {
			String[] files = file.list();
			if (files == null) return "";
			for (int i = 0; i < files.length; i++) {
				returnedFilePath += searchFile(elementToSearch, new File(file.getAbsolutePath() + "\\" + files[i]));
			}
			return returnedFilePath;
		}
		return "";
	}
	
	public static void deleteFile(File srcFile){ 
		if (srcFile.isDirectory()) { 
			for (File file : srcFile.listFiles())
				deleteFile(file); 
			srcFile.delete(); 
		} 
		else
			srcFile.delete(); 
	} 
}


