package stars.protoss;

import stars.Behavior;

abstract public class Protoss implements Behavior {
	@Override
	public void move() {
		System.out.println("�̵�");
	}

	@Override
	public void repair() {

		System.out.println("����ġ��");
	}

	public static void upgrade() {
		Protoss.upgrade();
		Zealot.attack++;
		Dragoon.attack++; //attack�� ���������� X
		System.out.println("�����佺 ���׷��̵� �Ϸ�");
	}
}
