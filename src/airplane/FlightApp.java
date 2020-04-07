package airplane;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class FlightApp {

	public static FlightInfo getFlightInfo(String depAirportId, String arrAirportId, Integer depPlandTime) {
		try {
			// 1�� �ּ� ��ü �����
			URL url = new URL("http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList?serviceKey=TYJuOuhQd%2BPQB9hRLr96SDnMNeegd0U3g9mOpBpumr6DwZ6sgto5MjcX%2F8rUKaIKC3AHWmO4gTEHK39cCxwLug%3D%3D&numOfRows=50&pageNo=1&depAirportId="+depAirportId+"&arrAirportId="+arrAirportId+"&depPlandTime="+depPlandTime+"&_type=json");
			
			// 2�� ��Ʈ�� ����
			HttpURLConnection con = 
					(HttpURLConnection) url.openConnection();
			
			// 3�� ���� ���� (���ڿ�)
			BufferedReader br = 
					new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
	
			// 4. ���� ���ϱ�
			StringBuilder sb = new StringBuilder();
			
			String input = "";
			while((input = br.readLine()) != null) {
				sb.append(input);
			}

			System.out.println(sb.toString());
			
			br.close(); // ���� �ݱ�
			con.disconnect(); // ��Ʈ�� �ݱ�
			
			Gson gson = new Gson();
			FlightInfo flightInfo = gson.fromJson(sb.toString(), FlightInfo.class);
			//toString() StringŸ������ ��������ִ� ��
			
			return flightInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static void main(String[] args) {
		String depAirportId = "NAARKJJ";
		String arrAirportId = "NAARKPC";
		Integer depPlandTime = 20200407;
		FlightInfo flightInfo = 
				getFlightInfo(depAirportId, arrAirportId,depPlandTime);
		
		for (Item item : flightInfo.getResponse().getBody().getItems().getItem()) {
			System.out.println("�װ��� : "+item.getAirlineNm());
			System.out.println("����� : "+item.getDepAirportNm());
			System.out.println("������ : "+item.getArrAirportNm());
			System.out.println("��߽ð� : "+item.getDepPlandTime());
			System.out.println("�����ð� : "+item.getArrPlandTime());
			System.out.println("��� : "+item.getEconomyCharge());
			System.out.println();
		}

	}

}
