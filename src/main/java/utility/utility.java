package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;


import net.bytebuddy.utility.RandomString;

public class utility 
{
	//common methods
	
	public static String readdataFromProperty(String key) throws IOException 
	{
		Properties data = new Properties();
		FileInputStream myfile = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\neoStox\\myprop.properties");
		data.load(myfile);
		String value = data.getProperty(key);
		return value;
	}
	
	
	
	// For GetScreenshot
	public static void takeScreenshot(WebDriver driver,String fileName) throws IOException
	{
		 File sorce = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String input = RandomString.make(1);
		 File destination = new File("C:\\Users\\hp\\Desktop\\Screenshot Selenium\\"+fileName+input+".png");
		 FileHandler.copy(sorce, destination);
		 
		 //Reporter.log("taking screenshot", true);
		 
	}
	
	// For Scrolling 
	public static void scrollIntoView(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	//	Reporter.log("scrolling the page"+element.getText(), true);
	
	}
	
	// For using Wait
	public static void wait(WebDriver driver,int time)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
		//Reporter.log("waiting for"+time+"milis", true);
	}

}
