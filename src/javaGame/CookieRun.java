package javaGame;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import test.Foot;
import test.Jelly;

//���� �ܰ�
//1. ���� �ڷ� �̵� ��ų �� �ִ�. O
//
//1-1. ���� ���� ���ѹݺ� �� �� �ִ�. O
//
//2. �ʰ� �Բ� ������ �ڷ� �̵� ��ų �� �ִ�. O
//
//3. ĳ���Ͱ� �����ϰų� ���� �� �ִ�. O
//
//4. ĳ���Ϳ� ������ ������ ������ ������� �� �� �ִ�. O
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
//â ������ 800 *480 / ���ǻ����� 80 / ��ĭ¥�� ��ֹ� 80*80 / �ε����� ���� 120*80 / ���� 20*20 ~ 30*30 / ���� �Ʒ� ���� / ĳ���ʹ� ����° ���ǿ� ��ġ

/////////////////// ���� : 1. ������ �� ���� �����۵鵵 �����  / 3. �����̽��ٸ� �� ������ ���� X / 3. ���������� ĳ���� �����  //////////

//������, �г�, ���� �� ����

public class CookieRun extends JFrame {

	//// ���� ////
	MousePanel panel;
	
	int imgX = 0;
	int imgY = 5; //���� 40
	
	int imgBgX = 0;
	int imgBgY = 0;
	
	int time = 60;
	int fieldY = 0;

	int itemX = 50;
	int itemY = 50;

	int count = 0; // ���� Ȯ�� ����
	int field = 300; // ���ǳ���
	
	int nowField = field; // ĳ���� ���̿� ���� ���� ��ġ ���� ����
	
	boolean fall = false; // ���� ���������� Ȯ��
	boolean jump = false; // ���� ���������� Ȯ��

	int doubleJump = 0; // ���� ī��Ʈ (2�� �Ǹ� �������� ����)
	
	boolean downKeyOn = false;
	
	// ���� ������ ���� ����
	private AlphaComposite alphaComposite; 
	
	//// �̹��� ////
	ImageIcon landIc = new ImageIcon("image/land.png"); // ����
	Image landimg = landIc.getImage();
	
	ImageIcon bg = new ImageIcon("image/bg1.png"); // bg �����̴� �̹���
	Image b = bg.getImage();

	ImageIcon bg2 = new ImageIcon("image/bg2.png"); // bg �����̹���
	Image bgTwo = bg2.getImage();

	int b1 = 0;
	int b2 = b.getWidth(null); // ������� �̹���

	// ���� ĳ���� �̹���
	ImageIcon cookie = new ImageIcon("image/player_origin.gif");
	Image c = cookie.getImage();

	// �ٿ� �̹��� (�����̵�)
	ImageIcon cookie2 = new ImageIcon("image/player_down.gif");
	Image down = cookie2.getImage();

	// ���� �̹���
	ImageIcon cookieJump = new ImageIcon("image/player_up.gif");
	Image cj = cookieJump.getImage();
	
	// �������� �̹���
	ImageIcon cookieDoubleJump = new ImageIcon("image/player_doubleup.gif");
	Image dj = cookieDoubleJump.getImage();
	
	// �������� �� �������� �̹���
	ImageIcon cookieDoubleJumpEnd = new ImageIcon("image/player_jumpend.png");
	Image je = cookieDoubleJumpEnd.getImage();

	// ������ �̹��� (�̹��� �ֱ� �Ϸ�)
	ImageIcon item = new ImageIcon("image/item.gif");
	Image item_i = item.getImage();
	
	// ���� ���� ���� (������ �߰�)
	Image buffImage;
	Graphics buffg;
	
	// ������ ����Ʈ ȿ�� �̹���
	ImageIcon effIc = new ImageIcon("image/effTest1.png");
	
	// ����ð� ��������
	static long getTime() {
		return Timestamp.valueOf(LocalDateTime.now()).getTime();
	}
	
	// substring���� ���� ���� �˻�
		static int getGround(String ground, int index) {
			return Integer.parseInt(ground.substring(index, index + 1));
		}

		
	List<Jelly> jellyList = new ArrayList<>();
	
	// ���� ��ü�� ���� ����Ʈ
	List<Foot> fieldList = new ArrayList<>(); // ���� ��ü�� ���� ����Ʈ
	
	int[][] colorArr; // �̹����� x,y��ǥ�� ������ �����ϴ� 2�����迭 colorArr[0][0]�� ȣ���ϸ� 16777215
	int[] sizeArr; // �̹����� ���̿� ���̸� �������� 1���� �迭 temp
	
