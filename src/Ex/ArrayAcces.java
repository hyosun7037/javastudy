package Ex;

import java.util.Scanner;

//양수 5개를 입력받아 배열에 저장, 제일 큰 수를 출력하는 프로그램
public class ArrayAcces {

	public static void main(String[] args) {
		int array[] = new int[5];
		Scanner sc = new Scanner(System.in);
		System.out.println("양수5개를 입력하세요");
		int max = 0;

		for (int i = 0; i < 5; i++) {

			array[i] = sc.nextInt();
			if (array[i] > max) {
				max = array[i];
			}

		}
		System.out.println("제일 큰 숫자는 : " + max + "입니다.");
	}

}
