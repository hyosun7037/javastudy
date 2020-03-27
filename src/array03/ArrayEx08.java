package array03;

import java.util.Scanner;


public class ArrayEx08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("영어대문자를 입력하세요");
		String input = sc.next(); //next()해야 입력받을 수 있음
//		System.out.println(input);
		char ch = input.charAt(0); //처음 글자만 쓰겠다
//		System.out.println((char)ch);
		int num = ((int)ch);
		
		for (int i = num + 1; i <=90; i++) {
			System.out.print((char)i);
		}


	}

}
