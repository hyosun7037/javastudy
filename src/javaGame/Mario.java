//package javaGame;
//
//import java.awt.Graphics;
//import java.awt.Image;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
////���۸�����
////���Ѿ�� ������ ���ǹ� �ֱ�
////�����ؾ��� ��� : ������ ����, ���� �Ծ��� �� ��ȭ�� �ֱ�
////������ ������ Ŀ����
//public class Mario extends JFrame {
//
//	MousePanel panel; // ���پ��Ŵ� �� �������� ������!
//	int imgX = 50;
//	int imgY = 800;
//
//	int fieldY = 787;
//	boolean spaceP = true;
//
//	ImageIcon bg = new ImageIcon("img/game_bg.jpg");
//	Image b = bg.getImage();
//
//	ImageIcon mario = new ImageIcon("img/ch1.png");
//	Image ma = mario.getImage(); // �̹��� ��������
//
//	//// ������////
//	public Mario() {
//		panel = new MousePanel();
//		setContentPane(panel); // MousePanel ���̱�
//		setSize(1673, 1046); // ũ�� ����
//		setVisible(true); // ���̰� �ϱ�
//	}
//
//	//// �׸��׸���////
//	class MousePanel extends JPanel implements Runnable {
//
//		public MousePanel() { // ������
//			setFocusable(true);
//			Thread re = new Thread(new Runnable() {
//				
//				@Override
//				public void run() {
//					while(true) {
//						repaint();
//						try {
//							Thread.sleep(10);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//					}
//				}
//			});
//			re.start();
//			this.addKeyListener(new KeyAdapter() {
//
//				@Override
//				public void keyPressed(KeyEvent e) {
//					if (imgY + b.getHeight(null) > fieldY) {
//						imgY = fieldY;
//					}
//					if (imgX > 0) {
//						switch (e.getKeyCode()) {
//						case KeyEvent.VK_LEFT:
//							imgX = imgX - 10;
//							break;
//						case KeyEvent.VK_RIGHT:
//							imgX = imgX + 10;
//							break;
//						case KeyEvent.VK_DOWN:
//							imgY = imgY + 10;
//							break;
//						case KeyEvent.VK_SPACE:
//
//							if (spaceP) {
//								new Thread(new Runnable() {
//
//									@Override
//									public void run() {
//										spaceP = false;
//
//										int time = 60;
//										while (time > 0) {
//											if (time > 30) {
//												imgY = imgY - 5;
//											} else {
//												imgY = imgY + 5;
//											}
//
//											time--;
//
//											try {
//												Thread.sleep(10);
//											} catch (Exception e) {
//												e.printStackTrace();
//											}
//											
//										}
//
//										spaceP = true;
//									}
//								}).start();// ������ ��
//							}
//
//							break;
//						}
//					} else {
//						imgX = 1;
//					}
////					repaint();
//				}
//
//				@Override
//				public void keyReleased(KeyEvent e) {
//
//					super.keyReleased(e);
//				}
//			});
//		}
//
//		@Override
//		protected void paintComponent(Graphics g) {
//			super.paintComponent(g);
//
//			g.drawImage(b, 0, 0, null);
//			g.drawImage(ma, imgX, imgY, this);
//
//		}
//
//		@Override
//		public void run() {
//			// TODO Auto-generated method stub
//
//		}
//
//	}
//
//	public static void main(String[] args) {
//		new Mario();
//	}
//
//}
