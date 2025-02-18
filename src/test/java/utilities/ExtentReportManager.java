package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {
       
	public static  ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	String repName;
	
	public void onStart(ITestContext testContext) {
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		
		repName="Test-Report-"+timeStamp+".html";
		
		String reportPath = System.getProperty("user.dir") + "\\reports\\" + repName;
		
		sparkReporter = new ExtentSparkReporter(reportPath);
		sparkReporter.config().setDocumentTitle("opencart Automation Report");
		sparkReporter.config().setReportName("opencart Functional Testing ");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application","opencart");
		extent.setSystemInfo("Module","Admin");
		extent.setSystemInfo("Sub Module","Customers");
		extent.setSystemInfo("User Name",System.getProperty("user.name"));
		extent.setSystemInfo("Environment","QA");
		
		String os=testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);
		
		String browser=testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		List<String> includedGroups=testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
			extent.setSystemInfo("Groups", includedGroups.toString());
		}
		
	    }
		
	  public void onTestSuccess(ITestResult result) {
			test=extent.createTest(result.getTestClass().getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.PASS, result.getName()+"got successfully executed");
			
	  }
	  
	  public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.FAIL, result.getName()+"got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
	    
		String imgPath=new BaseClass().captureScreen(result.getName());
		test.addScreenCaptureFromPath(imgPath);
	    }
	  
		public void onTestSkipped(ITestResult result) {
			
		     test=extent.createTest(result.getTestClass().getName());
		     test.assignCategory(result.getMethod().getGroups());
		     test.log(Status.SKIP, result.getName()+"got skipped");
		     test.log(Status.INFO, result.getThrowable().getMessage());
		}
		
		
		
		public void onFinish(ITestContext testContext) {
		    extent.flush();

		    String pathOfExtentReport = System.getProperty("user.dir") + "\\reports\\" + repName;
		    File extentReport = new File(pathOfExtentReport);

		    try {
		        if (extentReport.exists()) {
		            Desktop.getDesktop().browse(extentReport.toURI());  // Corrected usage
		        } else {
		            System.out.println("Report file not found: " + pathOfExtentReport);
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		
		
	/*try {
		
		URL url=new URL("file:///"+System.getProperty("user.dir")+"\\reports\\"+repName);
		
		//Create the email message
		ImageHtmlEmail email=new ImageHtmlEmail();
		
		email.setDataSourceResolver(new DataSourceUrlResolver(url));
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("LakhmiThirupathamma@gmail.com","test123"));
		email.setSSLOnConnect(true);
		email.setFrom("LakshmiThirupathamma@gmail.com");//  Sender
		email.setSubject("Test Result");
		email.setMsg("Please find Attached Reported.....");
		email.addTo("lthirupathamma3@gmail.com");
		email.attach(url,"extent report", "please check report....");
		email.send();// send the email 
      } catch(Exception e) {
    	  e.printStackTrace();
      }
      */   //this is send email to all people in the project. it is a sample demo. you need future you search on chatgpt. 
		
		
}
}
	

