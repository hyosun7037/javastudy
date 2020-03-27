package stars;

//��ũ���÷� DarkTempler ���ݷ�(50), ���� River(70) ����

import org.omg.CORBA.ULongLongSeqHelper;

//��ũ���÷� DarkTempler ����
class DarkTempler {
	final String NAME; // final �ѹ� �ʱ�ȭ �Ǹ� ���� ���� ����, �Һ�������, final�� �빮�ڷ� ����
	int hp;
	static int attack = 50; // static���� �����ϱ� ������ Zealot�� �����Ǳ� ���� ���ݷ� ���׷��̵� ����

	public DarkTempler(String name) {
		this.NAME = name;
		this.hp = 100;
		// this.attack = 10; //���� �ʱ�ȭ �Ҷ� �� //static ���� ������
	}

}

//���� River ����
class River {
	final String NAME; // final �ѹ� �ʱ�ȭ �Ǹ� ���� ���� ����, �Һ�������, final�� �빮�ڷ� ����
	int hp;
	static int attack = 70; // static���� �����ϱ� ������ Zealot�� �����Ǳ� ���� ���ݷ� ���׷��̵� ����

	public River(String name) {
		this.NAME = name;
		this.hp = 100;
		// this.attack = 10; //���� �ʱ�ȭ �Ҷ� �� //static ���� ������
	}

}

//���� Zealot ����
class Zealot {
	final String NAME; // final �ѹ� �ʱ�ȭ �Ǹ� ���� ���� ����, �Һ�������, final�� �빮�ڷ� ����
	int hp;
	static int attack = 10; // static���� �����ϱ� ������ Zealot�� �����Ǳ� ���� ���ݷ� ���׷��̵� ����

	public Zealot(String name) {
		this.NAME = name;
		this.hp = 100;
		// this.attack = 10; //���� �ʱ�ȭ �Ҷ� �� //static ���� ������
	}

}

//�巡�� Dragon ����
class Dragon {
	final String NAME;
	int hp;
	static int attack = 10;

	public Dragon(String name) {
		this.NAME = name;
		this.hp = 100;
		// this.attack = 10;
	}

}

public class GameStart {

	// ���ݹ���
	// ���� > ����
	static void attack(Zealot u1, Dragon u2) {
		u2.hp = u2.hp - u1.attack; // ������ ������� ������ ���ݷ��� �����
		System.out.println(u2.NAME + "�� ���ݴ��ϰ� �ֽ��ϴ�.");
		System.out.println(u2.NAME + "�� ü����" + u2.hp + "�Դϴ�.");
	}

	// ���� > ����
	static void attack(Dragon u1, Zealot u2) {
		u2.hp = u2.hp - u1.attack; // ������ ������� ������ ���ݷ��� �����
		System.out.println(u2.NAME + "�� ���ݴ��ϰ� �ֽ��ϴ�.");
		System.out.println(u2.NAME + "�� ü����" + u2.hp + "�Դϴ�.");
	}

	// ���� > ����
	static void attack(Zealot u1, Zealot u2) {
		u2.hp = u2.hp - u1.attack; // ������ ������� ������ ���ݷ��� �����
		System.out.println(u2.NAME + "�� ���ݴ��ϰ� �ֽ��ϴ�.");
		System.out.println(u2.NAME + "�� ü����" + u2.hp + "�Դϴ�.");
	}

	// ���� > ����
	static void attack(Dragon u1, Dragon u2) {
		u2.hp = u2.hp - u1.attack; // ������ ������� ������ ���ݷ��� �����
		System.out.println(u2.NAME + "�� ���ݴ��ϰ� �ֽ��ϴ�.");
		System.out.println(u2.NAME + "�� ü����" + u2.hp + "�Դϴ�.");
	}

	// ��ũ���÷� > ����
	static void attack(DarkTempler u1, Zealot u2) {
		u2.hp = u2.hp - u1.attack; // ������ ������� ������ ���ݷ��� �����
		System.out.println(u2.NAME + "�� ���ݴ��ϰ� �ֽ��ϴ�.");
		System.out.println(u2.NAME + "�� ü����" + u2.hp + "�Դϴ�.");
	}

	// ��ũ���÷� > ����
	static void attack(DarkTempler u1, Dragon u2) {
		u2.hp = u2.hp - u1.attack; // ������ ������� ������ ���ݷ��� �����
		System.out.println(u2.NAME + "�� ���ݴ��ϰ� �ֽ��ϴ�.");
		System.out.println(u2.NAME + "�� ü����" + u2.hp + "�Դϴ�.");
	}

	// ��ũ���÷� > ����
	static void attack(DarkTempler u1, River u2) {
		u2.hp = u2.hp - u1.attack; // ������ ������� ������ ���ݷ��� �����
		System.out.println(u2.NAME + "�� ���ݴ��ϰ� �ֽ��ϴ�.");
		System.out.println(u2.NAME + "�� ü����" + u2.hp + "�Դϴ�.");
	}
	
