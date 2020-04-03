package Coffeeshop;
//책임 : 커피 제조
public class Barista {
	public Coffee 커피제조(MenuItem menuItem) {
		return new Coffee(menuItem); //new는 실체화 시키는 것, 책임은 X
		
	}
}
