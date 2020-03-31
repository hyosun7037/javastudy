package stars.terran;

public class Tank extends Terran{
	private String name;
	private int hp;
	public static int attack = 40;
	
	// 持失切 持失
		public Tank(String name) {
			this.name = name;
			this.hp = 100;
		}

}