import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame myBasicJFrame=new JFrame();
		myBasicJFrame.setTitle("��һ��JFrame����");
        myBasicJFrame.setBounds(0,0,300,300);
        Container contentPane=myBasicJFrame.getContentPane();
        contentPane.setBackground(Color.blue);
        JButton  jb=new JButton("����һ����ť");
        myBasicJFrame.add(jb);
        myBasicJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myBasicJFrame.setVisible(true);
	}
}
