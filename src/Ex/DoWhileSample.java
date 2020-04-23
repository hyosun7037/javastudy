package Ex;

//a부터 z까지 출력하는 프로그램
public class DoWhileSample {

	public static void main(String[] args) {
	char a = 'a';
	do {
		System.out.print(" "+ a);
		a = (char)(a+1);
	} while (a <= 'z');

	}

}
