package core;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Page 
{
	
	public static WebDriver driver = null;
	public static ExtentReports report = null;
	public static ExtentTest test = null;
	
	public void openBrowser(String browser,String url) // define
	{
		
		String reportpath = System.getProperty("user.dir")+"\\src\\test\\java\\reports\\AmazonReport.html";
	    report = new ExtentReports(reportpath);
	    test = report.startTest("AmazonReport");
		
		 if(browser.equalsIgnoreCase("chrome"))
		 {
			 driver = new ChromeDriver();
		 }
		 else if(browser.equalsIgnoreCase("edge"))
		 {
			 driver = new EdgeDriver();
		 }
		 else if(browser.equalsIgnoreCase("firefox"))
		 {
			 driver = new FirefoxDriver();
		 }
		
		 driver.navigate().to(url); // prefer - can go back / forward 
		
		 PageFactory.initElements(driver, this); // compulsory to read external xpath
			
		 
		 // implicit wait..
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20L));
			
		 driver.manage().window().maximize();
	}
	
	public static void closeBrowser()
	{
		report.endTest(test);
		report.flush();
		driver.quit();
	}

}
