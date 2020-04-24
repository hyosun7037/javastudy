package ch11;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LabelEx extends JFrame {

	public LabelEx() {
		setTitle("���̺� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		// ���ڿ� ���̺� ����
		JLabel textLabel = new JLabel("����մϴ�.");

		// �̹��� ���̺� ����
		ImageIcon beauty = new ImageIcon("img/beauty.jpg");
		JLabel imageLabel = new JLabel(beauty);

		// ���ڿ��� �̹����� ��� ���� ���̺� ����
		ImageIcon normalIcon = new ImageIcon("img/normalIcon.gif");
		JLabel label = new JLabel("��������� ��ȭ�ϼ���", normalIcon, SwingConstants.CENTER);

		// ����Ʈ�ҿ� 3���� ���̺� ����
		c.add(textLabel);
		c.add(imageLabel);
		c.add(label);
		JButton btn = new JButton("Ŭ��");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				beauty.setImage(normalIcon.getImage());
				repaint();
			}
		});
		
		setSize(400, 600);
		setVisible(true);
	}

	public static void main(String[] args) {
		new LabelEx();
	}

}
