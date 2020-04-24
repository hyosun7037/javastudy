package dateex;

import java.util.Calendar;

public class CalenderEx {

	// 2020-03-28 18:22:11:05 타입이라면
	public static void printCalendar(String msg, Calendar cal) {

		int year = cal.get(Calendar.YEAR); // 2020
		int month = cal.get(Calendar.MONTH) + 1; // 4
		String mon = (month < 10) ? "0" + month : "" + month;
		
		int hour = cal.get(Calendar.HOUR);
		String h = (hour <10) ? "0" + hour : "" + hour;
		
		int minute = cal.get(Calendar.MINUTE);
		String m = (minute <10) ? "0" + minute : "" + minute;
		
		int second = cal.get(Calendar.SECOND);
		String s = (second <10) ? "0" + second : "" + second;
		
		int millisecond = cal.get(Calendar.MILLISECOND);
		String ms = (millisecond <10) ? "0" + millisecond : "" + millisecond;

		// 데이터 타입을 임의로 맞춰줌 //String으로 밀어넣으면 다 들어감
		

		int day = cal.get(Calendar.DAY_OF_MONTH); // 24
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 6 잘 안씀
		System.out
				.println(year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second + ":" + millisecond);

	}

	public static void main(String[] args) {
		// 싱글톤 패턴
		// JVM에서 띄워놓으니까 new를 안해도 됨
		Calendar now = Calendar.getInstance();
		printCalendar("현재", now); // calendar객체 넘기기
	}

}
