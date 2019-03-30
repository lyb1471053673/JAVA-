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
	   titlelabel = new JLabel("��ӭʹ�ÿ���ϵͳ");
	   titlelabel.setFont(new Font("����", Font.BOLD, 24));
	   namelabel = new JLabel("�û�����");
	   pwdlabel = new JLabel("��    �룺");
	   namefield = new JTextField(16);
	   pwdfield = new JPasswordField(16);
	   pwdfield.setEchoChar('*');
	   loginbtn = new JButton("��¼");
	   registerbtn = new JButton("ע��");
	   cancelbtn = new JButton("ȡ��");
	   pan.add(titlelabel);
	   pan.add(namelabel);
	   pan.add(namefield);
	   pan.add(pwdlabel);
	   pan.add(pwdfield);
	   pan.add(loginbtn);
	   pan.add(registerbtn);
	   pan.add(cancelbtn);
	   this.add(pan);
	   this.setTitle("�û���¼");
	   this.setSize(300, 200);
	   this.setLocationRelativeTo(null); // ���ô��������ʾ
	   this.setVisible(true);
	 }
	}