	//���� > ��ũ���÷�
	static void attack(Zealot u1, DarkTempler u2) {
		u2.hp = u2.hp - u1.attack; // ������ ������� ������ ���ݷ��� �����
		System.out.println(u2.NAME + "�� ���ݴ��ϰ� �ֽ��ϴ�.");
		System.out.println(u2.NAME + "�� ü����" + u2.hp + "�Դϴ�.");
	}
	
	//���� > ��ũ���÷�
	static void attack(Dragon u1, DarkTempler u2) {
		u2.hp = u2.hp - u1.attack; // ������ ������� ������ ���ݷ��� �����
		System.out.println(u2.NAME + "�� ���ݴ��ϰ� �ֽ��ϴ�.");
		System.out.println(u2.NAME + "�� ü����" + u2.hp + "�Դϴ�.");
	}
	
	//���� > ��ũ���÷�
	static void attack(River u1, DarkTempler u2) {
		u2.hp = u2.hp - u1.attack; // ������ ������� ������ ���ݷ��� �����
		System.out.println(u2.NAME + "�� ���ݴ��ϰ� �ֽ��ϴ�.");
		System.out.println(u2.NAME + "�� ü����" + u2.hp + "�Դϴ�.");
	}
	
	//���� > ����
	static void attack(River u1, Zealot u2) {
		u2.hp = u2.hp - u1.attack; // ������ ������� ������ ���ݷ��� �����
		System.out.println(u2.NAME + "�� ���ݴ��ϰ� �ֽ��ϴ�.");
		System.out.println(u2.NAME + "�� ü����" + u2.hp + "�Դϴ�.");
	}
	
	//���� > ����
	static void attack(River u1, Dragon u2) {
		u2.hp = u2.hp - u1.attack; // ������ ������� ������ ���ݷ��� �����
		System.out.println(u2.NAME + "�� ���ݴ��ϰ� �ֽ��ϴ�.");
		System.out.println(u2.NAME + "�� ü����" + u2.hp + "�Դϴ�.");
	}
	
	
	//���� > ����
	static void attack(Zealot u1, River u2) {
		u2.hp = u2.hp - u1.attack; // ������ ������� ������ ���ݷ��� �����
		System.out.println(u2.NAME + "�� ���ݴ��ϰ� �ֽ��ϴ�.");
		System.out.println(u2.NAME + "�� ü����" + u2.hp + "�Դϴ�.");
	}
	
	//���� > ����
	static void attack(Dragon u1, River u2) {
		u2.hp = u2.hp - u1.attack; // ������ ������� ������ ���ݷ��� �����
		System.out.println(u2.NAME + "�� ���ݴ��ϰ� �ֽ��ϴ�.");
		System.out.println(u2.NAME + "�� ü����" + u2.hp + "�Դϴ�.");
	}

	
	

	public static void main(String[] args) {
		// ���ݷ� ���׷��̵� �ϱ�
		Zealot.attack++;
		// ���� �����ϱ�
		Zealot z1 = new Zealot("1������");
		System.out.println(Zealot.attack);

		Zealot z2 = new Zealot("2������");
		System.out.println(Zealot.attack);

		Dragon d1 = new Dragon("1�� ����");
		System.out.println(Dragon.attack);

		Dragon d2 = new Dragon("2�� ����");
		System.out.println(Dragon.attack);
		
		DarkTempler t1 = new DarkTempler("1�� ��ũ���÷�");
		System.out.println(DarkTempler.attack);
		
		DarkTempler t2 = new DarkTempler("2�� ��ũ���÷�");
		System.out.println(DarkTempler.attack);
		
		River r1 = new River("1�� ����");
		System.out.println(River.attack);
		
		River r2 = new River("2�� ����");
		System.out.println(River.attack);

		
		// �����ϱ�
		//���� > ����
		attack(z1, d1);
		attack(z1, d1);

		//���� > ����
		attack(d1, z1);
		attack(d1, z1);

		//���� > ����
		attack(z1, z2);
		attack(z1, z2);

		//���� > ����
		attack(d1, d2);
		attack(d1, d2);
		
		
		/////
		
		
		// ��ũ���÷� > ����
		attack(t1, z1);
		
		// ��ũ���÷� > ����
		attack(t1, d1);
		
		// ��ũ���÷� > ����
		attack(t1, r1);
		
		//���� > ��ũ���÷�
		attack(z1, t1);
		
		//���� > ��ũ���÷�
		attack(d1, t1);
		
		//���� > ��ũ���÷�
		attack(r1, t1);
		
		//���� > ��ũ���÷�
		attack(r1, t1);
		
		//���� > ����
		attack(r1, z1);
		
		//���� > ����
		attack(r1, d1);
		
		//��ũ���÷� > ����
		attack(t1, r1);
		
		//���� > ����
		attack(z1, r1);
		
		//���� > ����
		attack(d1, r1);
	

	}

}
