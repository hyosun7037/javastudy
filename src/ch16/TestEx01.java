package ch16;

class MyConnection{ //부모
	
}

class MyJDBC extends MyConnection{ //자식 
	
	static MyConnection conn; // 변수 생성
	
	public MyJDBC() {
		System.out.println("생성자 호출");
	}
	
	//new 할 때 static 내부가 호출됨!!
	//static하면 미리 메모리에 떠있음
	//static만 하면, 스택이 바로 실행 초기화 때 사용
	
	static{
		
		//System.out.println("static 초기화 호출");
		conn = new MyJDBC(); //new MyJDBC 하면 부모, 자식 다 뜸

	}
}

class Hello{
	public void play() {
		MyConnection conn = MyJDBC.conn; //어디서든 찾기 가능!!
	}
}


public class TestEx01 {

	public static void main(String[] args) {
//		MyJDBC mj = new MyJDBC();
		try {
			Class.forName("ch16.MyJDBC");
			MyConnection conn = MyJDBC.conn; //변수를 가지고 올 수 있음
			//어디서든 가져와 쓸 수 있음, 레퍼런스를 굳이 스택에서 관리할 필요 X
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
