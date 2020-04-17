package ch06;

class Animal {
	@Override
	public int hashCode() {
		return super.hashCode(); // object�� ��� �����ϱ� override����
	}
}

public class ObjectEx01 {

	public static void main(String[] args) {

		String d1 = "��";
		String d2 = "��";

		System.out.println(d1.equals(d2)); // object�� ��� ����, �ڵ����
		System.out.println(d1 == d2);

		////////////////////////////////

		String d3 = new String("��");
		String d4 = new String("��");

		System.out.println(d3.equals(d4));
		System.out.println(d3 == d4);

		///////////////////////////////

		System.out.println(d3.getClass());
		System.out.println(new ObjectEx01().getClass()); // class�� ������ return

		// �ؽ��ڵ� -> �ؽ� �˰��� = ��� ���ڵ� ������ ������ ���ڷ� return
		System.out.println(d3.hashCode());
		System.out.println(d4.hashCode()); 
		// String = ���� ���̸� �����ڵ尡 ������ �ٲ����
		

		
		Animal a1 = new Animal();
		Animal a2 = new Animal();
		
		System.out.println(a1.hashCode()); 
		System.out.println(a2.hashCode());
		//new�� �ι��߱� ������ (�ּҰ��� �޶���) �ؽ��ڵ尡 �ٸ��� ����
		//���� ������ �ƴ��� �ּҸ� ���� �� �� ����
		
		
		System.out.println(a1 instanceof Animal); 
		System.out.println(a2 instanceof Animal);
		//Ÿ���� ����, ������ �ٸ�
		//��üŸ���� ������ ���� �� ���� ��
	}

}
