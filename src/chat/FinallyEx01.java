package chat;

interface StarUnit {
	abstract int getHp(); // 전체클래스가 공통으로 가지는 메서드
}

abstract class Protoss implements StarUnit {
	abstract int getSh(); //protoss 유일, protoss만 getHp, getSp 둘 다 확인
}

abstract class Zerg implements StarUnit { //getHp만 있으면 됨
	int hp = 100;
	@Override
	public int getHp() {
		return 0;
	}
}

class Zealot extends Protoss {
	int sh = 100;
	int hp = 100;
	
	@Override
	public int getHp() {
		return hp;
	}

	@Override
	public int getSh() {
		return sh;
	}
}

class Ultra extends Zerg {
	int hp = 100;
	
	@Override
	public int getHp() {
		return hp;
	}
}


public class FinallyEx01 {
	//상태체크, (hp,sh)
	static void check(StarUnit unit) {
		try {
			Zealot z = (Zealot) unit; //다운캐스팅
			System.out.println("남은 쉴드는" + z.getSh());
			System.out.println("남은 체력은" + z.getHp());
		} catch (Exception e) {
			//저그
			Ultra u = (Ultra) unit;
			System.out.println("저그는 쉴드가 없습니다.");
			System.out.println("남은 체력은 : " + u.getHp());
		}finally {
			//try, catch 둘 중에 아무거나 실행되도 무조건 동작되는 코드, 오류가 나는 안나든 무조건 실행되는 것
			// 소켓을 열었을 때 닫는 실행문을 넣을 때도 사용
			System.out.println("나는 무조건 실행");
		}
		
	}
	
	public static void main(String[] args) {
//		check(new Zealot());
		check(new Ultra()); //Ultra는 출력 X
	}

}
