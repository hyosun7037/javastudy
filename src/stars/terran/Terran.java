package stars.terran;

abstract public class Terran {
	public void move() {
		System.out.println("�̵�");
	} // �̵��� ��� ����

	public void repair() {
		System.out.println("SVC ġ��");
	}

//	public abstract void attack(); //���� �ٸ��� ������ �ڽĿ�Ұ� ����

	// new �ϱ����� ����
	public static void upgrade() {
		Marine.attack++;
		Tank.attack++;

	}
}
