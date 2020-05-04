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

public class CookieRunOrigin extends JFrame {

	//// ���� ////
	MousePanel panel;
	
	int imgX = 0;
	int imgY = 5; //���� 40
	
	String fieldStr = "11111111111111111110111111111111111011111111111111111111111111111111111";
	
	int imgBgX = 0;
	int imgBgY = 0;
	
	int time = 60;
	int fieldY = 0;

	int itemX = 50;
	int itemY = 50;

	int count = 0; // ���� Ȯ�� ����
	int field = 360; // ���ǳ���
	
	int nowField = field; // ĳ���� ���̿� ���� ���� ��ġ ���� ����
	
	boolean fall = false; // ���� ���������� Ȯ��
	boolean jump = false; // ���� ���������� Ȯ��

	int doubleJump = 0; // ���� ī��Ʈ (2�� �Ǹ� �������� ����)
	
	boolean downKeyOn = false;
	
	// ���� ������ ���� ����
	private AlphaComposite alphaComposite; 
	
	//// �̹��� ////
	ImageIcon landIc = new ImageIcon("img/land.png"); // ����
	Image landimg = landIc.getImage();
	
	ImageIcon bg = new ImageIcon("img/bg1.png"); // bg �����̴� �̹���
	Image b = bg.getImage();

	ImageIcon bg2 = new ImageIcon("img/bg2.png"); // bg �����̹���
	Image bgTwo = bg2.getImage();

	int b1 = 0;
	int b2 = b.getWidth(null); // ������� �̹���

	// ���� ĳ���� �̹���
	ImageIcon cookie = new ImageIcon("img/player_origin.gif");
	Image c = cookie.getImage();

	// �ٿ� �̹��� (�����̵�)
	ImageIcon cookie2 = new ImageIcon("img/player_down.gif");
	Image down = cookie2.getImage();

	// ���� �̹���
	ImageIcon cookieJump = new ImageIcon("img/player_up.gif");
	Image cj = cookieJump.getImage();
	
	// �������� �̹���
	ImageIcon cookieDoubleJump = new ImageIcon("img/player_doubleup.gif");
	Image dj = cookieDoubleJump.getImage();
	
	// �������� �� �������� �̹���
	ImageIcon cookieDoubleJumpEnd = new ImageIcon("img/player_jumpend.png");
	Image je = cookieDoubleJumpEnd.getImage();

	// ������ �̹��� (�̹��� �ֱ� �Ϸ�)
	ImageIcon item = new ImageIcon("img/item.gif");
	Image item_i = item.getImage();
	
	// ���� ���� ���� (������ �߰�)
	Image buffImage;
	Graphics buffg;
	
	// ������ ����Ʈ ȿ�� �̹���
	ImageIcon effIc = new ImageIcon("img/effTest1.png");
	
	// ����ð� ��������
	static long getTime() {
		return Timestamp.valueOf(LocalDateTime.now()).getTime();
	}
	
	// substring���� ���� ���� �˻�
		static int getGround(String ground, int index) {
			return Integer.parseInt(ground.substring(index, index + 1));
		}

	// ���� ��ü�� ���� ����Ʈ
	List<Foot> fieldList = new ArrayList<>(); // ���� ��ü�� ���� ����Ʈ
	
	// ������ ����Ʈ (����Ʈ �����Ϸ�)
	List<Item> itemList1 = new ArrayList<>();
	List<Item> itemList2 = new ArrayList<>();
	List<Item> itemList3 = new ArrayList<>();
	List<Item> itemList4 = new ArrayList<>();
	List<Item> itemList5 = new ArrayList<>();

	int[] itemInfite1 = { 0,0,0,0,0,0,1,1,1,1,0,0,1,0,1,0,0,0,1,1,1,0,0,0,0,1,1,1,1,0,0,1,1,1,0,0,0,1,0,1,0,0,0,1,1,1,0,0,0,0};
	int[] itemInfite2 = { 0,0,0,0,0,0,1,1,1,1,0,0,1,0,1,0,0,0,1,1,1,0,0,0,0,1,1,1,1,0,0,1,1,1,0,0,0,1,0,1,0,0,0,1,1,1,0,0,0,0};
	int[] itemInfite3 = { 0,0,0,0,0,0,1,1,1,1,0,0,1,0,1,0,0,0,1,1,1,0,0,0,0,1,1,1,1,0,0,1,1,1,0,0,0,1,0,1,0,0,0,1,1,1,0,0,0,0};
	int[] itemInfite4 = { 0,0,0,0,0,0,1,1,1,1,0,0,1,0,1,0,0,0,1,1,1,0,0,0,0,1,1,1,1,0,0,1,1,1,0,0,0,1,0,1,0,0,0,1,1,1,0,0,0,0};
	int[] itemInfite5 = { 0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,1,1,1,0,0,0,0,1,1,1,1,0,0,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1};

	//// ������////
	public CookieRunOrigin() {
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
			
			// ���� �߰�
			for (int i = 0; i < fieldStr.length(); i++) {
				int tempX = i * landimg.getWidth(null);
				if(getGround(fieldStr, i) == 1) {
					fieldList.add(new Foot(landimg, tempX, 320, landimg.getWidth(null), landimg.getHeight(null)));
				}
			}
			
			

			
			
			
			// ���� ��ǥ �̵� ������
						new Thread(new Runnable() {

							@Override
							public void run() {
								while (true) {
									for (int i = 0; i < fieldList.size(); i++) {
										fieldList.get(i).setX(fieldList.get(i).getX() - 3);
									}
									int range = (int) (landimg.getWidth(null) * 1.3); // ĳ���Ͱ� �� ���� �� �ִ� ��ġ
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
									int foot = imgY + c.getHeight(null);

									if (count == 0) {
										nowField = 2000;
									} else if (count == 0 && foot > field) {
										nowField = 2000;
									} else if (count == 1 && foot <= field) {
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
			
			///////////////// ������ ����Ʈ (������ �迭�� 5���� if�� �ټ��� �߰�) �������� �����ϴ� ���� ���� ���� ///////////////////
			for (int i = 0; i < 50; i++) {
				if (itemInfite1[i] == 1) {
					itemList1.add(new Item(item_i, 0, 200 + i * 100, 170));}
				
				if (itemInfite2[i] == 1) {
					itemList2.add(new Item(item_i, 0, 200 + i * 140, 100));}
				
				if (itemInfite3[i] == 1) {
					itemList3.add(new Item(item_i, 0, 200 + i * 180, 170));}
				
				if (itemInfite4[i] == 1) {
					itemList4.add(new Item(item_i, 0, 200 + i * 220, 100));}
				
				if (itemInfite5[i] == 1) {
					itemList5.add(new Item(item_i, 0, 200 + i * 260, 100));}
				i++;
			}

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

						////////////////// ������ ������ /////////////////

						////////////////////// ������ �̵� //////////////////////////
						for (int i = 0; i < itemList1.size(); i++) {
							itemList1.get(i).setX(itemList1.get(i).getX() - 7);
						}

						for (int i = 0; i < itemList2.size(); i++) {
							itemList2.get(i).setX(itemList2.get(i).getX() - 7);
						}

						for (int i = 0; i < itemList3.size(); i++) {
							itemList3.get(i).setX(itemList3.get(i).getX() - 7);
						}

						for (int i = 0; i < itemList4.size(); i++) {
							itemList4.get(i).setX(itemList4.get(i).getX() - 7);
						}

						for (int i = 0; i < itemList5.size(); i++) {
							itemList5.get(i).setX(itemList5.get(i).getX() - 7);
						}

						////////////////////////////////////// ������ �Ҹ� /////////////////////////////////
						for (int i = 0; i < itemList1.size(); i++) {
							if (itemList1.get(i).getX() < imgX + c.getWidth(null) -200
									&& itemList1.get(i).getY() > imgY + c.getHeight(null) -100) {

								itemList1.remove(itemList1.get(i));
							}
						} // for�� �ټ���

						for (int i = 0; i < itemList2.size(); i++) {
							if (itemList2.get(i).getX() < imgX + c.getWidth(null) -200
									&& itemList2.get(i).getY() > imgY + c.getHeight(null) -100) {

								itemList2.remove(itemList2.get(i));
							}
						} // for�� �ټ���

						for (int i = 0; i < itemList3.size(); i++) {
							if (itemList3.get(i).getX() < imgX + c.getWidth(null) -200
									&& itemList3.get(i).getY() > imgY + c.getHeight(null) -100) {

								itemList3.remove(itemList3.get(i));
							}
						} // for�� �ټ���

						for (int i = 0; i < itemList4.size(); i++) {
							if (itemList4.get(i).getX() < imgX + c.getWidth(null) -200
									&& itemList4.get(i).getY() > imgY + c.getHeight(null) -100) {

								itemList4.remove(itemList4.get(i));
							}
						} // for�� �ټ���

						for (int i = 0; i < itemList5.size(); i++) {
							if (itemList5.get(i).getX() < imgX + c.getWidth(null) -200
									&& itemList5.get(i).getY() > imgY + c.getHeight(null) -100) {

								itemList5.remove(itemList5.get(i));
							}
						} // for�� �ټ���

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
				}else{
					buffg = buffImage.getGraphics();
				}
			}
			
			//���� ������ ���� ���� �߰�
			
			buffg.drawImage(dj, 0, 0, this);
			g.drawImage(buffImage,0,0,this);
			
			g.drawImage(b, b1, 0, this); // ���
			g.drawImage(b, b2, 0, this); // ��6���� ���� ���
			g.drawImage(bgTwo, 0, 0, 970, 500, this); // �� ���
			g.drawImage(c, imgX, imgY + 60, 250, 250, null); // ĳ����

			for (int i = 0; i < itemList1.size(); i++) {g.drawImage(itemList1.get(i).getImage(), itemList1.get(i).getX(), itemList1.get(i).getY(), 30, 30, this);}
			for (int i = 0; i < itemList2.size(); i++) {g.drawImage(itemList2.get(i).getImage(), itemList2.get(i).getX(), itemList2.get(i).getY(), 30, 30, this);}
			for (int i = 0; i < itemList3.size(); i++) {g.drawImage(itemList3.get(i).getImage(), itemList3.get(i).getX(), itemList3.get(i).getY(), 30, 30, this);}
			for (int i = 0; i < itemList4.size(); i++) {g.drawImage(itemList4.get(i).getImage(), itemList4.get(i).getX(), itemList4.get(i).getY(), 30, 30, this);}
			for (int i = 0; i < itemList5.size(); i++) {g.drawImage(itemList5.get(i).getImage(), itemList5.get(i).getX(), itemList5.get(i).getY(), 30, 30, this);}
		
		
			for (int i = 0; i < fieldList.size(); i++) {
				Image tempImg = fieldList.get(i).getImage();
				int tempX = fieldList.get(i).getX();
				int tempY = fieldList.get(i).getY();
				int tempWidth = fieldList.get(i).getWidth();
				int tempHeight = fieldList.get(i).getHeight();
				g.drawImage(tempImg, tempX, tempY, tempWidth, tempHeight, null);
			}
//			g.drawImage(c, landimg.getWidth(null) / 2, imgY, c.getWidth(null), c.getHeight(null), this);
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
		new CookieRunOrigin();
	}

}