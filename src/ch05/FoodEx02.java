package ch05;

//추상클래스는 일반메서드를 가질 수 있다.
//추상클래스는 내가 구현할 수 없는 메서드를 오브젝트에서 미룰 수 있다.
//추상클래스는 abstract를 붙인다.
//추상클래스를 통해서 순서를 정할 수 있다.
abstract class Food {
	abstract void standby(); // 안에 들어가는 값이 다 다르고 잘 모를때

	protected void eat() {
		System.out.println("음식을 먹습니다.");
	}

	abstract void cook(); // 최대한 추상적인 것

	void auto() {
		standby();
		cook();
		eat();
	}
}

class 라면 extends Food {

	@Override
	void cook() {
		System.out.println("냄비에 끓인다.");
	}

	@Override
	void standby() {
		System.out.println("라면과 냄비를 준비합니다.");
	}

}

class 삼겹살 extends Food {

	@Override
	void cook() {
		System.out.println("불판에 굽는다.");
	}

	@Override
	void standby() {
		System.out.println("불판과 고기를 준비합니다.");
	}

}

public class FoodEx02 {

	static void start(Food f) {
		f.auto();

	}

	public static void main(String[] args) {
		start(new 라면());
	}

}
