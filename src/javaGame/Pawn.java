package javaGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Pawn extends JFrame {
	MousePanel panel;
//	JLabel la;
	int imgX = 12;
	int imgY = 12;
	
	ImageIcon imgIce = new ImageIcon("img/icech.png");
	Image ic = imgIce.getImage();
	ImageIcon imgIce2 = new ImageIcon("img/ice.png");
	
	public Pawn() {
		panel = new MousePanel();
		setContentPane(panel); // MousePanel을 붙인다
		setSize(800, 800); // 크기조정
		setVisible(true); // 보인다

	}

	class MousePanel extends JPanel {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(ic, imgX, imgY, this);


		}

		public MousePanel() {
			setLayout(null); // 레이아웃 널
			this.addMouseListener(new MyMouseListener()); // 마우스리스너
			this.addMouseMotionListener(new MyMouseListener()); // 모션리스너
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					while (true) {
						repaint();
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
				}
			}).start();
		}
	}

	class MyMouseListener extends MouseAdapter{

		public void mouseDragged(MouseEvent e) { // 드래그일시
			imgX = e.getX() - (int) (ic.getWidth(panel) / 2);
			imgY = e.getY() - (int) (ic.getHeight(panel) / 2);
//			la.setLocation(x, y); // 위치 조정
		
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			if(ic == imgIce.getImage()) {
				ic = imgIce2.getImage();
			}else {
				ic = imgIce.getImage();
			}
		}
	}

	public static void main(String[] args) {
		new Pawn();
	}
}