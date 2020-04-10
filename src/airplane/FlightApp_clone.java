package airplane;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.Gson;

public class FlightApp_clone {

	public static int getTotalCount(String depAirportId, String arrAirportId, long depPlandTime) {

		try {
			// 1번 주소 객체 만들기
			URL url = new URL("");

			// 2번 스트림 연결
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			// 3번 버퍼 연결 (문자열)
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

			// 4. 문자 더하기
			StringBuilder sb = new StringBuilder();

			String input = "";
			while ((input = br.readLine()) != null) {
				sb.append(input);
			}

			System.out.println(sb.toString());

			br.close(); // 버퍼 닫기
			con.disconnect(); // 스트림 닫기

			Gson gson = new Gson();
			FlightInfo flightInfo = gson.fromJson(sb.toString(), FlightInfo.class);
			return flightInfo.getResponse().getBody().getTotalCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static void main(String[] args) {

		FlightInfoService.setAirLineId();
		FlightInfoService.setAirPortId();

		System.out.println("출발지를 입력하세요");
		Scanner sc = new Scanner(System.in);
		String depAirportId = sc.next();

		System.out.println("도착지를 입력하세요");
		String arrAirportId = sc.next();

		System.out.println("출발일자를 입력하세요");
		String depPlandTimeTemp = sc.next();

		long depPlandTime = Long.parseLong(depPlandTimeTemp);
	}

}
