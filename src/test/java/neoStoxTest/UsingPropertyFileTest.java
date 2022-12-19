package neoStoxTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseMave.NewBase;
import neoStoxPomClasses.HomePageNeoStox;
import neoStoxPomClasses.PassCodeNeoStox;
import neoStoxPomClasses.SignInPageNeoStox;
import neoStoxPomClasses.Start;
import utility.utility;

@Listeners(ListnerMav.Listener.class)
public class UsingPropertyFileTest
{
	public class ValidateNeostoxUserName extends NewBase
	{
		SignInPageNeoStox login;
		PassCodeNeoStox pacode;
		HomePageNeoStox home;
		Start st;
		
	 @BeforeClass
	 public void launchNeostox() throws IOException
	 {
		 launchBrowser();
		 login = new SignInPageNeoStox(driver);
		 pacode =new PassCodeNeoStox(driver);
		 home = new HomePageNeoStox(driver);
		 st=new Start(driver);
		 
	 }
	 @BeforeMethod
	 public void logingToNeostox() throws InterruptedException, EncryptedDocumentException, IOException
	 {
		 st.clickOnStartPage(driver);
		 login.sendMobileNum(driver,utility.readdataFromProperty("moblieNumber"));
		 login.clickOnSingInButton(driver);
		 Thread.sleep(1000);
		 pacode.enterPasscode(driver, utility.readdataFromProperty("passWord"));
		 pacode.clickOnSubmitButton(driver);
		 Thread.sleep(1000);
	     home.popUpHandle(driver);
	     
	 }
		@Test
	  public void validateUserName () throws EncryptedDocumentException, IOException 
		{
			Assert.assertEquals(home.getUserName(), utility.readdataFromProperty("userName"),"TC failed, actual and expected User Names are not matching");
			
				
	  }
		 @Test
		  public void validateACBalance ()
		  {
			  Assert.assertNotNull(home.getBalance(driver));
			  Reporter.log("validate balance is", true);
			  
		  }
		
		@AfterMethod
		public void logout()
		{
			home.logoutFromApplication(driver);
		}
		
		@AfterClass
		public void closeApplication() throws InterruptedException
		{
			closingBrowser();
			
		}
	}
}
