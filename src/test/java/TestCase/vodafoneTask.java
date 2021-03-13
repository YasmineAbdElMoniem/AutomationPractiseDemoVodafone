package TestCase;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import POM.CartCheckOut;
import POM.HomePage_;
import POM.LoginPage_;
import POM.RegisterPage;



public class vodafoneTask extends TestBase {

	public ExtentReports extent;
	public ExtentTest test;
	HomePage_ home;
	RegisterPage register; 
	LoginPage_ login;
	CartCheckOut  carts;
	
	// Import Faker Library for data driven to give different values on registeration form
	Faker fakerData = new Faker();	
	String FirstName = fakerData.name().firstName();
	String LastName = fakerData.name().lastName();
	String Email = fakerData.internet().emailAddress();
	String Password = fakerData.number().digits(9).toString();	
		   
	String EmailAddress = Email;
	String Fits_Name = FirstName;
	String Last_Name = LastName;
	String Pass_Word = Password;
	
	@Test (priority=1, alwaysRun = true)

	public void VerifyregistrationForm() throws IOException, InterruptedException 
	{
		
		// Exporting the result on Chrome file
		extent = new ExtentReports(System.getProperty("user.dir")+"\\Results\\VerifyregistrationForm.html", true);
		test= extent.startTest("Verify that New Account is created Successfully");
		test.log(LogStatus.INFO, "Verify that New Account is created Successfully ");	
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		home = new HomePage_(driver);
		register = new RegisterPage(driver);
		login = new LoginPage_(driver);		
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		home.Click_SignIn();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		register.EnterEmailAddresses(EmailAddress);

		register.Click_CreateAccountBtn();

		register.Click_MRsGender();

		register.EnterFirstName(Fits_Name);

		register.EnterLastName(Last_Name);

		boolean isMatching =register.VerifyEmailMatching(EmailAddress);
		
		if(isMatching) 

		{
			test.log(LogStatus.PASS, " PASS"+": Email  Data Is Matching"+" ");
		}
		else 
		{
			test.log(LogStatus.FAIL, " FAIL"+""+" Email Data Is Matching ");

		}
		
	    register.EnterPassword(Pass_Word);
		
	  	register.InsertDateOfBirth();

		register.Click_SignUpnewsletter();

		register.Click_Receivespecialoffers();
		
		register.Enter_company("Vodafone");

		register.Enter_Address("ibnNafies");

		register.Enter_city("Cairo");

		register.InsertState("California");
		
        register.Enter_postCode("12345");
		
		register.InserCountry("United States");

		register.Enter_MobileNum("0100200100");

		register.Enter_Alias("Steeet2");

		register.Click_RegisterBtn();

        // New Account is created Successfully
		
		boolean IsAcc_created = register.IsAccountCreated();
		if(IsAcc_created) 
		{
			test.log(LogStatus.PASS, " PASS"+": New Account is created "+" ");
		}
		else 
		{
			test.log(LogStatus.FAIL, " FAIL"+"New Account not created"+" ");
		}
		
		home.Click_SignOut();		
		boolean SignIn = home.SignIn_Text();

		if(SignIn) 
		{
			test.log(LogStatus.PASS, " PASS"+": User is logged out from the website "+" ");
		}
		else 
		{
			test.log(LogStatus.FAIL, " FAIL"+"User is logged out from the website"+" ");
		}
		
		extent.endTest(test);
		extent.flush();

		//  Screenshot  

		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		File DestFileDestFile= new File(System.getProperty("user.dir")+"/ScreenShots/RegisterCreated"+".png");

		FileUtils.copyFile(SrcFile, DestFileDestFile);

		// end screen 
		
	}

	@Test (dependsOnMethods = "VerifyregistrationForm")

	public void VerifyLogin_() throws IOException, InterruptedException {


		extent = new ExtentReports(System.getProperty("user.dir")+"\\Results\\VerifyLogin_.html", true);
		test= extent.startTest("Verify that the user is logged into his account on the Website");
		test.log(LogStatus.INFO, "Verify that the user is logged into his account on the Website ");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		home = new HomePage_(driver);
		register = new RegisterPage(driver);
		login = new LoginPage_(driver);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			
		home.Click_SignIn();
		
		login.EnterEmailAdd(EmailAddress);
		
		login.EnterPassword(Pass_Word);
		
		
		login.Click_SignIn();
		
		boolean IsSignIn = register.IsAccountCreated();
		
		if(IsSignIn) 

		{
			test.log(LogStatus.PASS, " PASS"+": New Account is created "+" ");
		}
		else 
		{
			test.log(LogStatus.FAIL, " FAIL"+"New Account is created"+" ");

		}
		
		
		extent.endTest(test);

		extent.flush();

		//  Screenshot  

		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		File DestFileDestFile= new File(System.getProperty("user.dir")+"/ScreenShots/SignIn"+".png");

		FileUtils.copyFile(SrcFile, DestFileDestFile);

		// end screen 
		
}
	
	
	@Test (dependsOnMethods = "VerifyLogin_")

	public void VerifyCartCheckOut() throws IOException, InterruptedException 
	{

		extent = new ExtentReports(System.getProperty("user.dir")+"\\Results\\VerifyCartCheckOut_.html", true);
		test= extent.startTest("Verify that the user can purchase the products and checkout successfully ");
		test.log(LogStatus.INFO, "Verify that the user can purchase the products and checkout successfully");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		home = new HomePage_(driver);	
		carts = new CartCheckOut(driver);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		carts.Click_Women();
		
		carts.AddOneCategoriy();
		
		boolean IsOrderDone=carts.IsconfirmedOrder();
		
		if(IsOrderDone) 
		{
			test.log(LogStatus.PASS, " PASS"+" User can purchase the products and checkout successfully"+" ");
		}
		else 
		{
			test.log(LogStatus.FAIL, " FAIL"+"User can purchase the products and checkout successfully"+" ");

		}
		extent.endTest(test);

		extent.flush();

		//  Screenshot  

		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		File DestFileDestFile= new File(System.getProperty("user.dir")+"/ScreenShots/cartcheckout"+".png");

		FileUtils.copyFile(SrcFile, DestFileDestFile);

		// end screen 
	
	}
	
}
