package ch16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

// JAVA�� DB �����ϱ�
// ���̺귯���� �ʿ���
public class InsertEx01 {

	// new�� �����ϸ� ���۷����� �����ϰ� �Ǵµ�, �ش罺�ÿ����� �����Ѵ�. �׷��� Class.forName���� ������
	public static void main(String[] args) {
		try {
			
			int id = 1;
			String name = "ȫ�浿";
			String email = "ssal@nate.com";
			String password = "1234";
			
			//���� ����
			final String SQL = "insert into users(id, name, email, password) values(?,?,?,?)"; //?�� �־ ������ �Ľ����� ����, injection ������ ������
			
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// ��Ʈ�� ����
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##madang", "c##madang"); // url, id, pwd
			
			//���۴ޱ� (Burfferd Writer�� ������, ���������� �ִ� ���۶�����) : ?�� ����ϰ� ���ش�. �Ȱ��� ������ DB�� ���ư��� ������ �� ���� �Ľ���
			PreparedStatement pstmt = conn.prepareStatement(SQL); 
			pstmt.setInt(1, 4); //�����ͺ��̽��� 1���� ����, 1��° ?�� �ְ�, ���� ��
			pstmt.setString(2, "�ڵ�");
			pstmt.setNString(3, "gaga@nate.com");
			pstmt.setString(4, "1234");
			
			//���ۿ� ����(commit���� ����) / flush�ϱ� ���� ���� ä��(���ۿ� ���� ä���־����)
			pstmt.executeUpdate();
			
			//�Ϲ����� select������ execute() ���, �б�� �̱� ������ commit��� X
//			pstmt.execute();
			
			//���������� ������ �� ������ ���󰡵��� �ϴ� autoflush ����
			
			
		} catch (Exception e) { // Exception���� ����
			e.printStackTrace();
		}
	}

}
