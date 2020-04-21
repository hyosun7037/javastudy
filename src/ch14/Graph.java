package ch14;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graph extends JFrame {
	private MyPanel panel = new MyPanel();

	int panelX = 800;
	int panelY = 800;

	int a = 400;
	int b = 150;
	int c = 250;

	public Graph() {
		setTitle("그래프");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(panelX, panelY + 30);
		setVisible(true);
	}

	class MyPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			// 날짜
			g.setColor(Color.black);
			g.drawString("2019.10", (int) (panelX * 0.1), (int) (panelY * 0.9));
			g.drawString("2019.11", (int) (panelX * 0.4), (int) (panelY * 0.9));
			g.drawString("2019.12", (int) (panelX * 0.7), (int) (panelY * 0.9));
			// 사각형
			g.fillRect((int) (panelX * 0.1 + 5), (int) (panelY * 0.9 - 20) - a, 30, a);
			g.fillRect((int) (panelX * 0.4 + 5), (int) (panelY * 0.9 - 20) - b, 30, b);
			g.fillRect((int) (panelX * 0.7 + 5), (int) (panelY * 0.9 - 20) - c, 30, c);
			// 숫자
			g.drawString(Integer.toString(a / 10), (int) (panelX * 0.1 + 5), (int) (panelY * 0.9 - 30) - a);
			g.drawString(Integer.toString(b / 10), (int) (panelX * 0.4 + 5), (int) (panelY * 0.9 - 30) - b);
			g.drawString(Integer.toString(c / 10), (int) (panelX * 0.7 + 5), (int) (panelY * 0.9 - 30) - c);
		}
	}

	public static void main(String[] args) {
		new Graph();
	}
}