import java.io.*;
public class RandomAcessFileDemo{
  public static void main(String[] args) throws Exception{
    File f=new File("raf.dat");
    RandomAccessFile raf=new RandomAccessFile(f,"rw");
    String username ="javalover";
    int  age=18;
    raf.writeUTF(username);
    raf.writeInt(age);
    System.out.println("�ļ��������");
    System.out.println("���ļ�˳���ȡ�ļ�������");
    raf.seek(0);
    System.out.println(raf.readUTF());
    System.out.println(raf.readInt());  
    raf.close();
  }
}
