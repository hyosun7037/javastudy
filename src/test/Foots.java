package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Foots{

	private JFrame frame;
	int field = 400; // 발판 높이

	int imgX = 0;
	int imgY = 5;
	// 1이면 발판이 있고 0이면 없다. ----> 발판 정보
	String fieldStr = "1111100111110100111011001011111111100000011111111111111111111";

	List<Foot> fieldList = new ArrayList<>(); // 발판 객체를 담을 리스트

	int count = 0; // 발판 확인 변수

	int nowField = field; // 캐릭터 높에에 따른 발판위치 조정 변수

	ImageIcon landIc = new ImageIcon("image/land.png");
	Image landimg = landIc.getImage();

	ImageIcon image = new ImageIcon("image/player_origin.gif");
	Image img = image.getImage();

	int doubleJump = 0;

	boolean fall = false; // 현재 떨어지는지 확인
	boolean jump = false; // 현재 점프중인지 확인

	// substring으로 발판 정보 검색
	static int getGround(String ground, int index) {
		return Integer.parseInt(ground.substring(index, index + 1));
	}

	class Mypanel extends JPanel {
		public Mypanel() {
			setFocusable(true);

			//발판 추가
			for (int i = 0; i < fieldStr.length(); i++) {
				int tempX = i * landimg.getWidth(null);
				if(getGround(fieldStr, i) == 1) {
					fieldList.add(new Foot(landimg, tempX, 400, landimg.getWidth(null), landimg.getHeight(null)));
				}
			}
			
			// repaint 전용 쓰래드
			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						repaint();
						try {
							Thread.sleep(10);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}).start();

			// 발판 좌표 이동 쓰레드
			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						for (int i = 0; i < fieldList.size(); i++) {
							fieldList.get(i).setX(fieldList.get(i).getX() - 4);
						}
						int range = (int) (landimg.getWidth(null) * 1.2); // 캐릭터가 서 있을 수 있는 위치
						for (int i = 0; i < fieldList.size(); i++) {
							if (fieldList.get(i).getX() >= 0 && fieldList.get(i).getX() < range) {
								count = 1;
								break;
							} else if (i == fieldList.size() - 1) {
								count = 0;
							}
						}
						try {
							Thread.sleep(10);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}).start();

			// 캐릭터의 높이에 따라 발판 위치를 지정하는 쓰레드
			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						int foot = imgY + img.getHeight(null);

						if (count == 0) {
							nowField = 2000;
						} else if (count == 1 && foot > field) {
							nowField = 2000;
						} else if (count == 1 && foot < field) {
							nowField = field;
						}
						try {
							Thread.sleep(10);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}).start();

			// 낙하스레드
			new Thread(new Runnable() {

				public void run() {
					while (true) {
						// 발바닥 위치는 이미지의 Y위치 + 이미지의 높이
						int foot = imgY + img.getHeight(null);

						// 발바닥이 땅보다 위에 있으면 작동 //jump == false && foot < field
						if (foot < nowField && jump == false && fall == false) { // 점프중 X, 공중에 있고, 떨어지는 중이 아닐 때 작동
							fall = true; // 떨어지는 중으로 전환
							System.out.println("낙하시작");
							long t1 = getTime(); // 현재시간을 가져온다
							long t2;
							int set = 1; // 처음 낙하랑 (0~10)까지 테스트
							while (foot < nowField) { // 발이 땅에 닿기 전까지 반복
								t2 = getTime() - t1; // 지금 시간에서 t1을 뺀다
								int fallY = set + (int) ((t2) / 40); // 낙하량을 늘린다.

								if (foot + fallY > nowField) {
									fallY = nowField - foot;
								}

								imgY = imgY + fallY; // Y좌표에 낙하량을 더한다.
								foot = imgY + img.getHeight(null); // 현재 발바닥 위치를 저장
								repaint(); // 다시그리기

								if (jump == true) {
									break;
								}

								try {
									Thread.sleep(10);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							fall = false; // while문이 끝나면 다시 false

							if (jump = false) {
								doubleJump = 0;
							}
						}

					}
				}

				private long getTime() {
					// TODO Auto-generated method stub
					return 0;
				}
			}).start();
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			for (int i = 0; i < fieldList.size(); i++) {
				Image tempImg = fieldList.get(i).getImage();
				int tempX = fieldList.get(i).getX();
				int tempY = fieldList.get(i).getY();
				int tempWidth = fieldList.get(i).getWidth();
				int tempHeight = fieldList.get(i).getHeight();
				g.drawImage(tempImg, tempX, tempY, tempWidth, tempHeight, null);
			}
			g.drawImage(img, landimg.getWidth(null) / 2, imgY, img.getWidth(null), img.getHeight(null), this);
		}

	} // end of Mypanel
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Foots window = new Foots();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Foots() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new Mypanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
	}

}
