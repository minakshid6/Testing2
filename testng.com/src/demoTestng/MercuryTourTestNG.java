package demoTestng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class MercuryTourTestNG {
	
//ACCORDING TO TEST NG SEQUENCE	
	
	WebDriver driver;
	
	@BeforeSuite
	  public void openBrowser() {
		  
		  System.setProperty("webdriver.chrome.driver", "C:/Users/minak/Documents/Minakshi/webDriver/98_chromeDriver/chromedriver.exe");
			
			 driver = new ChromeDriver();
			
			
	  }
	 @BeforeTest
	  public void getUrl() {
		  driver.get("https://demo.guru99.com/test/newtours/");
	  }

	 @BeforeClass
	  public void maximizeBrowser() {
		  
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			  
	  }
	 @BeforeMethod
	  public void getAllCookies() {
		  
		 Set<Cookie> cookies = driver.manage().getCookies();
		 int count = cookies.size();
		 System.out.println("number of cookies--"+count);
	  }
	 
	 
	 
  @Test
  public void loginFunctionality() {
	  
	    driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("abcd@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("abcd123");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		driver.navigate().back();
		
	  
	  
  }
  @Test
  public void loginFunctionality2() {
	  
	    driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("abcd1@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("abcd123");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		driver.navigate().back();
	  
	  
  }

  @AfterMethod
  public void screenshot() throws IOException {
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File src1 = new File("C:\\Users\\minak\\Documents\\Minakshi\\mercury_After.png");
	FileUtils.copyFile(src, src1); 
	  
  }

 

  @AfterClass
  public void deletCookies() {
	  System.out.println("delet cookies");
	  
  }

 
  @AfterTest
  public void dbClose() {
	  
	  System.out.println("db close");
  }

  
  @AfterSuite
  public void closeDriver() {
	  driver.close();
  }

}
