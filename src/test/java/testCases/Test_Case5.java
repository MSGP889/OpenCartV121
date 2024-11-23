package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.signUpPage;
import testBase.BaseClass;

public class Test_Case5 extends BaseClass {
	
	@Test(groups={"Sanity","Master"})
	public void TestCase_Five()
	{
		try {
			//HomePage Object	
			HomePage hp=new HomePage(driver);
			hp.registerLink();
			
			signUpPage sp=new signUpPage(driver);
			sp.userNameProviding("Meruva");
			sp.userEmailProviding("sivaguruprasad1234@gmail.com");
			sp.submitingSignUp();
			
			String confmsg=hp.getEmail_existing();
			Assert.assertEquals(confmsg, "Email Address already exist!");
			System.out.println("The Email existing message is matched successfully");
			}
			catch (Exception e)
			{
				Assert.fail();
				System.out.println("The test_case4 has Failed");
			}
	}
}
