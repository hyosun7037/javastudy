package ch15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkEx01_clone {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList?serviceKey=HmOxDOdMlaH7QT6aXxwjlMhM3RXfK6QwvIR9CvlZuNfvJw0H4Hf99cvIa8XSI60F5LbkmnWUqFB4cxt%2BbL0uow%3D%3D&numOfRows=50&depAirportId=NAARKJJ&arrAirportId=NAARKPC&depPlandTime=20200407");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
			StringBuilder sb = new StringBuilder();
			String input = "";
			while((input = br.readLine())!=null) {
				sb.append(input);
				System.out.println(input);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
