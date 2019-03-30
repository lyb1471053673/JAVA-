import java.io.*;
class Candidate implements Serializable{
  // ��ź�ѡ�����ϵ���
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
    candidates[0] = new Candidate("���� ", 33,  " ����"); 
    candidates[1] = new Candidate("���� ", 32, " �Ϻ�"); 
     //����������������ļ����������
    ObjectOutputStream oos;
    oos = new ObjectOutputStream(new FileOutputStream("candidates.dat"));
     // �������е�����д����������  
    oos.writeObject(candidates);
      // �رն��������
    oos.close(); 
    candidates = null;	
     //�����������������ļ�����������
    ObjectInputStream ois;
    ois = new ObjectInputStream(new FileInputStream("candidates.dat"));
    //���������ж�ȡ����
    candidates = (Candidate[]) ois.readObject(); 
    System.out.println("��ѡ������: "); 
    for (int i=0; i<candidates.length; i++)
         System.out.println("��ѡ�� "+ (i+1) + ": " + candidates[i]);
     // �رն���������     
     ois.close();  
   } 
 } 