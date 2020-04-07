package ch15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkEx01 {

	public static void main(String[] args) {
		// 1�� �ּ� ��ü �����
		try {
			URL url = new URL(
					"http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList?serviceKey=HmOxDOdMlaH7QT6aXxwjlMhM3RXfK6QwvIR9CvlZuNfvJw0H4Hf99cvIa8XSI60F5LbkmnWUqFB4cxt%2BbL0uow%3D%3D&numOfRows=50&pageNo=1&depAirportId=NAARKJJ&arrAirportId=NAARKPC&depPlandTime=20200407&_type=json");
			// 2�� ��Ʈ�� ����
			// con�� http://www.naver.com�� ����� ��Ʈ�� ��
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			// 3�� ���� ����(���ڿ�)
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

			// bite���� ������ FileOutputStream
			// tip: ���Ͽ� ��Ʈ�� ����
			FileWriter fr = new FileWriter("c:\\utils\\test.html");

			// 4�� ���� ���ϱ�
			// ���ڿ� �� �Ҷ� StringBuilder
			StringBuilder sb = new StringBuilder();
			String input = "";
			while ((input = br.readLine()) != null) {
				sb.append(input);
				System.out.println(input);
			}

		} catch (Exception e) {
			e.printStackTrace(); // ������ �����ؼ� ���� �ٷ� �����ִ� ��
		}
	}

}
