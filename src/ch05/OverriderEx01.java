package ch05;

class A {
	void run() {
		System.out.println("A �޸���");
	}
}

class B extends A {
	@Override
	void run() {
		System.out.println("B �޸���.");
	}
}

class C extends B {
	String name = "C";

	@Override
	void run() {
		System.out.println(name + " �޸���.");
	}
}//���������
 

public class OverriderEx01 {

	public static void main(String[] args) {
		A a1 = new B(); // A B
		a1.run();

		A a2 = new C(); // A B C
		a2.run(); // �Լ��� ���ؼ� ������ ���� ���� --> ���� ���ε��� ���ؼ�

		B b1 = new C(); // B C
		b1.run();

	}

}
