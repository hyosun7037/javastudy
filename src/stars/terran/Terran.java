package stars.terran;

abstract public class Terran {
	public void move() {
		System.out.println("이동");
	} // 이동은 모두 같은

	public void repair() {
		System.out.println("SVC 치료");
	}

//	public abstract void attack(); //각각 다르기 때문에 자식요소가 구현

	// new 하기전에 가능
	public static void upgrade() {
		Marine.attack++;
		Tank.attack++;

	}
}
