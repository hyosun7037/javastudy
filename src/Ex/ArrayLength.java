package Ex;

import java.util.Scanner;

//length�� �̿�, �迭 ũ�⸸ŭ ������ �Է¹ް� ����� ���ϴ� ���α׷�
public class ArrayLength {

	public static void main(String[] args) {
		System.out.println("������ �Է��ϼ���");
		Scanner sc = new Scanner(System.in);

		int a = 0;
		int sum = 0;
		int arr[] = new int[5];

		for (int i = 0; i < arr.length; i++) {

			arr[i] = sc.nextInt();
			sum += arr[i];

		}
		System.out.println("�Է¹��� ������ ��� : " + sum / arr.length);
	}

}
