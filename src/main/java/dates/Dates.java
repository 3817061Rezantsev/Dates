package dates;

import java.util.InputMismatchException;

public class Dates {
	private int year, month, day;
	
	public Dates() {
		
	}
	
	public Dates(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public Dates(Dates date) {
		this.year = date.getYear();
		this.month = date.getMonth();
		this.day = date.getDay();
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	
	public boolean isLeapYear(int year) {
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
	
	public boolean isLeapYear(Dates date) {
		return isLeapYear(date.getYear());
	}

	public boolean isValidDate(int year, int month, int day) {
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

	public boolean isValidDate(Dates date) {
		return isValidDate(date.getYear(), date.getMonth(), date.getDay());
	}

	
	public int getDayOfWeek(int year, int month, int day) {
		if (!isValidDate(year, month, day)) {
			throw new InputMismatchException();
		}
		int displacement = year / 100;
		do {
			displacement++;
		} while (displacement % 4 != 0);
		displacement = (displacement - 1 - year / 100) * 2;
		int yearCode = (year % 100 + (year % 100) / 4 + displacement) % 7;
		int monthCode = 0;
		switch (month) {
		case 1:
			monthCode = 1;
			break;
		case 2:
			monthCode = 4;
			break;
		case 3:
			monthCode = 4;
			break;
		case 4:
			monthCode = 0;
			break;
		case 5:
			monthCode = 2;
			break;
		case 6:
			monthCode = 5;
			break;
		case 7:
			monthCode = 0;
			break;
		case 8:
			monthCode = 3;
			break;
		case 9:
			monthCode = 6;
			break;
		case 10:
			monthCode = 1;
			break;
		case 11:
			monthCode = 4;
			break;
		case 12:
			monthCode = 6;
			break;

		}
		int dayOfWeek = (day + monthCode + yearCode) % 7;
		if (isLeapYear(year) && day <= 29 && month <= 2) {
			dayOfWeek--;
			if (dayOfWeek == -1) {
				dayOfWeek = 6;
			}
		}
		switch (dayOfWeek) {
		case 0:
			return 5;
		case 1:
			return 6;
		case 2:
			return 0;
		case 3:
			return 1;
		case 4:
			return 2;
		case 5:
			return 3;
		case 6:
			return 4;
		}
		return 0;
	}
	
	public int getDayOfWeek(Dates date) {
		return getDayOfWeek(date.getYear(), date.getMonth(), date.getDay());
	}
	

	public String toString(int year, int month, int day) {
		int dayOfWeek = getDayOfWeek(year, month, day);
		String str = "";
		String strMonth = "";
		switch (dayOfWeek) {
		case 0:
			str = "Monday";
			break;
		case 1:
			str = "Tuesday";
			break;
		case 2:
			str = "Wednesday";
			break;
		case 3:
			str = "Thursday";
			break;
		case 4:
			str = "Friday";
			break;
		case 5:
			str = "Saturday";
			break;
		case 6:
			str = "Sunday";
			break;
		}
		switch (month) {
		case 1:
			strMonth = "January";
			break;
		case 2:
			strMonth = "February";
			break;
		case 3:
			strMonth = "March";
			break;
		case 4:
			strMonth = "April";
			break;
		case 5:
			strMonth = "May";
			break;
		case 6:
			strMonth = "June";
			break;
		case 7:
			strMonth = "July";
			break;
		case 8:
			strMonth = "August";
			break;
		case 9:
			strMonth = "September";
			break;
		case 10:
			strMonth = "October";
			break;
		case 11:
			strMonth = "November";
			break;
		case 12:
			strMonth = "December";
			break;
		}
		return str + " " + day + " " + strMonth + " " + year;
	}

	public String toString(Dates date) {
		return toString(date.getYear(), date.getMonth(), date.getDay());
	}
	
	public int countDays(int year, int month, int day) {
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

	public int countDays(Dates date) {
		return countDays(date.getYear(), date.getMonth(), date.getDay());
	}
	
	public int daysInMonth(int month) {
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			return 30;
		}
		if (month == 2) {
			return 28;
		}
		return 31;
	}

	public int daysInMonth(Dates date) {
		return daysInMonth(date.getMonth());
	}
	
	public int daysFromBeginOfYear(int month) {
		int summ = 0;
		for (int i = 1; i < month; i++) {
			summ += daysInMonth(i);
		}

		return summ;
	}
	
	public int daysFromBeginOfYear(Dates date) {
		return daysFromBeginOfYear(date.getMonth());
	}

}