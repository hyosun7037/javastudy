package ch16;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 모델, Beans
// 설계도가 있다고 가정, 3d로 올리는 것을 모델링 / 가상 --> 현실
// 중복되지 않은 데이터 : 튜플 
// 데이터베이스의 레코드를 자바의 오브젝트로 바꾸는 것을 모델링이라고 한다.

@Data //getter, setter 생성
@NoArgsConstructor //빈생성자
@AllArgsConstructor //모든것을 채운 생성자
public class Users {
	private int id;
	private String name;
	private String email;
	private String password;
}

