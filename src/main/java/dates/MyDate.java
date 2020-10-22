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

}
