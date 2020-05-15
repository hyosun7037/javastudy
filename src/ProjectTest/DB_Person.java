package ProjectTest;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DB_Person extends JFrame implements ActionListener {

	JLabel l1, l2, l3;
	JTextField tf1, tf2, tf3;
	JPanel panel;

	Object ob[][] = new Object[0][3];
	DefaultTableModel model;
	JTable table;
	JScrollPane js;
	String str[] = { "이름", "나이", "전화번호" };

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public DB_Person() {
		super("테이블에 테이터 입력");
		panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		l1 = new JLabel("이름", JLabel.CENTER);
		l2 = new JLabel("나이", JLabel.LEFT);
		l3 = new JLabel("전화번호", JLabel.RIGHT);

		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();

		panel.setLayout(new GridLayout(3, 4));
		panel.add(l1);
		panel.add(tf1);
		panel.add(l2);
		panel.add(tf2);
		panel.add(l3);
		panel.add(tf3);
		this.add("North", panel);

		model = new DefaultTableModel(ob, str);
		table = new JTable(model);
		js = new JScrollPane(table);
		this.add("Center", js);
		setBounds(250, 250, 300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		tf1.addActionListener(this);
		tf2.addActionListener(this);
		tf3.addActionListener(this);

		connect();
		select();

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				if (rs != null)
					try {
						rs.close();
						if (pstmt != null)
							pstmt.close();
						if (con != null)
							con.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				
			}

		});
	}

	private void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(url, "usertable", "usertable");
		} catch (Exception e) {
			System.out.println("DB 접속 오류 : " + e);
		}
	}

	private void select() {
		try {
			String sql = "select * from person";
			pstmt = con.prepareStatement(sql);
			System.out.println("pstmt : " + pstmt);
			rs = pstmt.executeQuery();
			System.out.println("rs : " + rs);

			while (rs.next()) {
				String name = rs.getString("name");
				String age = rs.getString("age");
				String tel = rs.getString("tel");

				Object data[] = { name, age, tel };
				model.addRow(data);
				System.out.println(name + ", " + age + ", " + tel);
			}
		} catch (Exception e) {
			System.out.println("select() 실행 오류 : " + e);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tf1) {
			tf2.requestFocus();
		} else if (e.getSource() == tf2) {
			tf3.requestFocus();
		} else if (e.getSource() == tf3) {
			if (tf1.getText().equals("") && tf2.getText().equals("") && tf3.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "값을 입력하세요");
				tf1.requestFocus();
				return;
			}
			Object data[] = { tf1.getText(), tf2.getText(), tf3.getText() };
			model.addRow(data);
			
			
			try {
				String sql = "insert into person values(?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, tf1.getText());
				pstmt.setString(2, tf2.getText());
				pstmt.setString(3, tf3.getText());
				
				int insert = pstmt.executeUpdate();
				System.out.println("데이터 성공 유무(insert) : " + insert);
				
				rs = pstmt.executeQuery("select * from person");
				while(rs.next()) {
					String name = rs.getString("name");
					String age = rs.getString("age");
					String tel = rs.getString("tel");
					System.out.println(name + ", " +age+", "+tel);
				}
			} catch (Exception e2) {
				System.out.println("person테이블에 데이터 입력 실패 : " + e2);
			}
			
			
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf1.requestFocus();
		}

	}

	public static void main(String[] args) {
		new DB_Person();
	}
}
