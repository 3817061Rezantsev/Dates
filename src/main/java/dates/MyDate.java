package dates;

public class MyDate {
	private int year, month, day;

	public MyDate() {

	}

	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public MyDate(MyDate date) {
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

	public boolean isLeapYear(MyDate date) {
		return DateUtils.isLeapYear(date.getYear());
	}

	public boolean isValidDate(MyDate date) {
		return DateUtils.isValidDate(date.getYear(), date.getMonth(), date.getDay());
	}

	public int getDayOfWeek(MyDate date) {
		return DateUtils.getDayOfWeek(date.getYear(), date.getMonth(), date.getDay());
	}

	public String toString(MyDate date) {
		return DateUtils.toString(date.getYear(), date.getMonth(), date.getDay());
	}

	public int countDays(MyDate date) {
		return DateUtils.countDays(date.getYear(), date.getMonth(), date.getDay());
	}

	public int daysInMonth(MyDate date) {
		return DateUtils.daysInMonth(date.getMonth());
	}

	public int daysFromBeginOfYear(MyDate date) {
		return DateUtils.daysFromBeginOfYear(date.getMonth());
	}

}
