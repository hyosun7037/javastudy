package javaGame;

////// 크기 맞춰서 한거라서 나중에 이미지만 수정하면 됨!
import java.awt.AlphaComposite;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


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
//창 사이즈 800 *480 / 발판사이즈 80 / 한칸짜리 장애물 80*80 / 부딪히는 범위 120*80 / 젤리 20*20 ~ 30*30 / 발판 아래 공간 / 캐릭터는 세번째 발판에 위치

// firstMap 가로 1200으로 늘리기 / 다 수정하고 파일정리

//프레임, 패널, 메인 한 공간



//맵 객체별 색깔
//
//기본젤리 255, 255, 0  //  16776960
//노랑젤리 200, 200, 0  //  13158400
//분홍젤리 150, 150, 0  //  9868800
//
//피물약  255, 100, 0  //  16737280
//
//1단장애물 255, 0, 0   //  16711680
//2단장애물 255, 0, 150  //  16711830
//3단장애물 255, 0, 255  //  16711935 


public class CookieRunTest extends JFrame {

	MyPanel panel;

	private int runPage = 0; // 한 화면 이동시 체력 깎기 위한 변수
	
	private int runStage = 1; // 스테이지 확인 변수
	
	private int nowField = 2000; // 캐릭터 높이에 따른 발판 위치 조정 변수

	private boolean fall = false; // 현재 떨어지는지 확인
	
	private boolean jump = false; // 현재 점프중인지 확인
 
	private int resultScore = 0; // 게임 스코어

	private int gameSpeed = 3; // 게임 속도

	private boolean escKeyOn = false; // 일시정지 확인
	
	private boolean downKeyOn = false; // 다운키 기본 설정
	
	private boolean invincible = false; // 무적상태 변수

	int doubleJump = 0; // 점프 카운트 (2가 되면 더블점프 상태)

	int cookieAlpha = 255; // 투명도
	
	int face; // 쿠키 정면
	
	int foot; // 쿠키 발
	

	
	/* 게임에 구현할 이미지들을 그려준다. */
	
	// 발판 이미지
	private ImageIcon fieldIc1 = new ImageIcon("img/footTest.png"); // 1단발판
	private ImageIcon fieldIc2 = new ImageIcon("img/footTest2.png"); // 2단발판

	// 배경 이미지
	private ImageIcon bg1 = new ImageIcon("img/bg1.png");
	private ImageIcon bg2 = new ImageIcon("img/bg2.png");

	// 쿠키 캐릭터 이미지
	private ImageIcon cookie = new ImageIcon("img/cookieTest.png"); // 기본
	private ImageIcon cookieDown = new ImageIcon("img/slideTest.png"); // 슬라이딩
	private ImageIcon cookieJump = new ImageIcon("img/jumpTest.png"); // 점프
	private ImageIcon cookieDJump = new ImageIcon("img/doubleJumpTest.png"); // 더블점프
	private ImageIcon cookieFall = new ImageIcon("img/fallTest.png"); // 낙하
	private ImageIcon cookieHit = new ImageIcon("img/hitTest.png"); // 공격받았을 때

	int cookieHeight = cookie.getImage().getHeight(null); // 캐릭터 높이

	// 젤리 이미지, 이펙트 이미지
	private ImageIcon jelly = new ImageIcon("img/jellyTest.png"); // 젤리
	private ImageIcon effect = new ImageIcon("img/tw2.png");

	// 장애물 이미지
	private ImageIcon tacle = new ImageIcon("img/tacleTest1.png"); // 장애물 (추후 추가예정)

	
	
	/* 젤리, 발판, 장애물 리스트 배치  */
	
	// 젤리 담을 리스트
	private List<Jelly> jellyList = new ArrayList<>();

	// 발판 객체를 담을 리스트
	private List<Field> fieldList = new ArrayList<>();

	// 장애물 리스트
	private List<Tacle> tacleList = new ArrayList<>();

	
	
	/* 프레임, 패널, 버튼 등은 전역공간에 배치 : 클래스 내 다른 객체 및 메서드들이 이용하기 위함 */

	int[][] colorArr; // 이미지의 x,y좌표의 색값을 저장하는 2차원배열 colorArr[0][0]을 호출하면 16777215
	int[] sizeArr; // 이미지의 넓이와 높이를 가져오는 1차원 배열

	
	
	/*PaintComponent 관련 */
	
	// 더블 버퍼 선언 (전역에 추가)
	Image buffImage;
	Graphics buffg;
	private AlphaComposite alphaComposite; // 투명도 조절을 위한 변수
	
	
	
	/*기타 레퍼런스*/
	
	Cookie c1; // 쿠키 (변수를 전역으로 弧)
	Back b11; // 배경 1-1
	Back b12; // 배경 1-2
	Button escBtn; //esc 버튼
	
	
	/* 생성자 */
	
	public CookieRunTest() {
		panel = new MyPanel();
		setTitle("Cookie Run : Stage1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel); // MyPanel 붙이기
		setSize(800, 480); // 창 크기
		setVisible(true); // 보이게 하기
		
		
		/*esc 버튼 관련*/
		
		escBtn = new Button("Restart");
		escBtn.setBounds(350, 240, 100, 30);
		escBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.remove(escBtn);
				escKeyOn = false;
			}
		});
	}

	class MyPanel extends JPanel {
		public MyPanel() {
			
			setFocusable(true); // 키 입력 우선권

			// 쿠키 인스턴스 생성 / 기본자료는 클래스 안에 내장, 이미지 추가
			c1 = new Cookie(cookie.getImage());

			// 쿠키 정면 = 쿠키 X값 + 높이
			face = c1.getX() + c1.getWidth();

			// 쿠키 발 밑 위치 = 쿠키 Y값 + 높이
			foot = c1.getY() + c1.getHealth();
			
			// 배경 1-1 (x좌표 값 : 0)
			b11 = new Back(
					bg1.getImage(), 
					0, 
					0, // y값 수정필요
					bg1.getImage().getWidth(null),
					bg1.getImage().getHeight(null));

			// 배경 1-2 (x좌표 값 : bg1부터 시작)
			b12 = new Back(
					bg1.getImage(), 
					bg1.getImage().getWidth(null), 
					0, // y값 수정필요
					bg1.getImage().getWidth(null), 
					bg1.getImage().getHeight(null));

			
			/* Util Class 안의 getSize와 getPic메서드 이용, 사이즈와 컬러를 가지고옴 */

			try {
				sizeArr = Util.getSize("img/firstMap.png"); // 맵 사이즈
				colorArr = Util.getPic("img/firstMap.png"); // 맵 색상값
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			int maxX = sizeArr[0]; // 맵의 넓이
			int maxY = sizeArr[1]; // 맵의 높이

			

			/* 발판 객체 리스트 생성 */
			
			// 1단 발판 검은색 : 0
			for (int i = 0; i < maxX; i += 2) { // 발판은 4칸을 차지하는 공간, 2,2사이즈로 반복문
				for (int j = 0; j < maxY; j += 2) { // 색 값이 0일 경우 (검은색)
					if (colorArr[i][j] == 0) {
						fieldList.add(new Field(fieldIc1.getImage(), i * 40, j * 40, 80, 80)); // 좌표에 40을 곱하고, 넓이와 높이는 80
																								
					}
				}
			}
			
			// 2단 발판 회색 : 6579300 (추후에 추가하기)
			for (int i = 0; i < maxX; i += 2) { // 발판은 4칸을 차지하는 공간, 2,2사이즈로 반복문
				for (int j = 0; j < maxY; j += 2) { // 색 값이 0일 경우 (검은색)
					if (colorArr[i][j] == 6579300) {
						fieldList.add(new Field(fieldIc2.getImage(), i * 40, j * 40, 80, 80)); // 좌표에 40을 곱하고, 넓이와 높이는 80
																								
					}
				}
			}

			
			
			/* 젤리 객체 리스트 생성 */
			
			// 기본젤리 255, 255, 0 : 16776960
			for (int i = 0; i < maxX; i += 1) { // 젤리는 1칸을 차지, 1,1사이즈로 반복문
				for (int j = 0; j < maxY; j += 1) {
					if (colorArr[i][j] == 16776960) { 
						jellyList.add(new Jelly(jelly.getImage(), i * 40, j*40, 30, 30, 1000)); // 좌표에 40곱하고, 넓이와 높이는 30
					}
				}
			}
			
			// 노랑젤리 200, 200, 0 : 13158400
			for (int i = 0; i < maxX; i += 1) { // 젤리는 1칸을 차지, 1,1사이즈로 반복문
				for (int j = 0; j < maxY; j += 1) {
					if (colorArr[i][j] == 13158400) { 
						jellyList.add(new Jelly(jelly.getImage(), i * 40, j*40, 30, 30, 2000)); // 좌표에 40곱하고, 넓이와 높이는 30
					}
				}
			}

			// 분홍젤리 150, 150, 0 : 9868800
			for (int i = 0; i < maxX; i += 1) { // 젤리는 1칸을 차지, 1,1사이즈로 반복문
				for (int j = 0; j < maxY; j += 1) {
					if (colorArr[i][j] == 9868800) { 
						jellyList.add(new Jelly(jelly.getImage(), i * 40, j*40, 30, 30, 3000)); // 좌표에 40곱하고, 넓이와 높이는 30
					}
				}
			}
			
			
			
			/* 물약 객체 리스트 생성 */
			
			//피물약  255, 100, 0  //  16737280
			for (int i = 0; i < maxX; i += 1) { // 젤리는 1칸을 차지, 1,1사이즈로 반복문
				for (int j = 0; j < maxY; j += 1) {
					if (colorArr[i][j] == 16737280) { 
						jellyList.add(new Jelly(jelly.getImage(), i * 40, j*40, 30, 30, 10000)); // 좌표에 40곱하고, 넓이와 높이는 30
					}
				}
			}
			
			
			
			/* 장애물 객체 리스트 생성  */
			
			//1단장애물 255, 0, 0   //  16711680
			for (int i = 0; i < maxX; i += 2) {
				for (int j = 0; j < maxY; j += 2) {
					if (colorArr[i][j] == 16711680) { // 색 값이 16711680일 경우 (빨간색)
						tacleList.add(new Tacle(tacle.getImage(), i * 40, j * 40, 80, 80, 0));  // 좌표에 40을 곱하고, 넓이와 높이는 80
					}
				}
			}
			
			//2단장애물 255, 0, 150  //  16711830
			for (int i = 0; i < maxX; i += 2) {
				for (int j = 0; j < maxY; j += 2) {
					if (colorArr[i][j] == 16711830) { // 색 값이 16711680일 경우 (빨간색)
						tacleList.add(new Tacle(tacle.getImage(), i * 40, j * 40, 80, 80, 0));  // 좌표에 40을 곱하고, 넓이와 높이는 80
					}
				}
			}
			
			//3단장애물 255, 0, 255  //  16711935
			for (int i = 0; i < maxX; i += 2) {
				for (int j = 0; j < maxY; j += 2) {
					if (colorArr[i][j] == 16711935) { // 색 값이 16711680일 경우 (빨간색)
						tacleList.add(new Tacle(tacle.getImage(), i * 40, j * 40, 80, 80, 0));  // 좌표에 40을 곱하고, 넓이와 높이는 80
					}
				}
			}
			

			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {

						int tempField; // 발판 위치를 계속 스캔하는 변수
						int tempNowField;// snowField를 세팅

						//// 무적화 조건문
						if (c1.isInvincible()) {
							tempNowField = 400;
						} else {
							tempNowField = 2000;
						}

						for (int i = 0; i < fieldList.size(); i++) {
							int tempX = fieldList.get(i).getX(); // 발판의 X값

							if (tempX > c1.getX()-60 && tempX <= face) { // 발판이 캐릭범위안

								tempField = fieldList.get(i).getY(); // 발판의 y값

								foot = c1.getY() + c1.getHeight(); // 캐릭터 발 위치 스캔

								// 발판위치가 tempNowField보다 작고, 발바닥의 위치가 tempField보다 위에 있다면
								if (tempField < tempNowField && tempField >= foot) {

									tempNowField = tempField;
								}
							}
						}
						nowField = tempNowField; // 결과를 nowField에 업데이트

						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();

			/* 낙하스레드 */
			new Thread(new Runnable() {

				public void run() {
					while (true) {
						// 발바닥 위치는 이미지의 Y위치 + 이미지의 높이
						foot = c1.getY() + c1.getHeight(); // 캐릭터 발 위치 재스캔

						// 발바닥이 땅보다 위에 있으면 작동
						if (
							!escKeyOn // 일시중지가 발동 X
							&& foot < nowField // 공중에
							&& !c1.isJump()  // 점프 X
							&& !c1.isFall()) { // 점프중 X, 공중에 있고, 떨어지는 중이 아닐 때 작동

							c1.setFall(true);// 떨어지는 중으로 전환
							System.out.println("낙하");

							if (c1.getCountJump() == 2) { // 더블점프 X, 낙하 이미지로 변경
								c1.setImage(cookieFall.getImage());
							}

							long t1 = Util.getTime(); // 현재시간을 가져온다
							long t2;
							int set = 2; // 처음 낙하랑 (0~10)까지 테스트

							while (foot < nowField) { // 발이 땅에 닿기 전까지 반복
								t2 = Util.getTime() - t1; // 지금 시간에서 t1을 뺀다
								int fallY = set + (int) ((t2) / 40); // 낙하량을 늘린다.

								foot = c1.getY() + c1.getHeight(); // 캐릭터 발 위치 재 스캔

								if (foot + fallY > nowField) {
									fallY = nowField - foot;
								}

								c1.setY(c1.getY() + fallY); // Y좌표에 낙하량 더하기

								if (c1.isJump()) { // 떨어지다가 더블 점프를 하면 낙하중지
									break;
								}

								try {
									Thread.sleep(10);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							c1.setFall(false); // while문이 끝나면 다시 false
							
							
							if (
									downKeyOn // 다운키 누르고
									&& !c1.isJump() // 점프상태 X
									&& !c1.isFall() // 낙하상태 X
									&& c1.getImage() != cookieDown.getImage()) { // 쿠키이미지가 슬라이드 이미지가 X

								c1.setImage(cookieDown.getImage());
								; // 누운 이미지로 변경

							} else if (
									!downKeyOn // 다운키 누른상태 X
									&& !c1.isJump() // 점프상태 X
									&& !c1.isFall() // 낙하상태 X
									&& c1.getImage() != cookie.getImage()) { // 쿠키이미지가 기본 이미지가 X

								c1.setImage(cookie.getImage());
							}

							if (!c1.isJump()) { // 발이 땅에 닿고, 점프중이 X, 더블점프 카운트 0
								c1.setCountJump(0);
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

			
			
			/*repaint 전용 스레드*/
			
			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						repaint();
						
						if(escKeyOn) {
							while(escKeyOn) { //esc키 누르면 repaint 멈춤
								try {
									Thread.sleep(10);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
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


			/* 키 어댑터 */
			this.addKeyListener(new KeyAdapter() {

				@Override
				public void keyPressed(KeyEvent e) {
					
					
					if(e.getKeyCode() == KeyEvent.VK_ESCAPE) { // ESC 키를 누르면 일시정지하기
						if(!escKeyOn) {
							escKeyOn = true;
							add(escBtn); // esc를 누르면 escKeyOn변수가 true가 되고 버튼을 화면에 보이게함
							repaint(); // 화면 어둡게 하기 위한 repaint
						}else {
							remove(escBtn);
							escKeyOn = false;
						}
					}
					
					if(!escKeyOn) { // esc가 없을 때에만 작동
						if (e.getKeyCode() == KeyEvent.VK_SPACE && c1.getCountJump() < 2) { // jump == false
							new Up();

						}
						if (e.getKeyCode() == KeyEvent.VK_DOWN) {

							downKeyOn = true;

							if (
								c1.getImage() != cookieDown.getImage()
								&& !c1.isJump() 
								&& !c1.isFall()) {

								c1.setImage(cookieDown.getImage());// 누웠을 때 이미지 변경
							}
						}
					}
					
				}

				@Override
				public void keyReleased(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_DOWN) {

						downKeyOn = false; // downKeyOn 변수를 false로

						if (
							c1.getImage() != cookie.getImage() // 쿠키이미지가 기본이미지 X
							&& !c1.isJump()  // 점프중 X
							&& !c1.isFall()) { // 낙하중 X

							c1.setImage(cookie.getImage()); // 이미지를 기본이미지로 변경
						}
					}
					
				}
			});
		}

		
		/* 화면 구현 */
		
		@Override
		protected void paintComponent(Graphics g) {
			
			// 더블버퍼
			if (buffg == null) {
				buffImage = createImage(this.getWidth(), this.getHeight());
				if (buffImage == null) {
					System.out.println("더블 버퍼링용 오프 스크린 생성 실패");
				} else {
					buffg = buffImage.getGraphics();
				}
			}

			// 투명도
			Graphics2D g2 = (Graphics2D) buffg;

			super.paintComponent(buffg); // 이전 이미지를 지운다.

			// 배경
			buffg.drawImage(b11.getImage(), b11.getX(), 0, null);
			buffg.drawImage(b12.getImage(), b12.getX(), 0, null);

			// 고정 배경
			buffg.drawImage(bg2.getImage(), 0, 0, null);
						
			// 발판
			for (int i = 0; i < fieldList.size(); i++) {

				Field tempFoot = fieldList.get(i);

				if (tempFoot.getX() > -90) {
					
					buffg.drawImage(

							tempFoot.getImage(), 
							tempFoot.getX(), 
							tempFoot.getY(),
							tempFoot.getWidth(),
							tempFoot.getHeight(), 
							null);
				}
			}

			// 젤리
			for (int i = 0; i < jellyList.size(); i++) {

				Jelly tempJelly = jellyList.get(i);

				if (tempJelly.getX() > -90) {

					buffg.drawImage(

							tempJelly.getImage(), 
							tempJelly.getX(), 
							tempJelly.getY(), 
							tempJelly.getWidth(),
							tempJelly.getHeight(), 
							null);
				}
			}

			// 장애물
			for (int i = 0; i < tacleList.size(); i++) {

				Tacle tempTacle = tacleList.get(i);

				if (tempTacle.getX() > -90 && tempTacle.getX() < 810) {

					buffg.drawImage(

							tempTacle.getImage(), 
							tempTacle.getX(), 
							tempTacle.getY(), 
							tempTacle.getWidth(),
							tempTacle.getHeight(), 
							null);
				}
			}

			
			/* 젤리 이동 및 동작 */
			
			for (int i = 0; i < jellyList.size(); i++) {
				Jelly tempJelly = jellyList.get(i);

				if (tempJelly.getX() < -90) {
					fieldList.remove(tempJelly);

				} else {
					tempJelly.setX(tempJelly.getX() - gameSpeed);
					
					foot = c1.getY() + c1.getHeight(); // 캐릭터 발 위치 재 스캔

					if (	c1.getImage() != cookieDown.getImage()
							&& tempJelly.getX() >= c1.getX()
							&& tempJelly.getX() <= face
							&& tempJelly.getY() >= c1.getY()
							&& tempJelly.getY() <= foot
							&& tempJelly.getImage() != effect.getImage()){
							
						tempJelly.setImage(effect.getImage()); // 젤리 이미지 이펙트로 바꾸기
						resultScore = resultScore + tempJelly.getScore();
						
					}else if(
							c1.getImage() == cookieDown.getImage()
							&& tempJelly.getX() + tempJelly.getWidth()*20/100 >= c1.getX()
							&& tempJelly.getX() + tempJelly.getWidth()*80/100 <= face
							&& tempJelly.getY() + tempJelly.getHeight()*20/100 >= c1.getY() + c1.getHeight()*1/3
							&& tempJelly.getY() + tempJelly.getHeight()*80/100 <= foot
							&& tempJelly.getImage() != effect.getImage()) {
							
							tempJelly.setImage(effect.getImage());
							resultScore = resultScore + tempJelly.getScore();
					}
				}

				buffg.drawImage(tempJelly.getImage(), tempJelly.getX(), tempJelly.getY(), tempJelly.getWidth(),
						tempJelly.getHeight(), null);
			}

			/////////////////// 캐릭터가 장애물에 부딪히면 캐릭터 상태가 무적으로 변경 /////////////////////////
			for (int i = 0; i < tacleList.size(); i++) {
				Tacle tempTacle = tacleList.get(i);

				
				////////////////// 무적 /////////////////////
				if (tempTacle.getX() < -90) {
					fieldList.remove(tempTacle);
				} else {
					tempTacle.setX(tempTacle.getX() - gameSpeed);
					
					foot = c1.getY() + c1.getHeight(); // 캐릭터 발 위치 재스캔
					
					if ( // 무적상태 X, 캐릭터의 범위 안에 장애물이 있으면
							!c1.isInvincible()
							&& tempTacle.getX() >= c1.getX()
							&& tempTacle.getX() <= face
							&& tempTacle.getY() >= c1.getY()
							&& tempTacle.getY() <= foot) {
						
							hit();
					}
				}			
				
				buffg.drawImage(tempTacle.getImage(), tempTacle.getX(), tempTacle.getY(), tempTacle.getWidth(),
						tempTacle.getHeight(), null);
			}

			
						
			// 쿠키 알파값
			alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) c1.getAlpha() / 255);
			g2.setComposite(alphaComposite);

			// 쿠키 그리기
			buffg.drawImage(c1.getImage(), c1.getX(), c1.getY(), c1.getWidth(), c1.getHeight(), null);

			// 알파값 되돌리기
			alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 255 / 255);
			g2.setComposite(alphaComposite);

			// 점수
			buffg.drawString("Score : " +Integer.toString(resultScore), 700, 30);

			// 체력게이지
			buffg.fillRect(50, 40, c1.getHealth() /2, 30);

			
			// 화면에 출력
			g.drawImage(buffImage, 0, 0, null);

//			buffg.drawLine(0, 0, 0, 500); // 범위 보기
//			buffg.drawLine(80, 0, 80, 500); // 범위 보기
		}

	}

	class Up {

		public Up() {
			///////////////////////////////// 점프 동작 구현 ///////////////////////////
			new Thread(new Runnable() {

				@Override
				public void run() {

					c1.setCountJump(c1.getCountJump() + 1); // 점프횟수 증가

					int nowJump = c1.getCountJump();
					int nowY = c1.getY();

					c1.setJump(true);

					if (c1.getCountJump() == 1) {
						
						System.out.println("점프");
						c1.setImage(cookieJump.getImage());

					} else if (c1.getCountJump() == 2) {
						
						System.out.println("더블점프");
						c1.setImage(cookieDJump.getImage());
					}

					long t1 = Util.getTime(); // 현재시간 가져오기
					long t2;
					int set = 8; // 점프 계수 설정(0~20)으로 바꿔보기
					int jumpY = 1; // 1이상으로만 설정하면 된다. (while문 조건 때문에)

					while (jumpY >= 0) { // 높이가 0일 때 까지 반복

						t2 = Util.getTime() - t1; // 지금 시간에서 t1 빼기
						jumpY = set - (int) ((t2) / 40); // jump 세팅

						c1.setY(c1.getY() - jumpY); // Y값 변경

						/// 더블점프 추가한부분 시작
						if (nowJump != c1.getCountJump()) { // 점프가 한번 더 되면 첫번째 점프는 멈춤
							break;
						}

						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					if (nowJump == c1.getCountJump()) { // 점프가 진짜 끝났을 때를 확인
						c1.setJump(false);
					}
				}
			}).start();
		}
	}
	
	/* 캐릭터 체력 자연 감소, 배경이동 메서드 */
	void mapMove() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					if(runPage > 800) { //한 프레임을 이동하면 체력이 10씩 감소 (추후 수정)
						c1.setHealth(c1.getHealth() - 10);
						runPage = 0;
					}
					runPage += gameSpeed; // 화면이 이동하면 reunPage에 이동한 만큼 저장
					
					// 배경 이동
					if (b11.getX() < -(b11.getWidth() - 1)) {
						b11.setX(b11.getWidth());
					}
					
					if (b12.getX() < -(b12.getWidth() - 1)) {
						b12.setX(b12.getWidth());
					}
					
					// 배경의 X좌표를 -1 해준다 (왼쪽으로 흐름)
					b11.setX(b11.getX() - gameSpeed / 3);
					b12.setX(b12.getX() - gameSpeed / 3);
					
					
					/* 발판 이동 */
					for (int i = 0; i < fieldList.size(); i++) {
						
						Field tempField = fieldList.get(i); // 임시 변수에 리스트 안에 있는 개별 발판 불러오기
						
						if(tempField.getX() < -90) { // 발판의 x좌표가 -90미만이면 해당발판 제거
							fieldList.remove(tempField);
						}else {
							tempField.setX(tempField.getX() - gameSpeed); // 조건 해당 X시, x좌표 줄이기
						}
					} 
				}
			}
		}).start();
	} // end of mapMove
	
	
	
	/* 캐릭터가 공격당했을 때의 메서드 */
	
	void hit() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// 무적상태
				c1.setInvincible(true);

				System.out.println("무적상태");

				// 쿠키 체력
				c1.setHealth(c1.getHealth() - 100); 
				
				// 게이지 확인
				System.out.println(c1.getHealth()); 
				
				// 쿠키 투명도
				c1.setAlpha(80);

				// 쿠키 모션 변경
				c1.setImage(cookieHit.getImage());

				// 0.5초 대기
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				// 다시 기본 이미지로 변경
				if (c1.getImage() == cookieHit.getImage()) {
					c1.setImage(cookie.getImage());
				}

				// 2.5초동안 깜빡이기
				for (int j = 0; j < 11; j++) {
					if (c1.getAlpha() == 80) {
						c1.setAlpha(160);
					} else {
						c1.setAlpha(80);
					}
					try {
						Thread.sleep(250);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				c1.setAlpha(255);

				c1.setInvincible(false);
				System.out.println("무적종료");
			}
		}).start();
	} // end of hit

	/* 낙하 스레드 */
	void fall() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
			}
		}).start();
	}
	
	public static void main(String[] args) {
		new CookieRunTest();
	}

}