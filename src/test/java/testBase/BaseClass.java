package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; //log4j
import org.apache.logging.log4j.Logger; //log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;



public class BaseClass  {
   public  static WebDriver driver;
   protected WebDriverWait wait;
   public Logger logger;  //Log4j
   public Properties p;
  
   
	
  
  @BeforeClass(groups={"sanity","Regression","Master"})
  @Parameters({"os","browser"})
  public void setup(@Optional("Windows") String os, @Optional("chrome") String br) throws IOException 
  {
	
	
	//Loading config.properties file
	p=new Properties();
	FileReader file=new FileReader("./src/test/resources/config.properties");
	p.load(file);
	  
	logger=LogManager.getLogger(this.getClass());	// it will generate the logs on every test case.  
	logger.info("Initializing driver...");
	
	
	if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
	{
		
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		if(os.equalsIgnoreCase("windows")) 
		{
		 capabilities.setPlatform(Platform.WIN11);
		}
		else if (os.equalsIgnoreCase("mac"))
		{
			capabilities.setPlatform(Platform.MAC);		
		}
		else
		{
		    System.out.println("No Matching os");
		    return;
		}
		
		//browser 
		switch(br.toLowerCase()) 
		{
		case"chrome" :capabilities.setBrowserName("chrome"); break;
		case"edge" :capabilities.setBrowserName("MicrosoftEdge"); break;
		default:System.out.println("No Matching browser");return;
		}
		
		driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
	}
	
	if(p.getProperty("execution_env").equalsIgnoreCase("local"))
	{
	switch(br.toLowerCase())
	{
	case "chrome":driver=new ChromeDriver();  break;
	case "edge":driver=new EdgeDriver(); break;
	case"firefox":driver=new FirefoxDriver();break;
	default: System.out.println("Invalid browser name... "); return;
	}
	
	}
	
	
    driver=new ChromeDriver();
    wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get(p.getProperty("appURL"));  //Reading from Properties file
    
    driver.manage().window().maximize();
    logger.info("Driver initialized successfully.");
    
  }
  
	  @AfterClass(groups={"sanity","Regression","Master"})
  public void teardown() 
  {
 	  driver.quit(); 
  }
	 
	  public  String randomeString() {
		  String generatedstring = RandomStringUtils.randomAlphabetic(6);
		  return generatedstring;
		  
	 }
	  public String randomeNumber() {
		  String Randomnum = RandomStringUtils.randomNumeric(10);
		  return Randomnum;
	  }
	  
	  public String randomeAlphaNumber() 
	  {
		  String genaratedString =RandomStringUtils.randomAlphabetic(3);
		  String genaratednumber=RandomStringUtils.randomNumeric(3);
		  return (genaratedString+"@"+genaratednumber);
		  
		  
	  }
	  
	  public String captureScreen(String tname) {
		  String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		  TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		  File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
		  
		  String targetFilePath=System.getProperty("user.dir"+"\\screenshots\\"+tname+"_"+timeStamp);
		  File targetFile=new File(targetFilePath);
		  
		  sourceFile.renameTo(targetFile);
		  
		  return targetFilePath;
	  }
      
}
