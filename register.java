	public void register( ){
	int flag = 0;                       //�Ƿ������жϱ�־
	String sqll = ��select  * from userin where name = ���� + user.name
	              + ������;
	try {
	DatabaseConnection  db = new DatabaseConnection( );
	Connection  Conn = db,getConnection( );
	Statement  stmt = conn.createStatement( );
	ResultSet  rs = stmt.executequery(sql);
	If (rs .next( ) ) {
	          JOptionPane.showMessageDialog(null.��ע�����ظ���������
	               ѡ��);
	          flag = 1;
	      }
	  }catch (Exception e){
	          e.printStackTrace( );
	  }
	If ( flag == 0 ) {                          //�����ע���û�
	 String sq12 = ��INSERT INTO userin(name,password,sex,age,nclass)
	             VALUES (?,?,?,?,?)�� ;
	      try{
	  Pstmt   pstmt = conn,prepareStatement(sq12);
	   pstmt.setString (1, user. name);
	   pstmt.setString (2, user.password);
	   pstmt.setString (3, user. sex);
	   pstmt.setString (4, user.age);
	   pstmt.setString (5,user.nclass);
	   pstmt.executeUpdate( );
	       //����ע��ɹ���Ϣ
	         JOptionPane.showMessageDialog(null,���û���+ user.name +
	          ��ע��ɹ���,��+��\n��;
	         regtSuccess = true;
	           //�ر��ļ�
	         pstmt.close( );                  //�رղ���
	         db.close( );                     //���ݿ�ر�
	       }catch��SQLException  e��{
	e.printStackTrace();
	       } catch (Exception e ) {
	e.printStackTrace( );
	       }
	   }
	 }
