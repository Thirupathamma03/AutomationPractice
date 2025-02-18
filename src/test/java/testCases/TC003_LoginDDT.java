package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.MyaccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/* Data is valid -login Success -test pass -logout
 * Data is valid -login is Failed -test fail
 * Data is invalid --login success -test fail
 * Data is invalid --login fail -test pass
 */
public class TC003_LoginDDT   extends BaseClass 
{
      @Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="DataDriven")	//dataProviderClass=DataProvider.class   getting another package or class that time only we use 
      
      public void Verify_loginDDT(String email, String  pwd, String exp ) {
    	 
    	logger.info("*****  Starting TC_003_Login_DDT  *****"); 
    	
    	try {
    	// home page  
    	Homepage hp=new Homepage(driver);
  		hp.clickMyAccount();
  		
  		logger.info("*****  click My Account  *****");
  		
  		hp.clickLogin();
  		logger.info("*****  click on Login  *****");
  		
  		
  		//login page
  		
  		LoginPage lp=new LoginPage(driver);
  		
  		lp.setEmail(email);
  		lp.setPassword(pwd);
  		lp.clickLogin();
  		
  		
  		//MyAccount
  	    MyaccountPage Mypage=new MyaccountPage(driver);
  	    boolean targetPage=Mypage.isMyAccountPageExists();
  	    
  	    if(exp.equalsIgnoreCase("valid")) {
  	    	if(targetPage==true) {
  	    		Mypage.ClickLogout();
  	    		Assert.assertTrue(true);
  	    		
  	    	}
  	    	else
  	    	{
  	    		Assert.assertTrue(false);
  	    	}
  	    }
  	    
  	    if(exp.equalsIgnoreCase("Invalid")) {
  	    	if(targetPage==true) {
  	    		Mypage.ClickLogout();
  	    		Assert.assertTrue(false);
  	    	}
  	    	else {
  	    		Assert.assertTrue(true);
  	    	}
  	    }
    	}catch(Exception e) {
    		Assert.fail();
    	}
  	    
  	  logger.info("*****  Finished TC_003_Login_DDT  *****");
      }
	
	
}
