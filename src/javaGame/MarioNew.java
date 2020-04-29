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
//슈퍼마리오 게임 만들기
//벽넘어서는 못가게 조건문 넣기 (해결)
//구현해야할 기능 : 포물선 점프, 버섯 먹었을 때 변화값 주기
//버섯을 먹으면 커지기
//중간중간 캐릭터들이 날아다니게 하기
//맵 움직이기 (해결)
//맵 끝나면 다음 맵으로 이동?
import javaGame.MarioNew.MousePanel;

//구현 단계
//1. 맵을 뒤로 이동 시킬 수 있다. O
//
//1-1. 같은 맵을 무한반복 할 수 있다. O
//
//2. 맵과 함께 젤리를 뒤로 이동 시킬 수 있다. 
//
//3. 캐릭터가 점프하거나 누을 수 있다. O
//
//4. 캐릭터와 젤리가 만나면 젤리가 사라지게 할 수 있다.
//
//5. 체력게이지를 만들고, 게이지가 0이 되면 게임 오버가 되게 할 수 있다.
//
//6. 대기실 페이지, 스테이지 선택 페이지, 결과페이지를 만들 수 있다.
//
//7. 거대화를 할 수 있다.
//
//8. 가속화를 할 수 있다.
//
//9. 기타

//프레임, 패널, 메인 한 공간

public class MarioNew extends JFrame {

	//// 변수 ////
	MousePanel panel;
	int imgX = 0;
	int imgY = 120;
	int imgBgX = 0;
	int imgBgY = 0;
	int time = 60;
	int fieldY = 50;
	boolean spaceP = true; // 점프 변수

	//// 이미지 ////

	ImageIcon bg = new ImageIcon("img/BgForest.png");
	Image b = bg.getImage();

	ImageIcon land = new ImageIcon("img/BgForest_1.png");
	Image l = land.getImage();

	int b1 = 0;
	int b2 = b.getWidth(null); // 따라오는 이미지

	// 원본 캐릭터 이미지
	ImageIcon cookie = new ImageIcon("img/ch_fire.gif");
	Image c = cookie.getImage();

	// 다운 이미지
	ImageIcon cookie2 = new ImageIcon("img/ch_fire_down.gif");
	Image down = cookie2.getImage();

	// 점프 이미지
	ImageIcon cookieJump = new ImageIcon("img/ch_fire_jump.gif");
	Image cj = cookieJump.getImage();

	//// 생성자////
	public MarioNew() {

		panel = new MousePanel();
		setTitle("Cookie Run : Fire Stage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel); // MousePanel 붙이기
		setSize(970, 395); // 배경2번 크기 조정
		setVisible(true); // 보이게 하기
		setResizable(false); // 크기조정불가
	}

	//////////////////// repaint 전용 스레드 ////////////////////
	class MousePanel extends JPanel {
		public MousePanel() {
			// 옆으로
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

			/////////////////// 배경 무한 반복//////////////////////
			Thread re = new Thread(new Runnable() {
				@Override // 배경 캐릭터와 반대방향으로 옆으로 이동
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
			re.start();// 배경 무한 반복 끝

			//////////////////// 키이벤트(업, 다운) ///////////////////////
			this.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_SPACE && spaceP) { ///// 임시방법 (추후에 수정)
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

			g.drawImage(b, b1, 0, this); // 배경
			g.drawImage(b, b2, 0, this); // 뒤따라 오는 배경
			g.drawImage(l, 0, 0, 970, 380, this); // 땅 배경
			g.drawImage(c, imgX, imgY, 200, 200, this); // 캐릭터

		}

	}

///////////////////////// 점프 동작 구현 시작 /////////////////////////
	class Up {
		public Up() {
			new Thread(new Runnable() {
				@Override
				public void run() { //// 이 안에다가 이미지 교체

// 이미지교체
					if (c == cookie.getImage()) { // 원본이미지
						c = cookieJump.getImage(); // 다운이미지
					}

// 점프동작
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
	} // 점프동작 구현 끝

///////////////////////////////// 내리기 동작 구현 시작 /////////////////////////////////
	class Down {
		public Down() {
			new Thread(new Runnable() {

				@Override
				public void run() {
					if (c == cookie.getImage()) { // 원본이미지
						c = cookie2.getImage(); // 다운이미지
					}
				}
			}).start();
		}

	} // 내리기 동작 구현 끝

	public static void main(String[] args) {
		new MarioNew();
	}

}
