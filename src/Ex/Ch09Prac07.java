package Ex;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ch09Prac07 extends JFrame {
	public Ch09Prac07() {

		setTitle("계산기 프레임");
		Container c = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		c.add(new SouthPanel(), BorderLayout.SOUTH);
		c.add(new CenterPanel(), BorderLayout.CENTER);
		c.add(new NorthPanel(), BorderLayout.NORTH);

//		c.setLayout(new GridLayout(4, 3));
//
//		JButton[] btn = new JButton[12];
//
//		for (int i = 0; i < btn.length; i++) {
//			btn[i] = new JButton(Integer.toString(i));
//			c.add(btn[i]);
//		}
//
//		JLabel[] label = {};

		setLocationRelativeTo(null);
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ch09Prac07();
	}

}

class SouthPanel extends JPanel {
	public SouthPanel() {
		setBackground(Color.yellow);
		setOpaque(true);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(new JLabel("계산결과"));
		add(new JTextField(15));
	}
}

class CenterPanel extends JPanel {
	JButton btn[] = { new JButton("+"), new JButton("-"), new JButton("x"), new JButton("/") };

	public CenterPanel() {
		setBackground(Color.white);
		setLayout(new GridLayout(4, 4, 5, 5));
		for (int i = 0; i < btn.length; i++) {
			JButton btn = new JButton(Integer.toString(i));
			add(btn);
		}
		add(new JButton("CE"));
		add(new JButton("계산"));

		for (int i = 0; i < btn.length; i++) {
			btn[i].setBackground(Color.cyan);
			add(btn[i]);
		}

	}
}

class NorthPanel extends JPanel {
	public NorthPanel() {
		setBackground(Color.LIGHT_GRAY);
		setOpaque(true);
		setLayout(new FlowLayout());
		add(new JLabel("수식입력"));
		add(new JTextField(16));
	}
}
