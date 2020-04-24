package ch11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextFieldEx extends JFrame {

	private JTextField tf;
	private JTextArea ta;
	private ScrollPane sp;
	
	public TextFieldEx() {
		init();
		setTitle("�ؽ�Ʈ ������, �ؽ�Ʈ �ڽ� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		

		// �ؽ�Ʈ �ʵ� ������
		tf.setFont(new Font("Arial", Font.BOLD, 30));
		// x, y //***��� ������Ʈ ũ�� ����
		tf.setPreferredSize(new Dimension(100, 100));

		
		
		ta.setBackground(Color.ORANGE);
//		ta.setEnabled(false);
		ta.setForeground(Color.BLACK);
		
		sp.add(ta);
		
		tf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String value = tf.getText();
					ta.append(value + "\n"); 
					tf.setText("");
					
				}
//				String value = tf.getText();
//				ta.setText(value);
			}
		});
		c.add(tf, BorderLayout.SOUTH);
		c.add(sp, BorderLayout.CENTER);

		setSize(400, 500);
		setVisible(true);
	}
	
	private void init() { //�ʱ��Լ� - ���⼭ �� new �ϱ�  // GUI ���۽� �Ǽ� ���ϴ� ��
		tf = new JTextField("", 20);
		ta = new JTextArea("", 5, 20);
		sp = new ScrollPane();
	}

	public static void main(String[] args) {
		new TextFieldEx();
	}

}
