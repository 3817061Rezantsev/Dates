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
		assertTrue(DateUtils.isLeapYear(2000));
		assertTrue(DateUtils.isLeapYear(2020));
		assertTrue(DateUtils.isLeapYear(1992));
		assertTrue(DateUtils.isLeapYear(2016));
		assertFalse(DateUtils.isLeapYear(1700));
		assertFalse(DateUtils.isLeapYear(1900));
		assertFalse(DateUtils.isLeapYear(2100));
	}

	@Test
	void isValidDateTest() {
		assertTrue(DateUtils.isValidDate(2000, 2, 29));
		assertTrue(DateUtils.isValidDate(2020, 3, 30));
		assertTrue(DateUtils.isValidDate(1992, 2, 28));
		assertTrue(DateUtils.isValidDate(2015, 2, 28));
		assertFalse(DateUtils.isValidDate(1700, 2, 29));
		assertFalse(DateUtils.isValidDate(1900, 13, 3));
		assertFalse(DateUtils.isValidDate(2100, -4, 6));
		assertFalse(DateUtils.isValidDate(1700, 3, 45));
		assertFalse(DateUtils.isValidDate(300, 3, 45));
		assertFalse(DateUtils.isValidDate(1900, 3, -3));
		assertFalse(DateUtils.isValidDate(-2100, -4, -6));
	}

	@Test
	void getDayOfWeekTest() {
		assertEquals(DateUtils.getDayOfWeek(2000, 2, 21), 0);
		assertEquals(DateUtils.getDayOfWeek(2020, 10, 21), 2);
		assertEquals(DateUtils.getDayOfWeek(1992, 10, 21), 2);
		assertEquals(DateUtils.getDayOfWeek(1992, 2, 28), 4);
		assertEquals(DateUtils.getDayOfWeek(2015, 2, 28), 5);
	}

	@Test
	void toStringTest() {
		assertEquals(DateUtils.toString(2020, 10, 21), "Wednesday 21 October 2020");
	}

	@Test
	void  daysFromBeginOfYearTest() {
		long check = Duration.between(LocalDateTime.of(2020, 1, 1, 0, 0), LocalDateTime.of(2020, 12, 31, 0, 0))
				.toDays();
		int correct = DateUtils.daysFromBeginOfYear(12) + 31;
		assertEquals(check, correct);
	}
	
	@Test
	void countDaysTest() {
		long days = Duration.between(LocalDateTime.of(2020, 10, 21, 0, 0), LocalDateTime.now()).toDays();
		assertEquals(days, DateUtils.countDays(2020, 10, 21));
		days = Duration.between(LocalDateTime.of(2020, 10, 20, 0, 0), LocalDateTime.now()).toDays();
		assertEquals(days, DateUtils.countDays(2020, 10, 20));
		days = Duration.between(LocalDateTime.of(2020, 9, 30, 0, 0), LocalDateTime.now()).toDays();
		assertEquals(days, DateUtils.countDays(2020, 9, 30));
		days = Duration.between(LocalDateTime.of(2014, 10, 21, 0, 0), LocalDateTime.now()).toDays();
		assertEquals(days, DateUtils.countDays(2014, 10, 21));
		days = Duration.between(LocalDateTime.of(2014, 10, 12, 0, 0), LocalDateTime.now()).toDays();
		assertEquals(days, DateUtils.countDays(2014, 10, 12));
		days = Duration.between(LocalDateTime.of(2015, 10, 21, 0, 0), LocalDateTime.now()).toDays();
		assertEquals(days, DateUtils.countDays(2015, 10, 21));
		days = Duration.between(LocalDateTime.of(2016, 10, 21, 0, 0), LocalDateTime.now()).toDays();
		assertEquals(days, DateUtils.countDays(2016, 10, 21));
		days = Duration.between(LocalDateTime.of(2017, 10, 21, 0, 0), LocalDateTime.now()).toDays();
		assertEquals(days, DateUtils.countDays(2017, 10, 21));
		days = Duration.between(LocalDateTime.of(2018, 10, 21, 0, 0), LocalDateTime.now()).toDays();
		assertEquals(days, DateUtils.countDays(2018, 10, 21));
		days = Duration.between(LocalDateTime.of(2019, 10, 21, 0, 0), LocalDateTime.now()).toDays();
		assertEquals(days, DateUtils.countDays(2019, 10, 21));
	}

}
