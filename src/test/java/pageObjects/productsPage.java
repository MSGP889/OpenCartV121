package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class productsPage extends BasePage {

	public productsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//h2[normalize-space()='Category']") WebElement CategoryVisible;
	
	public boolean CategoryHeadingVisibility()
	{
		boolean StatusofCategoryHeading=CategoryVisible.isDisplayed();
		return StatusofCategoryHeading;
	}
	
	
}
