package dateex;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

//구버전 java 1.7 이하

//java.sql.Date 자바 sql이 들고 있는 패키지
//java.sql.Time (x)
//java.sql.Timestamp
//java.util.Calendar (x) 자바 util이 들고 있는 패키지
//java.util.Date

//신버전 java 1.8 이상

//java.time.LocalDate
//java.time.LocalDateTime
//java.time.LocalTime


public class TimeEx01 {

	public static void main(String[] args) {
		// 1.Calendar 안씀
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String today = formater.format(cal.getTime());
		System.out.println("cal.getTime() : " + cal.getTime());
		System.out.println("today : " + today);

		// 2.java.util.Date 안씀
		Date time2 = new Date();
		System.out.println("time2 : " + time2);
		System.out.println("timew.getTime() " + time2.getTime());
		// System.out.println("time2.getDay() : " + time2.getDay());
		// 더이상 사용하지 말라는 신호, 이미 개발되있는 건 그대로 사용

		// 3. java.sql.Date 안씀(1970.01.01 기준으로 해서 경과된 milisecond를 계산)
		java.sql.Date time3 = new java.sql.Date(24 * 3600 * 1000);
		System.out.println("time3 : " + time3);

		// 4. java.sql.Timestamp
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date d = new Date();
		String timestamp = sf.format(d.getTime());
		Timestamp ts = Timestamp.valueOf(timestamp);
		System.out.println("ts : " + ts);

		// 5. LocalDateTime(LocalDate to Timestamp) 최신버전 (하지만 DB가 들고 있지 x)
		Timestamp nowDate = Timestamp.valueOf(LocalDateTime.now());
		System.out.println("nowDate : " + nowDate);

		// 6. LocalDateTime(Timestamp to localdate Time)
		LocalDateTime ldt = nowDate.toLocalDateTime();
		System.out.println("ldt : " + ldt);

		System.out.println("LocalDateTime : " + LocalDateTime.now()); // 날짜 시간
		System.out.println("LocalDate : " + LocalDate.now()); // 날짜
		System.out.println("LocalTime : " + LocalTime.now()); // 시간
	}

}
