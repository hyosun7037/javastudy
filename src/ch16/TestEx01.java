package ch16;

class MyConnection{ //�θ�
	
}

class MyJDBC extends MyConnection{ //�ڽ� 
	
	static MyConnection conn; // ���� ����
	
	public MyJDBC() {
		System.out.println("������ ȣ��");
	}
	
	//new �� �� static ���ΰ� ȣ���!!
	//static�ϸ� �̸� �޸𸮿� ������
	//static�� �ϸ�, ������ �ٷ� ���� �ʱ�ȭ �� ���
	
	static{
		
		//System.out.println("static �ʱ�ȭ ȣ��");
		conn = new MyJDBC(); //new MyJDBC �ϸ� �θ�, �ڽ� �� ��

	}
}

class Hello{
	public void play() {
		MyConnection conn = MyJDBC.conn; //��𼭵� ã�� ����!!
	}
}


public class TestEx01 {

	public static void main(String[] args) {
//		MyJDBC mj = new MyJDBC();
		try {
			Class.forName("ch16.MyJDBC");
			MyConnection conn = MyJDBC.conn; //������ ������ �� �� ����
			//��𼭵� ������ �� �� ����, ���۷����� ���� ���ÿ��� ������ �ʿ� X
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
