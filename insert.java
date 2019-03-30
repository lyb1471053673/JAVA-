import java.sql.* ;
public class insert {
	private static final String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=test";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "123456";	
	public static Connection con;
	public static void main (String[ ] args)throws Exception {
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	System.out.println("加载驱动成功");
	try{
	 con=DriverManager.getConnection(URL, USERNAME,PASSWORD);
         System.out.println("连接成功");

         Statement stmt = null;
	 stmt = con.createStatement();
         String sql="INSERT INTO userin(id,name,password,sex,age,nclass)"+"VALUES(6,'Rose', '123', '女', 18, '软件英语051')";
	 stmt.executeUpdate(sql);
	 System.out.println("插入成功");
	 stmt.close();              

         con.close();//释放资源
	  }
   catch(Exception ex){
     System.out.println("连接失败。");
     ex.printStackTrace();
   }
 }
}
