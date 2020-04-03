package composite;

public class Spset {
	private SpBurger spBurger;
	private Coke coke;
	private French french;

	public Spset() {
		this(new SpBurger(), new Coke(), new French());
	}
	

	public Spset(SpBurger spBurger, Coke coke, French french) {
		this.spBurger = spBurger;
		this.coke = coke;
		this.french = french;
	}

}
