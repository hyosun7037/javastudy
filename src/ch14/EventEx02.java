package ch14;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.midi.Soundbank;
import javax.swing.JButton;
import javax.swing.JFrame;

public class EventEx02 extends JFrame implements ActionListener {

	EventEx02 ex02; // 변수 선언

	public EventEx02() {
		setTitle("Action 이벤트 리스너 예제");
		// 이벤트 분배 스레드 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JButton btn = new JButton("Action");
		// 리스너 생성
		btn.addActionListener(this); // 안에 타겟을 넣어야함
		c.add(btn);

		setSize(350, 150);
		setVisible(true); // paint()함수 호출

	} // end of 생성자

	public static void main(String[] args) {
		new EventEx02();
	}

	@Override // 타켓(EventEx02가 가지고 있음)
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼클림됨");
	}

}
