
package finalprojectB;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
       //You can use this function to implement your manual testing

       System.out.println("MTest1: should be valid");
       UrlValidator urlValidator = new UrlValidator();
       if (urlValidator.isValid("ftp://foo.bar.com/")) {
         System.out.println("url is valid");
       } else {
         System.out.println("url is invalid");
       }

      System.out.println("MTest2: should be invalid");
      String[] schemes = {"http","https"};
      UrlValidator urlValidator2 = new UrlValidator(schemes);
      if (urlValidator2.isValid("ftp://foo.bar.com/")) {
         System.out.println("url is valid");
      } else {
         System.out.println("url is invalid");
      }

       System.out.println("MTest3: should be valid");
       UrlValidator urlValidator3 = new UrlValidator();
       if (urlValidator3.isValid("ftp://billgates:moremoney@files.microsoft.com/special/secretplans")) {
           System.out.println("url is valid");
       } else {
           System.out.println("url is invalid");
       }

       System.out.println("MTest4: should be invalid");
       UrlValidator urlValidator4 = new UrlValidator(schemes);
       if (urlValidator4.isValid("ftp://billgates:moremoney@files.microsoft.com/special/secretplans")) {
           System.out.println("url is valid");
       } else {
           System.out.println("url is invalid");
       }

       System.out.println("MTest5: should be valid");
       UrlValidator urlValidator5 = new UrlValidator(schemes);
       if (urlValidator5.isValid("https://google.com")) {
           System.out.println("url is valid");
       } else {
           System.out.println("url is invalid");
       }

       System.out.println("MTest6: should be valid");
       UrlValidator urlValidator6 = new UrlValidator(schemes);
       if (urlValidator6.isValid("https://drive.google.com/")) {
           System.out.println("url is valid");
       } else {
           System.out.println("url is invalid");
       }

   }
   
   
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing	   

   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	   

   }
   //You need to create more test cases for your Partitions if you need to 
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing

   }
   


}
