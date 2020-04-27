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
		setContentPane(panel); // MousePanel�� ���δ�
		setSize(800, 800); // ũ������
		setVisible(true); // ���δ�

	}

	class MousePanel extends JPanel {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(ic, imgX, imgY, this);


		}

		public MousePanel() {
			setLayout(null); // ���̾ƿ� ��
			this.addMouseListener(new MyMouseListener()); // ���콺������
			this.addMouseMotionListener(new MyMouseListener()); // ��Ǹ�����
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

		public void mouseDragged(MouseEvent e) { // �巡���Ͻ�
			imgX = e.getX() - (int) (ic.getWidth(panel) / 2);
			imgY = e.getY() - (int) (ic.getHeight(panel) / 2);
//			la.setLocation(x, y); // ��ġ ����
		
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