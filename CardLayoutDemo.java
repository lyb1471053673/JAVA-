import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class CardLayoutDemo {
    static JFrame frm=new JFrame("��Ƭʽ�������ù�����CardLayout");
	static JPanel pan1=new JPanel();     //����������
	static JPanel pan2=new JPanel();
	 public static void main(String[] args)
	{
		 frm.setLayout(null);                   //ȡ�����ڵ�ҳ������
		 pan2.setLayout(new GridLayout(1,4));    //��������pan2����Ϊ1��4�е�����ʽ����
		 CardLayout crd=new CardLayout (5,10);  //������Ƭʽ���ֶ���crd
		 pan1.setLayout(crd);                  //�����pan1����Ϊ��Ƭʽ���ַ�ʽ
		 frm.setSize(350,300);
		 frm.setResizable(false);
		 pan1.setBounds(10,10,320,200);
		 pan2.setBounds(10,220,320, 25);
		 frm.add(pan1);    //�������ӵ�������
		 frm.add(pan2) ;
		 JLabel lab1=new JLabel("���ǵ�һҳ", JLabel.CENTER);
		 JLabel lab2=new JLabel("���ǵڶ�ҳ", JLabel.CENTER);
		 JTextField tex=new JTextField("��Ƭʽ���ֲ���CardLayout",18);
		 pan1.add(lab1, "c1");             //����ǩ���lab1����Ϊc1����뵽���pan1��
		 pan1.add(lab2, "c2");
		 pan1.add(tex, "t1");              //���ı������tex����Ϊt1����뵽���pan1��
		 crd.show(pan1, "t1");             //��pan1�е�tex�����ʾ������pan1��
		 pan2.add(new JButton("��һҳ"));
		 pan2.add(new JButton("��һҳ"));
		 pan2.add(new JButton("��һҳ"));
		 pan2.add(new JButton("���ҳ"));
		 frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frm.setVisible(true);
	}
}
