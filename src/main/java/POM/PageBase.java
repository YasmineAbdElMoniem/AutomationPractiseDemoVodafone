package POM;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class PageBase {


	protected WebDriver driver;


	public PageBase (WebDriver driver) {



		PageFactory.initElements(driver, this);

	}



	protected static void Click_Button(WebElement button) {

		button.click();
	}
	
	

	protected static void EnterText(WebElement txt , String userTxt) {

		txt.click();
		txt.clear();
		txt.sendKeys(userTxt);
	}



}
