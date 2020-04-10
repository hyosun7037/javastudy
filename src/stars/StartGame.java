package stars;

import stars.protoss.Dragoon;
import stars.protoss.Zealot;

public class StartGame {

	public static void move(Behavior b) {
		b.move();
	}

	public static void repair(Behavior b) {
		b.repair();
	}

	public static void attack(Behavior b1, Behavior b2) {
		b1.attack(b2);
	}

	public static void main(String[] args) {
		Zealot z1 = new Zealot("����1");
		Dragoon d1 = new Dragoon("���1");
		Zealot z3 = new Zealot("����3");
		move(z1);
		repair(z1);
		attack(z1, d1);

	}
}