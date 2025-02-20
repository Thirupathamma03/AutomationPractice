package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import testBase.BaseClass;

public class MyaccountPage extends BaseClass {
       
    WebDriver driver;
    
	//constructor
	public MyaccountPage (WebDriver driver)
	{
	   super();	
	   this.driver=driver;	
	}
	
	By Accountpage=By.xpath("//h2[text()='My Account']");
	
	By logout=By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']");
	
	By Newslatter=By.xpath("//ul[@class='list-unstyled']//a[text()='Newsletter']");
	
	public boolean isMyAccountPageExists() {
		try {
		return driver.findElement(Accountpage).isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	
	
	public void ClickLogout() {
		driver.findElement(logout).click();
	}
	
	public void VerifyNewsLatter() {
		driver.findElement(Newslatter).click();
	}
}
