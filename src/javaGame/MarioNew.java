package javaGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

//슈퍼마리오 게임 만들기
//벽넘어서는 못가게 조건문 넣기 (해결)
//구현해야할 기능 : 포물선 점프, 버섯 먹었을 때 변화값 주기
//버섯을 먹으면 커지기
//중간중간 캐릭터들이 날아다니게 하기
//맵 움직이기 (해결)
//맵 끝나면 다음 맵으로 이동?
public class MarioNew extends JFrame {

	MousePanel panel; // 갖다쓸거는 다 전역으로 빼놓기!
//	int imgX = 50;
//	int imgY = 870; //1번배경

	int imgX = 50;
	int imgY = 180;

	int imgBgX = 0;
	int imgBgY = 0;

	int fieldY = 900;
	boolean spaceP = true;

	ImageIcon bg = new ImageIcon("img/game_bg2.png");
	Image b = bg.getImage();

	ImageIcon mario = new ImageIcon("img/ch1.png");
	Image ma = mario.getImage(); // 이미지 가져오기

	//// 생성자////
	public MarioNew() {
		panel = new MousePanel();
		setTitle("슈퍼마리오 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setContentPane(panel); // MousePanel 붙이기
//		setSize(1673, 1046); // 배경1번 크기 조정
		setSize(700, 295); // 배경2번 크기 조정
		setVisible(true); // 보이게 하기
	}

	//// 그림그리기////
	class MousePanel extends JPanel implements Runnable {

		public MousePanel() { // 옆으로
			setFocusable(true);
			Thread re = new Thread(new Runnable() {

				@Override // 배경 캐릭터와 반대방향으로 옆으로 이동
				public void run() {

					int time = 30;
					while (time > 0) {
						imgBgX = imgBgX - 7;
						time++; // ++무한으로 감
						if (time < 0) {
							imgBgX = imgBgX - 7;
							time--;
							////////////// 여기부터 배경 반복문 삽입하기///////////////
						}

						try {
							Thread.sleep(100); // 타임슬립주기
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
								}).start();// 스레드 끝
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
//			g.drawImage(ma, imgX, imgY, 60, 70, this); 1번 배경
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
