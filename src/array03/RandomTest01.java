package array03;

import java.util.Random;
import java.util.Scanner;

public class RandomTest01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			Random r = new Random();
			int k = r.nextInt(100);
			System.out.println("���� �����Ͽ����ϴ�. ���߾� ������");
			System.out.println("0-99");
			int i = 1;

			while (true) {
				System.out.println(i + ">>");
				int input = sc.nextInt();

				while (input != k) {
					if (input < k)
						System.out.println("�� ũ��");
					else if (input > k)
						System.out.println("�� �۰�");
					i++;
					break;
				}
				if (input == k) {
					System.out.println("�¾ҽ��ϴ�.");
					System.out.println("�ٽ� �ϰڽ��ϱ�? y/n");

					if (sc.next().equals("n")) { // ���α׷� ���� �ڵ�
						System.out.println("���� ���߱⸦ �����մϴ�.");
						System.exit(0);
					} else // ��� ������ �Ѵٸ�
						break;
				}
			}
		}

	}

}
