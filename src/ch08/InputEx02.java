package ch08;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

// ���ڷ� �а� ����
// �� �� �̻��� �ް� ����
public class InputEx02 {

	public static void main(String[] args) {
		InputStream in = System.in;
		InputStreamReader reader = new InputStreamReader(in);// ĳ���� ���� �ʾƵ� ���ڷ� ���� �� �ִ�.
		char[] data = new char[3]; // �迭�� ���۷��� �ڷ��� = heap
		try {
			reader.read(data);
			System.out.println(data);
		} catch (IOException e) {
		
		}
	}

}
