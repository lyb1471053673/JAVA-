import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class JlabelDemo extends JFrame{
    private JlabelDemo(){
	 super("JLabelʾ��");
	}
	public static void main(String[] args) {
		JlabelDemo jf=new JlabelDemo();
	    JPanel pan = new JPanel();
	    JLabel lab1 = new JLabel("�ı���ǩ");
	    JButton btn = new JButton("��ť");
	    pan.add(lab1);
	    pan.add(btn);
	    jf.add(pan);
	    jf.setLocation(300, 300);
	    jf.setSize(250, 200);
	    jf.setResizable(false);
	    jf.setVisible(true);
	}
}
