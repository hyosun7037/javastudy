package ch16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.management.Query;

// JAVA와 DB 연결하기
// 라이브러리가 필요함
public class SelectEx01 {

	// new로 접근하면 레퍼런스로 접근하게 되는데, 해당스택에서만 존재한다. 그래서 Class.forName으로 관리함
	public static void main(String[] args) {
		try {

			int id = 1;
			String name = "홍길동";
			String email = "ssal@nate.com";
			String password = "1234";

			// 변수 선언
			final String SQL = "select id, name, email, password from users where id = ?"; // ?를 넣어서 날리면 파싱하지 않음,
																							// injection 공격을 막아줌

			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 스트림 연결
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##madang",
					"c##madang"); // url, id, pwd

			// 버퍼달기 (Burfferd Writer로 날리기, 프로토콜이 있는 버퍼라이터) : ?를 사용하게 해준다. 똑같은 문장이 DB에 날아가기
			// 때문에 한 번만 파싱함
			PreparedStatement pstmt = conn.prepareStatement(SQL); // ? 자리에 들어갈 수 있는게 정해져있음!! / 가독성 좋음 / 파싱 안함

			// Statement pstmt = conn.prepareStatement(SQL); 쓰면 injection 공격 막을 수 없음 대신
			// PreparedStatement 사용

			
			////////////////////////////// 이 값 수정///////////////////////////
			pstmt.setInt(1, 3); // 데이터베이스는 1부터 시작, 1번째 ?에 넣고, 넣을 값

			// 버퍼에 쓰기(commit까지 해줌) / flush하기 위해 값을 채움(버퍼에 값을 채워넣어야함)
			// pstmt.executeUpdate();

			
			//////////////////////////// excute사용///////////////////////////
			// 일반적인 select문장은 execute() 사용, 읽기용 이기 때문에 commit사용 X
			// 버퍼에 쓰기(ResultSet을 리턴받음)
			ResultSet rs = pstmt.executeQuery(); // excuteQuery는 결과값까지 return 해줌
			// rs.next();

			
			Users users = null; //선언은 밖에서
			
			if (rs.next()) {
				users = new Users(
								rs.getInt("id"),
								rs.getString("name"),
								rs.getString("email"),
								rs.getString("password"));
				
			}
			System.out.println(users.getId()); // 1이라고 하면 index 번호, id는 컬럼명
			System.out.println(users.getName());
			System.out.println(users.getEmail());
			System.out.println(users.getPassword());
			System.out.println("셀렉트 완료");

			
			// 내부적으로 내용이 꽉 안차도 날라가도록 하는 autoflush 존재

		} catch (Exception e) { // Exception으로 수정
			e.printStackTrace();
		}
	}

}
