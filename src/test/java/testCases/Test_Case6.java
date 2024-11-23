package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.productsPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class Test_Case6 extends BaseClass{

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)// getting DataProvider from Different Class
	public void LoginToPage(String email, String password, String exp)
	{
		try {
		//HomePage Object	
		HomePage hp=new HomePage(driver);
		hp.registerLink();
		
		
		//Login Page
		hp.login_into_page(email);
		hp.login_into_pagepassword(password);
		hp.submit_login();
		
		productsPage pp= new productsPage(driver);
		boolean actualStatusofCategory=pp.CategoryHeadingVisibility();
		
		//Data is valid- login success - test  case -logout
		//Data is invalid login failed- testCase fail
		//Data is invalid -login success - test fail - logout
		//Data is invalid -- login failed - test pass
		
		if(exp.equalsIgnoreCase("valid"))
		{
			if(actualStatusofCategory==true)
			{
				hp.submit_Log_out();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(actualStatusofCategory==true)
			{
				hp.submit_Log_out();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
	}
	catch (Exception e)
	{
		Assert.fail();
	}
	}
}

