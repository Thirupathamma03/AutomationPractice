package SampleTestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class login {
WebDriver driver;
	
	@BeforeClass
	public  void setup()
	{  
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
	
	
	//@Test
	 
	
//	public  void testLogin() throws InterruptedException
//	{
//		LoginPage lp=new LoginPage(driver);
//		lp.setUserName("Admin");
//		Thread.sleep(2000);
//		
//		lp.setpassword("admin123");
//		Thread.sleep(2000);
//		
//		lp.click_login(null);
//		Thread.sleep(2000);
//		
//		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
//		
//		
//		
//		
//	
//	}
//	
//	@AfterClass
//	public  void teardown()
//	{
//		driver.quit();
//	}

}
