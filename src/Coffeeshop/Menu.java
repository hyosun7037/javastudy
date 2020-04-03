package Coffeeshop;

import java.util.ArrayList;

import lombok.Data;
@Data
//책임 : 메뉴선택 (손님에게 책임X, 객체지향에서는 모든 객체는 생명력을 가지고 있다고 가정)
public class Menu {
	
	//메뉴 아이템들을 가지고 있어야함. Composition
	//가변배열
	//메뉴 아이템들(컬렉션), 배열대신 사용
	private ArrayList<MenuItem> menuItems; //세가지 메뉴가 담겨있음

	public Menu(ArrayList<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	//foreach문 배열이나 컬렉션 크기만큼 반복해서 값을 찾음
	// 하나의 요소:배열이나 컬렉션크기
	
	public MenuItem 메뉴선택(String menuName) {
		for (MenuItem menuItem : menuItems) {
			if(menuItem.getName().equals(menuItem)); //손님이 요청한 커피가 존재하는지 확인
			return menuItem;
		}
		return null;
		//메뉴와 가격을 리턴해줘야되기 때문에 String을 쓸 수 X
	}
}