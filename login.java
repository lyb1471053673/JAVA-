public void login( ){
	  String sql = “select  name,  password  from userin”;
	    try{
	DatabaseConnection db = new DatabaseConnection( );
	Connection  conn = db.getConnection( );	       Statement stmt = conn.createStatement( );
	ResultSetrs = stmt.executeQuery(sql);
	       while (rs.next( )){
	          If (rs.getString(“name”).equals(user.name)
	          &&（rs.getString(“password”).equals(user.password)){
	       loginSuccess = true;
	    }
	 }
	   if (loginSuccess){
	      stmt.close( );
	      conn.close( );
	   }else
	     JOptionPane.showMessageDialog(null,”密码不正确，请重新输入!”,”
           密码不正确提示”,JOptionPane.OK_OPTION);
	 } catch ( Exception e) {
	 E.printStackTrace( );
	 }
	}
