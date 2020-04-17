package ch06;

class Person {
	String name = "홍길동";
	int age = 15;
	String job = "학생";

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", job=" + job + "]";
	} // 내가 원하는 것을 문자열로 바꾸도록 재정의 하는 것 @OVERRIDE

}

public class ObjectEx02 {

	public static void main(String[] args) {
		Integer num = 10;
		String s = Integer.toString(num); // toString을 통해 모든 것을 문자로 바꿈 -- 모든 오브젝트 가능
		// String s = num.toString(); //위와 같은 값
		System.out.println(s);

		Person p = new Person();
		System.out.println(p.toString()); // 원래의 toString
		System.out.println(p); // 레퍼런스 주소를 호출하면 자동으로 toString 호출

		StringBuilder sb = new StringBuilder();
		sb.append("안녕");
		sb.append("반가워");

		System.out.println(sb); // toString을 호출하지 않아도 자동으로 toString이 호출됨
		System.out.println(sb.toString()); // toString을 호출하지 않아도 자동으로 toString이 호출됨
		// append되는 값들을 String화 시켜줌 --> toString

	}

}
