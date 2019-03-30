import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
public class JRadioButtonAndJCheckboxDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frm=new JFrame("复选框和单选按钮组选取框");
		JCheckBox jchk1=new JCheckBox("粗体",true);  //创建复选框jchk1，初始状态为选中
		JCheckBox jchk2=new JCheckBox("斜体");
		JCheckBox jchk3=new JCheckBox("下划线");
		JRadioButton jrb1=new JRadioButton("红色");
		JRadioButton jrb2=new JRadioButton("绿色", true);  //创建单选按钮jrb2初始状态选中
		JRadioButton jrb3=new JRadioButton("蓝色");
	    ButtonGroup grp=new ButtonGroup();     //创建一个单选按钮组对象
	    frm.setLocation(200,150);
	    frm.setSize(300,220);
	    frm.setLayout(null);               //取消页面设置
	    jchk1.setBounds(20,20,150,20);     //设置复选框jchk1的位置和大小
	    jchk2.setBounds(20,40,150,20);
	    jchk3.setBounds(20,60,150,20);
	    jrb1.setBounds(20,80,150,20);       //设置单选按钮jrb1的位置和大小
	    jrb2.setBounds(20,100,150,20);
	    jrb3.setBounds(20,120,150,20);
	    grp.add(jrb1);            //将jrb1加入到单选按钮组grp中使之成为单选按钮
	    grp.add(jrb2);
	    grp.add(jrb3);
	    frm.add(jchk1);          //将复选框jchk1加入窗口frm中
	    frm.add(jchk2);
	    frm.add(jchk3);
	    frm.add(jrb1);            //将单选按钮jrb1加入窗口frm中
	    frm.add(jrb2);
	    frm.add(jrb3);
	    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frm.setVisible(true);
	}
}
