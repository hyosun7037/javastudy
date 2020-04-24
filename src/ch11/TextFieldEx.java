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
		setTitle("텍스트 에디터, 텍스트 박스 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		

		// 텍스트 필드 디자인
		tf.setFont(new Font("Arial", Font.BOLD, 30));
		// x, y //***모든 컴포넌트 크기 조정
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
	
	private void init() { //초기함수 - 여기서 다 new 하기  // GUI 제작시 실수 안하는 팁
		tf = new JTextField("", 20);
		ta = new JTextArea("", 5, 20);
		sp = new ScrollPane();
	}

	public static void main(String[] args) {
		new TextFieldEx();
	}

}
