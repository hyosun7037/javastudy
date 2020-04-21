package ch14;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EventEx05 extends JFrame {

	private JLabel la; // ����! ����ٰ� new�� �ظ��ϸ� ���� ����!

	public EventEx05() {
		la = new JLabel("Hello");
		setTitle("MouseEvent ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �̺�Ʈ �й� ������ ���� ��
		Container c = getContentPane(); // �г� ��������
		c.addMouseListener(new MymouseListener()); // l�� �� �������̽�
		c.setLayout(null); // absolute ���̾ƿ�
		la.setSize(50, 20); // ���� ������
		la.setLocation(30, 30); // ���� ��ġ
		c.add(la);
		setSize(250, 250);
		setVisible(true);
	}

	class MymouseListener extends MouseAdapter { // �߻�޼��� ������ �� �ʹ� �����ϱ� ����ͷ� �ɷ��ֱ�

		// ���콺 ���� ȿ��
		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX(); // x��ǥ
			int y = e.getY(); // y��ǥ
			la.setLocation(x, y); // �� ��ġ ���� = repaint()
			// ����� �͸� �������̵� ��Ű��
			
			
			for (int i = 0; i < la.getY(); i++) {
				

			}
			repaint();
		}

	}

	public static void main(String[] args) {
		new EventEx05();
	}

}
