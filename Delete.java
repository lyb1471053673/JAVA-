import java.sql.* ;
public class Delete {
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
     String sql = "DELETE FROM userin WHERE name = 'Rose'";
	 stmt.executeUpdate(sql);
	 System.out.println("ɾ���ɹ�");
	 stmt.close();              

         con.close();//�ͷ���Դ
	  }
   catch(Exception ex){
     System.out.println("����ʧ�ܡ�");
     ex.printStackTrace();
   }
 }
}
