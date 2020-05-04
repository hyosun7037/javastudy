
// 쿠키런 테스트

package CookieRun;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CookieRunTest extends JFrame{
	
	MyPanel panel;
	
	///// 이미지 넣기 /////
	
	// 발판 이미지
	ImageIcon footTest = new ImageIcon("img/footTest.png"); 
	Image ft = footTest.getImage();
	
	// bg 움직이는 이미지
	ImageIcon MoveBg = new ImageIcon("img/bg1.png");
	Image mb = MoveBg.getImage();
	
	// bg 고정 이미지
	ImageIcon StaticBg = new ImageIcon("img/bg2.png");
	Image sb = StaticBg.getImage();
	
	int mb1 = 0;
	int sb1 = mb.getWidth(null);
	
	// 원본 이미지
	ImageIcon cookieTest = new ImageIcon("img/cookieTest.png");
	Image c = cookieTest.getImage();
	
	// 슬라이딩 이미지
	ImageIcon fallTest = new ImageIcon("img/fallTest.png");
	Image fall = fallTest.getImage();
		
	// 점프이미지
	ImageIcon jumpTest = new ImageIcon("img/jumpTest.png");
	Image jump = jumpTest.getImage();
	
	// 더블점프 이미지
	ImageIcon doubleJumpTest = new ImageIcon();
	
	public CookieRunTest() {

	}
	
	class MyPanel extends JPanel{
		
	}

	public static void main(String[] args) {
		new CookieRunTest();
	}

}
