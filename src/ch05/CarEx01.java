package ch05;

class Car {
	void run() {
		System.out.println("기본 움직임");
	}
}

class Sonata extends Car {
	@Override // 무효화 시키다. 부모의 run이 날라감
	void run() {

//		super.run(); // 부모 클래스의 heap 공간
		System.out.println("소나타만의 움직임");
	}
}

public class CarEx01 {

	public static void main(String[] args) {
		Car s1 = new Sonata(); // 부모 메소드가 무시되고, 자식 메소드가 실행
		s1.run();
	}

}
