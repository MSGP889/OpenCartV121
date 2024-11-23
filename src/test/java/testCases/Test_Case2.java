package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.DataProviders;

public class Test_Case2 extends BaseClass{

	@Test(groups={"Sanity","Master"},dataProviderClass=DataProviders.class)
	public void LoginToPage()
	{
		//HomePage Object	
		HomePage hp=new HomePage(driver);
		hp.registerLink();
		
		
		//Login Page
		hp.login_into_page("Email");
		hp.login_into_pagepassword("Password");
		hp.submit_login();
		
		
		String confmsg=hp.getlogged_UserConfirmation();
		Assert.assertEquals(confmsg, "Meruva");
		System.out.println(confmsg);
	}
}
