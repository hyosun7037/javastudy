package Ex;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

//20개의 10x10크기의 JLabel컴포넌트가 프레임 내 (50,50) 위치에서 (250,250)영역에서 랜덤한 위치에서 출력
//프레임 크기 300x300, JLabel 파란색
public class Ch09Prac06 extends JFrame {

	public Ch09Prac06() {
		super("Random Labels");
		Container c = getContentPane();
		c.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		for (int i = 0; i < 20; i++) {
			JLabel label = new JLabel(Integer.toString(i));
			label.setOpaque(true);
			label.setBackground(Color.blue);
			int x = (int)(Math.random()*200) + 50;
			int y = (int)(Math.random()*200) + 50;
			label.setLocation(x,y);
			label.setSize(10,10);
			c.add(label);
		}

		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ch09Prac06();
	}

}
