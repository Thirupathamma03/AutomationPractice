package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



import testBase.BaseClass;

public class Homepage extends BaseClass{

       WebDriver driver;

	
	public Homepage(WebDriver driver)
	{
		super();
		this.driver=driver;
	}
    
	By clickmyAccount=By.xpath("//span[normalize-space()='My Account']");
	By clickRegistration=By.xpath("//a[normalize-space()='Register']");	
	By clickLogin=By.linkText("Login");
	
	public void clickMyAccount() {
		driver.findElement(clickmyAccount).click();
	}
	
	public void clickRegistration() {
		driver.findElement(clickRegistration).click();
	}
	
	public void clickLogin() {
		driver.findElement(clickLogin).click();
	}

	
	
}
