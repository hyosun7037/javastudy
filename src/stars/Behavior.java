package stars;

import stars.protoss.Dragoon;
import stars.protoss.Zealot;

// 추상클래스와 유사
// 추상메소드만 존재가능
public interface Behavior {
	public abstract void move();

	/* public */ void repair();

	/* public  abstract*/ void attack(Behavior u);

}

//협의해서 만들면 프로토콜
//만든대로 쓰는것, 내부 몰라도 사용가능 인터페이스