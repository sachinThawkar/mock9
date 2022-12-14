package neoStoxPomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import utility.utility;





public class Start 
{
@FindBy(xpath = "(//a[text()='Sign In'])[1]") private WebElement startPage;

public Start(WebDriver driver)
{
	PageFactory.initElements(driver, this);
	
}
public void clickOnStartPage(WebDriver driver)
{
	utility.wait(driver, 1000);
	startPage.click();
	Reporter.log("click on signin page", true);
}
}
