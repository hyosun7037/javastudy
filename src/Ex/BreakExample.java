package Ex;

import java.util.Scanner;

//exit가 입력되면 while문을 벗어나도록 하는 프로그램 - break문 사용
public class BreakExample {

	public static void main(String[] args) {
		System.out.println("exit를 입력하면 프로그램이 종료됩니다.");
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			String a = sc.nextLine();
			
			if(a.equals("exit")) {
				System.out.println("해당 프로그램을 종료합니다.");
				break;
			}
		}

	}

}

