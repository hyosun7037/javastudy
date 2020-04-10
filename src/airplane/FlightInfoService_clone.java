package airplane;

import java.util.Scanner;

public class FlightInfoService_clone {

	public static void main(String[] args) {

	System.out.println("출발지를 입력하세요");
	Scanner sc = new Scanner(System.in);
	String depAirportId = sc.next();
	
	System.out.println("도착지를 입력하세요");
	String arrAirportId = sc.next();
	
	System.out.println("출발일자를 입력하세요");
	String depPlandTimeTemp = sc.next();
	}

}
