import java.io.*;
class DataStreamDemo{
  public static void main(String args[]) throws  IOException {
        FileOutputStream fos = new FileOutputStream("a.txt");
        DataOutputStream dos = new DataOutputStream (fos);
        try{
            dos.writeUTF("����");
            dos.writeInt(2016);
           dos.writeUTF("��ӭ����");
        }
        finally{
            dos.close();
        }
   FileInputStream  fis = new FileInputStream("a.txt");
   DataInputStream dis = new DataInputStream(fis);
   try{
    System.out.print(dis.readUTF()+dis.readInt()+dis.readUTF());
   }
   finally{
    dis.close();
   }
  }
}
