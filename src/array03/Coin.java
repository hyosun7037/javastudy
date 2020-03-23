package array03;

//남은 동전의 개수를 구하는 프로그램(500,100,50,10)
public class Coin {

	public static void main(String[] args) {
		int money = 5555;
		int count = 0;
		int coin[] = {500,100,50,10,1}; //패턴이 없기 때문에 배열을 사용
		System.out.println("시작금액 : " + money);
		
		//coin의 배열의 길이만큼 반복
		for (int i = 0; i < coin.length; i++) {
			count = money / coin[i];
			money = money % coin[i];
			System.out.println(coin[i] +"원 개수 : " + count);
			System.out.println("남은금액 : " + money);
		}

//		count = money / 500;
//		money = money % 500;
//		System.out.println("500원 개수 : " + count);
//		System.out.println("남은금액 : " + money);
//		
//		count = money/100;
//		money = money%100;
//		System.out.println("100원 개수 : " + count);
//		System.out.println("남은금액 : " + money);
//		
//		count = money/50;
//		money = money%50;
//		System.out.println("50원 개수 : " + count);
//		System.out.println("남은금액 : " + money);
//		
//		count = money/10;
//		money = money%10;
//		System.out.println("10원 개수 : " + count);
//		System.out.println("남은금액 : " + money);
		
		
	}

}
