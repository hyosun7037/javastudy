package animal;

//인터페이스는 통로역할 ex) 하나의 리모콘으로 여러개의 티비가 작동되는 것
//인터페이스는 표준을 만들 수 있음 / 조종기 역할
//인터페이스에 따라 제작하고 사용자는 인터페이스만을 보고 사용

interface Animal {
	void run();

	void sound();
}

class Dog implements Animal {

	@Override
	public void run() {
		System.out.println("강아지 달린다.");

	}

	@Override
	public void sound() {
		System.out.println("멍멍");
	}

}

class Bird implements Animal {

	@Override
	public void run() {
		System.out.println("새는 달린다.");
	}

	@Override
	public void sound() {
		System.out.println("짹짹");
	}
	
	public void fly() {
		System.out.println("새는 난다.");
	}
}

public class AnimalEx02 {

	static void start(Animal a) {
		a.run();
		a.sound();
		if (a instanceof Bird) {
			((Bird) a).fly();
		}
	}

	public static void main(String[] args) {
//		Animal d = new Dog();
//		d.run();
//		d.sound();
//		
//		Animal b = new Dog();
//		b.run();
//		b.sound();
//		public Void fly() {
//			System.out.println("새는 난다");
//			//fly메소드를 가진  놈이라는 걿 확싱
//			((Bird)b).fly();

		start(new Dog());
		start(new Bird());

	}
}
