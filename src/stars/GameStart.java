package stars;

//다크템플러 DarkTempler 공격력(50), 리버 River(70) 생성

import org.omg.CORBA.ULongLongSeqHelper;

//다크템플러 DarkTempler 생성
class DarkTempler {
	final String NAME; // final 한번 초기화 되면 변경 되지 않음, 불변데이터, final은 대문자로 만듦
	int hp;
	static int attack = 50; // static으로 관리하기 때문에 Zealot이 생성되기 전에 공격력 업그레이드 가능

	public DarkTempler(String name) {
		this.NAME = name;
		this.hp = 100;
		// this.attack = 10; //값은 초기화 할때 들어감 //static 값은 안적음
	}

}

//리버 River 생성
class River {
	final String NAME; // final 한번 초기화 되면 변경 되지 않음, 불변데이터, final은 대문자로 만듦
	int hp;
	static int attack = 70; // static으로 관리하기 때문에 Zealot이 생성되기 전에 공격력 업그레이드 가능

	public River(String name) {
		this.NAME = name;
		this.hp = 100;
		// this.attack = 10; //값은 초기화 할때 들어감 //static 값은 안적음
	}

}

//질럿 Zealot 생성
class Zealot {
	final String NAME; // final 한번 초기화 되면 변경 되지 않음, 불변데이터, final은 대문자로 만듦
	int hp;
	static int attack = 10; // static으로 관리하기 때문에 Zealot이 생성되기 전에 공격력 업그레이드 가능

	public Zealot(String name) {
		this.NAME = name;
		this.hp = 100;
		// this.attack = 10; //값은 초기화 할때 들어감 //static 값은 안적음
	}

}

//드래곤 Dragon 생성
class Dragon {
	final String NAME;
	int hp;
	static int attack = 10;

	public Dragon(String name) {
		this.NAME = name;
		this.hp = 100;
		// this.attack = 10;
	}

}

public class GameStart {

	// 공격방향
	// 질럿 > 드라곤
	static void attack(Zealot u1, Dragon u2) {
		u2.hp = u2.hp - u1.attack; // 드라곤의 생명력은 질럿의 공격력을 빼면됨
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은" + u2.hp + "입니다.");
	}

	// 드라곤 > 질럿
	static void attack(Dragon u1, Zealot u2) {
		u2.hp = u2.hp - u1.attack; // 드라곤의 생명력은 질럿의 공격력을 빼면됨
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은" + u2.hp + "입니다.");
	}

	// 질럿 > 질럿
	static void attack(Zealot u1, Zealot u2) {
		u2.hp = u2.hp - u1.attack; // 드라곤의 생명력은 질럿의 공격력을 빼면됨
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은" + u2.hp + "입니다.");
	}

	// 드라곤 > 드라곤
	static void attack(Dragon u1, Dragon u2) {
		u2.hp = u2.hp - u1.attack; // 드라곤의 생명력은 질럿의 공격력을 빼면됨
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은" + u2.hp + "입니다.");
	}

	// 다크템플러 > 질럿
	static void attack(DarkTempler u1, Zealot u2) {
		u2.hp = u2.hp - u1.attack; // 드라곤의 생명력은 질럿의 공격력을 빼면됨
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은" + u2.hp + "입니다.");
	}

	// 다크템플러 > 드라곤
	static void attack(DarkTempler u1, Dragon u2) {
		u2.hp = u2.hp - u1.attack; // 드라곤의 생명력은 질럿의 공격력을 빼면됨
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은" + u2.hp + "입니다.");
	}

	// 다크템플러 > 리버
	static void attack(DarkTempler u1, River u2) {
		u2.hp = u2.hp - u1.attack; // 드라곤의 생명력은 질럿의 공격력을 빼면됨
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은" + u2.hp + "입니다.");
	}
	
	//질럿 > 다크템플러
	static void attack(Zealot u1, DarkTempler u2) {
		u2.hp = u2.hp - u1.attack; // 드라곤의 생명력은 질럿의 공격력을 빼면됨
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은" + u2.hp + "입니다.");
	}
	
