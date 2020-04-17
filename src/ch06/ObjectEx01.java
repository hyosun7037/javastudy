package ch06;

class Animal {
	@Override
	public int hashCode() {
		return super.hashCode(); // object가 들고 있으니까 override가능
	}
}

public class ObjectEx01 {

	public static void main(String[] args) {

		String d1 = "물";
		String d2 = "물";

		System.out.println(d1.equals(d2)); // object가 들고 있음, 자동상속
		System.out.println(d1 == d2);

		////////////////////////////////

		String d3 = new String("물");
		String d4 = new String("물");

		System.out.println(d3.equals(d4));
		System.out.println(d3 == d4);

		///////////////////////////////

		System.out.println(d3.getClass());
		System.out.println(new ObjectEx01().getClass()); // class의 정보를 return

		// 해쉬코드 -> 해쉬 알고리즘 = 어떠한 문자든 동일한 길이의 숫자로 return
		System.out.println(d3.hashCode());
		System.out.println(d4.hashCode()); 
		// String = 같은 값이면 같은코드가 나오게 바꿔놓음
		

		
		Animal a1 = new Animal();
		Animal a2 = new Animal();
		
		System.out.println(a1.hashCode()); 
		System.out.println(a2.hashCode());
		//new를 두번했기 때문에 (주소값이 달라짐) 해쉬코드가 다르게 나옴
		//같은 값인지 아닌지 주소를 보고 알 수 있음
		
		
		System.out.println(a1 instanceof Animal); 
		System.out.println(a2 instanceof Animal);
		//타입은 같음, 공간이 다름
		//객체타입이 같은지 비교할 때 쓰는 것
	}

}
