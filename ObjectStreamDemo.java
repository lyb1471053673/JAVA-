import java.io.*;
class Candidate implements Serializable{
  // 存放后选人资料的类
  private String fullName,city;
  private int age;
  private boolean married;
  public Candidate(String fullName, int age,  String city){ 
    this.fullName = fullName;
    this.age = age;
    this.city = city;
  }
  public String toString(){ 
    return (fullName+","+age+","+city);
  }
}  
class ObjectStreamDemo{
  public static void main(String[] args) throws Exception{ 
    Candidate[] candidates = new Candidate[2];
    candidates[0] = new Candidate("张三 ", 33,  " 北京"); 
    candidates[1] = new Candidate("李四 ", 32, " 上海"); 
     //创建对象输出流和文件输出流相连
    ObjectOutputStream oos;
    oos = new ObjectOutputStream(new FileOutputStream("candidates.dat"));
     // 将对象中的数据写入对象输出流  
    oos.writeObject(candidates);
      // 关闭对象输出流
    oos.close(); 
    candidates = null;	
     //创建对象输入流和文件输入流相连
    ObjectInputStream ois;
    ois = new ObjectInputStream(new FileInputStream("candidates.dat"));
    //从输入流中读取对象
    candidates = (Candidate[]) ois.readObject(); 
    System.out.println("侯选人名单: "); 
    for (int i=0; i<candidates.length; i++)
         System.out.println("侯选人 "+ (i+1) + ": " + candidates[i]);
     // 关闭对象输入流     
     ois.close();  
   } 
 } 