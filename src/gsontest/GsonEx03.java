package gsontest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

class People {

private String name;
private Integer age;

public People(String string, int i) {
	// TODO Auto-generated constructor stub
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public Integer getAge() {
return age;
}

public void setAge(Integer age) {
this.age = age;
}

//public Map<String, Object> getAdditionalProperties() {
//return this.additionalProperties;
//}
//
//public void setAdditionalProperty(String name, Object value) {
//this.additionalProperties.put(name, value);
//}

}
public class GsonEx03 {

	public static void main(String[] args) {
		// 1. �ٿ� ���� json ������
		String jsonData = "{\"name\":\"�ڽ�\",\"age\":40}"; // Ű��:value��
		System.out.println(jsonData);

		// 2. json ������ -> java ������Ʈ ��ȯ
		Gson gson = new Gson();
		People people = gson.fromJson(jsonData, People.class);
		System.out.println(people.getName());
		System.out.println(people.getAge());

	}

}




