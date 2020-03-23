package ch03;

class Data {
	int num = 10;
	//new 할때 heap에 띄움
}

public class MethodEx02 {
	static int 증가(int num) {
		num++;
		System.out.println("증가 num :" + num);
		return num;
	}

	static void 감소(Data d) {
 //Data는 크기를 알 수 없음 그래서 주소를 저장함
		d.num--;
		System.out.println("감소 num : " + d.num);
	} //끝나면 종료됨 stack 영역

	public static void main(String[] args) {
		//Value passing
		int myNum = 100; //main의 stack 영역
		myNum = 증가(myNum); 
		System.out.println("myNum :" + myNum);
		
		//Reference passing
		Data data = new Data(); 
		//주소를 가지고 있음 // new해서 heap이 만들어짐 (static이 아닌게 뜬다)
		//주소값을 가짐 (포인터 기능)
		
		감소(data); // 주소값이 넘어감 
		System.out.println("data.num : " + data.num);
	}

}
