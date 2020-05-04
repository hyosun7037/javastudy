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
	int field = 400; // ���� ����

	int imgX = 0;
	int imgY = 5;
	// 1�̸� ������ �ְ� 0�̸� ����. ----> ���� ����
	String fieldStr = "1111100111110100111011001011111111100000011111111111111111111";

	List<Foot> fieldList = new ArrayList<>(); // ���� ��ü�� ���� ����Ʈ

	int count = 0; // ���� Ȯ�� ����

	int nowField = field; // ĳ���� ������ ���� ������ġ ���� ����

	ImageIcon landIc = new ImageIcon("image/land.png");
	Image landimg = landIc.getImage();

	ImageIcon image = new ImageIcon("image/player_origin.gif");
	Image img = image.getImage();

	int doubleJump = 0;

	boolean fall = false; // ���� ���������� Ȯ��
	boolean jump = false; // ���� ���������� Ȯ��

	// substring���� ���� ���� �˻�
	static int getGround(String ground, int index) {
		return Integer.parseInt(ground.substring(index, index + 1));
	}

	class Mypanel extends JPanel {
		public Mypanel() {
			setFocusable(true);

			//���� �߰�
			for (int i = 0; i < fieldStr.length(); i++) {
				int tempX = i * landimg.getWidth(null);
				if(getGround(fieldStr, i) == 1) {
					fieldList.add(new Foot(landimg, tempX, 400, landimg.getWidth(null), landimg.getHeight(null)));
				}
			}
			
			// repaint ���� ������
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

			// ���� ��ǥ �̵� ������
			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						for (int i = 0; i < fieldList.size(); i++) {
							fieldList.get(i).setX(fieldList.get(i).getX() - 4);
						}
						int range = (int) (landimg.getWidth(null) * 1.2); // ĳ���Ͱ� �� ���� �� �ִ� ��ġ
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

			// ĳ������ ���̿� ���� ���� ��ġ�� �����ϴ� ������
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

			// ���Ͻ�����
			new Thread(new Runnable() {

				public void run() {
					while (true) {
						// �߹ٴ� ��ġ�� �̹����� Y��ġ + �̹����� ����
						int foot = imgY + img.getHeight(null);

						// �߹ٴ��� ������ ���� ������ �۵� //jump == false && foot < field
						if (foot < nowField && jump == false && fall == false) { // ������ X, ���߿� �ְ�, �������� ���� �ƴ� �� �۵�
							fall = true; // �������� ������ ��ȯ
							System.out.println("���Ͻ���");
							long t1 = getTime(); // ����ð��� �����´�
							long t2;
							int set = 1; // ó�� ���϶� (0~10)���� �׽�Ʈ
							while (foot < nowField) { // ���� ���� ��� ������ �ݺ�
								t2 = getTime() - t1; // ���� �ð����� t1�� ����
								int fallY = set + (int) ((t2) / 40); // ���Ϸ��� �ø���.

								if (foot + fallY > nowField) {
									fallY = nowField - foot;
								}

								imgY = imgY + fallY; // Y��ǥ�� ���Ϸ��� ���Ѵ�.
								foot = imgY + img.getHeight(null); // ���� �߹ٴ� ��ġ�� ����
								repaint(); // �ٽñ׸���

								if (jump == true) {
									break;
								}

								try {
									Thread.sleep(10);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							fall = false; // while���� ������ �ٽ� false

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
