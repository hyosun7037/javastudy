package Ex;

import java.util.Scanner;

//��� 5���� �Է¹޾� �迭�� ����, ���� ū ���� ����ϴ� ���α׷�
public class ArrayAcces {

	public static void main(String[] args) {
		int array[] = new int[5];
		Scanner sc = new Scanner(System.in);
		System.out.println("���5���� �Է��ϼ���");
		int max = 0;

		for (int i = 0; i < 5; i++) {

			array[i] = sc.nextInt();
			if (array[i] > max) {
				max = array[i];
			}

		}
		System.out.println("���� ū ���ڴ� : " + max + "�Դϴ�.");
	}

}
