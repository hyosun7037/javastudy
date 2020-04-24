package dateex;

import java.util.Calendar;

public class CalenderEx {

	// 2020-03-28 18:22:11:05 Ÿ���̶��
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

		// ������ Ÿ���� ���Ƿ� ������ //String���� �о������ �� ��
		

		int day = cal.get(Calendar.DAY_OF_MONTH); // 24
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 6 �� �Ⱦ�
		System.out
				.println(year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second + ":" + millisecond);

	}

	public static void main(String[] args) {
		// �̱��� ����
		// JVM���� ��������ϱ� new�� ���ص� ��
		Calendar now = Calendar.getInstance();
		printCalendar("����", now); // calendar��ü �ѱ��
	}

}
