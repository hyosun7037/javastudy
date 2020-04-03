package Coffeeshop;

import lombok.Data;

@Data
public class Coffee {
	private String name;
	private int price;
	
	public Coffee(MenuItem menuItem) {
		this.name = menuItem.getName();
		this.price = menuItem.getPrice();
	}
	
	
}
//Constructor 생성자는 직접 만든다. 이유는 커피가 만들어 질 때
//메뉴에 있는 것만 선택해서 바리스타가 만들도록 한다. 메뉴를 무조건 선택해야 되기 때문에
//빈생성자는 필요 X