import java.util.Scanner;
public class ScannerDemo {
  public static void main(String[] args) {
	 int a;
	 float b;
	 String str;
	 Scanner cin = new Scanner(System.in);  //创建输入处理的对象
	 System.out.print("请输入加数(整型): ");
	 a = cin.nextInt();
	 System.out.print("请输入被加数(实型):" );
	 b = cin.nextFloat(); 
	 System.out.println("两数相加结果为："+(a+b)); 
	 System.out.print("请输入一个字符: ");   
	 str = cin.next();            
	 System.out.println("输入的字符串为："+str );       
  }
}
