package ch01;

public class OperEx02 {

	public static void main(String[] args) {
		int sum = 0;// 값이 0
		int distance = 100; // 100이라는 값을 대입
		int move = 20;
		
		sum = sum + move;
		System.out.println(sum);
		
		sum = sum + move;
		System.out.println(sum); //값이 누적됨 
		
		sum = sum + move;
		System.out.println(sum); //값이 누적됨
		
		sum = sum + move;
		System.out.println(sum); //값이 누적됨 
		
		sum = sum + move;
		System.out.println("움직인 거리 : "+sum); //결합 / 묵시적 형변환
		System.out.println("도착지 : "+distance); //결합 / 묵시적 형변환
		
		
	}

}
