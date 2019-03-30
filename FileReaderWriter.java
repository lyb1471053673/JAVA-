import java.io.*;

public class  FileReaderWriter{
	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader("user.txt");
		FileWriter fw = new FileWriter("user.bak");
		int b;
		while((b = fr.read()) != -1) {
			
			System.out.print((char)b);
		//	fw.write(b);
		}
		fr.close();
		fw.close();
	}
}