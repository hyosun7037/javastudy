package test;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class EatJelly {

	private JFrame frame;

	ImageIcon item = new ImageIcon("image/item.gif");
	ImageIcon effIc = new ImageIcon("image/effTest1.png");
	
	Jelly j1;
	Jelly j2;
	
	private AlphaComposite alphaComposite; // ���� ������ ���� ����
	
	class MyPanel extends JPanel{
		public MyPanel() {
			j1 = new Jelly(item.getImage(), 500, 150, 20, 20, 255);
			j2 = new Jelly(item.getImage(), 600, 150, 20, 20, 255);
			
			/////////////////// ������ �̵�, �̹��� ����, ���İ� ���� /////////////////////
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					while(true) {
						// �������� �������� �̵�
						j1.setX(j1.getX()-1);
						j2.setX(j2.getX()-1);
						
						// ������ ���� �ȿ� ������ �̹����� �ٲٰ� ���İ��� ���δ�.
						if(j1.getX() < 300) {
							j1.setImage(effIc.getImage());
							
							if(j1.getAlpha()>1) {
								j1.setAlpha(j1.getAlpha() - 2);
							}
						}
						if(j2.getX() < 300) {
							j2.setImage(effIc.getImage());
							
							if(j2.getAlpha() > 1) {
								j2.setAlpha(j2.getAlpha() - 2);
							}
						}
						repaint();
						
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
		}
		// �̹��� �׸���
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g; // ����ȭ ��ų���� Graphics2D ���
			
			// ���� ���
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			
			// �����
			g.setColor(Color.WHITE);
			g.drawLine(300, 0, 300, this.getHeight());
			
			// ���İ� ����
			alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)j1.getAlpha()/255);
			g2.setComposite(alphaComposite);
			
			// ����1 �׸���
			g.drawImage(j1.getImage(), j1.getX(), j1.getY(), j1.getWidth(), j1.getHeight(), null);
			
			alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)j2.getAlpha()/255);
			g2.setComposite(alphaComposite);
			
			// ����2 �׸���
			g.drawImage(j2.getImage(), j2.getX(), j2.getY(), j2.getWidth(), j2.getHeight(), null);
		}
	}
	
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EatJelly window = new EatJelly();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EatJelly() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new MyPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
	}

}
