package ch14;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class te extends JFrame {

	int imgX = 140;
	int imgY = 180;
	
	public te() {
		setTitle("장풍 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 300);
		setLocationRelativeTo(null); // 프레임이 화면 가운데 배치 
		setContentPane(new MyPanel());
		setVisible(true);
	}

	// paintComponent 함수는 Frame 안에서 작동하지 않는다.
	class MyPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			ImageIcon imgBear = new ImageIcon("img/ice.png");
			ImageIcon imgPa = new ImageIcon("img/ice2.png");
			
			// 이미지 추출
			Image bear = imgBear.getImage();
			Image pa = imgPa.getImage();
			
			g.drawImage(bear, 0,0,null);
			g.drawImage(pa, imgX, imgY, null);
		}
	}
	
	public static void main(String[] args) {
		new te();
	}

}