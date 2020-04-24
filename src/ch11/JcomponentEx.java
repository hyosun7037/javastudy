package ch11;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JcomponentEx extends JFrame {

	private JButton b1, b2, b3; // heap으로 관리해야 다른 곳에서도 사용가능

	public JcomponentEx() {
		Container c = getContentPane();
		c.setLayout(new FlowLayout()); // 원래 borderLayout인데 FlowLayout으로 바꿔줌
		setTitle("Jcomponent의 공통 메소드 예제");

		b1 = new JButton("Magenta / Yellow Button");
		b2 = new JButton("	Disabled Button	");
		b3 = new JButton("getX(),getY()");

		b1.setBackground(Color.YELLOW);
		b2.setForeground(Color.MAGENTA);
		b3.setFont(new Font("Arial", Font.ITALIC, 20));

		b2.setEnabled(false); // 버튼 비활성화

		b3.addActionListener(new ActionListener() {

			// 타켓(콜백되는)
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				// Object를 리턴하기 때문에 JButton으로 다운캐스팅
				// 뭐가 클릭되었는지 모르기 때문에 알아서 다운캐스팅 해줘야함 --> 해당 버튼에 접근 가능

				b.setText("Hello");
				// b3를 알고있기 떄문에 위의 주석문을 처리해줄 필요는 X

			}
		});
		c.add(b1);
		c.add(b2);
		c.add(b3);

		setVisible(true);
		setSize(260, 200);

	}

	public static void main(String[] args) {
		new JcomponentEx();
	}

}
