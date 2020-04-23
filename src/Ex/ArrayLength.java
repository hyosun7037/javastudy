package Ex;

import java.util.Scanner;

//length를 이용, 배열 크기만큼 정수를 입력받고 평균을 구하는 프로그램
public class ArrayLength {

	public static void main(String[] args) {
		System.out.println("정수를 입력하세요");
		Scanner sc = new Scanner(System.in);

		int a = 0;
		int sum = 0;
		int arr[] = new int[5];

		for (int i = 0; i < arr.length; i++) {

			arr[i] = sc.nextInt();
			sum += arr[i];

		}
		System.out.println("입력받은 정수의 평균 : " + sum / arr.length);
	}

}
