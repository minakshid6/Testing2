package dataprovidertestng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class IndexHtmlDataProvider {
	
	      WebDriver driver;
	
	@BeforeSuite
	  public void openBrowser() {
		System.out.println("this is a chrome driver");
		System.setProperty("webdriver.chrome.driver", "C:/Users/minak/Documents/Minakshi/webDriver/98_chromeDriver/chromedriver.exe");
		
		driver = new ChromeDriver();
		
	  }
	
	@BeforeTest
	  public void getUrl() {
		
		driver.get("file:///C:/Users/minak/Desktop/index.html");
	  }
	
	@BeforeClass
	  public void maximize() {
		driver.manage().window().maximize();
		
	  }
	
	 @BeforeMethod
	  public void getAllCookies() {
		Set<Cookie> cookies = driver.manage().getCookies();
		int count = cookies.size();
		System.out.println("total cookies count is ---"+count);
		 
	  }
	 
  @Test(dataProvider = "getData")
  public void loginFunctionality(String uname, String pass) throws InterruptedException {
	  driver.findElement(By.className("username")).sendKeys(uname);
	  driver.findElement(By.className("pass")).sendKeys(pass);
	  driver.findElement(By.className("login")).submit();
	  Thread.sleep(3000);
	  driver.navigate().back();
	  Thread.sleep(3000);
	  driver.findElement(By.id("uid")).clear();;
	  driver.findElement(By.id("pid")).clear();;
  }
 

  @AfterMethod
  public void screenshot() throws IOException {
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;
	File src1 = new File("C:\\Users\\minak\\Documents\\Minakshi\\index");
    FileUtils.copyFileToDirectory(src, src1);
	  
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
  public void afterSuite() {
//	  driver.close();
	  
  }

  
  @DataProvider
  public Object[][] getData() {
    return new Object[][] 
    		{
    	
      new Object[] { "QQQQ", "qqqq" },
      new Object[] { "AAAA", "aaaa" },
      new Object[] { "PPPP", "pppp" },
      new Object[] { "RRRR", "rrrr" },
      new Object[] { "WWWW", "wwww" },
            };
            
            
  }
  

 

  

 
  

 
}
