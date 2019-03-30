import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class JPanelDemo extends JFrame {
	  public JPanelDemo( String title){
		  super(title);
	  }
	  public static void main(String args[]) {
		  JPanelDemo fr=new JPanelDemo("Two Panel≤‚ ‘");
		   JPanel pan1 = new JPanel();
		   JPanel pan2 = new JPanel();
		   fr.setLayout(null);      
		   fr.getContentPane().setBackground(Color.green);	
		   fr.setSize(250,250); 
		   pan1.setLayout(null);
		   pan1.setBackground(Color.red);
		   pan1.setSize(150,150);
		   pan2.setBackground(Color.yellow);
		   pan2.setSize(50,50);	
		   pan1.add(pan2);   
		   fr.getContentPane().add(pan1);  
		   fr.setVisible(true);
		 }
}
	  
