import java.io.*;
public class  SystemDemo{
  public static void main(String[] args) throws IOException{
  	int a;
  	float b; 
  	String str;
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    System.out.print("���������(����): ");
    str=br.readLine();
    a=Integer.parseInt(str);
    System.out.print("�����뱻����(ʵ��): ");
    str=br.readLine();
    b=Float.parseFloat(str);
    System.out.println("������ӽ��Ϊ��"+(a+b)); 
    System.out.print("������һ���ַ�: ");
    String s=br.readLine();
    System.out.println("������ַ���Ϊ��"+s );
  }
}

