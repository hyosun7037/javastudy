package composite;

import composite.BigBurger;
import composite.BigBurgerSet;
import composite.Burger;
import composite.Coke;
import composite.French;
import lombok.experimental.SuperBuilder;

public class LotteriaApp {
	public static void main(String[] args) {
		// BigBurgerSet �߰���!
		BigBurgerSet set1 = new BigBurgerSet();

		// Burger �߰���
		Burger burger1 = new Burger();

		// �ݶ� �߰���
		Coke coke1 = new Coke();

		// BigBurgerSet �߰���! ���� 1000�� ���� ���� ���Կ�!
		BigBurgerSet set2 = new BigBurgerSet(new BigBurger(3000, "���������"), new Coke(), new French());
		System.out.println(set1.getBigBurger().getPrice());
		System.out.println(set2.getBigBurger().getPrice());
		
		// BigBurgerSet �߰���! ���� 2000�� ���� ���� ���Կ�!
		BigBurgerSet set3 = new BigBurgerSet(new BigBurger(2000,"���������")); //��ȭ���� �ϳ�
		
		
		//������ż�Ʈ �߰���!
		Spset set4 = new Spset();
	}

}
