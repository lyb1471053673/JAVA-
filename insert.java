import java.sql.* ;
public class insert {
	private static final String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=test";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "123456";	
	public static Connection con;
	public static void main (String[ ] args)throws Exception {
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	System.out.println("���������ɹ�");
	try{
	 con=DriverManager.getConnection(URL, USERNAME,PASSWORD);
         System.out.println("���ӳɹ�");

         Statement stmt = null;
	 stmt = con.createStatement();
         String sql="INSERT INTO userin(id,name,password,sex,age,nclass)"+"VALUES(6,'Rose', '123', 'Ů', 18, '���Ӣ��051')";
	 stmt.executeUpdate(sql);
	 System.out.println("����ɹ�");
	 stmt.close();              

         con.close();//�ͷ���Դ
	  }
   catch(Exception ex){
     System.out.println("����ʧ�ܡ�");
     ex.printStackTrace();
   }
 }
}
