package composite;

public class ��� {

	String item1;
	String item2;
	String item3;

	public ���(String item1, String item2, String item3) {
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
	}// ����ڰ� ���� ������

	public ���() {
		this("��", "�Ǵ��⽺��", "�и�����");
	} // �⺻ ������ //�ȿ� �Ű������� �ֱ� ������ �⺻�����ڸ� ����Ѵ�.

	
	public ���(String item1) {
		this(item1, "�Ǵ��⽺��", "�и�����");
	} 
	
	public ���(String item1, String item3) {
		this(item1, null, item3);
	} 
	
	// �⺻ ������ //�ȿ� �Ű������� �ֱ� ������ �⺻�����ڸ� ����Ѵ�.
	
	public static void main(String[] args) {
		��� i1 = new ���("��", "�Ǵ��⽺��", "�и�����");
		��� i2 = new ���(); // �Ű������� ������ �޶����� ������ �����ε�
		��� i3 = new ���("�ҶṰ", "�Ǵ��⽺��", "�и�����");
		��� i4 = new ���("�ҶṰ", "�Ǵ��⽺��", "�и�����");
		��� i5 = new ���("�ҶṰ", "�Ǵ��⽺��", "�и�����");
		��� i6 = new ���();
		��� i7 = new ���("�ҶṰ", "�Ǵ��⽺��", "�и�����");
		��� i8 = new ���("�ҶṰ");
		��� i9 = new ���("�ҶṰ", "�и�����");
	}

}
