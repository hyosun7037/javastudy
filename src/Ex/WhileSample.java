package Ex;

import java.util.Scanner;

//while���, -1�� �Էµ� �� ���� ������ ��� �Է¹޾� �հ� ����� ���ϴ� ���α׷�
public class WhileSample {

	public static void main(String[] args) {
		int count = 0;
		int sum = 0;

		System.out.println("������ �Է��ϼ���");
		Scanner a = new Scanner(System.in);
		int b = a.nextInt();
		
		while(b != -1) {
			sum += b;
			count ++;
			b = a.nextInt();
		}
		
		if (count == 0) {
			System.out.println("�Է¹��� ������ �����ϴ�.");
		}else {
			System.out.println("�Է¹��� ������ ���� :" + sum);
			System.out.println("�Է¹��� ������ ������ : " +count);
		}
	}

}


