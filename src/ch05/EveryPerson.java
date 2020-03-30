package ch05; //상속

class 사람 {
	int num = 10;
}

class 아시아인 extends 사람 {
	int num = 30;
}

class 한국인 extends 아시아인 {

}
//class 배우는 부모클래스가 될 수 X, 다른 트리에서 사용 가능

class 박서준 extends 한국인 {
	int num = 20; // 변수를 찾았으니까 위로 스캔 안함
}

public class EveryPerson {

	public static void main(String[] args) {
		박서준 b1 = new 박서준(); // 찾는 시점부터 위로 스캔 // 박서준만 오브젝트, 실제 존재 가능
		System.out.println(b1.num);

		한국인 b2 = new 박서준(); // 한국인 바라보는 것, 박서준부터 찾기 // 묵시적형변환 (업캐스팅)
		System.out.println(b2.num);

		// 만약 자식오브젝트인 박서준을 출력하고 싶다면?
		// 다운캐스팅으로 자식오브젝트를 출력 (전제조건 : 메모리에 떠 있어야함)

		박서준 downB2 = (박서준) b2;
		System.out.println(downB2.num);

		사람 b3 = new 한국인();
		System.out.println(b3.num);

		// 박서준 b4 = new 한국인(); 오류 --> 박서준은 메모리에 안떴기 때문에
	}

}
