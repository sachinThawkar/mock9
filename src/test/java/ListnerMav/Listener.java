package ListnerMav;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import BaseMave.NewBase;
import utility.utility;



public class Listener extends NewBase implements ITestListener
{
	public void onTestSuccess(ITestResult result) 
	{
		Reporter.log("Tc " +result.getName()+"is pass", true);
	}
	public void onTestFailure( ITestResult result) 
	 	{
		try {
			utility.takeScreenshot(driver, result.getName());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		Reporter.log("Tc " +result.getName()+"is fail", true);
	}
	public void onTestSkipped(ITestResult result) 
	{
		Reporter.log("Tc " +result.getName()+"is skipped", true);
		
	}


}
