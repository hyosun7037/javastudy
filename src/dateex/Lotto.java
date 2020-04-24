package dateex;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Lotto {

	public static void main(String[] args) {
		// 6개의 번호 - (1~45)
		Set<Integer> lottoSet = new HashSet<>();// wrapper 클래스, Set은 인터페이스, 중복된 원소를 허용 X
		Random r = new Random();
		while (lottoSet.size() < 6) {
			int value = r.nextInt(45 + 1); // 0~44가 나오기 때문에 1을 더해줌
			lottoSet.add(value);
		}
		System.out.print(lottoSet);

	}

}
