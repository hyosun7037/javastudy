package ch16;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// ��, Beans
// ���赵�� �ִٰ� ����, 3d�� �ø��� ���� �𵨸� / ���� --> ����
// �ߺ����� ���� ������ : Ʃ�� 
// �����ͺ��̽��� ���ڵ带 �ڹ��� ������Ʈ�� �ٲٴ� ���� �𵨸��̶�� �Ѵ�.

@Data //getter, setter ����
@NoArgsConstructor //�������
@AllArgsConstructor //������ ä�� ������
public class Users {
	private int id;
	private String name;
	private String email;
	private String password;
}

