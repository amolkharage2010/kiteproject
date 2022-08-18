package Module1_Login_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import Module1_Login.KiteHomePage;
import Module1_Login.KiteLogin1Page;
import Module1_Login.KiteLogin2Page;

public class KiteLoginTest2 extends BaseClass
{
	KiteLogin1Page login1;
	KiteLogin2Page login2;
	KiteHomePage home;
	int TCID;
	
	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException
	{
		Reporter.log("--Open browser--",true);
		 initializeBrowser();
		 login1=new KiteLogin1Page(driver);
	 	 login2=new KiteLogin2Page(driver);
		 home=new KiteHomePage(driver);
	}
	
	@BeforeMethod
	public void loginToApp() throws EncryptedDocumentException, IOException
	{
		Reporter.log("--Login To App--",true);
		login1.inpKiteLogin1PageUsername(UtilityClass.getPFData("UN"));
		login1.inpKiteLogin1PagePassword(UtilityClass.getPFData("PWD"));
		login1.clickKiteLogin1PageLoginBtn();
		login2.inpKiteLogin2PagePin(UtilityClass.getPFData("PIN"));
		login2.clickKiteLogin2PageContinueBtn();	
	}
	
	
	@Test
	public void verifyUserID() throws EncryptedDocumentException, IOException
	{
		TCID=101;
		Reporter.log("running verify User ID TC",true);		
		String actUserID = home.getKiteHomePageUsrID();
		String expUserId = UtilityClass.getTD(0, 3);
		Assert.assertEquals(actUserID, expUserId,"--Failed: both results are diff--");
	}
	
	
	@AfterMethod
	public void logoutFromApp(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.captureScreenshot(driver, TCID);
		}
		
		Reporter.log("--Logout From App--",true);
	}
	
	@AfterClass
	public void closeBrowser()
	{
		Reporter.log("--Open browser--",true);
		driver.close();
		login1=null;
		login2=null;
		home=null;
		driver=null;
	}

}
