package ch04;

import java.security.PublicKey;

class Rabbit {
	private String name; //heap����, ��������, �������, �ʵ�, �Ӽ�, ������Ƽ
	private int power;

	public Rabbit(String name, int power) {
		this.name = name;
		this.power = power;
	}

	// power�� ������Ű�� ��
	// �ൿ
	boolean drink() {
		// 100�� �Ѿ�� �������� �ʵ���!
		if (power == 100) {
			return false;
		}
		power++;
		return true;
	}

	public int getPower() { 
		return power; // ��𼭵� �� �� �ְ� public����
	}
	void setName(String name) {
		this.name = name; //�����ڴ� ������ ��ü�� �����ɶ� �����, �� �Ŀ� ��ȭ�� �������� this ���
	}
	//public�� ��� Ŭ�������� ���� ����, new�Ҷ� ��, ���� stack�� ȣ���Ҷ� ��
	public String getName() {
		return name;
	}
}

public class RabbitApp {

	public static void main(String[] args) {
		Rabbit r1 = new Rabbit("�䳢", 20); // 100�� MAX��� ����

		while (r1.drink()) {
		}
		System.out.println(r1.getPower());
		
		//�̸�����
		r1.setName("���䳢");
		System.out.println(r1.getName());
	}

}
