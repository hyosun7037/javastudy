package composite;

import composite.BigBurger;
import composite.BigBurgerSet;
import composite.Burger;
import composite.Coke;
import composite.French;
import lombok.experimental.SuperBuilder;

public class LotteriaApp {
	public static void main(String[] args) {
		// BigBurgerSet 추가요!
		BigBurgerSet set1 = new BigBurgerSet();

		// Burger 추가요
		Burger burger1 = new Burger();

		// 콜라 추가요
		Coke coke1 = new Coke();

		// BigBurgerSet 추가요! 버거 1000원 할인 쿠폰 쓸게요!
		BigBurgerSet set2 = new BigBurgerSet(new BigBurger(3000, "빅버거할인"), new Coke(), new French());
		System.out.println(set1.getBigBurger().getPrice());
		System.out.println(set2.getBigBurger().getPrice());
		
		// BigBurgerSet 추가요! 버거 2000원 할인 쿠폰 쓸게요!
		BigBurgerSet set3 = new BigBurgerSet(new BigBurger(2000,"빅버거할인")); //변화값은 하나
		
		
		//새우버거세트 추가요!
		Spset set4 = new Spset();
	}

}
