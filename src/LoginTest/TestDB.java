package LoginTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDB {

	// ���� ������ ������ �ʿ��� ���۷����� �غ��ϱ�
	Connection con;
	String query;
	PreparedStatement pstmt;
	ResultSet rs;

	/* ���̺��� �������� �Ǹ� */
	
	
	// DB�� �����ϱ�
	void openCon() throws Exception {
		// ����Ŭ �ּ�, ���̵� ��й�ȣ
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String userid = "usertable";
		String pwd = "usertable";

		// �ڹ� ���̺귯�� ���� �ε�
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("����̹� �ε� ����");

		// ��Ʈ��ũ ����� ��ü ����
		System.out.println("�����ͺ��̽� ���� �غ�...");
		con = DriverManager.getConnection(url, userid, pwd);
		System.out.println("�����ͺ��̽� ���� ����");

	}

	// DB ���� ����
	void closeCon() throws Exception {
		con.close();
		System.out.println("�����ͺ��̽� ���� ����");
	}

	// ������ �ֱ�
	int insertData(Users user) {

		try {
			String SQL = "INSERT INTO users(id,password,name,phone) " + "VALUES (?,?,?,?)"; // ��
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPwd());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getPhone());
			int result = pstmt.executeUpdate(); // ����� �������� (Insert, Delete, Update)
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1; // ������ ��Ÿ���� ���
	}

	// ������ �����ϱ�
	int updateData(String password, String name, String phone) {
		try {
			
		} catch (Exception e) {
			
		}
		return -1;
	}
	
	// ������ ��������
	int selectData() {
		return -1;
	}

	// ������ �����
	int deleteData(String name){
		return -1;
	}

	
	public static void main(String[] args) {

	}
}
