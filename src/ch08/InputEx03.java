package ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputEx03 {

	public static void main(String[] args) {
		InputStream in = System.in;
		InputStreamReader reader = new InputStreamReader(in);

		BufferedReader br = new BufferedReader(reader);

		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		String data = "";

		try {
			while ((data = br2.readLine()) != null) {
//				data = br2.readLine(); // 프로그램 대기상태
				System.out.println(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
