package ch03;

//�޼���(�Լ�)�� �޼���(�Լ�)�ȿ� �ۼ��� �� ����
//class �ȿ� �޼���(�Լ�)�ۼ�
public class Mem {

	int num = 10;
	static String name = "ȫ�浿";
	void test() {
		int num = 5;
	}

	public static void main(String[] args) {
		
		int sum = 100;
		System.out.println("sum:  " +  sum);
		
		Mem m = new Mem(); //�ּҸ� ������ �ִ� �͵��� 4����Ʈ, new �ϸ� heap�� ����
		m.test(); //test()�� static�� �ƴ϶� heap�� ��� ����
		System.out.println("��ȣ "  +m. num); //num�� static�� �ƴ϶� heap�� ��� ����
		System.out.println(1);
		System.out.println(2);
		System.out.println("���α׷� ����");
		
		
		
//		int num = Cal.add(5, 3);
//		System.out.println("��� : " + num);
//
//		// minus
//		int num2 = Cal.minus(5, 3);
//		System.out.println("��� :" + num2);
//
//		// multi
//		int num3 = Cal.multi(5, 3);
//		System.out.println("��� :" + num3);
//
//		// divide
//		int num4 = Cal.divide(5, 3);
//		System.out.println("��� :" + num4);
	}

}
