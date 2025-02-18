package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import testBase.BaseClass;

public class LoginPage   extends BaseClass {
      
	WebDriver driver;
    
	//constructor
	public LoginPage(WebDriver driver)
	{
	   super();	
	   this.driver=driver;	
	}
      
	
	
	By emailBox=By.name("email");
	By PwdBox=By.name("password");
	By clickLogin=By.xpath("//input[@value='Login']");
	
	public void setEmail(String email){
		driver.findElement(emailBox).sendKeys(email);;
	}
	
	public void setPassword(String pwd){
		driver.findElement(PwdBox).sendKeys(pwd);;
	}
	
	public void clickLogin(){
		driver.findElement(clickLogin).click();
	}
	
}
