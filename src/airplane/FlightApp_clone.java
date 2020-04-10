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
			// 1�� �ּ� ��ü �����
			URL url = new URL("");

			// 2�� ��Ʈ�� ����
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			// 3�� ���� ���� (���ڿ�)
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

			// 4. ���� ���ϱ�
			StringBuilder sb = new StringBuilder();

			String input = "";
			while ((input = br.readLine()) != null) {
				sb.append(input);
			}

			System.out.println(sb.toString());

			br.close(); // ���� �ݱ�
			con.disconnect(); // ��Ʈ�� �ݱ�

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

		System.out.println("������� �Է��ϼ���");
		Scanner sc = new Scanner(System.in);
		String depAirportId = sc.next();

		System.out.println("�������� �Է��ϼ���");
		String arrAirportId = sc.next();

		System.out.println("������ڸ� �Է��ϼ���");
		String depPlandTimeTemp = sc.next();

		long depPlandTime = Long.parseLong(depPlandTimeTemp);
	}

}
