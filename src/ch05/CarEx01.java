package ch05;

class Car {
	void run() {
		System.out.println("�⺻ ������");
	}
}

class Sonata extends Car {
	@Override // ��ȿȭ ��Ű��. �θ��� run�� ����
	void run() {

//		super.run(); // �θ� Ŭ������ heap ����
		System.out.println("�ҳ�Ÿ���� ������");
	}
}

public class CarEx01 {

	public static void main(String[] args) {
		Car s1 = new Sonata(); // �θ� �޼ҵ尡 ���õǰ�, �ڽ� �޼ҵ尡 ����
		s1.run();
	}

}
