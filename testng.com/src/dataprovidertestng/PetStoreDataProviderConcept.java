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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class PetStoreDataProviderConcept {
	
	 WebDriver driver;
	
	 @BeforeSuite
	  public void openBrowser() {
		 System.setProperty("webdriver.chrome.driver", "C:/Users/minak/Documents/Minakshi/webDriver/98_chromeDriver/chromedriver.exe");
		 driver = new ChromeDriver();
		 
		 
	  }
	 
	 @BeforeTest
	  public void getUrl() {
		 driver.get("https://petstore.octoperf.com/actions/Account.action?newAccountForm=");
		 
	  }
	 
	 @BeforeClass
	  public void maximize() {
		 driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		 
	  }
	 
	 @BeforeMethod
	  public void getCookies() {
		 Set<Cookie> cookies = driver.manage().getCookies();
		 System.out.println(cookies.size());
	  }

	 
  @Test(dataProvider = "getData")
  public void registartion(String id,String pass,String rpass,String fname,String lname,String email,String phone,String add1,String add2,String city,String state,String zip,String country) {
	  driver.findElement(By.name("username")).sendKeys(id);
	  driver.findElement(By.name("password")).sendKeys(pass);
	  
	  driver.findElement(By.name("repeatedPassword")).sendKeys(rpass);
	  driver.findElement(By.name("account.firstName")).sendKeys(fname);
	  driver.findElement(By.name("account.lastName")).sendKeys(lname);
	  driver.findElement(By.name("account.email")).sendKeys(email);
	  driver.findElement(By.name("account.phone")).sendKeys(phone);
	  driver.findElement(By.name("account.address1")).sendKeys(add1);
	  driver.findElement(By.name("account.address2")).sendKeys(add2);
	  driver.findElement(By.name("account.city")).sendKeys(city);
	  driver.findElement(By.name("account.state")).sendKeys(state);
	  driver.findElement(By.name("account.zip")).sendKeys(zip);
	  driver.findElement(By.name("account.country")).sendKeys(country);
	  
	WebElement wb =   driver.findElement(By.name("account.languagePreference"));
	  Select sel = new Select(wb);
	  sel.selectByValue("english");
	  
	WebElement category = driver.findElement(By.name("account.favouriteCategoryId")) ;
	  Select sel1 = new Select(category);
	  sel1.selectByValue("DOGS");
	  
	  driver.findElement(By.name("account.listOption")).click();
	  driver.findElement(By.name("account.bannerOption")).click();
	  driver.findElement(By.name("newAccount")).click();
	  
  }
 
   @AfterMethod
  public void screenShot() throws IOException {
	   File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;
		File src1 = new File("C:\\Users\\minak\\Documents\\Minakshi\\petstore");
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
  public Object[][] getData() 
  {
    return new Object[][]
    		{
    	
      new Object[] { "CMD", "CMD123456","CMD123456","Jinu","Minu","JinuMinu@yahoo.com","8604023600","8191 apt","Main st","Frisco","Texas","75040","USA" },
     
        
    
    		};
  }
 


 
}
