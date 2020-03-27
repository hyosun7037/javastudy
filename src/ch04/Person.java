package ch04;

public class Person {
//상태와 행동
	String name;
	String job;
	int age;
	char gender;
	String bloodType;

	public Person() {
	}
	// 디폴트 생성자(매개변수가 없는 아이) = 초기화

	public Person(String name, String job, int age, char gender, String bloodType) {
		this.name = name;
		this.job = job;
		this.age = age;
		this.gender = gender;
		this.bloodType = bloodType;

	}

}
