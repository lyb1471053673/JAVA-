import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
public class JRadioButtonAndJCheckboxDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frm=new JFrame("��ѡ��͵�ѡ��ť��ѡȡ��");
		JCheckBox jchk1=new JCheckBox("����",true);  //������ѡ��jchk1����ʼ״̬Ϊѡ��
		JCheckBox jchk2=new JCheckBox("б��");
		JCheckBox jchk3=new JCheckBox("�»���");
		JRadioButton jrb1=new JRadioButton("��ɫ");
		JRadioButton jrb2=new JRadioButton("��ɫ", true);  //������ѡ��ťjrb2��ʼ״̬ѡ��
		JRadioButton jrb3=new JRadioButton("��ɫ");
	    ButtonGroup grp=new ButtonGroup();     //����һ����ѡ��ť�����
	    frm.setLocation(200,150);
	    frm.setSize(300,220);
	    frm.setLayout(null);               //ȡ��ҳ������
	    jchk1.setBounds(20,20,150,20);     //���ø�ѡ��jchk1��λ�úʹ�С
	    jchk2.setBounds(20,40,150,20);
	    jchk3.setBounds(20,60,150,20);
	    jrb1.setBounds(20,80,150,20);       //���õ�ѡ��ťjrb1��λ�úʹ�С
	    jrb2.setBounds(20,100,150,20);
	    jrb3.setBounds(20,120,150,20);
	    grp.add(jrb1);            //��jrb1���뵽��ѡ��ť��grp��ʹ֮��Ϊ��ѡ��ť
	    grp.add(jrb2);
	    grp.add(jrb3);
	    frm.add(jchk1);          //����ѡ��jchk1���봰��frm��
	    frm.add(jchk2);
	    frm.add(jchk3);
	    frm.add(jrb1);            //����ѡ��ťjrb1���봰��frm��
	    frm.add(jrb2);
	    frm.add(jrb3);
	    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frm.setVisible(true);
	}
}
