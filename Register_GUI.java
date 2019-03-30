//package system_source;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import java.io.Serializable;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class Register_GUI 
{
	public Register_GUI() 
	{
		RegisterFrame rf = new RegisterFrame();

		rf.setVisible(true);
	}
	
	public static void main(String args[]){
		new Register_GUI();
	}
}

//�����
class RegisterFrame extends JFrame
{

    private Toolkit tool;
	public RegisterFrame()
	{
		setTitle("�û�ע��");
		tool = Toolkit.getDefaultToolkit();
		Dimension ds = tool.getScreenSize();
		int w = ds.width;
		int h = ds.height;
		setBounds((w-300)/2,(h-300)/2, 300, 300);
		setResizable(false);
		BorderLayout bl =new BorderLayout();
		setLayout(bl);
		RegisterPanel rp = new RegisterPanel(this);
		add(rp,BorderLayout.CENTER);
		//pack();
	}
}

//������
class RegisterPanel extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
    private JLabel titlelabel,namelabel,pwdlabel1,pwdlabel2,sexlabel,agelabel,classlabel;
    private JTextField namefield,agefield;
    private JPasswordField pwdfield1,pwdfield2;
    private JButton commitbtn,resetbtn,cancelbtn;
    private JRadioButton rbtn1,rbtn2;
    private JComboBox combo;
    private Vector<String> v;
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    private JPanel panel;
    private Box box;
    private JFrame iframe;
    //private Box box,box1,box2,box3,box4,box5,box6,box7;
	public RegisterPanel(JFrame frame)
	{
		iframe = frame;
		titlelabel = new JLabel("�û�ע��");
		titlelabel.setFont(new Font("����",Font.BOLD,24));
		namelabel = new JLabel("�û�����");
		pwdlabel1 = new JLabel("��    �룺");
		pwdlabel2 = new JLabel("ȷ�����룺");
		sexlabel = new JLabel("��     ��:");
		agelabel = new JLabel("�� ��:  ");
		classlabel = new JLabel("�����༶:");
		namefield = new JTextField(16);
		pwdfield1 = new JPasswordField(16);
		//�������������ʾ���ַ�
		pwdfield1.setEchoChar('*');
		pwdfield2 = new JPasswordField(16);
		pwdfield2.setEchoChar('*');
		agefield = new JTextField(16);
		rbtn1 = new JRadioButton("��");
		rbtn2 = new JRadioButton("Ů");
		rbtn1.setSelected(true);
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbtn1);
		bg.add(rbtn2);
		v = new Vector<String>();
		v.add("���Ӣ��053");
		v.add("���Ӣ��052");
		v.add("���Ӣ��051");
		v.add("�����Ӧ��051");
		v.add("�����Ӧ��052");
		combo = new JComboBox(v);
		commitbtn = new JButton("ע��");
		commitbtn.addActionListener(this);
		resetbtn = new JButton("����");
		resetbtn.addActionListener(this);
		cancelbtn = new JButton("ȡ��");
		cancelbtn.addActionListener(this);
		panel = new JPanel();
		panel.add(rbtn1);
		panel.add(rbtn2);
		Border border = BorderFactory.createTitledBorder("");
		panel.setBorder(border);
		
		box = Box.createHorizontalBox();
		box.add(commitbtn);
		box.add(Box.createHorizontalStrut(30));
		box.add(resetbtn);
		box.add(Box.createHorizontalStrut(30));
		box.add(cancelbtn);
		
		//��������������ʽ����
		gbl = new GridBagLayout();
		setLayout(gbl);
		gbc = new GridBagConstraints();
		addCompnent(titlelabel,0,0,4,1);
		add(Box.createVerticalStrut(20));
		gbc.anchor=GridBagConstraints.CENTER;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.weightx=0;
		gbc.weighty=100;
		addCompnent(namelabel,0,1,1,1);
		addCompnent(namefield,1,1,4,1);
		addCompnent(pwdlabel1,0,2,1,1);
		addCompnent(pwdfield1,1,2,4,1);
		addCompnent(pwdlabel2,0,3,1,1);
		addCompnent(pwdfield2,1,3,4,1);
		addCompnent(sexlabel,0,4,1,1);
		//addCompnent(rbtn1,1,4,1,1);
		//addCompnent(rbtn2,2,4,1,1);
		addCompnent(panel,1,4,1,1);
		gbc.anchor=GridBagConstraints.EAST;
		gbc.fill=GridBagConstraints.NONE;
		addCompnent(agelabel,2,4,1,1);
		gbc.fill=GridBagConstraints.HORIZONTAL;
		addCompnent(agefield,3,4,2,1);
		addCompnent(classlabel,0,5,1,1);
		addCompnent(combo,1,5,4,1);
		gbc.anchor=GridBagConstraints.CENTER;
		gbc.fill=GridBagConstraints.NONE;
		addCompnent(box,0,6,4,1);
	}
	//����һ���������鲼�ֵ�ͨ�÷���
	public void addCompnent(Component c,int x,int y,int w,int h)
	{
		gbc.gridx=x;
		gbc.gridy=y;
		gbc.gridwidth=w;
		gbc.gridheight=h;
		add(c,gbc);
	}
	//@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==commitbtn)
		{
			//���ܿͻ�����ϸ����
			Register rinfo=new Register();
			rinfo.name = namefield.getText().trim();
			rinfo.password = new String(pwdfield1.getPassword());
			rinfo.sex = rbtn1.isSelected()?"��":"Ů";
			rinfo.age = agefield.getText().trim();
			rinfo.nclass = combo.getSelectedItem().toString();
			
			//��֤�û����Ƿ�Ϊ��
			if(rinfo.name.length()==0)
			{
			    JOptionPane.showMessageDialog(null,"\t�û�������Ϊ��");	
	            return;	
			}
			
			//��֤�����Ƿ�Ϊ��
			if(rinfo.password.length()==0)
			{
			    JOptionPane.showMessageDialog(null,"\t���벻��Ϊ��");	
	            return;	
			}	
			
			//��֤�����һ����
			if(!rinfo.password.equals(new String(pwdfield2.getPassword())))
			{
			    JOptionPane.showMessageDialog(null,"�����������벻һ�£�����������");	
	            return;
			}
			
			//��֤�����Ƿ�Ϊ��
			if(rinfo.age.length()==0)
			{
			    JOptionPane.showMessageDialog(null,"\t���䲻��Ϊ��");	
	            return;	
			}
			//��֤����ĺϷ���
			int age=Integer.parseInt(rinfo.age);
			if (age<=0||age>100){
				JOptionPane.showMessageDialog(null,"\t�������벻�Ϸ�");
				return;
			}
	
			Register_Login rl = new Register_Login(rinfo);
			rl.register();
			if(rl.regtSuced())
			{
//				new LoginFrame();
				iframe.dispose();
			}
        }
		if(e.getSource()==resetbtn)
		{
			namefield.setText("");
			pwdfield1.setText("");
			pwdfield2.setText("");
			rbtn1.isSelected();
			agefield.setText("");
			combo.setSelectedIndex(0);	
		}
		if(e.getSource()==cancelbtn)
		{
//			new LoginFrame();
			iframe.dispose();
		}
	}
}



