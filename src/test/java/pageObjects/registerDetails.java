package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class registerDetails extends BasePage{

	public registerDetails(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//b[normalize-space()='Enter Account Information']") WebElement registerPageTitle;
	@FindBy(xpath="//input[@id='id_gender1']") WebElement gender;
	@FindBy(xpath="//input[@id='name']") WebElement userName;
	@FindBy(xpath="//input[@id='email']") WebElement Email;
	@FindBy(xpath="//input[@id='password']") WebElement password;
	@FindBy(xpath="//select[@id='days']") WebElement days;
	@FindBy(xpath="//select[@id='months']") WebElement months;
	@FindBy(xpath="//select[@id='years']") WebElement years;
	@FindBy(xpath="//input[@id='newsletter']") WebElement newSeltter;
	@FindBy(xpath="//input[@id='first_name']") WebElement firstName;
	@FindBy(xpath="//input[@id='last_name']") WebElement lastName;
	@FindBy(xpath="//input[@id='company']") WebElement companyName;
	@FindBy(xpath="//input[@id='address1']") WebElement address1;
	@FindBy(xpath="//select[@id='country']") WebElement countryName;
	@FindBy(xpath="//input[@id='state']") WebElement stateName;
	@FindBy(xpath="//input[@id='city']") WebElement cityName;
	@FindBy(xpath="//input[@id='zipcode']") WebElement zipCode;
	@FindBy(xpath="//input[@id='mobile_number']") WebElement mobileNumber;
	@FindBy(xpath="//button[normalize-space()='Create Account']") WebElement creatAccount;
	@FindBy(xpath="//b[normalize-space()='Account Created!']") WebElement msgConfirmation;
	
	public void testregisterPageTitle()
	{
		String expected_registerPageTitle="ENTER ACCOUNT INFORMATION";
		String actual_registerPageTitle =registerPageTitle.getText();
	    Assert.assertEquals(actual_registerPageTitle, expected_registerPageTitle);
	}
	public void testGender()
	{
		gender.click();
	}
	public void providingRegisterDetails(String username)
	{
		userName.sendKeys(username);
	}
	public void providingEmail(String email)
	{
		Email.sendKeys(email);
	}
	public void providingPassword(String password1)
	{
		password.sendKeys(password1);
	}
	public void selectDate()
	{
		Select day_of_date = new Select(days);
		day_of_date.selectByIndex(1);
		List<WebElement> options= day_of_date.getOptions();
		
		// Find number of options in Dropdown.
		System.out.println(options.size());
		
	}
	public void selectMonth()
	{
		Select day_of_month = new Select(months);
		day_of_month.selectByIndex(1);
		List<WebElement> options= day_of_month.getOptions();
		
		// Find number of options in Dropdown.
		System.out.println(options.size());
		
	}
	public void selectYear()
	{
		Select day_of_year = new Select(years);
		day_of_year.selectByIndex(1);
		List<WebElement> options= day_of_year.getOptions();
		
		// Find number of options in Dropdown.
		System.out.println(options.size());
		
	}
	public void choosing_new_sletter()
	{
		newSeltter.click();
	}
	public void providing_first_Name(String Pfirstname)
	{
		firstName.sendKeys(Pfirstname);
	}
	public void providing_last_Name(String Plastname)
	{
		lastName.sendKeys(Plastname);
	}
	public void providing_company_Name(String PcompanyName)
	{
		companyName.sendKeys(PcompanyName);
	}
	public void providing_address1(String Paddress1)
	{
		address1.sendKeys(Paddress1);
	}
	public void providing_Country(String Pcountry)
	{
		Select course = new Select(countryName);
		course.selectByVisibleText(Pcountry);
	}
	public void providing_State(String Pstate)
	{
		stateName.sendKeys(Pstate);
	}
	public void providing_City(String PCity)
	{
		cityName.sendKeys(PCity);
	}
	public void providing_ZipCode(String PZipCode)
	{
		zipCode.sendKeys(PZipCode);
	}
	public void providing_Mobile_Number(String PmobileNumber)
	{
		mobileNumber.sendKeys(PmobileNumber);
	}
	public void submitting_RDetails()
	{
		creatAccount.click();
	}
	public String getConfirmationMsg()
	{
		try {
			return (msgConfirmation.getText());
		}catch(Exception e) {
			return(e.getMessage());
		}
	}
}
