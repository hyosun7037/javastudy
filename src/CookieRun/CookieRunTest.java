
// ��Ű�� �׽�Ʈ

package CookieRun;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CookieRunTest extends JFrame{
	
	MyPanel panel;
	
	///// �̹��� �ֱ� /////
	
	// ���� �̹���
	ImageIcon footTest = new ImageIcon("img/footTest.png"); 
	Image ft = footTest.getImage();
	
	// bg �����̴� �̹���
	ImageIcon MoveBg = new ImageIcon("img/bg1.png");
	Image mb = MoveBg.getImage();
	
	// bg ���� �̹���
	ImageIcon StaticBg = new ImageIcon("img/bg2.png");
	Image sb = StaticBg.getImage();
	
	int mb1 = 0;
	int sb1 = mb.getWidth(null);
	
	// ���� �̹���
	ImageIcon cookieTest = new ImageIcon("img/cookieTest.png");
	Image c = cookieTest.getImage();
	
	// �����̵� �̹���
	ImageIcon fallTest = new ImageIcon("img/fallTest.png");
	Image fall = fallTest.getImage();
		
	// �����̹���
	ImageIcon jumpTest = new ImageIcon("img/jumpTest.png");
	Image jump = jumpTest.getImage();
	
	// �������� �̹���
	ImageIcon doubleJumpTest = new ImageIcon();
	
	public CookieRunTest() {

	}
	
	class MyPanel extends JPanel{
		
	}

	public static void main(String[] args) {
		new CookieRunTest();
	}

}
