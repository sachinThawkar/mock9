package neoStoxPomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utility.utility;



public class SignInPageNeoStox 
{
	@FindBy(id = "MainContent_signinsignup_txt_mobilenumber") private WebElement MobileNoField;
	@FindBy(xpath = "(//a[text()='Sign In'])[2]") private WebElement signInButton;
	
	public SignInPageNeoStox(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendMobileNum(WebDriver driver,String mobNum)
	{
		utility.wait(driver, 1000);
		MobileNoField.sendKeys(mobNum);
		//Reporter.log("send mobile number", true);
	}
	
	public void clickOnSingInButton(WebDriver driver)
	{
		utility.wait(driver, 1000);
		signInButton.click();
		//Reporter.log("click on submit button", true);
	}

}
