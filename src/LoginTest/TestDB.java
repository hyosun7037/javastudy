package LoginTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDB {

	// 전역 공간에 쿼리에 필요한 레퍼런스를 준비하기
	Connection con;
	String query;
	PreparedStatement pstmt;
	ResultSet rs;

	/* 테이블이 여러개가 되면 */
	
	
	// DB에 연결하기
	public void openCon() throws Exception {
		// 오라클 주소, 아이디 비밀번호
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String userid = "usertable";
		String pwd = "usertable";

		// 자바 라이브러리 파일 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("드라이버 로드 성공");

		// 네트워크 입출력 객체 생성
		System.out.println("데이터베이스 연결 준비...");
		con = DriverManager.getConnection(url, userid, pwd);
		System.out.println("데이터베이스 연결 성공");

	}

	// DB 연결 끊기
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
		
		System.out.println("데이터베이스 연결 해제");
	}

	// 데이터 넣기
	public int insertData(Users user) {

		try {
			openCon();
			String SQL = "INSERT INTO users(id,password,name,phone) " + "VALUES (?,?,?,?)"; // 값
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPwd());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getPhone());
			int result = pstmt.executeUpdate(); // 결과값 가져오기 (Insert, Delete, Update)
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				closeCon();
			} catch (Exception e) {
				
			}
		}

		return -1; // 오류시 나타나는 결과
	}

	// 데이터 수정하기
	public int updateData(String password, String name, String phone) {
		try {
			
		} catch (Exception e) {
			
		}
		return -1;
	}
	
	// 데이터 가져오기
	public int selectData() {
		return -1;
	}

	// 데이터 지우기
	public int deleteData(String name){
		return -1;
	}

	
	public static void main(String[] args) {

	}
}
