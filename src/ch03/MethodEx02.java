package ch03;

class Data {
	int num = 10;
	//new �Ҷ� heap�� ���
}

public class MethodEx02 {
	static int ����(int num) {
		num++;
		System.out.println("���� num :" + num);
		return num;
	}

	static void ����(Data d) {
 //Data�� ũ�⸦ �� �� ���� �׷��� �ּҸ� ������
		d.num--;
		System.out.println("���� num : " + d.num);
	} //������ ����� stack ����

	public static void main(String[] args) {
		//Value passing
		int myNum = 100; //main�� stack ����
		myNum = ����(myNum); 
		System.out.println("myNum :" + myNum);
		
		//Reference passing
		Data data = new Data(); 
		//�ּҸ� ������ ���� // new�ؼ� heap�� ������� (static�� �ƴѰ� ���)
		//�ּҰ��� ���� (������ ���)
		
		����(data); // �ּҰ��� �Ѿ 
		System.out.println("data.num : " + data.num);
	}

}
