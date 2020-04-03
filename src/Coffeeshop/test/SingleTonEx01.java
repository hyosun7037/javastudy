package Coffeeshop.test;

class 대통령 {
	
	private static 대통령 instance = new 대통령();
	
	public static 대통령 getInstace() {
		return instance;
	}
	
	private 대통령() {}
//	public 대통령() {
//	} // 기본 생성자
}

public class SingleTonEx01 {
//	대통령 d = new 대통령(); 
// new를 막기위해서는 class 대통령 안의 기본 생성자를 private로 수정
// 하나만 띄우게 하려면 stattic으로 새로 작성 public static 대통령 instance = new 대통령();
// 생성자를 private으로 만들기
	대통령 d1 = 대통령.getInstace();
	대통령 d2 = 대통령.getInstace();
}
