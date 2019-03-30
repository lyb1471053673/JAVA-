
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ActionEvent_Example extends JFrame { // 继承窗体类JFrame

	private JLabel label;// 声明一个标签对象，用来显示提示信息

	public static void main(String args[]) {
		ActionEvent_Example frame = new ActionEvent_Example();
		frame.setVisible(true);
	}

	public ActionEvent_Example() {
		super();
		setTitle("动作事件示例");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		label = new JLabel();
		label.setText("欢迎登录！");
		label.setHorizontalAlignment(JLabel.CENTER);
		getContentPane().add(label);

		final JButton submitButton = new JButton();
		submitButton.setText("登录");
		submitButton.addActionListener(new ButtonAction()); // 为按钮添加动作监听器
		getContentPane().add(submitButton, BorderLayout.SOUTH);
	}

	class ButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource(); // 获得触发此次事件的按钮对象
			String buttonName = e.getActionCommand(); // 获得触发此次事件的按钮的标签文本
			if (buttonName.equals("登录")) {
				label.setText("您已经成功登录！"); // 修改标签的提示信息
				button.setText("退出"); // 修改按钮的标签文本
			} else {
				label.setText("您已经安全退出！"); // 修改标签的提示信息
				button.setText("登录"); // 修改按钮的标签文本
			}
		}
	}

}
