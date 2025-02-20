package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.Homepage;
import pageObjects.MyaccountPage;
import testBase.BaseClass;

public class TC005_AccountRegistrationByClickingNoNewsLetter extends BaseClass {
	
     @Test
	 public void VerifyAccountRegistrationWithNoNewsLetter() throws InterruptedException 
     {
		 
			  
		   logger.info("********* Staring TC005_AccountRegistrationTest To click No NewsLetter    ******");  
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
    	   Rp.clickNoButton();
    	   Rp.clickCheckBox();
    	   Rp.clickContinue();
    	   
    	   
    	   MyaccountPage Mypage=new MyaccountPage(driver);
    	   Mypage.VerifyNewsLatter();
    	   
    	   driver.findElement(By.xpath("//input[@value='0']")).click();

    	   driver.findElement(By.xpath("//input[@value='Continue']")).click();
    	   
    	   String expectedText = "Success: Your newsletter subscription has been successfully updated!";
    	   
    	   Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText(),  expectedText);

    	   logger.info("********* Finished TC005_AccountRegistrationTest To click No NewsLetter    ******");  
     }
}