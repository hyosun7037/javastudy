package stars.terran;

public class Marine extends Terran{
	private String name;
	private int hp;
	public static int attack =5;

	public Marine(String name) {
		this.name = name;
		this.hp = 100;
	}
}