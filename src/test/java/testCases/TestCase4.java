package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TestCase4 extends BaseClass{

	@Test(groups={"Regression","Master"})
	public void TestCaseFour() 
	{
		try {
			//HomePage Object	
			HomePage hp=new HomePage(driver);
			hp.registerLink();
			
			hp.login_into_page("sivaguruprasad1234@gmail.com");
			hp.login_into_pagepassword("MSGP21#()");
			hp.submit_login();
			
			String confmsg=hp.getlogged_UserConfirmation();
			Assert.assertEquals(confmsg, "Meruva");
			System.out.println("The User name is matched successfully");
						
			hp.submit_Log_out();
			hp.sign_up_btn_status();
			}
			catch (Exception e)
			{
				Assert.fail();
				System.out.println("The test_case4 has Failed");
			}
	}
}
