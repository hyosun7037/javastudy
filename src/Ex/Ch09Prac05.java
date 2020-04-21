package Ex;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

//GridLayout 활용, 4x4 바둑판 구성
public class Ch09Prac05 extends JFrame {

	public Ch09Prac05() {
		setTitle("2X2 Color Frame");
		Container c = getContentPane();
		
		c.setLayout(new GridLayout(2, 2));
		
		JButton[] btn = new JButton[4];
		Color[] color = { Color.white, Color.gray, Color.yellow, Color.green };

		for (int i = 0; i < color.length; i++) {
			btn[i] = new JButton(Integer.toString(i));
			c.add(btn[i]);
			btn[i].setBackground(color[i]);
		}

		setSize(400, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ch09Prac05();
	}

}
