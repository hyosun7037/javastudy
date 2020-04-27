package sonagi;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JList;

class Sonagi_Nick extends JFrame implements ActionListener, KeyListener {
	private JTextField textField;// 닉네임 입력창
	private JLabel lblNewLabel; // 라벨
	public String Nick_Name; // 닉네임 변수
	Sonagi_main main; // Main

	public Sonagi_Nick() {
		// 화면구성
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("아이스베어 게임");
		getContentPane().setLayout(null);

		lblNewLabel = new JLabel("닉네임을 설정해 주세요!"); // 라벨
		lblNewLabel.setFont(new Font("나눔고딕", Font.PLAIN, 27));
		lblNewLabel.setBounds(87, 100, 381, 31);
		getContentPane().add(lblNewLabel);

		textField = new JTextField(); // 닉네임 입력창
		textField.setFont(new Font("나눔고딕", Font.BOLD, 24));
		textField.setBounds(24, 261, 238, 40);
		getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("확인"); // 확인버튼
		btnNewButton.setFont(new Font("나눔고딕", Font.BOLD, 22));
		btnNewButton.setBounds(290, 261, 156, 40);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(this);

//		JLabel lblNewLabel_1 = new JLabel("닉네임"); // 닉네임 라벨 
//		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel_1.setFont(new Font("나눔고딕", Font.BOLD, 19));
//		lblNewLabel_1.setBounds(100, 202, 188, 40);
//		getContentPane().add(lblNewLabel_1);
		setVisible(true);
		// 닉네임 입력창 키 이벤트 (this)
		textField.addKeyListener(this);

	}

	// 버튼 이벤트
	@Override
	public void actionPerformed(ActionEvent e) {

		if (!textField.getText().equals("")) {

			// 텍스트 이력창에 값이 있다면 닉네임 변수에 저장 후 게임화면 띄우기
			Nick_Name = textField.getText().toString();
			main.showGameView(this, Nick_Name);

		} else {
			// 텍스트 입력창에 값이 없다면 라벨텍스트 변경
			lblNewLabel.setText("올바르지 않은 닉네임 입니다.");
		}

	}

	// Main 등록
	public void setSonagi_main(Sonagi_main main) {

		this.main = main;

	}

//엔터키 이벤트 
	@Override
	public void keyPressed(KeyEvent e) {
		// 엔터키 이벤트
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			// 텍스트 이력창에 값이 있다면 닉네임 변수에 저장 후 게임화면 띄우기
			if (!textField.getText().equals("")) {

				Nick_Name = textField.getText().toString();
				System.out.println(Nick_Name);
				main.showGameView(this, Nick_Name);

			} else {
				// 텍스트 입력창에 값이 없다면 라벨텍스트 변경
				lblNewLabel.setText("올바르지 않은 닉네임 입니다.");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}