class Register_Login 
{
   Register regt = new Register();
   Login login = new Login();
   private boolean loginSuccess = false;
   private boolean regtSuccess = false;
   public Register_Login(Register  reg){
	   regt=reg;
   }
   public void register(){
	  File  f;
      FileInputStream fi;
      FileOutputStream fo;
	  Vector vuser = new Vector();
	  ObjectInputStream ois;
	  ObjectOutputStream oos;
	  int flag=0; 
       try {
       	 f=new File("users.dat");  
   	     if(f.exists()){
    	 fi = new FileInputStream(f);
         ois = new ObjectInputStream(fi);
    	 vuser=(Vector)ois.readObject(); 
    	 for(int i=0;i<vuser.size();i++){
    		Register regtmesg = (Register)vuser.elementAt(i);  
         	 if(regtmesg.name.equals(regt.name)){
             JOptionPane.showMessageDialog(null,"���û��Ѵ��ڣ�����������");
              flag=1;
              break;
             }
    	  }
    	  fi.close();
    	  ois.close();		
        }
        if (flag==0){
    	        // �����ע���û�
		  vuser.addElement(regt);
				// �������е���д���ļ�
		  fo = new FileOutputStream(f);
		  oos = new ObjectOutputStream(fo);
		  oos.writeObject(vuser);
				// ����ע��ɹ���Ϣ
		  JOptionPane.showMessageDialog(null,"�û�" + regt.name + "ע��ɹ�, " + "\n");
			 regtSuccess = true;
			fo.close();
			oos.close();
		}
	 }
	  catch(ClassNotFoundException e){
    	 JOptionPane.showMessageDialog(null,"�Ҳ����û��ļ�'users.dat'!");
      }
      catch(IOException e){
      	System.out.println(e);
     }
   } 
   public boolean regtSuced(){
	   return regtSuccess;
   }
   public void login(){
	 Vector vuser = new Vector();
     try{
        FileInputStream fi = new FileInputStream("users.user");
        ObjectInputStream si = new ObjectInputStream(fi);
        vuser = (Vector)si.readObject();
        for(int i=0;i<vuser.size();i++){
           Register regtmesg = (Register) vuser.elementAt(i);            
		     if ( regtmesg.name.equals(login.name)){ 
		        if( !regtmesg.password.equals(login.password) ){
		          JOptionPane.showMessageDialog(null,"���벻��ȷ�����������룡","���벻��ȷ��ʾ",JOptionPane.OK_OPTION);
		      	  break;
		         }
		         else{  
		       	       loginSuccess = true;
		         } 
		     }
		     else{
		       if(i == vuser.size()){
		    	   JOptionPane.showMessageDialog(null,"���û��������ڣ�����ע�ᣡ","���û���������ʾ",JOptionPane.OK_OPTION);
		    	}
		    	else{
		    	  continue;
		    	}
		     }
         }
          fi.close();
          si.close();
    }
    catch(Exception e){
       JOptionPane.showMessageDialog(null,"�Ҳ����û��ļ�'users.user'!");
    }
  }
  public boolean islogin(){
	 return loginSuccess;
  }
}

class Register implements Serializable{
		String name;
	    String password;
	    String sex;
	    String age;
	    String nclass;
}
class Login implements Serializable
{
	
	private static final long serialVersionUID = 1L;
		String name;
	    String password;
        public Login()
        {
        	
        }
}