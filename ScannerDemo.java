import java.util.Scanner;
public class ScannerDemo {
  public static void main(String[] args) {
	 int a;
	 float b;
	 String str;
	 Scanner cin = new Scanner(System.in);  //�������봦��Ķ���
	 System.out.print("���������(����): ");
	 a = cin.nextInt();
	 System.out.print("�����뱻����(ʵ��):" );
	 b = cin.nextFloat(); 
	 System.out.println("������ӽ��Ϊ��"+(a+b)); 
	 System.out.print("������һ���ַ�: ");   
	 str = cin.next();            
	 System.out.println("������ַ���Ϊ��"+str );       
  }
}
