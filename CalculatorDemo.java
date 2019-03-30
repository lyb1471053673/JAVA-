

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorDemo   extends JFrame {
	
	 static JPanel jp1=new JPanel();
	 static JPanel jp2=new JPanel();
	 static JTextField jtf=new JTextField();
	 static JButton[] bt=new JButton[10];
	 static JButton ba,bb,bc,bd,be,bf;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      	CalculatorDemo jf=new CalculatorDemo();
		jf.setTitle("计算器");
		jf.setBounds(100,100,350,500);
		jf.setResizable(false);
		
		jf.setLayout(null);//将窗体的布局设置为空
		
		jp1.setBounds(20,10,300,50);
		jp1.setLayout(null);
		
		jp2.setBounds(20,70,300,400);
		GridLayout gl=new GridLayout(4,4);
		jp2.setLayout(gl);
		for(int i=0;i<10;i++){
			bt[i]=new JButton(""+i);
			jp2.add(bt[i]);
		}
		 ba=new JButton("+");
		 bb=new JButton("-");
		 bc=new JButton("*");
		 bd=new JButton("/");
		 be=new JButton("=");
		 bf=new JButton(".");
		 
		 jp2.add(ba);
		 jp2.add(bb);
		 jp2.add(bc);
		 jp2.add(bd);
		 jp2.add(be);
		 jp2.add(bf);
		 
		jtf.setBounds(0,0,300,100);
		jp1.add(jtf);
		
		
		jf.add(jp1);
		jf.add(jp2);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}
