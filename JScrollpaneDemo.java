import javax.swing.*;
public class JScrollpaneDemo extends JFrame{
   JScrollPane scrollPane;
   public JScrollpaneDemo(String title){
      super(title);
      JLabel label=new JLabel(new ImageIcon("flower.jpg"));
      scrollPane=new JScrollPane(label,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);         
      this.add(scrollPane);
      this.setSize(350,300);
      this.setVisible(true);
   }
   public static void main(String[] args){
      new JScrollpaneDemo("JScrollpaneDemo");
   }
}
