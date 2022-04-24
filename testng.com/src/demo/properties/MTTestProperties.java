package demo.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
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
import org.testng.annotations.Test;

public class MTTestProperties {
	
           WebDriver driver;
           Properties pro = new Properties();
	
	@BeforeSuite
	  public void openBrowser() throws IOException {
		  System.out.println("This is chrome browser-----------");
		  
		  System.setProperty("webdriver.chrome.driver", "C:/Users/minak/Documents/Minakshi/webDriver/98_chromeDriver/chromedriver.exe");
			
		 driver = new ChromeDriver();
		 
		FileInputStream fis = new FileInputStream("C:\\Users\\minak\\Documents\\Minakshi\\Poperties_Demo\\MTTest.properties"); 
		pro.load(fis);
			
	  }
	 @BeforeTest
	  public void getUrl() {
		 System.out.println("Before Test");
		 System.out.println("URL --"+pro.getProperty("url"));
		 driver.get(pro.getProperty("url"));
		  
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

	// input data using properties file 

  @Test
  public void loginFunctionality2() throws InterruptedException {
	  
	    driver.findElement(By.name(pro.getProperty("Name"))).sendKeys("abcd@gmail.com");
		driver.findElement(By.name(pro.getProperty("Pass"))).sendKeys("abcd123");
		
		driver.findElement(By.name(pro.getProperty("Submit"))).click();
		Thread.sleep(1000);
		

	  
	  
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
