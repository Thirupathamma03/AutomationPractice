package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.Homepage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass
{
	 
      
	 
	  @Test(groups={"Master","Regression"})
      public void VerifyAccountRegistration() 
      {
		  try {
			  
		   logger.info("********* Staring TC001_AccountRegistrationTest ******");  
     	   Homepage hp=new Homepage(driver); 
     	   
     	   hp.clickMyAccount();
     	   logger.info("clicked on myAccount link  ");
     	   
     	   hp.clickRegistration();
     	   logger.info("clicked on Registration  link  ");
     	   
     	   AccountRegistrationPage Rp=new AccountRegistrationPage(driver);
     	   
     	   logger.info("Providing customer details ");
     	   Rp.setFirstName(randomeString());
     	   Thread.sleep(2000);
     	   Rp.setLastName(randomeString());
     	   Thread.sleep(2000);
     	   Rp.setEmail(randomeString()+"@gmail.com");
     	   Thread.sleep(2000);
     	   Rp.setPhone(randomeNumber());
     	   Thread.sleep(2000);
     	   String password=randomeAlphaNumber();
     	   Thread.sleep(2000);
     	   Rp.setPassword(password);
     	   Thread.sleep(2000);
     	   Rp.setConfirmPassword(password);
     	   Rp.clickYesButton();
     	   Rp.clickCheckBox();
     	   Rp.clickContinue();
     	   
     	   logger.info("validating expected message...........  ");
     	   String confmsg=Rp.getConfirmMsg();
     	   Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		   }catch(Exception e) {
			  logger.error("Test failed...."+e.getMessage());
			  //logger.debug("Debug logs..... ");
			  //Assert.fail("Test failed due to exception:"+e.getMessage());
		   }
     	   logger.info("********** Finished TC001_AccountRegistrationTest*******");
     	   
     	   
      }
      	  
	 
	  
	
}
