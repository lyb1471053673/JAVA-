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

//框架类
class RegisterFrame extends JFrame
{

    private Toolkit tool;
	public RegisterFrame()
	{
		setTitle("用户注册");
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

//容器类
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
		titlelabel = new JLabel("用户注册");
		titlelabel.setFont(new Font("隶书",Font.BOLD,24));
		namelabel = new JLabel("用户名：");
		pwdlabel1 = new JLabel("密    码：");
		pwdlabel2 = new JLabel("确认密码：");
		sexlabel = new JLabel("性     别:");
		agelabel = new JLabel("年 龄:  ");
		classlabel = new JLabel("所属班级:");
		namefield = new JTextField(16);
		pwdfield1 = new JPasswordField(16);
		//设置密码框中显示的字符
		pwdfield1.setEchoChar('*');
		pwdfield2 = new JPasswordField(16);
		pwdfield2.setEchoChar('*');
		agefield = new JTextField(16);
		rbtn1 = new JRadioButton("男");
		rbtn2 = new JRadioButton("女");
		rbtn1.setSelected(true);
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbtn1);
		bg.add(rbtn2);
		v = new Vector<String>();
		v.add("软件英语053");
		v.add("软件英语052");
		v.add("软件英语051");
		v.add("计算机应用051");
		v.add("计算机应用052");
		combo = new JComboBox(v);
		commitbtn = new JButton("注册");
		commitbtn.addActionListener(this);
		resetbtn = new JButton("重置");
		resetbtn.addActionListener(this);
		cancelbtn = new JButton("取消");
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
		
		//添加组件，采用箱式布局
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
	//定义一个用网格组布局的通用方法
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
			//接受客户的详细资料
			Register rinfo=new Register();
			rinfo.name = namefield.getText().trim();
			rinfo.password = new String(pwdfield1.getPassword());
			rinfo.sex = rbtn1.isSelected()?"男":"女";
			rinfo.age = agefield.getText().trim();
			rinfo.nclass = combo.getSelectedItem().toString();
			
			//验证用户名是否为空
			if(rinfo.name.length()==0)
			{
			    JOptionPane.showMessageDialog(null,"\t用户名不能为空");	
	            return;	
			}
			
			//验证密码是否为空
			if(rinfo.password.length()==0)
			{
			    JOptionPane.showMessageDialog(null,"\t密码不能为空");	
	            return;	
			}	
			
			//验证密码的一致性
			if(!rinfo.password.equals(new String(pwdfield2.getPassword())))
			{
			    JOptionPane.showMessageDialog(null,"密码两次输入不一致，请重新输入");	
	            return;
			}
			
			//验证年龄是否为空
			if(rinfo.age.length()==0)
			{
			    JOptionPane.showMessageDialog(null,"\t年龄不能为空");	
	            return;	
			}
			//验证年龄的合法性
			int age=Integer.parseInt(rinfo.age);
			if (age<=0||age>100){
				JOptionPane.showMessageDialog(null,"\t年龄输入不合法");
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
             JOptionPane.showMessageDialog(null,"该用户已存在，请重新输入");
              flag=1;
              break;
             }
    	  }
    	  fi.close();
    	  ois.close();		
        }
        if (flag==0){
    	        // 添加新注册用户
		  vuser.addElement(regt);
				// 将向量中的类写回文件
		  fo = new FileOutputStream(f);
		  oos = new ObjectOutputStream(fo);
		  oos.writeObject(vuser);
				// 发送注册成功信息
		  JOptionPane.showMessageDialog(null,"用户" + regt.name + "注册成功, " + "\n");
			 regtSuccess = true;
			fo.close();
			oos.close();
		}
	 }
	  catch(ClassNotFoundException e){
    	 JOptionPane.showMessageDialog(null,"找不到用户文件'users.dat'!");
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
		          JOptionPane.showMessageDialog(null,"密码不正确，请重新输入！","密码不正确提示",JOptionPane.OK_OPTION);
		      	  break;
		         }
		         else{  
		       	       loginSuccess = true;
		         } 
		     }
		     else{
		       if(i == vuser.size()){
		    	   JOptionPane.showMessageDialog(null,"该用户名不存在，请先注册！","该用户不存在提示",JOptionPane.OK_OPTION);
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
       JOptionPane.showMessageDialog(null,"找不到用户文件'users.user'!");
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