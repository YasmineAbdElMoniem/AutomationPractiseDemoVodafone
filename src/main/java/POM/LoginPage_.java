package POM;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage_  extends PageBase{

	public LoginPage_(WebDriver driver) {
		super(driver);

		this.driver=driver;

		PageFactory.initElements(driver , this);
	}

	
	
	@FindBy(id = "email")
	public WebElement emailAdd ;


	@FindBy(id = "passwd")
	public WebElement password ;
	
	
	@FindBy(xpath = "//p[2]/button/span")
	public WebElement SignIn ;
	
	public void EnterEmailAdd(String EmailTxt)
	{
		EnterText(emailAdd,EmailTxt);
	}
	
	
	public void EnterPassword (String passW)
	{
		EnterText(password,passW);
	}
	
	
	public void Click_SignIn (){

        JavascriptExecutor js = ((JavascriptExecutor) driver);
	
		
		js.executeScript("arguments[0].scrollIntoView(true);", SignIn);
		
		
		Click_Button(SignIn);	
		}

	
	
	
}
