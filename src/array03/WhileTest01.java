package array03;

public class WhileTest01 {

	public static void main(String[] args) {
		int destination = 11271;
		int speed=3;
		int car = 0;
		int i=1;
		while(destination!=car) {
			car = car + speed;
			i++;
		}
		System.out.println(i+"Йј");
		int min = i/60;
		System.out.println(min+"Ка");
		int hour = min/60;
	}

}
