import java.io.*;
public class  FileStreamDemo {
  public static void main(String[] args) {
	 int b = 0;
	 FileInputStream in = null;
	 FileOutputStream out = null;
	 try {
	   in = new FileInputStream("user.txt");
	   out = new FileOutputStream("user.bak");
	   while((b=in.read())!=-1){
	  // 	System.out.print((char)b);
	   out.write(b);
	 }
	   in.close(); 
	   out.close();
	 } catch (FileNotFoundException e) {
	   System.out.println("�Ҳ���ָ���ļ�"); System.exit(-1);
	 } catch (IOException e1) {
	   System.out.println("�ļ����ƴ���"); System.exit(-1);
	 }
	  System.out.println("�ļ��Ѹ���");
  }
}
