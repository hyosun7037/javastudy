package animal;

//�������̽��� ��ο��� ex) �ϳ��� ���������� �������� Ƽ�� �۵��Ǵ� ��
//�������̽��� ǥ���� ���� �� ���� / ������ ����
//�������̽��� ���� �����ϰ� ����ڴ� �������̽����� ���� ���

interface Animal {
	void run();

	void sound();
}

class Dog implements Animal {

	@Override
	public void run() {
		System.out.println("������ �޸���.");

	}

	@Override
	public void sound() {
		System.out.println("�۸�");
	}

}

class Bird implements Animal {

	@Override
	public void run() {
		System.out.println("���� �޸���.");
	}

	@Override
	public void sound() {
		System.out.println("±±");
	}
	
	public void fly() {
		System.out.println("���� ����.");
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
//			System.out.println("���� ����");
//			//fly�޼ҵ带 ����  ���̶�� �� Ȯ��
//			((Bird)b).fly();

		start(new Dog());
		start(new Bird());

	}
}
