package ch06;

class Person {
	String name = "ȫ�浿";
	int age = 15;
	String job = "�л�";

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", job=" + job + "]";
	} // ���� ���ϴ� ���� ���ڿ��� �ٲٵ��� ������ �ϴ� �� @OVERRIDE

}

public class ObjectEx02 {

	public static void main(String[] args) {
		Integer num = 10;
		String s = Integer.toString(num); // toString�� ���� ��� ���� ���ڷ� �ٲ� -- ��� ������Ʈ ����
		// String s = num.toString(); //���� ���� ��
		System.out.println(s);

		Person p = new Person();
		System.out.println(p.toString()); // ������ toString
		System.out.println(p); // ���۷��� �ּҸ� ȣ���ϸ� �ڵ����� toString ȣ��

		StringBuilder sb = new StringBuilder();
		sb.append("�ȳ�");
		sb.append("�ݰ���");

		System.out.println(sb); // toString�� ȣ������ �ʾƵ� �ڵ����� toString�� ȣ���
		System.out.println(sb.toString()); // toString�� ȣ������ �ʾƵ� �ڵ����� toString�� ȣ���
		// append�Ǵ� ������ Stringȭ ������ --> toString

	}

}