	//// ������////
	public CookieRun() {
		panel = new MousePanel();
		setTitle("Cookie Run : Stage1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel); // MousePanel ���̱�
		setSize(800, 480); // ���2�� ũ�� ����
		setVisible(true); // ���̰� �ϱ�
//		setResizable(false); // ũ�������Ұ�
	}

	class MousePanel extends JPanel {
		public MousePanel() {
			// ������
			setFocusable(true);
			
			////// �̹����� ���� 
			try {
				sizeArr = Bf2.getSize("image/firstMap.png");
				colorArr = Bf2.getPic("image/firstMap.png");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			int maxX = sizeArr[0];
			int maxY = sizeArr[1];
			
			////// �гο��� �̹��� �ҷ�����
			for (int i = 0; i < maxX; i+=2) { // ������ 4ĭ�� �����ϴ� ����, 2,2������� �ݺ���
				for (int j = 0; j < maxY; j+=2) { // �� ���� 0�� ���(������)
					if(colorArr[i][j] == 0) {
						fieldList.add(new Foot(landimg, i*40, j*40, 80, 80)); // ��ǥ�� 40�� ���ϰ�, ���̿� ���̴� 80
					}
					
				}
			}
			
			for (int i = 0; i < maxX; i+=1) { // ������ 1ĭ�� ����, 1,1������� �ݺ���
				for (int j = 0; j < maxY; j+=1) {
					if(colorArr[i][j] == 16773632) { // �� ���� �����
						jellyList.add(new Jelly(item.getImage(), i*40, j*40, 30, 30, 255)); // ��ǥ�� 40���ϰ�, ���̿� ���̴� 30���� �Ѵ�.
					}
				}				
			}
			
			
			// ���� ��ǥ �̵� ������
						new Thread(new Runnable() {

							@Override
							public void run() {
								while (true) {
									for (int i = 0; i < fieldList.size(); i++) {
										fieldList.get(i).setX(fieldList.get(i).getX() - 4);
									}
									
									for(int i = 0; i < jellyList.size(); i++) {
										jellyList.get(i).setX(jellyList.get(i).getX()-4);
									}
									int range;
									range = 160;
									
									List<Integer> countList = new ArrayList<>(); // ������ �ȿ� �ӽ������� ����
									
									int tempField; // ���� ��ġ�� ��� ��ĵ�ϴ� ����
									int tempNowField = 2000; // nowField�� ����
									
									for (int i = 0; i < fieldList.size(); i++) {
										int tempX = fieldList.get(i).getX(); // ������ X��
										
										if(tempX >= 0 && tempX < range) { // ������ ĳ��������
											tempField = fieldList.get(i).getY(); // ������ y��
											
											System.out.println(imgY + c.getHeight(null) + "  " + tempField);
											
											//������ġ�� tempNowField���� �۰�, �߹ٴ��� ��ġ�� tempField���� ���� �ִٸ�
											if(tempField < tempNowField && imgY + c.getHeight(null) <= tempField) {
												tempNowField = tempField;
											}
										}
									}
									nowField = tempNowField; // ����� nowField�� ������Ʈ
									
									try {
										Thread.sleep(10);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}
						}).start();
						
						
						
			////////////////// ���� ������ /////////////////////////
			new Thread(new Runnable() {

				public void run() {
					while (true) {
						// �߹ٴ� ��ġ�� �̹����� Y��ġ + �̹����� ����
						int foot = imgY + c.getHeight(null);
						
						// �߹ٴ��� ������ ���� ������ �۵�
						if (foot < nowField && jump == false && fall == false)  { // ������ X, ���߿� �ְ�, �������� ���� �ƴ� �� �۵�
							fall = true; // �������� ������ ��ȯ
							System.out.println("���Ͻ���");
							
							long t1 = getTime(); // ����ð��� �����´�
							long t2;
							int set = 1; // ó�� ���϶� (0~10)���� �׽�Ʈ
							
							//////���� ���� �߰�����
							 if(doubleJump == 2) { 
								 c = cookieDoubleJumpEnd.getImage();
							 }
							 ////�������� �߰� ��
							 
							while (foot < nowField) { // ���� ���� ��� ������ �ݺ�
								t2 = getTime() - t1; // ���� �ð����� t1�� ����
								int fallY = set + (int) ((t2) / 40); // ���Ϸ��� �ø���.

								if(foot + fallY > nowField) {
									fallY = nowField - foot;
								}
								
								imgY = imgY + fallY; // Y��ǥ�� ���Ϸ� ���ϱ�
								foot = imgY + c.getHeight(null); // ���� �߹ٴ� ��ġ�� ����

								if(jump == true) { // �������ٰ� ���� ������ �ϸ� ��������
									break;
								}
								
								try {
									Thread.sleep(10);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							fall = false; // while���� ������ �ٽ� false
							
							
							/// �������� �߰��� �κ� ����
							if(jump == false) { // ���� ���� ��� ���� ���� X, ���� ���� ī��Ʈ�� 0���� ����
								doubleJump = 0;
							}
							/// �������� �߰��� �κ� ��
							
							
							//���Ŀ� �߰�
							if(downKeyOn && !jump && !fall & c!=cookie2.getImage()) {
								c = cookie2.getImage(); // ���� �̹����� ����
							}else if(!downKeyOn && !jump && !fall && c!=cookie.getImage()) {
								c = cookie.getImage();
							}
							
						}
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
			

			//////////////////// repaint ���� ������ ////////////////////
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
					if (e.getKeyCode() == KeyEvent.VK_SPACE && doubleJump < 2) { //jump == false
						new Up();
						
					}
					if (e.getKeyCode() == KeyEvent.VK_DOWN) {
						downKeyOn = false;
						if(c != cookie2.getImage() && !jump && !fall) {
							c = cookie2.getImage(); //������ �� �̹��� ����
						}
					}
				}
				
				

				@Override
				public void keyReleased(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_SPACE) {
						c = cookie.getImage();
					}
					if (e.getKeyCode() == KeyEvent.VK_DOWN) {
						downKeyOn = false;
						if(c != cookie.getImage() && !jump  && !fall) {
							c = cookie.getImage();
						}
					}
				}
			});
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			if(buffg == null) {
				buffImage = createImage(this.getWidth(), this.getHeight());
				if(buffImage == null) {
					System.out.println("���� ���۸��� ���� ��ũ�� ���� ����");
				}else {
					buffg = buffImage.getGraphics();
				}
			}
			
			//���� ������ ���� ���� �߰�
			
			buffg.drawImage(dj, 0, 0, this);
			buffg.drawImage(buffImage,0,0,this);
			
			buffg.drawImage(b, b1, 0, this); // ���
			buffg.drawImage(b, b2, 0, this); // ��6���� ���� ���
			buffg.drawImage(bgTwo, 0, 0, 970, 500, this); // �� ���
			buffg.drawImage(c, imgX, imgY, null); // ĳ����

			for (int i = 0; i < fieldList.size(); i++) {
				Foot tempFoot = fieldList.get(i);
				buffg.drawImage(tempFoot.getImage(), tempFoot.getX(), tempFoot.getY(), tempFoot.getWidth(), tempFoot.getHeight(), null);
			}
			
			for (int i = 0; i < jellyList.size(); i++) {
				Jelly tempJelly = jellyList.get(i);
				buffg.drawImage(tempJelly.getImage(), tempJelly.getX(), tempJelly.getY(), tempJelly.getWidth(), tempJelly.getHeight(), null);
			}
			g.drawImage(buffImage, 0, 0, null);
//			g.drawLine(160, 0, 160, 500); // ���� ����
		}

	}

	class Up{
		
		public Up() {			
			///////////////////////////////// ���� ���� ���� ///////////////////////////
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					/// �������� �߰��Ѻκ� ����
					doubleJump++; // ���� Ƚ�� ���� //////////////// ���⼭ ����..?
					int nowJump = doubleJump; // �������� ����
					
					jump = true; //���������� ����
					
					if(doubleJump == 1) {
						System.out.println("����");
						c = cookieJump.getImage();

					}else if(doubleJump == 2) {
						System.out.println("��������");
						c = cookieDoubleJump.getImage();
					}
					
					/// �������� �߰��Ѻκ� ��
					
					//// ���� ����
					
					// �߹ٴ� ��ġ�� �̹����� Y��ġ + �̹����� ����
					int foot = imgY + c.getHeight(null); // �߹ٴ��� ��ġ Y��ǥ + �̹����� ����
						long t1 = getTime(); // ����ð� ��������
						long t2;
						int set = 8; // ���� ��� ����(0~20)���� �ٲ㺸��
						int jumpY = 8; // 1�̻����θ� �����ϸ� �ȴ�. (while�� ���� ������)
						while(jumpY > 0) { // ���̰� 0�� �� ���� �ݺ�
							t2 = getTime() - t1;  // ���� �ð����� t1 ����
							jumpY = set - (int)((t2) / 40); // jump ����
							imgY = imgY - jumpY; //Y�� ����
							foot = imgY + c.getHeight(null); //�߹ٴ� ��ġ ����
							repaint();
							
							/// �������� �߰��Ѻκ� ����
							if(nowJump != doubleJump) { //������ �ѹ� �� �Ǹ� ù��° ������ ����
								break;
							}
							/// �������� �߰��Ѻκ� ��
							
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						if(nowJump == doubleJump) { // ������ ��¥ ������ ���� Ȯ��
							jump = false;
						}
					}
			}).start();
		}
	}

	public static void main(String[] args) {
		new CookieRun();
	}

}