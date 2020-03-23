package array03;

public class ArrayEx01 {

	public static void main(String[] args) {

		// 내부의 메서드는 표현식 ---> 바로 실행됨
		int num = 1;
		for (long i = 2L; i <= 20000000000L; i = i * 2) {
			System.out.println("2의 " + num + "승:" + i);
			num++;
		}
//		while(true) {
//			
//		}
	}

}
