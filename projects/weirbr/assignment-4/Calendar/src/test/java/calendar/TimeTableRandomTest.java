package calendar;

import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Random;
import java.util.LinkedList;
import java.sql.Time;

import org.junit.Test;
import static org.junit.Assert.*;
import org.omg.CORBA.TIMEOUT;

/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
      public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"deleteAppt","getApptRange"};// The list of the of methods to be tested in the CalDay class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

        return methodArray[n] ; // return the method name
      }
    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
			long startTime = Calendar.getInstance().getTimeInMillis();
 		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 long randomseed = System.currentTimeMillis();
		 Random random = new Random(randomseed);


 		 System.out.println("Start testing...");

 		try{
 			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
 				//long randomseed =System.currentTimeMillis(); //10
 	//			System.out.println(" Seed:"+randomseed );
 				//Random random = new Random(randomseed);

				int Year = ValuesGenerator.RandInt(random);
			 	int Month = ValuesGenerator.getRandomIntBetween(random, 1, 11);
			 	int Day = ValuesGenerator.RandInt(random);

			 GregorianCalendar gregDay = new GregorianCalendar(Year, Month, Day);
			 CalDay testDay = new CalDay(gregDay);

			 int startHour=ValuesGenerator.RandInt(random);
			 int startMinute=ValuesGenerator.RandInt(random);
			 int startDay=ValuesGenerator.RandInt(random);;
			 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
			 int startYear=ValuesGenerator.RandInt(random);
			 String title="Birthday Party";
			 String description="This is my birthday party.";

			 Appt appt = new Appt(startHour,
							startMinute ,
							startDay ,
							startMonth ,
							startYear ,
							title,
						 description);

			 LinkedList<Appt> appts = new LinkedList<Appt>();
			 appts.add(appt);
			 testDay.addAppt(appt);
			 TimeTable table = new TimeTable();


 			for (int i = 0; i < NUM_TESTS; i++) {
 					String methodName = ApptRandomTest.RandomSelectMethod(random);
 					   if (methodName.equals("deleteAppt")){
							// table.deleteAppt(appts, appt);
							 int Hour=ValuesGenerator.RandInt(random);
							 int Minute=ValuesGenerator.RandInt(random);
							 Day=ValuesGenerator.RandInt(random);;
							 Month=ValuesGenerator.getRandomIntBetween(random, 1, 11);
							 Year=ValuesGenerator.RandInt(random);
							 title="somehting else";
							 description="This is not my birthday party.";

							 Appt appt2 = new Appt(Hour,
						          Minute ,
						          Day ,
							   			Month ,
						          Year ,
						          title,
						         description);

						   testDay.addAppt(appt2);
							 appts.add(appt2);
							 table.deleteAppt(appts, appt2);
							 appts = null;
							 table.deleteAppt(appts, appt);
							 LinkedList<Appt> emptyList = new LinkedList<Appt>();
							 emptyList = null;
							 Appt emptyAppt = new Appt(0,0,0,0,0,"nothing","nothing");
							 emptyAppt = null;

							 table.deleteAppt(emptyList, emptyAppt);

 					   }
 					   else if (methodName.equals("getApptRange")){
							 int Year1 = ValuesGenerator.RandInt(random);
							 int Month1 = ValuesGenerator.getRandomIntBetween(random, 0, 12);
							 int Day1 = ValuesGenerator.RandInt(random);
							 int Year2 = ValuesGenerator.RandInt(random);
			 			   int Month2 = ValuesGenerator.getRandomIntBetween(random, 0, 12);
			 			   int Day2 = ValuesGenerator.RandInt(random);

							 GregorianCalendar firstDay = new GregorianCalendar(Year1, Month1, Day1);
							 GregorianCalendar lastDay = new GregorianCalendar(Year2, Month2, Day2);

							 int Hour=ValuesGenerator.RandInt(random);
							 int Minute=ValuesGenerator.RandInt(random);
							 Day=ValuesGenerator.RandInt(random);;
							 Month=ValuesGenerator.getRandomIntBetween(random, 1, 11);
							 Year=ValuesGenerator.RandInt(random);
							 title="somehting else";
							 description="This is not my birthday party.";

							 Appt appt2 = new Appt(Hour,
							 			 Minute ,
							 			 Day ,
							 			 Month ,
							 			 Year ,
							 			 title,
							 			description);

							 testDay.addAppt(appt2);
							 appts.add(appt2);

							 table.getApptRange(appts, firstDay, lastDay);

 					   }
 				}

				/*TimeTable table = new TimeTable();
				int index = ValuesGenerator.RandInt(random);
				table.deleteAppt(appts, appts.get(index));
*/
 				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
 			        if((iteration%10000)==0 && iteration!=0 )
 			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
 			}
 		}catch(NullPointerException e){}
 		 System.out.println("table testing Done testing...");
	 }
}
