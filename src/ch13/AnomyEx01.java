package ch13;

//익명클래스
//규약!!
interface Animal {
	void move(); // 추상 메서드 - new를 하지 못함! (추상적이니까 오브젝트가 될 수 없음), 앞에 abstract 생략되어 있음
}

abstract class Person {
	abstract void eat();
}

public class AnomyEx01 {

	public static void main(String[] args) {
		// Animal a = new Animal();추상메서드가 구현되어 있지 않아서 new 할 수 X
		// Person p = new Person(); 추상메서드가 구현되어 있지 않아서 new 할 수 X
		// Person p2 = new Person(); 추상클래스는 추상메서드가 들어올 수 있기 때문에 new를 막아둠

	}
}

