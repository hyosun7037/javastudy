package LoginTest.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class UserUpdate {

	private JFrame frame;
	private JTextField PwdUpdateTf;
	private JTextField NameUpdateTf;
	private JTextField PhoneUpdateTf;
	private JButton UserUpdateBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserUpdate window = new UserUpdate();
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
	public UserUpdate() {
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
		
		JLabel lblNewLabel = new JLabel("\uBE44\uBC00\uBC88\uD638 \uC218\uC815");
		lblNewLabel.setBounds(73, 53, 84, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC774\uB984 \uC218\uC815");
		lblNewLabel_1.setBounds(73, 88, 84, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uBC88\uD638 \uC218\uC815");
		lblNewLabel_1_1.setBounds(73, 124, 84, 15);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		PwdUpdateTf = new JTextField();
		PwdUpdateTf.setBounds(168, 50, 157, 21);
		frame.getContentPane().add(PwdUpdateTf);
		PwdUpdateTf.setColumns(10);
		
		NameUpdateTf = new JTextField();
		NameUpdateTf.setColumns(10);
		NameUpdateTf.setBounds(169, 85, 157, 21);
		frame.getContentPane().add(NameUpdateTf);
		
		PhoneUpdateTf = new JTextField();
		PhoneUpdateTf.setColumns(10);
		PhoneUpdateTf.setBounds(169, 121, 157, 21);
		frame.getContentPane().add(PhoneUpdateTf);
		
		UserUpdateBtn = new JButton("\uD68C\uC6D0\uC815\uBCF4 \uC218\uC815");
		UserUpdateBtn.setBounds(157, 182, 126, 39);
		frame.getContentPane().add(UserUpdateBtn);
	}

}
