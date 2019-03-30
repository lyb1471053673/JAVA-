import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class Login_GUI_Finally {
	public static void main(String[] args) {
	     new Login_panel("用户登录");
	}
}
class Login_panel extends JFrame {
    private JLabel namelabel,pwdlabel,titlelabel;
    private JTextField namefield;
    private JPasswordField pwdfield;
    private JButton loginbtn,registerbtn,cancelbtn;
    private JPanel panel1,panel2,panel3,panel21,panel22;
  	public Login_panel(String title){
	  this.setTitle(title);
	  titlelabel = new JLabel("欢迎使用考试系统");  	
	  titlelabel.setFont(new Font("隶书",Font.BOLD,24));
	  namelabel = new JLabel("用户名：");
	  pwdlabel = new JLabel("密    码：");
	  namefield = new JTextField(16);
	  pwdfield = new JPasswordField(16);
	  pwdfield.setEchoChar('*');
	  loginbtn = new JButton("登录");
      registerbtn = new JButton("注册");
      cancelbtn = new JButton("取消");
	  panel1 = new JPanel();
	  panel2 = new JPanel();
	  panel3 = new JPanel();
	  panel21 = new JPanel();
	  panel22 = new JPanel();
	 //添加组件，采用边框布局
      BorderLayout bl = new BorderLayout();
      setLayout(bl);
      panel1.add(titlelabel);
      panel21.add(namelabel);
      panel21.add(namefield);
      panel22.add(pwdlabel);
      panel22.add(pwdfield);
      panel2.add(panel21,BorderLayout.NORTH);
      panel2.add(panel22,BorderLayout.SOUTH);
      panel3.add(loginbtn);
      panel3.add(registerbtn);
      panel3.add(cancelbtn);
      add(panel1,BorderLayout.NORTH);
      add(panel2,BorderLayout.CENTER);
      add(panel3,BorderLayout.SOUTH);
      this.setBounds(400,200,300, 200);
      this.setVisible(true);
      
   }	
}
