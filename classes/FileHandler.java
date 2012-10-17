package classes;



import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class FileHandler {
	
	@SuppressWarnings("deprecation")
	public static void putToFile(String input,String path,boolean overwrite){
		String s = input;
		if(!overwrite){s = readFromFile(path)+input;}
		byte[] bytes = s.getBytes();
		InputStream is = new ByteArrayInputStream(bytes);
		try {
			DataInputStream dInStream = new DataInputStream(new BufferedInputStream(is));
			BufferedWriter bw = new BufferedWriter(new FileWriter(path));
			while((s = dInStream.readLine())!=null){
				bw.append(s);
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				is.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public static String readFromFile(String path){
		File file  = new File(path);
		StringBuilder out = new StringBuilder();
		
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while((line = br.readLine())!=null){
				out.append(line).append("\n");
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return out.toString();
	}

	public static void main(String[] args) {
		putToFile(args[0], args[1],false);
	}
	
}
