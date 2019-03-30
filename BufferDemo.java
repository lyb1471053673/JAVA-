import java.io.*;
public class  BufferDemo{
  public static void main(String[] args) { 
    String s;
    try {
      FileWriter fw=new  FileWriter("hello.txt");
      FileReader fr=new  FileReader("hello.txt");
      BufferedWriter bw = new BufferedWriter(fw);
      BufferedReader br = new BufferedReader(fr);
      bw.write("Hello");
      bw.newLine();
      bw.write("Everyone");
      bw.newLine();
      bw.flush();
      while((s=br.readLine())!=null){
        System.out.println(s);
      }
      bw.close(); 
      br.close();
      fr.close();
      fw.close();
    } catch (IOException e) { e.printStackTrace();}
  }
}