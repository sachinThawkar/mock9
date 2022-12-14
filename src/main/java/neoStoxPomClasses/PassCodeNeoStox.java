package neoStoxPomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import utility.utility;



public class PassCodeNeoStox
{

	@FindBy(id = "txt_accesspin") private WebElement passCode;
	@FindBy(xpath = "//a[text()='Submit']") private WebElement submitbutton;
	
	public PassCodeNeoStox(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterPasscode(WebDriver driver,String code)
	{
		     
		
		
		
		utility.wait(driver,1000);
		passCode.sendKeys(code);
		Reporter.log("entering passcode", true);
	}
	
	public void clickOnSubmitButton(WebDriver driver)
	{
		
		
		
		
		
		
		
		
		utility.wait(driver,1000);
		submitbutton.click();
		Reporter.log("click on submit button", true);
	}

}
