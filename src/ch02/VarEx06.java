package ch02;

class Person{
	String name = "È«±æµ¿";
	int age = 29;
	char gender = '¿©';
	String email = "haha7037@naver.com";
	String phone = "010-0000-2000";
}

public class VarEx06 {

	public static void main(String[] args) {
		Person a = new Person();
		System.out.println(a.name);
		System.out.println(a.age);
		System.out.println(a.gender);
		System.out.println(a.email);
		System.out.println(a.phone);
	}

}
