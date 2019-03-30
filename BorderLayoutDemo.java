import javax.swing.*;
import java.awt.*;

public class BorderLayoutDemo extends JFrame {
	public BorderLayoutDemo() {
		this.setLayout(new BorderLayout(5, 5));
		this.add(new JButton("North"),BorderLayout.NORTH);
		this.add(new JButton("South"), BorderLayout.SOUTH);
		this.add(new JButton("East"), BorderLayout.EAST);
		this.add(new JButton("West"), BorderLayout.WEST);
		this.add(new JButton("Center"), BorderLayout.CENTER);
	}

	public static void main(String args[]) {
		BorderLayoutDemo frm = new BorderLayoutDemo();
		frm.setTitle("BorderLayout±ß¿ò²¼¾Ö");
		frm.setSize(400,300);
		frm.setVisible(true);
	}
}
