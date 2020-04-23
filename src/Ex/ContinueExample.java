package Ex;

import java.util.Scanner;

//continue, break 사용
//5개의 정수를 입력받고 그 중 양수들만 합하여 출력하는 프로그램
public class ContinueExample {

	public static void main(String[] args) {
		int sum = 0;
		int a = 0;
		System.out.println("다섯개의 정수를 입력하세요");
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			a = sc.nextInt();
			if (a < 0) {
				continue;
			} else {
				sum += a;
			}
		}System.out.println("정수의 합은 : " + sum);
	}

}
