package ch13;

class Sub implements Runnable {
//	﻿OS는 Runnable 타입의 heap 공간에 run 메서드를 호출해야된다는 걸 이미 알고 있음
	@Override
	public void run() {
		for (int i = 1; i < 11; i++) {
			System.out.println("서브쓰레드 :" + i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) { // 부모타입인 Exception로 적어줌
				e.printStackTrace();
			} 
		}
	}
}

public class ThreadEx01 {

	public static void main(String[] args) {
		// 메인 쓰레드
		Sub s = new Sub();
		Thread t1 = new Thread(s); // 메모리 heap에 sub가 띄워지고 안의 run()도 메모리에 띄워짐
		// 운영체제에게 스레드를 요청하기 위해서는 스택을 가지고 있어야함
		// 그 약속은 runnable 타입의 run()을 실행하도록 정해져 있음
		t1.start();

		for (int i = 1; i < 6; i++) {
			System.out.println("메인쓰레드 :" + i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) { // 부모타입인 Exception로 적어줌
				e.printStackTrace();
			} // 1초동안 잠깐 쉬고 있다가 다른 스레드에게 간섭받아서 다시 실행되면 꼬여서 프로그램이 뻗을 수 있음
				// try catch가 필요
		}
	}

}
