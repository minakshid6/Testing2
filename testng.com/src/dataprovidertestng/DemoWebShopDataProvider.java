package dataprovidertestng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
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

public class DemoWebShopDataProvider {
	
	   WebDriver driver;
	
	  @BeforeSuite
	  public void openBrowser() {
		  
		  System.setProperty("webdriver.chrome.driver", "C:/Users/minak/Documents/Minakshi/webDriver/98_chromeDriver/chromedriver.exe");
			
			 driver = new ChromeDriver();
	  }
	
	
	@BeforeTest
	  public void getUrl() {
		driver.get("http://demowebshop.tricentis.com/register");
	  }

	@BeforeClass
	  public void maximize() {
		driver.manage().window().maximize();
	  }
	
	@BeforeMethod
	  public void getAllCookie() {
		
		Set<Cookie> cookies = driver.manage().getCookies();
		int count = cookies.size();
		System.out.println("total cookies count is ---"+count);
		 
	  }
	
	
	
  @Test(dataProvider = "getData")
  public void f(String fname, String lname,String email,String pass,String cpass) throws InterruptedException 
  {
	  driver.findElement(By.id("gender-male")).click();
	  driver.findElement(By.id("FirstName")).sendKeys(fname);
	  driver.findElement(By.id("LastName")).sendKeys(lname);
	  driver.findElement(By.id("Email")).sendKeys(email);
	  driver.findElement(By.id("Password")).sendKeys(pass);
	  driver.findElement(By.id("ConfirmPassword")).sendKeys(cpass);
	  Thread.sleep(1000);
	  driver.findElement(By.id("register-button")).submit();
	  Thread.sleep(1000);
	  driver.navigate().back();
	  Thread.sleep(3000);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	  driver.findElement(By.id("gender-male")).clear();
	  driver.findElement(By.xpath("//input[@name='FirstName']")).clear();
	  driver.findElement(By.xpath("//input[@id='LastName']")).clear();
	  driver.findElement(By.xpath("//input[@name='Email']")).clear();
	  
//	  driver.findElement(By.id("Password")).clear();;
//	  driver.findElement(By.id("ConfirmPassword")).clear();;
//	  driver.findElement(By.id("Email")).clear();
	  
	 
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
      new Object[] { "AAAA" ,"aaaa", "xm_mx_bv@yahoo.com" ,"xyz123456","xyz123456" },
      
      new Object[] {"BBBB" ,"bbbb", "b_b_b_b@yahoo.com" ,"xyz123456","xyz123456"}
     
            };
        
        
  }
  

}
