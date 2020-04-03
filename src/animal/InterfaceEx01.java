package animal;

interface Cal{
	/*public static final */int num = 10;
	//	변수 : public static final 생략
	//	함수 : public abstract 생략
	//	인터페이스는 통로의 역할 - 동적바인딩 용도
}

public class InterfaceEx01 {
	public static void main(String[] args) {
		System.out.println(Cal.num);
	}
}
