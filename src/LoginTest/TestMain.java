package LoginTest;

public class TestMain {
	public static void main(String[] args) {
		TestDB tb = new TestDB();
		Users user = new Users("bb", "1234", "ȫ�浿", "01065458975");
		try {
			tb.insertData(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
