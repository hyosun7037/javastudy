package ch16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

// JAVA와 DB 연결하기
// 라이브러리가 필요함
public class DeleteEx01 {

	// new로 접근하면 레퍼런스로 접근하게 되는데, 해당스택에서만 존재한다. 그래서 Class.forName으로 관리함
	public static void main(String[] args) {
		try {
			
			int id = 1;
			String name = "홍길동";
			String email = "ssal@nate.com";
			String password = "1234";
			
			//변수 선언
			final String SQL = "delete from users where id= ?"; //?를 넣어서 날리면 파싱하지 않음, injection 공격을 막아줌
			
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 스트림 연결
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##madang", "c##madang"); // url, id, pwd
			
			//버퍼달기 (Burfferd Writer로 날리기, 프로토콜이 있는 버퍼라이터) : ?를 사용하게 해준다. 똑같은 문장이 DB에 날아가기 때문에 한 번만 파싱함
			PreparedStatement pstmt = conn.prepareStatement(SQL); 
			pstmt.setInt(1, 1); //데이터베이스는 1부터 시작, 1번째 ?에 넣고, 넣을 값
			
			//버퍼에 쓰기(commit까지 해줌) / flush하기 위해 값을 채움(버퍼에 값을 채워넣어야함)
			pstmt.executeUpdate();
			
			//일반적인 select문장은 execute() 사용, 읽기용 이기 때문에 commit사용 X
//			pstmt.execute();
			
			//내부적으로 내용이 꽉 안차도 날라가도록 하는 autoflush 존재
			
			System.out.println("삭제완료");
		} catch (Exception e) { // Exception으로 수정
			e.printStackTrace();
		}
	}

}
