package ch15;

class MyOuterClass {
	static int outerNum = 10;

	class MyInnerClass {
		int innerNum = 20;

	}
}

public class InnerEx01 {

	public static void main(String[] args) {
//		new MyOuterClass.MyInnerClass();
		MyOuterClass moc = new MyOuterClass();
		MyOuterClass.MyInnerClass d = moc.new MyInnerClass(); 
		// new �ϸ� MyInnerClass �̸��� ��, ���� ������ X
	}

}


