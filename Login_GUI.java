import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class Login_GUI {
	public static void main(String[] args) {
	     new LoginFrame();
	}
}
class LoginFrame extends JFrame {
	  private JPanel pan;
	  private JLabel namelabel, pwdlabel, titlelabel;
	  private JTextField namefield;
	  private JPasswordField pwdfield;
	  private JButton loginbtn, registerbtn, cancelbtn;
	  public LoginFrame() {
	   pan = new JPanel();
	   titlelabel = new JLabel("欢迎使用考试系统");
	   titlelabel.setFont(new Font("隶书", Font.BOLD, 24));
	   namelabel = new JLabel("用户名：");
	   pwdlabel = new JLabel("密    码：");
	   namefield = new JTextField(16);
	   pwdfield = new JPasswordField(16);
	   pwdfield.setEchoChar('*');
	   loginbtn = new JButton("登录");
	   registerbtn = new JButton("注册");
	   cancelbtn = new JButton("取消");
	   pan.add(titlelabel);
	   pan.add(namelabel);
	   pan.add(namefield);
	   pan.add(pwdlabel);
	   pan.add(pwdfield);
	   pan.add(loginbtn);
	   pan.add(registerbtn);
	   pan.add(cancelbtn);
	   this.add(pan);
	   this.setTitle("用户登录");
	   this.setSize(300, 200);
	   this.setLocationRelativeTo(null); // 设置窗体居中显示
	   this.setVisible(true);
	 }
	}

