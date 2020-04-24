package ch11;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JcomponentEx extends JFrame {

	private JButton b1, b2, b3; // heap���� �����ؾ� �ٸ� �������� ��밡��

	public JcomponentEx() {
		Container c = getContentPane();
		c.setLayout(new FlowLayout()); // ���� borderLayout�ε� FlowLayout���� �ٲ���
		setTitle("Jcomponent�� ���� �޼ҵ� ����");

		b1 = new JButton("Magenta / Yellow Button");
		b2 = new JButton("	Disabled Button	");
		b3 = new JButton("getX(),getY()");

		b1.setBackground(Color.YELLOW);
		b2.setForeground(Color.MAGENTA);
		b3.setFont(new Font("Arial", Font.ITALIC, 20));

		b2.setEnabled(false); // ��ư ��Ȱ��ȭ

		b3.addActionListener(new ActionListener() {

			// Ÿ��(�ݹ�Ǵ�)
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				// Object�� �����ϱ� ������ JButton���� �ٿ�ĳ����
				// ���� Ŭ���Ǿ����� �𸣱� ������ �˾Ƽ� �ٿ�ĳ���� ������� --> �ش� ��ư�� ���� ����

				b.setText("Hello");
				// b3�� �˰��ֱ� ������ ���� �ּ����� ó������ �ʿ�� X

			}
		});
		c.add(b1);
		c.add(b2);
		c.add(b3);

		setVisible(true);
		setSize(260, 200);

	}

	public static void main(String[] args) {
		new JcomponentEx();
	}

}
