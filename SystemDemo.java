import java.io.*;
public class  SystemDemo{
  public static void main(String[] args) throws IOException{
  	int a;
  	float b; 
  	String str;
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    System.out.print("请输入加数(整型): ");
    str=br.readLine();
    a=Integer.parseInt(str);
    System.out.print("请输入被加数(实型): ");
    str=br.readLine();
    b=Float.parseFloat(str);
    System.out.println("两数相加结果为："+(a+b)); 
    System.out.print("请输入一个字符: ");
    String s=br.readLine();
    System.out.println("输入的字符串为："+s );
  }
}

