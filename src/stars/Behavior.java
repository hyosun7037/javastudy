package stars;

import stars.protoss.Dragoon;
import stars.protoss.Zealot;

// �߻�Ŭ������ ����
// �߻�޼ҵ常 ���簡��
public interface Behavior {
	public abstract void move();

	/* public */ void repair();

	/* public  abstract*/ void attack(Behavior u);

}

//�����ؼ� ����� ��������
//������ ���°�, ���� ���� ��밡�� �������̽