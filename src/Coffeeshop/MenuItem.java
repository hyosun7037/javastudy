package Coffeeshop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//å�� X, ��������⸸ �ϸ� ��, �����͸� �ʿ� --> Ŭ���� �ڷ��� : Beans 

@Data //getter, setter�������
@NoArgsConstructor //�Ű������� ���� ������
@AllArgsConstructor //���Ű������� �ִ� ������

public class MenuItem {
	private String name;
	private int price;
}
