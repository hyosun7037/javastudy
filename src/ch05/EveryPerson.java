package ch05; //���

class ��� {
	int num = 10;
}

class �ƽþ��� extends ��� {
	int num = 30;
}

class �ѱ��� extends �ƽþ��� {

}
//class ���� �θ�Ŭ������ �� �� X, �ٸ� Ʈ������ ��� ����

class �ڼ��� extends �ѱ��� {
	int num = 20; // ������ ã�����ϱ� ���� ��ĵ ����
}

public class EveryPerson {

	public static void main(String[] args) {
		�ڼ��� b1 = new �ڼ���(); // ã�� �������� ���� ��ĵ // �ڼ��ظ� ������Ʈ, ���� ���� ����
		System.out.println(b1.num);

		�ѱ��� b2 = new �ڼ���(); // �ѱ��� �ٶ󺸴� ��, �ڼ��غ��� ã�� // ����������ȯ (��ĳ����)
		System.out.println(b2.num);

		// ���� �ڽĿ�����Ʈ�� �ڼ����� ����ϰ� �ʹٸ�?
		// �ٿ�ĳ�������� �ڽĿ�����Ʈ�� ��� (�������� : �޸𸮿� �� �־����)

		�ڼ��� downB2 = (�ڼ���) b2;
		System.out.println(downB2.num);

		��� b3 = new �ѱ���();
		System.out.println(b3.num);

		// �ڼ��� b4 = new �ѱ���(); ���� --> �ڼ����� �޸𸮿� �ȶ��� ������
	}

}
