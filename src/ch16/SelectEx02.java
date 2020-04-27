package ch16;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.management.Query;

// JAVA�� DB �����ϱ�
// ���̺귯���� �ʿ���
public class SelectEx02 {

	// new�� �����ϸ� ���۷����� �����ϰ� �Ǵµ�, �ش罺�ÿ����� �����Ѵ�. �׷��� Class.forName���� ������
	public static void main(String[] args) {
		try {

			int id = 1;
			String name = "ȫ�浿";
			String email = "ssal@nate.com";
			String password = "1234";

			// ���� ����
			final String SQL = "select id, name, email, password from users"; // ?�� �־ ������ �Ľ����� ����,
																							// injection ������ ������

			Class.forName("oracle.jdbc.driver.OracleDriver");

			// ��Ʈ�� ����
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##madang",
					"c##madang"); // url, id, pwd

			// ���۴ޱ� (Burfferd Writer�� ������, ���������� �ִ� ���۶�����) : ?�� ����ϰ� ���ش�. �Ȱ��� ������ DB�� ���ư���
			// ������ �� ���� �Ľ���
			PreparedStatement pstmt = conn.prepareStatement(SQL); // ? �ڸ��� �� �� �ִ°� ����������!! / ������ ���� / �Ľ� ����

			// Statement pstmt = conn.prepareStatement(SQL); ���� injection ���� ���� �� ���� ���
			// PreparedStatement ���

			
			////////////////////////////// �� �� ����///////////////////////////
//			pstmt.setInt(1, 3); // �����ͺ��̽��� 1���� ����, 1��° ?�� �ְ�, ���� ��

			// ���ۿ� ����(commit���� ����) / flush�ϱ� ���� ���� ä��(���ۿ� ���� ä���־����)
			// pstmt.executeUpdate();

			
			//////////////////////////// excute���///////////////////////////
			// �Ϲ����� select������ execute() ���, �б�� �̱� ������ commit��� X
			// ���ۿ� ����(ResultSet�� ���Ϲ���)
			ResultSet rs = pstmt.executeQuery(); // excuteQuery�� ��������� return ����
			// rs.next();

			
			// Users users = null; //������ �ۿ���
			
			//////////////////// �� �� �̻��̸� �÷��ǿ� ���!! �θ��� List�� ���°� ����. /////////////////////
			List<Users> users = new ArrayList<>(); 
			
			while (rs.next()) {
				Users user = new Users(
								rs.getInt("id"),
								rs.getString("name"),
								rs.getString("email"),
								rs.getString("password")
								);
				users.add(user);
				
			}
			
			//JSON ���°� �ƴϱ� ������ ������ �ٲ������
			//users�� ũ�⸸ŭ ����, �� ���� �� ������ user�� ���
			for (Users user : users) {
				System.out.println(user.getId()); // 1�̶�� �ϸ� index ��ȣ, id�� �÷���
				System.out.println(user.getName());
				System.out.println(user.getEmail());
				System.out.println(user.getPassword());
				System.out.println();
			}
			

			
			// ���������� ������ �� ������ ���󰡵��� �ϴ� autoflush ����

		} catch (Exception e) { // Exception���� ����
			e.printStackTrace();
		}
	}

}
