package Ex;

import java.util.Scanner;

//continue, break ���
//5���� ������ �Է¹ް� �� �� ����鸸 ���Ͽ� ����ϴ� ���α׷�
public class ContinueExample {

	public static void main(String[] args) {
		int sum = 0;
		int a = 0;
		System.out.println("�ټ����� ������ �Է��ϼ���");
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			a = sc.nextInt();
			if (a < 0) {
				continue;
			} else {
				sum += a;
			}
		}System.out.println("������ ���� : " + sum);
	}

}
