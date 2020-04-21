//package ch14;
//
//import java.awt.Graphics;
//
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
//import net.nurigo.java_sdk.api.Image;
//
//public class GraphicDrawImageEx1 extends JFrame{
//
//	private MyPanel4 panel = new MyPanel4();
//	
//	public GraphicDrawImageEx1() {
//		setTitle("원본 크기로 원하는 위치에 이미지 그리기");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setContentPane(panel);
//		
//		setSize(300,420);
//		setVisible(true);
//	}
//	
//	class MyPanel4 extends JPanel{
//		
//		private ImageIcon icon = new ImageIcon("image/ice.png");
//		private Image img = icon.getImage();
//		
//		public void paintComponent(Graphics g) {
//			super.paintComponent(g);
//			
//			g.drawImage(img, 20, 20, this);
//			
//		}
//	}
//	
//	public static void main(String[] args) {
//		new GraphicDrawImageEx1();
//	}
//
//}
