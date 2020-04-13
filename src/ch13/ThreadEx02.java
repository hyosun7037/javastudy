package ch13;

class DownloadThread implements Runnable {

	int data = 10000;

	@Override
	public void run() { // void�� return�� ���� --> �������� ����
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		data = data + 20000; // 3�� �Ŀ� data�� 20000 ���ϱ�
		System.out.println("�ݾ� �ٿ�ε� ����");
	}
}

public class ThreadEx02 {

	public static void main(String[] args) {
		System.out.println("���α׷� ����");
		System.out.println("-------------");

		DownloadThread dt = new DownloadThread();
		dt.run();
//		Thread t1 = new Thread(dt);
//		t1.start();

		System.out.println("�ݾ��� : " + dt.data);
	}

}
