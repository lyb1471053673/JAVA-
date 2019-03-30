
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ActionEvent_Example extends JFrame { // �̳д�����JFrame

	private JLabel label;// ����һ����ǩ����������ʾ��ʾ��Ϣ

	public static void main(String args[]) {
		ActionEvent_Example frame = new ActionEvent_Example();
		frame.setVisible(true);
	}

	public ActionEvent_Example() {
		super();
		setTitle("�����¼�ʾ��");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		label = new JLabel();
		label.setText("��ӭ��¼��");
		label.setHorizontalAlignment(JLabel.CENTER);
		getContentPane().add(label);

		final JButton submitButton = new JButton();
		submitButton.setText("��¼");
		submitButton.addActionListener(new ButtonAction()); // Ϊ��ť��Ӷ���������
		getContentPane().add(submitButton, BorderLayout.SOUTH);
	}

	class ButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource(); // ��ô����˴��¼��İ�ť����
			String buttonName = e.getActionCommand(); // ��ô����˴��¼��İ�ť�ı�ǩ�ı�
			if (buttonName.equals("��¼")) {
				label.setText("���Ѿ��ɹ���¼��"); // �޸ı�ǩ����ʾ��Ϣ
				button.setText("�˳�"); // �޸İ�ť�ı�ǩ�ı�
			} else {
				label.setText("���Ѿ���ȫ�˳���"); // �޸ı�ǩ����ʾ��Ϣ
				button.setText("��¼"); // �޸İ�ť�ı�ǩ�ı�
			}
		}
	}

}
