package gsontest;

import com.google.gson.Gson;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class Family2{
	String �ƹ���;
	String ��Ӵ�;
}
public class GsonToJson {

	public static void main(String[] args) {
		Gson gson = new Gson();
		
		Family2 family = new Family2("��","ȿ");
		String a = gson.toJson(family);
		System.out.println(a);
	}

}
