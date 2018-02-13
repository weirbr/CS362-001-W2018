package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
	     int startHour = 9;
	     int startMinute = 00;
	     int startDay = 3;
	     int startMonth = 5;
	     int startYear = 2018;
	     String title = "weekly-recurring event";
	     String description = "repeats each week";
	     int [] recurDays = new int[] {1};
	     int recurBy = 1;    
	     int recurIncrement = 1;
	     int recurNumber = 10;

	     Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
	     appt.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
	     TimeTable table = new TimeTable();

	     GregorianCalendar origDay = new GregorianCalendar(2018, 5, 3);
	     GregorianCalendar nextDay = new GregorianCalendar(2018, 6, 3);

	     LinkedList<Appt> compareTable = new LinkedList<Appt>();
	     compareTable.add(appt);

	     //testing it can get the correct amount of days in between
	     assertNotNull(table);
	     assertEquals(30, table.getApptRange(compareTable, origDay, nextDay).size());



	     //SHOULD REALLY BE A NEW TEST CASE BUT I DIDN'T WANT TO TYPE THE SAME THING
	     title = "yearly-recurring event";
	     description = "repeats each year";
	     recurDays = new int[] {3};
	     recurBy = 3;    
	     recurIncrement = 3;
	     recurNumber = 3;

	     Appt appt2 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
	     appt.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
	     //TimeTable table = new TimeTable();

	     //GregorianCalendar origDay = new GregorianCalendar(2018, 5, 3);
	     nextDay = new GregorianCalendar(2019, 6, 3);

	     //LinkedList<Appt> compareTable = new LinkedList<Appt>();
	     compareTable.add(appt2);

	     //testing it can get the correct amount of days in between
	     assertNotNull(table);
	     assertEquals(395, table.getApptRange(compareTable, origDay, nextDay).size());


	     //ANOTHER SECTION OF CODE THAT SHOULD TECHNICALLY BE A NEW TEST CASE
	     title = "infinitely-recurring event";
	     description = "repeats each infinitely";
	     recurDays = new int[] {1000};
	     recurBy = 1000;    
	     recurIncrement = 1000;
	     recurNumber = 1000;

	     Appt appt3 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
	     appt.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
	     //TimeTable table = new TimeTable();

	     //GregorianCalendar origDay = new GregorianCalendar(2018, 5, 3);
	     nextDay = new GregorianCalendar(2018, 8, 3);

	     //LinkedList<Appt> compareTable = new LinkedList<Appt>();
	     compareTable.add(appt3);

	     //testing it can get the correct amount of days in between
	     assertNotNull(table);
	     assertEquals(92, table.getApptRange(compareTable, origDay, nextDay).size());


	     //ANOTHER SECTION OF CODE THAT SHOULD TECHNICALLY BE A NEW TEST CASE
	     title = "never-recurring event";
	     description = "repeats NEVER";
	     recurDays = new int[] {0};
	     recurBy = 0;    
	     recurIncrement = 0;
	     recurNumber = 0;

	     Appt appt4 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
	     appt.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
	     //TimeTable table = new TimeTable();

	     //GregorianCalendar origDay = new GregorianCalendar(2018, 5, 3);
	     nextDay = new GregorianCalendar(2018, 8, 3);

	     //LinkedList<Appt> compareTable = new LinkedList<Appt>();
	     compareTable.add(appt4);

	     //testing it can get the correct amount of days in between
	     assertNotNull(table);
	     assertEquals(92, table.getApptRange(compareTable, origDay, nextDay).size());
	 }
	 @Test
	  public void test02()  throws Throwable  {
	     int startHour = 9;
	     int startMinute = 00;
	     int startDay = 3;
	     int startMonth = 5;
	     int startYear = 2018;
	     String title = "monthly-recurring event";
	     String description = "repeats each month";
	     int [] recurDays = new int[] {2};
	     int recurBy = 2;    //recurs monthly so 61 days expected between the appts
	     int recurIncrement = 1;
	     int recurNumber = 5;

	     Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
	     appt.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
	     TimeTable table = new TimeTable();
	     //table.add(appt);

	     GregorianCalendar origDay = new GregorianCalendar(2018, 5, 3);
	     GregorianCalendar nextDay = new GregorianCalendar(2018, 7, 3);

	     LinkedList<Appt> compareTable = new LinkedList<Appt>();
	     compareTable.add(appt);

	     //testing it can get the correct amount of days in between
	     assertNotNull(table);
	     assertEquals(61, table.getApptRange(compareTable, origDay, nextDay).size());

             
	     

	     int startHour2 = 9;
	     int startMinute2 = 00;
	     int startDay2 = 4;
	     int startMonth2 = 6;
	     int startYear2 = 2018;
	     String title2 = "monthly-recurring event2";
	     String description2 = "repeats each month as well";
	     int [] recurDays2 = new int[] {2};
	     int recurBy2 = 2;    //recurs monthly so 61 days expected between the appts
	     int recurIncrement2 = 1;
	     int recurNumber2 = 5;

	     Appt appt2 = new Appt(startHour2, startMinute2, startDay2, startMonth2, startYear2, title2, description2);
	     appt2.setRecurrence(recurDays2, recurBy2, recurIncrement2, recurNumber2);

	     //compareTable.add(appt2);

	     LinkedList<Appt> newList = new LinkedList<Appt>();
	     newList = null;

	     //assertEquals(newList, table.deleteAppt(compareTable, appt2));
             assertEquals(newList, table.deleteAppt(compareTable, appt));



	 }
//add more unit tests as you needed
	@Test
	public void test03() throws Throwable{

	}

}
