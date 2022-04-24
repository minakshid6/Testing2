package dataprovidertestng;

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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoWebShopLogin {
	  WebDriver driver;
		
	  @BeforeSuite
	  public void openBrowser() {
		  
		  System.setProperty("webdriver.chrome.driver", "C:/Users/minak/Documents/Minakshi/webDriver/98_chromeDriver/chromedriver.exe");
			
			 driver = new ChromeDriver();
	  }
	
	
	@BeforeTest
	  public void getUrl() {
		driver.get("http://demowebshop.tricentis.com");
	  }

	@BeforeClass
	  public void maximize() {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
	  }
	
	@BeforeMethod
	  public void getAllCookie() {
		
		Set<Cookie> cookies = driver.manage().getCookies();
		int count = cookies.size();
		System.out.println("total cookies count is ---"+count);
		 
	  }
	
	
	
  @Test(dataProvider = "getData")
  public void f(String email,String pass) throws InterruptedException 
  {
	  driver.findElement(By.xpath("//a[@href='/login']")).click();
	  driver.findElement(By.id("Email")).sendKeys(email);
	  driver.findElement(By.id("Password")).sendKeys(pass);
	  driver.findElement(By.xpath("//input[@class='button-1 login-button']")).submit();
	  driver.navigate().back();
	  Thread.sleep(1000);
	  
	  driver.findElement(By.id("Email")).clear();
	  driver.findElement(By.id("Password")).clear();
	  
	 
  }
  
  @AfterMethod
  public void screenShot() throws IOException {
	    File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;
		File src1 = new File("C:\\Users\\minak\\Documents\\Minakshi\\DemoWeb");
	    FileUtils.copyFileToDirectory(src, src1);
	  
  }

  @AfterClass
  public void deletAllCookie() {
	  System.out.println("delet cookies");
  }
 
  @AfterTest
  public void dbClose() {
	System.out.println("db close");  
	  
  }
  
  @AfterSuite
  public void afterSuite() {
//	  driver.close();
  }
  
  
  @DataProvider
  public Object[][] getData() {
	  
    return new Object[][] 
    		{
      new Object[] { "aaaa_aaaa@yahoo.com" ,"xyz123456" },
      
      new Object[] {"b_b_b_b@yahoo.com" ,"xyz123456"}
     
            };
        
        
  }
  

}

