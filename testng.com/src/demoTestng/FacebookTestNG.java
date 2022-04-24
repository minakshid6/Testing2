package demoTestng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class FacebookTestNG {
	WebDriver driver ;
	 @BeforeSuite
	  public void openBrowser() {
			 
		  System.setProperty("webdriver.chrome.driver", "C:/Users/minak/Documents/Minakshi/webDriver/98_chromeDriver/chromedriver.exe");
		 driver = new ChromeDriver();
	  }
	 @BeforeTest
	  public void getUrl() {
		  
		  driver.get("https://www.facebook.com/");
		  
	  }
	 @BeforeClass
	    public void maximize() {
		  
		  driver.manage().window().maximize();

		  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
	  }
	 @BeforeMethod
	  public void screenShotBeforeLogin() throws IOException {
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File src1 = new File("C:\\Users\\minak\\Documents\\Minakshi\\fbtestng_Before.png");
			FileUtils.copyFile(src, src1);
			  
		  }
  @Test
  public void login() throws InterruptedException {
	  driver.findElement(By.id("email")).sendKeys("abcd@gmail.com");
	  Thread.sleep(1000);
	  driver.findElement(By.id("pass")).sendKeys("jinal1234567");
	  
	  driver.findElement(By.xpath("//button[@name='login']")).click();
	Assert.assertEquals("Fail", "Fail");
  }
 
//  @Test
//  public void login1() throws InterruptedException {
//	  driver.findElement(By.id("email")).sendKeys("abcd1@gmail.com");
//	  Thread.sleep(1000);
//	  driver.findElement(By.id("pass")).sendKeys("jinal1234567");
//	
//	  driver.findElement(By.xpath("//button[@name='login']")).click();
//	Assert.assertEquals("Fail", "Fail");
//  }
  @AfterMethod
  public void screenShotAfterLogin() throws IOException {
	  File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File src1 = new File("C:\\Users\\minak\\Documents\\Minakshi\\fbtestng_After");
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
  public void driverClose() {
	  
//	  driver.close();
  }

}
