package array03;

import java.util.Scanner;

public class StarEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

//		for (int i = 1; i <=5; i=i+2) {
//			System.out.println(i);
//		}
//		

		for (int i = 0; i < num; i = i + 2) {
			for (int j = num; j >i+2; j=j-2) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}

			System.out.println();
		}
//
//		for (int i = 0; i < num; i++) {
//			for (int j = 0; j <=i ; j++) {
//				System.out.print("*");
//			}
//		}System.out.println();

	}
}
