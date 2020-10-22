package dates;

import java.util.InputMismatchException;

public class DateUtils {

	private static final int[] MONTH_CODES = new int[] { 0, 1, 4, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6 };
	private static final int[] DAY_OF_WEEK = new int[] { 5, 6, 0, 1, 2, 3, 4 };
	private static final String[] DAY_NAME = new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
			"Saturday", "Sunday" };
	private static final String[] MONTH_NAME = new String[] { "", "January", "February", "March", "April",
			"May", "June", "July", "August", "September", "October", "November", "December"};

	public static boolean isLeapYear(int year) {
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					return true;
				}
				return false;
			}
			return true;
		}
		return false;
	}

	public static boolean isValidDate(int year, int month, int day) {
		if (month > 0 && month <= 12 && year >= 0) {
			if (month == 4 || month == 6 || month == 9 || month == 11) {
				if (day > 0 && day <= 30)
					return true;
			}
			if (month == 2 && isLeapYear(year)) {
				if (day > 0 && day <= 29)
					return true;
			}
			if (month == 2 && !isLeapYear(year)) {
				if (day > 0 && day <= 28)
					return true;
			} else if (day > 0 && day <= 31)
				return true;
		}
		return false;
	}

	public static int getDayOfWeek(int year, int month, int day) {
		if (!isValidDate(year, month, day)) {
			throw new InputMismatchException();
		}
		int displacement = year / 100;
		do {
			displacement++;
		} while (displacement % 4 != 0);
		displacement = (displacement - 1 - year / 100) * 2;
		int yearCode = (year % 100 + (year % 100) / 4 + displacement) % 7;
		int monthCode = MONTH_CODES[month];
		int dayOfWeek = (day + monthCode + yearCode) % 7;
		if (isLeapYear(year) && day <= 29 && month <= 2) {
			dayOfWeek--;
			if (dayOfWeek == -1) {
				dayOfWeek = 6;
			}
		}
		return DAY_OF_WEEK[dayOfWeek];
	}

	public static String toString(int year, int month, int day) {
		int dayOfWeek = getDayOfWeek(year, month, day);
		String str = DAY_NAME[dayOfWeek];
		String strMonth = MONTH_NAME[month];
		return str + " " + day + " " + strMonth + " " + year;
	}

	public static int countDays(int year, int month, int day) {
		if (!isValidDate(year, month, day)) {
			throw new InputMismatchException();
		}
		long millsInDay = 24 * 60 * 60 * 1000;
		long current = System.currentTimeMillis();
		long leap = (year - 1970) / 4;
		if (year % 4 == 3 || year % 4 == 2) {
			leap--;
		}
		long days = ((year - 1970) * 365 + daysFromBeginOfYear(month) + leap + day) * millsInDay;
		long diff = current - days;
		long count = diff / millsInDay;
		return (int) count;
	}

	public static int daysInMonth(int month) {
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			return 30;
		}
		if (month == 2) {
			return 28;
		}
		return 31;
	}

	public static int daysFromBeginOfYear(int month) {
		int summ = 0;
		for (int i = 1; i < month; i++) {
			summ += daysInMonth(i);
		}
		return summ;
	}

	public static boolean isLeapYear(MyDate date) {
		return isLeapYear(date.getYear());
	}

	public static boolean isValidDate(MyDate date) {
		return isValidDate(date.getYear(), date.getMonth(), date.getDay());
	}

	public static int getDayOfWeek(MyDate date) {
		return getDayOfWeek(date.getYear(), date.getMonth(), date.getDay());
	}

	public static String toString(MyDate date) {
		return toString(date.getYear(), date.getMonth(), date.getDay());
	}

	public static int countDays(MyDate date) {
		return countDays(date.getYear(), date.getMonth(), date.getDay());
	}

	public static int daysInMonth(MyDate date) {
		return daysInMonth(date.getMonth());
	}

	public static int daysFromBeginOfYear(MyDate date) {
		return daysFromBeginOfYear(date.getMonth());
	}
}
