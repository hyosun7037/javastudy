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
		// new 하면 MyInnerClass 이름만 뜸, 안의 내용은 X
	}

}


