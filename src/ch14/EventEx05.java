package ch14;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EventEx05 extends JFrame {

	private JLabel la; // 선언만! 여기다가 new는 왠만하면 하지 말기!

	public EventEx05() {
		la = new JLabel("Hello");
		setTitle("MouseEvent 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 이벤트 분배 스레드 끄는 것
		Container c = getContentPane(); // 패널 가져오기
		c.addMouseListener(new MymouseListener()); // l은 다 인터페이스
		c.setLayout(null); // absolute 레이아웃
		la.setSize(50, 20); // 라벨의 사이즈
		la.setLocation(30, 30); // 라벨의 위치
		c.add(la);
		setSize(250, 250);
		setVisible(true);
	}

	class MymouseListener extends MouseAdapter { // 추상메서드 구현할 게 너무 많으니까 어댑터로 걸러주기

		// 마우스 오버 효과
		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX(); // x좌표
			int y = e.getY(); // y좌표
			la.setLocation(x, y); // 라벨 위치 변경 = repaint()
			// 사용할 것만 오버라이딩 시키기
			
			
			for (int i = 0; i < la.getY(); i++) {
				

			}
			repaint();
		}

	}

	public static void main(String[] args) {
		new EventEx05();
	}

}
