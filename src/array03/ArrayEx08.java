package array03;

import java.util.Scanner;


public class ArrayEx08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("����빮�ڸ� �Է��ϼ���");
		String input = sc.next(); //next()�ؾ� �Է¹��� �� ����
//		System.out.println(input);
		char ch = input.charAt(0); //ó�� ���ڸ� ���ڴ�
//		System.out.println((char)ch);
		int num = ((int)ch);
		
		for (int i = num + 1; i <=90; i++) {
			System.out.print((char)i);
		}


	}

}
