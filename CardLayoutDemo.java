import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class CardLayoutDemo {
    static JFrame frm=new JFrame("卡片式布局设置管理器CardLayout");
	static JPanel pan1=new JPanel();     //创建面板对象
	static JPanel pan2=new JPanel();
	 public static void main(String[] args)
	{
		 frm.setLayout(null);                   //取消窗口的页面设置
		 pan2.setLayout(new GridLayout(1,4));    //将面板对象pan2设置为1行4列的网格式布局
		 CardLayout crd=new CardLayout (5,10);  //创建卡片式布局对象crd
		 pan1.setLayout(crd);                  //将面板pan1设置为卡片式布局方式
		 frm.setSize(350,300);
		 frm.setResizable(false);
		 pan1.setBounds(10,10,320,200);
		 pan2.setBounds(10,220,320, 25);
		 frm.add(pan1);    //将面板添加到窗口里
		 frm.add(pan2) ;
		 JLabel lab1=new JLabel("我是第一页", JLabel.CENTER);
		 JLabel lab2=new JLabel("我是第二页", JLabel.CENTER);
		 JTextField tex=new JTextField("卡片式布局策略CardLayout",18);
		 pan1.add(lab1, "c1");             //将标签组件lab1命名为c1后加入到面板pan1中
		 pan1.add(lab2, "c2");
		 pan1.add(tex, "t1");              //将文本框组件tex命名为t1后加入到面板pan1中
		 crd.show(pan1, "t1");             //将pan1中的tex组件显示在容器pan1中
		 pan2.add(new JButton("第一页"));
		 pan2.add(new JButton("上一页"));
		 pan2.add(new JButton("下一页"));
		 pan2.add(new JButton("最后页"));
		 frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frm.setVisible(true);
	}
}
