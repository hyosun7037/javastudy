package Coffeeshop;

//å�� : �ֹ�
//�޴����̶� �ٸ���Ÿ ���۷����� ������ �־����
//���ν����� ��� ���� -- �������� �޾ƾ���
public class Consumer {

	public static void �ֹ�(String menuName, Menu menu, Barista barista) {
		//�մ� -> �޴��� �޽����� ������.(�޴� ���� ����)
		MenuItem menuItem = menu.�޴�����(menuName);
		
		if(menuItem == null) {
			System.out.println(menuName + "�� �츮 ���忡 �����ϴ�.");
		}else {
			//�մ��� �ٸ���Ÿ���� �޽����� ������. (Ŀ�� ���� ����)
			Coffee coffee = barista.Ŀ������(menuItem);
			System.out.println(coffee.getName());
			System.out.println(coffee.getPrice());
		}
	}
}

//