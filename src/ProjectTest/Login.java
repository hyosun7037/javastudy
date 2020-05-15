package ProjectTest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login {

	private JFrame frame;
	private JTextField id;
	private JTextField password;

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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(107, 92, 57, 15);
		frame.getContentPane().add(lblNewLabel);
		
		
		// id
		id = new JTextField();
		id.setBounds(157, 89, 156, 21);
		frame.getContentPane().add(id);
		id.setColumns(10);
		
		
		// password
		password = new JPasswordField();
		password.setColumns(10);
		password.setBounds(157, 121, 156, 21);
		frame.getContentPane().add(password);
		
		JLabel lblPw = new JLabel("PW");
		lblPw.setHorizontalAlignment(SwingConstants.CENTER);
		lblPw.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		lblPw.setBounds(107, 124, 57, 15);
		frame.getContentPane().add(lblPw);
		
		
		// loginBtn
		JButton loginBtn = new JButton("\uB85C\uADF8\uC778");
		loginBtn.setBounds(119, 173, 97, 23);
		frame.getContentPane().add(loginBtn);
		
		
		// signinBtn
		JButton signinBtn = new JButton("\uD68C\uC6D0\uAC00\uC785");
		signinBtn.setBounds(229, 173, 97, 23);
		frame.getContentPane().add(signinBtn);
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("LOGIN");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(178, 44, 82, 27);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
