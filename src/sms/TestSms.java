package sms;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
// ��ȣ �Է��ϰ�, �����Է��ϰ�, ���۹�ư ������ ���ڰ� ���۵Ǵ� ���α׷�
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TestSms extends JFrame {

	private JTextArea ta;
	private JTextField tf;
	private JButton sd;

	class Click extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			new ExampleSend(tf.getText(),ta.getText());
		}
	}

	public TestSms() {

		setTitle("���ڸ޽��� ������ ���α׷�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		ta = new JTextArea(7, 20);
		tf = new JTextField(20);

		c.add(new JLabel("��ȣ"));
		c.add(tf);
		c.add(new JLabel("����"));
		c.add(ta);
		sd = new JButton("����");

		sd.addMouseListener(new Click()); // Ŭ������ ����ϴ� ���

		c.add(sd);

		setSize(300, 300);
		setVisible(true);
		
		
		
//		(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				new ExampleSend(tf.getText(), ta.getText());
//			}
//		}

	}

	public static void main(String[] args) {
		new TestSms();

	}

}
