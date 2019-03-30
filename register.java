	public void register( ){
	int flag = 0;                       //是否重名判断标志
	String sqll = “select  * from userin where name = ‘” + user.name
	              + “’”;
	try {
	DatabaseConnection  db = new DatabaseConnection( );
	Connection  Conn = db,getConnection( );
	Statement  stmt = conn.createStatement( );
	ResultSet  rs = stmt.executequery(sql);
	If (rs .next( ) ) {
	          JOptionPane.showMessageDialog(null.”注册名重复，请另外
	               选择”);
	          flag = 1;
	      }
	  }catch (Exception e){
	          e.printStackTrace( );
	  }
	If ( flag == 0 ) {                          //添加新注册用户
	 String sq12 = “INSERT INTO userin(name,password,sex,age,nclass)
	             VALUES (?,?,?,?,?)” ;
	      try{
	  Pstmt   pstmt = conn,prepareStatement(sq12);
	   pstmt.setString (1, user. name);
	   pstmt.setString (2, user.password);
	   pstmt.setString (3, user. sex);
	   pstmt.setString (4, user.age);
	   pstmt.setString (5,user.nclass);
	   pstmt.executeUpdate( );
	       //发送注册成功信息
	         JOptionPane.showMessageDialog(null,”用户”+ user.name +
	          “注册成功”,”+”\n”;
	         regtSuccess = true;
	           //关闭文件
	         pstmt.close( );                  //关闭操作
	         db.close( );                     //数据库关闭
	       }catch（SQLException  e）{
	e.printStackTrace();
	       } catch (Exception e ) {
	e.printStackTrace( );
	       }
	   }
	 }
