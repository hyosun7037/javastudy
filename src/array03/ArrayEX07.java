package array03;

import java.util.Scanner;

public class ArrayEX07 {
//6자리 숫자를 입력해서 3이 있는지 체크 하기 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("6자리 숫자를 입력하세요");
		int num = sc.nextInt(); //6자리 수 입력
		
		String strNum = num +"";
//		System.out.println(strNum.charAt(2));
//		System.out.println(strNum.length());
		int len = strNum.length();
		boolean check = false;
		for (int i = 0; i < len; i++) {
			if (strNum.charAt(i) =='3') {
				check = true;
			}
		}
		if(check) {
			System.out.println("3이 존재합니다.");
		}else {
			System.out.println("3이 존재하지 않습니다.");
		}
	}

}
