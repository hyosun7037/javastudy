package stars.zerg;

abstract public class Zerg {
	public void move() {
		System.out.println("�̵�");
	} // �̵��� ��� ����

	public void repair() {
		System.out.println("SVC ġ��");
	}

//	public abstract void attack(); //���� �ٸ��� ������ �ڽĿ�Ұ� ����

	// new �ϱ����� ����
	public static void upgrade() {
		Hydra.attack++;
		Ultra.attack++;

	}
}
