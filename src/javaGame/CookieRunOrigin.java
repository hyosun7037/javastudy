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

//구현 단계
//1. 맵을 뒤로 이동 시킬 수 있다. O
//
//1-1. 같은 맵을 무한반복 할 수 있다. O
//
//2. 맵과 함께 젤리를 뒤로 이동 시킬 수 있다. O
//
//3. 캐릭터가 점프하거나 누을 수 있다. O
//
//4. 캐릭터와 젤리가 만나면 젤리가 사라지게 할 수 있다. O
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
//창 사이즈 800 *480 / 발판사이즈 80 / 한칸짜리 장애물 80*80 / 부딪히는 범위 120*80 / 젤리 20*20 ~ 30*30 / 발판 아래 공간 / 캐릭터는 세번째 발판에 위치

/////////////////// 오류 : 1. 점프할 때 전의 아이템들도 사라짐  / 3. 스페이스바를 꾹 누르면 점프 X / 3. 더블점프시 캐릭터 사라짐  //////////

//프레임, 패널, 메인 한 공간

public class CookieRunOrigin extends JFrame {

	//// 변수 ////
	MousePanel panel;
	
	int imgX = 0;
	int imgY = 5; //원래 40
	
	String fieldStr = "11111111111111111110111111111111111011111111111111111111111111111111111";
	
	int imgBgX = 0;
	int imgBgY = 0;
	
	int time = 60;
	int fieldY = 0;

	int itemX = 50;
	int itemY = 50;

	int count = 0; // 발판 확인 변수
	int field = 360; // 발판높이
	
	int nowField = field; // 캐릭터 높이에 따른 발판 위치 조정 변수
	
	boolean fall = false; // 현재 떨어지는지 확인
	boolean jump = false; // 현재 점프중인지 확인

	int doubleJump = 0; // 점프 카운트 (2가 되면 더블점프 상태)
	
	boolean downKeyOn = false;
	
	// 투명도 조절을 위한 변수
	private AlphaComposite alphaComposite; 
	
	//// 이미지 ////
	ImageIcon landIc = new ImageIcon("img/land.png"); // 발판
	Image landimg = landIc.getImage();
	
	ImageIcon bg = new ImageIcon("img/bg1.png"); // bg 움직이는 이미지
	Image b = bg.getImage();

	ImageIcon bg2 = new ImageIcon("img/bg2.png"); // bg 고정이미지
	Image bgTwo = bg2.getImage();

	int b1 = 0;
	int b2 = b.getWidth(null); // 따라오는 이미지

	// 원본 캐릭터 이미지
	ImageIcon cookie = new ImageIcon("img/player_origin.gif");
	Image c = cookie.getImage();

	// 다운 이미지 (슬라이딩)
	ImageIcon cookie2 = new ImageIcon("img/player_down.gif");
	Image down = cookie2.getImage();

	// 점프 이미지
	ImageIcon cookieJump = new ImageIcon("img/player_up.gif");
	Image cj = cookieJump.getImage();
	
	// 더블점프 이미지
	ImageIcon cookieDoubleJump = new ImageIcon("img/player_doubleup.gif");
	Image dj = cookieDoubleJump.getImage();
	
	// 더블점프 후 떨어지는 이미지
	ImageIcon cookieDoubleJumpEnd = new ImageIcon("img/player_jumpend.png");
	Image je = cookieDoubleJumpEnd.getImage();

	// 아이템 이미지 (이미지 넣기 완료)
	ImageIcon item = new ImageIcon("img/item.gif");
	Image item_i = item.getImage();
	
	// 더블 버퍼 선언 (전역에 추가)
	Image buffImage;
	Graphics buffg;
	
	// 아이템 이펙트 효과 이미지
	ImageIcon effIc = new ImageIcon("img/effTest1.png");
	
	// 현재시간 가져오기
	static long getTime() {
		return Timestamp.valueOf(LocalDateTime.now()).getTime();
	}
	
	// substring으로 발판 정보 검색
		static int getGround(String ground, int index) {
			return Integer.parseInt(ground.substring(index, index + 1));
		}

