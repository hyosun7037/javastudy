package composite;

//Burger�� ���
public class BigBurger extends Burger {
	public BigBurger() {
		super(4000, "�����"); // �θ� ����ִ� price�� desc�� ����
	}

	public BigBurger(int price, String desc) {
		super(price, desc);
	}
}
