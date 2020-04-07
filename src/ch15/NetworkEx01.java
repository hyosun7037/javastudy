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
		// 1번 주소 객체 만들기
		try {
			URL url = new URL(
					"http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList?serviceKey=HmOxDOdMlaH7QT6aXxwjlMhM3RXfK6QwvIR9CvlZuNfvJw0H4Hf99cvIa8XSI60F5LbkmnWUqFB4cxt%2BbL0uow%3D%3D&numOfRows=50&pageNo=1&depAirportId=NAARKJJ&arrAirportId=NAARKPC&depPlandTime=20200407&_type=json");
			// 2번 스트림 연결
			// con은 http://www.naver.com에 연결된 스트림 선
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			// 3번 버퍼 연결(문자열)
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

			// bite쓰고 싶으면 FileOutputStream
			// tip: 파일에 스트림 연결
			FileWriter fr = new FileWriter("c:\\utils\\test.html");

			// 4번 문자 더하기
			// 문자열 더 할때 StringBuilder
			StringBuilder sb = new StringBuilder();
			String input = "";
			while ((input = br.readLine()) != null) {
				sb.append(input);
				System.out.println(input);
			}

		} catch (Exception e) {
			e.printStackTrace(); // 오류를 추적해서 빨간 줄로 보여주는 것
		}
	}

}
