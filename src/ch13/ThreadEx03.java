package ch13;

interface Callback { // 함수 넘기려고 interface 생성 (어쩔 수 없이 만든 것)
	void printMoney(int money);
}

class MoneyChange {
	int money = 10000;

	// 메인 메서드가 accept()요청 하면 그 안의 Thread의 익명클래스가 실행
	public void accept(Callback callback) {
		// 은행에 인출 요청을 해서 20000원을 받을 예정 / 2초가 걸림!
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(2000);
					money = money + 20000; // 비동기로 작성
					callback.printMoney(money);
				} catch (Exception e) { // 부모요소인 Exception으로 변경
					e.printStackTrace();
				}
			}
		}).start(); // Target이 없어서 작동 X Thread(Target자리)
//		return money;
	}
}

public class ThreadEx03 {

	public static void main(String[] args) {
		MoneyChange mc = new MoneyChange(); // 주도권이 main 쓰레드에 있음
		mc.accept(new Callback() { // return 받을 필요 X, int 지워줌
			@Override
			public void printMoney(int money) {
				System.out.println("통장의 잔액은 : " + money);
			}
		}); // 금액을 출력해주는 함수를 넣어줌 - 코드상으로는 불가
		for (int i = 1; i < 6; i++) {
			System.out.println("메인쓰레드" + i); // 실행하는 도중에 printMoney() 메서드 실행하도록
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
