package ch05;

//추상클래스 new 못함
abstract class Animal {

	abstract String name(); // {
//		return null;
//	}
}

class Dog extends Animal {
	final String NAME = "강아지";

	@Override
	String name() {
		return NAME;
	}

}

class Cat extends Animal {
	final String NAME = "고양이";

	@Override
	String name() {
		return NAME;
	}
}

class Bird extends Animal {
	final String NAME = "새";

	@Override // 강제성이 부여
	String name() {
		return NAME;

	}

}

class Tiger extends Animal {
	final String NAME = "호랑이";

	@Override
	String name() {
		return NAME;
	}

}

//추상적인 것을 들고 있기 때문에 override 필수
class Mouse extends Animal {
	@Override
	String name() {

		return null;
	}
}

public class AnimalEx01 {
//	static void attack(Dog u1, Cat u2) {
//		System.out.println(u2.NAME + "가" + u1.NAME + "에게 공격당했습니다.");
//	}
//
//	static void attack(Dog u1, Bird u2) {
//		System.out.println(u2.NAME + "가" + u1.NAME + "에게 공격당했습니다.");
//	}
//
//	static void attack(Cat u1, Bird u2) {
//		System.out.println(u2.NAME + "가" + u1.NAME + "에게 공격당했습니다.");
//	}

	static void attack(Animal u1, Animal u2) {
		System.out.println(u2.name() + "가" + u1.name() + "에게 공격당했습니다.");
	}

	public static void main(String[] args) {
		Animal d1 = new Dog(); // Dog와 Animal이 메모리에 뜸
		Animal c1 = new Cat(); // Cat와 Animal이 메모리에 뜸
		Animal b1 = new Bird(); // Bird와 Animal이 메모리에 뜸
		Animal t1 = new Tiger(); // Bird와 Animal이 메모리에 뜸

//		System.out.println(d1.NAME + "탄생");
//		System.out.println(c1.NAME + "탄생");
//		System.out.println(b1.NAME + "탄생");

		// 강아지 VS 고양이
		attack(d1, c1);

		// 강아지 VS 새
		attack(d1, b1);

		// 고양이 VS 새
		attack(c1, b1);

		// 호랑이 VS 고양이
		attack(t1, c1);
	}

}
