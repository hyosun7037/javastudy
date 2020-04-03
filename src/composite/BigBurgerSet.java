package composite;

import lombok.Data;

@Data
//�ڹٴ� ���߻���� �ȵ�
//��Ʈ ����� (����� + �ݶ� + ����Ƣ��)
public class BigBurgerSet { // ���� ���
	private BigBurger bigBurger; // �������鶧 ù���� �ҹ��ڷ�
	private Coke coke;
	private French french;

//	private Burger burger; //Burger�� �����ϸ� ��� ��Ʈ�� ���� �� �ִ� �ϳ��� �������� Ŭ����
//	private Coke coke;
//	private French french;

	public BigBurgerSet() {
		this(
				new BigBurger(), 
				new Coke(), 
				new French());
	}
	//������ �����ε� �Ű������� �ϳ� �þ BigBurgerŸ�� 
	public BigBurgerSet(BigBurger bigBurger) {
		this(
				bigBurger, //��ȭ��
				new Coke(),  //����Ʈ��
				new French()); //����Ʈ��
	}

	public BigBurgerSet(BigBurger bigBurger, Coke coke, French french) {
		this.bigBurger = bigBurger;
		this.coke = coke;
		this.french = french;
	}


//	public BigBurgerSet(Burger burger, Coke coke, French french) {
//		super();
//		this.bigBurger = bigBurger;
//		this.coke = coke;
//		this.french = french;
//	}
}
