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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class DemoWebShopTestng {
	
	  WebDriver driver;
	  
	@BeforeSuite
	  public void openBrowser() 
	  { 
		
		  System.setProperty("webdriver.chrome.driver", "C:/Users/minak/Documents/Minakshi/webDriver/98_chromeDriver/chromedriver.exe");
	 
		  driver = new ChromeDriver();
	  }
	
	@BeforeTest
	  public void getUrl() 
	  {
		  driver.get("http://demowebshop.tricentis.com");
		  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS );
			
	  }
	
	 @BeforeClass
	  public void maximize()
	  {
		  driver.manage().window().maximize();
	  }
	 
	 @BeforeMethod
	  public void beforeMethod() 
	 {
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 System.out.println("implicite wait");
     }
	 
  @Test(priority =1)
  public void registerFunctionality()
  {
	  
	    driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.xpath("//input[@id='gender-female']")).click();
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("jinal");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Dhakite");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("DDDD@yahoo.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456789");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123456789");
		driver.findElement(By.xpath("//input[@id='register-button']")).click();
  }
  
  @Test(priority =2)
  public void addToCart() throws InterruptedException 
  {
	  
      driver.findElement(By.linkText("Books")).click();
      driver.findElement(By.cssSelector("img[alt ='Picture of Computing and Internet']")).click();
      driver.findElement(By.cssSelector("input#add-to-cart-button-13")).click();
	  driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
	  driver.findElement(By.xpath("//button[@id='checkout']")).click();
	  
	  
  }
  @Test(priority =3)
  public void billingAddress() 
  {
	  WebElement element = driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"));
	    Select sel = new Select(element);
	    sel.selectByValue("41");
	    driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']")).sendKeys("Nagpur");
	    driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']")).sendKeys("main street");
		driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']")).sendKeys("75032");
		driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']")).sendKeys("9999999999");
		driver.findElement(By.xpath("//div/child::input[@onclick='Billing.save()']")).click();
	  
  }
  
  @AfterMethod
   public void screenshot() throws IOException 
  {
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File src1 = new File("C:\\Users\\minak\\Documents\\Minakshi\\WebDemo_After.png");
			FileUtils.copyFile(src, src1); 
			  
  }

  @AfterClass
  public void afterClass() 
  {
	  System.out.println("delete cookies");
  }

  @AfterTest
  public void afterTest() 
  {
	  System.out.println("close db");
  }

  @AfterSuite
  public void afterSuite() 
  {  
//	  driver.close();
  }

}
