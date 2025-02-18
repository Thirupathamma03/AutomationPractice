package testCases;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.MyaccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
     
	@SuppressWarnings("null")
	@Test(groups={"Sanity","Master"})
	public void verify_login() {
		logger.info("*****  Starting Tc_002_LoginTest *****");
		
		//homepage
		try {
			
		logger.info("*****  click My Account  *****");	
		Homepage hp=new Homepage(driver);
		hp.clickMyAccount();
		logger.info("*****  click My Account  *****");
		hp.clickLogin();
		logger.info("*****  click on Login  *****");
		
		
		//login page
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		
		//MyAccount
	    MyaccountPage Mypage=new MyaccountPage(driver);
	    boolean targetPage=Mypage.isMyAccountPageExists();
	    
	    
	    //we can write also like this  
	    Assert.assertTrue(targetPage);
	    //or  //Assert.assertEquals(targetPage, true,"Login Failed");
		}
		catch(Exception e) {
			Assert.fail();
		}
	    
	    logger.info("*****  Finished Tc_002_LoginTest *****");
	    
	    
	    
	}
}
