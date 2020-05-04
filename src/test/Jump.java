//package test;
//
//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//import java.awt.Graphics;
//import java.awt.Image;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//import java.sql.Timestamp;
//import java.time.LocalDateTime;
//
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
////점프하는 동작 구현하기 (기능은 작동하는데 이미지 로딩 X)
//public class Jump {
//
//	private JFrame frame; // JFrame 삽입
//
//	int field = 250; // 낙하가 멈추는 지점
//	
//	ImageIcon ic = new ImageIcon("image/ch_fire.gif");
//	Image img = ic.getImage(); // 이미지 그리기
//	
//	int imgY = 5; // 이미지가 시작하는 Y좌표
//
//	boolean fall = false; // 현재 떨어지는지 확인
//	boolean jump = false; // 현재 점프중인지 확인
//
//	int doubleJump = 0;
//	// 시간 가져오기
//	static long getTime() {
//		return Timestamp.valueOf(LocalDateTime.now()).getTime();
//	}
//
////	public static void main(String[] args) {
////		EventQueue.invokeLater(new Runnable() {
////			public void run() {
////				try {
////					Jump window = new Jump();
////					new Foots();
////					window.frame.setVisible(true);
////				} catch (Exception e) {
////					e.printStackTrace();
////				}
////			}
////		});
////	} //end of main
//
//	public Jump() {
//		initialize();
//	}
//
//	// JPanel을 상속받는 클래스를 만들고 이미지를 그린다.
//	class MyPanel extends JPanel {
//		public MyPanel() {
//			setFocusable(true);
//
//			// 스레드 실행
//			new Thread(new Runnable() {
//
//				public void run() {
//					while (true) {
//						// 발바닥 위치는 이미지의 Y위치 + 이미지의 높이
//						int foot = imgY + img.getHeight(null);
//
//						// 발바닥이 땅보다 위에 있으면 작동 //jump == false && foot < field
//						if ( foot < Foots.nowField && jump == false && fall == false) { // 점프중 X, 공중에 있고, 떨어지는 중이 아닐 때 작동
//							fall = true; // 떨어지는 중으로 전환
//							System.out.println("낙하시작");
//							long t1 = getTime(); // 현재시간을 가져온다
//							long t2;
//							int set = 1; // 처음 낙하랑 (0~10)까지 테스트
//							while (foot < Foots.nowField) { // 발이 땅에 닿기 전까지 반복
//								t2 = getTime() - t1; // 지금 시간에서 t1을 뺀다
//								int jumpY = set + (int) ((t2) / 40); // 낙하량을 늘린다.
//								imgY = imgY + jumpY; // Y좌표에 낙하량을 더한다.
//								foot = imgY + img.getHeight(null); // 현재 발바닥 위치를 저장
//								repaint(); // 다시그리기
//								try {
//									Thread.sleep(10);
//								} catch (InterruptedException e) {
//									e.printStackTrace();
//								}
//							}
//							fall = false; // while문이 끝나면 다시 false
//						}
//
//					}
//				}
//			}).start();
//
//			// 점프 시작
//			addKeyListener(new KeyAdapter() {
//				@Override
//				public void keyPressed(KeyEvent e) {
//					if (e.getKeyCode() == KeyEvent.VK_SPACE && jump == false) { // 스페이스키를 누르고 점프중이 아닐 때
//						new Thread(new Runnable() {
//
//							@Override
//							public void run() {
//								// 발바닥 위치는 이미지의 Y위치 + 이미지의 높이
//								int foot = imgY + img.getHeight(null); // 발바닥의 위치 Y좌표 + 이미지의 높이
//
//								if (fall == false) { // 떨어지는 중이 아닐 때 점프
//									jump = true; // 점프중으로 변경
//									System.out.println("점프시작");
//									long t1 = getTime(); // 현재시간을 가져온다
//									long t2;
//									int set = 8; // 점프 계수 설정(0~20)등으로 바꿔보자
//									int jumpY = 8; // 1이상으로만 설정하면 된다.(while문 조건 때문)
//									while (jumpY > 0) { // 상승 높이가 0일 때 까지 반복
//										t2 = getTime() - t1; // 지금 시간에서 t1을 뺀다.
//										jumpY = set - (int) ((t2) / 40); // jump를 세팅
//										imgY = imgY - jumpY; // Y값을 변경
//										foot = imgY + img.getHeight(null); // 발바닥 위치를 저장
//										repaint();
//										try {
//											Thread.sleep(10);
//										} catch (InterruptedException e) {
//
//											e.printStackTrace();
//										}
//
//									}
//									jump = false;
//								}
//
//							}
//						}).start();
//					}
//				}
//			});
//		}
//		
//		@Override
//		protected void paintComponent(Graphics g) {
//			super.paintComponent(g);
//			g.drawImage(img, 100, imgY, this);
//		}
//	}
//
//	// 처음 세팅 할 값
//	private void initialize() {
//		frame = new JFrame();
//		frame.setBounds(100, 100, 450, 300);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//		JPanel panel = new MyPanel();
//		frame.getContentPane().add(panel, BorderLayout.CENTER);
//		panel.setLayout(null);
//	}
//
//}
