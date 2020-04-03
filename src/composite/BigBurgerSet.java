package composite;

import lombok.Data;

@Data
//자바는 다중상속이 안됨
//세트 만들기 (빅버거 + 콜라 + 감자튀김)
public class BigBurgerSet { // 버거 상속
	private BigBurger bigBurger; // 변수명만들때 첫글자 소문자로
	private Coke coke;
	private French french;

//	private Burger burger; //Burger로 수정하면 모든 세트를 만들 수 있는 하나의 공통적인 클래스
//	private Coke coke;
//	private French french;

	public BigBurgerSet() {
		this(
				new BigBurger(), 
				new Coke(), 
				new French());
	}
	//생성자 오버로딩 매개변수가 하나 늘어남 BigBurger타입 
	public BigBurgerSet(BigBurger bigBurger) {
		this(
				bigBurger, //변화값
				new Coke(),  //디폴트값
				new French()); //디폴트값
	}

	public BigBurgerSet(BigBurger bigBurger, Coke coke, French french) {
		this.bigBurger = bigBurger;
		this.coke = coke;
		this.french = french;
	}


//	public BigBurgerSet(Burger burger, Coke coke, French french) {
//		super();
//		this.bigBurger = bigBurger;
//		this.coke = coke;
//		this.french = french;
//	}
}
