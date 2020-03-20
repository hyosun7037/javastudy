package ch03;

//메서드(함수)는 메서드(함수)안에 작성할 수 없다
//class 안에 메서드(함수)작성
public class Mem {

	int num = 10;
	static String name = "홍길동";
	void test() {
		int num = 5;
	}

	public static void main(String[] args) {
		
		int sum = 100;
		System.out.println("sum:  " +  sum);
		
		Mem m = new Mem(); //주소를 가지고 있는 것들은 4바이트, new 하면 heap이 생성
		m.test(); //test()는 static이 아니라 heap이 들고 있음
		System.out.println("번호 "  +m. num); //num도 static이 아니라 heap이 들고 있음
		System.out.println(1);
		System.out.println(2);
		System.out.println("프로그램 종료");
		
		
		
//		int num = Cal.add(5, 3);
//		System.out.println("결과 : " + num);
//
//		// minus
//		int num2 = Cal.minus(5, 3);
//		System.out.println("결과 :" + num2);
//
//		// multi
//		int num3 = Cal.multi(5, 3);
//		System.out.println("결과 :" + num3);
//
//		// divide
//		int num4 = Cal.divide(5, 3);
//		System.out.println("결과 :" + num4);
	}

}
