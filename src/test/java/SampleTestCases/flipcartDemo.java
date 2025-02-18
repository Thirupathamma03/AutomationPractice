package SampleTestCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class flipcartDemo{
	
    @SuppressWarnings("unlikely-arg-type")
	@Test
	static void BookTickets() throws InterruptedException {
		
	
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://www.flipkart.com/?s_kwcid=AL!739!3!676201929245!b!!g!!flipkart&gclsrc=aw.ds&&semcmpid=sem_8024046704_brand_exe_buyers_goog&gad_source=1&gclid=CjwKCAiA5Ka9BhB5EiwA1ZVtvG4NU9SBP1iZtWM8ZLWYpyeCSUyX4SZQ975OL2BVlTuT12k_WHmwwhoCOLEQAvD_BwE");
        
		
		        
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 Actions action = new Actions(driver);
		        
		        try {
		            
		        	driver.get("https://www.flipkart.com/?s_kwcid=AL!739!3!676201929245!b!!g!!flipkart&gclsrc=aw.ds&&semcmpid=sem_8024046704_brand_exe_buyers_goog&gad_source=1&gclid=CjwKCAiA5Ka9BhB5EiwA1ZVtvG4NU9SBP1iZtWM8ZLWYpyeCSUyX4SZQ975OL2BVlTuT12k_WHmwwhoCOLEQAvD_BwE");
		            
		        	Thread.sleep(5000);
		        	
		        	
		             //Click the Flight Bookings
		            WebElement flightBooking = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='Flight Bookings']")));
		            flightBooking.click();
		            
		            // Select Departure City
		            WebElement fromBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='0-departcity']")));
		            fromBox.clear();
		            fromBox.click();
		            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Hyderabad')])[1]"))).click();
		            
		            // Select Arrival City
		            WebElement toBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='0-arrivalcity']")));
		            toBox.clear();
		            toBox.click();
		            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Bangkok')])[2]"))).click();
		            
//		            // Select Date
		            String month = "April 2025";
		            String date = "20";

		            WebElement datePicker = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='0-datefrom']")));
		            datePicker.click();

		            while (true) {
		                WebElement currentMonth = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_1w7bXX']")));
		                if (currentMonth.getText().trim().equals(month)) break;
		                
		                WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='R0r93E'])[2]")));
		                nextButton.click();
		            }
                     
		            Thread.sleep(4000);
		            
		            List<WebElement> dates = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tbody//tr//td/div/button[@class='pl8ttv']")));
		            for (WebElement dt : dates) {
		                if (dt.getText().trim().equals(date)) {
		                    dt.click();
		                    break;
		                }
		            }

		            // Select Travelers
		            WebElement travelerBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='0-travellerclasscount']")));
		            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", travelerBox);

		            WebElement adultTicketsAdd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ddniwG S0EQss']//div[1]//div[2]//div[1]//div[3]//button[1]//*[name()='svg']")));
		            WebElement childTicketsAdd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='s+8PCn t6x2xH _9zHVSK _5XbPZt eTQwh+']//div[2]//div[2]//div[1]//div[3]//button[1]//*[name()='svg']")));
		            WebElement clickDone = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Done']")));

		            action.moveToElement(adultTicketsAdd).click().perform();
		            action.moveToElement(childTicketsAdd).click().perform();
		            action.moveToElement(clickDone).click().perform();

		            // Click on Search
		            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='SEARCH']")));
		            searchButton.click();
		            
		            // Wait to observe results
		            Thread.sleep(4000);

		        } catch (Exception e) {
		            System.out.println("Error: " + e.getMessage());
		        } finally {
		            driver.quit();
		        }
		    }
		}
		
		
		//Click the flight Booking 
		
//		driver.findElement(By.xpath("//img[@alt='Flight Bookings']")).click();
//		Thread.sleep(2000);
		
//		WebElement fromBox = driver.findElement(By.xpath("//input[@name='0-departcity']"));
//		fromBox.clear();
//		
//		fromBox.click();
//		Thread.sleep(2000);
//		
//		driver.findElement(By.xpath("(//span[contains(text(),'Hyderabad')])[1]")).click();
//		
//		Thread.sleep(2000); // Wait for suggestions to appear
//
//		
//		
//		WebElement To_Box = driver.findElement(By.xpath("//input[@name='0-arrivalcity']"));
//		To_Box.clear();
//		
//		To_Box.click();
//		Thread.sleep(2000);
//		
//		
//		driver.findElement(By.xpath("(//span[contains(text(),'Bangkok')])[2]")).click(); 
//		Thread.sleep(2000);
//
//		
//
// // Click after ensuring visibility
//
//		
//		
//		Thread.sleep(2000);   
//		
//
//		
//		String month = "April 2025";
//		String date = "25";
//
//		// Click the date picker
//		driver.findElement(By.xpath("//input[@name='0-datefrom']")).click();
//		Thread.sleep(2000); // Wait for calendar to appear
//
//		// Loop to navigate months
//		while (true) {
//		    WebElement current_month = driver.findElement(By.xpath("//div[@class='_1w7bXX']"));
//		    System.out.println("Current Month: " + current_month.getText()); // Debugging
//
//		    if (current_month.getText().trim().equals(month)) {
//		        break; // Stop when the correct month is found
//		    }
//
//		    // Click "Next" button
//		    driver.findElement(By.xpath("(//button[@class='R0r93E'])[2]")).click();
//		    Thread.sleep(2000); // Wait for UI update
//		}
//
//		// Select the date
//		List<WebElement> dates = driver.findElements(By.xpath("//tbody//tr//td/div/button[@class='pl8ttv']"));
//
//		for (WebElement dt : dates) {
//		    //System.out.println("Available Date: " + dt.getText()); // Debugging
//
//		    if (dt.getText().trim().equals(date)) {
//		        dt.click();
//		        break; // Stop after clicking the date
//		    }
//		}
//        
//		// select the travelers
//		WebElement travelerBox = driver.findElement(By.xpath("//input[@name='0-travellerclasscount']"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", travelerBox);
//		
//		WebElement adultTicketsadd = driver.findElement(By.xpath("//div[@class='ddniwG S0EQss']//div[1]//div[2]//div[1]//div[3]//button[1]//*[name()='svg']"));
//		
//		WebElement childTicketsadd=driver.findElement(By.xpath("//div[@class='s+8PCn t6x2xH _9zHVSK _5XbPZt eTQwh+']//div[2]//div[2]//div[1]//div[3]//button[1]//*[name()='svg']"));
//		
//		WebElement ClickDone=driver.findElement(By.xpath("//button[normalize-space()='Done']"));
//		
//		
//		
//		action.moveToElement(adultTicketsadd).click().perform();
//		action.moveToElement(childTicketsadd).click().perform();
//		action.moveToElement(ClickDone).click().perform();
//		
//		driver.findElement(By.xpath("//span[normalize-space()='SEARCH']")).click();
//		
//		// Wait for 4 seconds (for debugging purposes)
//		Thread.sleep(4000);
//		
//		
//
//
//
//		
//		
//		
//		
//		
//		
//		driver.close();
//	}