	//드라곤 > 다크템플러
	static void attack(Dragon u1, DarkTempler u2) {
		u2.hp = u2.hp - u1.attack; // 드라곤의 생명력은 질럿의 공격력을 빼면됨
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은" + u2.hp + "입니다.");
	}
	
	//리버 > 다크템플러
	static void attack(River u1, DarkTempler u2) {
		u2.hp = u2.hp - u1.attack; // 드라곤의 생명력은 질럿의 공격력을 빼면됨
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은" + u2.hp + "입니다.");
	}
	
	//리버 > 질럿
	static void attack(River u1, Zealot u2) {
		u2.hp = u2.hp - u1.attack; // 드라곤의 생명력은 질럿의 공격력을 빼면됨
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은" + u2.hp + "입니다.");
	}
	
	//리버 > 드라곤
	static void attack(River u1, Dragon u2) {
		u2.hp = u2.hp - u1.attack; // 드라곤의 생명력은 질럿의 공격력을 빼면됨
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은" + u2.hp + "입니다.");
	}
	
	
	//질럿 > 리버
	static void attack(Zealot u1, River u2) {
		u2.hp = u2.hp - u1.attack; // 드라곤의 생명력은 질럿의 공격력을 빼면됨
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은" + u2.hp + "입니다.");
	}
	
	//드라곤 > 리버
	static void attack(Dragon u1, River u2) {
		u2.hp = u2.hp - u1.attack; // 드라곤의 생명력은 질럿의 공격력을 빼면됨
		System.out.println(u2.NAME + "이 공격당하고 있습니다.");
		System.out.println(u2.NAME + "의 체력은" + u2.hp + "입니다.");
	}

	
	

	public static void main(String[] args) {
		// 공격력 업그레이드 하기
		Zealot.attack++;
		// 질럿 생성하기
		Zealot z1 = new Zealot("1번질럿");
		System.out.println(Zealot.attack);

		Zealot z2 = new Zealot("2번질럿");
		System.out.println(Zealot.attack);

		Dragon d1 = new Dragon("1번 드라곤");
		System.out.println(Dragon.attack);

		Dragon d2 = new Dragon("2번 드라곤");
		System.out.println(Dragon.attack);
		
		DarkTempler t1 = new DarkTempler("1번 다크템플러");
		System.out.println(DarkTempler.attack);
		
		DarkTempler t2 = new DarkTempler("2번 다크템플러");
		System.out.println(DarkTempler.attack);
		
		River r1 = new River("1번 리버");
		System.out.println(River.attack);
		
		River r2 = new River("2번 리버");
		System.out.println(River.attack);

		
		// 공격하기
		//질럿 > 드라곤
		attack(z1, d1);
		attack(z1, d1);

		//드라곤 > 질럿
		attack(d1, z1);
		attack(d1, z1);

		//질럿 > 질럿
		attack(z1, z2);
		attack(z1, z2);

		//드라곤 > 드라곤
		attack(d1, d2);
		attack(d1, d2);
		
		
		/////
		
		
		// 다크템플러 > 질럿
		attack(t1, z1);
		
		// 다크템플러 > 드라곤
		attack(t1, d1);
		
		// 다크템플러 > 리버
		attack(t1, r1);
		
		//질럿 > 다크템플러
		attack(z1, t1);
		
		//드라곤 > 다크템플러
		attack(d1, t1);
		
		//리버 > 다크템플러
		attack(r1, t1);
		
		//리버 > 다크템플러
		attack(r1, t1);
		
		//리버 > 질럿
		attack(r1, z1);
		
		//리버 > 드라곤
		attack(r1, d1);
		
		//다크템플러 > 리버
		attack(t1, r1);
		
		//질럿 > 리버
		attack(z1, r1);
		
		//드라곤 > 리버
		attack(d1, r1);
	

	}

}
