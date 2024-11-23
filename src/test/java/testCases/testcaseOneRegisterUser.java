package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.accountCreatedPage;
import pageObjects.registerDetails;
import pageObjects.signUpPage;
import testBase.BaseClass;

public class testcaseOneRegisterUser extends BaseClass {
	
	@Test
	public void testOneRegistration1() throws InterruptedException 
	{
		try {
		
			
		logger.info("********Starting testOneRegistration1 ********");
		//HomePage Object	
		HomePage hp=new HomePage(driver);
		hp.registerLink();
		
		logger.info("******** Providing SingUp Details ********");
		//SignUp ObjectPage
		signUpPage sp=new signUpPage(driver);
		sp.userNameProviding(randomString());
		sp.userEmailProviding(randomString()+"@gmail.com");
		sp.submitingSignUp();
		
		Thread.sleep(2000);
		logger.info("******** Providing All Account details for New Account Creation ********");
		registerDetails rd= new registerDetails(driver);
		rd.testregisterPageTitle();
		rd.testGender();
		//rd.providingRegisterDetails("Meruva");
		//rd.providingEmail("sivaguruprasad123@gmail.com");
		rd.providingPassword(randomAlphaNumeric());
		rd.selectDate();
		rd.selectMonth();
		rd.selectYear();
		rd.choosing_new_sletter();
		rd.providing_first_Name(randomString());
		rd.providing_last_Name(randomString());
		rd.providing_company_Name(randomString());
		rd.providing_address1("Kormangal BDC14A");
		rd.providing_Country("India");
		rd.providing_City("Bangalore");
		rd.providing_State("Karnataka");
		rd.providing_ZipCode("178632");
		rd.providing_Mobile_Number(randomNumeric());
		rd.submitting_RDetails();
		logger.info("********Validate Expected Message ********");
		String confmsg=rd.getConfirmationMsg();
		Assert.assertEquals(confmsg, "ACCOUNT CREATED!");
		logger.info("******** Account Creation is completed ********");
		
		accountCreatedPage ac=new accountCreatedPage(driver);
		ac.click_Continue();
		
		//hp.status_of_Username();
		hp.Account_Delete();
		String confmsg2=hp.getConfirmationMsg();
		Assert.assertEquals(confmsg2, "ACCOUNT DELETED!");
		
		}
		catch (Exception e)
		{
			logger.error("Test_Failed...");
			//logger.debug("Debug Logs...");
			Assert.fail();
		}
	}
}

