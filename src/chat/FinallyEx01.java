package chat;

interface StarUnit {
	abstract int getHp(); // ��üŬ������ �������� ������ �޼���
}

abstract class Protoss implements StarUnit {
	abstract int getSh(); //protoss ����, protoss�� getHp, getSp �� �� Ȯ��
}

abstract class Zerg implements StarUnit { //getHp�� ������ ��
	int hp = 100;
	@Override
	public int getHp() {
		return 0;
	}
}

class Zealot extends Protoss {
	int sh = 100;
	int hp = 100;
	
	@Override
	public int getHp() {
		return hp;
	}

	@Override
	public int getSh() {
		return sh;
	}
}

class Ultra extends Zerg {
	int hp = 100;
	
	@Override
	public int getHp() {
		return hp;
	}
}


public class FinallyEx01 {
	//����üũ, (hp,sh)
	static void check(StarUnit unit) {
		try {
			Zealot z = (Zealot) unit; //�ٿ�ĳ����
			System.out.println("���� �����" + z.getSh());
			System.out.println("���� ü����" + z.getHp());
		} catch (Exception e) {
			//����
			Ultra u = (Ultra) unit;
			System.out.println("���״� ���尡 �����ϴ�.");
			System.out.println("���� ü���� : " + u.getHp());
		}finally {
			//try, catch �� �߿� �ƹ��ų� ����ǵ� ������ ���۵Ǵ� �ڵ�, ������ ���� �ȳ��� ������ ����Ǵ� ��
			// ������ ������ �� �ݴ� ���๮�� ���� ���� ���
			System.out.println("���� ������ ����");
		}
		
	}
	
	public static void main(String[] args) {
//		check(new Zealot());
		check(new Ultra()); //Ultra�� ��� X
	}

}
