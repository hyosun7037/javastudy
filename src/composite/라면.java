package composite;

public class 라면 {

	String item1;
	String item2;
	String item3;

	public 라면(String item1, String item2, String item3) {
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
	}// 사용자가 만든 생성자

	public 라면() {
		this("물", "건더기스프", "분말스프");
	} // 기본 생성자 //안에 매개변수가 있기 때문에 기본생성자를 사용한다.

	
	public 라면(String item1) {
		this(item1, "건더기스프", "분말스프");
	} 
	
	public 라면(String item1, String item3) {
		this(item1, null, item3);
	} 
	
	// 기본 생성자 //안에 매개변수가 있기 때문에 기본생성자를 사용한다.
	
	public static void main(String[] args) {
		라면 i1 = new 라면("물", "건더기스프", "분말스프");
		라면 i2 = new 라면(); // 매개변수의 갯수가 달라졌기 때문에 오버로딩
		라면 i3 = new 라면("쌀뜬물", "건더기스프", "분말스프");
		라면 i4 = new 라면("쌀뜬물", "건더기스프", "분말스프");
		라면 i5 = new 라면("쌀뜬물", "건더기스프", "분말스프");
		라면 i6 = new 라면();
		라면 i7 = new 라면("쌀뜬물", "건더기스프", "분말스프");
		라면 i8 = new 라면("쌀뜬물");
		라면 i9 = new 라면("쌀뜬물", "분말스프");
	}

}
