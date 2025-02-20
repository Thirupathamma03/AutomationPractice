package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.Homepage;
import testBase.BaseClass;

public class TC004_AccountRegistrationWithoutData extends BaseClass {
    
	@Test
	public void VerifyFieldsWithOutData() throws InterruptedException
	{
        logger.info("*****  Starting TC004_AccountRegistrationWithOutData *****");
		
		//homepage
		
			
		logger.info("*****  click My Account  *****");	
		Homepage hp=new Homepage(driver);
		hp.clickMyAccount();
		logger.info("*****  click My Account  *****");
		
		hp.clickRegistration();
   	    logger.info("clicked on Registration  link  ");
   	    
   	    AccountRegistrationPage Rp=new AccountRegistrationPage(driver);
   	    
   	    Rp.clickContinue();
   	    
   	    Thread.sleep(3000);
   	    
   	    String ExpectedFirstNameWarningField="First Name must be between 1 and 32 characters!";
   	    String ExpectedSecondNameWarningField="Last Name must be between 1 and 32 characters!";
   	    String ExpectedEmailWarningField="E-Mail Address does not appear to be valid!";
   	    String ExpectedTelePhoneWarningField="Telephone must be between 3 and 32 characters!";
   	    String ExpectedPasswordWarningField="Password must be between 4 and 20 characters!";
     	String ExpectedPrivacyPolicy="Warning: You must agree to the Privacy Policy!";
     	
     	Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText(),ExpectedFirstNameWarningField );
     	Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText(),ExpectedSecondNameWarningField );
     	Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]")).getText(),ExpectedEmailWarningField );
     	Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText(),ExpectedTelePhoneWarningField);
     	Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).getText(),ExpectedPasswordWarningField );
     	Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(),ExpectedPrivacyPolicy );
     	
     	logger.info("*****  Finished TC004_AccountRegistrationWithOutData *****");
     	driver.quit();
  	   
   	   
   	    
	    
   	    
		
	}
	
	
}
