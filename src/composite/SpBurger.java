package composite;

public class SpBurger extends Burger{
	public SpBurger() {
		super(5000,"����������");
	}
	public SpBurger(int price, String desc) {
		super(price, desc);
	}
	public static void main(String[] args) {
		new BigBurger();
	}
}
