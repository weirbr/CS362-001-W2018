package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
	     int day = 15;
	     int month = 4;
	     int year = 2018;

	     GregorianCalendar Day = new GregorianCalendar(year, month, day);

	     CalDay newDay = new CalDay(Day);

	     String stringForCompare = "4/15";
	     String stringInput = newDay.toString();
	     String monthWord = stringInput.substring(6, 10);


	     //assertions
	     assertEquals(15, newDay.getDay());
	     assertEquals(4, newDay.getMonth());
	     assertEquals(2018, newDay.getYear());
	     assertEquals(stringForCompare, monthWord);



	 }
	 @Test
	  public void test02()  throws Throwable  {
	     //test inputs
	     int day = 16;
	     int month = 4;
	     int year = 2018;

	     int startHour = 10;
	     int startMinute = 00;
	     int startDay = 16;
	     int startMonth = 4;
	     int startYear = 2018;
	     String title = "event";
	     String description = "a one time event";

	     GregorianCalendar Day = new GregorianCalendar(year, month, day);

	     CalDay newDay = new CalDay(Day);
	     Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
	     newDay.addAppt(appt);

	     //LinkedList<Appt> apptLL = new LinkedList<Appt>();
	     //apptList.add(appt);
	     assertEquals(1, newDay.getSizeAppts());
		 
	     //assertEquals(apptList, newDay.getAppts());
	     assertEquals(16, newDay.getDay());
	     assertEquals(4, newDay.getMonth());
	     assertEquals(2018, newDay.getYear());
	 }
//add more unit tests as you needed	
}
