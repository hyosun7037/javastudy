package ProjectTest;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBTest {
	
	public static void main(String[] args) {
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url,"usertable","usertable");
			System.out.println("���� : " + con);
		} catch (Exception e) {
			System.out.println("DB ���� ���� : " +e.getMessage());
		}
		
		
	}

}
