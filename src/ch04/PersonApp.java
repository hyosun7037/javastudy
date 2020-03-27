package ch04;

public class PersonApp {

	public static void main(String[] args) {
		//new를 통해서 static이 아닌 것들이 띄워지고, Person()생성자 호출
		Person p1 = new Person(); // 인스턴스화
		p1.name = "최승희";
		p1.job = "의사";
		p1.gender = '여';
		p1.bloodType = "AB";
		p1.age = 45;

		Person p2 = new Person();
		p2.name = "이미녀";
		p2.job = "골프선수";
		p2.gender = '여';
		p2.bloodType = "O";
		p2.age = 28;

		Person p3 = new Person();
		p3.name = "김미남";
		p3.job = "교수";
		p3.gender = '남';
		p3.bloodType = "AB";
		p3.age = 47;
		
		System.out.println(p3.name);
		System.out.println(p3.job);
		System.out.println(p3.gender);
		System.out.println(p3.bloodType);
		System.out.println(p3.age);
		
		Person p4 = new Person(
				"홍길동",
				"강사",
				10,
				'남',
				"B"
		);

		System.out.println(p4.name);
		System.out.println(p4.job);
		System.out.println(p4.gender);
		System.out.println(p4.bloodType);
		System.out.println(p4.age);
		
	} //end of main
}










