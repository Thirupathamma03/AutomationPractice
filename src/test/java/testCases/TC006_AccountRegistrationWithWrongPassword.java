package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.Homepage;
import testBase.BaseClass;

public class TC006_AccountRegistrationWithWrongPassword extends BaseClass 
{
    @Test 
	public void VerifyAccountRegistrationWithWrongPassword() throws InterruptedException
	{
		
		    logger.info(" ********* Starting TC006_AccountRigistrationWithWrongPassword ********");
	    	Homepage hp=new Homepage(driver);
	    	
	    	hp.clickMyAccount();
	    	hp.clickRegistration();
	    	
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
	     	Rp.setPassword(randomeAlphaNumber());
	     	Thread.sleep(2000);
	     	Rp.setConfirmPassword(randomeAlphaNumber());
	     	Rp.clickYesButton();
	     	Rp.clickCheckBox();
	        Rp.clickContinue();
	        
	        WebElement PasswordWaringMSG = driver.findElement(By.xpath("//div[@class='text-danger']"));
	        
	        Assert.assertEquals( PasswordWaringMSG.getText(),"Password confirmation does not match password!");
	        
	        logger.info(" ********* Finished TC006_AccountRigistrationWithWrongPassword ********");
	        
	    	
	}
     
}
