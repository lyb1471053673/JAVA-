import java.awt.Rectangle;
import javax.swing.*;
public class NullLayoutDemo extends JFrame {
  private JButton b1, b2, b3, b4, b5;
  NullLayoutDemo() {
  setLayout(null);
  setBounds(new Rectangle(400, 300, 410, 180));
  b1 = new JButton("Button 1");
  b2 = new JButton("Button 2");
  b3 = new JButton("Button 3");
  b4 = new JButton("Button 4");
  b5 = new JButton("Button 5");
  b1.setBounds(new Rectangle(10, 10, 85, 30));
  this.add(b1);
  b2.setBounds(new Rectangle(100, 40, 85, 30));
  this.add(b2);
  b3.setBounds(new Rectangle(190, 70, 85, 30));
  this.add(b3);
  b4.setBounds(new Rectangle(280, 100, 85, 30));
  this.add(b4);
 }
 public static void main(String args[]) {
   NullLayoutDemo frm = new NullLayoutDemo();
   frm.setTitle("NullLayoutDemo Application");
   frm.setVisible(true);
 }
}