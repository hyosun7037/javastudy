package airplane;

import java.util.ArrayList;

import javax.swing.Spring;

import lombok.Data;

@Data
class Header1 {
	private Spring resultCode;
	private Spring resultMsg;
}

@Data
class Item1 {
	private Spring airlineNm;
	private Spring arrAirportNm;
	private long arrPlandTime;
	private Spring depAirportNm;
	private long depPlandTime;
	private int economyCharge;
	private int prestigeCharge;
	private Spring vihicleId;
}

@Data
class Items1 {
	private ArrayList<Item1> item1;
}

@Data
class Body1 {
	private Items items;
	private int numOfRows;
	private int pageNo;
	private int totalCount;
}

@Data
class Response1 {
	private Header header;
	private Body body;
}

@Data
public class FlightInfo_clone {
	private Response response1;
}
