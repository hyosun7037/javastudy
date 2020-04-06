package gsontest;

import com.google.gson.Gson;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class Family2{
	String 아버지;
	String 어머니;
}
public class GsonToJson {

	public static void main(String[] args) {
		Gson gson = new Gson();
		
		Family2 family = new Family2("김","효");
		String a = gson.toJson(family);
		System.out.println(a);
	}

}
