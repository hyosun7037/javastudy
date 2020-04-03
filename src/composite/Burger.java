package composite;

import lombok.Data;

@Data // Getter, Setter ����

public class Burger {
	private int price;
	private String desc; // private�� �����Ϸ��� getter, setter�ʿ�

	public Burger() {
		this(1500, "�⺻����"); //������
	}
	
	//����������
	public Burger(int price, String desc) { // ������ //�ٲ�� ��
		this.price = price;
		this.desc = desc;
		System.out.println(desc + "�� ����������ϴ�."); 
	}

}
