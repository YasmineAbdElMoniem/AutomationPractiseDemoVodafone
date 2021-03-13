package POM;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CartCheckOut extends PageBase {

	public CartCheckOut(WebDriver driver) {
		super(driver);

		this.driver=driver;

		PageFactory.initElements(driver , this);
	}


	@FindBy(xpath  = "//a[contains(text(),'Women')]")
	public WebElement Women ;

	@FindBy(xpath  = "//*[@id=\"add_to_cart\"]/button/span")
	public WebElement Add_to_Cart ;
	
	@FindBy(xpath  = "//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]")
	public WebElement FirstOpnSelect ;

	@FindBy(xpath  = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
	public WebElement proceedToCheckout ;


	@FindBy(xpath  = "//div[3]/div/p[2]/a/span")
	public WebElement proceedToCheckout2 ;

	@FindBy(xpath  = "//div[@id='center_column']/form/p/button/span")
	public WebElement proceedToCheckout3 ;


	@FindBy(id  = "cgv")
	public WebElement Terms ;



	@FindBy(xpath  = "//p/button/span")
	public WebElement proceedToCheckout4 ;

	@FindBy(linkText= "Pay by check (order processing will be longer)")
	public WebElement payByCheckOptn ;

	@FindBy(xpath  = "//p/button/span")
	public WebElement ConfirmBtn ;


	@FindBy(xpath  = "//div[3]/div/p")
	public WebElement confirmedMsg ;

	public void Click_Women (){

		Click_Button(Women);	
	}

	public void Click_Add_to_Cart()
	{
		
		Click_Button(Add_to_Cart);	
	}
	
	public void AddOneCategoriy (){


		JavascriptExecutor jse6 = (JavascriptExecutor) driver;
		jse6.executeScript("window.scrollBy(0,700)", "");


		Click_Button(FirstOpnSelect);
		
		Click_Button(Add_to_Cart);
		
		Click_Button(proceedToCheckout);


		Click_Button(proceedToCheckout2);

		Click_Button(proceedToCheckout3);

		Click_Button(Terms);

		Click_Button(proceedToCheckout4);

		//js.executeScript("arguments[0].scrollIntoView(true);", payByCheckOptn);
		
		Click_Button(payByCheckOptn);


		Click_Button(ConfirmBtn);



	}



	public boolean IsconfirmedOrder(){

		Boolean IsconfirmedMsg=false;

		String confirmedMsgTxt="";

		confirmedMsgTxt=confirmedMsg.getText().trim();

		if(confirmedMsgTxt.contains("is complete."))
		{
			IsconfirmedMsg=true;
		}

		return IsconfirmedMsg;
	}


}
