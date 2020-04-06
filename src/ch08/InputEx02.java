package ch08;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

// 문자로 읽고 싶음
// 한 개 이상을 받고 싶음
public class InputEx02 {

	public static void main(String[] args) {
		InputStream in = System.in;
		InputStreamReader reader = new InputStreamReader(in);// 캐스팅 하지 않아도 문자로 받을 수 있다.
		char[] data = new char[3]; // 배열은 레퍼런스 자료형 = heap
		try {
			reader.read(data);
			System.out.println(data);
		} catch (IOException e) {
		
		}
	}

}
