package Coffeeshop;

import java.util.ArrayList;

//화이팅
public class CoffeeApp {

	public static void main(String[] args) {
		//메뉴, 바리스타, 손님
		Consumer consumer = new Consumer();
		Barista barista = new Barista();
		
		//아이템들을 관리하기 위해서는 
		MenuItem m1 = new MenuItem("아메리카노", 1500);
		MenuItem m2 = new MenuItem("카페라떼", 2500);
		MenuItem m3 = new MenuItem("카푸치노", 4000);
		
		ArrayList<MenuItem> menuItems = new ArrayList<>();
		
		//추가할때 add
		menuItems.add(m1);
		menuItems.add(m2);
		menuItems.add(m3);
		
		//값을 가져다 쓸때는 get
		System.out.println(menuItems.get(0).getName());
		System.out.println(menuItems.get(1).getName());
		System.out.println(menuItems.get(2).getName());
		
		
		//메뉴 아이템들을 컬렉션에 담은 것
		Menu menu = new Menu(menuItems);
		
		Consumer.주문("아메리카노", menu, barista);
	}

}


// 컬렉션은 Linked list(연결리스트), 집어넣을 때 마음대로 값을 넣고 다음주소를 찾는다. 하지만 항상 처음부터 
// 접근을 해야 다음주소를 찾을 수 있다. 중간에 하나 삭제가 되면 데이터 검증이 바로 가능함
// 삭제, 삽입이 편리한 장점이 있다. 
// 액세스 속도가 느리다는 단점이 있다. --주로 블록체인에 사용


// ArrayList : 장점은 크기가 가변적이다. index를 가지고 있기 때문에 랜덤 엑세스 가능, 검색효율이 뛰어나다.
// 단점 : 삭제, 삽입시 위치이동이 일어나기 때문에 비효율적이다.


// 제네릭


// 배열은 연속된 공간이 있어야 생성가능
