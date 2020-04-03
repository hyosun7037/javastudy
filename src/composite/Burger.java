package composite;

import lombok.Data;

@Data // Getter, Setter 생성

public class Burger {
	private int price;
	private String desc; // private에 접근하려면 getter, setter필요

	public Burger() {
		this(1500, "기본버거"); //고정값
	}
	
	//최종목적지
	public Burger(int price, String desc) { // 생성자 //바뀌는 값
		this.price = price;
		this.desc = desc;
		System.out.println(desc + "가 만들어졌습니다."); 
	}

}
