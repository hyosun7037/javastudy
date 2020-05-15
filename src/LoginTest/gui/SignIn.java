package LoginTest.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import LoginTest.TestDB;
import LoginTest.Users;

import javax.swing.JButton;

public class SignIn extends JFrame{

	private JTextField IdTf;
	private JTextField PwdTf;
	private JTextField PwdTfAgain;
	private JTextField NameTf;
	private JTextField PhoneTf;
	private JButton SignInBtn;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SignIn window = new SignIn();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public SignIn() {
		initialize();
		setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		frame = new JFrame();
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
		lblNewLabel.setBounds(92, 49, 57, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_1.setBounds(92, 74, 57, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uC774\uB984");
		lblNewLabel_1_1.setBounds(92, 126, 57, 15);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\uBC88\uD638");
		lblNewLabel_1_2.setBounds(92, 154, 57, 15);
		getContentPane().add(lblNewLabel_1_2);
		
		IdTf = new JTextField();
		IdTf.setBounds(161, 46, 183, 21);
		getContentPane().add(IdTf);
		IdTf.setColumns(10);
		
		PwdTf = new JTextField();
		PwdTf.setColumns(10);
		PwdTf.setBounds(161, 71, 183, 21);
		getContentPane().add(PwdTf);
		
		PwdTfAgain = new JTextField();
		PwdTfAgain.setColumns(10);
		PwdTfAgain.setBounds(161, 97, 183, 21);
		getContentPane().add(PwdTfAgain);
		
		NameTf = new JTextField();
		NameTf.setColumns(10);
		NameTf.setBounds(161, 123, 183, 21);
		getContentPane().add(NameTf);
		
		PhoneTf = new JTextField();
		PhoneTf.setColumns(10);
		PhoneTf.setBounds(161, 151, 183, 21);
		getContentPane().add(PhoneTf);
		
		SignInBtn = new JButton("\uD68C\uC6D0\uAC00\uC785");
		SignInBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(IdTf.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력해주세요");
					return;
				}
				
				if(PwdTf.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요");
					return;
				}
				
				if(NameTf.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "이름을 입력해주세요");
					return;
				}
				
				if(PhoneTf.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "전화번호를 입력해주세요");
					return;
				}
				
				
				if(PwdTf.getText().equals(PwdTfAgain.getText())) {
					Users users = new Users(IdTf.getText(),PwdTf.getText(),NameTf.getText(),PhoneTf.getText());
					int temp = new TestDB().insertData(users);
					if(temp == 1) {
						JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
						new Login().getFrame().setVisible(true);
						dispose();
					}
					
					
				}else {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
					PwdTf.setText(""); //오류면 빈칸으로 비워주기
					PwdTfAgain.setText("");
				}
				
			}
		});
		SignInBtn.setBounds(148, 196, 126, 36);
		getContentPane().add(SignInBtn);
	}

}
