package Coffeeshop;

import java.util.ArrayList;

import lombok.Data;
@Data
//å�� : �޴����� (�մԿ��� å��X, ��ü���⿡���� ��� ��ü�� ������� ������ �ִٰ� ����)
public class Menu {
	
	//�޴� �����۵��� ������ �־����. Composition
	//�����迭
	//�޴� �����۵�(�÷���), �迭��� ���
	private ArrayList<MenuItem> menuItems; //������ �޴��� �������

	public Menu(ArrayList<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	//foreach�� �迭�̳� �÷��� ũ�⸸ŭ �ݺ��ؼ� ���� ã��
	// �ϳ��� ���:�迭�̳� �÷���ũ��
	
	public MenuItem �޴�����(String menuName) {
		for (MenuItem menuItem : menuItems) {
			if(menuItem.getName().equals(menuItem)); //�մ��� ��û�� Ŀ�ǰ� �����ϴ��� Ȯ��
			return menuItem;
		}
		return null;
		//�޴��� ������ ��������ߵǱ� ������ String�� �� �� X
	}
}