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
////���۸����� ���� �����
////���Ѿ�� ������ ���ǹ� �ֱ� (�ذ�)
////�����ؾ��� ��� : ������ ����, ���� �Ծ��� �� ��ȭ�� �ֱ�
////������ ������ Ŀ����
////�߰��߰� ĳ���͵��� ���ƴٴϰ� �ϱ�
////�� �����̱� (�ذ�)
////�� ������ ���� ������ �̵�?
//
////���� �ܰ�
////1. ���� �ڷ� �̵� ��ų �� �ִ�. O
////
////1-1. ���� ���� ���ѹݺ� �� �� �ִ�. O
////
////2. �ʰ� �Բ� ������ �ڷ� �̵� ��ų �� �ִ�. 
////
////3. ĳ���Ͱ� �����ϰų� ���� �� �ִ�.
////
////4. ĳ���Ϳ� ������ ������ ������ ������� �� �� �ִ�.
////
////5. ü�°������� �����, �������� 0�� �Ǹ� ���� ������ �ǰ� �� �� �ִ�.
////
////6. ���� ������, �������� ���� ������, ����������� ���� �� �ִ�.
////
////7. �Ŵ�ȭ�� �� �� �ִ�.
////
////8. ����ȭ�� �� �� �ִ�.
////
////9. ��Ÿ
//
//
//public class MarioNew_origin extends JFrame{
//
//   
//   
//   MousePanel panel; // ���پ��Ŵ� �� �������� ������!
////   int imgX = 50;
////   int imgY = 870; //1�����
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
//   boolean spaceP = true; //���� ����
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
//   int b2 = b.getWidth(null); //������� �̹���
//   
////   ImageIcon cookie = new ImageIcon("img/c1.png");
////   ImageIcon cookie2 = new ImageIcon("img/c2.png");
////   ImageIcon cookie3 = new ImageIcon("img/c3.png");
////   Image c = cookie.getImage(); // �̹��� ��������
//   
//   ImageIcon cookie = new ImageIcon("img/ch_fire.gif");
//   Image c = cookie.getImage();
//   
//   ImageIcon cookie2 = new ImageIcon("img/ch_fire_down.gif");
//   Image c2 = cookie2.getImage();
//   
//   
//   //���� �̹���
//   ImageIcon cookieJump = new ImageIcon("img/ch_fire_jump.gif");
//   Image cj = cookieJump.getImage();
//
//
//
//   
//   //// ������////
//   public MarioNew_origin() {
//      panel = new MousePanel();
//      setTitle("Cookie Run : Fire Stage");
//      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////      setLocationRelativeTo(null);
//      setContentPane(panel); // MousePanel ���̱�
////      setSize(1673, 1046); // ���1�� ũ�� ����
//      setSize(970, 400); // ���2�� ũ�� ����
//      setVisible(true); // ���̰� �ϱ�
//      setResizable(false); //ũ�������Ұ�
//   }
//
//
//      
//   
//   //// �׸��׸���////
//   class MousePanel extends JPanel implements Runnable {
//      
//      public MousePanel() { // ������
//         setFocusable(true);
//         Thread re = new Thread(new Runnable() {
//            @Override // ��� ĳ���Ϳ� �ݴ�������� ������ �̵�
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
//         re.start(); //��� �ݺ�
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
//                        }; //�Ʒ��� ������ �����ִ� �̹���
//                        
//                        public void keyReleased(KeyEvent e) {
//                        	if(c ==cookie2.getImage()) {
//                        		c = cookie.getImage();
//                        		repaint();
//                        	}                        	
//                        };
//                     }); //�Ʒ��� ���� �ٽ� ���� �̹���
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
//                          }; //�Ʒ��� ������ �����ִ� �̹���
//                          
//                          public void keyReleased(KeyEvent e) {
//                          	if(c ==cookieJump.getImage()) {
//                          		c = cookie.getImage();
//                          		repaint();
//                          	}                        	
//                          };
//                       }); //ĳ���� ����
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
//                        }).start();// ������ ��
//                     }
//
//                     break;
//                  }
//               } else {
//                  imgX = 1;
//               }
////               repaint(); 
//            } // ĳ���� ����
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
//         g.drawImage(b,b1, 0, this); //���
//         g.drawImage(b,b2, 0, this); //�ڵ��� ���� ���
////         g.drawImage(ma, imgX, imgY, 60, 70, this); 1�� ���
//         g.drawImage(c, imgX, imgY, 150, 150, this); //ĳ����
//         g.drawImage(l, 0, 72, 970, 300, this); //�� ���
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