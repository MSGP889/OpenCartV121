package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class signUpPage extends BasePage {

	public signUpPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//input[@placeholder='Name']") WebElement userName;
	@FindBy(xpath="//input[@data-qa='signup-email']") WebElement userEmail;
	@FindBy(xpath="//button[normalize-space()='Signup']") WebElement btnsignUp;
	
	public void userNameProviding(String SignUpUserName)
	{
		userName.sendKeys(SignUpUserName);
	}
	public void userEmailProviding(String SignUpEmail)
	{
		userEmail.sendKeys(SignUpEmail);
	}
	public void submitingSignUp()
	{
		btnsignUp.click();
	}
	
}
