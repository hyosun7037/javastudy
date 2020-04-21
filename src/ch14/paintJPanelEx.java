package ch14;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class paintJPanelEx extends JFrame {
	private MyPanel1 panel = new MyPanel1();

	public paintJPanelEx() {
		setTitle("JPanel¿« paintComponent() øπ¡¶");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(250, 200);
		setVisible(true);
	}

	class MyPanel1 extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.blue);
			g.drawRect(10, 10, 50, 50);
			g.drawRect(50, 50, 50, 50);
			g.setColor(Color.MAGENTA);
			g.drawRect(90, 90, 50, 50);
		}

	}

	public static void main(String[] args) {
		new paintJPanelEx();
	}

}
