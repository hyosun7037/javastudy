package ch14;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.midi.Soundbank;
import javax.swing.JButton;
import javax.swing.JFrame;

public class EventEx02 extends JFrame implements ActionListener {

	EventEx02 ex02; // ���� ����

	public EventEx02() {
		setTitle("Action �̺�Ʈ ������ ����");
		// �̺�Ʈ �й� ������ ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JButton btn = new JButton("Action");
		// ������ ����
		btn.addActionListener(this); // �ȿ� Ÿ���� �־����
		c.add(btn);

		setSize(350, 150);
		setVisible(true); // paint()�Լ� ȣ��

	} // end of ������

	public static void main(String[] args) {
		new EventEx02();
	}

	@Override // Ÿ��(EventEx02�� ������ ����)
	public void actionPerformed(ActionEvent e) {
		System.out.println("��ưŬ����");
	}

}
