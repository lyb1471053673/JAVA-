import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
public class FlowLayoutDemo extends JFrame{
	  public FlowLayoutDemo() {
		    setLayout(new FlowLayout());
		    setFont(new Font("Helvetica", Font.PLAIN, 14));
		    getContentPane().add(new JButton("1"));
		    getContentPane().add(new JButton("2"));
		    getContentPane().add(new JButton("3"));
		    getContentPane().add(new JButton("4"));
		    getContentPane().add(new JButton("5"));
		    getContentPane().add(new JButton("6"));
		    getContentPane().add(new JButton("7"));
		    getContentPane().add(new JButton("8"));
		    getContentPane().add(new JButton("9"));
	  }
	public static void main(String[] args) {
	    FlowLayoutDemo jf = new FlowLayoutDemo();
	    jf.setTitle("流式布局实例");
	    jf.setSize(180,180);
	    jf.setVisible(true);
	}
}
