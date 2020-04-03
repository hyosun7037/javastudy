package Coffeeshop;

//책임 : 주문
//메뉴판이랑 바리스타 레퍼런스를 가지고 있어야함
//메인스텍이 들고 있음 -- 메인으로 받아야함
public class Consumer {

	public static void 주문(String menuName, Menu menu, Barista barista) {
		//손님 -> 메뉴판 메시지를 보낸다.(메뉴 선택 해줘)
		MenuItem menuItem = menu.메뉴선택(menuName);
		
		if(menuItem == null) {
			System.out.println(menuName + "은 우리 매장에 없습니다.");
		}else {
			//손님이 바리스타에게 메시지를 보낸다. (커피 생성 해줘)
			Coffee coffee = barista.커피제조(menuItem);
			System.out.println(coffee.getName());
			System.out.println(coffee.getPrice());
		}
	}
}

//