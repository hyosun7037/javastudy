package ch13;

abstract class Ani {
	abstract void sound();
}

class Cat extends Ani {
	@Override
	void sound() {
		System.out.println("�߿�");
	}
}

class Bird extends Ani {
	@Override
	void sound() {
		System.out.println("±±");
	}
}

class fish extends Ani {
	@Override
	void sound() {
		System.out.println("���ݻ���");

	}
}



public class AnomyEx04 {

	static void start(Ani a) {
		a.sound();
	}

	public static void main(String[] args) {
		start(new Cat());
		start(new fish());
		start(new Ani() {
			
			@Override
			void sound() {
				System.out.println("����");
			}
		});
	}

}
