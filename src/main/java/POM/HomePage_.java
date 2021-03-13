package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_  extends PageBase {

	public HomePage_(WebDriver driver) {
		super(driver);
		
		this.driver=driver;

		PageFactory.initElements(driver , this);
	}

	
	@FindBy(linkText= "Sign in")
	public WebElement SigninLink ;

	@FindBy(xpath  = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
	public WebElement SignoutLink ;
	
	public void Click_SignIn  ( )  
	{

 	    Click_Button(SigninLink);	
	}

	public Boolean SignIn_Text() 
	{
		boolean SignInTextAppear = false;
		if(SigninLink.isDisplayed())
		{
			SignInTextAppear = true;
		}
		return SignInTextAppear;
	}
	public void Click_SignOut  ( )  
	{

 	Click_Button(SignoutLink);
		
	
	}

}
