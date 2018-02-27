package calendar;

import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {

	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
      public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"addAppt","setApps"};// The list of the of methods to be tested in the CalDay class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

        return methodArray[n] ; // return the method name
      }
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
		  long startTime = Calendar.getInstance().getTimeInMillis();
 		  long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


 		 System.out.println("Start testing...");

 		try{
 			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
 				long randomseed =System.currentTimeMillis(); //10
 	//			System.out.println(" Seed:"+randomseed );
 				Random random = new Random(randomseed);

				//making new gregorian cal day bc CalDay is actually a gregorain day
				//GregorianCalendar gregDay;
			        //gregDay	= new GregorianCalendar();
				int Year = ValuesGenerator.RandInt(random);
				int Month = ValuesGenerator.getRandomIntBetween(random, 0, 12);
				int Day = ValuesGenerator.RandInt(random);

				GregorianCalendar gregDay = new GregorianCalendar(Year, Month, Day);
				CalDay testDay = new CalDay(gregDay);

				//if(!appt.getValid())continue;

					for (int i = 0; i < NUM_TESTS; i++) {
						String methodName = CalDayRandomTest.RandomSelectMethod(random);
						if (methodName.equals("addAppt")){
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

						   testDay.addAppt(appt);
						}
						else if(methodName.equals("setApps")){
							LinkedList<Appt> appts = new LinkedList<Appt>();
							int startHour=ValuesGenerator.RandInt(random);
			 			 int startMinute=ValuesGenerator.RandInt(random);
			 			 int startDay=ValuesGenerator.RandInt(random);;
			 			 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
			 			 int startYear=ValuesGenerator.RandInt(random);
			 			 String title="Birthday Party";
			 			 String description="This is my birthday party.";

			 			 Appt appt1 = new Appt(startHour,
			 							startMinute ,
			 							startDay ,
			 							startMonth ,
			 							startYear ,
			 							title,
			 						 description);
						}
						appts.addAppt(appt1);

						startHour=ValuesGenerator.RandInt(random);
		 			 startMinute=ValuesGenerator.RandInt(random);
		 			 startDay=ValuesGenerator.RandInt(random);;
		 			 startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
		 			 startYear=ValuesGenerator.RandInt(random);
		 			 title="Birthday Party";
		 			 description="This is my birthday party.";

		 			 Appt appt2 = new Appt(startHour,
		 							startMinute ,
		 							startDay ,
		 							startMonth ,
		 							startYear ,
		 							title,
		 						 description);

								 appts.addAppt(appt2);
						testDay.setApps(appts);
					}

			elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
 					if((iteration%10000)==0 && iteration!=0 )
 								System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

		}
 }catch(NullPointerException e){}

  System.out.println("Done testing...");
 }

}
