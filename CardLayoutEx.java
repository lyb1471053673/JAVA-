

import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardLayoutEx  extends JFrame {

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CardLayoutEx cle=new CardLayoutEx();
		
		cle.setTitle("CardLayout布局");
		
		cle.setLayout(null);
		
		cle.setBounds(100, 100, 300, 500);
		
		JPanel jp1=new JPanel();
		//定义卡布式布局
		CardLayout cl=new CardLayout();
		
		jp1.setLayout(cl);
		jp1.setBounds(10, 10, 250, 350);
		JLabel jl1=new JLabel("我是第一页",JLabel.CENTER);
		JLabel jl2=new JLabel("我是第二页",JLabel.CENTER);
		jp1.add(jl1,"c1");
		jp1.add(jl2,"c2");
		cl.show(jp1,"c2");//用于显示哪一张卡片
		
		
		
		
		
		JPanel jp2=new JPanel();
		GridLayout gl=new GridLayout(1,4);
		jp2.setLayout(gl);
		jp2.setBounds(10,380,250,100);
		JButton jb1=new JButton("第一页");
		JButton jb2=new JButton("上一页");
		JButton jb3=new JButton("下一页");
		JButton jb4=new JButton("最后页");
		jp2.add(jb1);
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		
		
		
		cle.add(jp1);
		cle.add(jp2);
		
		cle.setVisible(true);
		cle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
