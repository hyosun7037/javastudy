package ch14;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EventEx06 extends JFrame {

	int imgX = 210;
	int imgY = 55;

	public EventEx06() {
		setTitle("장풍예제");
		setSize(700, 300);
		setLocationRelativeTo(null);
//		Container c = getContentPane(); 
		setContentPane(new MyPanel()); // panel 바꾸기
		setVisible(true);

	}

	// PaintComponent 함수는 JFrame 안에서 작동안함
	class MyPanel extends JPanel {

		public MyPanel() {
			setFocusable(true);
			this.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) { // 구현할 것만 적고, 나머지는 adapter에게 넘기기

					System.out.println("keycode : " + e.getKeyCode());
					System.out.println("keychar : " + e.getKeyChar());

					switch (e.getKeyCode()) {
					case KeyEvent.VK_LEFT: // 왼쪽 키를 클릭하면 작동
						imgX = imgX - 10;
						break; // break를 걸어야 다음 문장을 검사 X
					case KeyEvent.VK_RIGHT:
						imgX = imgX + 10;
						break;
					case KeyEvent.VK_SPACE:
						new Thread(new Runnable() {

							@Override
							public void run() {
								int time = 5;
								while (time > 0) {
									imgY = imgY + 20;
									time--;
									try {
										Thread.sleep(100); // 타임슬립주기
									} catch (Exception e1) {
										e1.printStackTrace();
									}
									repaint();
								}
							}
						}).start();
						break;
					}
					repaint();
				}
			});
		}

		@Override // 변경값을 여기다가 구현해야함
		public void paintComponent(Graphics g) { // 동적으로 바뀌고 싶으면 여기다가 그림 그리기
//			System.out.println("그림그리기");
			super.paintComponent(g);
			ImageIcon imgIce = new ImageIcon("img/ice.png"); // 이미지 아이콘 객체
			ImageIcon imgIce2 = new ImageIcon("img/ice2.png");

			// 이미지 추출

			Image Ice = imgIce.getImage();
			Image Ice2 = imgIce2.getImage();

			// g는 붓으로 그림그린다고 생각
			g.drawImage(Ice, 0, 0, null);
			g.drawImage(Ice2, imgX, imgY, null);
		}
	}

	public static void main(String[] args) {
		new EventEx06();
	}

}
