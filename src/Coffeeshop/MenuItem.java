package Coffeeshop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//책임 X, 만들어지기만 하면 됨, 데이터만 필요 --> 클래스 자료형 : Beans 

@Data //getter, setter만들어줌
@NoArgsConstructor //매개변수가 없는 생성자
@AllArgsConstructor //모든매개변수가 있는 생성자

public class MenuItem {
	private String name;
	private int price;
}
