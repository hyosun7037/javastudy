package Ex;

import java.util.Scanner;

//exit�� �ԷµǸ� while���� ������� �ϴ� ���α׷� - break�� ���
public class BreakExample {

	public static void main(String[] args) {
		System.out.println("exit�� �Է��ϸ� ���α׷��� ����˴ϴ�.");
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			String a = sc.nextLine();
			
			if(a.equals("exit")) {
				System.out.println("�ش� ���α׷��� �����մϴ�.");
				break;
			}
		}

	}

}

