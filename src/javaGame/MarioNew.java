package javaGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

//���۸����� ���� �����
//���Ѿ�� ������ ���ǹ� �ֱ� (�ذ�)
//�����ؾ��� ��� : ������ ����, ���� �Ծ��� �� ��ȭ�� �ֱ�
//������ ������ Ŀ����
//�߰��߰� ĳ���͵��� ���ƴٴϰ� �ϱ�
//�� �����̱� (�ذ�)
//�� ������ ���� ������ �̵�?
public class MarioNew extends JFrame {

	MousePanel panel; // ���پ��Ŵ� �� �������� ������!
//	int imgX = 50;
//	int imgY = 870; //1�����

	int imgX = 50;
	int imgY = 180;

	int imgBgX = 0;
	int imgBgY = 0;

	int fieldY = 900;
	boolean spaceP = true;

	ImageIcon bg = new ImageIcon("img/game_bg2.png");
	Image b = bg.getImage();

	ImageIcon mario = new ImageIcon("img/ch1.png");
	Image ma = mario.getImage(); // �̹��� ��������

	//// ������////
	public MarioNew() {
		panel = new MousePanel();
		setTitle("���۸����� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setContentPane(panel); // MousePanel ���̱�
//		setSize(1673, 1046); // ���1�� ũ�� ����
		setSize(700, 295); // ���2�� ũ�� ����
		setVisible(true); // ���̰� �ϱ�
	}

	//// �׸��׸���////
	class MousePanel extends JPanel implements Runnable {

		public MousePanel() { // ������
			setFocusable(true);
			Thread re = new Thread(new Runnable() {

				@Override // ��� ĳ���Ϳ� �ݴ�������� ������ �̵�
				public void run() {

					int time = 30;
					while (time > 0) {
						imgBgX = imgBgX - 7;
						time++; // ++�������� ��
						if (time < 0) {
							imgBgX = imgBgX - 7;
							time--;
							////////////// ������� ��� �ݺ��� �����ϱ�///////////////
						}

						try {
							Thread.sleep(100); // Ÿ�ӽ����ֱ�
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						repaint();
					}
				}
			});
			re.start();

			this.addKeyListener(new KeyAdapter() {

				@Override
				public void keyPressed(KeyEvent e) {
					if (imgY + b.getHeight(null) > fieldY) {
						imgY = fieldY;

					}
					if (imgX > 0) {
						switch (e.getKeyCode()) {
						case KeyEvent.VK_LEFT:
							imgX = imgX - 10;
							break;
						case KeyEvent.VK_RIGHT:
							imgX = imgX + 10;
							break;
						case KeyEvent.VK_DOWN:
							imgY = imgY + 10;
							break;
						case KeyEvent.VK_SPACE:

							if (spaceP) {
								new Thread(new Runnable() {

									@Override
									public void run() {
										spaceP = false;

										int time = 60;
										while (time > 0) {
											if (time > 30) {
												imgY = imgY - 3;
											} else {
												imgY = imgY + 3;
											}
											time--;

											try {
												Thread.sleep(10);
											} catch (Exception e) {
												e.printStackTrace();
											}

										}

										spaceP = true;
									}
								}).start();// ������ ��
							}

							break;
						}
					} else {
						imgX = 1;
					}
//					repaint();
				}

				@Override
				public void keyReleased(KeyEvent e) {

					super.keyReleased(e);
				}
			});
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.drawImage(b, imgBgX, imgBgY, null);
//			g.drawImage(ma, imgX, imgY, 60, 70, this); 1�� ���
			g.drawImage(ma, imgX, imgY, 30, 45, this);

		}

		@Override
		public void run() {
			// TODO Auto-generated method stub

		}

	}

	public static void main(String[] args) {
		new MarioNew();
	}

}
