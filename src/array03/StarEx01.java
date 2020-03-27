package array03;

public class StarEx01 {

	static void printStars(int i) {
		for (int j = 0; j < i; j++) {
			System.out.print("*");
		}
		System.out.println();
	}

	//¹Ù±ù for¹®Àº Çà
	
	public static void main(String[] args) {
//		System.out.println("*"); // 1
//		System.out.println("**"); // 2
//		System.out.println("***"); // 3
//		System.out.println("****"); // 4
//		
//		printStars(4);
//		printStars(3);
//		printStars(2);
//		printStars(1);
		
		for (int i = 5; i>=1; i--) {
		printStars(i);
	}
		
//		for (int i = 1; i < 5; i++) {
//			printStars(i);
//		}
		
		
//		printStars(1);
		
//		printStars(2);
//		printStars(3);
//		printStars(4);
	}
}
