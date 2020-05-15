package LoginTest.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import LoginTest.TestDB;

import javax.swing.JButton;

public class Login {

	private JFrame frame;
	private JTextField IdTf;
	private JTextField PwdTf;
	private JButton LoginBtn;
	private JButton SignInBtn;
	
	public JFrame getFrame() {
		return frame;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
		lblNewLabel.setBounds(115, 66, 57, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_1.setBounds(115, 105, 57, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		IdTf = new JTextField();
		IdTf.setBounds(175, 63, 153, 21);
		frame.getContentPane().add(IdTf);
		IdTf.setColumns(10);
		
		PwdTf = new JTextField();
		PwdTf.setColumns(10);
		PwdTf.setBounds(177, 102, 153, 21);
		frame.getContentPane().add(PwdTf);
		
		// 로그인 버튼
		LoginBtn = new JButton("\uB85C\uADF8\uC778");
		LoginBtn.setBounds(119, 177, 97, 23);
		frame.getContentPane().add(LoginBtn);
		
		// 회원가입 버튼
		SignInBtn = new JButton("\uD68C\uC6D0\uAC00\uC785");
		
		SignInBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new SignIn();
				frame.dispose();
			}
		});
		SignInBtn.setBounds(233, 177, 97, 23);
		frame.getContentPane().add(SignInBtn);
	}
}