	// 발판 객체를 담을 리스트
	List<Foot> fieldList = new ArrayList<>(); // 발판 객체를 담을 리스트
	
	// 아이템 리스트 (리스트 생성완료)
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

	//// 생성자////
	public CookieRunOrigin() {
		panel = new MousePanel();
		setTitle("Cookie Run : Stage1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel); // MousePanel 붙이기
		setSize(800, 480); // 배경2번 크기 조정
		setVisible(true); // 보이게 하기
//		setResizable(false); // 크기조정불가
	}

	class MousePanel extends JPanel {
		public MousePanel() {
			// 옆으로
			setFocusable(true);
			
			// 발판 추가
			for (int i = 0; i < fieldStr.length(); i++) {
				int tempX = i * landimg.getWidth(null);
				if(getGround(fieldStr, i) == 1) {
					fieldList.add(new Foot(landimg, tempX, 320, landimg.getWidth(null), landimg.getHeight(null)));
				}
			}
			
			

			
			
			
			// 발판 좌표 이동 쓰레드
						new Thread(new Runnable() {

							@Override
							public void run() {
								while (true) {
									for (int i = 0; i < fieldList.size(); i++) {
										fieldList.get(i).setX(fieldList.get(i).getX() - 3);
									}
									int range = (int) (landimg.getWidth(null) * 1.3); // 캐릭터가 서 있을 수 있는 위치
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
						
						
			////////////////// 낙하 스레드 /////////////////////////
			new Thread(new Runnable() {

				public void run() {
					while (true) {
						// 발바닥 위치는 이미지의 Y위치 + 이미지의 높이
						int foot = imgY + c.getHeight(null);
						
						// 발바닥이 땅보다 위에 있으면 작동
						if (foot < nowField && jump == false && fall == false)  { // 점프중 X, 공중에 있고, 떨어지는 중이 아닐 때 작동
							fall = true; // 떨어지는 중으로 전환
							System.out.println("낙하시작");
							
							long t1 = getTime(); // 현재시간을 가져온다
							long t2;
							int set = 1; // 처음 낙하랑 (0~10)까지 테스트
							
							//////더블 점프 추가시작
							 if(doubleJump == 2) { 
								 c = cookieDoubleJumpEnd.getImage();
							 }
							 ////더블점프 추가 끝
							 
							while (foot < nowField) { // 발이 땅에 닿기 전까지 반복
								t2 = getTime() - t1; // 지금 시간에서 t1을 뺀다
								int fallY = set + (int) ((t2) / 40); // 낙하량을 늘린다.

								if(foot + fallY > nowField) {
									fallY = nowField - foot;
								}
								
								imgY = imgY + fallY; // Y좌표에 낙하량 더하기
								foot = imgY + c.getHeight(null); // 현재 발바닥 위치를 저장

								if(jump == true) { // 떨어지다가 더블 점프를 하면 낙하중지
									break;
								}
								
								try {
									Thread.sleep(10);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							fall = false; // while문이 끝나면 다시 false
							
							
							/// 더블점프 추가한 부분 시작
							if(jump == false) { // 발이 땅에 닿고 점프 중이 X, 더블 점프 카운트를 0으로 수정
								doubleJump = 0;
							}
							/// 더블점프 추가한 부분 끝
							
							
							//추후에 추가
							if(downKeyOn && !jump && !fall & c!=cookie2.getImage()) {
								c = cookie2.getImage(); // 누운 이미지로 변경
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
			
			///////////////// 아이템 리스트 (아이템 배열이 5개면 if문 다섯개 추가) 무한으로 생성하는 것은 추후 수정 ///////////////////
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

			//////////////////// repaint 전용 스레드 ////////////////////
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

						////////////////// 아이템 스레드 /////////////////

						////////////////////// 아이템 이동 //////////////////////////
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

						////////////////////////////////////// 아이템 소멸 /////////////////////////////////
						for (int i = 0; i < itemList1.size(); i++) {
							if (itemList1.get(i).getX() < imgX + c.getWidth(null) -200
									&& itemList1.get(i).getY() > imgY + c.getHeight(null) -100) {

								itemList1.remove(itemList1.get(i));
							}
						} // for문 다섯개

						for (int i = 0; i < itemList2.size(); i++) {
							if (itemList2.get(i).getX() < imgX + c.getWidth(null) -200
									&& itemList2.get(i).getY() > imgY + c.getHeight(null) -100) {

								itemList2.remove(itemList2.get(i));
							}
						} // for문 다섯개

						for (int i = 0; i < itemList3.size(); i++) {
							if (itemList3.get(i).getX() < imgX + c.getWidth(null) -200
									&& itemList3.get(i).getY() > imgY + c.getHeight(null) -100) {

								itemList3.remove(itemList3.get(i));
							}
						} // for문 다섯개

						for (int i = 0; i < itemList4.size(); i++) {
							if (itemList4.get(i).getX() < imgX + c.getWidth(null) -200
									&& itemList4.get(i).getY() > imgY + c.getHeight(null) -100) {

								itemList4.remove(itemList4.get(i));
							}
						} // for문 다섯개

						for (int i = 0; i < itemList5.size(); i++) {
							if (itemList5.get(i).getX() < imgX + c.getWidth(null) -200
									&& itemList5.get(i).getY() > imgY + c.getHeight(null) -100) {

								itemList5.remove(itemList5.get(i));
							}
						} // for문 다섯개

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
					if (e.getKeyCode() == KeyEvent.VK_SPACE && doubleJump < 2) { //jump == false
						new Up();
						
					}
					if (e.getKeyCode() == KeyEvent.VK_DOWN) {
						downKeyOn = false;
						if(c != cookie2.getImage() && !jump && !fall) {
							c = cookie2.getImage(); //누웠을 때 이미지 변경
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
					System.out.println("더블 버퍼링용 오프 스크린 생성 실패");
				}else{
					buffg = buffImage.getGraphics();
				}
			}
			
			//오류 수정후 더블 버퍼 추가
			
			buffg.drawImage(dj, 0, 0, this);
			g.drawImage(buffImage,0,0,this);
			
			g.drawImage(b, b1, 0, this); // 배경
			g.drawImage(b, b2, 0, this); // 뒤6따라 오는 배경
			g.drawImage(bgTwo, 0, 0, 970, 500, this); // 땅 배경
			g.drawImage(c, imgX, imgY + 60, 250, 250, null); // 캐릭터

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
			///////////////////////////////// 점프 동작 구현 ///////////////////////////
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					/// 더블점프 추가한부분 시작
					doubleJump++; // 점프 횟수 증가 //////////////// 여기서 수정..?
					int nowJump = doubleJump; // 더블점프 저장
					
					jump = true; //점프중으로 변경
					
					if(doubleJump == 1) {
						System.out.println("점프");
						c = cookieJump.getImage();

					}else if(doubleJump == 2) {
						System.out.println("더블점프");
						c = cookieDoubleJump.getImage();
					}
					
					/// 더블점프 추가한부분 끝
					
					//// 점프 구현
					
					// 발바닥 위치는 이미지의 Y위치 + 이미지의 높이
					int foot = imgY + c.getHeight(null); // 발바닥의 위치 Y좌표 + 이미지의 높이
						long t1 = getTime(); // 현재시간 가져오기
						long t2;
						int set = 8; // 점프 계수 설정(0~20)으로 바꿔보기
						int jumpY = 8; // 1이상으로만 설정하면 된다. (while문 조건 때문에)
						while(jumpY > 0) { // 높이가 0일 때 까지 반복
							t2 = getTime() - t1;  // 지금 시간에서 t1 빼기
							jumpY = set - (int)((t2) / 40); // jump 세팅
							imgY = imgY - jumpY; //Y값 변경
							foot = imgY + c.getHeight(null); //발바닥 위치 저장
							repaint();
							
							/// 더블점프 추가한부분 시작
							if(nowJump != doubleJump) { //점프가 한번 더 되면 첫번째 점프는 멈춤
								break;
							}
							/// 더블점프 추가한부분 끝
							
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						if(nowJump == doubleJump) { // 점프가 진짜 끝났을 때를 확인
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