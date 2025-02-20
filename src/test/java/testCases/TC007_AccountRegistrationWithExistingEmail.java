package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.Homepage;
import testBase.BaseClass;

public class TC007_AccountRegistrationWithExistingEmail extends BaseClass
{  
	 @Test
     public void TC007_AccountRegistrationWithExistingEmail() throws InterruptedException 
     {
    	 logger.info("**************Starting TC007_AccountRegistrationWithExistingEmail ***********");
    	 
    	 Homepage hp=new Homepage(driver);
    	 hp.clickMyAccount();
    	 hp.clickRegistration();
    	 
    	 AccountRegistrationPage Rp=new AccountRegistrationPage(driver);
    	 
    	 
    	 logger.info("Providing customer details ");
	     Rp.setFirstName(randomeString());
	     Thread.sleep(2000);
	     Rp.setLastName(randomeString());
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("lthirupathamma@gmail.com");
	     Thread.sleep(2000);
	     Rp.setPhone(randomeNumber());
	     Thread.sleep(2000);
	     Rp.setPassword(randomeAlphaNumber());
	     Thread.sleep(2000);
	     Rp.setConfirmPassword(randomeAlphaNumber());
	     Rp.clickYesButton();
	     Rp.clickCheckBox();
	     Rp.clickContinue();
	     
	     WebElement EmailWarningMSG = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
    	 
	     Assert.assertEquals(EmailWarningMSG.getText(),"Warning: E-Mail Address is already registered!");
	     logger.info("************** Finished TC007_AccountRegistrationWithExistingEmail ***********");
	     
     }
}
