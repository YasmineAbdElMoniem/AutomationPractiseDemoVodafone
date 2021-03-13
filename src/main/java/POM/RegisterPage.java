package POM;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class RegisterPage extends PageBase{

	public RegisterPage(WebDriver driver) {

		super(driver);

		this.driver=driver;

		PageFactory.initElements(driver , this);
	}	

	@FindBy(id= "email_create")
	public WebElement email_createTextfield ;



	@FindBy(xpath = "//div[3]/button/span")
	public WebElement creatEmailBtn ;

	@FindBy(id = "id_gender2")
	public WebElement MRsGenderBtn ;


	@FindBy(id = "customer_firstname")
	public WebElement Fname ;


	@FindBy(id = "customer_lastname")
	public WebElement Lname ;

	@FindBy(name = "email")
	public WebElement EmailAdd ;

	@FindBy(id = "passwd")
	public WebElement Password ;

	@FindBy(xpath = "//form/div[1]/div[6]/div/div[2]/div/select")
	public WebElement months ;
	
	@FindBy(xpath = "//form/div[1]/div[6]/div/div[1]/div/select")
	public WebElement Days ;
	
	@FindBy(xpath = "//form/div[1]/div[6]/div/div[3]/div/select")
	public WebElement years ;

	@FindBy(id = "newsletter")
	public WebElement newsletterCheckBox ;

	@FindBy(id = "optin")
	public WebElement optinCheckBox ;

	@FindBy(id = "firstname")
	public WebElement firstnameComp ;

	@FindBy(id = "lastname")
	public WebElement lastnameComp ;

	@FindBy(id = "company")
	public WebElement company ;

	@FindBy(id = "address1")
	public WebElement address1 ;

	@FindBy(id = "city")
	public WebElement city ;

	@FindBy(id = "id_state")
	public WebElement IdState ;

	@FindBy(id = "postcode")
	public WebElement postCodeF ;

	@FindBy(id = "id_country")
	public WebElement IdCountry ;

	@FindBy(id = "phone_mobile")
	public WebElement phoneMobile ;

	@FindBy(id = "alias")
	public WebElement Alias ;

	@FindBy(xpath  = "//div[4]/button/span")
	public WebElement RegisterBtn ;

	@FindBy(xpath  = "//div[3]/div/p")
	public WebElement Succ_Msg ;
		
	
	public void EnterEmailAddresses(String Emailtxt) {
		

		EnterText(email_createTextfield,Emailtxt);
	}

	public void Click_CreateAccountBtn (){

		Click_Button(creatEmailBtn);	}

	// Register Form Here

	public void Click_MRsGender (){

		Click_Button(MRsGenderBtn);
	}

	public void EnterFirstName(String FirstName) {

		EnterText(Fname,FirstName);
	}

	public void EnterLastName(String LastName) {

		EnterText(Lname,LastName);
	}

	public Boolean VerifyEmailMatching (String InsertedEmail) {

	JavascriptExecutor js = ((JavascriptExecutor) driver);
		
		Boolean IsEmail=false;
		
		String EmailAddreessTxt="";
		
		js.executeScript("arguments[0].scrollIntoView(true);", EmailAdd);
		
		EmailAddreessTxt=EmailAdd.getAttribute("value");

		if(EmailAddreessTxt.equals(InsertedEmail))
		{
			IsEmail=true;
		}

		return IsEmail;

	}

	public void EnterPassword (String passW)
	{
		EnterText(Password,passW);
	}

	public void InsertDateOfBirth() {
		
		Days.sendKeys("25");
		Days.click();
		
		months.sendKeys("January");
		months.click();
		
		years.sendKeys("1994");
		years.click();
	}
	
	public void Click_SignUpnewsletter(){

		Click_Button(newsletterCheckBox);
	}

	public void Click_Receivespecialoffers(){

		Click_Button(optinCheckBox);
	}

	public void Enter_company(String companyTxt){

		EnterText(company,companyTxt);
	}

	public void Enter_Address(String AddressTxt){

		EnterText(address1,AddressTxt);
	}

	public void Enter_city(String cityTxt){

		EnterText(city,cityTxt);
	}

	public void InsertState(String StateTxt) {

		Select IdStateOptn = new Select(this.IdState);
		
		IdStateOptn.selectByVisibleText(StateTxt);

	}

	public void Enter_postCode(String postCodeTxt){

		EnterText(postCodeF,postCodeTxt);
	}

	
	public void InserCountry(String CountryTxt) {

		Select IdCountryOptn = new Select(this.IdCountry);
		IdCountryOptn.selectByVisibleText(CountryTxt);

	}

	public void Enter_MobileNum(String MobileNum){

		EnterText(phoneMobile,MobileNum);
	}


	public void Enter_Alias(String AliasTxt){

		EnterText(Alias,AliasTxt);
	}


	public void Click_RegisterBtn(){

		Click_Button(RegisterBtn);
	}

	
	public boolean IsAccountCreated(){

		Boolean IsAccCreated=false;

		String LnameTxtTxt="";

		LnameTxtTxt=Succ_Msg.getText().trim();

		if(LnameTxtTxt.contains("Welcome to your account"))
		{
			IsAccCreated=true;
		}

		return IsAccCreated;
	}

	

	
	
	
}
