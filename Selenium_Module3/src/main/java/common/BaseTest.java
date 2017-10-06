package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod; 

public class BaseTest 
{
	protected static WebDriver driver;
	
	@BeforeMethod 
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/allDrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://opensource.demo.orangehrmlive.com/");
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}
}
