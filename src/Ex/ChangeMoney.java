package Ex;

import java.util.Scanner;

public class ChangeMoney {

	int [] unit = {50000,10000,1000,500,100,50,10,1};
	
	public ChangeMoney() {
		System.out.println("금액을 입력하세요");
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt(); //입력받은 금액
		
		for (int i = 0; i < unit.length; i++) {
			int c = money/unit[i];
			
			if(c>0) {
				System.out.println(unit[i] + "원 짜리" + c + "개");
				money = money%unit[i];
			}
		}
		
	}
	public static void main(String[] args) {
		new ChangeMoney();
	}

}
