package LoginTest.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class UserConfirm {

	private JFrame frame;
	private JButton UserConfirmBtn;
	private JTextField UserConfirmTf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserConfirm window = new UserConfirm();
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
	public UserConfirm() {
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
		
		// 회원정보수정 버튼
		JButton UserConfirmBtn = new JButton("\uD68C\uC6D0\uC815\uBCF4 \uC218\uC815");
		UserConfirmBtn.setBounds(154, 147, 126, 33);
		frame.getContentPane().add(UserConfirmBtn);
		
		// 회원 정보
		UserConfirmTf = new JTextField();
		UserConfirmTf.setHorizontalAlignment(SwingConstants.CENTER);
		UserConfirmTf.setEditable(false);
		UserConfirmTf.setBounds(81, 94, 271, 43);
		frame.getContentPane().add(UserConfirmTf);
		UserConfirmTf.setColumns(10);
	}

}
