import java.sql.* ;
public class Query {
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
    String sql = "select * from userin";
   ResultSet rs = stmt.executeQuery(sql);
  while (rs.next()) {
	System.out.print(rs.getInt("id") + "   ");
	 System.out.print(rs.getString("name") + "   ");
	System.out.print(rs.getString("password") +"    ");
	System.out.print(rs.getString("sex") +"  ");
	System.out.print(rs.getInt("age") +"  ");
	 System.out.println("  " + rs.getString("nclass"));
  }
	 System.out.println("��ѯ�ɹ�");
	 stmt.close();              

         con.close();//�ͷ���Դ
	  }
   catch(Exception ex){
     System.out.println("����ʧ�ܡ�");
     ex.printStackTrace();
   }
 }
}
