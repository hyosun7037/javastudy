package stars;

// ��ũ���÷� DarkTempler (50), ���� River (70)

abstract class Protoss {
	abstract String getName();
	abstract int getHp();
	abstract void setHp(int hp);
	abstract int getAttack();
	abstract void setAttack(int attack);
}

class Zealot extends Protoss{
	private final String NAME;
	private int hp;
	static int attack=10;
	
	public Zealot(String name) {
		this.NAME = name;
		this.hp = 100;
	}

	@Override
	String getName() {
		return NAME;
	}

	@Override
	int getHp() {
		return hp;
	}

	@Override
	void setHp(int hp) {
		this.hp = hp;
	}

	@Override
	int getAttack() {
		return attack;
	}

	@Override
	void setAttack(int attack) {
		this.attack = attack;
	}
}

class Dragoon extends Protoss {
	private final String NAME;
	private int hp;
	static int attack=15;
	
	public Dragoon(String name) {
		this.NAME = name;
		this.hp = 100;
	}
	@Override
	String getName() {
		return NAME;
	}

	@Override
	int getHp() {
		return hp;
	}

	@Override
	void setHp(int hp) {
		this.hp = hp;
	}

	@Override
	int getAttack() {
		return attack;
	}

	@Override
	void setAttack(int attack) {
		this.attack = attack;
	}
}

public class GameStart {
	
	// ���� => ���
	static void attack(Protoss u1, Protoss u2) {
		u2.setHp(u2.getHp() - u1.getAttack());
		
		System.out.println(u2.getName()+"�� ���ݴ��ϰ� �ֽ��ϴ�.");
		System.out.println(u2.getName()+"�� ü���� "+u2.getHp()+"�Դϴ�.");
	}
	
	
	public static void main(String[] args) {
		// ���ݷ� ���׷��̵��ϱ�
		Zealot.attack++;
		// ���� �����ϱ�
		Zealot z1 = new Zealot("1������");
		System.out.println(Zealot.attack);
		
		Zealot z2 = new Zealot("2������");
		System.out.println(Zealot.attack);
		
		Dragoon d1 = new Dragoon("1�����");
		System.out.println(Dragoon.attack);
		
		Dragoon d2 = new Dragoon("2�����");
		System.out.println(Dragoon.attack);
		
		//�����ϱ�
		attack(z1, d1);
		attack(z1, d1);
		
		attack(d1, z1);
		attack(z1, z2);
		attack(d1, d2);
	}

}



