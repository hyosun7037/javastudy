package Ex;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ch09Prac03 extends JFrame {
//GridLayout 활용 10개의 동일한 크기로 배치
	public Ch09Prac03() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(1,10));
		
		JButton[] btn = new JButton [10];
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new JButton(Integer.toString(i));
			c.add(btn[i]);
		}
		
		
		setSize(800, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ch09Prac03();
	}

}
