package Ex;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

//20���� 10x10ũ���� JLabel������Ʈ�� ������ �� (50,50) ��ġ���� (250,250)�������� ������ ��ġ���� ���
//������ ũ�� 300x300, JLabel �Ķ���
public class Ch09Prac06 extends JFrame {

	public Ch09Prac06() {
		setTitle("Random Labels");
		Container c = getContentPane();
		c.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		for (int i = 0; i < 20; i++) {
			JLabel label = new JLabel(Integer.toString(i));
			label.setOpaque(true);
			label.setBackground(Color.blue);
		}

		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ch09Prac01();
	}

}
