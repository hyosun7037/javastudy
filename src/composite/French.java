package composite;

import lombok.Data;

@Data
public class French{
	private int price;
	private String desc;
	
	// ����: 2000, ����: ����Ĩ
	public French() {
		this(2000,"����Ƣ��");
	}

	public French(int price, String desc) {
		this.price = price;
		this.desc = desc;
		System.out.println(desc +"�� ����������ϴ�.");
	}
	public static void main(String[] args) {
		new French();
	}
}
