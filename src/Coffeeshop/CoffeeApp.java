package Coffeeshop;

import java.util.ArrayList;

//ȭ����
public class CoffeeApp {

	public static void main(String[] args) {
		//�޴�, �ٸ���Ÿ, �մ�
		Consumer consumer = new Consumer();
		Barista barista = new Barista();
		
		//�����۵��� �����ϱ� ���ؼ��� 
		MenuItem m1 = new MenuItem("�Ƹ޸�ī��", 1500);
		MenuItem m2 = new MenuItem("ī���", 2500);
		MenuItem m3 = new MenuItem("īǪġ��", 4000);
		
		ArrayList<MenuItem> menuItems = new ArrayList<>();
		
		//�߰��Ҷ� add
		menuItems.add(m1);
		menuItems.add(m2);
		menuItems.add(m3);
		
		//���� ������ ������ get
		System.out.println(menuItems.get(0).getName());
		System.out.println(menuItems.get(1).getName());
		System.out.println(menuItems.get(2).getName());
		
		
		//�޴� �����۵��� �÷��ǿ� ���� ��
		Menu menu = new Menu(menuItems);
		
		Consumer.�ֹ�("�Ƹ޸�ī��", menu, barista);
	}

}


// �÷����� Linked list(���Ḯ��Ʈ), ������� �� ������� ���� �ְ� �����ּҸ� ã�´�. ������ �׻� ó������ 
// ������ �ؾ� �����ּҸ� ã�� �� �ִ�. �߰��� �ϳ� ������ �Ǹ� ������ ������ �ٷ� ������
// ����, ������ ���� ������ �ִ�. 
// �׼��� �ӵ��� �����ٴ� ������ �ִ�. --�ַ� ���ü�ο� ���


// ArrayList : ������ ũ�Ⱑ �������̴�. index�� ������ �ֱ� ������ ���� ������ ����, �˻�ȿ���� �پ��.
// ���� : ����, ���Խ� ��ġ�̵��� �Ͼ�� ������ ��ȿ�����̴�.


// ���׸�


// �迭�� ���ӵ� ������ �־�� ��������
