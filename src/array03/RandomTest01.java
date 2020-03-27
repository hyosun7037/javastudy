package array03;

import java.util.Random;
import java.util.Scanner;

public class RandomTest01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			Random r = new Random();
			int k = r.nextInt(100);
			System.out.println("수를 결정하였습니다. 맞추어 보세요");
			System.out.println("0-99");
			int i = 1;

			while (true) {
				System.out.println(i + ">>");
				int input = sc.nextInt();

				while (input != k) {
					if (input < k)
						System.out.println("더 크게");
					else if (input > k)
						System.out.println("더 작게");
					i++;
					break;
				}
				if (input == k) {
					System.out.println("맞았습니다.");
					System.out.println("다시 하겠습니까? y/n");

					if (sc.next().equals("n")) { // 프로그램 종료 코드
						System.out.println("숫자 맞추기를 종료합니다.");
						System.exit(0);
					} else // 계속 게임을 한다면
						break;
				}
			}
		}

	}

}
