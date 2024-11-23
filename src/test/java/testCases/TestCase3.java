package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TestCase3 extends BaseClass {

	@Test(groups={"Regression","Master"})
	public void LoginToPage()
	{
		try {
		//HomePage Object	
		HomePage hp=new HomePage(driver);
		hp.registerLink();
		
		hp.login_into_page("sivaguruprasad1234@gmail.com");
		hp.login_into_pagepassword("MSGP21#3()");
		hp.submit_login();
		
		String confmsg=hp.getErrorMsg();
		Assert.assertEquals(confmsg, "Your email or password is incorrects!");
		//System.out.println(confmsg);
		}
		catch (Exception e)
		{
			Assert.fail();
		}
	}
}
