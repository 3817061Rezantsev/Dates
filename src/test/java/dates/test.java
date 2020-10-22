package dates;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.time.*;

import org.junit.jupiter.api.Test;

class test {

	@Test
	void isLeapYearTest() {
		Dates date = new Dates();
		assertTrue(date.isLeapYear(2000));
		assertTrue(date.isLeapYear(2020));
		assertTrue(date.isLeapYear(1992));
		assertTrue(date.isLeapYear(2016));
		assertFalse(date.isLeapYear(1700));
		assertFalse(date.isLeapYear(1900));
		assertFalse(date.isLeapYear(2100));
	}

	@Test
	void isValidDateTest() {
		Dates date = new Dates();
		assertTrue(date.isValidDate(2000, 2, 29));
		assertTrue(date.isValidDate(2020, 3, 30));
		assertTrue(date.isValidDate(1992, 2, 28));
		assertTrue(date.isValidDate(2015, 2, 28));
		assertFalse(date.isValidDate(1700, 2, 29));
		assertFalse(date.isValidDate(1900, 13, 3));
		assertFalse(date.isValidDate(2100, -4, 6));
		assertFalse(date.isValidDate(1700, 3, 45));
		assertFalse(date.isValidDate(300, 3, 45));
		assertFalse(date.isValidDate(1900, 3, -3));
		assertFalse(date.isValidDate(-2100, -4, -6));
	}
	
	@Test
	void getDayOfWeekTest() {
		Dates date = new Dates();
		assertEquals(date.getDayOfWeek(2000, 2, 21), 0);
		assertEquals(date.getDayOfWeek(2020, 10, 21), 2);
		assertEquals(date.getDayOfWeek(1992, 10, 21), 2);
		assertEquals(date.getDayOfWeek(1992, 2, 28), 4);
		assertEquals(date.getDayOfWeek(2015, 2, 28), 5);
	}
	
	@Test
	void toStringTest() {
		Dates date = new Dates();
		assertEquals(date.toString(2020, 10, 21), "Wednesday 21 October 2020");
	}
	
	@Test
	void countDaysTest() {
		Dates date = new Dates();
		long check = Duration.between(LocalDateTime.of(2020, 1, 1, 0, 0), LocalDateTime.of(2020, 12, 31, 0, 0)).toDays();
		int correct = date.daysFromBeginOfYear(12) + 31;
		assertEquals(check, correct);
		long days = Duration.between(LocalDateTime.of(2020, 10, 21, 0, 0), LocalDateTime.now()).toDays();
		assertEquals(days, date.countDays(2020, 10, 21));
		days = Duration.between(LocalDateTime.of(2020, 10, 20, 0, 0), LocalDateTime.now()).toDays();
		assertEquals(days, date.countDays(2020, 10, 20));
		days = Duration.between(LocalDateTime.of(2020, 9, 30, 0, 0), LocalDateTime.now()).toDays();
		assertEquals(days, date.countDays(2020, 9, 30));
		days = Duration.between(LocalDateTime.of(2014, 10, 21, 0, 0), LocalDateTime.now()).toDays();
		assertEquals(days, date.countDays(2014, 10, 21));
		days = Duration.between(LocalDateTime.of(2014, 10, 12, 0, 0), LocalDateTime.now()).toDays();
		assertEquals(days, date.countDays(2014, 10, 12));
		days = Duration.between(LocalDateTime.of(2015, 10, 21, 0, 0), LocalDateTime.now()).toDays();
		assertEquals(days, date.countDays(2015, 10, 21));
		days = Duration.between(LocalDateTime.of(2016, 10, 21, 0, 0), LocalDateTime.now()).toDays();
		assertEquals(days, date.countDays(2016, 10, 21));
		days = Duration.between(LocalDateTime.of(2017, 10, 21, 0, 0), LocalDateTime.now()).toDays();
		assertEquals(days, date.countDays(2017, 10, 21));
		days = Duration.between(LocalDateTime.of(2018, 10, 21, 0, 0), LocalDateTime.now()).toDays();
		assertEquals(days, date.countDays(2018, 10, 21));
		days = Duration.between(LocalDateTime.of(2019, 10, 21, 0, 0), LocalDateTime.now()).toDays();
		assertEquals(days, date.countDays(2019, 10, 21));
	}

}
