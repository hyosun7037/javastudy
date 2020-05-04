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
////�����ϴ� ���� �����ϱ� (����� �۵��ϴµ� �̹��� �ε� X)
//public class Jump {
//
//	private JFrame frame; // JFrame ����
//
//	int field = 250; // ���ϰ� ���ߴ� ����
//	
//	ImageIcon ic = new ImageIcon("image/ch_fire.gif");
//	Image img = ic.getImage(); // �̹��� �׸���
//	
//	int imgY = 5; // �̹����� �����ϴ� Y��ǥ
//
//	boolean fall = false; // ���� ���������� Ȯ��
//	boolean jump = false; // ���� ���������� Ȯ��
//
//	int doubleJump = 0;
//	// �ð� ��������
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
//	// JPanel�� ��ӹ޴� Ŭ������ ����� �̹����� �׸���.
//	class MyPanel extends JPanel {
//		public MyPanel() {
//			setFocusable(true);
//
//			// ������ ����
//			new Thread(new Runnable() {
//
//				public void run() {
//					while (true) {
//						// �߹ٴ� ��ġ�� �̹����� Y��ġ + �̹����� ����
//						int foot = imgY + img.getHeight(null);
//
//						// �߹ٴ��� ������ ���� ������ �۵� //jump == false && foot < field
//						if ( foot < Foots.nowField && jump == false && fall == false) { // ������ X, ���߿� �ְ�, �������� ���� �ƴ� �� �۵�
//							fall = true; // �������� ������ ��ȯ
//							System.out.println("���Ͻ���");
//							long t1 = getTime(); // ����ð��� �����´�
//							long t2;
//							int set = 1; // ó�� ���϶� (0~10)���� �׽�Ʈ
//							while (foot < Foots.nowField) { // ���� ���� ��� ������ �ݺ�
//								t2 = getTime() - t1; // ���� �ð����� t1�� ����
//								int jumpY = set + (int) ((t2) / 40); // ���Ϸ��� �ø���.
//								imgY = imgY + jumpY; // Y��ǥ�� ���Ϸ��� ���Ѵ�.
//								foot = imgY + img.getHeight(null); // ���� �߹ٴ� ��ġ�� ����
//								repaint(); // �ٽñ׸���
//								try {
//									Thread.sleep(10);
//								} catch (InterruptedException e) {
//									e.printStackTrace();
//								}
//							}
//							fall = false; // while���� ������ �ٽ� false
//						}
//
//					}
//				}
//			}).start();
//
//			// ���� ����
//			addKeyListener(new KeyAdapter() {
//				@Override
//				public void keyPressed(KeyEvent e) {
//					if (e.getKeyCode() == KeyEvent.VK_SPACE && jump == false) { // �����̽�Ű�� ������ �������� �ƴ� ��
//						new Thread(new Runnable() {
//
//							@Override
//							public void run() {
//								// �߹ٴ� ��ġ�� �̹����� Y��ġ + �̹����� ����
//								int foot = imgY + img.getHeight(null); // �߹ٴ��� ��ġ Y��ǥ + �̹����� ����
//
//								if (fall == false) { // �������� ���� �ƴ� �� ����
//									jump = true; // ���������� ����
//									System.out.println("��������");
//									long t1 = getTime(); // ����ð��� �����´�
//									long t2;
//									int set = 8; // ���� ��� ����(0~20)������ �ٲ㺸��
//									int jumpY = 8; // 1�̻����θ� �����ϸ� �ȴ�.(while�� ���� ����)
//									while (jumpY > 0) { // ��� ���̰� 0�� �� ���� �ݺ�
//										t2 = getTime() - t1; // ���� �ð����� t1�� ����.
//										jumpY = set - (int) ((t2) / 40); // jump�� ����
//										imgY = imgY - jumpY; // Y���� ����
//										foot = imgY + img.getHeight(null); // �߹ٴ� ��ġ�� ����
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
//	// ó�� ���� �� ��
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
