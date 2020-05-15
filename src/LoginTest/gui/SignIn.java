package LoginTest.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SignIn {

	private JFrame frame;
	private JTextField IdTf;
	private JTextField PwdTf;
	private JTextField PwdTfAgain;
	private JTextField NameTf;
	private JTextField PhoneTf;
	private JButton SignInBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn window = new SignIn();
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
	public SignIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
		lblNewLabel.setBounds(92, 49, 57, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_1.setBounds(92, 74, 57, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uC774\uB984");
		lblNewLabel_1_1.setBounds(92, 126, 57, 15);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\uBC88\uD638");
		lblNewLabel_1_2.setBounds(92, 154, 57, 15);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		IdTf = new JTextField();
		IdTf.setBounds(161, 46, 183, 21);
		frame.getContentPane().add(IdTf);
		IdTf.setColumns(10);
		
		PwdTf = new JTextField();
		PwdTf.setColumns(10);
		PwdTf.setBounds(161, 71, 183, 21);
		frame.getContentPane().add(PwdTf);
		
		PwdTfAgain = new JTextField();
		PwdTfAgain.setColumns(10);
		PwdTfAgain.setBounds(161, 97, 183, 21);
		frame.getContentPane().add(PwdTfAgain);
		
		NameTf = new JTextField();
		NameTf.setColumns(10);
		NameTf.setBounds(161, 123, 183, 21);
		frame.getContentPane().add(NameTf);
		
		PhoneTf = new JTextField();
		PhoneTf.setColumns(10);
		PhoneTf.setBounds(161, 151, 183, 21);
		frame.getContentPane().add(PhoneTf);
		
		SignInBtn = new JButton("\uD68C\uC6D0\uAC00\uC785");
		SignInBtn.setBounds(148, 196, 126, 36);
		frame.getContentPane().add(SignInBtn);
	}

}
