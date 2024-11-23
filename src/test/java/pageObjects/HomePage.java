package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//a[normalize-space()='Home']") WebElement HomePageVisible;
	@FindBy(xpath="//a[normalize-space()='Signup / Login']") WebElement btnRegisterLink;
	
	@FindBy(xpath="//b[normalize-space()='Meruva']") WebElement check_Username;
	
	@FindBy(xpath="//a[normalize-space()='Delete Account']") WebElement Delete_Account;
	@FindBy(xpath="//b[normalize-space()='Account Deleted!']") WebElement msgConfirmation;
	
	@FindBy(xpath="//input[@data-qa='login-email']") WebElement loginEmail;
	@FindBy(xpath="//input[@placeholder='Password']") WebElement loginPassword;
	@FindBy(xpath="//button[normalize-space()='Login']") WebElement btn_submit_login;
	@FindBy(xpath="//b[normalize-space()='Meruva']") WebElement logged_UserName;
	@FindBy(xpath="//p[normalize-space()='Your email or password is incorrect!']") WebElement checkErrorMsg;
	@FindBy(xpath="//a[normalize-space()='Logout']") WebElement btn_Log_Out;
	@FindBy(xpath="//p[normalize-space()='Email Address already exist!']") WebElement email_existing;
	
	
	
	public void HomePageVisibility()
	{
		boolean HomePageVisibleStatus=HomePageVisible.isDisplayed();
		System.out.println(HomePageVisibleStatus+"Home Page Loaded successfully");
	}
	
	public void registerLink()
	{
		btnRegisterLink.click();
		System.out.println("sucessfully clicked on sign_up button");
	}
	/*
	public void status_of_Username()
	{
		Assert.assertEquals();
	}*/
	public void Account_Delete()
	{
		Delete_Account.click();
		System.out.println("sucessfully account got deleted");
	}
	public String getConfirmationMsg()
	{
		try {
			return (msgConfirmation.getText());
		}catch(Exception e) {
			return(e.getMessage());
		}
	}
	public void login_into_page(String login_Pemail)
	{
		loginEmail.sendKeys(login_Pemail);
	}
	public void login_into_pagepassword(String login_Ppassword)
	{
		loginPassword.sendKeys(login_Ppassword);
	}
	public void submit_login()
	{
		btn_submit_login.click();
		System.out.println("sucessfully logged_in");
	}
	public String getlogged_UserConfirmation()
	{
		try {
			return (logged_UserName.getText());
		}catch(Exception e) {
			return(e.getMessage());
		}
	}
	public String getEmail_existing()
	{
		try {
			return (email_existing.getText());
		}catch(Exception e) {
			return(e.getMessage());
		}
	}
	public String getErrorMsg()
	{
		try {
			return (checkErrorMsg.getText());
		}catch(Exception e) {
			return(e.getMessage());
		}
	}
	public void submit_Log_out()
	{
		btn_Log_Out.click();
	}
	public void sign_up_btn_status()
	{
		boolean sign_up_btn =btnRegisterLink.isDisplayed();
		System.out.println(sign_up_btn+"Backed to sign_up button");
	}
	
}
