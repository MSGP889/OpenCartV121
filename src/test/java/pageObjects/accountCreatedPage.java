package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class accountCreatedPage extends BasePage {

	public accountCreatedPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[normalize-space()='Continue']") WebElement btncontinue;
	
	public void click_Continue()
	{
		btncontinue.click();
	}

	
}
