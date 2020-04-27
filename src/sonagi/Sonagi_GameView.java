package sonagi;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Sonagi_GameView extends JFrame implements ActionListener, KeyListener, ListSelectionListener {

	private JTextField textField_1;
	private JButton btn_gamestart;
	private String[] work = { "바보", "우수하다", "반발", "마라톤", "전해지다", "주인공", "손가락", "수시로", "선명하다", "수도꼭지", "건전하다", "가라앉다",
			"믿음", "뛰어가다", "숨어있는", "고용하다", "보호하다", "착하다", "나쁘다", "선풍기", "자바", "붕어빵", "선택하다", "찬성하다", "반대하다", "위치하다",
			"생각되다", "깜짝", "감다", "꿈", "별", "감", "책", "오다", "가다", "소나기", "가방", "초록", "일어나다", "쏘다", "겨드랑이", "존경하다", "종소리",
			"갖고싶다", "명확하다", "뚜벅뚜벅", "할인", "아장아장", "사과", "감사", "이별", "대기" };
	private String[] game_LV = { "level 1", "level 2", "level 3", "level 4", "level 5", "level 6", "level 7", "level 8",
			"level 9", "level 10" };
	private JPanel panel_Screen;
	private JLabel label[] = new JLabel[10000];
	private JLabel score;
	private int scorenum = 0;
	private int i = 0;
	private JList list;
	private int spd = 3500;
	private JPanel panel_life1;
	private JPanel panel_life2;
	private JPanel panel_life3;
	private int life = 0;
	private JLabel level;
	private JPanel panel_over;
	private JLabel lblNewLabel;
	private JLabel lblScore;
	private JLabel Label_nickname;
	private JLabel lblNick;
	private String NickName;
	Sonagi_main main;

	public Sonagi_GameView(String Nick) {
		NickName = Nick;// 닉네임 변수 저장

		// 화면구성
		setSize(1200, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		textField_1 = new JTextField();// 단어입력
		textField_1.setBounds(115, 631, 267, 38);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		list = new JList(game_LV);// 레벨 리스트 보여주기
		list.setSelectedIndex(0);
		list.setFont(new Font("굴림", Font.BOLD, 22));
		list.setBounds(986, 44, 162, 280);
		getContentPane().add(list);

		btn_gamestart = new JButton("시작");// 시작 버튼
		btn_gamestart.setFont(new Font("굴림", Font.BOLD, 23));
		btn_gamestart.setBounds(497, 627, 105, 38);
		getContentPane().add(btn_gamestart);

		panel_Screen = new JPanel();// 게임화면
		panel_Screen.setBackground(Color.ORANGE);
		panel_Screen.setForeground(Color.ORANGE);
		panel_Screen.setBounds(43, 29, 740, 571);
		getContentPane().add(panel_Screen);
		panel_Screen.setLayout(null);
		panel_Screen.setVisible(false);

		JPanel panel_1 = new JPanel(); // 게임화면에서 빨간색 선
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(0, 520, 740, 10);
		panel_Screen.add(panel_1);

		score = new JLabel("0점");// 점수판
		score.setHorizontalAlignment(SwingConstants.CENTER);
		score.setFont(new Font("굴림", Font.BOLD, 25));
		score.setBounds(823, 241, 149, 45);
		getContentPane().add(score);

		Label_nickname = new JLabel(Nick); //닉네임 
		Label_nickname.setHorizontalAlignment(SwingConstants.CENTER);
		Label_nickname.setFont(new Font("굴림", Font.BOLD, 25));
		Label_nickname.setBounds(823, 71, 149, 27);
		getContentPane().add(Label_nickname);

		level = new JLabel("level 1"); //레벨 리스트
		level.setHorizontalAlignment(SwingConstants.CENTER);
		level.setFont(new Font("굴림", Font.BOLD, 24));
		level.setBounds(846, 142, 99, 42);
		getContentPane().add(level);

		panel_life1 = new JPanel(); // 생명1
		panel_life1.setBackground(Color.RED);
		panel_life1.setBounds(824, 319, 26, 27);
		getContentPane().add(panel_life1);

		panel_life2 = new JPanel();// 생명2
		panel_life2.setBackground(Color.RED);
		panel_life2.setBounds(864, 319, 26, 27);
		getContentPane().add(panel_life2);

		panel_life3 = new JPanel(); // 생명3
		panel_life3.setBackground(Color.RED);
		panel_life3.setBounds(904, 319, 26, 27);
		getContentPane().add(panel_life3);

		// 게임결과화면
		panel_over = new JPanel();// 게임결과 백스라운드 
		panel_over.setBackground(Color.PINK);
		panel_over.setBounds(14, 142, 794, 286);
		panel_over.setVisible(false);
		getContentPane().add(panel_over);
		panel_over.setLayout(null);

		lblNewLabel = new JLabel("Game Over"); // 게임 오버 라벨 
		lblNewLabel.setBounds(0, 36, 794, 63);
		panel_over.add(lblNewLabel);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 54));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		lblNick = new JLabel("Nick");// 닉네임 
		lblNick.setBounds(0, 115, 794, 45);
		panel_over.add(lblNick);
		lblNick.setHorizontalAlignment(SwingConstants.CENTER);
		lblNick.setForeground(Color.RED);
		lblNick.setFont(new Font("굴림", Font.BOLD, 54));

		lblScore = new JLabel("Score"); // 게임결과 점수 
		lblScore.setBounds(0, 232, 794, 42);
		panel_over.add(lblScore);
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setForeground(Color.RED);
		lblScore.setFont(new Font("굴림", Font.BOLD, 54));


		setVisible(true);

		// 버튼,리스트,키 이벤트설정및 텍스트필드포커스 설정
		btn_gamestart.addActionListener(this); // 버튼 이벤트
		textField_1.addKeyListener(this); // 키 이벤트
		list.addListSelectionListener(this); // 리스트 이벤트
		textField_1.requestFocus(); // 텍스트 포커스

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// 게임시작 버튼 이벤트
		if (e.getSource().equals(btn_gamestart)) {

			// 라이프 0 = 생명이 모두 있는것
			life = 0;
			score.setText("0점"); // 게임시작시 점수판 0점
			scorenum = 0; // 게임점수 변수 =0
			// 만약에 게임결과화면이 띄어져 있으면 보이지 않게
			if (panel_over.isVisible()) {
				panel_over.setVisible(false);// 결과화면 안보이게
			}

			// 단어가 만들어져 있는지 확인
			if (label[0] != null) {
				for (int i = 0; i < label.length; i++) {
					// 쓰레드가 돌아가고 있으면 중지
					if (!new Sonagi_Thead().isAlive() || !new Sonagi_Move().isAlive()) {
						new Sonagi_Thead().interrupt();// 단어 쓰레드 중지
						new Sonagi_Move().interrupt();// 내려가는 쓰레드 중지
					}
					// 단어가 만들어져 있다면 안보이게
					if (label[i] != null) {
						label[i].setVisible(false);
					}

				}
			}

			// 게임시작시 텍스트필드 포커스 주기
			textField_1.requestFocus();
			// 단어를 뿌려주는 쓰레드 실행
			new Sonagi_Thead().start();

		}
	}

	// 단어를 입력하여 동일단어 있는지 확인하는 키이벤트
	@Override
	public void keyPressed(KeyEvent e) {

		// 엔터키 이벤트
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			// 텍스트 필드에 값이 있는지 없는지 확인
			if (!textField_1.getText().equals("")) {
				// String 변수에 텍스트 값 주기
				String work_answer = textField_1.getText().toString();
				/*
				 * 텍스트 입력값과 동일한 단어 있는지 검사 동일 단어 있을시 안보이게 하고 점수 5점 주기 ,텍스트값
				 * 삭제(단어가 틀리더라도 )
				 * 
				 */

				for (int i = 0; i <= label.length; i++) { // 동일 단어 검사 for
					try {
						if (work_answer.equals(label[i].getText())) {// 동일단어 검사
							if (label[i].isVisible()) { // 동일단어가 화면에 보여져 있는지 검사
								scorenum = scorenum += 5; // 점수 +5
								score.setText(scorenum + "점"); // 점수판 점수 변경
								label[i].setVisible(false);// 단어 화면에서 안보이게
								textField_1.setText("");// 텍스트 값 없애기
							}
						} else {
							textField_1.setText("");
						}
					} catch (Exception e2) {
						e2.getMessage();
					}

				}

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

	// 단어를 하나씩 뿌려주는 쓰레드
	class Sonagi_Thead extends Thread {

		@Override
		public void run() {
			panel_Screen.setVisible(true);// 게임화면 등장
			// 단어를 레벨에 따른 속도로 게임화면에 x값 랜덤으로생성
			for (i = 0; i <= 10000; i++) {

				try {

					Random random = new Random();// 랜덤 객체 생성

					label[i] = new JLabel(work[random.nextInt(work.length)]);// 단어
																				// 랜덤으로
																				// 가지고옴
					label[i].setBounds(0, 0, 80, 20);// 단어 초기 위치 높이,폭 설정
					panel_Screen.add(label[i]);// 단어 추가
					label[i].setLocation(random.nextInt(678), 2);// x값 랜덤으로 보여주기
					// 단어를 움직이는 쓰레드 실행
					new Sonagi_Move().start();

					Thread.sleep(spd);// 게임레벨에 따른 단어속도

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
	}

	// 단어 내려가고,게임오버 확인하는 쓰레드
	class Sonagi_Move extends Thread {

		@Override
		public void run() {

			// 단어 생성 갯수 만큼 for 돌려 각 단어마다 y값 변경
			for (int a = 0; a <= i; a++) {
				if (label[a].isVisible()) {
					int sp = label[a].getY();
					int xp = label[a].getX();

					label[a].setLocation(xp, sp + 10);

				}

				// 단어가 보여져있는 상태롤 빨간선을 넘었는지 확인
				if (label[a].isVisible() && label[a].getY() > 512) {
					label[a].setVisible(false);// 단어가 선을 넘으면 단어 사라짐
					life++;// 라이프 1 = 생명 1없어짐
				}
			}

			// 라이프 확인
			switch (life) {
			case 0:// 생명 모두 있음
				panel_life1.setBackground(Color.RED);
				panel_life2.setBackground(Color.RED);
				panel_life3.setBackground(Color.RED);
				break;

			case 1: // 생명 1개 없어짐
				panel_life1.setBackground(Color.BLUE);
				panel_life2.setBackground(Color.RED);
				panel_life3.setBackground(Color.RED);
				break;

			case 2:// 생명 2 없어짐
				panel_life1.setBackground(Color.BLUE);
				panel_life2.setBackground(Color.BLUE);
				panel_life3.setBackground(Color.RED);
				break;
			case 3:// 생명 3개 없어짐 게임오버
				panel_life1.setBackground(Color.BLUE);
				panel_life2.setBackground(Color.BLUE);
				panel_life3.setBackground(Color.BLUE);
				// 게임 결과화면 띄우기
				panel_Screen.setVisible(false);
				panel_over.setVisible(true);
				lblScore.setText(score.getText());
				lblNick.setText(NickName);
				// 쓰레드 중지
				new Sonagi_Thead().interrupt();
				new Sonagi_Move().interrupt();

				break;
			default:
				break;
			}
		}
	}

	//Main 등록 
	public void setSonagi_main(Sonagi_main main) {
		this.main = main;
	}

	// 레벨리스트 이벤트 처리
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		String str;
		if (arg0.getSource() == list) {

			switch (list.getSelectedIndex()) {
			case 0:
				spd = 3500;// 게임속도
				str = (String) list.getSelectedValue();// 리스트 이름 저장
				level.setText(str); // 레벨 라벨에 보여주기
				break;
			case 1:
				spd = 2900;// 게임속도
				str = (String) list.getSelectedValue();// 리스트 이름 저장
				level.setText(str);// 레벨 라벨에 보여주기
				break;
			case 2:
				spd = 2600;// 게임속도
				str = (String) list.getSelectedValue();// 리스트 이름 저장
				level.setText(str);// 레벨 라벨에 보여주기
				break;
			case 3:
				spd = 2300;// 게임속도
				str = (String) list.getSelectedValue();// 리스트 이름 저장
				level.setText(str);// 레벨 라벨에 보여주기
				break;
			case 4:
				spd = 1900;// 게임속도
				str = (String) list.getSelectedValue();// 리스트 이름 저장
				level.setText(str);// 레벨 라벨에 보여주기
				break;
			case 5:
				spd = 1600;// 게임속도
				str = (String) list.getSelectedValue();// 리스트 이름 저장
				level.setText(str);// 레벨 라벨에 보여주기
				break;
			case 6:
				spd = 1300;// 게임속도
				str = (String) list.getSelectedValue();// 리스트 이름 저장
				level.setText(str);// 레벨 라벨에 보여주기
				break;
			case 7:
				spd = 1000;// 게임속도
				str = (String) list.getSelectedValue();// 리스트 이름 저장
				level.setText(str);// 레벨 라벨에 보여주기
				break;
			case 8:
				spd = 800;// 게임속도
				str = (String) list.getSelectedValue();// 리스트 이름 저장
				level.setText(str);// 레벨 라벨에 보여주기
				break;
			case 9:
				spd = 400;// 게임속도
				str = (String) list.getSelectedValue();// 리스트 이름 저장
				level.setText(str);// 레벨 라벨에 보여주기

				break;
			default:
				break;
			}
		}
	}
}
