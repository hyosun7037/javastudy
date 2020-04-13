package ch13;

class DownloadThread implements Runnable {

	int data = 10000;

	@Override
	public void run() { // void라서 return을 못함 --> 전역으로 빼줌
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		data = data + 20000; // 3초 후에 data에 20000 더하기
		System.out.println("금액 다운로드 종료");
	}
}

public class ThreadEx02 {

	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		System.out.println("-------------");

		DownloadThread dt = new DownloadThread();
		dt.run();
//		Thread t1 = new Thread(dt);
//		t1.start();

		System.out.println("금액은 : " + dt.data);
	}

}
