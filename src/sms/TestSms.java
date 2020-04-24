package sms;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
// 번호 입력하고, 내용입력하고, 전송버튼 누르면 문자가 전송되는 프로그램
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

		setTitle("문자메시지 보내기 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		ta = new JTextArea(7, 20);
		tf = new JTextField(20);

		c.add(new JLabel("번호"));
		c.add(tf);
		c.add(new JLabel("내용"));
		c.add(ta);
		sd = new JButton("전송");

		sd.addMouseListener(new Click()); // 클래스를 사용하는 방법

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
