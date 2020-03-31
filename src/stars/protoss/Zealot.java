package stars.protoss;

import stars.Behavior;

public class Zealot extends Protoss {
	private String name;
	private int hp;
	private int sh;
	public static int attack = 10 ;

	// 积己磊 积己
	public Zealot(String name) {
		this.name = name;
		this.hp = 100;
		this.sh = 100;
	}

	@Override
	public void attack(Behavior u) {
		System.out.println("辟芭府 傍拜");
		
	}

}