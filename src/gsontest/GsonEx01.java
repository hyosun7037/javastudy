package gsontest;

import com.google.gson.Gson;

import lombok.AllArgsConstructor;

class Person {
	String �̸�;
	int ����;
	String ����;
	String �ּ�;
	String[] Ư��;
	Family ��������;
	String ȸ��;
}
@AllArgsConstructor
class Family {
	int ��;
	String �ƹ���;
	String ��Ӵ�;
}

public class GsonEx01 {

	public static void main(String[] args) {
//		String jsonPerson = "{\"�̸�\":\"ȫ�浿\",\"����\":25,\"����\":\"��\",\"�ּ�\":\"����Ư���� ��õ�� ��\",\"Ư��\":[\"��\",\"����\"],\"��������\":{\"��\":2,\"�ƹ���\":\"ȫ�Ǽ�\",\"��Ӵ�\":\"�ἶ\"},\"ȸ��\":\"��� ������ �ȴޱ� �츸��\"}\r\n"
//				+ "";
		Gson gson = new Gson();
		
		Family a = new Family(3, "d", "s");
		// Person p = gson.fromJson(jsonPerson, Person.class);
		String aa = gson.toJson(a);
		System.out.println(aa);
		//System.out.println(p.�̸�);
		
	}

}
