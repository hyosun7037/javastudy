package javaGame;

import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.imageio.ImageIO;

public class Util {

	// �̹��� ������ ��������
	public static int[] getSize(String src) throws Exception {
		File imgf = new File(src);
		BufferedImage img = ImageIO.read(imgf);
		int width = img.getWidth();
		int height = img.getHeight();
		int[] tempSize = { width, height };
		return tempSize;
	}

	// �̹��� �ȼ��� ��������
	public static int[][] getPic(String src) throws Exception{ // �Ʒ��ڵ�� �����ؼ� ��밡��
		File imgf = new File(src);
		BufferedImage img = ImageIO.read(imgf);
		int width = img.getWidth();
		int height = img.getHeight();
		int[] pixels = new int[width*height];
		PixelGrabber grab = new PixelGrabber(img, 0, 0, width, height, pixels, 0, width);
		grab.grabPixels();
		
		int[][] picture = new int[width][height];
		for(int i=0; i<pixels.length; i++)
			picture[i%width][i/width]= pixels[i] + 16777216;
		return picture;
	}

	
	// ����ð� ��������
	static long getTime() {
		return Timestamp.valueOf(LocalDateTime.now()).getTime();
	}
	
//	public static void main(String[] args) {
//		try {
//			System.out.println(getPic("img/footTest.png")[0][0]);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	// �迭�� ���� ������ �� ���
	// substring���� ���� ���� �˻�
//		static int getGround(String ground, int index) {
//			return Integer.parseInt(ground.substring(index, index + 1));
//		}

}