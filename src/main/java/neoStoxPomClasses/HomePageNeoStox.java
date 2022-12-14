package neoStoxPomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import utility.utility;

public class HomePageNeoStox
{
	@FindBy(xpath = "(//a[text()='OK'])[2]") private WebElement okButton;
	@FindBy(xpath = "(//a[text()='Close'])[5]") private WebElement closeButton;
	@FindBy(id = "lbl_username") private WebElement userName;
	@FindBy(id = "lbl_curbalancetop") private WebElement balance;
	@FindBy(id = "lnk_logout") private WebElement logoutButton;
	
	public HomePageNeoStox(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void popUpHandle(WebDriver driver)
	{
		if(okButton.isDisplayed())
		{
			
		utility.wait(driver, 1000);
		okButton.click();
		closeButton.click();
		Reporter.log("popUp handle", true);
		}
		else
		{
			utility.wait(driver, 1000);
			Reporter.log("No popup", true);
		}
		
		
	}
	
	public String getUserName()
	{
		String actualUserName = userName.getText();
		Reporter.log("actual user name is", true);
		return actualUserName;
	}
	
	public String getBalance(WebDriver driver)
	{
		utility.wait(driver, 1000);
		String actualBalance = balance.getText();
		Reporter.log("actual Balance is", true);
		return actualBalance;
	}
	
	public void logoutFromApplication(WebDriver driver)
	{
		utility.wait(driver, 1000);
		userName.click();
		utility.wait(driver, 1000);
		logoutButton.click();
		Reporter.log("logout from applicating", true);
	}
	
	
	

}
