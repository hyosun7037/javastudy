package array03;

import java.util.Scanner;

public class Gugudan2 {

	public static void main(String[] args) {
		// 사용자로 부터 입력 받은 구구단 프로그램을 완성
		Scanner sc = new Scanner(System.in);
		System.out.println("구구단을 시작합니다.");
		boolean confirm = true;
		while (confirm) {
			System.out.println("숫자를 입력하세요 2~9");
			int num = sc.nextInt();

//			System.out.println(2 + "X" + 1 + "=" + 2 * 1);
			for (int i = 1; i < 10; i++) {
				System.out.println(num + "X" + i + "=" + num * i);
			} // end of for
			System.out.println("계속 진행할까요? y or n");
			String check = sc.next();

			// check가 n이랑 같은지 물어보는 문장
			if (check.equals("n")) {
//				break;// 가장 가까운 반복문을 빠져나갈때 사용
				confirm = false;
			}
		} // end of while
		System.out.println("구구단 프로그램 종료");
	} // end of main
} // end of class
