package ch13;

//�͸�Ŭ����
//�Ծ�!!
interface Animal {
	void move(); // �߻� �޼��� - new�� ���� ����! (�߻����̴ϱ� ������Ʈ�� �� �� ����), �տ� abstract �����Ǿ� ����
}

abstract class Person {
	abstract void eat();
}

public class AnomyEx01 {

	public static void main(String[] args) {
		// Animal a = new Animal();�߻�޼��尡 �����Ǿ� ���� �ʾƼ� new �� �� X
		// Person p = new Person(); �߻�޼��尡 �����Ǿ� ���� �ʾƼ� new �� �� X
		// Person p2 = new Person(); �߻�Ŭ������ �߻�޼��尡 ���� �� �ֱ� ������ new�� ���Ƶ�

	}
}

