package ch05;

class A {
	void run() {
		System.out.println("A 달린다");
	}
}

class B extends A {
	@Override
	void run() {
		System.out.println("B 달린다.");
	}
}

class C extends B {
	String name = "C";

	@Override
	void run() {
		System.out.println(name + " 달린다.");
	}
}//공통모듈생성
 

public class OverriderEx01 {

	public static void main(String[] args) {
		A a1 = new B(); // A B
		a1.run();

		A a2 = new C(); // A B C
		a2.run(); // 함수를 통해서 변수에 접근 가능 --> 동적 바인딩을 통해서

		B b1 = new C(); // B C
		b1.run();

	}

}
