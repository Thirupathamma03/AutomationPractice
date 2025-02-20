package pageObjects;

import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import testBase.BaseClass;

public class AccountRegistrationPage extends BaseClass {
	
	        WebDriver driver;
	        
	        public AccountRegistrationPage(WebDriver driver)
        	{
		      super();
		      this.driver=driver;
		
	        }
	       
	        
		    

		    // Locators
		    private By fname = By.xpath("//input[@id='input-firstname']");
		    private By lname = By.xpath("//input[@id='input-lastname']");
		    private By email = By.xpath("//input[@id='input-email']");
		    private By phone = By.xpath("//input[@id='input-telephone']");
		    private By pws = By.xpath("//input[@id='input-password']");
		    private By confirmPws = By.xpath("//input[@id='input-confirm']");
		    private By btn = By.xpath("//label[normalize-space()='Yes']");
		    private By No_btn=By.xpath("//input[@value='0']");
		    private By checkBox = By.xpath("//input[@name='agree']");
		    private By click = By.xpath("//input[@value='Continue']");
		    private By confirmMsg = By.xpath("//h1[normalize-space()='Your Account Has Been Created!']");

		    // Methods
		    public void setFirstName(String firstname) {
		        driver.findElement(fname).sendKeys(firstname);
		    }

		    public void setLastName(String lastname) {
		        driver.findElement(lname).sendKeys(lastname);
		    }

		    public void setEmail(String Email) {
		        driver.findElement(email).sendKeys(generateNewEmail());
		    }
		    
		    

		    public void setPhone(String phoneNumber) {
		        driver.findElement(phone).sendKeys(phoneNumber);
		    }

		    public void setPassword(String password) {
		        driver.findElement(pws).sendKeys(password);
		    }

		    public void setConfirmPassword(String confirmPassword) {
		        driver.findElement(confirmPws).sendKeys(confirmPassword);
		    }

		    public void clickYesButton() {
		        driver.findElement(btn).click();
		    }
		    
		    public void clickNoButton() {
		        driver.findElement(No_btn).click();
		    }

		    public void clickCheckBox() {
		        driver.findElement(checkBox).click();
		    }

		    public void clickContinue() {
		        driver.findElement(click).click();
		    }

		    public String getConfirmMsg() {
		        try {
		            return driver.findElement(confirmMsg).getText();
		        } catch (Exception e) {
		            return e.getMessage();
		        }
		    }

		    public String generateNewEmail() {
		        return "user" + System.currentTimeMillis() + "@gmail.com";
		    }
		}

		

	
	
	

