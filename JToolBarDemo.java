import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JToolBarDemo extends JFrame implements ActionListener{  
   private JButton red,green,yellow;
   private JToolBar toolBar;
   private Container c;
   public JToolBarDemo(){  
      super ("JToolBar  Demo");
     c=this.getContentPane();
      c.setBackground(Color.white); 
      toolBar = new JToolBar();
      red = new JButton("红色");
      red.addActionListener(this);
      green = new JButton("绿色");
      green.setToolTipText("绿色");
      green.addActionListener(this);
      yellow = new JButton("黄色");
      yellow.setToolTipText("黄色");
      yellow.addActionListener(this);
      toolBar.add(red);
      toolBar.add(green);
      toolBar.add(yellow);
      this.add(toolBar, BorderLayout.NORTH);
      this.setSize(250,200);  
      this.setVisible(true); 
   }
   public void actionPerformed(ActionEvent e){ 
      if ( e.getSource() ==red )
         c.setBackground(Color.red);
      if ( e.getSource() == green )
         c.setBackground(Color.green);
      if ( e.getSource() == yellow )
         c.setBackground(Color.yellow);
   }
   public static void main(String[] args){  
      new JToolBarDemo(); 
       
   }
}
