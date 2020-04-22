package ch14;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EventEx06 extends JFrame {

	int imgX = 210;
	int imgY = 55;

	public EventEx06() {
		setTitle("��ǳ����");
		setSize(700, 300);
		setLocationRelativeTo(null);
//		Container c = getContentPane(); 
		setContentPane(new MyPanel()); // panel �ٲٱ�
		setVisible(true);

	}

	// PaintComponent �Լ��� JFrame �ȿ��� �۵�����
	class MyPanel extends JPanel {

		public MyPanel() {
			setFocusable(true);
			this.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) { // ������ �͸� ����, �������� adapter���� �ѱ��

					System.out.println("keycode : " + e.getKeyCode());
					System.out.println("keychar : " + e.getKeyChar());

					switch (e.getKeyCode()) {
					case KeyEvent.VK_LEFT: // ���� Ű�� Ŭ���ϸ� �۵�
						imgX = imgX - 10;
						break; // break�� �ɾ�� ���� ������ �˻� X
					case KeyEvent.VK_RIGHT:
						imgX = imgX + 10;
						break;
					case KeyEvent.VK_SPACE:
						new Thread(new Runnable() {

							@Override
							public void run() {
								int time = 5;
								while (time > 0) {
									imgY = imgY + 20;
									time--;
									try {
										Thread.sleep(100); // Ÿ�ӽ����ֱ�
									} catch (Exception e1) {
										e1.printStackTrace();
									}
									repaint();
								}
							}
						}).start();
						break;
					}
					repaint();
				}
			});
		}

		@Override // ���氪�� ����ٰ� �����ؾ���
		public void paintComponent(Graphics g) { // �������� �ٲ�� ������ ����ٰ� �׸� �׸���
//			System.out.println("�׸��׸���");
			super.paintComponent(g);
			ImageIcon imgIce = new ImageIcon("img/ice.png"); // �̹��� ������ ��ü
			ImageIcon imgIce2 = new ImageIcon("img/ice2.png");

			// �̹��� ����

			Image Ice = imgIce.getImage();
			Image Ice2 = imgIce2.getImage();

			// g�� ������ �׸��׸��ٰ� ����
			g.drawImage(Ice, 0, 0, null);
			g.drawImage(Ice2, imgX, imgY, null);
		}
	}

	public static void main(String[] args) {
		new EventEx06();
	}

}
