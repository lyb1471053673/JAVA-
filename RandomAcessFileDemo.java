import java.io.*;
public class RandomAcessFileDemo{
  public static void main(String[] args) throws Exception{
    File f=new File("raf.dat");
    RandomAccessFile raf=new RandomAccessFile(f,"rw");
    String username ="javalover";
    int  age=18;
    raf.writeUTF(username);
    raf.writeInt(age);
    System.out.println("文件创建完毕");
    System.out.println("从文件顺序读取文件的数据");
    raf.seek(0);
    System.out.println(raf.readUTF());
    System.out.println(raf.readInt());  
    raf.close();
  }
}
