

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
		
		cle.setTitle("CardLayout����");
		
		cle.setLayout(null);
		
		cle.setBounds(100, 100, 300, 500);
		
		JPanel jp1=new JPanel();
		//���忨��ʽ����
		CardLayout cl=new CardLayout();
		
		jp1.setLayout(cl);
		jp1.setBounds(10, 10, 250, 350);
		JLabel jl1=new JLabel("���ǵ�һҳ",JLabel.CENTER);
		JLabel jl2=new JLabel("���ǵڶ�ҳ",JLabel.CENTER);
		jp1.add(jl1,"c1");
		jp1.add(jl2,"c2");
		cl.show(jp1,"c2");//������ʾ��һ�ſ�Ƭ
		
		
		
		
		
		JPanel jp2=new JPanel();
		GridLayout gl=new GridLayout(1,4);
		jp2.setLayout(gl);
		jp2.setBounds(10,380,250,100);
		JButton jb1=new JButton("��һҳ");
		JButton jb2=new JButton("��һҳ");
		JButton jb3=new JButton("��һҳ");
		JButton jb4=new JButton("���ҳ");
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
