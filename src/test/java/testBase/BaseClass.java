package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public WebDriver driver;
	
	public Logger logger;
	
	public Properties p;
	
	/*
	@BeforeClass
	public void setUP() throws IOException 
	{
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		logger= LogManager.getLogger(this.getClass());
		driver=new EdgeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
	}*/
	
	//java -jar selenium-server-4.26.0.jar standalone --> command to run Grid.
	
	@BeforeClass(groups={"Sanity","Master","Regression"})
	@Parameters({"os","browser"})
	public void setUp(String os, String br) throws InterruptedException, IOException
	{ 
		FileReader file=new FileReader("./src//test/resources//config.properties");
		p=new Properties();
		p.load(file);
		//Loading config.properties file
		
		logger=LogManager.getLogger(this.getClass());//log4j2
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			if(os.equalsIgnoreCase("window"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os");
				return;
			}
			switch (br.toLowerCase()) {
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			default :System.out.println("Invalid browser name.."); return;
		}
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
			if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
			{
				switch (br.toLowerCase()) {
				case "chrome": driver=new ChromeDriver(); break;
				case "edge": driver=new EdgeDriver(); break;
				case "firefox": driver=new FirefoxDriver(); break;
				default :System.out.println("Invalid browser name.."); return;
				}
			}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));//Reading URL from Properties file.
		driver.manage().window().maximize();
	}
	
	
	@AfterClass(groups={"Sanity","Master","Regression"})
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
	
	
	public String randomString()
	 {
		 String generatedString= RandomStringUtils.randomAlphabetic(5);
		 return generatedString;
	 }
	 public String randomNumeric()
	 {
		 String generatedInteger=RandomStringUtils.randomNumeric(5);
		 return generatedInteger;
	 }
	 public String randomAlphaNumeric()
	 {
		 String generatedString=RandomStringUtils.randomAlphabetic(5);
		 String generatedInteger=RandomStringUtils.randomNumeric(5);
		 return (generatedString+"@"+generatedInteger);
	 }
}
