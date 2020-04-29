package javaGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javaGame.*;
//���۸����� ���� �����
//���Ѿ�� ������ ���ǹ� �ֱ� (�ذ�)
//�����ؾ��� ��� : ������ ����, ���� �Ծ��� �� ��ȭ�� �ֱ�
//������ ������ Ŀ����
//�߰��߰� ĳ���͵��� ���ƴٴϰ� �ϱ�
//�� �����̱� (�ذ�)
//�� ������ ���� ������ �̵�?
import javaGame.MarioNew.MousePanel;

//���� �ܰ�
//1. ���� �ڷ� �̵� ��ų �� �ִ�. O
//
//1-1. ���� ���� ���ѹݺ� �� �� �ִ�. O
//
//2. �ʰ� �Բ� ������ �ڷ� �̵� ��ų �� �ִ�. 
//
//3. ĳ���Ͱ� �����ϰų� ���� �� �ִ�. O
//
//4. ĳ���Ϳ� ������ ������ ������ ������� �� �� �ִ�.
//
//5. ü�°������� �����, �������� 0�� �Ǹ� ���� ������ �ǰ� �� �� �ִ�.
//
//6. ���� ������, �������� ���� ������, ����������� ���� �� �ִ�.
//
//7. �Ŵ�ȭ�� �� �� �ִ�.
//
//8. ����ȭ�� �� �� �ִ�.
//
//9. ��Ÿ

//������, �г�, ���� �� ����

public class MarioNew extends JFrame {

	//// ���� ////
	MousePanel panel;
	int imgX = 0;
	int imgY = 120;
	int imgBgX = 0;
	int imgBgY = 0;
	int time = 60;
	int fieldY = 50;
	boolean spaceP = true; // ���� ����

	//// �̹��� ////

	ImageIcon bg = new ImageIcon("img/BgForest.png");
	Image b = bg.getImage();

	ImageIcon land = new ImageIcon("img/BgForest_1.png");
	Image l = land.getImage();

	int b1 = 0;
	int b2 = b.getWidth(null); // ������� �̹���

	// ���� ĳ���� �̹���
	ImageIcon cookie = new ImageIcon("img/ch_fire.gif");
	Image c = cookie.getImage();

	// �ٿ� �̹���
	ImageIcon cookie2 = new ImageIcon("img/ch_fire_down.gif");
	Image down = cookie2.getImage();

	// ���� �̹���
	ImageIcon cookieJump = new ImageIcon("img/ch_fire_jump.gif");
	Image cj = cookieJump.getImage();

	//// ������////
	public MarioNew() {

		panel = new MousePanel();
		setTitle("Cookie Run : Fire Stage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel); // MousePanel ���̱�
		setSize(970, 395); // ���2�� ũ�� ����
		setVisible(true); // ���̰� �ϱ�
		setResizable(false); // ũ�������Ұ�
	}

	//////////////////// repaint ���� ������ ////////////////////
	class MousePanel extends JPanel {
		public MousePanel() {
			// ������
			setFocusable(true);
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

			/////////////////// ��� ���� �ݺ�//////////////////////
			Thread re = new Thread(new Runnable() {
				@Override // ��� ĳ���Ϳ� �ݴ�������� ������ �̵�
				public void run() {
					while (true) {
						b1 = b1 - 5;
						b2 = b2 - 5;

						if (b1 < -(b.getWidth(null))) {
							b1 = b.getWidth(null) - 5;
						}
						if (b2 < -(b.getWidth(null))) {
							b2 = b.getWidth(null) - 5;
						}
						repaint();
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			});
			re.start();// ��� ���� �ݺ� ��

			//////////////////// Ű�̺�Ʈ(��, �ٿ�) ///////////////////////
			this.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_SPACE && spaceP) { ///// �ӽù�� (���Ŀ� ����)
						spaceP = false;
						new Up();
					}
					if (e.getKeyCode() == KeyEvent.VK_DOWN) {
						new Down();
					}
				}

				@Override
				public void keyReleased(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_SPACE) {
						c = cookie.getImage();
					}
					if (e.getKeyCode() == KeyEvent.VK_DOWN) {
						c = cookie.getImage();
					}
				}
			});
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.drawImage(b, b1, 0, this); // ���
			g.drawImage(b, b2, 0, this); // �ڵ��� ���� ���
			g.drawImage(l, 0, 0, 970, 380, this); // �� ���
			g.drawImage(c, imgX, imgY, 200, 200, this); // ĳ����

		}

	}

///////////////////////// ���� ���� ���� ���� /////////////////////////
	class Up {
		public Up() {
			new Thread(new Runnable() {
				@Override
				public void run() { //// �� �ȿ��ٰ� �̹��� ��ü

// �̹�����ü
					if (c == cookie.getImage()) { // �����̹���
						c = cookieJump.getImage(); // �ٿ��̹���
					}

// ��������
					while (time > 0) {
						if (time > 30) {
							imgY = imgY - 5;
						} else {
							imgY = imgY + 5;
						}
						time--;
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					time = 60;
					spaceP = true;
				}

			}).start();
		}
	} // �������� ���� ��

///////////////////////////////// ������ ���� ���� ���� /////////////////////////////////
	class Down {
		public Down() {
			new Thread(new Runnable() {

				@Override
				public void run() {
					if (c == cookie.getImage()) { // �����̹���
						c = cookie2.getImage(); // �ٿ��̹���
					}
				}
			}).start();
		}

	} // ������ ���� ���� ��

	public static void main(String[] args) {
		new MarioNew();
	}

}
