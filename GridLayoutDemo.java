import javax.swing.*;
import java.awt.*;

public class GridLayoutDemo extends JFrame {
	JButton b1, b2;
	JPanel pan;
	public GridLayoutDemo() {
		b1 = new JButton("Button 6");
		b2 = new JButton("Button 7");
		pan = new JPanel();
		pan.add(b1);
		pan.add(b2);
		setLayout(new GridLayout(3, 2));
		this.add(new JButton("Button 1"));
		this.add(new JButton("Button 2"));
		this.add(new JButton("Button 3"));
		this.add(new JButton("Button 4"));
		this.add(new JButton("Button 5"));
		this.add(pan);
	}
	public static void main(String args[]) {
		GridLayoutDemo frm = new GridLayoutDemo();
		frm.setTitle("Íø¸ñ²¼¾Ö");
		frm.pack();
		frm.setVisible(true);
	}
}
