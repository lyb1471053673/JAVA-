
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class KeyEvent_Example extends JFrame { // �̳д�����JFrame
	public static void main(String args[]) {
		KeyEvent_Example frame = new KeyEvent_Example();
		frame.setVisible(true); // ���ô���ɼ���Ĭ��Ϊ���ɼ�
	}

	public KeyEvent_Example() {
		super(); // �̳и���Ĺ��췽��
		setTitle("�����¼�ʾ��"); // ���ô���ı���
		setBounds(100, 100, 500, 375); // ���ô������ʾλ�ü���С
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���ô���رհ�ť�Ķ���Ϊ�˳�

		final JLabel label = new JLabel();
		label.setText("��ע��");
		getContentPane().add(label, BorderLayout.WEST);

		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		JTextArea textArea = new JTextArea();
		textArea.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				String keyText = KeyEvent.getKeyText(e.getKeyCode());
				if (e.isActionKey())
					System.out.println("�����µ��Ƕ�������" + keyText + "��");
				else {
					System.out.println("�����µ��ǷǶ�������" + keyText + "��");
					char keyChar = e.getKeyChar();
					switch (keyChar) {
					case KeyEvent.VK_CONTROL:
						System.out.println("Ctrl��������");
						break;
					case KeyEvent.VK_ALT:
						System.out.println("Alt��������");
						break;
					case KeyEvent.VK_SHIFT:
						System.out.println("Shift��������");
						break;
					}
				}
			}

			public void keyTyped(KeyEvent e) {
				System.out.println("�˴�������ǡ�" + e.getKeyChar() + "��");
			}

			public void keyReleased(KeyEvent e) {
				String keyText = KeyEvent.getKeyText(e.getKeyCode());
				System.out.println("���ͷŵ��ǡ�" + keyText + "����");
				System.out.println();
			}
		});
		textArea.setLineWrap(true);
		textArea.setRows(3);
		textArea.setColumns(15);
		scrollPane.setViewportView(textArea);

	}

}
