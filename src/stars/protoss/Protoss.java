package stars.protoss;

import stars.Behavior;

abstract public class Protoss implements Behavior {
	@Override
	public void move() {
		System.out.println("이동");
	}

	@Override
	public void repair() {

		System.out.println("쉴드치료");
	}

	public static void upgrade() {
		Protoss.upgrade();
		Zealot.attack++;
		Dragoon.attack++; //attack은 공통적이지 X
		System.out.println("프로토스 업그레이드 완료");
	}
}
