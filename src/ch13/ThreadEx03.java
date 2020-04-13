package ch13;

interface Callback { // �Լ� �ѱ���� interface ���� (��¿ �� ���� ���� ��)
	void printMoney(int money);
}

class MoneyChange {
	int money = 10000;

	// ���� �޼��尡 accept()��û �ϸ� �� ���� Thread�� �͸�Ŭ������ ����
	public void accept(Callback callback) {
		// ���࿡ ���� ��û�� �ؼ� 20000���� ���� ���� / 2�ʰ� �ɸ�!
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(2000);
					money = money + 20000; // �񵿱�� �ۼ�
					callback.printMoney(money);
				} catch (Exception e) { // �θ����� Exception���� ����
					e.printStackTrace();
				}
			}
		}).start(); // Target�� ��� �۵� X Thread(Target�ڸ�)
//		return money;
	}
}

public class ThreadEx03 {

	public static void main(String[] args) {
		MoneyChange mc = new MoneyChange(); // �ֵ����� main �����忡 ����
		mc.accept(new Callback() { // return ���� �ʿ� X, int ������
			@Override
			public void printMoney(int money) {
				System.out.println("������ �ܾ��� : " + money);
			}
		}); // �ݾ��� ������ִ� �Լ��� �־��� - �ڵ�����δ� �Ұ�
		for (int i = 1; i < 6; i++) {
			System.out.println("���ξ�����" + i); // �����ϴ� ���߿� printMoney() �޼��� �����ϵ���
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
