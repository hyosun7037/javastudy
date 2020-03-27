package array03;

public class StarEx02 {

	static void printStarts(int i) {
		if (i == 1) {
			for (int j = 0; j < 4 - i; j++) {
				System.out.print("_");
			}

			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		if (i == 2) {
			for (int j = 0; j < 4 - i; j++) {
				System.out.print("_");
			}

			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		if (i == 3) {
			for (int j = 0; j < 4 - i; j++) {
				System.out.print("_");
			}

			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		if (i == 4) {
			for (int j = 0; j < 4 - i; j++) {
				System.out.print("_");
			}

			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {

		printStarts(1);
		printStarts(2);
		printStarts(3);
		printStarts(4);


	}

}
