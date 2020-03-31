package ch05;

//추상화는 new를 할 수 없음, 오브젝트가 아니기 때문에!
//추상클래스는 추상메서드를 가질 수 있다.
abstract class food1 {
	abstract void eat(); // 함수의 본체가 없음
}

//extends는 강제성을 부여
class 라면1 extends food1 {
	String name = "라면";

	@Override
	void eat() {
		System.out.println(name + "을 먹었습니다.");
	}

}

class 불고기1 extends food1 {
	String name = "불고기";

	@Override
	void eat() {
		System.out.println(name + "을 먹었습니다.");
	}

}

class 갈비1 extends food1 {
	String name = "갈비";

	@Override
	void eat() {
		System.out.println(name + "을 먹었습니다.");
	}

}

public class FoodEx01 {

	static void start(food1 f) {
		f.eat();
	}

	public static void main(String[] args) {
		start(new 라면1());

	}

}
