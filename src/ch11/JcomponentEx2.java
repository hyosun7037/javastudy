package ch11;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JcomponentEx2 extends JFrame implements ActionListener {

	private JButton b1, b2, b3; // heap으로 관리해야 다른 곳에서도 사용가능

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		b.setText("Hello");
	}

	public JcomponentEx2() {
		Container c = getContentPane();
		c.setLayout(new FlowLayout()); // 원래 borderLayout인데 FlowLayout으로 바꿔줌

		b1 = new JButton("b1");
		b2 = new JButton("b2");
		b3 = new JButton("b3");

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		c.add(b1);
		c.add(b2);
		c.add(b3);
		
		setSize(260,200);
		setVisible(true);
		setLocationRelativeTo(null);
}

	public static void main(String[] args) {
		new JcomponentEx2();
	}

}
