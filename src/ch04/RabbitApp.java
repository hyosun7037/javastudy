package ch04;

import java.security.PublicKey;

class Rabbit {
	private String name; //heap변수, 전역변수, 멤버변수, 필드, 속성, 프로퍼티
	private int power;

	public Rabbit(String name, int power) {
		this.name = name;
		this.power = power;
	}

	// power를 증가시키는 것
	// 행동
	boolean drink() {
		// 100이 넘어가면 동작하지 않도록!
		if (power == 100) {
			return false;
		}
		power++;
		return true;
	}

	public int getPower() { 
		return power; // 어디서든 볼 수 있게 public실행
	}
	void setName(String name) {
		this.name = name; //생성자는 최초의 객체가 생성될때 만들고, 그 후에 변화가 있을때는 this 사용
	}
	//public은 모든 클래스에서 접근 가능, new할때 뜸, 내부 stack은 호출할때 뜸
	public String getName() {
		return name;
	}
}

public class RabbitApp {

	public static void main(String[] args) {
		Rabbit r1 = new Rabbit("토끼", 20); // 100이 MAX라고 가정

		while (r1.drink()) {
		}
		System.out.println(r1.getPower());
		
		//이름변경
		r1.setName("산토끼");
		System.out.println(r1.getName());
	}

}
