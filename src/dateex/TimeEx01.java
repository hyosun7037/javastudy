package dateex;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

//������ java 1.7 ����

//java.sql.Date �ڹ� sql�� ��� �ִ� ��Ű��
//java.sql.Time (x)
//java.sql.Timestamp
//java.util.Calendar (x) �ڹ� util�� ��� �ִ� ��Ű��
//java.util.Date

//�Ź��� java 1.8 �̻�

//java.time.LocalDate
//java.time.LocalDateTime
//java.time.LocalTime


public class TimeEx01 {

	public static void main(String[] args) {
		// 1.Calendar �Ⱦ�
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String today = formater.format(cal.getTime());
		System.out.println("cal.getTime() : " + cal.getTime());
		System.out.println("today : " + today);

		// 2.java.util.Date �Ⱦ�
		Date time2 = new Date();
		System.out.println("time2 : " + time2);
		System.out.println("timew.getTime() " + time2.getTime());
		// System.out.println("time2.getDay() : " + time2.getDay());
		// ���̻� ������� ����� ��ȣ, �̹� ���ߵ��ִ� �� �״�� ���

		// 3. java.sql.Date �Ⱦ�(1970.01.01 �������� �ؼ� ����� milisecond�� ���)
		java.sql.Date time3 = new java.sql.Date(24 * 3600 * 1000);
		System.out.println("time3 : " + time3);

		// 4. java.sql.Timestamp
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date d = new Date();
		String timestamp = sf.format(d.getTime());
		Timestamp ts = Timestamp.valueOf(timestamp);
		System.out.println("ts : " + ts);

		// 5. LocalDateTime(LocalDate to Timestamp) �ֽŹ��� (������ DB�� ��� ���� x)
		Timestamp nowDate = Timestamp.valueOf(LocalDateTime.now());
		System.out.println("nowDate : " + nowDate);

		// 6. LocalDateTime(Timestamp to localdate Time)
		LocalDateTime ldt = nowDate.toLocalDateTime();
		System.out.println("ldt : " + ldt);

		System.out.println("LocalDateTime : " + LocalDateTime.now()); // ��¥ �ð�
		System.out.println("LocalDate : " + LocalDate.now()); // ��¥
		System.out.println("LocalTime : " + LocalTime.now()); // �ð�
	}

}
