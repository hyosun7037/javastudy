//package javaGame;
//
//import java.awt.Graphics;
//import java.awt.Image;
//import java.awt.event.ActionEvent;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
////슈퍼마리오 게임 만들기
////벽넘어서는 못가게 조건문 넣기 (해결)
////구현해야할 기능 : 포물선 점프, 버섯 먹었을 때 변화값 주기
////버섯을 먹으면 커지기
////중간중간 캐릭터들이 날아다니게 하기
////맵 움직이기 (해결)
////맵 끝나면 다음 맵으로 이동?
//
////구현 단계
////1. 맵을 뒤로 이동 시킬 수 있다. O
////
////1-1. 같은 맵을 무한반복 할 수 있다. O
////
////2. 맵과 함께 젤리를 뒤로 이동 시킬 수 있다. 
////
////3. 캐릭터가 점프하거나 누을 수 있다.
////
////4. 캐릭터와 젤리가 만나면 젤리가 사라지게 할 수 있다.
////
////5. 체력게이지를 만들고, 게이지가 0이 되면 게임 오버가 되게 할 수 있다.
////
////6. 대기실 페이지, 스테이지 선택 페이지, 결과페이지를 만들 수 있다.
////
////7. 거대화를 할 수 있다.
////
////8. 가속화를 할 수 있다.
////
////9. 기타
//
//
//public class MarioNew_origin extends JFrame{
//
//   
//   
//   MousePanel panel; // 갖다쓸거는 다 전역으로 빼놓기!
////   int imgX = 50;
////   int imgY = 870; //1번배경
//
//   int imgX = 0;
//   int imgY = 70;
//
//   int bx = 0;
//   
//   int imgBgX = 0;
//   int imgBgY = 0;
//   
//   int fieldY = 900;
//   boolean spaceP = true; //점프 변수
//   
//
//   ImageIcon bg = new ImageIcon("img/BgForest.png");
//   Image b = bg.getImage();
//
//   
//   ImageIcon land = new ImageIcon("img/land.png");
//   Image l = land.getImage();
//   
//   
//   int b1 = 0;
//   int b2 = b.getWidth(null); //따라오는 이미지
//   
////   ImageIcon cookie = new ImageIcon("img/c1.png");
////   ImageIcon cookie2 = new ImageIcon("img/c2.png");
////   ImageIcon cookie3 = new ImageIcon("img/c3.png");
////   Image c = cookie.getImage(); // 이미지 가져오기
//   
//   ImageIcon cookie = new ImageIcon("img/ch_fire.gif");
//   Image c = cookie.getImage();
//   
//   ImageIcon cookie2 = new ImageIcon("img/ch_fire_down.gif");
//   Image c2 = cookie2.getImage();
//   
//   
//   //점프 이미지
//   ImageIcon cookieJump = new ImageIcon("img/ch_fire_jump.gif");
//   Image cj = cookieJump.getImage();
//
//
//
//   
//   //// 생성자////
//   public MarioNew_origin() {
//      panel = new MousePanel();
//      setTitle("Cookie Run : Fire Stage");
//      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////      setLocationRelativeTo(null);
//      setContentPane(panel); // MousePanel 붙이기
////      setSize(1673, 1046); // 배경1번 크기 조정
//      setSize(970, 400); // 배경2번 크기 조정
//      setVisible(true); // 보이게 하기
//      setResizable(false); //크기조정불가
//   }
//
//
//      
//   
//   //// 그림그리기////
//   class MousePanel extends JPanel implements Runnable {
//      
//      public MousePanel() { // 옆으로
//         setFocusable(true);
//         Thread re = new Thread(new Runnable() {
//            @Override // 배경 캐릭터와 반대방향으로 옆으로 이동
//            public void run() {
//               while(true) { 
//                 b1 =  b1-5;
//                 b2 =  b2-5;
//                  
//                  if(b1 < -(b.getWidth(null))) {
//                     b1 = b.getWidth(null)-5;
//                  }
//                  if(b2 < -(b.getWidth(null))) {
//                     b2 = b.getWidth(null)-5;
//                  }
//                  repaint();
//                  try {
//                     Thread.sleep(20);
//                  } catch (InterruptedException e) {
//                     e.printStackTrace();
//                  }
//               }
//            }
//         });
//         re.start(); //배경 반복
//         
//
//         this.addKeyListener(new KeyAdapter() {
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//               if (imgY + b.getHeight(null) > fieldY) {
//                  imgY = fieldY;
//               }
//               if (imgX > 0) {
//                  switch (e.getKeyCode()) {
//                  case KeyEvent.VK_DOWN:
//                	  addKeyListener(new KeyAdapter() {
//                        public void keyPressed(KeyEvent e) {
//                              if(c == cookie.getImage()) {
//                                 c = cookie2.getImage();
//                                 repaint();
//                              }
//                        }; //아래로 누르면 누워있는 이미지
//                        
//                        public void keyReleased(KeyEvent e) {
//                        	if(c ==cookie2.getImage()) {
//                        		c = cookie.getImage();
//                        		repaint();
//                        	}                        	
//                        };
//                     }); //아래를 떼면 다시 원래 이미지
//                     break;
//
//                  case KeyEvent.VK_SPACE:
//
//                	  addKeyListener(new KeyAdapter() {
//                          public void keyPressed(KeyEvent e) {
//                                if(c == cookie.getImage()) {
//                                   c = cookieJump.getImage();
//                                   repaint();
//                                }
//                          }; //아래로 누르면 누워있는 이미지
//                          
//                          public void keyReleased(KeyEvent e) {
//                          	if(c ==cookieJump.getImage()) {
//                          		c = cookie.getImage();
//                          		repaint();
//                          	}                        	
//                          };
//                       }); //캐릭터 변경
//                	  
//                	  
//                     if (spaceP) {
//                        new Thread(new Runnable() {
//
//                           @Override
//                           public void run() {
//                              spaceP = false;
//                              
//                              int time = 60;
//                              
//                              
//                              while (time > 0) {
//                                 if (time > 30) {
//                                    imgY = imgY - 3;
//                                 } else {
//                                    imgY = imgY + 3;
//                                 }
//                                 time--;
//
//                                 try {
//                                    Thread.sleep(10);
//                                 } catch (Exception e) {
//                                    e.printStackTrace();
//                                 }
//
//                              }
//
//                              spaceP = true;
//                           }
//                        }).start();// 스레드 끝
//                     }
//
//                     break;
//                  }
//               } else {
//                  imgX = 1;
//               }
////               repaint(); 
//            } // 캐릭터 점프
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//
//               super.keyReleased(e);
//            }
//         });
//      }
//
//
//      public void actionPerformed(ActionEvent e) {
//         
//      }
//      
//      @Override
//      protected void paintComponent(Graphics g) {
//         super.paintComponent(g);
//         
//         g.drawImage(b,b1, 0, this); //배경
//         g.drawImage(b,b2, 0, this); //뒤따라 오는 배경
////         g.drawImage(ma, imgX, imgY, 60, 70, this); 1번 배경
//         g.drawImage(c, imgX, imgY, 150, 150, this); //캐릭터
//         g.drawImage(l, 0, 72, 970, 300, this); //땅 배경
//         
//      }
//
//      @Override
//      public void run() {
//      }
//
//   }
//
//   
//   public static void main(String[] args) {
//      new MarioNew_origin();
//   }
//
//}