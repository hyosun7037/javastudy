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
	private JTextField textField;// �г��� �Է�â
	private JLabel lblNewLabel; // ��
	public String Nick_Name; // �г��� ����
	Sonagi_main main; // Main

	public Sonagi_Nick() {
		// ȭ�鱸��
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("���̽����� ����");
		getContentPane().setLayout(null);

		lblNewLabel = new JLabel("�г����� ������ �ּ���!"); // ��
		lblNewLabel.setFont(new Font("�������", Font.PLAIN, 27));
		lblNewLabel.setBounds(87, 100, 381, 31);
		getContentPane().add(lblNewLabel);

		textField = new JTextField(); // �г��� �Է�â
		textField.setFont(new Font("�������", Font.BOLD, 24));
		textField.setBounds(24, 261, 238, 40);
		getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Ȯ��"); // Ȯ�ι�ư
		btnNewButton.setFont(new Font("�������", Font.BOLD, 22));
		btnNewButton.setBounds(290, 261, 156, 40);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(this);

//		JLabel lblNewLabel_1 = new JLabel("�г���"); // �г��� �� 
//		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel_1.setFont(new Font("�������", Font.BOLD, 19));
//		lblNewLabel_1.setBounds(100, 202, 188, 40);
//		getContentPane().add(lblNewLabel_1);
		setVisible(true);
		// �г��� �Է�â Ű �̺�Ʈ (this)
		textField.addKeyListener(this);

	}

	// ��ư �̺�Ʈ
	@Override
	public void actionPerformed(ActionEvent e) {

		if (!textField.getText().equals("")) {

			// �ؽ�Ʈ �̷�â�� ���� �ִٸ� �г��� ������ ���� �� ����ȭ�� ����
			Nick_Name = textField.getText().toString();
			main.showGameView(this, Nick_Name);

		} else {
			// �ؽ�Ʈ �Է�â�� ���� ���ٸ� ���ؽ�Ʈ ����
			lblNewLabel.setText("�ùٸ��� ���� �г��� �Դϴ�.");
		}

	}

	// Main ���
	public void setSonagi_main(Sonagi_main main) {

		this.main = main;

	}

//����Ű �̺�Ʈ 
	@Override
	public void keyPressed(KeyEvent e) {
		// ����Ű �̺�Ʈ
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			// �ؽ�Ʈ �̷�â�� ���� �ִٸ� �г��� ������ ���� �� ����ȭ�� ����
			if (!textField.getText().equals("")) {

				Nick_Name = textField.getText().toString();
				System.out.println(Nick_Name);
				main.showGameView(this, Nick_Name);

			} else {
				// �ؽ�Ʈ �Է�â�� ���� ���ٸ� ���ؽ�Ʈ ����
				lblNewLabel.setText("�ùٸ��� ���� �г��� �Դϴ�.");
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