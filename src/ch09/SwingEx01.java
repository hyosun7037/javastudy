package ch09;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyButton extends JButton{
	//커스터마이징 할 디자인 소스, 오버라이딩 해서 사용
}

public class SwingEx01 extends JFrame { // swing 자바 스윙 상속

	public SwingEx01() { // 생성자 생성
		setTitle("첫번째 프레임"); // 프레임은 윈도우 창
		setSize(500, 300);
		add(new JButton("클릭"));
		setVisible(true);
	}

	public static void main(String[] args) {
		new SwingEx01();
	}

}
