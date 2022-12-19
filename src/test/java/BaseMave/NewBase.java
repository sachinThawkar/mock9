package BaseMave;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import utility.utility;


public class NewBase 
{
	protected static WebDriver driver;
	public void launchBrowser() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Desktop\\selenium\\ChromeDriver\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.get(utility.readdataFromProperty("url"));
		driver.manage().window().maximize();
		
		Reporter.log("lantching Browser", true);
		utility.wait(driver, 1000);
		
	}
	
	public void closingBrowser() throws InterruptedException
	{
		//Reporter.log("closed browser", true);
		Thread.sleep(500);
		driver.close();
	}
	

}
