package array03;

import java.util.Scanner;

import javax.xml.transform.Templates;

public class ArratEx05 {

	public static void main(String[] args) {
		/*
		 * ���� 1000000000�Է¹ް� (10��) 3�ڸ� ���� �޸��� �� ���!! 1,000,000,000
		 */
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

//		String tempNumString = num + ""; 
//		//int�� String�� ���ϸ� ������ ����ȯ�� �Ͼ
//		//int�� String�� �����
//		String tempNum2[] = tempNumString.split("");
//		//split �и���Ŵ
//		//���� ��� abc�� �и��Ϸ��� "" �ƹ��͵� �ȳ������
//		System.out.println(tempNum2[0]);
//		System.out.println("���� : " + tempNum2.length); //�迭�� ũ��

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

