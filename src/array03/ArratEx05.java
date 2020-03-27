package array03;

import java.util.Scanner;

import javax.xml.transform.Templates;

public class ArratEx05 {

	public static void main(String[] args) {
		/*
		 * 숫자 1000000000입력받고 (10억) 3자리 마다 콤마를 찍어서 출력!! 1,000,000,000
		 */
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

//		String tempNumString = num + ""; 
//		//int랑 String을 더하면 묵시적 형변환이 일어남
//		//int가 String에 저장됨
//		String tempNum2[] = tempNumString.split("");
//		//split 분리시킴
//		//예를 들어 abc를 분리하려면 "" 아무것도 안넣으면됨
//		System.out.println(tempNum2[0]);
//		System.out.println("길이 : " + tempNum2.length); //배열의 크기

		String tempNumString = num + "";
		String tempNum2[] = tempNumString.split("");

		int len = tempNum2.length;
		for (int i = 0; i < len; i++) {
			if ((len - i) % 3 == 0 && i != 0) {
				System.out.print(",");
			}
			System.out.print(tempNum2[i]);

//		for (int i = tempNum2.length - 1; i >= 0; i--) {
//			System.out.print(tempNum2[i]);
//			if ((tempNum2.length  -1 -i) % 3 == 0) {
//				tempNum2[i] = "," + tempNum2[i];
//			}
//			
//		}

		}

	}
}

