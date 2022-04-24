package dataprovidertestng;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IndexHtmlData {
	
	 WebDriver driver;
		
		@BeforeSuite(groups = "abc")
		  public void openBrowser() {
			System.out.println("this is a chrome driver");
			System.setProperty("webdriver.chrome.driver", "C:/Users/minak/Documents/Minakshi/webDriver/98_chromeDriver/chromedriver.exe");
			
			driver = new ChromeDriver();
			
		  }
		
		@BeforeTest(groups = "abc")
		  public void getUrl() {
			
			driver.get("file:///C:/Users/minak/Desktop/index.html");
		  }
		
		@BeforeClass (groups = "abc")
		  public void maximize() {
			driver.manage().window().maximize();
			
		  }
		
		 @BeforeMethod (groups = "abc")
		  public void getAllCookies() {
			Set<Cookie> cookies = driver.manage().getCookies();
			int count = cookies.size();
			System.out.println("total cookies count is ---"+count);
			 
		  }
		 

		 @Test(groups = "abc")
		 
	  public void loginFunctionality() throws InterruptedException {
		  driver.findElement(By.className("username")).sendKeys("CJC");
		  driver.findElement(By.className("pass")).sendKeys("CJC@123");
		  driver.findElement(By.className("login")).submit();
//		  Thread.sleep(3000);
//		  driver.navigate().back();
//		  Thread.sleep(3000);
//		  driver.findElement(By.id("uid")).clear();;
//		  driver.findElement(By.id("pid")).clear();;
	  }
	 

	  @AfterMethod(groups = "abc")
	  public void screenshot() throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;
		File src1 = new File("C:\\Users\\minak\\Documents\\Minakshi\\index");
	    FileUtils.copyFileToDirectory(src, src1);
		  
	  }

	  @AfterClass(groups = "abc")
	  public void deletCookies() {
		  System.out.println("delet cookies");
		  
	  }

	  
	  @AfterTest(groups = "abc")
	  public void dbClose() {
		  System.out.println("db close");
	  }

	  @AfterSuite(groups = "abc")
	  public void afterSuite() {
//		  driver.close();
		  
	  }


	}

  

