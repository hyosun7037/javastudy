package airplane;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;

public class FlightApp {

	public static int getTotalCount(String depAirportId, String arrAirportId, long depPlandTime) {
		try {
			// 1번 주소 객체 만들기
			URL url = new URL(
					"http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList?serviceKey=TYJuOuhQd%2BPQB9hRLr96SDnMNeegd0U3g9mOpBpumr6DwZ6sgto5MjcX%2F8rUKaIKC3AHWmO4gTEHK39cCxwLug%3D%3D&numOfRows=50&"
							+ "pageNo=1" + "&depAirportId=" + FlightInfoService.airPortId.get(depAirportId)
							+ "&arrAirportId=" + FlightInfoService.airPortId.get(arrAirportId) + "&depPlandTime="
							+ depPlandTime + "&_type=json");

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

	public static FlightInfo getFlightInfo(String depAirportId, String arrAirportId, long depPlandTime, int page) {
		try {
			// 1번 주소 객체 만들기
			URL url = new URL(
					"http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList?serviceKey=TYJuOuhQd%2BPQB9hRLr96SDnMNeegd0U3g9mOpBpumr6DwZ6sgto5MjcX%2F8rUKaIKC3AHWmO4gTEHK39cCxwLug%3D%3D&numOfRows=50&pageNo="
							+ page + "&depAirportId=" + FlightInfoService.airPortId.get(depAirportId) + "&arrAirportId="
							+ FlightInfoService.airPortId.get(arrAirportId) + "&depPlandTime=" + depPlandTime
							+ "&_type=json");

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

			return flightInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {

		// 해시만들기
		FlightInfoService.setAirLineId(); // 항공사이름
		FlightInfoService.setAirPortId(); // 출발지, 도착지
		System.out.println(FlightInfoService.airPortId.keySet());

		for (String key : FlightInfoService.airPortId.keySet()) {
			System.out.print(key + " ");
		}

		System.out.println();
		System.out.println("출발지를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		String depAirportId = sc.next(); // 김포

		System.out.println("도착지를 입력하세요");
		String arrAirportId = sc.next();

		System.out.println("출발일자를 입력하세요");
		String depPlandTimeTemp = sc.next();

		long depPlandTime = Long.parseLong(depPlandTimeTemp); // String을 long으로 바꿈
		Integer depPlandTimeTempInteger = Integer.parseInt(depPlandTimeTemp);

//		double depPlandTimeDouble = Double.parseDouble(depPlandTimeTemp); //1번
//		Double depPlandTimeDouble = Double.parseDouble(depPlandTimeTemp); //2번

		int page = 1;
//		String strTemp = depPlandTime + "";
//		String srtTemp2 = depPlandTimeTempInteger.toString();
//		String strTemp3 = depPlandTimeDouble + ""; //1번 
//		String strTemp3 = depPlandTimeDouble.toString(); //2번

		// String을 숫자로 바꾸는 방법

//		String depAirportId = "NAARKJJ";
//		String arrAirportId = "NAARKPC";
//		Integer depPlandTime = 20200407;

		int totalCount = getTotalCount(depAirportId, arrAirportId, depPlandTime);

		int count = 0;
		if (totalCount % 50 == 0) {
			count = totalCount / 50;
		} else {
			count = totalCount / 50 + 1;
		}

		ArrayList<FlightInfo> flightInfos = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			FlightInfo flightInfo = getFlightInfo(depAirportId, arrAirportId, depPlandTime, page); // 페이지 넘버 추가필요 //for문이 반복될 때 마다 1씩 추가
			page++;
			flightInfos.add(flightInfo);
		}
		
		
		
		for (FlightInfo flightInfo : flightInfos) { //122개니까 3번 반복
			ArrayList<Item> flightItems = flightInfo.getResponse().getBody().getItems().getItem();

			// for each문 : 전체를 반복
			for (Item item : flightItems) { //50번 반복
				System.out.println("항공사 : " + item.getAirlineNm());
				System.out.println("출발지 : " + item.getDepAirportNm());
				System.out.println("도착지 : " + item.getArrAirportNm());
				System.out.println("출발시간 : " + item.getDepPlandTime());
				System.out.println("도착시간 : " + item.getArrPlandTime());
				System.out.println("요금 : " + item.getEconomyCharge());
				System.out.println();
			}
		}

		

	}

}
