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
	public void openCon() throws Exception {
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
	public void closeCon() throws Exception {
		if(con != null) {
			con.close();
		}
		if(pstmt != null) {
			pstmt.close();
		}
		if(rs != null) {
			rs.close();
		}
		
		System.out.println("�����ͺ��̽� ���� ����");
	}

	// ������ �ֱ�
	public int insertData(Users user) {

		try {
			openCon();
			String SQL = "INSERT INTO users(id,password,name,phone) " + "VALUES (?,?,?,?)"; // ��
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPwd());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getPhone());
			int result = pstmt.executeUpdate(); // ����� �������� (Insert, Delete, Update)
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				closeCon();
			} catch (Exception e) {
				
			}
		}

		return -1; // ������ ��Ÿ���� ���
	}

	// ������ �����ϱ�
	public int updateData(String password, String name, String phone) {
		try {
			
		} catch (Exception e) {
			
		}
		return -1;
	}
	
	// ������ ��������
	public int selectData() {
		return -1;
	}

	// ������ �����
	public int deleteData(String name){
		return -1;
	}

	
	public static void main(String[] args) {

	}
}
