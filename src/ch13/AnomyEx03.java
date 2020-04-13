package ch13;

class Car {
	void run() {
		System.out.println("자동차는 달린다.");
	}
}
//어차피 달릴거니까 자식요소에서 재정의 할 필요 X

class Sonata extends Car {
	
}

class Granger extends Car {
	
}

public class AnomyEx03 {

	static void start(Car c) {
		c.run();
	}

	public static void main(String[] args) {
		start(new Sonata());
	}

}
