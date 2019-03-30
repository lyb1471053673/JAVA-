import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame myBasicJFrame=new JFrame();
		myBasicJFrame.setTitle("第一个JFrame窗口");
        myBasicJFrame.setBounds(0,0,300,300);
        Container contentPane=myBasicJFrame.getContentPane();
        contentPane.setBackground(Color.blue);
        JButton  jb=new JButton("我是一个按钮");
        myBasicJFrame.add(jb);
        myBasicJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myBasicJFrame.setVisible(true);
	}
}
