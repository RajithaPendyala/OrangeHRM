package com.TestNG;

import org.testng.annotations.Test;

public class Annotations1 {

	
	// @Test - It represents to a Test Case
	
		// If a class contains more than One Test case then The Test Cases will be executed
		// based on the Alphabetical order of the given Test case Name
		
		// Every Test Case should be set with a Priority
		
		// If a Test case need to be ignored during the Test Run - then the status of the
		// Test case should be set as "enabled=false"  
		
		// The default status of the Test case is "enabled=true" 
		
		@Test(priority=1) // It represents to a Test Case ..Name of Test Case is -gmailApplicationLaunch
		      //any functionality which is under Test should be written within the Test Case only 
		public void gmailApplicationLaunchTest()
		{
			System.out.println(" Gmail Application Launched Successfully ");
		}
		
		@Test(priority=2)
		public void InBoxTest()
		{
			System.out.println(" InBox Functionality Test Successful ");
		}
		
		@Test(enabled=false) // TestNG Ignores this Test at the Time of TestRun - because its status
		                     // is set as its a False Test 
		public void composeMailTest()
		{
			System.out.println(" ComposeMail Functionality Test Successful ");
		}
		
		@Test(priority=4)
		public void sentMail()
		{
			System.out.println(" SentMail Functionality Test Successful ");
		}
		
		
		/*
		public static void main(String[] args) {
			
			Annotations1 an = new Annotations1();
			an.gmailApplicationLaunch();
			
		}*/
}
