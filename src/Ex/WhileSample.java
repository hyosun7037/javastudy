package Ex;

import java.util.Scanner;

//while사용, -1이 입력될 떄 까지 정수를 계속 입력받아 합과 평균을 구하는 프로그램
public class WhileSample {

	public static void main(String[] args) {
		int count = 0;
		int sum = 0;

		System.out.println("정수를 입력하세요");
		Scanner a = new Scanner(System.in);
		int b = a.nextInt();
		
		while(b != -1) {
			sum += b;
			count ++;
			b = a.nextInt();
		}
		
		if (count == 0) {
			System.out.println("입력받은 정수가 없습니다.");
		}else {
			System.out.println("입력받은 정수의 합은 :" + sum);
			System.out.println("입력받은 정수의 갯수는 : " +count);
		}
	}

}


