package Coffeeshop.test;

class Data<T> {
	T value;
}

class Data1<H>{
	H value;
}

class Str<K,V>{
	K k;
	V v;
}

class DDD{
	int num = 10;
	Integer num2 = 10;
	long n = 1000L;
	Long nLong = 100000L;
}

public class GenericEx01 {

	public static void main(String[] args) {
		Data<Integer> data = new Data<>();
		data.value = 10;
		System.out.println(data.value);
		
		//Wrapper 클래스 : 기본자료형을 클래스화 시켜주는 기술
		Data<Integer> data2 = new Data();
		Data<Character> data3 = new Data();
		
		Str<String, String> s = new Str<>();
		s.k = "비밀번호";
		s.v = "bitc5500";
		
		System.out.println(s.k);
		System.out.println(s.v);
	
	}

}
