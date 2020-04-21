package ch14;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicDrawLineEx extends JFrame{
	private MyPanel3 panel = new MyPanel3();
	
	public GraphicDrawLineEx() {
		setTitle("drawLine 사용예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(200,170);
		setVisible(true);
	}
	
	class MyPanel3 extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.drawLine(20, 20, 100, 100);
		}
	}
	
	public static void main(String[] args) {
		new GraphicDrawLineEx();
	}

}
