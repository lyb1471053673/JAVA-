
import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FocusEvent_Example extends JFrame { // 继承窗体类JFrame

	private JTextField textField;

	public static void main(String args[]) {
		FocusEvent_Example frame = new FocusEvent_Example();
		frame.setVisible(true);
	}

	public FocusEvent_Example() {
		super();
		setTitle("焦点事件示例");
		setBounds(100, 100, 500, 375);
		getContentPane().setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JLabel label = new JLabel();
		label.setText("出生日期：");
		getContentPane().add(label);

		textField = new JTextField();
		textField.setColumns(10);
		textField.addFocusListener(new TextFieldFocus()); // 为文本框添加焦点监听器
		getContentPane().add(textField);

		final JButton button = new JButton();
		button.setText("确定");
		getContentPane().add(button);
	}

	class TextFieldFocus implements FocusListener {
		public void focusGained(FocusEvent e) {
			textField.setText("");
		}

		public void focusLost(FocusEvent e) {
			textField.setText("2018-8-8");
		}
	}

}
