package composite;

//Burger를 상속
public class BigBurger extends Burger {
	public BigBurger() {
		super(4000, "빅버거"); // 부모가 들고있는 price와 desc를 수정
	}

	public BigBurger(int price, String desc) {
		super(price, desc);
	}
}
