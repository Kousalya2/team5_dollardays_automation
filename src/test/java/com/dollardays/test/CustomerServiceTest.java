package com.dollardays.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class CustomerServiceTest {

	@BeforeSuite

	//A test suite is a collection of test cases intended to test a behavior or a set of behaviors of software program.
	//In TestNG, we cannot define a suite in testing source code, but it is represented by one XML file, as suite is the feature of execution.
	//@BeforeSuite is used when we have different URLs to run your test cases

	public void beforeSuite() {

		System.out.println("This will execute before the Test Suite");

	}

	@BeforeTest
	
	// A method with @beforeTest annotation will run, before any test method
	// belonging to the classes inside the test tag is run.
	// We will know more about the test tag as the example progresses.

	public void beforeTest() {

		System.out.println("This will execute before the Test");


	}

	@BeforeClass
	
	//The @BeforeClass annotated method runs before the execution of test methods in a current class.

	public void beforeClass() {

		System.out.println("This will execute before the Class");
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		
		//System.setProperty is located in your system class. setProperty is static string method where you can store your values based on key-value pair.
		//This has to be the first line of code needs to be executed in your selenium script before any test method to initialise the driver.

	}

	@BeforeMethod
	
	//The @BeforeMethod annotated method will be invoked before the execution of each test method where the test method is nothing but a test case
	//Suppose there are four test methods in a class then the @BeforeMethod annotated method is executed before the execution of each test method
	//Invoked before the execution of each test method where the test method is nothing but a test case
	
	public void beforeMethod() {

		System.out.println("This will execute before every Method");
		driver = new ChromeDriver(); 
		
		//WebDriver is an interface and all the methods which are declared in Webdriver interface are implemented by respective driver class.
		//Running the same automation scripts in different browsers to achieve Runtime Polymorphism.

	}

	
		WebDriver driver; //WHY HRER, supposed to be in beforetest
		
		// It helps you when you do testing on multiple browsers.
		//switching will be very easy. If we use this statement in our script then the WebDriver driver can implement any browser.

	@Test(description = "Verifying the link named Contact Us opens when it click.")
		public void verifyContactUsLink_TC02() 
	{
		// Step1- open homepage
		
		driver.get("https://www.dollardays.com/");
		System.out.println("CURRENT URL: " + driver.getCurrentUrl());
		System.out.println("CURRENT TITLE:" + driver.getTitle());

		// Step2 - click contact us link
		
		WebElement contactUsWebElement = driver.findElement(By.linkText("Contact Us"));
		//Contact US on Linktext.
		
		Assert.assertTrue(contactUsWebElement != null);
		//Assertions are used for validating a test case and helps us understand if a test case has passed or failed.
		//When the object is Null, the assertion is passed without any exception.
		
		if (contactUsWebElement != null) {
			contactUsWebElement.click();
		}
		
		System.out.println("AFTER CLICK CURRENT URL: " + driver.getCurrentUrl());
		System.out.println("AFTER CLICK CURRENT TITLE:" + driver.getTitle());
		String expectedURL = "https://www.dollardays.com/aboutus/contact-us.aspx";
		String expecterTitle = "Contact Us - DollarDays";

		Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
		Assert.assertEquals(driver.getTitle(), expecterTitle);

		// Step3 - Assert link is clickable or not

	}

	@AfterMethod

	public void afterMethod() {

		System.out.println("This will execute after every Method");
		driver.quit();

	}

	@AfterClass

	public void afterClass() {

		System.out.println("This will execute after the Class");

	}

	@AfterTest
	 
	 public void afterTest() {
	 
	 System.out.println("This will execute after the Test");
	
	}

	@AfterSuite

	public void afterSuite() {

		System.out.println("This will execute after the Test Suite");

	}
}
