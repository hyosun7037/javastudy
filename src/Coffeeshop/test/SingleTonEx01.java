package Coffeeshop.test;

class ����� {
	
	private static ����� instance = new �����();
	
	public static ����� getInstace() {
		return instance;
	}
	
	private �����() {}
//	public �����() {
//	} // �⺻ ������
}

public class SingleTonEx01 {
//	����� d = new �����(); 
// new�� �������ؼ��� class ����� ���� �⺻ �����ڸ� private�� ����
// �ϳ��� ���� �Ϸ��� stattic���� ���� �ۼ� public static ����� instance = new �����();
// �����ڸ� private���� �����
	����� d1 = �����.getInstace();
	����� d2 = �����.getInstace();
}
